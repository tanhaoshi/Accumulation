package com.example.accumulation.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * create by tanhs on 2020/5/22 15:00
 */
public abstract class UserBaseFragment extends Fragment {

    protected Unbinder unbinder;
    protected View     rootView;
    protected boolean  isFirstLoader = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
            return rootView;
        }
        if (getLayoutId() != 0) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }


    protected abstract int getLayoutId();

    protected abstract void onInitView();

    protected abstract void initData();

    @Override
    public void onResume() {
        super.onResume();
        if(isFirstLoader){
            onInitView();
            initData();
            isFirstLoader = false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirstLoader = true;
        if (unbinder != null) {
            unbinder.unbind();
        }
        ViewGroup viewGroup = (ViewGroup) rootView.getParent();
        if (viewGroup != null && rootView != null) {
            viewGroup.removeView(rootView);
            rootView = null;
        }
    }
}

