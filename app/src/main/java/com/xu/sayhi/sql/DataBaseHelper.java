package com.xu.sayhi.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.xu.sayhi.bean.dbbean.SayCoCharacterBean;

import java.sql.SQLException;

/**
 * Created by wx on 2015/12/3.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String DATABASE_NAME = "sayco.db";
    private static final int DATABASE_VERSON = 1;

    public DataBaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    private static DataBaseHelper dataBaseHelper;

    public static synchronized DataBaseHelper getInstance(Context context) {
        if (dataBaseHelper == null) {
            dataBaseHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSON);
        }
        return dataBaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, SayCoCharacterBean.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    public Dao<SayCoCharacterBean, Integer> getSayCoCharacterDao() throws SQLException {
        return getDao(SayCoCharacterBean.class);
    }
    public Dao<SayCoCharacterBean, Integer> getFuncationDao() throws SQLException {
        return getDao(SayCoCharacterBean.class);
    }

}
