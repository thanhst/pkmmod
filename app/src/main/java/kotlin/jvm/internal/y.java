package kotlin.jvm.internal;

import java.util.List;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes.dex */
public class y {
    public static List a(Object obj) {
        if ((obj instanceof q0.a) && !(obj instanceof q0.b)) {
            h(obj, "kotlin.collections.MutableList");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i2) {
        if (obj != null && !e(obj, i2)) {
            h(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static List c(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw g(e2);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof p) {
            return ((p) obj).getArity();
        }
        if (obj instanceof p0.a) {
            return 0;
        }
        if (obj instanceof p0.l) {
            return 1;
        }
        if (obj instanceof p0.p) {
            return 2;
        }
        if (obj instanceof p0.q) {
            return 3;
        }
        if (obj instanceof p0.r) {
            return 4;
        }
        if (obj instanceof p0.s) {
            return 5;
        }
        if (obj instanceof p0.t) {
            return 6;
        }
        if (obj instanceof p0.u) {
            return 7;
        }
        if (obj instanceof p0.v) {
            return 8;
        }
        if (obj instanceof p0.w) {
            return 9;
        }
        if (obj instanceof p0.b) {
            return 10;
        }
        if (obj instanceof p0.c) {
            return 11;
        }
        if (obj instanceof p0.d) {
            return 12;
        }
        if (obj instanceof p0.e) {
            return 13;
        }
        if (obj instanceof p0.f) {
            return 14;
        }
        if (obj instanceof p0.g) {
            return 15;
        }
        if (obj instanceof p0.h) {
            return 16;
        }
        if (obj instanceof p0.i) {
            return 17;
        }
        if (obj instanceof p0.j) {
            return 18;
        }
        if (obj instanceof p0.k) {
            return 19;
        }
        if (obj instanceof p0.m) {
            return 20;
        }
        if (obj instanceof p0.n) {
            return 21;
        }
        return obj instanceof p0.o ? 22 : -1;
    }

    public static boolean e(Object obj, int i2) {
        return (obj instanceof kotlin.c) && d(obj) == i2;
    }

    private static <T extends Throwable> T f(T t2) {
        return (T) s.l(t2, y.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        i((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
