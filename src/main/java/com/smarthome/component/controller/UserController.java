package com.smarthome.component.controller;

import com.smarthome.component.service.api.UserService;
import com.smarthome.mybatis.dto.ResponseMsg;
import com.smarthome.mybatis.dto.ServiceResult;
import com.smarthome.mybatis.dto.UserDTO;
import com.smarthome.mybatis.po.User;
import com.smarthome.mybatis.qo.UserQo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/23/2017 5:16 PM.
 */
@RequestMapping("/user")
@RestController
@Api("用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "signup", method = RequestMethod.PUT)
    public ServiceResult<ResponseMsg> signup(User user) {

        return userService.signup(user);
    }

    /**
     * 登录
     * @param userQo
     * @return
     */
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "邮箱或者电话号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "rememberMe", value = "7天免登陆", required = true, dataType = "boolean")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServiceResult<ResponseMsg> login(UserQo userQo) {

        return userService.login(userQo);
    }

    /**
     * 注销
     * @return
     */
    @ApiOperation("用户注销")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ServiceResult<ResponseMsg> logout() {

        return userService.logout();
    }

    /**
     * 修改信息
     * @param user
     * @return
     */
    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号,不允许修改", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userType", value = "用户类型,不允许修改"),
            @ApiImplicitParam(name = "userName", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userPwd", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userSex", value = "性别", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userBirth", value = "出生年月", required = true, dataType = "Date", example = "1994-09-05"),
            @ApiImplicitParam(name = "userEmail", value = "用户邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userTel", value = "电话", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userIDCard", value = "身份证", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userdatetime", value = "创建时间,不允许修改")
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ServiceResult<ResponseMsg> update(User user) {

        return userService.update(user);
    }

    /**
     * 获取用户信息, 根据邮箱或者电话
     * @param username: 邮箱或者电话
     * @return
     */
    @ApiOperation("获取用户信息")
    @ApiImplicitParam(paramType = "path", name = "username", value = "邮箱或者电话")
    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
    public ServiceResult<UserDTO> get(@PathVariable("username") String username) {

        return userService.get(new UserQo(username, null));
    }

    /**
     * 校验电话号码或者邮箱
     * @param tel_email
     * @return
     */
    @ApiOperation("校验电话号码或者邮箱是否存在")
    @ApiImplicitParam(paramType = "path", name = "tel_email", value = "邮箱或者手机号", dataType = "String")
    // 使用SpringEl表达式来解决PathVariable参数中有.的问题
    @RequestMapping(value = "/check/{tel_email:.+}", method = RequestMethod.GET)
    public ServiceResult<ResponseMsg> check(@PathVariable("tel_email") String tel_email) {

        return userService.check(tel_email);
    }

    /**
     * 获取已登录用户
     * @return
     */
    @ApiOperation("获取已登录用户信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ServiceResult<UserDTO> getLoginedUser() {

        return userService.getLoginedUser();
    }
}
