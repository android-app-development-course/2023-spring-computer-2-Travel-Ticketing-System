package com.agiletest.pojo;

class OrderReturn(
    var orginLocation: String? = null,
    var destinationLocation: String? = null,
    var startTime: String? = null,
    var reachTime: String? = null,
    var carNum: String? = null,
    var ticketPrice: Int = 0,
    var ticketNum: Int = 0,
    var trueName: String? = null,
    var idCardNum: String? = null,
    var phoneNum: String? = null,
    var status: String? = null
) {
    override fun toString(): String {
        return "OrderReturn{" +
                "orginLocation='" + orginLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", startTime='" + startTime + '\'' +
                ", reachTime='" + reachTime + '\'' +
                ", carNum='" + carNum + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketNum=" + ticketNum +
                ", trueName='" + trueName + '\'' +
                ", idCardNum='" + idCardNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}'
    }
}

