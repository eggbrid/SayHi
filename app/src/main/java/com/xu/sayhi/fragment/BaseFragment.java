package com.xu.sayhi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangxu on 2016/6/3.
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        initView(view);
        initListener();
        initData();
        return view;
    }

    public abstract int getLayout();
    public abstract void initView(View view);
    public abstract void initListener();
    public abstract void initData();

}
