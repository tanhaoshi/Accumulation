package com.example.accumulation.http.service;


import com.example.accumulation.been.RegisterRequest;
import com.example.accumulation.been.SmsCodeRequest;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;


/**
 * Description: <UserService><br>
 *
 */
public interface UserService {

    /**
     * 请求验证码
     *
     * @param url
     * @param request
     * @return
     */
    @POST
    Observable<ResponseBody> postCode(@Url String url, @Body SmsCodeRequest request);

    /**
     * 验证码注册or登录
     *
     * @param url
     * @param request
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST
    Observable<ResponseBody> postRegister(@Url String url, @Body RegisterRequest request);
}
