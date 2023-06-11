package com.agiletest.service

import com.agiletest.Result.Result
import com.agiletest.pojo.Trips

/**
 * 查询车票信息
 * @version 1.0
 */
interface TripsService {
    /**
     * 查询所有车票信息
     * @param trips
     * @return
     */
    fun getAlltrips(trips: Trips): Result

    /**
     *查询目标车票信息
     * @param trips
     * @return
     */
    fun getAimtrips(trips: Trips): Result

    /**
     * 购买车票
     * @param username
     * @param carInfoId
     * @param carNum
     * @return
     */
    fun buyTicket(username: String, carInfoId: Int, carNum: String): Result

    /**
     * 退票
     * @param personId
     * @param carNum
     * @param reachTime
     * @param startTime
     * @return
     */
    fun ticketRetund(personId: Int, carNum: String, startTime: String, reachTime: String): Result

    /**
     * 付钱
     * @param orderId
     * @return
     */
    fun payMoney(orderId: Int): Result
}