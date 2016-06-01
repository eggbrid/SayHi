package com.xu.sayhi.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xu.sayhi.R;
import com.xu.sayhi.bean.tobean.BaseToBean;

/**
 * Created by wangxu on 2016/5/31.
 */
public abstract class BaseActivity extends FragmentActivity {
    private Button back;
    private TextView title;
    private BaseToBean baseToBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String kay=getOpenBean();
        if (!TextUtils.isEmpty(kay)){
            baseToBean = (BaseToBean) getIntent().getSerializableExtra(getOpenBean());
        }
        readyInit();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
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
}
