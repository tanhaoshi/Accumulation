package com.example.accumulation.ui.check;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.accumulation.R;
import com.example.accumulation.mvp.base.UserBaseFragment;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.OnClick;

public class CheckCodeFragment extends UserBaseFragment {

    @BindView(R.id.toolbar_back)  ImageView toolbarBack;

    public static CheckCodeFragment newInstance(String param1, String param2) {
        CheckCodeFragment fragment = new CheckCodeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_check_code;
    }

    @Override
    protected void onInitView() {
        toolbarBack.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.toolbar_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.toolbar_back:
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).popBackStack();
                break;
        }
    }
}
