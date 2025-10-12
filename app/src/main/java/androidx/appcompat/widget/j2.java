package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class j2 extends a2 {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f981b;

    public j2(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f981b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawableA = a(i2);
        Context context = this.f981b.get();
        if (drawableA != null && context != null) {
            z1.h().x(context, i2, drawableA);
        }
        return drawableA;
    }
}
