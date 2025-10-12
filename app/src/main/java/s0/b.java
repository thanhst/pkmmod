package s0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.s;

/* compiled from: ProgressionIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\b¨\u0006\u0016"}, d2 = {"Ls0/b;", "Lkotlin/collections/r;", "", "hasNext", "", "a", "", "e", "I", "getStep", "()I", "step", "f", "finalElement", "g", "Z", "h", "next", "first", "last", "<init>", "(CCI)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class b extends r {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int step;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int finalElement;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasNext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int next;

    public b(char c2, char c3, int i2) {
        this.step = i2;
        this.finalElement = c3;
        boolean z2 = true;
        if (i2 <= 0 ? s.f(c2, c3) < 0 : s.f(c2, c3) > 0) {
            z2 = false;
        }
        this.hasNext = z2;
        this.next = z2 ? c2 : c3;
    }

    @Override // kotlin.collections.r
    public char a() {
        int i2 = this.next;
        if (i2 != this.finalElement) {
            this.next = this.step + i2;
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return (char) i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }
}
