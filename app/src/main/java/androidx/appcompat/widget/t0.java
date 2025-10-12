package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
final class t0 {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private TextView f1135a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private TextClassifier f1136b;

    /* compiled from: AppCompatTextClassifierHelper.java */
    @RequiresApi(26)
    private static final class a {
        @NonNull
        @DoNotInline
        static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    t0(@NonNull TextView textView) {
        this.f1135a = (TextView) androidx.core.util.h.f(textView);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier a() {
        TextClassifier textClassifier = this.f1136b;
        return textClassifier == null ? a.a(this.f1135a) : textClassifier;
    }

    @RequiresApi(api = 26)
    public void b(@Nullable TextClassifier textClassifier) {
        this.f1136b = textClassifier;
    }
}
