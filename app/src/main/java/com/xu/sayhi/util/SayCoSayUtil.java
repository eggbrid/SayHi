package com.xu.sayhi.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.text.ParseException;

/**
 * Created by wangxu on 2016/6/1.
 */
public class SayCoSayUtil {
    public static SayCoSayUtil sayCoSayUtil;
    public Context context;

    public SayCoSayUtil(Context context) {
        this.context = context;
    }

    public synchronized static SayCoSayUtil getInstence(Context context) {
        if (sayCoSayUtil == null) {
            sayCoSayUtil = new SayCoSayUtil(context);
        }
        return sayCoSayUtil;
    }

    private void doTime(String s, int i, long time) {
        Intent intent = new Intent();
        intent.putExtra("msg", s);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.ELAPSED_REALTIME, time, pi);
    }
}
