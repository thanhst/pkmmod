package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.h;

/* loaded from: classes.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.h {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return v.d(this);
    }

    public abstract /* synthetic */ Object get();

    @Override // kotlin.reflect.l
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.h) getReflected()).getDelegate();
    }

    @Override // p0.a
    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(Object obj);

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public a_p0 getGetter() {
        return ((kotlin.reflect.h) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public h.a getSetter() {
        return ((kotlin.reflect.h) getReflected()).getSetter();
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
