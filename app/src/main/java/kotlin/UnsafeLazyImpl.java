package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import p0.a_p0;

/* compiled from: Lazy.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b8\b@\bX\u0088\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/d;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "isInitialized", "", "toString", "Lkotlin/Function0;", "initializer", "Lp0/a;", "_value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "value", "<init>", "(Lp0/a;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class UnsafeLazyImpl<T> implements d<T>, Serializable {

    @Nullable
    private Object _value;

    @Nullable
    private a_p0<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull a_p0<? extends T> initializer) {
        kotlin.jvm.internal.s.e(initializer, "initializer");
        this.initializer = initializer;
        this._value = q.f3473a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.d
    public T getValue() {
        if (this._value == q.f3473a) {
            a_p0<? extends T> aP0Var = this.initializer;
            kotlin.jvm.internal.s.b(aP0Var);
            this._value = aP0Var.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != q.f3473a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
