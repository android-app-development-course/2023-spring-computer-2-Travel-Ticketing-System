package com.agiletest.service

import com.agiletest.Result.Result
import com.agiletest.pojo.User

/**
 * login and usercheck functions
 * @version 0.1
 */
interface LoginService {
    /**
     * 登录处理
     * @return
     */
    fun loginIn(userData: User): Result

    /**
     * 更新用户信息
     * @param userData
     * @param passwordNew
     * @return
     */
    fun updateUser(userData: User, passwordNew: String): Result

    /**
     * regist user info
     * @param userData
     * @return
     */
    fun registUser(userData: User): Result
}