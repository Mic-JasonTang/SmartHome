package com.smarthome.component.service;

import com.smarthome.common.msgenum.Msg;
import com.smarthome.common.util.MD5Util;
import com.smarthome.component.service.api.UserService;
import com.smarthome.mybatis.dto.ResponseMsg;
import com.smarthome.mybatis.dto.ServiceResult;
import com.smarthome.mybatis.dto.UserDTO;
import com.smarthome.mybatis.mapper.UserMapper;
import com.smarthome.mybatis.po.User;
import com.smarthome.mybatis.qo.UserQo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/22/2017 5:09 PM.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ServiceResult<ResponseMsg> signup(User user) {
        ServiceResult<ResponseMsg> serviceResult = new ServiceResult<>();
        String newPwd = MD5Util.getPwd(user.getUserPwd());
        user.setUserPwd(newPwd);
        try {
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            serviceResult.setMsg("注册失败,数据重复");
            log.info("注册失败：" + user + "," + e.getMessage());
            return serviceResult;
        }
        serviceResult.setSuccess(true);
        serviceResult.setData(new ResponseMsg(Msg.OK));
        return serviceResult;
    }

    /**
     * 登录
     * @param userQo
     * @return
     */
    @Override
    public ServiceResult<ResponseMsg> login(UserQo userQo) {
        ServiceResult<ResponseMsg> serviceResult = new ServiceResult<>();
        String username = userQo.getUsername();
        String password = MD5Util.getPwd(userQo.getPassword());
        User user;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 邮箱登录
        if (username.matches(".*@.*\\.\\w*")) {
            user = userMapper.selectByTelOrEmailAndPwd(null, username, password);
        } else {
            user = userMapper.selectByTelOrEmailAndPwd(username, null, password);
        }
        if (user != null) {
            HttpSession session = request.getSession();
//            log.info("登录时ID:" + session.getId());
            session.setAttribute(session.getId(), new UserDTO(user));
            if (userQo.getRememberMe() != null && userQo.getRememberMe()) {
                log.info("用户选择记住密码,有效期为7天");
                session.setMaxInactiveInterval(3600 * 12 * 7);
            }
            serviceResult.setSuccess(true);
            serviceResult.setData(new ResponseMsg(Msg.OK));
        } else {
            serviceResult.setMsg("账号或密码错误");
        }
        return serviceResult;
    }

    /**
     * 用户注销
     * @return
     */
    @Override
    public ServiceResult<ResponseMsg> logout() {
        ServiceResult<ResponseMsg> serviceResult = new ServiceResult<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(session.getId());
        serviceResult.setSuccess(true);
        serviceResult.setData(new ResponseMsg(Msg.OK));
        return serviceResult;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public ServiceResult<ResponseMsg> update(User user) {
        ServiceResult<ResponseMsg> serviceResult = new ServiceResult<>();
        if (user.getUserId() == null) {
            serviceResult.setMsg("用户编号不能为空");
            return serviceResult;
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        userMapper.updateByPrimaryKeySelective(user);
        User session_user = userMapper.selectByPrimaryKey(user.getUserId());
        session.setAttribute(session.getId(), new UserDTO(session_user));
        serviceResult.setSuccess(true);
        serviceResult.setData(new ResponseMsg(Msg.OK));
        return serviceResult;
    }

    /**
     * 根据邮箱或者手机号获取用户信息
     * @param userQo
     * @return
     */
    @Override
    public ServiceResult<UserDTO> get(UserQo userQo) {
        ServiceResult<UserDTO> serviceResult = new ServiceResult<>();
        String username = userQo.getUsername();
        User user;
        // 邮箱
        if (username.matches(".*@.*\\.\\w*")) {
            String email = username;
            user = userMapper.selectByTelOrEmail(null ,email);
        } else {
            String tel = username;
            user = userMapper.selectByTelOrEmail(tel, null);
        }
        if (user == null) {
            serviceResult.setMsg("该用户不存在");
            return serviceResult;
        }
        serviceResult.setSuccess(true);
        serviceResult.setData(new UserDTO(user));
        return serviceResult;
    }

    /**
     * 校验电话和邮箱
     * @param tel_email
     * @return
     */
    @Override
    public ServiceResult<ResponseMsg> check(String tel_email) {
        ServiceResult<ResponseMsg> serviceResult = new ServiceResult<>();
        if (StringUtils.isBlank(tel_email)) {
            serviceResult.setMsg("参数错误");
            return serviceResult;
        }
        User user;
        if (tel_email.matches(".*@.*\\.\\w*")) {
            user = userMapper.selectByTelOrEmail(null, tel_email);
            if (user == null) {
                serviceResult.setSuccess(true);
                serviceResult.setData(new ResponseMsg(Msg.OK));
            } else {
                serviceResult.setMsg("此邮箱:" + tel_email + ",已被注册");
            }
        } else {
            user = userMapper.selectByTelOrEmail(tel_email, null);
            if (user == null) {
                serviceResult.setSuccess(true);
                serviceResult.setData(new ResponseMsg(Msg.OK));
            } else {
                serviceResult.setMsg("此号码:" + tel_email + ",已被注册");
            }
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<UserDTO> getLoginedUser() {
        ServiceResult<UserDTO> serviceResult = new ServiceResult<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
//        log.info(session.getId());
        UserDTO userDTO = (UserDTO) session.getAttribute(session.getId());
        if (userDTO == null) {
            serviceResult.setMsg("用户未登录");
            return serviceResult;
        }
        serviceResult.setSuccess(true);
        serviceResult.setData(userDTO);
        return serviceResult;
    }
}
