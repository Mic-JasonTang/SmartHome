package com.smarthome.component.service.api;

import com.smarthome.mybatis.dto.ResponseMsg;
import com.smarthome.mybatis.dto.ServiceResult;
import com.smarthome.mybatis.dto.UserDTO;
import com.smarthome.mybatis.po.User;
import com.smarthome.mybatis.qo.UserQo;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/22/2017 5:09 PM.
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @return
     */
    public ServiceResult<ResponseMsg> signup(User user);

    /**
     * 登录
     * @param userQo
     * @return
     */
    public ServiceResult<ResponseMsg> login(UserQo userQo);

    /**
     * 注销
     * @return
     */
    public ServiceResult<ResponseMsg> logout();

    /**
     * 修改信息
     * @param user
     * @return
     */
    public ServiceResult<ResponseMsg> update(User user);

    /**
     * 获取用户信息
     * @param userQo
     * @return
     */
    public ServiceResult<UserDTO> get(UserQo userQo);

    /**
     * 校验电话号码或者邮箱
     * @param tel_email
     * @return
     */
    public ServiceResult<ResponseMsg> check(String tel_email);

    /**
     * 获取已登录用户
     * @return
     */
    public ServiceResult<UserDTO> getLoginedUser();
}
