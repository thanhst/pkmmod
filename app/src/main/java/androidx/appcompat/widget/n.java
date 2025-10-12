package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatEmojiTextHelper.java */
/* loaded from: classes.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TextView f1015a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final q.f f1016b;

    n(@NonNull TextView textView) {
        this.f1015a = textView;
        this.f1016b = new q.f(textView, false);
    }

    @NonNull
    InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f1016b.a(inputFilterArr);
    }

    void b(@Nullable AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f1015a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        try {
            int i3 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(i3) ? typedArrayObtainStyledAttributes.getBoolean(i3, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void c(boolean z2) {
        this.f1016b.b(z2);
    }

    void d(boolean z2) {
        this.f1016b.c(z2);
    }
}
