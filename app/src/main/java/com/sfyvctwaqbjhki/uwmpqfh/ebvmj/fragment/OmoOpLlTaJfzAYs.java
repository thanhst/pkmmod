package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.BrHfvPMqyRTwQe;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SmMyRuq;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class OmoOpLlTaJfzAYs extends NNXOHlAajkUISY {
    private ProductAdapter adapter;
    private SmMyRuq layout_select_list;
    private ListView list_select;
    private Button mBuyBtn;
    private TextView mExchangeRateTv;
    private RelativeLayout mProductListLay;
    private TextView mProductTv;
    private TextView mTitleTv;
    private TextView mVirtualCoinTv;
    private RfybaJKCLilYpc selectPayChannel;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$OmoOpLlTaJfzAYs$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$OmoOpLlTaJfzAYs$Buttons = iArr;
            try {
                iArr[Buttons.BTNBUY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$OmoOpLlTaJfzAYs$Buttons[Buttons.BTNPRODUCT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$OmoOpLlTaJfzAYs$Buttons[Buttons.BTNEXCHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum Buttons {
        BTNBUY,
        BTNPRODUCT,
        BTNEXCHANGE
    }

    private class ProductAdapter extends BaseAdapter {

        class ViewHolder {
            TextView textView;

            ViewHolder() {
            }
        }

        private ProductAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (OmoOpLlTaJfzAYs.this.selectPayChannel == null) {
                return 0;
            }
            return OmoOpLlTaJfzAYs.this.selectPayChannel.getProducts().size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(((NNXOHlAajkUISY) OmoOpLlTaJfzAYs.this).activity.getContext()).inflate(R.layout.cg_product_list_item, (ViewGroup) null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.tv_product_item);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            RfybaJKCLilYpc.Products products = OmoOpLlTaJfzAYs.this.selectPayChannel.getProducts().get(i2);
            viewHolder2.textView.setText(products.getGameCoin() + products.getGameCurrency());
            return view;
        }
    }

    public OmoOpLlTaJfzAYs(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeChoose() {
        this.mProductTv.setText(this.selectPayChannel.getSelectedProduct().getGameCoin() + this.selectPayChannel.getSelectedProduct().getGameCurrency());
        this.mVirtualCoinTv.setText(this.selectPayChannel.getSelectedProduct().getShortCurrency() + " " + this.selectPayChannel.getSelectedProduct().getAmount());
        this.mTitleTv.setText(this.selectPayChannel.getName());
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoubleBtnDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs.4
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                ((NNXOHlAajkUISY) OmoOpLlTaJfzAYs.this).activity.dismiss();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                ((NNXOHlAajkUISY) OmoOpLlTaJfzAYs.this).activity.dismiss();
                SYwCAo.createAndShow(OmoOpLlTaJfzAYs.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    ((NNXOHlAajkUISY) OmoOpLlTaJfzAYs.this).activity.dismiss();
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        int i2 = AnonymousClass5.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$OmoOpLlTaJfzAYs$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 == 1) {
            startBuy();
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            new BrHfvPMqyRTwQe(getContext(), this.selectPayChannel.getProducts()).show();
        } else if (this.mProductListLay.getVisibility() == 0) {
            this.mProductListLay.setVisibility(4);
            this.layout_select_list.setVisibility(4);
        } else {
            this.mProductListLay.setVisibility(0);
            this.layout_select_list.setVisibility(0);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        this.mTitleTv = (TextView) view.findViewById(R.id.confirm_title);
        TextView textView = (TextView) view.findViewById(R.id.confirm_exchange_rate);
        this.mExchangeRateTv = textView;
        textView.setVisibility(8);
        this.mProductTv = (TextView) view.findViewById(R.id.tv_product);
        this.mVirtualCoinTv = (TextView) view.findViewById(R.id.tv_virtual_coin);
        this.mProductListLay = (RelativeLayout) view.findViewById(R.id.layout_select_list_layout);
        SmMyRuq smMyRuq = (SmMyRuq) findViewById(R.id.layout_select_list);
        this.layout_select_list = smMyRuq;
        smMyRuq.setVisibility(8);
        this.layout_select_list.setAnimations(1, 1);
        this.mProductListLay.setVisibility(8);
        this.list_select = (ListView) findViewById(R.id.list_select);
        this.mBuyBtn = (Button) view.findViewById(R.id.btn_buy);
        this.mProductTv.setTag(Buttons.BTNPRODUCT);
        this.mBuyBtn.setTag(Buttons.BTNBUY);
        this.mProductTv.setOnTouchListener(this);
        this.mBuyBtn.setOnTouchListener(this);
        ProductAdapter productAdapter = new ProductAdapter();
        this.adapter = productAdapter;
        this.list_select.setAdapter((ListAdapter) productAdapter);
        this.list_select.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                OmoOpLlTaJfzAYs.this.mProductListLay.setVisibility(8);
                OmoOpLlTaJfzAYs.this.selectPayChannel.setSelectedProduct(OmoOpLlTaJfzAYs.this.selectPayChannel.getProducts().get(i2));
                OmoOpLlTaJfzAYs.this.changeChoose();
            }
        });
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_confirm_change, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        try {
            this.selectPayChannel = (RfybaJKCLilYpc) Response.getInstance().getChoosePayChannel().clone();
            this.mProductTv.setText(this.selectPayChannel.getSelectedProduct().getGameCoin() + this.selectPayChannel.getSelectedProduct().getGameCurrency());
            this.mVirtualCoinTv.setText(this.selectPayChannel.getSelectedProduct().getShortCurrency() + " " + this.selectPayChannel.getSelectedProduct().getAmount());
            this.mTitleTv.setText(this.selectPayChannel.getName());
            this.adapter.notifyDataSetChanged();
        } catch (Exception unused) {
            Toast.makeText(getContext(), "oops! An Error is occur", 1).show();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mProductListLay.setVisibility(8);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelectPayChannel(RfybaJKCLilYpc rfybaJKCLilYpc) {
        this.selectPayChannel = rfybaJKCLilYpc;
    }

    public void startBuy() {
        if (isDoubleClick()) {
            return;
        }
        KcUwgofnY.getInstance().startPay(this.activity.getContext(), this.selectPayChannel, new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                if (OmoOpLlTaJfzAYs.this.selectPayChannel.getChannel().equals("21")) {
                    return;
                }
                String string = OmoOpLlTaJfzAYs.this.getContext().getString(ErrorUtil.getIdByCode(i2));
                OmoOpLlTaJfzAYs omoOpLlTaJfzAYs = OmoOpLlTaJfzAYs.this;
                omoOpLlTaJfzAYs.showSingleBtnDialog(i2 == 206, omoOpLlTaJfzAYs.getContext().getString(i2 == 206 ? R.string.txt_pay_pending : R.string.txt_buy_fail), string);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                if (OmoOpLlTaJfzAYs.this.selectPayChannel.getChannel().equals("21")) {
                    ((NNXOHlAajkUISY) OmoOpLlTaJfzAYs.this).activity.dismiss();
                    return;
                }
                String string = OmoOpLlTaJfzAYs.this.getContext().getString(R.string.txt_buy_success);
                if (Response.getInstance().getUserInfo().getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                    OmoOpLlTaJfzAYs.this.showDoubleBtnDialog(string, OmoOpLlTaJfzAYs.this.getContext().getString(R.string.txt_tourist_update_tips));
                } else {
                    OmoOpLlTaJfzAYs.this.showSingleBtnDialog(true, string, OmoOpLlTaJfzAYs.this.getContext().getString(R.string.txt_buy_success_tip));
                }
            }
        });
    }

    public OmoOpLlTaJfzAYs(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
    }
}
