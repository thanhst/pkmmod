package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: TypefaceEmojiSpan.java */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class m extends g {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private static Paint f1974j;

    public m(@NonNull EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    @NonNull
    private static Paint c() {
        if (f1974j == null) {
            TextPaint textPaint = new TextPaint();
            f1974j = textPaint;
            textPaint.setColor(EmojiCompat.b().c());
            f1974j.setStyle(Paint.Style.FILL);
        }
        return f1974j;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        if (EmojiCompat.b().i()) {
            canvas.drawRect(f2, i4, f2 + b(), i6, c());
        }
        a().a(canvas, f2, i5, paint);
    }
}
