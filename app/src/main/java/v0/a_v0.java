package v0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import me.weyye.hipermission.PermissionAdapter;
import me.weyye.hipermission.R$attr;
import me.weyye.hipermission.R$id;
import me.weyye.hipermission.R$layout;

/* compiled from: PermissionView.java */
/* loaded from: classes.dex */
public class a_v0 extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private TextView f4152e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f4153f;

    /* renamed from: g, reason: collision with root package name */
    private Button f4154g;

    /* renamed from: h, reason: collision with root package name */
    private GridView f4155h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f4156i;

    public a_v0(Context context) {
        this(context, null);
    }

    private ColorFilter a(int i2) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(i2), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(i2), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(i2), 0.0f, 0.0f, 0.0f, 1.0f, 1.0f});
    }

    private void b() {
        View viewInflate = View.inflate(getContext(), R$layout.dialog_request_permission, this);
        this.f4152e = (TextView) viewInflate.findViewById(R$id.tvTitle);
        this.f4156i = (LinearLayout) viewInflate.findViewById(R$id.llRoot);
        this.f4153f = (TextView) viewInflate.findViewById(R$id.tvDesc);
        this.f4154g = (Button) viewInflate.findViewById(R$id.goto_settings);
        this.f4155h = (GridView) viewInflate.findViewById(R$id.gvPermission);
    }

    public void setBtnOnClickListener(View.OnClickListener onClickListener) {
        this.f4154g.setOnClickListener(onClickListener);
    }

    public void setFilterColor(int i2) {
        if (i2 == 0) {
            return;
        }
        ((PermissionAdapter) this.f4155h.getAdapter()).a(i2);
    }

    public void setGridViewAdapter(ListAdapter listAdapter) {
        this.f4155h.setAdapter(listAdapter);
    }

    public void setGridViewColum(int i2) {
        this.f4155h.setNumColumns(i2);
    }

    public void setMsg(String str) {
        this.f4153f.setText(str);
    }

    public void setStyleId(int i2) {
        if (i2 <= 0) {
            return;
        }
        int[] iArr = {R$attr.PermissionMsgColor, R$attr.PermissionTitleColor, R$attr.PermissionItemTextColor, R$attr.PermissionButtonTextColor, R$attr.PermissionBackround, R$attr.PermissionButtonBackground, R$attr.PermissionBgFilterColor, R$attr.PermissionIconFilterColor};
        Resources.Theme themeNewTheme = getResources().newTheme();
        themeNewTheme.applyStyle(i2, true);
        TypedArray typedArrayObtainStyledAttributes = themeNewTheme.obtainStyledAttributes(iArr);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(1, 0);
        int color3 = typedArrayObtainStyledAttributes.getColor(2, 0);
        int color4 = typedArrayObtainStyledAttributes.getColor(3, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(4);
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
        int color5 = typedArrayObtainStyledAttributes.getColor(6, 0);
        int color6 = typedArrayObtainStyledAttributes.getColor(7, 0);
        if (color2 != 0) {
            this.f4152e.setTextColor(color2);
        }
        if (drawable != null) {
            if (color5 != 0) {
                drawable.setColorFilter(a(color5));
            }
            this.f4156i.setBackgroundDrawable(drawable);
        }
        if (color != 0) {
            this.f4153f.setTextColor(color);
        }
        if (color3 != 0) {
            ((PermissionAdapter) this.f4155h.getAdapter()).b(color3);
        }
        if (drawable2 != null) {
            this.f4154g.setBackgroundDrawable(drawable2);
        }
        if (color4 != 0) {
            this.f4154g.setTextColor(color4);
        }
        if (color6 != 0) {
            setFilterColor(color6);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setTitle(String str) {
        this.f4152e.setText(str);
    }

    public a_v0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a_v0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
