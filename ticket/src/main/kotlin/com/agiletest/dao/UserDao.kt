package com.agiletest.dao;

import com.agiletest.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
interface UserDao {

    /**
     * 通过username查询User信息
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    fun getUserByUsername(username: String): User

    /**
     * 注册用户信息
     * @param user
     * @return
     */
    @Insert("insert into user (username, password, person_id) values(#{username}, #{password}, #{personId})")
    fun insertUserRegisterInfo(user: User): Int

    /**
     * 更新用户账户信息
     * @param user
     * @return
     */
    fun updateUserRegisterInfo(user: User): Int
}