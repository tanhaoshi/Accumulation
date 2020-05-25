package com.example.accumulation.mvp.model;

import com.example.accumulation.been.RegisterRequest;
import com.example.accumulation.http.RetrofitManager;
import com.example.accumulation.http.config.Constans;
import com.example.accumulation.mvp.contract.CheckCodeContract;
import com.example.accumulation.transformer.SchedulerTransformer;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * create by tanhs on 2020/5/22
 */
public class CheckCodeModel implements CheckCodeContract.Model {

    @Override
    public Observable<ResponseBody> verifyCurrentCode(String url, RegisterRequest registerRequest) {
        return RetrofitManager.getInstance()
                .getUserService()
                .postRegister(Constans.BASE_URL,registerRequest)
                .compose(new SchedulerTransformer<>());
    }
}
