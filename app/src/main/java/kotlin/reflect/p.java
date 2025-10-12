package kotlin.reflect;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KTypeProjection.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/p;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/reflect/KVariance;", "a", "Lkotlin/reflect/KVariance;", "b", "()Lkotlin/reflect/KVariance;", "variance", "Lkotlin/reflect/o;", "Lkotlin/reflect/o;", "()Lkotlin/reflect/o;", ShareConstants.MEDIA_TYPE, "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/o;)V", "c", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final /* data */ class p {

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final p f3483d = new p(null, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final KVariance variance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final o type;

    /* compiled from: KTypeProjection.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3486a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f3486a = iArr;
        }
    }

    public p(@Nullable KVariance kVariance, @Nullable o oVar) {
        String str;
        this.variance = kVariance;
        this.type = oVar;
        if ((kVariance == null) == (oVar == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final o getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final KVariance getVariance() {
        return this.variance;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof p)) {
            return false;
        }
        p pVar = (p) other;
        return this.variance == pVar.variance && s.a(this.type, pVar.type);
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int iHashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        o oVar = this.type;
        return iHashCode + (oVar != null ? oVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.variance;
        int i2 = kVariance == null ? -1 : b.f3486a[kVariance.ordinal()];
        if (i2 == -1) {
            return "*";
        }
        if (i2 == 1) {
            return String.valueOf(this.type);
        }
        if (i2 == 2) {
            return "in " + this.type;
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.type;
    }
}
