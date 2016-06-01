package com.xu.sayhi.util;

import android.content.Context;

/**
 * Created by wangxu on 2016/5/31.
 */
public class SharePUtil extends BaseUtil {

    private static final String SP_NAME = "sayCo";


    private static SharePUtil instance = new SharePUtil();

    public SharePUtil() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SharePUtil();
        }
    }

    public static SharePUtil getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

//    private android.content.SharedPreferences getSp() {
//        return AppContext.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
//    }
}
