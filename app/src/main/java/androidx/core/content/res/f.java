package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R$styleable;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: GradientColorInflaterCompat.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
final class f {
    private static a a(@Nullable a aVar, @ColorInt int i2, @ColorInt int i3, boolean z2, @ColorInt int i4) {
        return aVar != null ? aVar : z2 ? new a(i2, i4, i3) : new a(i2, i3);
    }

    static Shader b(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayK = p.k(resources, theme, attributeSet, R$styleable.GradientColor);
        float f2 = p.f(typedArrayK, xmlPullParser, "startX", R$styleable.GradientColor_android_startX, 0.0f);
        float f3 = p.f(typedArrayK, xmlPullParser, "startY", R$styleable.GradientColor_android_startY, 0.0f);
        float f4 = p.f(typedArrayK, xmlPullParser, "endX", R$styleable.GradientColor_android_endX, 0.0f);
        float f5 = p.f(typedArrayK, xmlPullParser, "endY", R$styleable.GradientColor_android_endY, 0.0f);
        float f6 = p.f(typedArrayK, xmlPullParser, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
        float f7 = p.f(typedArrayK, xmlPullParser, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
        int iG = p.g(typedArrayK, xmlPullParser, ShareConstants.MEDIA_TYPE, R$styleable.GradientColor_android_type, 0);
        int iB = p.b(typedArrayK, xmlPullParser, "startColor", R$styleable.GradientColor_android_startColor, 0);
        boolean zJ = p.j(xmlPullParser, "centerColor");
        int iB2 = p.b(typedArrayK, xmlPullParser, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
        int iB3 = p.b(typedArrayK, xmlPullParser, "endColor", R$styleable.GradientColor_android_endColor, 0);
        int iG2 = p.g(typedArrayK, xmlPullParser, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
        float f8 = p.f(typedArrayK, xmlPullParser, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayK.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iB, iB3, zJ, iB2);
        if (iG != 1) {
            return iG != 2 ? new LinearGradient(f2, f3, f4, f5, aVarA.f1463a, aVarA.f1464b, d(iG2)) : new SweepGradient(f6, f7, aVarA.f1463a, aVarA.f1464b);
        }
        if (f8 > 0.0f) {
            return new RadialGradient(f6, f7, f8, aVarA.f1463a, aVarA.f1464b, d(iG2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        return new androidx.core.content.res.f.a(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.core.content.res.f.a c(@androidx.annotation.NonNull android.content.res.Resources r9, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r10, @androidx.annotation.NonNull android.util.AttributeSet r11, @androidx.annotation.Nullable android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R$styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.res.p.k(r9, r12, r11, r3)
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R$styleable.GradientColorItem_android_offset
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            androidx.core.content.res.f$a r9 = new androidx.core.content.res.f$a
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.f$a");
    }

    private static Shader.TileMode d(int i2) {
        return i2 != 1 ? i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    /* compiled from: GradientColorInflaterCompat.java */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f1463a;

        /* renamed from: b, reason: collision with root package name */
        final float[] f1464b;

        a(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.f1463a = new int[size];
            this.f1464b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f1463a[i2] = list.get(i2).intValue();
                this.f1464b[i2] = list2.get(i2).floatValue();
            }
        }

        a(@ColorInt int i2, @ColorInt int i3) {
            this.f1463a = new int[]{i2, i3};
            this.f1464b = new float[]{0.0f, 1.0f};
        }

        a(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
            this.f1463a = new int[]{i2, i3, i4};
            this.f1464b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
