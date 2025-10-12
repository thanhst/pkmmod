package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* compiled from: Reflection.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static final w f3458a;

    /* renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.c[] f3459b;

    static {
        w wVar = null;
        try {
            wVar = (w) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (wVar == null) {
            wVar = new w();
        }
        f3458a = wVar;
        f3459b = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.f a(FunctionReference functionReference) {
        return f3458a.a(functionReference);
    }

    public static kotlin.reflect.c b(Class cls) {
        return f3458a.b(cls);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.e c(Class cls) {
        return f3458a.c(cls, "");
    }

    public static kotlin.reflect.h d(MutablePropertyReference0 mutablePropertyReference0) {
        return f3458a.d(mutablePropertyReference0);
    }

    public static kotlin.reflect.i e(MutablePropertyReference1 mutablePropertyReference1) {
        return f3458a.e(mutablePropertyReference1);
    }

    public static kotlin.reflect.j f(MutablePropertyReference2 mutablePropertyReference2) {
        return f3458a.f(mutablePropertyReference2);
    }

    public static kotlin.reflect.l g(PropertyReference0 propertyReference0) {
        return f3458a.g(propertyReference0);
    }

    public static kotlin.reflect.m h(PropertyReference1 propertyReference1) {
        return f3458a.h(propertyReference1);
    }

    public static kotlin.reflect.n i(PropertyReference2 propertyReference2) {
        return f3458a.i(propertyReference2);
    }

    @SinceKotlin(version = "1.3")
    public static String j(p pVar) {
        return f3458a.j(pVar);
    }

    @SinceKotlin(version = "1.1")
    public static String k(Lambda lambda) {
        return f3458a.k(lambda);
    }
}
