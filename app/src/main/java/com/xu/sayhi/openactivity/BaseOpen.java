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

    protected abstract String setKey();

    protected abstract BaseToBean setBean(String json);

    public void toActivity(Context context, String json) {
        Intent i = new Intent(context, setActivity());
        i.setFlags(setFlag());
        i.putExtra(setKey(),setBean(json));
//        i.putExtra(setKey(),setBean(json));
        context.startActivity(i);
    }
}
