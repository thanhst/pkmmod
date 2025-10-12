package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.request.target.Target;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private boolean f617e;

    /* renamed from: f, reason: collision with root package name */
    private View f618f;

    /* renamed from: g, reason: collision with root package name */
    private View f619g;

    /* renamed from: h, reason: collision with root package name */
    private View f620h;

    /* renamed from: i, reason: collision with root package name */
    Drawable f621i;

    /* renamed from: j, reason: collision with root package name */
    Drawable f622j;

    /* renamed from: k, reason: collision with root package name */
    Drawable f623k;

    /* renamed from: l, reason: collision with root package name */
    boolean f624l;

    /* renamed from: m, reason: collision with root package name */
    boolean f625m;

    /* renamed from: n, reason: collision with root package name */
    private int f626n;

    @RequiresApi(21)
    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.R(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f621i = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f622j = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f626n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z2 = true;
        if (getId() == R$id.split_action_bar) {
            this.f624l = true;
            this.f623k = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f624l ? this.f621i != null || this.f622j != null : this.f623k != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f621i;
        if (drawable != null && drawable.isStateful()) {
            this.f621i.setState(getDrawableState());
        }
        Drawable drawable2 = this.f622j;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f622j.setState(getDrawableState());
        }
        Drawable drawable3 = this.f623k;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f623k.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f618f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f621i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f622j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f623k;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f619g = findViewById(R$id.action_bar);
        this.f620h = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f617e || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z2, i2, i3, i4, i5);
        View view = this.f618f;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.f624l) {
            Drawable drawable2 = this.f623k;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f621i != null) {
                if (this.f619g.getVisibility() == 0) {
                    this.f621i.setBounds(this.f619g.getLeft(), this.f619g.getTop(), this.f619g.getRight(), this.f619g.getBottom());
                } else {
                    View view2 = this.f620h;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f621i.setBounds(0, 0, 0, 0);
                    } else {
                        this.f621i.setBounds(this.f620h.getLeft(), this.f620h.getTop(), this.f620h.getRight(), this.f620h.getBottom());
                    }
                }
                z4 = true;
            }
            this.f625m = z5;
            if (!z5 || (drawable = this.f622j) == null) {
                z3 = z4;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.f619g == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f626n) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Target.SIZE_ORIGINAL);
        }
        super.onMeasure(i2, i3);
        if (this.f619g == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f618f;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f619g) ? a(this.f619g) : !b(this.f620h) ? a(this.f620h) : 0) + a(this.f618f), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f621i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f621i);
        }
        this.f621i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f619g;
            if (view != null) {
                this.f621i.setBounds(view.getLeft(), this.f619g.getTop(), this.f619g.getRight(), this.f619g.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f624l ? this.f621i != null || this.f622j != null : this.f623k != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f623k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f623k);
        }
        this.f623k = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f624l && (drawable2 = this.f623k) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f624l ? !(this.f621i != null || this.f622j != null) : this.f623k == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f622j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f622j);
        }
        this.f622j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f625m && (drawable2 = this.f622j) != null) {
                drawable2.setBounds(this.f618f.getLeft(), this.f618f.getTop(), this.f618f.getRight(), this.f618f.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f624l ? this.f621i != null || this.f622j != null : this.f623k != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setTabContainer(c2 c2Var) {
        View view = this.f618f;
        if (view != null) {
            removeView(view);
        }
        this.f618f = c2Var;
        if (c2Var != null) {
            addView(c2Var);
            ViewGroup.LayoutParams layoutParams = c2Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            c2Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z2) {
        this.f617e = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f621i;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f622j;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f623k;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f621i && !this.f624l) || (drawable == this.f622j && this.f625m) || ((drawable == this.f623k && this.f624l) || super.verifyDrawable(drawable));
    }
}
