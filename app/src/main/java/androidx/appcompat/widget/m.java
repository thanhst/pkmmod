package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatEmojiEditTextHelper.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final EditText f1008a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final q.a f1009b;

    m(@NonNull EditText editText) {
        this.f1008a = editText;
        this.f1009b = new q.a(editText, false);
    }

    @Nullable
    KeyListener a(@Nullable KeyListener keyListener) {
        return b(keyListener) ? this.f1009b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(@Nullable AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f1008a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        try {
            int i3 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(i3) ? typedArrayObtainStyledAttributes.getBoolean(i3, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Nullable
    InputConnection d(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.f1009b.b(inputConnection, editorInfo);
    }

    void e(boolean z2) {
        this.f1009b.c(z2);
    }
}
