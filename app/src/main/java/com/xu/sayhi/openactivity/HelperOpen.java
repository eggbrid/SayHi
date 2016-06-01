package com.xu.sayhi.openactivity;

import android.content.Intent;

import com.xu.sayhi.activity.help.HelpActivity;
import com.xu.sayhi.bean.tobean.BaseToBean;

/**
 * Created by wangxu on 2016/6/1.
 */
public class HelperOpen extends BaseOpen {
    public static String Key = "HelpToBean";
    public static String Action = "HelperOpen";

    @Override
    protected Class setActivity() {
        return HelpActivity.class;
    }

    @Override
    protected int setFlag() {
        return Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP;
    }

    @Override
    public String setKey() {
        return Key;
    }

    @Override
    public String getAction() {
        return Action;
    }

    @Override
    protected BaseToBean setBean(String json) {
        return null;
    }
}
