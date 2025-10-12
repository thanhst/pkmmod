package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.k;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class MutablePropertyReference extends PropertyReference {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    @NotNull
    public abstract /* synthetic */ k.a getGetter();

    @NotNull
    public abstract /* synthetic */ kotlin.reflect.g getSetter();

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
