package s0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"Ls0/i;", "Ls0/g;", "", "", "value", "", "d", "isEmpty", "other", "equals", "", "hashCode", "", "toString", "start", "endInclusive", "<init>", "(JJ)V", "i", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class i_s0 extends g_s0 {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final i_s0 f4125j = new i_s0(1, 0);

    public i_s0(long j2, long j3) {
        super(j2, j3, 1L);
    }

    public boolean d(long value) {
        return getFirst() <= value && value <= getLast();
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof i_s0) {
            if (!isEmpty() || !((i_s0) other).isEmpty()) {
                i_s0 iS0Var = (i_s0) other;
                if (getFirst() != iS0Var.getFirst() || getLast() != iS0Var.getLast()) {
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
        return (int) ((31 * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @NotNull
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
