package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author:guoyaqi
 * @Date: 2024/11/4 23:50
 */
@Mapper
public interface UserMapper {


    @Select("select * from user where openid=#{openid}")
    User getByOpenId(String openid);

    //@Insert("Insert into user (id, openid, name, phone, sex, id_number, avatar, create_time) values (#{id},#{openid},#{name},#{phone},#{sex},#{idNumber},#{avatar},#{createTime})")
    void insert(User user);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long userId);

    /**
     * 用户统计
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
