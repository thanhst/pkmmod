package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.h;
import androidx.core.provider.FontsContractCompat;

/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final l f1529a;

    /* renamed from: b, reason: collision with root package name */
    private static final androidx.collection.e<String, Typeface> f1530b;

    /* compiled from: TypefaceCompat.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private h.f f1531a;

        public a(@Nullable h.f fVar) {
            this.f1531a = fVar;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void a(int i2) {
            h.f fVar = this.f1531a;
            if (fVar != null) {
                fVar.f(i2);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void b(@NonNull Typeface typeface) {
            h.f fVar = this.f1531a;
            if (fVar != null) {
                fVar.g(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f1529a = new k();
        } else if (i2 >= 28) {
            f1529a = new j();
        } else if (i2 >= 26) {
            f1529a = new i();
        } else if (i2 >= 24 && h.n()) {
            f1529a = new h();
        } else if (i2 >= 21) {
            f1529a = new g();
        } else {
            f1529a = new l();
        }
        f1530b = new androidx.collection.e<>(16);
    }

    @NonNull
    public static Typeface a(@NonNull Context context, @Nullable Typeface typeface, int i2) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i2)) == null) ? Typeface.create(typeface, i2) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface b(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.b[] bVarArr, int i2) {
        return f1529a.c(context, cancellationSignal, bVarArr, i2);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface c(@NonNull Context context, @NonNull FontResourcesParserCompat.b bVar, @NonNull Resources resources, int i2, @Nullable String str, int i3, int i4, @Nullable h.f fVar, @Nullable Handler handler, boolean z2) throws NoSuchFieldException, SecurityException {
        Typeface typefaceB;
        if (bVar instanceof FontResourcesParserCompat.e) {
            FontResourcesParserCompat.e eVar = (FontResourcesParserCompat.e) bVar;
            Typeface typefaceH = h(eVar.c());
            if (typefaceH != null) {
                if (fVar != null) {
                    fVar.d(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceB = FontsContractCompat.c(context, eVar.b(), i4, !z2 ? fVar != null : eVar.a() != 0, z2 ? eVar.d() : -1, h.f.e(handler), new a(fVar));
        } else {
            typefaceB = f1529a.b(context, (FontResourcesParserCompat.c) bVar, resources, i4);
            if (fVar != null) {
                if (typefaceB != null) {
                    fVar.d(typefaceB, handler);
                } else {
                    fVar.c(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f1530b.d(e(resources, i2, str, i3, i4), typefaceB);
        }
        return typefaceB;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface d(@NonNull Context context, @NonNull Resources resources, int i2, String str, int i3, int i4) {
        Typeface typefaceE = f1529a.e(context, resources, i2, str, i4);
        if (typefaceE != null) {
            f1530b.d(e(resources, i2, str, i3, i4), typefaceE);
        }
        return typefaceE;
    }

    private static String e(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface f(@NonNull Resources resources, int i2, @Nullable String str, int i3, int i4) {
        return f1530b.c(e(resources, i2, str, i3, i4));
    }

    @Nullable
    private static Typeface g(Context context, Typeface typeface, int i2) throws NoSuchFieldException, SecurityException {
        l lVar = f1529a;
        FontResourcesParserCompat.c cVarJ = lVar.j(typeface);
        if (cVarJ == null) {
            return null;
        }
        return lVar.b(context, cVarJ, context.getResources(), i2);
    }

    private static Typeface h(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
