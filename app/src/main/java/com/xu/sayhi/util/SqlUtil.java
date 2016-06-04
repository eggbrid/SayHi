package com.xu.sayhi.util;

import android.content.Context;

import com.j256.ormlite.stmt.PreparedQuery;
import com.xu.sayhi.bean.dbbean.SayCoCharacterBean;
import com.xu.sayhi.sql.DataBaseHelper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangxu on 2016/6/4.
 */
public class SqlUtil extends BaseInstenceUtil {
    public DataBaseHelper dataBaseHelper;

    public SqlUtil(Context context) {
        super();
        dataBaseHelper = DataBaseHelper.getInstance(context);
    }

    /**
     * 获取sayco性格
     * @param phoneId
     * @return
     */
    public SayCoCharacterBean getSayCoCharater(String phoneId) {
        SayCoCharacterBean sayCoCharater = null;
        List<SayCoCharacterBean> sayCoCharaters = null;
        try {
            PreparedQuery<SayCoCharacterBean> query =
                    dataBaseHelper.getSayCoCharacterDao().queryBuilder().orderBy("id", false).where().eq("phoneId", phoneId).prepare();
            sayCoCharaters = dataBaseHelper.getSayCoCharacterDao().query(query);
            if (sayCoCharaters.size()<=0){
                return null;
            }else {
                sayCoCharater=sayCoCharaters.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sayCoCharater;
    }
}
