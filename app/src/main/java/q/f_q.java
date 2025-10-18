package q;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: EmojiTextViewHelper.java */
/* loaded from: classes.dex */
public final class f_q {

    /* renamed from: a, reason: collision with root package name */
    private final b f4072a;

    /* compiled from: EmojiTextViewHelper.java */
    @RequiresApi(19)
    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f4073a;

        /* renamed from: b, reason: collision with root package name */
        private final d_q f4074b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4075c = true;

        a(TextView textView) {
            this.f4073a = textView;
            this.f4074b = new d_q(textView);
        }

        @NonNull
        private InputFilter[] d(@NonNull InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f4074b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f4074b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> e(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof d_q) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            return sparseArray;
        }

        @NonNull
        private InputFilter[] f(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayE = e(inputFilterArr);
            if (sparseArrayE.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayE.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArrayE.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }

        @Nullable
        private TransformationMethod h(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod instanceof h_q ? ((h_q) transformationMethod).a() : transformationMethod;
        }

        private void i() {
            this.f4073a.setFilters(a(this.f4073a.getFilters()));
        }

        @NonNull
        private TransformationMethod k(@Nullable TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h_q) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h_q(transformationMethod);
        }

        @Override // q.f.b
        @NonNull
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return !this.f4075c ? f(inputFilterArr) : d(inputFilterArr);
        }

        @Override // q.f.b
        void b(boolean z2) {
            if (z2) {
                j();
            }
        }

        @Override // q.f.b
        void c(boolean z2) {
            this.f4075c = z2;
            j();
            i();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        void g(boolean z2) {
            this.f4075c = z2;
        }

        void j() {
            this.f4073a.setTransformationMethod(l(this.f4073a.getTransformationMethod()));
        }

        @Nullable
        TransformationMethod l(@Nullable TransformationMethod transformationMethod) {
            return this.f4075c ? k(transformationMethod) : h(transformationMethod);
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    static class b {
        b() {
        }

        @NonNull
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            throw null;
        }

        void b(boolean z2) {
            throw null;
        }

        void c(boolean z2) {
            throw null;
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    @RequiresApi(19)
    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f4076a;

        c(TextView textView) {
            this.f4076a = new a(textView);
        }

        private boolean d() {
            return !EmojiCompat.h();
        }

        @Override // q.f.b
        @NonNull
        InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return d() ? inputFilterArr : this.f4076a.a(inputFilterArr);
        }

        @Override // q.f.b
        void b(boolean z2) {
            if (d()) {
                return;
            }
            this.f4076a.b(z2);
        }

        @Override // q.f.b
        void c(boolean z2) {
            if (d()) {
                this.f4076a.g(z2);
            } else {
                this.f4076a.c(z2);
            }
        }
    }

    public f_q(@NonNull TextView textView, boolean z2) {
        androidx.core.util.h.g(textView, "textView cannot be null");
        if (z2) {
            this.f4072a = new a(textView);
        } else {
            this.f4072a = new c(textView);
        }
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f4072a.a(inputFilterArr);
    }

    public void b(boolean z2) {
        this.f4072a.b(z2);
    }

    public void c(boolean z2) {
        this.f4072a.c(z2);
    }
}
