package kotlin;

import com.facebook.share.internal.ShareConstants;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: UInt.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0014\b\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\r\u0012\u0004\b\u000e\u0010\u000f\u0088\u0001\u0010\u0092\u0001\u00020\u0005ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlin/m;", "", "", "e", "(I)Ljava/lang/String;", "", "d", "(I)I", "", "other", "", "c", "(ILjava/lang/Object;)Z", "I", "getData$annotations", "()V", ShareConstants.WEB_DIALOG_PARAM_DATA, "b", "f", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes.dex */
public final class m implements Comparable<m> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int data;

    @PublishedApi
    private /* synthetic */ m(int i2) {
        this.data = i2;
    }

    public static final /* synthetic */ m a(int i2) {
        return new m(i2);
    }

    @PublishedApi
    public static int b(int i2) {
        return i2;
    }

    public static boolean c(int i2, Object obj) {
        return (obj instanceof m) && i2 == ((m) obj).getData();
    }

    public static int d(int i2) {
        return i2;
    }

    @NotNull
    public static String e(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(m mVar) {
        return u.a(getData(), mVar.getData());
    }

    public boolean equals(Object obj) {
        return c(this.data, obj);
    }

    /* renamed from: f, reason: from getter */
    public final /* synthetic */ int getData() {
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
