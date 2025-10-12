package q;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: EmojiTextWatcher.java */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class g implements TextWatcher {

    /* renamed from: e, reason: collision with root package name */
    private final EditText f4077e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f4078f;

    /* renamed from: g, reason: collision with root package name */
    private EmojiCompat.e f4079g;

    /* renamed from: h, reason: collision with root package name */
    private int f4080h = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private int f4081i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4082j = true;

    /* compiled from: EmojiTextWatcher.java */
    @RequiresApi(19)
    private static class a extends EmojiCompat.e {

        /* renamed from: a, reason: collision with root package name */
        private final Reference<EditText> f4083a;

        a(EditText editText) {
            this.f4083a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.e
        public void b() {
            super.b();
            g.b(this.f4083a.get(), 1);
        }
    }

    g(EditText editText, boolean z2) {
        this.f4077e = editText;
        this.f4078f = z2;
    }

    private EmojiCompat.e a() {
        if (this.f4079g == null) {
            this.f4079g = new a(this.f4077e);
        }
        return this.f4079g;
    }

    static void b(@Nullable EditText editText, int i2) {
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f4082j && (this.f4078f || EmojiCompat.h())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void c(boolean z2) {
        if (this.f4082j != z2) {
            if (this.f4079g != null) {
                EmojiCompat.b().t(this.f4079g);
            }
            this.f4082j = z2;
            if (z2) {
                b(this.f4077e, EmojiCompat.b().d());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f4077e.isInEditMode() || d() || i3 > i4 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iD = EmojiCompat.b().d();
        if (iD != 0) {
            if (iD == 1) {
                EmojiCompat.b().r((Spannable) charSequence, i2, i2 + i4, this.f4080h, this.f4081i);
                return;
            } else if (iD != 3) {
                return;
            }
        }
        EmojiCompat.b().s(a());
    }
}
