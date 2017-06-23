package com.smarthome.component.service;

import com.smarthome.common.msgenum.Msg;
import com.smarthome.component.service.api.UserService;
import com.smarthome.mybatis.dto.ServiceResult;
import com.smarthome.mybatis.dto.UserDTO;
import com.smarthome.mybatis.po.User;
import com.smarthome.mybatis.qo.UserQo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/23/2017 3:28 PM.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void check() throws Exception {
        ServiceResult<Msg> result = userService.check("3612397311@qq.com");
        System.out.println(result.getData());
    }

    @Test
    public void login() throws Exception {
        ServiceResult<Msg> result = userService.login(new UserQo("361239731@qq.com", "361239731"));
        System.out.println(result);
    }

    @Test
    public void signup() throws Exception {
        User user = new User();
        user.setUserType("居住者");
        user.setUserPwd("361239731");
        user.setUserTel("18829348259");
        user.setUserEmail("279671732@qq.com");
        user.setUserIDCard("477777199409057511");
        ServiceResult<Msg> result = userService.signup(user);
        System.out.println(result);
    }

    @Test
    public void get() throws Exception {
        ServiceResult<UserDTO> serviceResult = userService.get(new UserQo("361239731@qq.com", null));
        System.out.println(serviceResult.getData());
    }
}