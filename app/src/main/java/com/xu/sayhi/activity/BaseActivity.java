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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.TextUnderstander;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;
import com.xu.sayhi.R;
import com.xu.sayhi.bean.response.FkResponse;
import com.xu.sayhi.bean.tobean.BaseToBean;
import com.xu.sayhi.cosay.BaseSayBean;
import com.xu.sayhi.enums.CoSayType;
import com.xu.sayhi.interfaces.OnCosayGet;
import com.xu.sayhi.interfaces.OnFkTextBack;

/**
 * Created by wangxu on 2016/5/31.
 */
public abstract class BaseActivity extends FragmentActivity implements TextUnderstanderListener {
    private Button back;
    private TextView title;
    private BaseToBean baseToBean;
    private Gson gson = new Gson();
    //创建文本语义理解对象
    private TextUnderstander mTextUnderstander;
    private OnFkTextBack onFkTextBack;

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


    /**
     * 像sayCo发消息
     *
     * @param text
     */
    public void sayToSayCo(String text, OnFkTextBack onFkTextBack) {
        this.onFkTextBack = onFkTextBack;
        if (mTextUnderstander == null) {
            mTextUnderstander = TextUnderstander.createTextUnderstander(this, null);

        }
        mTextUnderstander.understandText(text, this);

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

    @Override
    public void onResult(UnderstanderResult understanderResult) {
        FkResponse fkResponse = gson.fromJson(understanderResult.getResultString(), FkResponse.class);
        if (onFkTextBack!=null){
            onFkTextBack.onFkTextBack(fkResponse);
        }
    }

    @Override
    public void onError(SpeechError speechError) {

    }

    public void hideInput() {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        if (params.softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE) {
            // 隐藏软键盘
            getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN;
        }
    }
}
