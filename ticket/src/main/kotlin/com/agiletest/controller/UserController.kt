package com.agiletest.controller

import com.agiletest.Result.Result
import com.agiletest.pojo.Person
import com.agiletest.service.UserService
import com.alibaba.fastjson.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * login function
 * @version 0.1
 */
@RestController
@CrossOrigin
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping("/updateUserInfo")
    fun updateUserInfo(@RequestBody jsonObject: JSONObject): Result {
        val username = jsonObject.getString("username")
        val trueName = jsonObject.getString("trueName")
        val idCardNum = jsonObject.getString("idCardNum")
        val phoneNum = jsonObject.getString("phoneNum")
        val age = jsonObject.getInteger("age")
        val person = Person(trueName, idCardNum, phoneNum, age)
        return userService.updateUserInfo(username, person)
    }

    @PostMapping("/getpersoninfo")
    fun getPersonInfo(@RequestBody jsonObject: JSONObject): Result {
        return userService.getPersonInfo(jsonObject.getString("username"))
    }
}