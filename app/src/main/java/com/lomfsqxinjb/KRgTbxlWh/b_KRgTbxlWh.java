package com.lomfsqxinjb.KRgTbxlWh;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PCJDkVISZlhELOrlicationInfo.java */
/* loaded from: classes.dex */
class b_KRgTbxlWh {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f3194a;

    /* renamed from: b, reason: collision with root package name */
    static Activity f3195b;

    /* renamed from: c, reason: collision with root package name */
    static Context f3196c;

    public static void a(Activity activity) {
        f3195b = activity;
        f3196c = activity.getApplicationContext();
        f3194a = f3195b.getPreferences(0);
    }
}
