package s0;

import kotlin.Metadata;
import kotlin.collections.h0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Progressions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B!\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u0015"}, d2 = {"Ls0/g;", "", "", "Lkotlin/collections/h0;", "c", "e", "J", "a", "()J", "first", "f", "b", "last", "g", "getStep", "step", "start", "endInclusive", "<init>", "(JJJ)V", "h", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public class g implements Iterable<Long>, q0.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long first;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long last;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long step;

    public g(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = j2;
        this.last = l0.c.d(j2, j3, j4);
        this.step = j4;
    }

    /* renamed from: a, reason: from getter */
    public final long getFirst() {
        return this.first;
    }

    /* renamed from: b, reason: from getter */
    public final long getLast() {
        return this.last;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h0 iterator() {
        return new h(this.first, this.last, this.step);
    }
}
