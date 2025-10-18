package q;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: EmojiEditTextHelper.java */
/* loaded from: classes.dex */
public final class a_q {

    /* renamed from: a, reason: collision with root package name */
    private final b f4056a;

    /* renamed from: b, reason: collision with root package name */
    private int f4057b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f4058c = 0;

    /* compiled from: EmojiEditTextHelper.java */
    @RequiresApi(19)
    /* renamed from: q.a$a, reason: collision with other inner class name */
    private static class C0068a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f4059a;

        /* renamed from: b, reason: collision with root package name */
        private final g_q f4060b;

        C0068a(@NonNull EditText editText, boolean z2) {
            this.f4059a = editText;
            g_q gQVar = new g_q(editText, z2);
            this.f4060b = gQVar;
            editText.addTextChangedListener(gQVar);
            editText.setEditableFactory(b_q.getInstance());
        }

        @Override // q.a.b
        KeyListener a(@Nullable KeyListener keyListener) {
            if (keyListener instanceof e_q) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e_q(keyListener);
        }

        @Override // q.a.b
        InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection instanceof c_q ? inputConnection : new c_q(this.f4059a, inputConnection, editorInfo);
        }

        @Override // q.a.b
        void c(boolean z2) {
            this.f4060b.c(z2);
        }
    }

    /* compiled from: EmojiEditTextHelper.java */
    static class b {
        b() {
        }

        @Nullable
        KeyListener a(@Nullable KeyListener keyListener) {
            throw null;
        }

        InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            throw null;
        }

        void c(boolean z2) {
            throw null;
        }
    }

    public a_q(@NonNull EditText editText, boolean z2) {
        androidx.core.util.h.g(editText, "editText cannot be null");
        this.f4056a = new C0068a(editText, z2);
    }

    @Nullable
    public KeyListener a(@Nullable KeyListener keyListener) {
        return this.f4056a.a(keyListener);
    }

    @Nullable
    public InputConnection b(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f4056a.b(inputConnection, editorInfo);
    }

    public void c(boolean z2) {
        this.f4056a.c(z2);
    }
}
