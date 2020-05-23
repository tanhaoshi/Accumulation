package com.example.accumulation.ui.login;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.example.accumulation.R;
import com.example.accumulation.mvp.base.UserBaseFragment;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.OnClick;


public class LoginInputFragment extends UserBaseFragment {

    @BindView(R.id.toolbar_right)  TextView right_title;
    @BindView(R.id.lg_agreement_text) TextView lgAgreementText;

    public static LoginInputFragment newInstance(String param1, String param2) {
        LoginInputFragment fragment = new LoginInputFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_input;
    }

    @Override
    protected void onInitView() {
        right_title.setText(getActivity().getResources().getString(R.string.lg_use_code));
    }

    @Override
    protected void initData() {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(getResources().getString(R.string.lg_normal_agreement_head));
        ForegroundColorSpan colorSpan_one = new ForegroundColorSpan(getResources().getColor(R.color.lg_line_color));
        builder.setSpan(colorSpan_one,8,14, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan_two = new ForegroundColorSpan(getResources().getColor(R.color.lg_line_color));
        builder.setSpan(colorSpan_two,17,21,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        lgAgreementText.setText(builder);
    }

    @OnClick({R.id.toolbar_right})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.toolbar_right:
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).popBackStack();
                break;
        }
    }

}
