package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: CheckedTextViewCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: CheckedTextViewCompat.java */
    @RequiresApi(16)
    private static class a {
        @Nullable
        static Drawable a(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* compiled from: CheckedTextViewCompat.java */
    @RequiresApi(21)
    /* renamed from: androidx.core.widget.b$b, reason: collision with other inner class name */
    private static class C0024b {
        static void a(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    @Nullable
    public static Drawable a(@NonNull CheckedTextView checkedTextView) {
        return a.a(checkedTextView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0024b.a(checkedTextView, colorStateList);
        } else if (checkedTextView instanceof m0) {
            ((m0) checkedTextView).setSupportCheckMarkTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0024b.b(checkedTextView, mode);
        } else if (checkedTextView instanceof m0) {
            ((m0) checkedTextView).setSupportCheckMarkTintMode(mode);
        }
    }
}
