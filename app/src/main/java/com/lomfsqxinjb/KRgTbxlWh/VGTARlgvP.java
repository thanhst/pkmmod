package com.lomfsqxinjb.KRgTbxlWh;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes.dex */
public class VGTARlgvP extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private NotificationManager f3192a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f3192a = (NotificationManager) context.getSystemService("notification");
        int intExtra = intent.getIntExtra("id", 0);
        String stringExtra = intent.getStringExtra(ShareConstants.WEB_DIALOG_PARAM_TITLE);
        String stringExtra2 = intent.getStringExtra("content");
        int i2 = 1;
        switch (intExtra) {
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            default:
                i2 = 0;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = 2;
                break;
        }
        try {
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) PCJDkVISZlhELOr.class), 0);
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle(stringExtra);
            builder.setContentText(stringExtra2);
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentIntent(activity);
            builder.setDefaults(3);
            ((NotificationManager) context.getSystemService("notification")).notify(i2, builder.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
