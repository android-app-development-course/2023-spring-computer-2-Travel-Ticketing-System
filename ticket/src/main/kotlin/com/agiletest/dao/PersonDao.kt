package com.agiletest.dao

import com.agiletest.pojo.Person
import com.agiletest.pojo.Trips
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface PersonDao {

    /**
     * 查询全部车票信息
     * @param trips
     * @return
     */
    @Select("select * from trips where orgin_location=#{orginLocation} and destination_location=#{destinationLocation} and start_time like CONCAT('%',#{startTime},'%')")
    fun getAlltrips(trips: Trips): List<Trips>

    /**
     * 修改用户个人信息
     * @param person
     * @return
     */
    fun updateUserInfo(person: Person): Int

    /**
     * 通过id和车号查询车次信息
     * @param trips
     * @return
     */
    @Select("select * from trips where id = #{id} and car_num = #{carNum}")
    fun getTripsInfoByCarInfoIdAndId(trips: Trips): Trips

    /**
     * 添加用户个人信息
     * @param person
     * @return
     */
    fun insertUserInfo(person: Person): Int

    /**
     * 通过id获取个人信息
     * @param Id
     * @return
     */
    @Select("select * from person where id = #{Id}")
    fun getPersonInfo(@Param("Id") Id: Int): Person

    /**
     * 通过username查询个人信息
     * @param username
     * @return
     */
    fun getPersonInfo1(username: String): Person
}