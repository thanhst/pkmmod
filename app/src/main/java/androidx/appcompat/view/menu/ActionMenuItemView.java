package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.p1;
import androidx.appcompat.widget.p2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionMenuItemView extends c1 implements l.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: l, reason: collision with root package name */
    g f397l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f398m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f399n;

    /* renamed from: o, reason: collision with root package name */
    e.b f400o;

    /* renamed from: p, reason: collision with root package name */
    private p1 f401p;

    /* renamed from: q, reason: collision with root package name */
    b f402q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f403r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f404s;

    /* renamed from: t, reason: collision with root package name */
    private int f405t;

    /* renamed from: u, reason: collision with root package name */
    private int f406u;

    /* renamed from: v, reason: collision with root package name */
    private int f407v;

    private class a extends p1 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.p1
        public n b() {
            b bVar = ActionMenuItemView.this.f402q;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.p1
        protected boolean c() {
            n nVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f400o;
            return bVar != null && bVar.a(actionMenuItemView.f397l) && (nVarB = b()) != null && nVarB.b();
        }
    }

    public static abstract class b {
        public abstract n a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void t() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f398m);
        if (this.f399n != null && (!this.f397l.B() || (!this.f403r && !this.f404s))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        setText(z4 ? this.f398m : null);
        CharSequence contentDescription = this.f397l.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z4 ? null : this.f397l.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f397l.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            p2.a(this, z4 ? null : this.f397l.getTitle());
        } else {
            p2.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean a() {
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return r();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return r() && this.f397l.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void d(g gVar, int i2) {
        this.f397l = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f401p == null) {
            this.f401p = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.l.a
    public g getItemData() {
        return this.f397l;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f400o;
        if (bVar != null) {
            bVar.a(this.f397l);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f403r = s();
        t();
    }

    @Override // androidx.appcompat.widget.c1, android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        boolean zR = r();
        if (zR && (i4 = this.f406u) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f405t) : this.f405t;
        if (mode != 1073741824 && this.f405t > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (zR || this.f399n == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f399n.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p1 p1Var;
        if (this.f397l.hasSubMenu() && (p1Var = this.f401p) != null && p1Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f404s != z2) {
            this.f404s = z2;
            g gVar = this.f397l;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f399n = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.f407v;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        t();
    }

    public void setItemInvoker(e.b bVar) {
        this.f400o = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f406u = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f402q = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f398m = charSequence;
        t();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f403r = s();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i2, 0);
        this.f405t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f407v = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f406u = -1;
        setSaveEnabled(false);
    }
}
