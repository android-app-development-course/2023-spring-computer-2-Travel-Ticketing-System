package com.agiletest.service

import com.agiletest.Result.Result

/**
 * 订单处理
 * @version 0.1
 */
interface OrderService {
    /**
     * @param username
     * @return
     */
    fun getOrder(username: String): Result

    /**
     *订单改签
     */
    fun changeOrder(orderId: Int, tripsId: Int): Result
}