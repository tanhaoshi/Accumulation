package com.example.accumulation.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * create by tanhs on 2020/5/25 14:21
 */
public final class ImelUtils {

    public static String getIMEI(Context context) {
        try {
            //实例化TelephonyManager对象
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //获取IMEI号
            String imei = telephonyManager.getDeviceId();
            if (imei == null) {
                imei = "";
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
