package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
class s extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f1121b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f1122a;

    static {
        f1121b = Build.VERSION.SDK_INT < 21;
    }

    public s(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        k2 k2VarU = k2.u(context, attributeSet, R$styleable.PopupWindow, i2, i3);
        int i4 = R$styleable.PopupWindow_overlapAnchor;
        if (k2VarU.r(i4)) {
            b(k2VarU.a(i4, false));
        }
        setBackgroundDrawable(k2VarU.f(R$styleable.PopupWindow_android_popupBackground));
        k2VarU.v();
    }

    private void b(boolean z2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (f1121b) {
            this.f1122a = z2;
        } else {
            androidx.core.widget.w.a(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (f1121b && this.f1122a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f1121b && this.f1122a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f1121b && this.f1122a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
