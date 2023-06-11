package com.agiletest.dao;

import com.agiletest.pojo.Order;
import com.agiletest.pojo.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
interface OrderDao {
    /**
     *插入订单信息
     * @param order
     */
    @Insert("INSERT INTO `order` (car_info_id, person_id, change_times, status) VALUES (#{carInfoId}, #{personId}, #{changeTimes}, #{status})\n" +
            "    ")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    fun buyTicket(order: Order)

    /**
     * 退票，把statu改为2
     * @param orderId
     * @return
     */
    @Update("update `order` set status = 1 where id = #{orderId}")
    fun updateOrder(orderId: Int): Int

    @Select("select * from `order`,user where user.person_id = `order`.person_id and user.username = #{userName}")
    fun getOrder(userName: String): List<Order>

    @Update("update `order` set status = 2 where person_id=#{personId} and car_info_id = (select id from trips where car_num = #{carNum}" +
            " and start_time = #{startTime} and reach_time = #{reachTime})")
    fun updateOrder1(@Param("personId") personId: Int, @Param("carNum") carNum: String,
                     @Param("startTime") startTime: String, @Param("reachTime") reachTime: String): Int

//    @Select("select * from `order` where person_id = #{personId}")
//    public List<Order> getOrder(Order order);

    /**
     * 查询目标订单
     * @param orderId
     * @return
     */
    @Select("select * from `order` where id = #{orderId}")
    fun getAimOrder(orderId: Int): Order

    /**
     * 查询订单所有人信息
     */
    @Select("select * from `person` where `id` = #{personId}")
    fun getPersoninf(personId: Int): Person

    /**
     * 改签订单信息变更
     * @param orderId
     * @param tripsId
     * @return
     */
    @Update("update `order` set car_info_id = #{tripsId},change_times = change_times +1,status = 1 where id = #{orderId}")
    fun changeOrder(@Param("orderId")orderId: Int, @Param("tripsId")tripsId: Int): Int

}
