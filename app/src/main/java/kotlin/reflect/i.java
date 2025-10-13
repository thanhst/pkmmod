package kotlin.reflect;

import kotlin.Metadata;
import kotlin.t;
import p0.p_p0;

import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\tR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/i;", "T", "V", "Lkotlin/reflect/m;", "", "Lkotlin/reflect/i$a;", "getSetter", "()Lkotlin/reflect/i$a;", "setter", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public interface i<T, V> extends m<T, V>, k {

    /* compiled from: KProperty.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/i$a;", "T", "V", "Lkotlin/reflect/g;", "Lkotlin/Function2;", "Lkotlin/t;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public interface a<T, V> extends g<V>, p_p0<T, V, t> {
    }

    @NotNull
    a<T, V> getSetter();
}
