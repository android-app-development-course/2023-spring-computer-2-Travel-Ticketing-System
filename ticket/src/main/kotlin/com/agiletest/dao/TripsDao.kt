package com.agiletest.dao;

import com.agiletest.pojo.Trips;
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface TripsDao {

    /**
     * 查询目标车票信息
     * @param trips
     * @return
     */
    @Select("select * from trips where start_time like CONCAT('%',#{startTime},'%') and car_num = #{carNum}")
    fun getAimtrips(trips: Trips): Trips

    /**
     * 查询全部车票信息
     * @param trips
     * @return
     */
    @Select("select * from trips where orgin_location=#{orginLocation} and destination_location=#{destinationLocation} and start_time like CONCAT('%',#{startTime},'%')")
    fun getAlltrips(trips: Trips): List<Trips>

    /**
     * 通过id获取车票信息
     * @param id
     * @return
     */
    @Select("select * from trips where id = #{id}")
    fun gettrips(id: Int): Trips

    /**
     * 订单改签后改变旧车票信息
     * @param oldId
     * @return
     */
    @Update("update trips set ticket_num = ticket_num+1 where id = #{oldId}")
    fun changeOldtrips(oldId: Int): Int

    /**
     * 订单改签后改变新车票信息
     * @param newId
     * @return
     */
    @Update("update trips set ticket_num = ticket_num-1 where id = #{newId}")
    fun changeNewtrips(newId: Int): Int

    /**
     * 通过id和车号查询车次信息
     * @param trips
     * @return
     */
    @Select("select * from trips where id = #{id} and car_num = #{carNum}")
    fun getTripsInfoByCarInfoIdAndId(trips: Trips): Trips

    /**
     * 更新trips表
     * @param trips
     * @return
     */
    @Update("<script> update trips set <if test='ticketNum != 0'> ticket_num = #{ticketNum}</if>" +
            "where id = #{id} </script>")
    fun updateTrips(trips: Trips): Int

    /**
     * 车票退款
     * @param personId
     * @param carNum
     * @param startTime
     * @param reachTime
     * @return
     */
    @Update("update trips set ticket_num = ticket_num + 1" +
            " where  car_num = #{carNum}" +
            "and start_time = #{startTime} and reach_time = #{reachTime}")
    fun refundTrips(@Param("personId") personId: Int, @Param("carNum") carNum: String,
                    @Param("startTime") startTime: String, @Param("reachTime") reachTime: String): Int

    /**
     * 通过车号和出发时间查询车次信息
     * @param carNum
     * @param startTime
     * @return
     */
    @Select("select * from trips where car_num = #{carNum} and start_time = #{startTime}")
    fun getTripsInfoByCarNumAndStartTime(@Param("carNum") carNum: String, @Param("startTime") startTime: String): Trips
}