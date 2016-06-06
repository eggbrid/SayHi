package com.xu.sayhi.bean.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by wangxu on 2016/6/4.
 */

@DatabaseTable(tableName = "tb_function")
public class FunctionBean {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField()
    private String objectId;
    @DatabaseField()
    private String name;
    @DatabaseField()
    private String key;
    @DatabaseField()
    private boolean isFind;
    @DatabaseField()
    private int isDeprive;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isFind() {
        return isFind;
    }

    public void setFind(boolean find) {
        isFind = find;
    }

    public int getIsDeprive() {
        return isDeprive;
    }

    public void setIsDeprive(int isDeprive) {
        this.isDeprive = isDeprive;
    }
}
