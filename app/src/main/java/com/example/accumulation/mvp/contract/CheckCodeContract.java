package com.example.accumulation.mvp.contract;


import com.example.accumulation.been.RegisterRequest;
import com.example.accumulation.mvp.base.UserBaseModel;
import com.example.accumulation.mvp.base.UserBasePresenter;
import com.example.accumulation.mvp.base.UserBaseView;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * create by tanhs on 2020/5/22
 */
public interface CheckCodeContract {

    interface View extends UserBaseView {

    }

    interface Model extends UserBaseModel {
       Observable<ResponseBody> verifyCurrentCode(String url, RegisterRequest registerRequest);
    }

    interface Presenter extends UserBasePresenter {

    }
}
