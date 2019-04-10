package com.offcn.mapper;

import com.offcn.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户mapper接口
 */
@Mapper
public interface UserMapper {


    /**
     * 根据id查询用户详情
     *
     * @param id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);


    /**
     * 注册用户
     * @param user
     */
    @Insert("insert into user (id,username,encrptPassword,name,telephone,address,createTime,status) values(#{id},#{username},#{encrptPassword},#{name},#{telephone},#{address},#{createTime},1)")
    Integer registerUser(User user);

    /**
     * 登录验证
     * @param username
     * @param encrptPassword
     * @return
     */
    @Select("select * from user where username=#{username} and encrptPassword=#{encrptPassword} and status=1")
    User login(String username, String encrptPassword);

    @Select("select * from user where username=#{username} and status=1")
    User getUserByUsername(String username);
}

