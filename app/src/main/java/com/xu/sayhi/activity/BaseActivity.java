package com.xu.sayhi.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xu.sayhi.R;
import com.xu.sayhi.bean.tobean.BaseToBean;
import com.xu.sayhi.cosay.BaseSayBean;
import com.xu.sayhi.enums.CoSayType;
import com.xu.sayhi.interfaces.OnCosayGet;

/**
 * Created by wangxu on 2016/5/31.
 */
public abstract class BaseActivity extends FragmentActivity {
    private Button back;
    private TextView title;
    private BaseToBean baseToBean;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String kay = getOpenBean();
        if (!TextUtils.isEmpty(kay)) {
            baseToBean = (BaseToBean) getIntent().getSerializableExtra(getOpenBean());
        }
        readyInit();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
        initData();
    }

    public BaseToBean getBaseToBean() {
        return baseToBean;
    }

    public void setBaseToBean(BaseToBean baseToBean) {
        this.baseToBean = baseToBean;
    }

    public abstract String getOpenBean();

    public abstract void readyInit();

    public abstract int getLayoutID();

    public abstract void initView();

    public abstract void initData();


    public void initTitle(String titles) {
        back = (Button) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        title.setText(titles);
        back.setVisibility(View.GONE);
    }

    public void initTitleBack(String titles) {
        back = (Button) findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        title.setText(titles);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public BroadcastReceiver pushListener;

    public <L extends BaseSayBean> void setCosayListener(final OnCosayGet<L> listeners, final Class<L> aClas) {
        IntentFilter dynamic_filter = new IntentFilter();
        dynamic_filter.addAction("com.push.sendMessage");
        pushListener = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                L l = gson.fromJson(intent.getExtras().getString("json"), aClas);
                listeners.onCosayGet(l);
            }
        };
        registerReceiver(pushListener, dynamic_filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pushListener != null) {
            unregisterReceiver(pushListener);
        }
    }
}
