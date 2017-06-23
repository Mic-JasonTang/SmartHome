package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/22/2017 5:29 PM.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user = userMapper.selectByPrimaryKey(100);
        System.out.println(user);
    }

    @Test
    public void selectByTelOrEmail() throws Exception {
        User user = userMapper.selectByTelOrEmail(null, "361239731@qq.com");
        System.out.println(user);
    }

    @Test
    public void selectByTelOrEmailAndPwd() throws Exception {
        User user = userMapper.selectByTelOrEmailAndPwd(null, "361239731@qq.com", "361239731");
        System.out.println(user);
    }
}