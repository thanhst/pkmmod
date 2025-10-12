package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.JwpHqftVBZs;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.CustomListView;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BaWsrZQ extends NNXOHlAajkUISY {
    private final String LIST_RECHARGE_HISTORY;
    private int mAppId;
    private String mLastTime;
    private OrderHistoryAdapter mOrderListAdapter;
    private List<JwpHqftVBZs> mRechargeHistorys;
    private int mUserId;
    private CustomListView vHistiryLv;

    class OrderHistoryAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private final String TXT_CHARGE_NUM = "txt_charge_num";
        private final String TXT_CHARGE_WAY = "txt_charge_way";
        private final String TXT_ORDER_NUM = "txt_order_num";
        private final String TXT_ORDER_STATUS = "txt_order_status";
        private final String TXT_RECHARGE_TIME = "txt_recharge_time";
        private final String IMG_ORDER_STATUS = "img_order_status";

        public final class ViewHolder {
            public TextView amountTv;
            public TextView chargingTypeTv;
            public TextView clientDateTv;
            public TextView orderTv;
            public ImageView statusIv;
            public TextView statusTv;

            public ViewHolder() {
            }
        }

        public OrderHistoryAdapter(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return BaWsrZQ.this.mRechargeHistorys.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return BaWsrZQ.this.mRechargeHistorys.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View viewInflate;
            ViewHolder viewHolder;
            Context context;
            int i3;
            JwpHqftVBZs jwpHqftVBZs = (JwpHqftVBZs) BaWsrZQ.this.mRechargeHistorys.get(i2);
            if (view == null) {
                viewHolder = new ViewHolder();
                viewInflate = this.mInflater.inflate(R.layout.cg_charge_history_item, (ViewGroup) null);
                viewHolder.amountTv = (TextView) viewInflate.findViewById(R.id.txt_charge_num);
                viewHolder.chargingTypeTv = (TextView) viewInflate.findViewById(R.id.txt_charge_way);
                viewHolder.orderTv = (TextView) viewInflate.findViewById(R.id.txt_order_num);
                viewHolder.statusTv = (TextView) viewInflate.findViewById(R.id.txt_order_status);
                viewHolder.clientDateTv = (TextView) viewInflate.findViewById(R.id.txt_recharge_time);
                viewHolder.statusIv = (ImageView) viewInflate.findViewById(R.id.img_order_status);
                viewInflate.setTag(viewHolder);
            } else {
                viewInflate = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jwpHqftVBZs.getAmount().equals("null") ? "0" : jwpHqftVBZs.getAmount());
            stringBuffer.append((jwpHqftVBZs.getCurrency() == null || jwpHqftVBZs.getCurrency().equals("null")) ? "" : jwpHqftVBZs.getCurrency());
            viewHolder.amountTv.setText(stringBuffer.toString());
            TextView textView = viewHolder.chargingTypeTv;
            if (jwpHqftVBZs.getChannel() == 1) {
                context = this.mContext;
                i3 = R.string.txt_official;
            } else {
                context = this.mContext;
                i3 = R.string.txt_other_way;
            }
            textView.setText(context.getString(i3));
            viewHolder.orderTv.setText(jwpHqftVBZs.getTransactionId());
            viewHolder.clientDateTv.setText(jwpHqftVBZs.getClientTime());
            if (jwpHqftVBZs.getStatus() == 200) {
                viewHolder.statusIv.setImageResource(R.drawable.order_status_success);
                viewHolder.statusTv.setTextColor(-16711936);
            } else if (jwpHqftVBZs.getStatus() == 3003) {
                viewHolder.statusIv.setImageResource(R.drawable.order_status_pending);
                viewHolder.statusTv.setTextColor(Color.argb(255, 237, 177, 16));
            } else {
                viewHolder.statusIv.setImageResource(R.drawable.order_status_fail);
                viewHolder.statusTv.setTextColor(-65536);
            }
            viewHolder.statusTv.setText(this.mContext.getString(ErrorUtil.getIdByCode(jwpHqftVBZs.getStatus())));
            return viewInflate;
        }
    }

    public BaWsrZQ(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.LIST_RECHARGE_HISTORY = "list_recharge_history";
    }

    private void changeTitle() {
        ((SYwCAo) this.activity).changeTitleName(getContext().getString(R.string.txt_recharge_history));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDataFromDBBySaveTime() {
        getOrderListFromDBAndShow(getContext().getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0).getString((this.mUserId + this.mAppId) + "orderLastUpdateTime", "''"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrderListFromDBAndShow(String str) {
        ArrayList<JwpHqftVBZs> arrayListQueryTenOrderByTime = PBvElADcPX.queryTenOrderByTime(this.mAppId, this.mUserId, str);
        if (arrayListQueryTenOrderByTime.size() < 10) {
            this.vHistiryLv.onLoadMoreComplete(0);
        } else {
            this.vHistiryLv.onLoadMoreComplete(1);
        }
        this.mRechargeHistorys.addAll(arrayListQueryTenOrderByTime);
        if (arrayListQueryTenOrderByTime.size() != 0) {
            this.mLastTime = arrayListQueryTenOrderByTime.get(arrayListQueryTenOrderByTime.size() - 1).getClientTime();
        }
        this.mOrderListAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        this.mRechargeHistorys = new ArrayList();
        this.mUserId = Response.getInstance().getUserInfo().getUserId();
        this.mAppId = Response.getInstance().getConfigBean().getAppId();
        this.mOrderListAdapter = new OrderHistoryAdapter(getContext());
        CustomListView customListView = (CustomListView) view.findViewById(R.id.list_recharge_history);
        this.vHistiryLv = customListView;
        customListView.setAdapter((BaseAdapter) this.mOrderListAdapter);
        this.vHistiryLv.setAutoLoadMore(!r4.isAutoLoadMore());
        this.vHistiryLv.setOnLoadListener(new CustomListView.OnLoadMoreListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.BaWsrZQ.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.CustomListView.OnLoadMoreListener
            public void onLoadMore() {
                BaWsrZQ baWsrZQ = BaWsrZQ.this;
                baWsrZQ.getOrderListFromDBAndShow(baWsrZQ.mLastTime);
            }
        });
        this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.BaWsrZQ.3
            @Override // java.lang.Runnable
            public void run() {
                BaWsrZQ.this.getDataFromDBBySaveTime();
                ((NNXOHlAajkUISY) BaWsrZQ.this).handler.removeCallbacks(this);
            }
        }, 500L);
        onRefresh();
    }

    public void netGetOrderList() {
        Response.getInstance().getNetParamsBean().setLastTime(getContext().getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0).getString((this.mUserId + this.mAppId) + "orderLastUpdateTime", "''"));
        MhrJWomE.netGetChargeList(new UserManager(UserManager.Type.CHARGELIST) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.BaWsrZQ.4
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                Toast.makeText(BaWsrZQ.this.getContext(), ErrorUtil.getIdByCode(i2), 0).show();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                BaWsrZQ.this.mRechargeHistorys.clear();
                BaWsrZQ.this.getDataFromDBBySaveTime();
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        initView(view);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_recharge_history, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        super.onRefresh();
        this.handler.postDelayed(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.BaWsrZQ.1
            @Override // java.lang.Runnable
            public void run() {
                BaWsrZQ.this.netGetOrderList();
                ((NNXOHlAajkUISY) BaWsrZQ.this).handler.removeCallbacks(this);
            }
        }, 500L);
        this.vHistiryLv.setSelection(0);
        changeTitle();
    }
}
