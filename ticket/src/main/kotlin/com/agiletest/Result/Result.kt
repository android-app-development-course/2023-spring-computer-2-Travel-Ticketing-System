package com.agiletest.Result

/**
 * 数据传输类
 */
class Result(
    var stateCode: Int = 0,
    var data: Any? = null,
    var msg: String? = null
) {
    constructor() : this(0)

    override fun toString(): String {
        return "Result{" +
                "stateCode=" + stateCode +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}'
    }
}