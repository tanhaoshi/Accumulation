package com.example.accumulation.mvp.base;

/**
 * create by tanhs on 2020/5/23 14:15
 */
public interface UserBaseView {

    void showProgress(boolean isTrue);

    void hideProgress();

    void showError(String msg);

    void loadData(boolean pullToRefresh);
}
