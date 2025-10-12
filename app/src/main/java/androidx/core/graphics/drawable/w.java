package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: WrappedDrawableState.java */
/* loaded from: classes.dex */
final class w extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f1521a;

    /* renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f1522b;

    /* renamed from: c, reason: collision with root package name */
    ColorStateList f1523c;

    /* renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f1524d;

    w(@Nullable w wVar) {
        this.f1523c = null;
        this.f1524d = t.f1513k;
        if (wVar != null) {
            this.f1521a = wVar.f1521a;
            this.f1522b = wVar.f1522b;
            this.f1523c = wVar.f1523c;
            this.f1524d = wVar.f1524d;
        }
    }

    boolean a() {
        return this.f1522b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i2 = this.f1521a;
        Drawable.ConstantState constantState = this.f1522b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new v(this, resources) : new t(this, resources);
    }
}
