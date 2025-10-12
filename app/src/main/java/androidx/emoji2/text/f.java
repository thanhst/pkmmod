package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.k;
import java.util.Arrays;

/* compiled from: EmojiProcessor.java */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final EmojiCompat.i f1925a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final k f1926b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private EmojiCompat.d f1927c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f1928d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final int[] f1929e;

    /* compiled from: EmojiProcessor.java */
    @RequiresApi(19)
    private static final class a {
        static int a(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i3 != 0) {
                    i2--;
                    if (i2 < 0) {
                        return z2 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i2);
                    if (z2) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i3--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i3--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z2 = true;
                    }
                }
                return i2;
            }
        }

        static int b(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i3 != 0) {
                    if (i2 >= length) {
                        if (z2) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i2);
                    if (z2) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i3--;
                        i2++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i3--;
                        i2++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2++;
                        z2 = true;
                    }
                }
                return i2;
            }
        }
    }

    /* compiled from: EmojiProcessor.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f1930a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final k.a f1931b;

        /* renamed from: c, reason: collision with root package name */
        private k.a f1932c;

        /* renamed from: d, reason: collision with root package name */
        private k.a f1933d;

        /* renamed from: e, reason: collision with root package name */
        private int f1934e;

        /* renamed from: f, reason: collision with root package name */
        private int f1935f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f1936g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f1937h;

        b(k.a aVar, boolean z2, int[] iArr) {
            this.f1931b = aVar;
            this.f1932c = aVar;
            this.f1936g = z2;
            this.f1937h = iArr;
        }

        private static boolean d(int i2) {
            return i2 == 65039;
        }

        private static boolean f(int i2) {
            return i2 == 65038;
        }

        private int g() {
            this.f1930a = 1;
            this.f1932c = this.f1931b;
            this.f1935f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f1932c.b().j() || d(this.f1934e)) {
                return true;
            }
            if (this.f1936g) {
                if (this.f1937h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f1937h, this.f1932c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i2) {
            k.a aVarA = this.f1932c.a(i2);
            int iG = 3;
            if (this.f1930a == 2) {
                if (aVarA != null) {
                    this.f1932c = aVarA;
                    this.f1935f++;
                } else if (f(i2)) {
                    iG = g();
                } else if (!d(i2)) {
                    if (this.f1932c.b() == null) {
                        iG = g();
                    } else if (this.f1935f != 1 || h()) {
                        this.f1933d = this.f1932c;
                        g();
                    } else {
                        iG = g();
                    }
                }
                iG = 2;
            } else if (aVarA == null) {
                iG = g();
            } else {
                this.f1930a = 2;
                this.f1932c = aVarA;
                this.f1935f = 1;
                iG = 2;
            }
            this.f1934e = i2;
            return iG;
        }

        EmojiMetadata b() {
            return this.f1932c.b();
        }

        EmojiMetadata c() {
            return this.f1933d.b();
        }

        boolean e() {
            return this.f1930a == 2 && this.f1932c.b() != null && (this.f1935f > 1 || h());
        }
    }

    f(@NonNull k kVar, @NonNull EmojiCompat.i iVar, @NonNull EmojiCompat.d dVar, boolean z2, @Nullable int[] iArr) {
        this.f1925a = iVar;
        this.f1926b = kVar;
        this.f1927c = dVar;
        this.f1928d = z2;
        this.f1929e = iArr;
    }

    private void a(@NonNull Spannable spannable, EmojiMetadata emojiMetadata, int i2, int i3) {
        spannable.setSpan(this.f1925a.a(emojiMetadata), i2, i3, 33);
    }

    private static boolean b(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z2) {
        g[] gVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (gVarArr = (g[]) editable.getSpans(selectionStart, selectionEnd, g.class)) != null && gVarArr.length > 0) {
            for (g gVar : gVarArr) {
                int spanStart = editable.getSpanStart(gVar);
                int spanEnd = editable.getSpanEnd(gVar);
                if ((z2 && spanStart == selectionStart) || ((!z2 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean c(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z2) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i2 >= 0 && i3 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z2) {
                iMax = a.a(editable, selectionStart, Math.max(i2, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i3, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i2, 0);
                iMin = Math.min(selectionEnd + i3, editable.length());
            }
            g[] gVarArr = (g[]) editable.getSpans(iMax, iMin, g.class);
            if (gVarArr != null && gVarArr.length > 0) {
                for (g gVar : gVarArr) {
                    int spanStart = editable.getSpanStart(gVar);
                    int spanEnd = editable.getSpanEnd(gVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean d(@NonNull Editable editable, int i2, @NonNull KeyEvent keyEvent) {
        if (!(i2 != 67 ? i2 != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i2, int i3, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.d() == 0) {
            emojiMetadata.k(this.f1927c.a(charSequence, i2, i3, emojiMetadata.h()));
        }
        return emojiMetadata.d() == 2;
    }

    private static boolean f(int i2, int i3) {
        return i2 == -1 || i3 == -1 || i2 != i3;
    }

    private static boolean g(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    CharSequence h(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, boolean z2) {
        int iCharCount;
        g[] gVarArr;
        boolean z3 = charSequence instanceof l;
        if (z3) {
            ((l) charSequence).a();
        }
        p pVar = null;
        if (z3) {
            pVar = new p((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    pVar = new p((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i2 - 1, i3 + 1, g.class) <= i3) {
                    pVar = new p(charSequence);
                }
            } finally {
                if (z3) {
                    ((l) charSequence).d();
                }
            }
        }
        if (pVar != null && (gVarArr = (g[]) pVar.getSpans(i2, i3, g.class)) != null && gVarArr.length > 0) {
            for (g gVar : gVarArr) {
                int spanStart = pVar.getSpanStart(gVar);
                int spanEnd = pVar.getSpanEnd(gVar);
                if (spanStart != i3) {
                    pVar.removeSpan(gVar);
                }
                i2 = Math.min(spanStart, i2);
                i3 = Math.max(spanEnd, i3);
            }
        }
        if (i2 != i3 && i2 < charSequence.length()) {
            if (i4 != Integer.MAX_VALUE && pVar != null) {
                i4 -= ((g[]) pVar.getSpans(0, pVar.length(), g.class)).length;
            }
            b bVar = new b(this.f1926b.f(), this.f1928d, this.f1929e);
            p pVar2 = pVar;
            int iCodePointAt = Character.codePointAt(charSequence, i2);
            int i5 = 0;
            loop1: while (true) {
                iCharCount = i2;
                while (i2 < i3 && i5 < i4) {
                    int iA = bVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i2 = iCharCount;
                    } else if (iA == 2) {
                        i2 += Character.charCount(iCodePointAt);
                        if (i2 < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, i2);
                        }
                    } else if (iA == 3) {
                        if (z2 || !e(charSequence, iCharCount, i2, bVar.c())) {
                            if (pVar2 == null) {
                                pVar2 = new p((Spannable) new SpannableString(charSequence));
                            }
                            a(pVar2, bVar.c(), iCharCount, i2);
                            i5++;
                        }
                    }
                }
                break loop1;
            }
            if (bVar.e() && i5 < i4 && (z2 || !e(charSequence, iCharCount, i2, bVar.b()))) {
                if (pVar2 == null) {
                    pVar2 = new p(charSequence);
                }
                a(pVar2, bVar.b(), iCharCount, i2);
            }
            if (pVar2 != null) {
                return pVar2.b();
            }
            if (z3) {
                ((l) charSequence).d();
            }
            return charSequence;
        }
        if (z3) {
            ((l) charSequence).d();
        }
        return charSequence;
    }
}
