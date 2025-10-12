package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\nJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/l;", "V", "Lkotlin/reflect/k;", "Lkotlin/Function0;", "", "getDelegate", "Lkotlin/reflect/l$a;", "getGetter", "()Lkotlin/reflect/l$a;", "getter", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public interface l<V> extends k<V>, p0.a<V> {

    /* compiled from: KProperty.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/reflect/l$a;", "V", "Lkotlin/reflect/k$a;", "Lkotlin/Function0;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public interface a<V> extends k.a<V>, p0.a<V> {
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate();

    @NotNull
    a<V> getGetter();
}
