package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: e, reason: collision with root package name */
    private final int f1711e;

    /* renamed from: f, reason: collision with root package name */
    private final h f1712f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1713g;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public a(int i2, @NonNull h hVar, int i3) {
        this.f1711e = i2;
        this.f1712f = hVar;
        this.f1713g = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1711e);
        this.f1712f.G(this.f1713g, bundle);
    }
}
