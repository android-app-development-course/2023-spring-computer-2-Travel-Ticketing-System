package com.agiletest.pojo;

/**
 * person 类
 * 用户对person信息持久化
 * @version 0.1
 */
class Person(
    var id: Int = 0,
    var trueName: String? = null,
    var idCardNum: String? = null,
    var phoneNum: String? = null,
    var age: Int = 0
) {
    constructor(trueName: String, idCardNum: String, phoneNum: String, age: Int) : this(0, trueName, idCardNum, phoneNum, age)

    override fun toString(): String {
        return "Person{" +
                "id=" + id +
                ", trueName='" + trueName + '\'' +
                ", idCardNum='" + idCardNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", age=" + age +
                '}'
    }
}