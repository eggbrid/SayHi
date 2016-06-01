package com.xu.sayhi;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.xu.sayhi.activity.BaseActivity;
import com.xu.sayhi.bean.bombean.Function;
import com.xu.sayhi.cosay.HomeSayBean;
import com.xu.sayhi.interfaces.OnCosayGet;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends BaseActivity implements OnCosayGet<HomeSayBean>, View.OnClickListener {
    private EditText edt_content;
    private Button send;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initTitle("?");
        edt_content = (EditText) findViewById(R.id.edt_content);
        send = (Button) findViewById(R.id.send);

    }

    @Override
    public void initData() {
        setCosayListener(this, HomeSayBean.class);

    }

    @Override
    public String getOpenBean() {
        return "null";
    }

    @Override
    public void readyInit() {

    }

    @Override
    public void onCosayGet(HomeSayBean homeSayBean) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                break;
        }
    }

    private void getFuncation(String key) {
        BmobQuery query = new BmobQuery("Function");
        query.addWhereContains("key", key);
        query.findObjects(this, new FindListener<Function>() {

            @Override
            public void onSuccess(List<Function> list) {
                for (Function functionBean : list) {
                    Log.e("wangxu", functionBean.getName());
                }
            }

            @Override
            public void onError(int i, String s) {
                Log.e("wangxu", "i=" + i + "s=" + s);

            }
        });
    }
}
