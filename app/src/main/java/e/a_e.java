package e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.z1;
import androidx.core.content.ContextCompat;

/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a_e {
    public static ColorStateList a(@NonNull Context context, @ColorRes int i2) {
        return ContextCompat.c(context, i2);
    }

    @Nullable
    public static Drawable b(@NonNull Context context, @DrawableRes int i2) {
        return z1.h().j(context, i2);
    }
}
