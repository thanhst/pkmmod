package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, FontResourcesParserCompat.c> f1548a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl.java */
    class a implements c<FontsContractCompat.b> {
        a() {
        }

        @Override // androidx.core.graphics.l.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(FontsContractCompat.b bVar) {
            return bVar.e();
        }

        @Override // androidx.core.graphics.l.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(FontsContractCompat.b bVar) {
            return bVar.f();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    class b implements c<FontResourcesParserCompat.d> {
        b() {
        }

        @Override // androidx.core.graphics.l.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(FontResourcesParserCompat.d dVar) {
            return dVar.e();
        }

        @Override // androidx.core.graphics.l.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(FontResourcesParserCompat.d dVar) {
            return dVar.f();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    private interface c<T> {
        int a(T t2);

        boolean b(T t2);
    }

    l() {
    }

    private void a(Typeface typeface, FontResourcesParserCompat.c cVar) throws NoSuchFieldException, SecurityException {
        long jK = k(typeface);
        if (jK != 0) {
            this.f1548a.put(Long.valueOf(jK), cVar);
        }
    }

    private FontResourcesParserCompat.d f(FontResourcesParserCompat.c cVar, int i2) {
        return (FontResourcesParserCompat.d) g(cVar.a(), i2, new b());
    }

    private static <T> T g(T[] tArr, int i2, c<T> cVar) {
        return (T) h(tArr, (i2 & 1) == 0 ? Constants.MINIMAL_ERROR_STATUS_CODE : 700, (i2 & 2) != 0, cVar);
    }

    private static <T> T h(T[] tArr, int i2, boolean z2, c<T> cVar) {
        T t2 = null;
        int i3 = Integer.MAX_VALUE;
        for (T t3 : tArr) {
            int iAbs = (Math.abs(cVar.a(t3) - i2) * 2) + (cVar.b(t3) == z2 ? 0 : 1);
            if (t2 == null || i3 > iAbs) {
                t2 = t3;
                i3 = iAbs;
            }
        }
        return t2;
    }

    private static long k(@Nullable Typeface typeface) throws NoSuchFieldException, SecurityException {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    @Nullable
    public Typeface b(Context context, FontResourcesParserCompat.c cVar, Resources resources, int i2) throws NoSuchFieldException, SecurityException {
        FontResourcesParserCompat.d dVarF = f(cVar, i2);
        if (dVarF == null) {
            return null;
        }
        Typeface typefaceD = f.d(context, resources, dVarF.b(), dVarF.a(), 0, i2);
        a(typefaceD, cVar);
        return typefaceD;
    }

    @Nullable
    public Typeface c(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.b[] bVarArr, int i2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(i(bVarArr, i2).d());
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                m.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                m.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                m.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = m.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (m.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    @Nullable
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        File fileE = m.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (m.c(fileE, resources, i2)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected FontsContractCompat.b i(FontsContractCompat.b[] bVarArr, int i2) {
        return (FontsContractCompat.b) g(bVarArr, i2, new a());
    }

    @Nullable
    FontResourcesParserCompat.c j(Typeface typeface) throws NoSuchFieldException, SecurityException {
        long jK = k(typeface);
        if (jK == 0) {
            return null;
        }
        return this.f1548a.get(Long.valueOf(jK));
    }
}
