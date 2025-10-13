package kotlin.jvm.internal;

import java.util.List;

import p0.a_p0;
import p0.b_p0;
import p0.c_p0;
import p0.d_p0;
import p0.e_p0;
import p0.f_p0;
import p0.g_p0;
import p0.h_p0;
import p0.i_p0;
import p0.j_p0;
import p0.k_p0;
import p0.l_p0;
import p0.m_p0;
import p0.n_p0;
import p0.o_p0;
import p0.p_p0;
import p0.q_p0;
import p0.r_p0;
import p0.s_p0;
import p0.t_p0;
import p0.u_p0;
import p0.v_p0;
import p0.w_p0;
import q0.a_q0;
import q0.b_q0;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes.dex */
public class y {
    public static List a(Object obj) {
        if ((obj instanceof a_q0) && !(obj instanceof b_q0)) {
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
        if (obj instanceof a_p0) {
            return 0;
        }
        if (obj instanceof l_p0) {
            return 1;
        }
        if (obj instanceof p_p0) {
            return 2;
        }
        if (obj instanceof q_p0) {
            return 3;
        }
        if (obj instanceof r_p0) {
            return 4;
        }
        if (obj instanceof s_p0) {
            return 5;
        }
        if (obj instanceof t_p0) {
            return 6;
        }
        if (obj instanceof u_p0) {
            return 7;
        }
        if (obj instanceof v_p0) {
            return 8;
        }
        if (obj instanceof w_p0) {
            return 9;
        }
        if (obj instanceof b_p0) {
            return 10;
        }
        if (obj instanceof c_p0) {
            return 11;
        }
        if (obj instanceof d_p0) {
            return 12;
        }
        if (obj instanceof e_p0) {
            return 13;
        }
        if (obj instanceof f_p0) {
            return 14;
        }
        if (obj instanceof g_p0) {
            return 15;
        }
        if (obj instanceof h_p0) {
            return 16;
        }
        if (obj instanceof i_p0) {
            return 17;
        }
        if (obj instanceof j_p0) {
            return 18;
        }
        if (obj instanceof k_p0) {
            return 19;
        }
        if (obj instanceof m_p0) {
            return 20;
        }
        if (obj instanceof n_p0) {
            return 21;
        }
        return obj instanceof o_p0 ? 22 : -1;
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
