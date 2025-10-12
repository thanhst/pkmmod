package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.stream.IntStream;

/* compiled from: UnprecomputeTextOnModificationSpannable.java */
/* loaded from: classes.dex */
class p implements Spannable {

    /* renamed from: e, reason: collision with root package name */
    private boolean f1975e = false;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private Spannable f1976f;

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    @RequiresApi(24)
    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof androidx.core.text.h;
        }
    }

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    @RequiresApi(28)
    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.p.b
        boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof androidx.core.text.h);
        }
    }

    p(@NonNull Spannable spannable) {
        this.f1976f = spannable;
    }

    private void a() {
        Spannable spannable = this.f1976f;
        if (!this.f1975e && c().a(spannable)) {
            this.f1976f = new SpannableString(spannable);
        }
        this.f1975e = true;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    Spannable b() {
        return this.f1976f;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f1976f.charAt(i2);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream chars() {
        return a.a(this.f1976f);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream codePoints() {
        return a.b(this.f1976f);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1976f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1976f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1976f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return (T[]) this.f1976f.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1976f.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f1976f.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f1976f.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i2, int i3, int i4) {
        a();
        this.f1976f.setSpan(obj, i2, i3, i4);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public CharSequence subSequence(int i2, int i3) {
        return this.f1976f.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f1976f.toString();
    }

    p(@NonNull CharSequence charSequence) {
        this.f1976f = new SpannableString(charSequence);
    }
}
