package com.smarthome.component.handler;

import com.smarthome.mybatis.dto.ServiceResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * iclass
 * <p>
 * Created by JasonTang on 3/26/2017 10:52 PM.
 * 自定义异常处理，捕捉RuntimeException
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServiceResult handle(Exception e) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setMsg(e.getMessage());
        return serviceResult;
    }
}
