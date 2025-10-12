package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.y2;
import androidx.core.view.z2;
import com.bumptech.glide.request.target.Target;

/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
abstract class a extends ViewGroup {

    /* renamed from: e, reason: collision with root package name */
    protected final C0007a f827e;

    /* renamed from: f, reason: collision with root package name */
    protected final Context f828f;

    /* renamed from: g, reason: collision with root package name */
    protected ActionMenuView f829g;

    /* renamed from: h, reason: collision with root package name */
    protected c f830h;

    /* renamed from: i, reason: collision with root package name */
    protected int f831i;

    /* renamed from: j, reason: collision with root package name */
    protected y2 f832j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f833k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f834l;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0007a implements z2 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f835a = false;

        /* renamed from: b, reason: collision with root package name */
        int f836b;

        protected C0007a() {
        }

        @Override // androidx.core.view.z2
        public void a(View view) {
            this.f835a = true;
        }

        @Override // androidx.core.view.z2
        public void b(View view) {
            if (this.f835a) {
                return;
            }
            a aVar = a.this;
            aVar.f832j = null;
            a.super.setVisibility(this.f836b);
        }

        @Override // androidx.core.view.z2
        public void c(View view) {
            a.super.setVisibility(0);
            this.f835a = false;
        }

        public C0007a d(y2 y2Var, int i2) {
            a.this.f832j = y2Var;
            this.f836b = i2;
            return this;
        }
    }

    a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected static int d(int i2, int i3, boolean z2) {
        return z2 ? i2 - i3 : i2 + i3;
    }

    protected int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Target.SIZE_ORIGINAL), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    protected int e(View view, int i2, int i3, int i4, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z2) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public y2 f(int i2, long j2) {
        y2 y2Var = this.f832j;
        if (y2Var != null) {
            y2Var.c();
        }
        if (i2 != 0) {
            y2 y2VarB = ViewCompat.c(this).b(0.0f);
            y2VarB.f(j2);
            y2VarB.h(this.f827e.d(y2VarB, i2));
            return y2VarB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        y2 y2VarB2 = ViewCompat.c(this).b(1.0f);
        y2VarB2.f(j2);
        y2VarB2.h(this.f827e.d(y2VarB2, i2));
        return y2VarB2;
    }

    public int getAnimatedVisibility() {
        return this.f832j != null ? this.f827e.f836b : getVisibility();
    }

    public int getContentHeight() {
        return this.f831i;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.f830h;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f834l = false;
        }
        if (!this.f834l) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f834l = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f834l = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f833k = false;
        }
        if (!this.f833k) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f833k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f833k = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.f831i = i2;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            y2 y2Var = this.f832j;
            if (y2Var != null) {
                y2Var.c();
            }
            super.setVisibility(i2);
        }
    }

    a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f827e = new C0007a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f828f = context;
        } else {
            this.f828f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
