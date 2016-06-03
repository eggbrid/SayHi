package com.xu.sayhi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.UnderstanderResult;
import com.xu.sayhi.activity.BaseActivity;
import com.xu.sayhi.bean.bombean.Function;
import com.xu.sayhi.bean.fkbean.MoreResults;
import com.xu.sayhi.bean.response.FkResponse;
import com.xu.sayhi.cosay.HomeSayBean;
import com.xu.sayhi.fragment.BaseSayCoFragment;
import com.xu.sayhi.fragment.NomalSayCoFragment;
import com.xu.sayhi.fragment.TextSayCoFragment;
import com.xu.sayhi.interfaces.OnCosayGet;
import com.xu.sayhi.interfaces.OnFkTextBack;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends BaseActivity implements OnCosayGet<HomeSayBean>, View.OnClickListener, OnFkTextBack {
    private EditText edt_content;
    private Button send;
    private BaseSayCoFragment content;
    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initTitle("SayCo");
        edt_content = (EditText) findViewById(R.id.edt_content);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setCosayListener(this, HomeSayBean.class);
        setDefaultFragment(0,null);

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
                String s = edt_content.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    sayToSayCo("我啥也没说", this);
                }
                sayToSayCo(s, this);
                edt_content.setText("");
                hideInput();
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
    private void setDefaultFragment(int status,FkResponse response) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (status) {
            case 0://正常状态
                content = new NomalSayCoFragment(response);
                break;
            case 1://文字
                content = new TextSayCoFragment(response);
                break;
        }
        transaction.replace(R.id.fragment_container, content);
        transaction.commit();
    }

    @Override
    public void onFkTextBack(FkResponse response) {
        setDefaultFragment(1,response);

    }
}
