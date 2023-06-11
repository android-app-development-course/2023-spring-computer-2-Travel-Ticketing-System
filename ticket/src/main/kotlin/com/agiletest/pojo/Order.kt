package com.agiletest.pojo;

/**
 *查询订单信息
 * @version 0.1
 */
class Order(
    var id: Int = 0,
    var carInfoId: Int = 0,
    var personId: Int = 0,
    var changeTimes: Int = 0,
    var status: Int = 0,
    var stautsMsg: String? = null
) {
    override fun toString(): String {
        return "Order{" +
                "id=" + id +
                ", carInfoId=" + carInfoId +
                ", personId=" + personId +
                ", changeTimes=" + changeTimes +
                ", status=" + status +
                '}'
    }
}