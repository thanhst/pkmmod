package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class h implements Spannable {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f1621h = new Object();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Spannable f1622e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final a f1623f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final PrecomputedText f1624g;

    @NonNull
    public a a() {
        return this.f1623f;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText b() {
        Spannable spannable = this.f1622e;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f1622e.charAt(i2);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1622e.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1622e.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1622e.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f1624g.getSpans(i2, i3, cls) : (T[]) this.f1622e.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1622e.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f1622e.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1624g.removeSpan(obj);
        } else {
            this.f1622e.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1624g.setSpan(obj, i2, i3, i4);
        } else {
            this.f1622e.setSpan(obj, i2, i3, i4);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f1622e.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f1622e.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final TextPaint f1625a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final TextDirectionHeuristic f1626b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1627c;

        /* renamed from: d, reason: collision with root package name */
        private final int f1628d;

        /* renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f1629e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.text.h$a$a, reason: collision with other inner class name */
        public static class C0020a {

            /* renamed from: a, reason: collision with root package name */
            @NonNull
            private final TextPaint f1630a;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f1631b;

            /* renamed from: c, reason: collision with root package name */
            private int f1632c;

            /* renamed from: d, reason: collision with root package name */
            private int f1633d;

            public C0020a(@NonNull TextPaint textPaint) {
                this.f1630a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1632c = 1;
                    this.f1633d = 1;
                } else {
                    this.f1633d = 0;
                    this.f1632c = 0;
                }
                this.f1631b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public a a() {
                return new a(this.f1630a, this.f1631b, this.f1632c, this.f1633d);
            }

            @RequiresApi(23)
            public C0020a b(int i2) {
                this.f1632c = i2;
                return this;
            }

            @RequiresApi(23)
            public C0020a c(int i2) {
                this.f1633d = i2;
                return this;
            }

            @RequiresApi(18)
            public C0020a d(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f1631b = textDirectionHeuristic;
                return this;
            }
        }

        a(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1629e = new Object(textPaint) { // from class: android.text.PrecomputedText.Params.Builder
                    static {
                        throw new NoClassDefFoundError();
                    }

                    public /* synthetic */ Builder(@android.annotation.NonNull TextPaint textPaint2) {
                    }

                    @android.annotation.NonNull
                    public native /* synthetic */ Params build();

                    public native /* synthetic */ Builder setBreakStrategy(int i4);

                    public native /* synthetic */ Builder setHyphenationFrequency(int i4);

                    public native /* synthetic */ Builder setTextDirection(@android.annotation.NonNull TextDirectionHeuristic textDirectionHeuristic2);
                }.setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f1629e = null;
            }
            this.f1625a = textPaint2;
            this.f1626b = textDirectionHeuristic;
            this.f1627c = i2;
            this.f1628d = i3;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean a(@NonNull a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f1627c != aVar.b() || this.f1628d != aVar.c())) || this.f1625a.getTextSize() != aVar.e().getTextSize() || this.f1625a.getTextScaleX() != aVar.e().getTextScaleX() || this.f1625a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i2 >= 21 && (this.f1625a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f1625a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f1625a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f1625a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f1625a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f1625a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f1625a.getTypeface().equals(aVar.e().getTypeface());
        }

        @RequiresApi(23)
        public int b() {
            return this.f1627c;
        }

        @RequiresApi(23)
        public int c() {
            return this.f1628d;
        }

        @Nullable
        @RequiresApi(18)
        public TextDirectionHeuristic d() {
            return this.f1626b;
        }

        @NonNull
        public TextPaint e() {
            return this.f1625a;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f1626b == aVar.d();
        }

        public int hashCode() {
            int i2 = Build.VERSION.SDK_INT;
            return i2 >= 24 ? androidx.core.util.c.b(Float.valueOf(this.f1625a.getTextSize()), Float.valueOf(this.f1625a.getTextScaleX()), Float.valueOf(this.f1625a.getTextSkewX()), Float.valueOf(this.f1625a.getLetterSpacing()), Integer.valueOf(this.f1625a.getFlags()), this.f1625a.getTextLocales(), this.f1625a.getTypeface(), Boolean.valueOf(this.f1625a.isElegantTextHeight()), this.f1626b, Integer.valueOf(this.f1627c), Integer.valueOf(this.f1628d)) : i2 >= 21 ? androidx.core.util.c.b(Float.valueOf(this.f1625a.getTextSize()), Float.valueOf(this.f1625a.getTextScaleX()), Float.valueOf(this.f1625a.getTextSkewX()), Float.valueOf(this.f1625a.getLetterSpacing()), Integer.valueOf(this.f1625a.getFlags()), this.f1625a.getTextLocale(), this.f1625a.getTypeface(), Boolean.valueOf(this.f1625a.isElegantTextHeight()), this.f1626b, Integer.valueOf(this.f1627c), Integer.valueOf(this.f1628d)) : androidx.core.util.c.b(Float.valueOf(this.f1625a.getTextSize()), Float.valueOf(this.f1625a.getTextScaleX()), Float.valueOf(this.f1625a.getTextSkewX()), Integer.valueOf(this.f1625a.getFlags()), this.f1625a.getTextLocale(), this.f1625a.getTypeface(), this.f1626b, Integer.valueOf(this.f1627c), Integer.valueOf(this.f1628d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1625a.getTextSize());
            sb.append(", textScaleX=" + this.f1625a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1625a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                sb.append(", letterSpacing=" + this.f1625a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1625a.isElegantTextHeight());
            }
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f1625a.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.f1625a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1625a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.f1625a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1626b);
            sb.append(", breakStrategy=" + this.f1627c);
            sb.append(", hyphenationFrequency=" + this.f1628d);
            sb.append("}");
            return sb.toString();
        }

        @RequiresApi(28)
        public a(@NonNull PrecomputedText.Params params) {
            this.f1625a = params.getTextPaint();
            this.f1626b = params.getTextDirection();
            this.f1627c = params.getBreakStrategy();
            this.f1628d = params.getHyphenationFrequency();
            this.f1629e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
