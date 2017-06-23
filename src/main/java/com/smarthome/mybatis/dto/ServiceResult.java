package com.smarthome.mybatis.dto;

import java.io.Serializable;

/**
 * iclass
 * <p>
 * Created by JasonTang on 2/20/2017 11:38 PM.
 */
public class ServiceResult<T> implements Serializable {

    /**
     * 是否执行成功
     */
    private Boolean success = Boolean.FALSE;

    /**
     * 数据
     */
    private T data;

    /**
     * 详细信息，可以是详细原因
     */
    private String msg;


    public ServiceResult() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "success=" + success +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
