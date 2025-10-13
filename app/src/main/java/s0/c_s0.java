package s0;

import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0011B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Ls0/c;", "Ls0/a;", "", "", "", "isEmpty", "other", "equals", "", "hashCode", "", "toString", "start", "endInclusive", "<init>", "(CC)V", "i", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class c_s0 extends a_s0 {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final c_s0 f4105j = new c_s0(1, 0);

    public c_s0(char c2, char c3) {
        super(c2, c3, 1);
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof c_s0) {
            if (!isEmpty() || !((c_s0) other).isEmpty()) {
                c_s0 cS0Var = (c_s0) other;
                if (getFirst() != cS0Var.getFirst() || getLast() != cS0Var.getLast()) {
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
        return (getFirst() * 31) + getLast();
    }

    public boolean isEmpty() {
        return s.f(getFirst(), getLast()) > 0;
    }

    @NotNull
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
