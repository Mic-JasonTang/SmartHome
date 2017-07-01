package com.smarthome.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/27/2017 9:33 PM.
 */
public class TimeUtil {

    public static String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
