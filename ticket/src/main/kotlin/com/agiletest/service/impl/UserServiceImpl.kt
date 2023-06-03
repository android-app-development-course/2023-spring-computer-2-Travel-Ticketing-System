package com.agiletest.service.impl

import com.agiletest.Result.Result
import com.agiletest.dao.PersonDao
import com.agiletest.dao.UserDao
import com.agiletest.pojo.Person
import com.agiletest.pojo.User
import com.agiletest.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl : UserService {
    @Autowired
    private lateinit var userDao: UserDao

    @Autowired
    private lateinit var personDao: PersonDao

    override fun updateUserInfo(username: String, person: Person): Result {
        val user = userDao.getUserByUsername(username)
        val result = Result()
        result.msg = "update fail, please update again"
        result.stateCode = 404
        result.data = false
        if (user != null) {
            if (user.personId > 0) {
                person.id = user.personId
                val i = personDao.updateUserInfo(person)
                if (i == 1) {
                    result.msg = "update success"
                    result.stateCode = 200
                    result.data = true
                }
            } else {
                val i = personDao.insertUserInfo(person)
                if (i == 1) {
                    user.personId = person.id
                    val j = userDao.updateUserRegisterInfo(user)
                    if (j == 1) {
                        result.msg = "update success"
                        result.stateCode = 200
                        result.data = true
                    }
                }
            }
        }
        return result
    }

    override fun getPersonInfo(username: String): Result {
        val result = Result()
        val person = personDao.getPersonInfo1(username)
        if (person == null) {
            result.stateCode = 400
            result.msg = "未填写个人信息，请完善个人信息"
            result.data = null
        } else {
            result.stateCode = 200
            result.msg = "查询成功，已填写个人信息"
            result.data = person
        }
        return result
    }
}