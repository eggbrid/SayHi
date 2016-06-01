package com.xu.sayhi.openactivity;

import android.content.Context;
import android.content.Intent;

import com.xu.sayhi.bean.tobean.BaseToBean;

import java.io.Serializable;

/**
 * Created by wangxu on 2016/6/1.
 * 虚拟打开activity
 */
public abstract class BaseOpen {
    protected abstract Class setActivity();

    protected abstract int setFlag();

    public abstract String setKey();
    public abstract String getAction();

    protected abstract BaseToBean setBean(String json);

    public void toActivity(Context context, String json) {
        Intent i = new Intent(context, setActivity());
        i.setFlags(setFlag());
        i.putExtra(setKey(), setBean(json));
        context.startActivity(i);
    }
    public void sendMessage(Context context, String beanJson) {
        Intent intent = new Intent();
        intent.setAction(getAction());
        intent.putExtra(setKey(), setBean(beanJson));
        context.sendBroadcast(intent);
    }
}
