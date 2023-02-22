package org.noear.heihei.dao;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

import org.noear.heihei.R;
import org.noear.heihei.controller.MainActivity;

/**
 * Created by yuety on 2017/8/3.
 */

public class LocalBroadcast {
    public static void notificaction(Context cxt, String content) {
        Intent appIntent = new Intent(cxt, MainActivity.class);

        if (!TextUtils.isEmpty(content)) {
            appIntent.putExtra("content", content);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(cxt)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(cxt.getApplicationInfo().loadLabel(cxt.getPackageManager()).toString())
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(cxt.getResources(), R.mipmap.ic_launcher_round))
                .setContentText(content);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(cxt, 0, appIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) cxt.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify((int) (1000000 * Math.random()), mBuilder.build());
    }
}
