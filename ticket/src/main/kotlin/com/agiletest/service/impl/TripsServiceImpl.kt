package com.agiletest.service.impl

import com.agiletest.Result.Result
import com.agiletest.dao.OrderDao
import com.agiletest.dao.PersonDao
import com.agiletest.dao.TripsDao
import com.agiletest.dao.UserDao
import com.agiletest.pojo.Order
import com.agiletest.pojo.Person
import com.agiletest.pojo.Trips
import com.agiletest.pojo.User
import com.agiletest.service.TripsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.HashMap

@Service
class TripsServiceImpl : TripsService {
    @Autowired
    private lateinit var orderDao: OrderDao

    @Autowired
    private lateinit var userDao: UserDao

    @Autowired
    private lateinit var personDao: PersonDao

    @Autowired
    private lateinit var tripsDao: TripsDao

    override fun getAlltrips(trips: Trips): Result {
        val result = Result()
        val tripsdata = tripsDao.getAlltrips(trips)
        if (tripsdata != null) {
            result.msg = "Query all succeed"
            result.data = tripsdata
            result.stateCode = 200
        } else {
            result.msg = "Query failes,no tickets"
            result.stateCode = 404
        }
        return result
    }

    override fun getAimtrips(trips: Trips): Result {
        val result = Result()
        val tripsdata = tripsDao.getAimtrips(trips)
        if (tripsdata != null) {
            result.msg = "Query all succeed"
            result.data = trips
            result.stateCode = 200
        } else {
            result.msg = "Query failes,no tickets"
            result.stateCode = 404
        }
        return result
    }

    @Transactional
    override fun buyTicket(username: String, carInfoId: Int, carNum: String): Result {
        val result = Result()

        //获取用户个人信息的id
        val customer = userDao.getUserByUsername(username)
        val person = personDao.getPersonInfo(customer.personId)
        if (person == null) {
            result.stateCode = 400
            result.msg = "购票前请完善用户个人信息"
            result.data = false
            return result
        }
        val trips = Trips()
        trips.carNum = carNum
        trips.id = carInfoId
        //获取车票详细信息
        val tripsInfoData = tripsDao.getTripsInfoByCarInfoIdAndId(trips)
        //判断车票是否卖光了
        val order = Order(carInfoId, customer.personId, 0)
        order.status = 0
        if (tripsInfoData.ticketNum >= 1) {

            orderDao.buyTicket(order)
            trips.ticketNum = tripsInfoData.ticketNum - 1
            trips.carNum = null
            val i = tripsDao.updateTrips(trips)
            val detailData: MutableMap<String, Any> = HashMap()
            if (order.id > 0 && i == 1) {
                //还有车票，购买成功
                result.msg = "购票成功"
                result.stateCode = 200

                result.data = detailData
            }
            return result
        } else {
            //车票卖光了，购买失败
            result.msg = " 购买失败，车票已经卖光"
            result.stateCode = 400
            result.data = false
            return result
        }
    }

    @Transactional
    override fun ticketRetund(personId: Int, carNum: String, startTime: String, reachTime: String): Result {
        val result = Result()
        //票数+1
        val i = tripsDao.refundTrips(personId, carNum, startTime, reachTime)
        //把订单状态改为退票
        val j = orderDao.updateOrder1(personId, carNum, startTime, reachTime)
        if (i > 0 && j > 0) {
            result.data = true
            result.msg = "退票成功"
            result.stateCode = 200
        } else {
            result.data = false
            result.msg = "退票失败"
            result.stateCode = 400
        }
        return result
    }

    @Transactional
    override fun payMoney(orderId: Int): Result {
        val result = Result()
        if (orderDao.updateOrder(orderId) == 1) {
            result.stateCode = 200
            result.msg = "支付成功"
            result.data = true
        } else {
            result.data = false
            result.msg = "支付失败，请重新支付"
            result.stateCode = 400
        }
        return result
    }
}