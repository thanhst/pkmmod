package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: DefaultGlyphChecker.java */
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class d implements EmojiCompat.d {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f1920b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f1921a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.f1921a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f1920b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.d
    public boolean a(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23 && i4 > i5) {
            return false;
        }
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i2 < i3) {
            sbB.append(charSequence.charAt(i2));
            i2++;
        }
        return androidx.core.graphics.d.a(this.f1921a, sbB.toString());
    }
}
