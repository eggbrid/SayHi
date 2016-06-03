package com.xu.sayhi.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebView;

import com.xu.sayhi.R;
import com.xu.sayhi.bean.response.FkResponse;

/**
 * Created by wangxu on 2016/6/3.
 */
@SuppressLint("ValidFragment")
public class WebSayCoFragment extends BaseSayCoFragment {
    private WebView webView;

    public WebSayCoFragment(FkResponse fkResponse) {
        super(fkResponse);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_sayco_web;
    }

    @Override
    public void initView(View view) {
        webView=(WebView)view.findViewById(R.id.webview);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
