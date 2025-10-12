package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.k2;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements l.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: e, reason: collision with root package name */
    private g f443e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f444f;

    /* renamed from: g, reason: collision with root package name */
    private RadioButton f445g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f446h;

    /* renamed from: i, reason: collision with root package name */
    private CheckBox f447i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f448j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f449k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f450l;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f451m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f452n;

    /* renamed from: o, reason: collision with root package name */
    private int f453o;

    /* renamed from: p, reason: collision with root package name */
    private Context f454p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f455q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f456r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f457s;

    /* renamed from: t, reason: collision with root package name */
    private LayoutInflater f458t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f459u;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private void b(View view) {
        c(view, -1);
    }

    private void c(View view, int i2) {
        LinearLayout linearLayout = this.f451m;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f447i = checkBox;
        b(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f444f = imageView;
        c(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f445g = radioButton;
        b(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f458t == null) {
            this.f458t = LayoutInflater.from(getContext());
        }
        return this.f458t;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.f449k;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean a() {
        return false;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f450l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f450l.getLayoutParams();
        rect.top += this.f450l.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void d(g gVar, int i2) {
        this.f443e = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.l.a
    public g getItemData() {
        return this.f443e;
    }

    public void h(boolean z2, char c2) {
        int i2 = (z2 && this.f443e.A()) ? 0 : 8;
        if (i2 == 0) {
            this.f448j.setText(this.f443e.h());
        }
        if (this.f448j.getVisibility() != i2) {
            this.f448j.setVisibility(i2);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.R(this, this.f452n);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f446h = textView;
        int i2 = this.f453o;
        if (i2 != -1) {
            textView.setTextAppearance(this.f454p, i2);
        }
        this.f448j = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f449k = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f456r);
        }
        this.f450l = (ImageView) findViewById(R$id.group_divider);
        this.f451m = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f444f != null && this.f455q) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f444f.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f445g == null && this.f447i == null) {
            return;
        }
        if (this.f443e.m()) {
            if (this.f445g == null) {
                g();
            }
            compoundButton = this.f445g;
            view = this.f447i;
        } else {
            if (this.f447i == null) {
                e();
            }
            compoundButton = this.f447i;
            view = this.f445g;
        }
        if (z2) {
            compoundButton.setChecked(this.f443e.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f447i;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f445g;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f443e.m()) {
            if (this.f445g == null) {
                g();
            }
            compoundButton = this.f445g;
        } else {
            if (this.f447i == null) {
                e();
            }
            compoundButton = this.f447i;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f459u = z2;
        this.f455q = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f450l;
        if (imageView != null) {
            imageView.setVisibility((this.f457s || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.f443e.z() || this.f459u;
        if (z2 || this.f455q) {
            ImageView imageView = this.f444f;
            if (imageView == null && drawable == null && !this.f455q) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f455q) {
                this.f444f.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f444f;
            if (!z2) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f444f.getVisibility() != 0) {
                this.f444f.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f446h.getVisibility() != 8) {
                this.f446h.setVisibility(8);
            }
        } else {
            this.f446h.setText(charSequence);
            if (this.f446h.getVisibility() != 0) {
                this.f446h.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        k2 k2VarU = k2.u(getContext(), attributeSet, R$styleable.MenuView, i2, 0);
        this.f452n = k2VarU.f(R$styleable.MenuView_android_itemBackground);
        this.f453o = k2VarU.m(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f455q = k2VarU.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f454p = context;
        this.f456r = k2VarU.f(R$styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f457s = typedArrayObtainStyledAttributes.hasValue(0);
        k2VarU.v();
        typedArrayObtainStyledAttributes.recycle();
    }
}
