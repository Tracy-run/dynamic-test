package com.dynamic.demo.service;

import com.dynamic.demo.mapper.UserMapper;
import com.dynamic.demo.vo.User;
import com.dynamic.util.db.DataSourceEnum;
import com.dynamic.util.inter.CurDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/20 18:01
 */
@Service
public class UserService1 {


    @Resource
    private UserMapper userMapper;


    /**
     * 方法指明 second
     */
    @CurDataSource(DataSourceEnum.first)
    public String save1(User user){
        try {
            User key = userMapper.selectUserByKey(user);
            if (Objects.isNull(key)) {
                userMapper.insertSelective(user);
                return "新增成功";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "新增异常";
    }
    /**
     * 方法指明 second
     */
    @CurDataSource(DataSourceEnum.first)
    public User getUser1(User user){
        try {
            User key = userMapper.selectUserByKey(user);
            return key;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 方法未指明
     */
    public void save2(User user){
        userMapper.insertSelective(user);
    }

    /**
     * 方法未指明
     */
    public User getUser(User user){
        User user1 = userMapper.selectUserByKey(user);
        return user1;
    }
}
