package com.sfyvctwaqbjhki.uwmpqfh.lebktch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AnimatedExpandableListView extends ExpandableListView {
    private static final int ANIMATION_DURATION = 300;
    private static final String TAG = AnimatedExpandableListAdapter.class.getSimpleName();
    private AnimatedExpandableListAdapter adapter;
    private int groupPos;

    public static abstract class AnimatedExpandableListAdapter extends BaseExpandableListAdapter {
        private static final int STATE_COLLAPSING = 2;
        private static final int STATE_EXPANDING = 1;
        private static final int STATE_IDLE = 0;
        private SparseArray<GroupInfo> groupInfo = new SparseArray<>();
        private AnimatedExpandableListView parent;

        private GroupInfo getGroupInfo(int i2) {
            GroupInfo groupInfo = this.groupInfo.get(i2);
            if (groupInfo != null) {
                return groupInfo;
            }
            GroupInfo groupInfo2 = new GroupInfo();
            this.groupInfo.put(i2, groupInfo2);
            return groupInfo2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(AnimatedExpandableListView animatedExpandableListView) {
            this.parent = animatedExpandableListView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startCollapseAnimation(int i2, int i3) {
            GroupInfo groupInfo = getGroupInfo(i2);
            groupInfo.animating = true;
            groupInfo.firstChildPosition = i3;
            groupInfo.expanding = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startExpandAnimation(int i2, int i3) {
            GroupInfo groupInfo = getGroupInfo(i2);
            groupInfo.animating = true;
            groupInfo.firstChildPosition = i3;
            groupInfo.expanding = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopAnimation(int i2) {
            getGroupInfo(i2).animating = false;
        }

        protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
            return new AbsListView.LayoutParams(-1, -2, 0);
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public final int getChildType(int i2, int i3) {
            if (getGroupInfo(i2).animating) {
                return 0;
            }
            return getRealChildType(i2, i3) + 1;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public final int getChildTypeCount() {
            return getRealChildTypeCount() + 1;
        }

        @Override // android.widget.ExpandableListAdapter
        public final View getChildView(final int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
            int i4;
            int i5;
            final GroupInfo groupInfo = getGroupInfo(i2);
            if (!groupInfo.animating) {
                return getRealChildView(i2, i3, z2, view, viewGroup);
            }
            View dummyView = view;
            if (!(dummyView instanceof DummyView)) {
                dummyView = new DummyView(viewGroup.getContext());
                dummyView.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            }
            View view2 = dummyView;
            if (i3 < groupInfo.firstChildPosition) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final DummyView dummyView2 = (DummyView) view2;
            dummyView2.clearViews();
            dummyView2.setDivider(expandableListView.getDivider(), viewGroup.getMeasuredWidth(), expandableListView.getDividerHeight());
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int height = viewGroup.getHeight();
            int realChildrenCount = getRealChildrenCount(i2);
            int i6 = groupInfo.firstChildPosition;
            int i7 = 0;
            while (true) {
                if (i6 >= realChildrenCount) {
                    i4 = 1;
                    i5 = i7;
                    break;
                }
                i4 = 1;
                int i8 = i6;
                int i9 = realChildrenCount;
                int i10 = height;
                View realChildView = getRealChildView(i2, i6, i6 == realChildrenCount + (-1), null, viewGroup);
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) realChildView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
                    realChildView.setLayoutParams(layoutParams);
                }
                int i11 = layoutParams.height;
                realChildView.measure(iMakeMeasureSpec, i11 > 0 ? View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : iMakeMeasureSpec2);
                int measuredHeight = i7 + realChildView.getMeasuredHeight();
                if (measuredHeight >= i10) {
                    dummyView2.addFakeView(realChildView);
                    i5 = measuredHeight + (((i9 - i8) - 1) * (measuredHeight / (i8 + 1)));
                    break;
                }
                dummyView2.addFakeView(realChildView);
                i6 = i8 + 1;
                i7 = measuredHeight;
                height = i10;
                realChildrenCount = i9;
            }
            Object tag = dummyView2.getTag();
            int iIntValue = tag == null ? 0 : ((Integer) tag).intValue();
            boolean z3 = groupInfo.expanding;
            if (z3 && iIntValue != i4) {
                ExpandAnimation expandAnimation = new ExpandAnimation(dummyView2, 0, i5, groupInfo);
                expandAnimation.setDuration(this.parent.getAnimationDuration());
                expandAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.lebktch.AnimatedExpandableListView.AnimatedExpandableListAdapter.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AnimatedExpandableListAdapter.this.stopAnimation(i2);
                        AnimatedExpandableListAdapter.this.notifyDataSetChanged();
                        dummyView2.setTag(0);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                dummyView2.startAnimation(expandAnimation);
                dummyView2.setTag(Integer.valueOf(i4));
            } else if (!z3 && iIntValue != 2) {
                if (groupInfo.dummyHeight == -1) {
                    groupInfo.dummyHeight = i5;
                }
                ExpandAnimation expandAnimation2 = new ExpandAnimation(dummyView2, groupInfo.dummyHeight, 0, groupInfo);
                expandAnimation2.setDuration(this.parent.getAnimationDuration());
                expandAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.lebktch.AnimatedExpandableListView.AnimatedExpandableListAdapter.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AnimatedExpandableListAdapter.this.stopAnimation(i2);
                        expandableListView.collapseGroup(i2);
                        AnimatedExpandableListAdapter.this.notifyDataSetChanged();
                        groupInfo.dummyHeight = -1;
                        dummyView2.setTag(0);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                dummyView2.startAnimation(expandAnimation2);
                dummyView2.setTag(2);
            }
            return view2;
        }

        @Override // android.widget.ExpandableListAdapter
        public final int getChildrenCount(int i2) {
            GroupInfo groupInfo = getGroupInfo(i2);
            return groupInfo.animating ? groupInfo.firstChildPosition + 1 : getRealChildrenCount(i2);
        }

        public int getRealChildType(int i2, int i3) {
            return 0;
        }

        public int getRealChildTypeCount() {
            return 1;
        }

        public abstract View getRealChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup);

        public abstract int getRealChildrenCount(int i2);

        public void notifyGroupExpanded(int i2) {
            getGroupInfo(i2).dummyHeight = -1;
        }
    }

    private static class DummyView extends View {
        private Drawable divider;
        private int dividerHeight;
        private int dividerWidth;
        private List<View> views;

        public DummyView(Context context) {
            super(context);
            this.views = new ArrayList();
        }

        public void addFakeView(View view) {
            view.layout(0, 0, getWidth(), view.getMeasuredHeight());
            this.views.add(view);
        }

        public void clearViews() {
            this.views.clear();
        }

        @Override // android.view.View
        public void dispatchDraw(Canvas canvas) {
            canvas.save();
            Drawable drawable = this.divider;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.dividerWidth, this.dividerHeight);
            }
            int size = this.views.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.views.get(i2);
                canvas.save();
                canvas.clipRect(0, 0, getWidth(), view.getMeasuredHeight());
                view.draw(canvas);
                canvas.restore();
                Drawable drawable2 = this.divider;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                    canvas.translate(0.0f, this.dividerHeight);
                }
                canvas.translate(0.0f, view.getMeasuredHeight());
            }
            canvas.restore();
        }

        @Override // android.view.View
        protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            int size = this.views.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = this.views.get(i6);
                view.layout(i2, i3, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + i3);
            }
        }

        public void setDivider(Drawable drawable, int i2, int i3) {
            if (drawable != null) {
                this.divider = drawable;
                this.dividerWidth = i2;
                this.dividerHeight = i3;
                drawable.setBounds(0, 0, i2, i3);
            }
        }
    }

    private static class ExpandAnimation extends Animation {
        private int baseHeight;
        private int delta;
        private GroupInfo groupInfo;
        private View view;

        private ExpandAnimation(View view, int i2, int i3, GroupInfo groupInfo) {
            this.baseHeight = i2;
            this.delta = i3 - i2;
            this.view = view;
            this.groupInfo = groupInfo;
            view.getLayoutParams().height = i2;
            this.view.requestLayout();
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            if (f2 < 1.0f) {
                int i2 = this.baseHeight + ((int) (this.delta * f2));
                this.view.getLayoutParams().height = i2;
                this.groupInfo.dummyHeight = i2;
                this.view.requestLayout();
                return;
            }
            int i3 = this.baseHeight + this.delta;
            this.view.getLayoutParams().height = i3;
            this.groupInfo.dummyHeight = i3;
            this.view.requestLayout();
        }
    }

    private static class GroupInfo {
        boolean animating;
        int dummyHeight;
        boolean expanding;
        int firstChildPosition;

        private GroupInfo() {
            this.animating = false;
            this.expanding = false;
            this.dummyHeight = -1;
        }
    }

    public AnimatedExpandableListView(Context context) {
        super(context);
        this.groupPos = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAnimationDuration() {
        return ANIMATION_DURATION;
    }

    public boolean collapseGroupWithAnimation(int i2) {
        int flatListPosition = getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i2));
        if (flatListPosition != -1) {
            int firstVisiblePosition = flatListPosition - getFirstVisiblePosition();
            if (firstVisiblePosition < 0 || firstVisiblePosition >= getChildCount()) {
                return collapseGroup(i2);
            }
            View childAt = getChildAt(firstVisiblePosition);
            if (childAt != null && childAt.getBottom() >= getBottom()) {
                return collapseGroup(i2);
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
        if (packedPositionChild == -1 || packedPositionGroup != i2) {
            packedPositionChild = 0;
        }
        this.adapter.startCollapseAnimation(i2, packedPositionChild);
        this.adapter.notifyDataSetChanged();
        return isGroupExpanded(i2);
    }

    public void collapseLastGroup() {
        int i2 = this.groupPos;
        if (i2 != -1) {
            collapseGroup(i2);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean expandGroupWithAnimation(int i2) {
        int firstVisiblePosition;
        View childAt;
        int i3 = this.groupPos;
        if (i3 != -1) {
            collapseGroupWithAnimation(i3);
        }
        this.groupPos = i2;
        int flatListPosition = getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i2));
        if (flatListPosition == -1 || (firstVisiblePosition = flatListPosition - getFirstVisiblePosition()) >= getChildCount() || (childAt = getChildAt(firstVisiblePosition)) == null || childAt.getBottom() < getBottom()) {
            this.adapter.startExpandAnimation(i2, 0);
            return expandGroup(i2);
        }
        this.adapter.notifyGroupExpanded(i2);
        return expandGroup(i2);
    }

    @Override // android.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof AnimatedExpandableListAdapter) {
            AnimatedExpandableListAdapter animatedExpandableListAdapter = (AnimatedExpandableListAdapter) expandableListAdapter;
            this.adapter = animatedExpandableListAdapter;
            animatedExpandableListAdapter.setParent(this);
        } else {
            throw new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
        }
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.groupPos = -1;
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.groupPos = -1;
    }
}
