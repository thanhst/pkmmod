package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.BrHfvPMqyRTwQe;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.ListViewForScrollView;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;
import java.util.List;

/* loaded from: classes.dex */
public class VAswzYa extends NNXOHlAajkUISY {
    private final String BTN_CONFIRM;
    private final String EDIT_PIN;
    private final String EDIT_SERIAL;
    private final String IMG_PAY;
    private final String LAYOUT_PIN;
    private final String LAYOUT_SERIAL;
    private final String LIST_PROPORTION;
    private final String SCROLL_VIEW;
    private final String TV_TO_BUY;
    private final String TXT_TIPS;
    private InnerAdapter adapter;
    private Button btn_confirm;
    private String cardCode;
    private EditText edit_pin;
    private EditText edit_serial;
    private ImageView img_pay;
    private RfybaJKCLilYpc item;
    private RelativeLayout layout_pin;
    private RelativeLayout layout_serial;
    private List<RfybaJKCLilYpc.Products> list;
    private ListViewForScrollView list_proportion;
    private TextView mExchangeRateTv;
    private TextView mTitleTv;
    private ScrollView scroll_view;
    private TextView txt_how_to_buy;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.VAswzYa$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$VAswzYa$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$VAswzYa$Buttons = iArr;
            try {
                iArr[Buttons.BTN_CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$VAswzYa$Buttons[Buttons.BTN_EXCHANGE_RATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        BTN_CONFIRM,
        BTN_EXCHANGE_RATE
    }

    private class InnerAdapter extends BaseAdapter {

        private class ViewHolder {
            TextView txt_money;

            private ViewHolder() {
            }
        }

        private InnerAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (VAswzYa.this.list == null) {
                return 0;
            }
            return VAswzYa.this.list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return VAswzYa.this.list.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = LayoutInflater.from(VAswzYa.this.getContext()).inflate(R.layout.cg_pay_proportion_item, (ViewGroup) null);
                viewHolder.txt_money = (TextView) viewInflate.findViewById(R.id.txt_name);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            RfybaJKCLilYpc.Products products = (RfybaJKCLilYpc.Products) VAswzYa.this.list.get(i2);
            viewHolder2.txt_money.setText(products.getGameCurrency() + " = " + products.getAmount() + " " + products.getCurrency());
            return view;
        }
    }

    public VAswzYa(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.IMG_PAY = "img_pay";
        this.EDIT_SERIAL = "edit_serial";
        this.EDIT_PIN = "edit_pin";
        this.BTN_CONFIRM = "btn_confirm";
        this.SCROLL_VIEW = "scroll_view";
        this.TXT_TIPS = "txt_tips";
        this.LAYOUT_SERIAL = "layout_serial";
        this.LAYOUT_PIN = "layout_pin";
        this.TV_TO_BUY = "tv_to_buy";
        this.LIST_PROPORTION = "list_proportion";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoubleBtnDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.VAswzYa.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                ((NNXOHlAajkUISY) VAswzYa.this).activity.dismiss();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                ((NNXOHlAajkUISY) VAswzYa.this).activity.dismiss();
                SYwCAo.createAndShow(VAswzYa.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.VAswzYa.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    ((NNXOHlAajkUISY) VAswzYa.this).activity.dismiss();
                }
            }
        });
    }

    private void startPay() {
        NetParamsBean netParamsBean = new NetParamsBean();
        String strTrim = this.edit_serial.getText().toString().trim();
        String strTrim2 = this.edit_pin.getText().toString().trim();
        if (strTrim2.equals("")) {
            Toast.makeText(getContext(), R.string.txt_pay_fail_null, 0).show();
            return;
        }
        if ((this.item.getShowMethod().equals("1") || this.item.getShowMethod().equals(ConstantUtil.SHOW_METHOD_CONFIRM_AND_SERIAL_PIN)) && strTrim.equals("")) {
            Toast.makeText(getContext(), R.string.txt_pay_fail_null, 0).show();
            return;
        }
        netParamsBean.setCardNumber(strTrim);
        netParamsBean.setCardPassword(strTrim2);
        Response.getInstance().setNetParamsBean(netParamsBean);
        KcUwgofnY.getInstance().startPay(this.activity.getContext(), this.item, new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.VAswzYa.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                if (VAswzYa.this.item.getChannel().equals("21")) {
                    return;
                }
                String string = VAswzYa.this.getContext().getString(ErrorUtil.getIdByCode(i2));
                VAswzYa vAswzYa = VAswzYa.this;
                vAswzYa.showSingleBtnDialog(i2 == 206, vAswzYa.getContext().getString(i2 == 206 ? R.string.txt_pay_pending : R.string.txt_buy_fail), string);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                if (VAswzYa.this.item.getChannel().equals("21")) {
                    ((NNXOHlAajkUISY) VAswzYa.this).activity.dismiss();
                    return;
                }
                String string = VAswzYa.this.getContext().getString(R.string.txt_buy_success);
                if (Response.getInstance().getUserInfo().getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                    VAswzYa.this.showDoubleBtnDialog(string, VAswzYa.this.getContext().getString(R.string.txt_tourist_update_tips));
                } else {
                    VAswzYa.this.showSingleBtnDialog(true, string, VAswzYa.this.getContext().getString(R.string.txt_buy_success_tip));
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    protected void click(View view) {
        int i2 = AnonymousClass4.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$fragment$VAswzYa$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 == 1) {
            startPay();
        } else {
            if (i2 != 2) {
                return;
            }
            new BrHfvPMqyRTwQe(getContext(), this.item.getProducts()).show();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        this.btn_confirm = (Button) findViewById(R.id.btn_confirm);
        this.edit_serial = (EditText) findViewById(R.id.edit_serial);
        this.edit_pin = (EditText) findViewById(R.id.edit_pin);
        this.img_pay = (ImageView) findViewById(R.id.img_pay);
        this.layout_serial = (RelativeLayout) findViewById(R.id.layout_serial);
        this.layout_pin = (RelativeLayout) findViewById(R.id.layout_pin);
        this.txt_how_to_buy = (TextView) findViewById(R.id.tv_to_buy);
        this.btn_confirm.setTag(Buttons.BTN_CONFIRM);
        this.btn_confirm.setOnTouchListener(this);
        if (this.activity instanceof JqUIzeZd) {
            this.mTitleTv = (TextView) view.findViewById(R.id.confirm_title);
            TextView textView = (TextView) view.findViewById(R.id.confirm_exchange_rate);
            this.mExchangeRateTv = textView;
            textView.setTag(Buttons.BTN_EXCHANGE_RATE);
            this.mExchangeRateTv.setOnTouchListener(this);
        } else {
            this.scroll_view = (ScrollView) findViewById(R.id.scroll_view);
            this.list_proportion = (ListViewForScrollView) findViewById(R.id.list_proportion);
            InnerAdapter innerAdapter = new InnerAdapter();
            this.adapter = innerAdapter;
            this.list_proportion.setAdapter((ListAdapter) innerAdapter);
        }
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_card, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        this.edit_serial.setText("");
        this.edit_pin.setText("");
        RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
        this.item = choosePayChannel;
        this.list = choosePayChannel.getProducts();
        if (this.activity instanceof JqUIzeZd) {
            this.mTitleTv.setText(this.item.getName());
        } else {
            this.scroll_view.scrollTo(0, 0);
        }
        this.cardCode = this.item.getCode();
        if (this.item.getChannel().equals("21") && this.cardCode.equals("58")) {
            this.layout_pin.setVisibility(0);
            this.layout_serial.setVisibility(8);
            this.txt_how_to_buy.setVisibility(0);
        } else {
            this.txt_how_to_buy.setVisibility(8);
            if (this.item.getShowMethod().equals("1") || this.item.getShowMethod().equals(ConstantUtil.SHOW_METHOD_CONFIRM_AND_SERIAL_PIN)) {
                this.layout_serial.setVisibility(0);
                this.layout_pin.setVisibility(0);
            } else if (this.item.getShowMethod().equals(ConstantUtil.SHOW_METHOD_PIN) || this.item.getShowMethod().equals(ConstantUtil.SHOW_METHOD_CONFIRM_AND_PIN)) {
                this.layout_serial.setVisibility(8);
                this.layout_pin.setVisibility(0);
            }
        }
        Glide.with(getContext()).load(this.item.getCodeImg()).placeholder(R.drawable.pictures_no).into(this.img_pay);
    }

    public VAswzYa(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
        this.IMG_PAY = "img_pay";
        this.EDIT_SERIAL = "edit_serial";
        this.EDIT_PIN = "edit_pin";
        this.BTN_CONFIRM = "btn_confirm";
        this.SCROLL_VIEW = "scroll_view";
        this.TXT_TIPS = "txt_tips";
        this.LAYOUT_SERIAL = "layout_serial";
        this.LAYOUT_PIN = "layout_pin";
        this.TV_TO_BUY = "tv_to_buy";
        this.LIST_PROPORTION = "list_proportion";
    }
}
