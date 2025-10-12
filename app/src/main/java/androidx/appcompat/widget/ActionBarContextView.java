package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.y2;
import com.bumptech.glide.request.target.Target;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f627m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f628n;

    /* renamed from: o, reason: collision with root package name */
    private View f629o;

    /* renamed from: p, reason: collision with root package name */
    private View f630p;

    /* renamed from: q, reason: collision with root package name */
    private View f631q;

    /* renamed from: r, reason: collision with root package name */
    private LinearLayout f632r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f633s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f634t;

    /* renamed from: u, reason: collision with root package name */
    private int f635u;

    /* renamed from: v, reason: collision with root package name */
    private int f636v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f637w;

    /* renamed from: x, reason: collision with root package name */
    private int f638x;

    class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f639e;

        a(androidx.appcompat.view.b bVar) {
            this.f639e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f639e.c();
        }
    }

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f632r == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f632r = linearLayout;
            this.f633s = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f634t = (TextView) this.f632r.findViewById(R$id.action_bar_subtitle);
            if (this.f635u != 0) {
                this.f633s.setTextAppearance(getContext(), this.f635u);
            }
            if (this.f636v != 0) {
                this.f634t.setTextAppearance(getContext(), this.f636v);
            }
        }
        this.f633s.setText(this.f627m);
        this.f634t.setText(this.f628n);
        boolean z2 = !TextUtils.isEmpty(this.f627m);
        boolean z3 = !TextUtils.isEmpty(this.f628n);
        int i2 = 0;
        this.f634t.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = this.f632r;
        if (!z2 && !z3) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.f632r.getParent() == null) {
            addView(this.f632r);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ y2 f(int i2, long j2) {
        return super.f(i2, j2);
    }

    public void g() {
        if (this.f629o == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f628n;
    }

    public CharSequence getTitle() {
        return this.f627m;
    }

    public void h(androidx.appcompat.view.b bVar) {
        View view = this.f629o;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f638x, (ViewGroup) this, false);
            this.f629o = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f629o);
        }
        View viewFindViewById = this.f629o.findViewById(R$id.action_mode_close_button);
        this.f630p = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.e();
        c cVar = this.f830h;
        if (cVar != null) {
            cVar.y();
        }
        c cVar2 = new c(getContext());
        this.f830h = cVar2;
        cVar2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f830h, this.f828f);
        ActionMenuView actionMenuView = (ActionMenuView) this.f830h.o(this);
        this.f829g = actionMenuView;
        ViewCompat.R(actionMenuView, null);
        addView(this.f829g, layoutParams);
    }

    public boolean j() {
        return this.f637w;
    }

    public void k() {
        removeAllViews();
        this.f631q = null;
        this.f829g = null;
        this.f830h = null;
        View view = this.f630p;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        c cVar = this.f830h;
        if (cVar != null) {
            return cVar.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f830h;
        if (cVar != null) {
            cVar.B();
            this.f830h.C();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean zB = v2.b(this);
        int paddingRight = zB ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f629o;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f629o.getLayoutParams();
            int i6 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = androidx.appcompat.widget.a.d(paddingRight, i6, zB);
            paddingRight = androidx.appcompat.widget.a.d(iD + e(this.f629o, iD, paddingTop, paddingTop2, zB), i7, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f632r;
        if (linearLayout != null && this.f631q == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f632r, iE, paddingTop, paddingTop2, zB);
        }
        int i8 = iE;
        View view2 = this.f631q;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f829g;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f831i;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Target.SIZE_ORIGINAL);
        View view = this.f629o;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f629o.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f829g;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f829g, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f632r;
        if (linearLayout != null && this.f631q == null) {
            if (this.f637w) {
                this.f632r.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f632r.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.f632r.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f631q;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Target.SIZE_ORIGINAL;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            int i7 = i6 == -2 ? Target.SIZE_ORIGINAL : 1073741824;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f631q.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i7));
        }
        if (this.f831i > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i2) {
        this.f831i = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f631q;
        if (view2 != null) {
            removeView(view2);
        }
        this.f631q = view;
        if (view != null && (linearLayout = this.f632r) != null) {
            removeView(linearLayout);
            this.f632r = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f628n = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f627m = charSequence;
        i();
        ViewCompat.Q(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f637w) {
            requestLayout();
        }
        this.f637w = z2;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k2 k2VarU = k2.u(context, attributeSet, R$styleable.ActionMode, i2, 0);
        ViewCompat.R(this, k2VarU.f(R$styleable.ActionMode_background));
        this.f635u = k2VarU.m(R$styleable.ActionMode_titleTextStyle, 0);
        this.f636v = k2VarU.m(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f831i = k2VarU.l(R$styleable.ActionMode_height, 0);
        this.f638x = k2VarU.m(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        k2VarU.v();
    }
}
