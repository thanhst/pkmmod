package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

/* compiled from: TooltipPopup.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class t2 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1137a;

    /* renamed from: b, reason: collision with root package name */
    private final View f1138b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f1139c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f1140d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f1141e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f1142f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f1143g;

    t2(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1140d = layoutParams;
        this.f1141e = new Rect();
        this.f1142f = new int[2];
        this.f1143g = new int[2];
        this.f1137a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f1138b = viewInflate;
        this.f1139c = (TextView) viewInflate.findViewById(R$id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z2, WindowManager.LayoutParams layoutParams) throws Resources.NotFoundException {
        int height;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1137a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1137a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1137a.getResources().getDimensionPixelOffset(z2 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f1141e);
        Rect rect = this.f1141e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1137a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1141e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f1143g);
        view.getLocationOnScreen(this.f1142f);
        int[] iArr = this.f1142f;
        int i5 = iArr[0];
        int[] iArr2 = this.f1143g;
        int i6 = i5 - iArr2[0];
        iArr[0] = i6;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i6 + i2) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1138b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f1138b.getMeasuredHeight();
        int i7 = this.f1142f[1];
        int i8 = ((i4 + i7) - dimensionPixelOffset3) - measuredHeight;
        int i9 = i7 + height + dimensionPixelOffset3;
        if (z2) {
            if (i8 >= 0) {
                layoutParams.y = i8;
                return;
            } else {
                layoutParams.y = i9;
                return;
            }
        }
        if (measuredHeight + i9 <= this.f1141e.height()) {
            layoutParams.y = i9;
        } else {
            layoutParams.y = i8;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f1137a.getSystemService("window")).removeView(this.f1138b);
        }
    }

    boolean d() {
        return this.f1138b.getParent() != null;
    }

    void e(View view, int i2, int i3, boolean z2, CharSequence charSequence) throws Resources.NotFoundException {
        if (d()) {
            c();
        }
        this.f1139c.setText(charSequence);
        a(view, i2, i3, z2, this.f1140d);
        ((WindowManager) this.f1137a.getSystemService("window")).addView(this.f1138b, this.f1140d);
    }
}
