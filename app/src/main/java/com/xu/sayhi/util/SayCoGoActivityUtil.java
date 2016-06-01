package com.xu.sayhi.util;

import android.content.Context;

import com.xu.sayhi.openactivity.BaseOpen;

/**
 * Created by wangxu on 2016/6/1.
 */
public class SayCoGoActivityUtil {

    public static void goActivity(String name, Context context, String beanJson) {
        try {
            Class clazz = Class.forName("com.xu.sayhi.openactivity." + name);
            BaseOpen bta = (BaseOpen) clazz.newInstance();
            bta.toActivity(context, beanJson);
        } catch (Exception e) {

        }
    }
}
