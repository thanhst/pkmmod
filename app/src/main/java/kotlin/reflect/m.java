package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import p0.l_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\rJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0004\b\u0007\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/m;", "T", "V", "Lkotlin/reflect/k;", "Lkotlin/Function1;", "receiver", "", "getDelegate", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/m$a;", "getGetter", "()Lkotlin/reflect/m$a;", "getter", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public interface m<T, V> extends k<V>, l_p0<T, V> {

    /* compiled from: KProperty.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/m$a;", "T", "V", "Lkotlin/reflect/k$a;", "Lkotlin/Function1;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public interface a<T, V> extends k.a<V>, l_p0<T, V> {
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate(T receiver);

    @NotNull
    a<T, V> getGetter();
}
