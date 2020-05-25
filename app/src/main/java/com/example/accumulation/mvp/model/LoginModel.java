package com.example.accumulation.mvp.model;


import com.example.accumulation.been.SmsCodeRequest;
import com.example.accumulation.http.RetrofitManager;
import com.example.accumulation.http.config.Constans;
import com.example.accumulation.mvp.contract.LoginContract;
import com.example.accumulation.transformer.SchedulerTransformer;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public class LoginModel implements LoginContract.Model {

    @Override
    public Observable<ResponseBody> requestSmsCode(SmsCodeRequest body) {
        return RetrofitManager.getInstance()
                .getUserService()
                .postCode(Constans.SMS_REQUEST_URL,body)
                .doOnNext(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                    }
                })
                .compose(new SchedulerTransformer<>());
    }


}
