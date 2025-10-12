package com.sfyvctwaqbjhki.uwmpqfh.lebktch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class CustomListView extends ListView implements AbsListView.OnScrollListener {
    private static final String DATE_FORMAT_STR = "yyyy年MM月dd日 HH:mm";
    private static final int DONE = 3;
    private static final int ENDINT_AUTO_LOAD_DONE = 3;
    private static final int ENDINT_LOADING = 1;
    private static final int ENDINT_MANUAL_LOAD_DONE = 2;
    private static final int LOADING = 4;
    private static final int PULL_TO_REFRESH = 1;
    private static final int RATIO = 3;
    private static final int REFRESHING = 2;
    private static final int RELEASE_TO_REFRESH = 0;
    private RotateAnimation mArrowAnim;
    private ImageView mArrowImageView;
    private RotateAnimation mArrowReverseAnim;
    private boolean mCanLoadMore;
    private boolean mCanRefresh;
    private Context mContext;
    private int mCount;
    private ProgressBar mEndLoadProgressBar;
    private TextView mEndLoadTipsTextView;
    private View mEndRootView;
    private int mEndState;
    private int mFirstItemIndex;
    private int mHeadState;
    private LinearLayout mHeadView;
    private int mHeadViewHeight;
    private int mHeadViewWidth;
    private LayoutInflater mInflater;
    private boolean mIsAutoLoadMore;
    private boolean mIsBack;
    private boolean mIsMoveToFirstItemAfterRefresh;
    private boolean mIsRecored;
    private int mLastItemIndex;
    private TextView mLastUpdatedTextView;
    private OnLoadMoreListener mLoadMoreListener;
    private ProgressBar mProgressBar;
    private OnRefreshListener mRefreshListener;
    private int mStartY;
    private TextView mTipsTextView;

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public CustomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanLoadMore = false;
        this.mCanRefresh = false;
        this.mIsAutoLoadMore = true;
        this.mIsMoveToFirstItemAfterRefresh = false;
        this.mContext = context;
        init(context);
    }

    private void addFooterView() {
        View viewInflate = this.mInflater.inflate(R.layout.cg_listfooter_more, (ViewGroup) null);
        this.mEndRootView = viewInflate;
        viewInflate.setVisibility(0);
        this.mEndLoadProgressBar = (ProgressBar) this.mEndRootView.findViewById(R.id.pull_to_refresh_progress);
        this.mEndLoadTipsTextView = (TextView) this.mEndRootView.findViewById(R.id.load_more);
        this.mEndRootView.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.lebktch.CustomListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CustomListView.this.mCanLoadMore) {
                    if (!CustomListView.this.mCanRefresh) {
                        if (CustomListView.this.mEndState != 1) {
                            CustomListView.this.mEndState = 1;
                            CustomListView.this.onLoadMore();
                            return;
                        }
                        return;
                    }
                    if (CustomListView.this.mEndState == 1 || CustomListView.this.mHeadState == 2) {
                        return;
                    }
                    CustomListView.this.mEndState = 1;
                    CustomListView.this.onLoadMore();
                }
            }
        });
        addFooterView(this.mEndRootView);
        if (this.mIsAutoLoadMore) {
            this.mEndState = 3;
        } else {
            this.mEndState = 2;
        }
    }

    private void addHeadView() {
        LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(R.layout.cg_list_head, (ViewGroup) null);
        this.mHeadView = linearLayout;
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.head_arrowImageView);
        this.mArrowImageView = imageView;
        imageView.setMinimumWidth(70);
        this.mArrowImageView.setMinimumHeight(50);
        this.mProgressBar = (ProgressBar) this.mHeadView.findViewById(R.id.head_progressBar);
        this.mTipsTextView = (TextView) this.mHeadView.findViewById(R.id.head_tipsTextView);
        this.mLastUpdatedTextView = (TextView) this.mHeadView.findViewById(R.id.head_lastUpdatedTextView);
        measureView(this.mHeadView);
        this.mHeadViewHeight = this.mHeadView.getMeasuredHeight();
        this.mHeadViewWidth = this.mHeadView.getMeasuredWidth();
        this.mHeadView.setPadding(0, this.mHeadViewHeight * (-1), 0, 0);
        this.mHeadView.invalidate();
        Log.v("size", "width:" + this.mHeadViewWidth + " height:" + this.mHeadViewHeight);
        addHeaderView(this.mHeadView, null, false);
        this.mHeadState = 3;
    }

    private void changeEndViewByState() {
        int i2 = this.mEndState;
        if (i2 == 1) {
            this.mEndLoadTipsTextView.setText(R.string.p2refresh_doing_end_refresh);
            this.mEndLoadTipsTextView.setVisibility(0);
            this.mEndLoadProgressBar.setVisibility(0);
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.mEndLoadTipsTextView.setText(R.string.p2refresh_end_load_more);
            this.mEndLoadTipsTextView.setVisibility(0);
            this.mEndLoadProgressBar.setVisibility(8);
            this.mEndRootView.setVisibility(0);
            return;
        }
        if (this.mCanLoadMore) {
            this.mEndLoadTipsTextView.setText(R.string.ui_pay_records_button_more);
            this.mEndLoadTipsTextView.setVisibility(0);
            this.mEndLoadProgressBar.setVisibility(8);
            this.mEndRootView.setVisibility(0);
            return;
        }
        this.mEndLoadProgressBar.setVisibility(8);
        this.mEndLoadTipsTextView.setText(R.string.ui_pay_records_button_none);
        this.mEndLoadTipsTextView.setVisibility(0);
        this.mEndRootView.setVisibility(0);
    }

    private void changeHeaderViewByState() {
        int i2 = this.mHeadState;
        if (i2 == 0) {
            this.mArrowImageView.setVisibility(0);
            this.mProgressBar.setVisibility(8);
            this.mTipsTextView.setVisibility(0);
            this.mLastUpdatedTextView.setVisibility(0);
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mArrowAnim);
            this.mTipsTextView.setText(R.string.p2refresh_release_refresh);
            return;
        }
        if (i2 == 1) {
            this.mProgressBar.setVisibility(8);
            this.mTipsTextView.setVisibility(0);
            this.mLastUpdatedTextView.setVisibility(0);
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.setVisibility(0);
            if (!this.mIsBack) {
                this.mTipsTextView.setText(R.string.p2refresh_pull_to_refresh);
                return;
            }
            this.mIsBack = false;
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mArrowReverseAnim);
            this.mTipsTextView.setText(R.string.p2refresh_pull_to_refresh);
            return;
        }
        if (i2 == 2) {
            this.mHeadView.setPadding(0, 0, 0, 0);
            this.mProgressBar.setVisibility(0);
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.setVisibility(8);
            this.mTipsTextView.setText(R.string.p2refresh_doing_head_refresh);
            this.mLastUpdatedTextView.setVisibility(0);
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.mHeadView.setPadding(0, this.mHeadViewHeight * (-1), 0, 0);
        this.mProgressBar.setVisibility(8);
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.setImageResource(R.drawable.arrow);
        this.mTipsTextView.setText(R.string.p2refresh_pull_to_refresh);
        this.mLastUpdatedTextView.setVisibility(0);
    }

    private void init(Context context) {
        setCacheColorHint(context.getResources().getColor(R.color.cg_trancelucent));
        this.mInflater = LayoutInflater.from(context);
        addHeadView();
        setOnScrollListener(this);
        initPullImageAnimation(0);
    }

    private void initPullImageAnimation(int i2) {
        if (i2 <= 0) {
            i2 = 250;
        }
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mArrowAnim = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        long j2 = i2;
        this.mArrowAnim.setDuration(j2);
        this.mArrowAnim.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mArrowReverseAnim = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        this.mArrowReverseAnim.setDuration(j2);
        this.mArrowReverseAnim.setFillAfter(true);
    }

    private void measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        view.measure(childMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadMore() {
        if (this.mLoadMoreListener != null) {
            this.mEndLoadTipsTextView.setText(R.string.p2refresh_doing_end_refresh);
            this.mEndLoadTipsTextView.setVisibility(0);
            this.mEndLoadProgressBar.setVisibility(0);
            this.mLoadMoreListener.onLoadMore();
        }
    }

    private void onRefresh() {
        OnRefreshListener onRefreshListener = this.mRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onRefresh();
        }
    }

    public boolean isAutoLoadMore() {
        return this.mIsAutoLoadMore;
    }

    public boolean isCanLoadMore() {
        return this.mCanLoadMore;
    }

    public boolean isCanRefresh() {
        return this.mCanRefresh;
    }

    public boolean isMoveToFirstItemAfterRefresh() {
        return this.mIsMoveToFirstItemAfterRefresh;
    }

    public void onLoadMoreComplete(int i2) {
        if (this.mIsAutoLoadMore) {
            this.mEndState = 3;
        } else {
            this.mEndState = 2;
        }
        if (i2 == 0) {
            this.mCanLoadMore = false;
        } else {
            this.mCanLoadMore = true;
        }
        changeEndViewByState();
    }

    public void onRefreshComplete() {
        if (this.mIsMoveToFirstItemAfterRefresh) {
            setSelection(0);
        }
        this.mHeadState = 3;
        this.mLastUpdatedTextView.setText(getResources().getString(R.string.p2refresh_refresh_lasttime) + new SimpleDateFormat(DATE_FORMAT_STR, Locale.CHINA).format(new Date()));
        changeHeaderViewByState();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.mFirstItemIndex = i2;
        this.mLastItemIndex = (i2 + i3) - 2;
        this.mCount = i4 - 2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (!this.mCanLoadMore) {
            View view = this.mEndRootView;
            if (view != null) {
                view.getVisibility();
                return;
            }
            return;
        }
        if (this.mLastItemIndex == this.mCount && i2 == 0 && this.mEndState != 1) {
            if (!this.mIsAutoLoadMore) {
                this.mEndState = 2;
                changeEndViewByState();
            } else if (!this.mCanRefresh) {
                this.mEndState = 1;
                onLoadMore();
                changeEndViewByState();
            } else if (this.mHeadState != 2) {
                this.mEndState = 1;
                onLoadMore();
                changeEndViewByState();
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCanRefresh) {
            if (this.mCanLoadMore && this.mEndState == 1) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                System.out.println("down.........");
                if (this.mFirstItemIndex == 0 && !this.mIsRecored) {
                    this.mIsRecored = true;
                    this.mStartY = (int) motionEvent.getY();
                }
            } else if (action == 1) {
                System.out.println("up.........");
                int i2 = this.mHeadState;
                if (i2 != 2 && i2 != 4) {
                    if (i2 == 1) {
                        this.mHeadState = 3;
                        changeHeaderViewByState();
                    }
                    if (this.mHeadState == 0) {
                        this.mHeadState = 2;
                        changeHeaderViewByState();
                        onRefresh();
                    }
                }
                this.mIsRecored = false;
                this.mIsBack = false;
            } else if (action == 2) {
                System.out.println("move.........");
                int y2 = (int) motionEvent.getY();
                if (!this.mIsRecored && this.mFirstItemIndex == 0) {
                    this.mIsRecored = true;
                    this.mStartY = y2;
                }
                int i3 = this.mHeadState;
                if (i3 != 2 && this.mIsRecored && i3 != 4) {
                    if (i3 == 0) {
                        setSelection(0);
                        int i4 = this.mStartY;
                        if ((y2 - i4) / 3 < this.mHeadViewHeight && y2 - i4 > 0) {
                            this.mHeadState = 1;
                            changeHeaderViewByState();
                        } else if (y2 - i4 <= 0) {
                            this.mHeadState = 3;
                            changeHeaderViewByState();
                        }
                    }
                    if (this.mHeadState == 1) {
                        setSelection(0);
                        int i5 = this.mStartY;
                        if ((y2 - i5) / 3 >= this.mHeadViewHeight) {
                            this.mHeadState = 0;
                            this.mIsBack = true;
                            changeHeaderViewByState();
                        } else if (y2 - i5 <= 0) {
                            this.mHeadState = 3;
                            changeHeaderViewByState();
                        }
                    }
                    if (this.mHeadState == 3 && y2 - this.mStartY > 0) {
                        this.mHeadState = 1;
                        changeHeaderViewByState();
                    }
                    if (this.mHeadState == 1) {
                        this.mHeadView.setPadding(0, (this.mHeadViewHeight * (-1)) + ((y2 - this.mStartY) / 3), 0, 0);
                    }
                    if (this.mHeadState == 0) {
                        this.mHeadView.setPadding(0, ((y2 - this.mStartY) / 3) - this.mHeadViewHeight, 0, 0);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.mLastUpdatedTextView.setText(getResources().getString(R.string.p2refresh_refresh_lasttime) + new SimpleDateFormat(DATE_FORMAT_STR, Locale.CHINA).format(new Date()));
        super.setAdapter((ListAdapter) baseAdapter);
    }

    public void setAutoLoadMore(boolean z2) {
        this.mIsAutoLoadMore = z2;
    }

    public void setCanLoadMore(boolean z2) {
        this.mCanLoadMore = z2;
        if (z2 && getFooterViewsCount() == 0) {
            addFooterView();
        }
    }

    public void setCanRefresh(boolean z2) {
        this.mCanRefresh = z2;
    }

    public void setMoveToFirstItemAfterRefresh(boolean z2) {
        this.mIsMoveToFirstItemAfterRefresh = z2;
    }

    public void setOnLoadListener(OnLoadMoreListener onLoadMoreListener) {
        if (onLoadMoreListener != null) {
            this.mLoadMoreListener = onLoadMoreListener;
            this.mCanLoadMore = true;
            if (getFooterViewsCount() == 0) {
                addFooterView();
            }
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        if (onRefreshListener != null) {
            this.mRefreshListener = onRefreshListener;
            this.mCanRefresh = true;
        }
    }

    public CustomListView(Context context) {
        super(context);
        this.mCanLoadMore = false;
        this.mCanRefresh = false;
        this.mIsAutoLoadMore = true;
        this.mIsMoveToFirstItemAfterRefresh = false;
        init(context);
    }

    public CustomListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCanLoadMore = false;
        this.mCanRefresh = false;
        this.mIsAutoLoadMore = true;
        this.mIsMoveToFirstItemAfterRefresh = false;
        init(context);
    }
}
