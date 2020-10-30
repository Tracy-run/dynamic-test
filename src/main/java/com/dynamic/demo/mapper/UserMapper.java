package com.dynamic.demo.mapper;

import com.dynamic.demo.vo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/20 17:58
 */
@Mapper
public interface UserMapper {

    public int insertSelective(User user);

    public User selectUserByKey(User user);
}
