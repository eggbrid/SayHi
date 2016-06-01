package com.xu.sayhi.bean.bombean;

import cn.bmob.v3.BmobObject;

/**
 * Created by wangxu on 2016/6/1.
 */
public class Function extends BmobObject {
    public Function() {
        this.setTableName("Function");
    }
    private String key;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
