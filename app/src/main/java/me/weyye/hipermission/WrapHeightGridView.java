package me.weyye.hipermission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes.dex */
public class WrapHeightGridView extends GridView {

    /* renamed from: e, reason: collision with root package name */
    public boolean f4046e;

    public WrapHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f4046e = false;
        super.onLayout(z2, i2, i3, i4, i5);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i2, int i3) {
        this.f4046e = true;
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Target.SIZE_ORIGINAL));
    }
}
