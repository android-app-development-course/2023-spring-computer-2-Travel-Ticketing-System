package com.agiletest.pojo

/**
 * 用于查询车票信息
 * @version 1.0
 */
class Trips(
    var id: Int = 0,
    var orginLocation: String? = null,
    var destinationLocation: String? = null,
    var startTime: String? = null,
    var reachTime: String? = null,
    var carNum: String? = null,
    var ticketPrice: Int = 0,
    var ticketNum: Int = 0
) {
    override fun toString(): String {
        return "Trips{" +
                "id=" + id +
                ", orginLocation='" + orginLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", startTime='" + startTime + '\'' +
                ", reachTime='" + reachTime + '\'' +
                ", carNum='" + carNum + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketNum=" + ticketNum +
                '}'
    }
}