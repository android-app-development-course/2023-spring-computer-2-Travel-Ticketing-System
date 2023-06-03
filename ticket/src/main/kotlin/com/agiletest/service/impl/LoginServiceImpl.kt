package com.agiletest.service.impl

import com.agiletest.Result.Result
import com.agiletest.dao.PersonDao
import com.agiletest.dao.UserDao
import com.agiletest.pojo.User
import com.agiletest.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LoginServiceImpl : LoginService {

    @Autowired
    private lateinit var userDao: UserDao

    @Autowired
    private lateinit var personDao: PersonDao

    override fun loginIn(userData: User): Result {
        val result = Result()
        val user = userDao.getUserByUsername(userData.username!!)

        if (user == null) {
            result.data = null
            result.msg = "username is not exist"
            result.stateCode = 404
            return result
        }
        if (user.password != userData.password) {
            result.msg = "password is wrong"
            result.stateCode = 404
            return result
        }
        result.stateCode = 200
        result.msg = " login in success"
        result.data = user
        return result
    }

    @Transactional
    override fun updateUser(userData: User, newPassword: String): Result {
        val result = Result()
        val user = userDao.getUserByUsername(userData.username!!)
        if (user != null) {
            val oldPassword = user.password
            if (userData.password == oldPassword) {
                userData.password = newPassword
                if (userDao.updateUserRegisterInfo(userData) == 1) {
                    result.msg = "密码修改成功"
                    result.stateCode = 200
                    result.data = true
                } else {
                    result.data = false
                    result.stateCode = 400
                    result.msg = "密码修改失败，请重新操作"
                }
            } else {
                result.data = false
                result.stateCode = 200
                result.msg = "修改密码失败，旧密码错误"
            }
        } else {
            result.data = false
            result.stateCode = 400
            result.msg = "密码修改失败，不存在该用户"
        }
        return result
    }

    @Transactional
    override fun registUser(userData: User): Result {
        val result = Result()
        if (userDao.insertUserRegisterInfo(userData) == 1) {
            result.msg = "regist success"
            result.stateCode = 200
            result.data = userData.username
        } else {
            result.data = false
            result.msg = "regist fail, username is exist"
            result.stateCode = 200
        }
        return result
    }
}