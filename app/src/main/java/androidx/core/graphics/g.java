package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl.java */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class g extends l {

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f1532b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Constructor<?> f1533c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Method f1534d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Method f1535e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f1536f = false;

    g() {
    }

    private static boolean l(Object obj, String str, int i2, boolean z2) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        o();
        try {
            return ((Boolean) f1534d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface m(Object obj) throws NoSuchMethodException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        o();
        try {
            Object objNewInstance = Array.newInstance(f1532b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f1535e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File n(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void o() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f1536f) {
            return;
        }
        f1536f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f1533c = constructor;
        f1532b = cls;
        f1534d = method2;
        f1535e = method;
    }

    private static Object p() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        o();
        try {
            return f1533c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.l
    public Typeface b(Context context, FontResourcesParserCompat.c cVar, Resources resources, int i2) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Object objP = p();
        for (FontResourcesParserCompat.d dVar : cVar.a()) {
            File fileE = m.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!m.c(fileE, resources, dVar.b())) {
                    return null;
                }
                if (!l(objP, fileE.getPath(), dVar.e(), dVar.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return m(objP);
    }

    @Override // androidx.core.graphics.l
    public Typeface c(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.b[] bVarArr, int i2) throws IOException {
        if (bVarArr.length < 1) {
            return null;
        }
        FontsContractCompat.b bVarI = i(bVarArr, i2);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarI.d(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                File fileN = n(parcelFileDescriptorOpenFileDescriptor);
                if (fileN != null && fileN.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileN);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceD;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
