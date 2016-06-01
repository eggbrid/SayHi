package com.xu.sayhi.enums;

/**
 * Created by wangxu on 2016/6/1.
 */
public enum CoSayType {
    ToActivityMessage(1,"activity"), TextMessage(2,"Text");
    CoSayType( int id,String name){
        this.id=id;
        this.name=name;
    }
    public int id;
    public String name;

}
