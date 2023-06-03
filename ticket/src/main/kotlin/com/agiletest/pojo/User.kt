package com.agiletest.pojo

/**
 * 用户注册信息pojo
 * 用于存储用户账号信息
 * @version 0.1
 */
class User(
    var id: Int = 0,
    var personId: Int = 0,
    var username: String? = null,
    var password: String? = null
) {
    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", personId=" + personId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}