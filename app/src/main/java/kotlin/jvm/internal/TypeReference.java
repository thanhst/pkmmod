package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeReference.kt */
@SinceKotlin(version = "1.4")
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0006H\u0002J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR \u0010$\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010\u001d\u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010&R\u0014\u0010)\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010(¨\u0006,"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/o;", "", "convertPrimitiveToWrapper", "", "d", "Lkotlin/reflect/p;", "c", "", "other", "equals", "", "hashCode", "toString", "Lkotlin/reflect/d;", "e", "Lkotlin/reflect/d;", "g", "()Lkotlin/reflect/d;", "classifier", "", "f", "Ljava/util/List;", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/o;", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/o;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "platformTypeUpperBound", "h", "I", "getFlags$kotlin_stdlib", "()I", "getFlags$kotlin_stdlib$annotations", "flags", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "()Z", "isMarkedNullable", "i", "a", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class TypeReference implements kotlin.reflect.o {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final kotlin.reflect.d classifier;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<kotlin.reflect.p> arguments;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final kotlin.reflect.o platformTypeUpperBound;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int flags;

    /* compiled from: TypeReference.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3428a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f3428a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(kotlin.reflect.p pVar) {
        String strValueOf;
        if (pVar.getVariance() == null) {
            return "*";
        }
        kotlin.reflect.o oVar = pVar.getCom.facebook.share.internal.ShareConstants.MEDIA_TYPE java.lang.String();
        TypeReference typeReference = oVar instanceof TypeReference ? (TypeReference) oVar : null;
        if (typeReference == null || (strValueOf = typeReference.d(true)) == null) {
            strValueOf = String.valueOf(pVar.getCom.facebook.share.internal.ShareConstants.MEDIA_TYPE java.lang.String());
        }
        int i2 = b.f3428a[pVar.getVariance().ordinal()];
        if (i2 == 1) {
            return strValueOf;
        }
        if (i2 == 2) {
            return "in " + strValueOf;
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + strValueOf;
    }

    private final String d(boolean convertPrimitiveToWrapper) {
        String name;
        kotlin.reflect.d classifier = getClassifier();
        kotlin.reflect.c cVar = classifier instanceof kotlin.reflect.c ? (kotlin.reflect.c) classifier : null;
        Class<?> clsA = cVar != null ? o0.a.a(cVar) : null;
        if (clsA == null) {
            name = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsA.isArray()) {
            name = f(clsA);
        } else if (convertPrimitiveToWrapper && clsA.isPrimitive()) {
            kotlin.reflect.d classifier2 = getClassifier();
            s.c(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = o0.a.b((kotlin.reflect.c) classifier2).getName();
        } else {
            name = clsA.getName();
        }
        String str = name + (e().isEmpty() ? "" : CollectionsKt___CollectionsKt.I(e(), ", ", "<", ">", 0, null, new p0.l<kotlin.reflect.p, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            {
                super(1);
            }

            @Override // p0.l
            @NotNull
            public final CharSequence invoke(@NotNull kotlin.reflect.p it) {
                s.e(it, "it");
                return this.this$0.c(it);
            }
        }, 24, null)) + (h() ? "?" : "");
        kotlin.reflect.o oVar = this.platformTypeUpperBound;
        if (!(oVar instanceof TypeReference)) {
            return str;
        }
        String strD = ((TypeReference) oVar).d(true);
        if (s.a(strD, str)) {
            return str;
        }
        if (s.a(strD, str + '?')) {
            return str + '!';
        }
        return '(' + str + ".." + strD + ')';
    }

    private final String f(Class<?> cls) {
        return s.a(cls, boolean[].class) ? "kotlin.BooleanArray" : s.a(cls, char[].class) ? "kotlin.CharArray" : s.a(cls, byte[].class) ? "kotlin.ByteArray" : s.a(cls, short[].class) ? "kotlin.ShortArray" : s.a(cls, int[].class) ? "kotlin.IntArray" : s.a(cls, float[].class) ? "kotlin.FloatArray" : s.a(cls, long[].class) ? "kotlin.LongArray" : s.a(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    @NotNull
    public List<kotlin.reflect.p> e() {
        return this.arguments;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) other;
            if (s.a(getClassifier(), typeReference.getClassifier()) && s.a(e(), typeReference.e()) && s.a(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public kotlin.reflect.d getClassifier() {
        return this.classifier;
    }

    public boolean h() {
        return (this.flags & 1) != 0;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + e().hashCode()) * 31) + Integer.valueOf(this.flags).hashCode();
    }

    @NotNull
    public String toString() {
        return d(false) + " (Kotlin reflection is not available)";
    }
}
