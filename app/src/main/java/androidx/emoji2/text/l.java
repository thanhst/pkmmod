package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SpannableBuilder.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class l extends SpannableStringBuilder {

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Class<?> f1970e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final List<a> f1971f;

    /* compiled from: SpannableBuilder.java */
    private static class a implements TextWatcher, SpanWatcher {

        /* renamed from: e, reason: collision with root package name */
        final Object f1972e;

        /* renamed from: f, reason: collision with root package name */
        private final AtomicInteger f1973f = new AtomicInteger(0);

        a(Object obj) {
            this.f1972e = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof g;
        }

        final void a() {
            this.f1973f.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f1972e).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.f1972e).beforeTextChanged(charSequence, i2, i3, i4);
        }

        final void c() {
            this.f1973f.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            if (this.f1973f.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1972e).onSpanAdded(spannable, obj, i2, i3);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            if (this.f1973f.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    int i8 = i2 > i3 ? 0 : i2;
                    if (i4 > i5) {
                        i6 = i8;
                        i7 = 0;
                    } else {
                        i7 = i4;
                        i6 = i8;
                    }
                } else {
                    i6 = i2;
                    i7 = i4;
                }
                ((SpanWatcher) this.f1972e).onSpanChanged(spannable, obj, i6, i3, i7, i5);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            if (this.f1973f.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f1972e).onSpanRemoved(spannable, obj, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.f1972e).onTextChanged(charSequence, i2, i3, i4);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        super(charSequence);
        this.f1971f = new ArrayList();
        androidx.core.util.h.g(cls, "watcherClass cannot be null");
        this.f1970e = cls;
    }

    private void b() {
        for (int i2 = 0; i2 < this.f1971f.size(); i2++) {
            this.f1971f.get(i2).a();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static l c(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new l(cls, charSequence);
    }

    private void e() {
        for (int i2 = 0; i2 < this.f1971f.size(); i2++) {
            this.f1971f.get(i2).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i2 = 0; i2 < this.f1971f.size(); i2++) {
            a aVar = this.f1971f.get(i2);
            if (aVar.f1972e == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(@NonNull Class<?> cls) {
        return this.f1970e == cls;
    }

    private boolean h(@Nullable Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i2 = 0; i2 < this.f1971f.size(); i2++) {
            this.f1971f.get(i2).c();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a() {
        b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(@Nullable Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(@Nullable Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(@Nullable Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i2, int i3, @NonNull Class<T> cls) {
        if (!g(cls)) {
            return (T[]) super.getSpans(i2, i3, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i2, i3, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            tArr[i4] = aVarArr[i4].f1972e;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i2, int i3, @Nullable Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(@Nullable Object obj) {
        a aVarF;
        if (h(obj)) {
            aVarF = f(obj);
            if (aVarF != null) {
                obj = aVarF;
            }
        } else {
            aVarF = null;
        }
        super.removeSpan(obj);
        if (aVarF != null) {
            this.f1971f.remove(aVarF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(@Nullable Object obj, int i2, int i3, int i4) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f1971f.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i2, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i2, int i3) {
        return new l(this.f1970e, this, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence) {
        b();
        super.replace(i2, i3, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(@NonNull Class<?> cls, @NonNull CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
        this.f1971f = new ArrayList();
        androidx.core.util.h.g(cls, "watcherClass cannot be null");
        this.f1970e = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        b();
        super.replace(i2, i3, charSequence, i4, i5);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i2) {
        super.append(charSequence, obj, i2);
        return this;
    }
}
