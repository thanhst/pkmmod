package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private int f1761a;

    /* renamed from: b, reason: collision with root package name */
    private int f1762b;

    public f0(@NonNull ViewGroup viewGroup) {
    }

    public int a() {
        return this.f1761a | this.f1762b;
    }

    public void b(@NonNull View view, @NonNull View view2, int i2) {
        c(view, view2, i2, 0);
    }

    public void c(@NonNull View view, @NonNull View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f1762b = i2;
        } else {
            this.f1761a = i2;
        }
    }

    public void d(@NonNull View view, int i2) {
        if (i2 == 1) {
            this.f1762b = 0;
        } else {
            this.f1761a = 0;
        }
    }
}
