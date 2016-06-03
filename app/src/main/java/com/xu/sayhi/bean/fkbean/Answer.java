package com.xu.sayhi.bean.fkbean;

import com.xu.sayhi.bean.BaseBean;

/**
 * Created by wangxu on 2016/6/3.
 */
public class Answer extends BaseBean {
    private String type;//T
    private String text;//谦虚是立足之本。我很谦虚，但是我认为你说的特别尤其相当对

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
