package com.xu.sayhi.bean.tobean;

import java.io.Serializable;

/**
 * Created by wangxu on 2016/6/1.
 */
public class BaseToBean implements Serializable {
    private String title;
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
