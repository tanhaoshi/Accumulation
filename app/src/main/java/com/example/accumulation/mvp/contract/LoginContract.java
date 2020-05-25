package com.example.accumulation.mvp.contract;


import com.example.accumulation.been.SmsCodeRequest;
import com.example.accumulation.mvp.base.UserBaseModel;
import com.example.accumulation.mvp.base.UserBasePresenter;
import com.example.accumulation.mvp.base.UserBaseView;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public interface LoginContract {

    interface View extends UserBaseView {

        void responseResult(String result);

    }

    interface Model extends UserBaseModel {

        Observable<ResponseBody> requestSmsCode(SmsCodeRequest body);
    }

    interface Presenter extends UserBasePresenter {

        void requestSmsCode(String phone);

    }
}
