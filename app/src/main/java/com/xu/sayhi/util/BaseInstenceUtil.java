package com.xu.sayhi.util;

import android.content.Context;

/**
 * Created by wangxu on 2016/6/4.
 */
public class BaseInstenceUtil {
    public BaseInstenceUtil() {

    }

    public BaseInstenceUtil(Context context) {
        this.context = context;
    }

    private static BaseInstenceUtil baseInstenceUtil;
    protected Context context;

    public synchronized static BaseInstenceUtil getInstensce() {
        if (baseInstenceUtil == null) {
            baseInstenceUtil = new BaseInstenceUtil();
        }
        return baseInstenceUtil;
    }

    public synchronized static BaseInstenceUtil getInstensce(Context context) {
        if (baseInstenceUtil == null) {
            baseInstenceUtil = new BaseInstenceUtil(context);
        }
        return baseInstenceUtil;
    }
}
