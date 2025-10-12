package com.ykiocnwpdseglq.lbmntzwepqakgu.utils;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ClsTool {
    public static void callMethod(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, clsArr).invoke(cls.newInstance(), objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void callStaticMethod(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, clsArr).invoke(cls, objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Class<?> getClz(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object getClzObject(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
