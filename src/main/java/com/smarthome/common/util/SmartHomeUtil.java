package com.smarthome.common.util;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 7/1/2017 8:47 PM.
 */
public class SmartHomeUtil {

    private static String DOOR_ORDER = "3";

    /**
     * 判断是否为门结点，是的话返回true
     * @param order
     * @return
     */
    public static Boolean isDoor(String order) {
        if (order.endsWith(DOOR_ORDER)) {
            return true;
        }
        return false;
    }
}
