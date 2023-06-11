package com.agiletest.service

import com.agiletest.Result.Result
import com.agiletest.pojo.Person

/**
 * @version 0.1
 */
interface UserService {
    /**
     * 第一次填写个人信息
     * @param username
     * @param person
     * @return
     */
//    fun insertUserInfo(username: String, person: Person): Result

    /**
     * 修改个人信息
     * @param username
     * @param person
     * @return
     */
    fun updateUserInfo(username: String, person: Person): Result

    /**
     * 查询个人信息
     * @param username
     * @return
     */
    fun getPersonInfo(username: String): Result
}