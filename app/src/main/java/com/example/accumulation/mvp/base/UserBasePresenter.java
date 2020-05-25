package com.example.accumulation.mvp.base;

import io.reactivex.disposables.Disposable;

/**
 * create by tanhs on 2020/5/23 14:14
 */
public interface UserBasePresenter {

    void detach();

    void addDisposable(Disposable subscription);

    void unDisposable();
}
