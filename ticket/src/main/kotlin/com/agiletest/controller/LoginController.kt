package com.agiletest.controller;

import com.agiletest.Result.Result;
import com.agiletest.pojo.User;
import com.agiletest.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
class LoginController {
    @Autowired
    private lateinit var loginService: LoginService

    /**
     * login
     * @param jsonObject
     * @return
     */
    @PostMapping("/login")
    @GetMapping("/login")
    @ResponseBody
    fun login(@RequestBody jsonObject: JSONObject): Result {
        val user = User()
        val password = jsonObject.getString("password")
        val username = jsonObject.getString("username")
        user.password = password
        user.username = username
        val result = loginService.loginIn(user)
        return result
    }

    /**
     * update user's password
     * @param
     * @return
     */
    @PostMapping("/updatePassword")
    fun updateUser(@RequestBody jsonObject: JSONObject): Result {
        val userData = User()
        userData.username = jsonObject.getString("username")
        userData.password = jsonObject.getString("passwordOld")
        val newPassword = jsonObject.getString("passwordNew")
        val result = loginService.updateUser(userData, newPassword)
        return result
    }

    /**
     * user regist
     * @param userData
     * @return
     */
    @PostMapping("/regist")
    fun registUser(@RequestBody userData: User): Result {
        return loginService.registUser(userData)
    }
}