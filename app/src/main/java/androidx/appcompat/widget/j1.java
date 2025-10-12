package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.k;

/* compiled from: DecorContentParent.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface j1 {
    void a(Menu menu, k.a aVar);

    boolean b();

    void c();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    void k(int i2);

    void l();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
