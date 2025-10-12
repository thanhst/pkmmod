package com.sfyvctwaqbjhki.uwmpqfh.lebktch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes.dex */
public class ListViewForScrollView extends ListView {
    private boolean isOnMeasure;

    public ListViewForScrollView(Context context) {
        super(context);
    }

    public boolean isInMeasure() {
        return this.isOnMeasure;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.isOnMeasure = false;
        super.onLayout(z2, i2, i3, i4, i5);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Target.SIZE_ORIGINAL);
        this.isOnMeasure = true;
        super.onMeasure(i2, iMakeMeasureSpec);
    }

    public ListViewForScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewForScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
