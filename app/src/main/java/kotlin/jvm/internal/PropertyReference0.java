package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* loaded from: classes.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.l {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return v.g(this);
    }

    public abstract /* synthetic */ Object get();

    @Override // kotlin.reflect.l
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.l) getReflected()).getDelegate();
    }

    @Override // p0.a
    public Object invoke() {
        return get();
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public a_p0 getGetter() {
        return ((kotlin.reflect.l) getReflected()).getGetter();
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
