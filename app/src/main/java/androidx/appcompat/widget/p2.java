package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: TooltipCompat.java */
/* loaded from: classes.dex */
public class p2 {

    /* compiled from: TooltipCompat.java */
    @RequiresApi(26)
    static class a {
        @DoNotInline
        static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            s2.h(view, charSequence);
        }
    }
}
