package com.example.accumulation.ui.material;

import android.os.Bundle;

import com.example.accumulation.R;
import com.example.accumulation.mvp.base.UserBaseFragment;
import com.example.accumulation.mvp.base.UserBasePresenterImpl;


public class UserMaterialFragment extends UserBaseFragment {

    public static UserMaterialFragment newInstance(String param1, String param2) {
        UserMaterialFragment fragment = new UserMaterialFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_material;
    }

    @Override
    protected void onInitView() {

    }

    @Override
    public UserBasePresenterImpl initPresenter() {
        return null;
    }

    @Override
    public void showProgress(boolean isTrue) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
