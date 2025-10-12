package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: ScrollingTabContainerView.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class c2 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: n, reason: collision with root package name */
    private static final Interpolator f878n = new DecelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    Runnable f879e;

    /* renamed from: f, reason: collision with root package name */
    private c f880f;

    /* renamed from: g, reason: collision with root package name */
    LinearLayoutCompat f881g;

    /* renamed from: h, reason: collision with root package name */
    private Spinner f882h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f883i;

    /* renamed from: j, reason: collision with root package name */
    int f884j;

    /* renamed from: k, reason: collision with root package name */
    int f885k;

    /* renamed from: l, reason: collision with root package name */
    private int f886l;

    /* renamed from: m, reason: collision with root package name */
    private int f887m;

    /* compiled from: ScrollingTabContainerView.java */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f888e;

        a(View view) {
            this.f888e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            c2.this.smoothScrollTo(this.f888e.getLeft() - ((c2.this.getWidth() - this.f888e.getWidth()) / 2), 0);
            c2.this.f879e = null;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return c2.this.f881g.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((d) c2.this.f881g.getChildAt(i2)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return c2.this.c((ActionBar.c) getItem(i2), true);
            }
            ((d) view).a((ActionBar.c) getItem(i2));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = c2.this.f881g.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = c2.this.f881g.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class d extends LinearLayout {

        /* renamed from: e, reason: collision with root package name */
        private final int[] f892e;

        /* renamed from: f, reason: collision with root package name */
        private ActionBar.c f893f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f894g;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f895h;

        /* renamed from: i, reason: collision with root package name */
        private View f896i;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(Context context, ActionBar.c cVar, boolean z2) {
            int i2 = R$attr.actionBarTabStyle;
            super(context, null, i2);
            int[] iArr = {R.attr.background};
            this.f892e = iArr;
            this.f893f = cVar;
            k2 k2VarU = k2.u(context, null, iArr, i2, 0);
            if (k2VarU.r(0)) {
                setBackgroundDrawable(k2VarU.f(0));
            }
            k2VarU.v();
            if (z2) {
                setGravity(8388627);
            }
            c();
        }

        public void a(ActionBar.c cVar) {
            this.f893f = cVar;
            c();
        }

        public ActionBar.c b() {
            return this.f893f;
        }

        public void c() {
            ActionBar.c cVar = this.f893f;
            View viewB = cVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f896i = viewB;
                TextView textView = this.f894g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f895h;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f895h.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f896i;
            if (view != null) {
                removeView(view);
                this.f896i = null;
            }
            Drawable drawableC = cVar.c();
            CharSequence charSequenceD = cVar.d();
            if (drawableC != null) {
                if (this.f895h == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f895h = appCompatImageView;
                }
                this.f895h.setImageDrawable(drawableC);
                this.f895h.setVisibility(0);
            } else {
                ImageView imageView2 = this.f895h;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f895h.setImageDrawable(null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(charSequenceD);
            if (z2) {
                if (this.f894g == null) {
                    c1 c1Var = new c1(getContext(), null, R$attr.actionBarTabTextStyle);
                    c1Var.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    c1Var.setLayoutParams(layoutParams2);
                    addView(c1Var);
                    this.f894g = c1Var;
                }
                this.f894g.setText(charSequenceD);
                this.f894g.setVisibility(0);
            } else {
                TextView textView2 = this.f894g;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f894g.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f895h;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            p2.a(this, z2 ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (c2.this.f884j > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = c2.this.f884j;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (z3 && z2) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f882h;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f882h == null) {
            this.f882h = b();
        }
        removeView(this.f881g);
        addView(this.f882h, new ViewGroup.LayoutParams(-2, -1));
        if (this.f882h.getAdapter() == null) {
            this.f882h.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f879e;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f879e = null;
        }
        this.f882h.setSelection(this.f887m);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f882h);
        addView(this.f881g, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f882h.getSelectedItemPosition());
        return false;
    }

    public void a(int i2) {
        View childAt = this.f881g.getChildAt(i2);
        Runnable runnable = this.f879e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f879e = aVar;
        post(aVar);
    }

    d c(ActionBar.c cVar, boolean z2) {
        d dVar = new d(getContext(), cVar, z2);
        if (z2) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f886l));
        } else {
            dVar.setFocusable(true);
            if (this.f880f == null) {
                this.f880f = new c();
            }
            dVar.setOnClickListener(this.f880f);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f879e;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f885k = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f879e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f881g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f884j = -1;
        } else {
            if (childCount > 2) {
                this.f884j = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f884j = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f884j = Math.min(this.f884j, this.f885k);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f886l, 1073741824);
        if (!z2 && this.f883i) {
            this.f881g.measure(0, iMakeMeasureSpec);
            if (this.f881g.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f887m);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z2) {
        this.f883i = z2;
    }

    public void setContentHeight(int i2) {
        this.f886l = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f887m = i2;
        int childCount = this.f881g.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f881g.getChildAt(i3);
            boolean z2 = i3 == i2;
            childAt.setSelected(z2);
            if (z2) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f882h;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }
}
