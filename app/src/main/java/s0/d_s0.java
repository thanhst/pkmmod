package s0;

import kotlin.Metadata;
import kotlin.collections.g0;
import kotlin.jvm.internal.o;
import l0.c_l0;
import q0.a_q0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Progressions.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB!\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u001d"}, d2 = {"Ls0/d;", "", "", "Lkotlin/collections/g0;", "d", "", "isEmpty", "", "other", "equals", "hashCode", "", "toString", "e", "I", "a", "()I", "first", "f", "b", "last", "g", "c", "step", "start", "endInclusive", "<init>", "(III)V", "h", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public class d_s0 implements Iterable<Integer>, a_q0 {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int first;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int last;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int step;

    /* compiled from: Progressions.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Ls0/d$a;", "", "", "rangeStart", "rangeEnd", "step", "Ls0/d;", "a", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s0.d$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        @NotNull
        public final d_s0 a(int rangeStart, int rangeEnd, int step) {
            return new d_s0(rangeStart, rangeEnd, step);
        }
    }

    public d_s0(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = i2;
        this.last = c_l0.c(i2, i3, i4);
        this.step = i4;
    }

    /* renamed from: a, reason: from getter */
    public final int getFirst() {
        return this.first;
    }

    /* renamed from: b, reason: from getter */
    public final int getLast() {
        return this.last;
    }

    /* renamed from: c, reason: from getter */
    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public g0 iterator() {
        return new e_s0(this.first, this.last, this.step);
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof d_s0) {
            if (!isEmpty() || !((d_s0) other).isEmpty()) {
                d_s0 dS0Var = (d_s0) other;
                if (this.first != dS0Var.first || this.last != dS0Var.last || this.step != dS0Var.step) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            if (this.first > this.last) {
                return true;
            }
        } else if (this.first < this.last) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append("..");
            sb.append(this.last);
            sb.append(" step ");
            i2 = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(" downTo ");
            sb.append(this.last);
            sb.append(" step ");
            i2 = -this.step;
        }
        sb.append(i2);
        return sb.toString();
    }
}
