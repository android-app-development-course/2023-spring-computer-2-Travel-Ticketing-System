package com.agiletest.service.impl

import kotlin.collections.MutableList
import com.agiletest.Result.Result
import com.agiletest.dao.OrderDao
import com.agiletest.dao.TripsDao
import com.agiletest.pojo.Order
import com.agiletest.pojo.OrderReturn
import com.agiletest.pojo.Person
import com.agiletest.pojo.Trips
import com.agiletest.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService {

    @Autowired
    private lateinit var orderDao: OrderDao

    @Autowired
    private lateinit var tripsDao: TripsDao

    override fun getOrder(username: String): Result {
        val result = Result()
        var person = Person()
        val orderReturnList = mutableListOf<OrderReturn>()
        var trips = Trips()

        // 获取订单列表
        val orderdata = orderDao.getOrder(username)

        if (orderdata != null) {
            for (i in orderdata) {
                val orderReturn = OrderReturn()
                person = orderDao.getPersoninf(i.personId)
                trips = tripsDao.gettrips(i.carInfoId)
                orderReturn.trueName = person.trueName
                orderReturn.idCardNum = person.idCardNum
                orderReturn.phoneNum = person.phoneNum
                orderReturn.carNum = trips.carNum
                orderReturn.destinationLocation = trips.destinationLocation
                orderReturn.orginLocation = trips.orginLocation
                orderReturn.ticketPrice = trips.ticketPrice
                orderReturn.ticketNum = trips.ticketNum
                orderReturn.startTime = trips.startTime
                orderReturn.reachTime = trips.reachTime
                if (i.status == 1) {
                    orderReturn.status = "已支付"
                } else {
                    orderReturn.status = "已退票"
                }

                orderReturnList.add(orderReturn)
            }
            result.stateCode = 200
            result.msg = "Query succeed"
            result.data = orderReturnList
        } else {
            result.stateCode = 404
            result.data = false
            result.msg = "Query failed, no order"
        }
        return result
    }

    override fun changeOrder(orderId: Int, tripsId: Int): Result {
        val result = Result()
        val order = orderDao.getAimOrder(orderId)
        val trips = tripsDao.gettrips(tripsId)
        if (trips.ticketNum > 0) {
            tripsDao.changeOldtrips(order.carInfoId)
            tripsDao.changeNewtrips(tripsId)
            orderDao.changeOrder(orderId, tripsId)
            result.stateCode = 200
            result.msg = "change order succeed"
        } else {
            result.stateCode = 404
            result.msg = "change order failed"
        }
        return result
    }
}