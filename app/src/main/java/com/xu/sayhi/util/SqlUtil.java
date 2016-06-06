package com.xu.sayhi.util;

import android.content.Context;

import com.j256.ormlite.stmt.PreparedQuery;
import com.xu.sayhi.bean.dbbean.SayCoCharacterBean;
import com.xu.sayhi.sql.DataBaseHelper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
     *
     * @return
     */
    public SayCoCharacterBean getSayCoCharater() {
        SayCoCharacterBean sayCoCharater = null;
        List<SayCoCharacterBean> sayCoCharaters = null;
        try {
            PreparedQuery<SayCoCharacterBean> query =
                    dataBaseHelper.getSayCoCharacterDao().queryBuilder().orderBy("id", false).where().eq("phoneId", SayCoSayUtil.getInstence(context).getAndroidID()).prepare();
            sayCoCharaters = dataBaseHelper.getSayCoCharacterDao().query(query);
            if (sayCoCharaters.size() <= 0) {
                SayCoCharacterBean bean=saveSayCoCharater(null);
                bean.setNew(true);
                return bean;
            } else {
                sayCoCharater = sayCoCharaters.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sayCoCharater;
    }

    /**
     * 保存性格
     *
     * @param bean
     */
    public SayCoCharacterBean saveSayCoCharater(SayCoCharacterBean bean) {
        try {
            if (bean == null) {
                Random random = new Random();
                bean.setAngry(random.nextInt(100));
                bean.setBoring(random.nextInt(100));
                bean.setHappy(random.nextInt(100));
                bean.setSad(random.nextInt(100));
                bean.setPhoneId(SayCoSayUtil.getInstence(context).getAndroidID());
            }
            dataBaseHelper.getFuncationDao().create(bean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
