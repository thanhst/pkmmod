package s0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.h0;

/* compiled from: ProgressionIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007¨\u0006\u0015"}, d2 = {"Ls0/h;", "Lkotlin/collections/h0;", "", "hasNext", "", "nextLong", "e", "J", "getStep", "()J", "step", "f", "finalElement", "g", "Z", "h", "next", "first", "last", "<init>", "(JJJ)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class h_s0 extends h0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long step;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long finalElement;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasNext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long next;

    public h_s0(long j2, long j3, long j4) {
        this.step = j4;
        this.finalElement = j3;
        boolean z2 = true;
        if (j4 <= 0 ? j2 < j3 : j2 > j3) {
            z2 = false;
        }
        this.hasNext = z2;
        this.next = z2 ? j2 : j3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.h0
    public long nextLong() {
        long j2 = this.next;
        if (j2 != this.finalElement) {
            this.next = this.step + j2;
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return j2;
    }
}
