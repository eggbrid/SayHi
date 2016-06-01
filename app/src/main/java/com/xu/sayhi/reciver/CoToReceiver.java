package com.xu.sayhi.reciver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.xu.sayhi.R;

/**
 * Created by wangxu on 2016/5/18.
 */
public class CoToReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//        showNotification(context,msg);
    }

//    protected void showNotification(Context context,String s) {
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        // Notification myNotify = new Notification(R.drawable.message,
//        // "自定义通知：您有新短信息了，请注意查收！", System.currentTimeMillis());
//        Notification myNotify = new Notification();
//        myNotify.icon = R.mipmap.ic_launcher;
//        myNotify.tickerText = "您有新短消息，请注意查收！";
//        myNotify.when = System.currentTimeMillis();
//        myNotify.flags = Notification.FLAG_AUTO_CANCEL;// 不能够自动清除
//        RemoteViews rv = new RemoteViews(context.getPackageName(),
//                R.layout.my_notification);
//        rv.setTextViewText(R.id.text_content, s);
//        myNotify.contentView = rv;
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        PendingIntent contentIntent = PendingIntent.getActivity(context, 1,
//                intent, 0);
//        myNotify.contentIntent = contentIntent;
//        manager.notify(1, myNotify);
//    }
}