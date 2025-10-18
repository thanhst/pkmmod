package q;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: EmojiInputFilter.java */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class d_q implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f4066a;

    /* renamed from: b, reason: collision with root package name */
    private EmojiCompat.e f4067b;

    /* compiled from: EmojiInputFilter.java */
    @RequiresApi(19)
    private static class a extends EmojiCompat.e {

        /* renamed from: a, reason: collision with root package name */
        private final Reference<TextView> f4068a;

        /* renamed from: b, reason: collision with root package name */
        private final Reference<d_q> f4069b;

        a(TextView textView, d_q dQVar) {
            this.f4068a = new WeakReference(textView);
            this.f4069b = new WeakReference(dQVar);
        }

        private boolean c(@Nullable TextView textView, @Nullable InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.e
        public void b() {
            CharSequence text;
            CharSequence charSequenceO;
            super.b();
            TextView textView = this.f4068a.get();
            if (c(textView, this.f4069b.get()) && textView.isAttachedToWindow() && text != (charSequenceO = EmojiCompat.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceO);
                int selectionEnd = Selection.getSelectionEnd(charSequenceO);
                textView.setText(charSequenceO);
                if (charSequenceO instanceof Spannable) {
                    d_q.b((Spannable) charSequenceO, selectionStart, selectionEnd);
                }
            }
        }
    }

    d_q(@NonNull TextView textView) {
        this.f4066a = textView;
    }

    private EmojiCompat.e a() {
        if (this.f4067b == null) {
            this.f4067b = new a(this.f4066a, this);
        }
        return this.f4067b;
    }

    static void b(Spannable spannable, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            Selection.setSelection(spannable, i2, i3);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (this.f4066a.isInEditMode()) {
            return charSequence;
        }
        int iD = EmojiCompat.b().d();
        if (iD != 0) {
            boolean z2 = true;
            if (iD == 1) {
                if (i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == this.f4066a.getText()) {
                    z2 = false;
                }
                if (!z2 || charSequence == null) {
                    return charSequence;
                }
                if (i2 != 0 || i3 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return EmojiCompat.b().p(charSequence, 0, charSequence.length());
            }
            if (iD != 3) {
                return charSequence;
            }
        }
        EmojiCompat.b().s(a());
        return charSequence;
    }
}
