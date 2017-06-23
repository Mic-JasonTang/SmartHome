package com.smarthome.common.msgenum;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/23/2017 4:12 PM.
 */
public enum Msg {

    OK("ok");

    private String msg;

    Msg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
