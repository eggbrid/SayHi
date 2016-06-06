package com.xu.sayhi.bean.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by wangxu on 2016/6/4.
 */
@DatabaseTable(tableName = "tb_article")
public class SayCoCharacterBean {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField()
    private String phoneId;
    @DatabaseField()
    private int happy;
    @DatabaseField()
    private int sad;
    @DatabaseField()
    private int angry;
    @DatabaseField()
    private int boring;
    private boolean isNew=false;

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getSad() {
        return sad;
    }

    public void setSad(int sad) {
        this.sad = sad;
    }

    public int getAngry() {
        return angry;
    }

    public void setAngry(int angry) {
        this.angry = angry;
    }

    public int getBoring() {
        return boring;
    }

    public void setBoring(int boring) {
        this.boring = boring;
    }
}
