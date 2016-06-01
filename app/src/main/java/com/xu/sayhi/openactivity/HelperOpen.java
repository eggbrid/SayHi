package com.xu.sayhi.openactivity;

import com.xu.sayhi.bean.tobean.BaseToBean;

/**
 * Created by wangxu on 2016/6/1.
 */
public class HelperOpen extends BaseOpen {
    @Override
    protected Class setActivity() {
        return null;
    }

    @Override
    protected int setFlag() {
        return 0;
    }

    @Override
    protected String setKey() {
        return null;
    }

    @Override
    protected BaseToBean setBean(String json) {
        return null;
    }
}
