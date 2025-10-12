package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f1498k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    Object f1500b;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String f1508j;

    /* renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int f1499a = -1;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] f1501c = null;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable f1502d = null;

    /* renamed from: e, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f1503e = 0;

    /* renamed from: f, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f1504f = 0;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList f1505g = null;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f1506h = f1498k;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String f1507i = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IconType {
    }

    @RequiresApi(23)
    static class a {
        @DrawableRes
        @IdRes
        static int a(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            } catch (InvocationTargetException e4) {
                Log.e("IconCompat", "Unable to get icon resource", e4);
                return 0;
            }
        }

        @Nullable
        static String b(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon package", e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            } catch (InvocationTargetException e4) {
                Log.e("IconCompat", "Unable to get icon package", e4);
                return null;
            }
        }

        @Nullable
        @DoNotInline
        static Uri c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            } catch (InvocationTargetException e4) {
                Log.e("IconCompat", "Unable to get icon uri", e4);
                return null;
            }
        }

        @DoNotInline
        static Drawable d(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        @DoNotInline
        static Icon e(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f1499a) {
                case -1:
                    return (Icon) iconCompat.f1500b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f1500b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.d(), iconCompat.f1503e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f1500b, iconCompat.f1503e, iconCompat.f1504f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f1500b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.b((Bitmap) iconCompat.f1500b, false));
                        break;
                    } else {
                        iconCreateWithBitmap = b.b((Bitmap) iconCompat.f1500b);
                        break;
                    }
                case 6:
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.e());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.e());
                        }
                        InputStream inputStreamF = iconCompat.f(context);
                        if (inputStreamF == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.e());
                        }
                        if (i2 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.b(BitmapFactory.decodeStream(inputStreamF), false));
                            break;
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamF));
                            break;
                        }
                    }
            }
            ColorStateList colorStateList = iconCompat.f1505g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f1506h;
            if (mode != IconCompat.f1498k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    @RequiresApi(26)
    static class b {
        @DoNotInline
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        @DoNotInline
        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @RequiresApi(28)
    static class c {
        @DoNotInline
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        @DoNotInline
        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        @DoNotInline
        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        @DoNotInline
        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @RequiresApi(30)
    static class d {
        @DoNotInline
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
    }

    @VisibleForTesting
    static Bitmap b(Bitmap bitmap, boolean z2) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f2 = iMin;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z2) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    private static String i(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @DrawableRes
    public int c() {
        int i2 = this.f1499a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f1500b);
        }
        if (i2 == 2) {
            return this.f1503e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String d() {
        int i2 = this.f1499a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f1500b);
        }
        if (i2 == 2) {
            String str = this.f1508j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f1500b).split(CertificateUtil.DELIMITER, -1)[0] : this.f1508j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    @NonNull
    public Uri e() {
        int i2 = this.f1499a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f1500b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f1500b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream f(@NonNull Context context) {
        Uri uriE = e();
        String scheme = uriE.getScheme();
        if ("content".equals(scheme) || ShareInternalUtility.STAGING_PARAM.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriE);
            } catch (Exception e2) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriE, e2);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f1500b));
        } catch (FileNotFoundException e3) {
            Log.w("IconCompat", "Unable to load image from path: " + uriE, e3);
            return null;
        }
    }

    public void g() {
        this.f1506h = PorterDuff.Mode.valueOf(this.f1507i);
        switch (this.f1499a) {
            case -1:
                Parcelable parcelable = this.f1502d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f1500b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1502d;
                if (parcelable2 != null) {
                    this.f1500b = parcelable2;
                    return;
                }
                byte[] bArr = this.f1501c;
                this.f1500b = bArr;
                this.f1499a = 3;
                this.f1503e = 0;
                this.f1504f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1501c, Charset.forName("UTF-16"));
                this.f1500b = str;
                if (this.f1499a == 2 && this.f1508j == null) {
                    this.f1508j = str.split(CertificateUtil.DELIMITER, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1500b = this.f1501c;
                return;
        }
    }

    public void h(boolean z2) {
        this.f1507i = this.f1506h.name();
        switch (this.f1499a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f1502d = (Parcelable) this.f1500b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z2) {
                    this.f1502d = (Parcelable) this.f1500b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f1500b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f1501c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f1501c = ((String) this.f1500b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1501c = (byte[]) this.f1500b;
                return;
            case 4:
            case 6:
                this.f1501c = this.f1500b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @NonNull
    public String toString() {
        if (this.f1499a == -1) {
            return String.valueOf(this.f1500b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(i(this.f1499a));
        switch (this.f1499a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1500b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1500b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1508j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1503e);
                if (this.f1504f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1504f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1500b);
                break;
        }
        if (this.f1505g != null) {
            sb.append(" tint=");
            sb.append(this.f1505g);
        }
        if (this.f1506h != f1498k) {
            sb.append(" mode=");
            sb.append(this.f1506h);
        }
        sb.append(")");
        return sb.toString();
    }
}
