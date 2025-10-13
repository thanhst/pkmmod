package com.lomfsqxinjb.KRgTbxlWh;

import com.helpergames.Logger;

import java.io.File;

/* compiled from: PCJDkVISZlhELOr.java */
/* loaded from: classes.dex */
class c_KRgTbxlWh {

    /* renamed from: a, reason: collision with root package name */
    public String f3197a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f3198b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f3199c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f3200d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f3201e = 0;

    /* renamed from: f, reason: collision with root package name */
    public float f3202f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public int f3203g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f3204h = 0;

    c_KRgTbxlWh() {
        Logger.d("Class c running");
    }

    public boolean a() throws Throwable {
        String str = this.f3199c;
        if (str == null || str.length() == 0) {
            return true;
        }
        File file = new File(this.f3198b);
        return file.exists() && file.canRead() && PCJDkVISZlhELOr.A1(file).compareTo(this.f3199c) == 0;
    }
}
