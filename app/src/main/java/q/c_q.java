package q;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: EmojiInputConnection.java */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class c_q extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f4064a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4065b;

    /* compiled from: EmojiInputConnection.java */
    public static class a {
        public boolean a(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z2) {
            return EmojiCompat.e(inputConnection, editable, i2, i3, z2);
        }

        public void b(@NonNull EditorInfo editorInfo) {
            if (EmojiCompat.h()) {
                EmojiCompat.b().u(editorInfo);
            }
        }
    }

    c_q(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f4064a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        return this.f4065b.a(this, a(), i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return this.f4065b.a(this, a(), i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }

    c_q(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull a aVar) {
        super(inputConnection, false);
        this.f4064a = textView;
        this.f4065b = aVar;
        aVar.b(editorInfo);
    }
}
