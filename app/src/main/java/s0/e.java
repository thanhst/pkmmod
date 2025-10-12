package s0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.g0;

/* compiled from: ProgressionIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007¨\u0006\u0015"}, d2 = {"Ls0/e;", "Lkotlin/collections/g0;", "", "hasNext", "", "nextInt", "e", "I", "getStep", "()I", "step", "f", "finalElement", "g", "Z", "h", "next", "first", "last", "<init>", "(III)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class e extends g0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int step;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int finalElement;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasNext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int next;

    public e(int i2, int i3, int i4) {
        this.step = i4;
        this.finalElement = i3;
        boolean z2 = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z2 = false;
        }
        this.hasNext = z2;
        this.next = z2 ? i2 : i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.g0
    public int nextInt() {
        int i2 = this.next;
        if (i2 != this.finalElement) {
            this.next = this.step + i2;
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return i2;
    }
}
