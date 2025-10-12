package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes.dex */
public class w {
    public kotlin.reflect.f a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.c b(Class cls) {
        return new m(cls);
    }

    public kotlin.reflect.e c(Class cls, String str) {
        return new u(cls, str);
    }

    public kotlin.reflect.h d(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.i e(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.j f(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public kotlin.reflect.l g(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.m h(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.n i(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @SinceKotlin(version = "1.3")
    public String j(p pVar) {
        String string = pVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    @SinceKotlin(version = "1.1")
    public String k(Lambda lambda) {
        return j(lambda);
    }
}
