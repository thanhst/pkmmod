package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadSafeHeap.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b&\u0010'J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082\u0010¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082\u0010¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR$\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00068F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\u000f\u0010\nR\u0011\u0010%\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lkotlinx/coroutines/internal/h0;", "Lkotlinx/coroutines/internal/i0;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "i", "Lkotlin/t;", "l", "(I)V", "k", "", "f", "()[Lkotlinx/coroutines/internal/i0;", "j", "m", "(II)V", "e", "()Lkotlinx/coroutines/internal/i0;", "node", "", "g", "(Lkotlinx/coroutines/internal/i0;)Z", "b", "index", "h", "(I)Lkotlinx/coroutines/internal/i0;", "a", "(Lkotlinx/coroutines/internal/i0;)V", "[Lkotlinx/coroutines/internal/i0;", "value", "c", "()I", "size", "d", "()Z", "isEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class h0<T extends i0 & Comparable<? super T>> {

    @NotNull
    private volatile /* synthetic */ int _size = 0;

    @Nullable
    private T[] a;

    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new i0[4];
            this.a = tArr2;
            return tArr2;
        }
        if (get_size() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, get_size() * 2);
        kotlin.jvm.internal.s.d(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((i0[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void j(int i2) {
        this._size = i2;
    }

    private final void k(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= get_size()) {
                return;
            }
            T[] tArr = this.a;
            kotlin.jvm.internal.s.b(tArr);
            int i4 = i3 + 1;
            if (i4 < get_size()) {
                T t2 = tArr[i4];
                kotlin.jvm.internal.s.b(t2);
                T t3 = tArr[i3];
                kotlin.jvm.internal.s.b(t3);
                if (((Comparable) t2).compareTo(t3) < 0) {
                    i3 = i4;
                }
            }
            T t4 = tArr[i2];
            kotlin.jvm.internal.s.b(t4);
            T t5 = tArr[i3];
            kotlin.jvm.internal.s.b(t5);
            if (((Comparable) t4).compareTo(t5) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void l(int i2) {
        while (i2 > 0) {
            T[] tArr = this.a;
            kotlin.jvm.internal.s.b(tArr);
            int i3 = (i2 - 1) / 2;
            T t2 = tArr[i3];
            kotlin.jvm.internal.s.b(t2);
            T t3 = tArr[i2];
            kotlin.jvm.internal.s.b(t3);
            if (((Comparable) t2).compareTo(t3) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void m(int i2, int j2) {
        T[] tArr = this.a;
        kotlin.jvm.internal.s.b(tArr);
        T t2 = tArr[j2];
        kotlin.jvm.internal.s.b(t2);
        T t3 = tArr[i2];
        kotlin.jvm.internal.s.b(t3);
        tArr[i2] = t2;
        tArr[j2] = t3;
        t2.setIndex(i2);
        t3.setIndex(j2);
    }

    @PublishedApi
    public final void a(@NotNull T node) {
        node.b(this);
        i0[] i0VarArrF = f();
        int i2 = get_size();
        j(i2 + 1);
        i0VarArrF[i2] = node;
        node.setIndex(i2);
        l(i2);
    }

    @PublishedApi
    @Nullable
    public final T b() {
        T[] tArr = this.a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: c, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean d() {
        return get_size() == 0;
    }

    @Nullable
    public final T e() {
        T t2;
        synchronized (this) {
            t2 = (T) b();
        }
        return t2;
    }

    public final boolean g(@NotNull T node) {
        boolean z2;
        synchronized (this) {
            if (node.c() == null) {
                z2 = false;
            } else {
                h(node.getIndex());
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T h(int r6) {
        /*
            r5 = this;
            T extends kotlinx.coroutines.internal.i0 & java.lang.Comparable<? super T>[] r0 = r5.a
            kotlin.jvm.internal.s.b(r0)
            int r1 = r5.get_size()
            r2 = -1
            int r1 = r1 + r2
            r5.j(r1)
            int r1 = r5.get_size()
            if (r6 >= r1) goto L3d
            int r1 = r5.get_size()
            r5.m(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            kotlin.jvm.internal.s.b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            kotlin.jvm.internal.s.b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.m(r6, r1)
            r5.l(r1)
            goto L3d
        L3a:
            r5.k(r6)
        L3d:
            int r6 = r5.get_size()
            r6 = r0[r6]
            kotlin.jvm.internal.s.b(r6)
            r1 = 0
            r6.b(r1)
            r6.setIndex(r2)
            int r2 = r5.get_size()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.h0.h(int):kotlinx.coroutines.internal.i0");
    }

    @Nullable
    public final T i() {
        T t2;
        synchronized (this) {
            t2 = get_size() > 0 ? (T) h(0) : null;
        }
        return t2;
    }
}
