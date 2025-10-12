package s0;

import kotlin.Metadata;
import kotlin.jvm.internal.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0016"}, d2 = {"Ls0/f;", "Ls0/d;", "", "", "value", "", "f", "isEmpty", "other", "equals", "hashCode", "", "toString", "h", "()Ljava/lang/Integer;", "start", "g", "endInclusive", "<init>", "(II)V", "i", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final f f4115j = new f(1, 0);

    /* compiled from: Ranges.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Ls0/f$a;", "", "Ls0/f;", "EMPTY", "Ls0/f;", "a", "()Ls0/f;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s0.f$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        @NotNull
        public final f a() {
            return f.f4115j;
        }
    }

    public f(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // s0.d
    public boolean equals(@Nullable Object other) {
        if (other instanceof f) {
            if (!isEmpty() || !((f) other).isEmpty()) {
                f fVar = (f) other;
                if (getFirst() != fVar.getFirst() || getLast() != fVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @NotNull
    public Integer g() {
        return Integer.valueOf(getLast());
    }

    @NotNull
    public Integer h() {
        return Integer.valueOf(getFirst());
    }

    @Override // s0.d
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // s0.d
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // s0.d
    @NotNull
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
