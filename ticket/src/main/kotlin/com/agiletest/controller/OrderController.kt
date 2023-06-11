package com.agiletest.controller;


import com.agiletest.Result.Result;
import com.agiletest.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
class OrderController {

    @Autowired
    private lateinit var orderService: OrderService

    @PostMapping("/getorder")
    fun getOrder(@RequestBody jsonObject: JSONObject): Result {
        val username = jsonObject.getString("username")
        val result = orderService.getOrder(username)
        return result
    }

    /**
     * change order
     * @return
     */
    @PostMapping("/changeorder")
    fun changeOrder(@RequestBody jsonObject: JSONObject): Result {
        val orderId = jsonObject.getInteger("orderId")
        val tripsId = jsonObject.getInteger("tripsId")
        val result = orderService.changeOrder(orderId, tripsId)
        return result
    }
}