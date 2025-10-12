package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R$styleable;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FontResourcesParserCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    @RequiresApi(21)
    static class a {
        @DoNotInline
        static int a(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final d[] f1435a;

        public c(@NonNull d[] dVarArr) {
            this.f1435a = dVarArr;
        }

        @NonNull
        public d[] a() {
            return this.f1435a;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f1436a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1437b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f1438c;

        /* renamed from: d, reason: collision with root package name */
        private final String f1439d;

        /* renamed from: e, reason: collision with root package name */
        private final int f1440e;

        /* renamed from: f, reason: collision with root package name */
        private final int f1441f;

        public d(@NonNull String str, int i2, boolean z2, @Nullable String str2, int i3, int i4) {
            this.f1436a = str;
            this.f1437b = i2;
            this.f1438c = z2;
            this.f1439d = str2;
            this.f1440e = i3;
            this.f1441f = i4;
        }

        @NonNull
        public String a() {
            return this.f1436a;
        }

        public int b() {
            return this.f1441f;
        }

        public int c() {
            return this.f1440e;
        }

        @Nullable
        public String d() {
            return this.f1439d;
        }

        public int e() {
            return this.f1437b;
        }

        public boolean f() {
            return this.f1438c;
        }
    }

    public static final class e implements b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final androidx.core.provider.e f1442a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1443b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1444c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final String f1445d;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public e(@NonNull androidx.core.provider.e eVar, int i2, int i3, @Nullable String str) {
            this.f1442a = eVar;
            this.f1444c = i2;
            this.f1443b = i3;
            this.f1445d = str;
        }

        public int a() {
            return this.f1444c;
        }

        @NonNull
        public androidx.core.provider.e b() {
            return this.f1442a;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String c() {
            return this.f1445d;
        }

        public int d() {
            return this.f1443b;
        }
    }

    private static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.a(typedArray, i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    @Nullable
    public static b b(@NonNull XmlPullParser xmlPullParser, @NonNull Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> c(@NonNull Resources resources, @ArrayRes int i2) throws Resources.NotFoundException {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    @Nullable
    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    @Nullable
    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i2 = R$styleable.FontFamilyFont_fontWeight;
        if (!typedArrayObtainAttributes.hasValue(i2)) {
            i2 = R$styleable.FontFamilyFont_android_fontWeight;
        }
        int i3 = typedArrayObtainAttributes.getInt(i2, Constants.MINIMAL_ERROR_STATUS_CODE);
        int i4 = R$styleable.FontFamilyFont_fontStyle;
        if (!typedArrayObtainAttributes.hasValue(i4)) {
            i4 = R$styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z2 = 1 == typedArrayObtainAttributes.getInt(i4, 0);
        int i5 = R$styleable.FontFamilyFont_ttcIndex;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = R$styleable.FontFamilyFont_android_ttcIndex;
        }
        int i6 = R$styleable.FontFamilyFont_fontVariationSettings;
        if (!typedArrayObtainAttributes.hasValue(i6)) {
            i6 = R$styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = typedArrayObtainAttributes.getString(i6);
        int i7 = typedArrayObtainAttributes.getInt(i5, 0);
        int i8 = R$styleable.FontFamilyFont_font;
        if (!typedArrayObtainAttributes.hasValue(i8)) {
            i8 = R$styleable.FontFamilyFont_android_font;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i8, 0);
        String string2 = typedArrayObtainAttributes.getString(i8);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i3, z2, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
