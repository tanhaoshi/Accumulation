package com.example.accumulation.ui.login;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.accumulation.R;
import com.example.accumulation.mvp.base.UserBaseFragment;
import com.example.accumulation.mvp.base.UserBasePresenterImpl;
import com.example.accumulation.widget.ChrysanthemumView;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends UserBaseFragment {

    @BindView(R.id.loading)
    ChrysanthemumView chrysanthemumView;
    @BindView(R.id.lg_agreement_text) TextView lgAgreementText;
    @BindView(R.id.toolbar_right) TextView toolbarRight;
    @BindView(R.id.btn_confirm)   Button btnConfirm;

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void onInitView() {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(getResources().getString(R.string.lg_normal_agreement_head));
        ForegroundColorSpan colorSpan_one = new ForegroundColorSpan(getResources().getColor(R.color.lg_line_color));
        builder.setSpan(colorSpan_one,8,14, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan_two = new ForegroundColorSpan(getResources().getColor(R.color.lg_line_color));
        builder.setSpan(colorSpan_two,17,21,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        lgAgreementText.setText(builder);

        toolbarRight.setVisibility(View.VISIBLE);
        toolbarRight.setText(getResources().getString(R.string.lg_use_password));
    }

    @Override
    public UserBasePresenterImpl initPresenter() {
        return null;
    }

    @OnClick({R.id.toolbar_right,R.id.btn_confirm})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.toolbar_right:
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.loginInputFragment);
                break;
            case R.id.btn_confirm:
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.checkCodeFragment);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(null != chrysanthemumView){
            chrysanthemumView.stopAnimation();
            chrysanthemumView.detachView();
        }
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
