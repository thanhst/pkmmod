package s0;

import kotlin.Metadata;
import kotlin.collections.r;
import l0.c_l0;

import org.jetbrains.annotations.NotNull;

/* compiled from: Progressions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B!\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Ls0/a;", "", "", "Lkotlin/collections/r;", "c", "e", "C", "a", "()C", "first", "f", "b", "last", "", "g", "I", "getStep", "()I", "step", "start", "endInclusive", "<init>", "(CCI)V", "h", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public class a_s0 implements Iterable<Character>, q0.a_q0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final char first;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final char last;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int step;

    public a_s0(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = c2;
        this.last = (char) c_l0.c(c2, c3, i2);
        this.step = i2;
    }

    /* renamed from: a, reason: from getter */
    public final char getFirst() {
        return this.first;
    }

    /* renamed from: b, reason: from getter */
    public final char getLast() {
        return this.last;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r iterator() {
        return new b_s0(this.first, this.last, this.step);
    }
}
