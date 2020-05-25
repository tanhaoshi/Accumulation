package com.example.accumulation.http.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <API><br>
 * Author:      mxdl<br>
 * Date:        2019/6/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class API {

    //开发
    private static final String URL_HTTP_WEB_DEV = "http://192.168.4.71:6001/api-dev/";
    //内部测试
    private static final String URL_HTTP_WEB_TEST_IN = "http://192.168.4.71:6001/api-test/";
    //外部测试
    private static final String URL_HTTP_WEB_TEST_OUT = "https://otapi.kefangapp.com/webapi/";
    //生产
    private static final String URL_HTTP_WEB_PUBLISH = "https://gw.kefangapp.com:18110/api-prod/";

    private static Map<Integer, String> sysTypeList = new HashMap<Integer, String>();

    static {
        sysTypeList.put(0, URL_HTTP_WEB_DEV);
        sysTypeList.put(1, URL_HTTP_WEB_TEST_IN);
        sysTypeList.put(2, URL_HTTP_WEB_TEST_OUT);
        sysTypeList.put(3, URL_HTTP_WEB_PUBLISH);
    }

    public static String getHttpUrl(int index) {
        return sysTypeList.get(index);
    }

}
