package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: EmojiSpan.java */
@RequiresApi(19)
/* loaded from: classes.dex */
public abstract class g extends ReplacementSpan {

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final EmojiMetadata f1945f;

    /* renamed from: e, reason: collision with root package name */
    private final Paint.FontMetricsInt f1944e = new Paint.FontMetricsInt();

    /* renamed from: g, reason: collision with root package name */
    private short f1946g = -1;

    /* renamed from: h, reason: collision with root package name */
    private short f1947h = -1;

    /* renamed from: i, reason: collision with root package name */
    private float f1948i = 1.0f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    g(@NonNull EmojiMetadata emojiMetadata) {
        androidx.core.util.h.g(emojiMetadata, "metadata cannot be null");
        this.f1945f = emojiMetadata;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final EmojiMetadata a() {
        return this.f1945f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final int b() {
        return this.f1946g;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f1944e);
        Paint.FontMetricsInt fontMetricsInt2 = this.f1944e;
        this.f1948i = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f1945f.e();
        this.f1947h = (short) (this.f1945f.e() * this.f1948i);
        short sI = (short) (this.f1945f.i() * this.f1948i);
        this.f1946g = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f1944e;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
