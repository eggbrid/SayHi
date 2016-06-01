package com.xu.sayhi;

import android.os.Bundle;


import com.xu.sayhi.activity.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initTitle("?");
    }

    @Override
    public void initData() {

    }

    @Override
    public String getOpenBean() {
        return "null";
    }

    @Override
    public void readyInit() {

    }
}
