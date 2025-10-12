package kotlin.reflect;

import kotlin.Metadata;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/h;", "V", "Lkotlin/reflect/l;", "", "Lkotlin/reflect/h$a;", "getSetter", "()Lkotlin/reflect/h$a;", "setter", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public interface h<V> extends l<V>, k {

    /* compiled from: KProperty.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/h$a;", "V", "Lkotlin/reflect/g;", "Lkotlin/Function1;", "Lkotlin/t;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public interface a<V> extends g<V>, p0.l<V, t> {
    }

    @NotNull
    a<V> getSetter();
}
