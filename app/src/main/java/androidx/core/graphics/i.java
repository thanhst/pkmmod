package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl.java */
@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class i extends g {

    /* renamed from: g, reason: collision with root package name */
    protected final Class<?> f1541g;

    /* renamed from: h, reason: collision with root package name */
    protected final Constructor<?> f1542h;

    /* renamed from: i, reason: collision with root package name */
    protected final Method f1543i;

    /* renamed from: j, reason: collision with root package name */
    protected final Method f1544j;

    /* renamed from: k, reason: collision with root package name */
    protected final Method f1545k;

    /* renamed from: l, reason: collision with root package name */
    protected final Method f1546l;

    /* renamed from: m, reason: collision with root package name */
    protected final Method f1547m;

    public i() throws NoSuchMethodException, SecurityException {
        Method methodY;
        Constructor<?> constructorA;
        Method methodW;
        Method methodX;
        Method methodB;
        Method methodV;
        Class<?> cls = null;
        try {
            Class<?> clsZ = z();
            constructorA = A(clsZ);
            methodW = w(clsZ);
            methodX = x(clsZ);
            methodB = B(clsZ);
            methodV = v(clsZ);
            methodY = y(clsZ);
            cls = clsZ;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            methodY = null;
            constructorA = null;
            methodW = null;
            methodX = null;
            methodB = null;
            methodV = null;
        }
        this.f1541g = cls;
        this.f1542h = constructorA;
        this.f1543i = methodW;
        this.f1544j = methodX;
        this.f1545k = methodB;
        this.f1546l = methodV;
        this.f1547m = methodY;
    }

    @Nullable
    private Object p() {
        try {
            return this.f1542h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void q(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f1546l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean r(Context context, Object obj, String str, int i2, int i3, int i4, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1543i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f1544j.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t(Object obj) {
        try {
            return ((Boolean) this.f1545k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean u() {
        if (this.f1543i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1543i != null;
    }

    protected Constructor<?> A(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method B(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // androidx.core.graphics.g, androidx.core.graphics.l
    @Nullable
    public Typeface b(Context context, FontResourcesParserCompat.c cVar, Resources resources, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!u()) {
            return super.b(context, cVar, resources, i2);
        }
        Object objP = p();
        if (objP == null) {
            return null;
        }
        for (FontResourcesParserCompat.d dVar : cVar.a()) {
            if (!r(context, objP, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                q(objP);
                return null;
            }
        }
        if (t(objP)) {
            return m(objP);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r12v3, types: [android.graphics.Typeface$Builder] */
    @Override // androidx.core.graphics.g, androidx.core.graphics.l
    @Nullable
    public Typeface c(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.b[] bVarArr, int i2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Typeface typefaceM;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!u()) {
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
                    final FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                    Typeface typefaceBuild = new Object(fileDescriptor) { // from class: android.graphics.Typeface$Builder
                        static {
                            throw new NoClassDefFoundError();
                        }

                        public native /* synthetic */ Typeface build();

                        public native /* synthetic */ Typeface$Builder setItalic(boolean z2);

                        public native /* synthetic */ Typeface$Builder setWeight(int i3);
                    }.setWeight(bVarI.e()).setItalic(bVarI.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapH = m.h(context, bVarArr, cancellationSignal);
        Object objP = p();
        if (objP == null) {
            return null;
        }
        boolean z2 = false;
        for (FontsContractCompat.b bVar : bVarArr) {
            ByteBuffer byteBuffer = mapH.get(bVar.d());
            if (byteBuffer != null) {
                if (!s(objP, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    q(objP);
                    return null;
                }
                z2 = true;
            }
        }
        if (!z2) {
            q(objP);
            return null;
        }
        if (t(objP) && (typefaceM = m(objP)) != null) {
            return Typeface.create(typefaceM, i2);
        }
        return null;
    }

    @Override // androidx.core.graphics.l
    @Nullable
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!u()) {
            return super.e(context, resources, i2, str, i3);
        }
        Object objP = p();
        if (objP == null) {
            return null;
        }
        if (!r(context, objP, str, 0, -1, -1, null)) {
            q(objP);
            return null;
        }
        if (t(objP)) {
            return m(objP);
        }
        return null;
    }

    @Nullable
    protected Typeface m(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance(this.f1541g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f1547m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method y(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> z() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }
}
