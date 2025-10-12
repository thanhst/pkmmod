package kotlin;

import com.facebook.share.internal.ShareConstants;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: UShort.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\t\b\u0087@\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0014\b\u0001\u0012\u0006\u0010\u0011\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u0012\u0004\b\u000f\u0010\u0010\u0088\u0001\u0011\u0092\u0001\u00020\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlin/r;", "", "", "e", "(S)Ljava/lang/String;", "", "d", "(S)I", "", "other", "", "c", "(SLjava/lang/Object;)Z", "", "S", "getData$annotations", "()V", ShareConstants.WEB_DIALOG_PARAM_DATA, "b", "(S)S", "f", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes.dex */
public final class r implements Comparable<r> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final short data;

    @PublishedApi
    private /* synthetic */ r(short s2) {
        this.data = s2;
    }

    public static final /* synthetic */ r a(short s2) {
        return new r(s2);
    }

    @PublishedApi
    public static short b(short s2) {
        return s2;
    }

    public static boolean c(short s2, Object obj) {
        return (obj instanceof r) && s2 == ((r) obj).getData();
    }

    public static int d(short s2) {
        return s2;
    }

    @NotNull
    public static String e(short s2) {
        return String.valueOf(s2 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(r rVar) {
        return kotlin.jvm.internal.s.f(getData() & 65535, rVar.getData() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.data, obj);
    }

    /* renamed from: f, reason: from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    public int hashCode() {
        return d(this.data);
    }

    @NotNull
    public String toString() {
        return e(this.data);
    }
}
