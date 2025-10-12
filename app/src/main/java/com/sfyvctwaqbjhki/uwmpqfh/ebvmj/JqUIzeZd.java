package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CommonUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.BHkzDf;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.NALdIqmRM;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OmoOpLlTaJfzAYs;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OvSFXgdxe;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.VAswzYa;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.YqDvVAX;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.Zmxjahf;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;
import java.util.List;

/* loaded from: classes.dex */
public class JqUIzeZd extends NNXOHlAajkUISYActivity {
    private final int FRAGMENT_CONFIRM;
    private final int FRAGMENT_CONFIRM_CHANGE;
    private final int FRAGMENT_CONTENT;
    private final int FRAGMENT_GOODS_LIST;
    private final int FRAGMENT_SERIAL_PIN;
    private final int FRAGMENT_SUQERAD;
    private final int FRAGMENT_WEB;
    private SelectAdapter adapter;
    private int currentFragment;
    private List<RfybaJKCLilYpc> payChannelList;
    private RfybaJKCLilYpc selectPayChannel;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JqUIzeZd$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JqUIzeZd$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JqUIzeZd$Buttons[Buttons.LAYOUT_CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_BACK,
        LAYOUT_CLOSE
    }

    private class SelectAdapter extends BaseAdapter {
        public int select;

        private class ViewHolder {
            RelativeLayout channelItemLay;
            ImageView discountImage;
            ImageView hotImage;
            TextView textArrow;
            TextView textName;

            private ViewHolder() {
            }
        }

        private SelectAdapter() {
            this.select = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (JqUIzeZd.this.payChannelList == null) {
                return 0;
            }
            return JqUIzeZd.this.payChannelList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        public int getSelect() {
            return this.select;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = LayoutInflater.from(((SLdJjpRXaI) JqUIzeZd.this).context).inflate(R.layout.cg_pay_channel_item, (ViewGroup) null);
                viewHolder.textName = (TextView) viewInflate.findViewById(R.id.txt_name);
                viewHolder.textArrow = (TextView) viewInflate.findViewById(R.id.txt_arrow);
                viewHolder.hotImage = (ImageView) viewInflate.findViewById(R.id.iv_hot_logo);
                viewHolder.discountImage = (ImageView) viewInflate.findViewById(R.id.iv_discount);
                viewHolder.channelItemLay = (RelativeLayout) viewInflate.findViewById(R.id.channel_item_lay);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            viewHolder2.textName.setText(((RfybaJKCLilYpc) JqUIzeZd.this.payChannelList.get(i2)).getName());
            if (this.select == i2) {
                viewHolder2.textName.setTextColor(Color.rgb(255, 255, 255));
                viewHolder2.textArrow.setTextColor(Color.rgb(255, 255, 255));
                viewHolder2.textArrow.setVisibility(0);
                viewHolder2.textName.setTypeface(Typeface.defaultFromStyle(1));
                viewHolder2.channelItemLay.setBackgroundColor(Color.rgb(41, 172, 240));
            } else {
                viewHolder2.textName.setTextColor(Color.rgb(41, 172, 240));
                viewHolder2.textArrow.setVisibility(8);
                viewHolder2.textName.setTypeface(Typeface.defaultFromStyle(0));
                viewHolder2.channelItemLay.setBackgroundColor(Color.rgb(242, 242, 242));
            }
            if (((RfybaJKCLilYpc) JqUIzeZd.this.payChannelList.get(i2)).getHotImg().length() != 0) {
                viewHolder2.hotImage.setVisibility(0);
                Glide.with(JqUIzeZd.this.getContext()).load(((RfybaJKCLilYpc) JqUIzeZd.this.payChannelList.get(i2)).getHotImg()).placeholder(R.drawable.pictures_no).into(viewHolder2.hotImage);
            } else {
                viewHolder2.hotImage.setVisibility(8);
            }
            if (((RfybaJKCLilYpc) JqUIzeZd.this.payChannelList.get(i2)).getDiscountImg().length() != 0) {
                viewHolder2.discountImage.setVisibility(0);
                Glide.with(JqUIzeZd.this.getContext()).load(((RfybaJKCLilYpc) JqUIzeZd.this.payChannelList.get(i2)).getDiscountImg()).placeholder(R.drawable.pictures_no).into(viewHolder2.discountImage);
            } else {
                viewHolder2.discountImage.setVisibility(8);
            }
            return view;
        }

        public void setSelect(int i2) {
            this.select = i2;
            notifyDataSetChanged();
        }
    }

    public JqUIzeZd(Context context) {
        super(context);
        this.currentFragment = 0;
        this.FRAGMENT_SUQERAD = 1;
        this.FRAGMENT_SERIAL_PIN = 2;
        this.FRAGMENT_CONTENT = 3;
        this.FRAGMENT_WEB = 4;
        this.FRAGMENT_CONFIRM = 5;
        this.FRAGMENT_CONFIRM_CHANGE = 6;
        this.FRAGMENT_GOODS_LIST = 8;
        setAnimRes(R.anim.anim_enter_1, R.anim.anim_exit_1, R.anim.back_enter_1, R.anim.back_exit_1);
    }

    private void checkProceed(int i2, int i3) {
        this.currentFragment = i3;
        if (i2 == 100) {
            proceeFragment(i3);
            return;
        }
        if (i2 == -1) {
            clearTaskWithNoAnim(i3);
        } else if (i2 > this.adapter.select) {
            clearTaskAndProcee(i3);
        } else {
            clearTaskAndback(i3);
        }
    }

    public static JqUIzeZd createAndShow(Context context) {
        JqUIzeZd jqUIzeZd = new JqUIzeZd(context);
        jqUIzeZd.show();
        return jqUIzeZd;
    }

    private void sendPay() {
        KcUwgofnY.getInstance().startPay(getActivity(), this.selectPayChannel, new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                JqUIzeZd.this.showSingleBtnDialog(false, JqUIzeZd.this.getContext().getString(R.string.txt_buy_fail), JqUIzeZd.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                JqUIzeZd.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getNetParamsBean().getPaymentUrl())));
                JqUIzeZd.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    JqUIzeZd.this.dismiss();
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        int i2 = AnonymousClass4.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JqUIzeZd$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            dismiss();
        } else {
            NNXOHlAajkUISY nNXOHlAajkUISYFindFragmentByTag = getFragmentManager().findFragmentByTag(String.valueOf(this.currentFragment));
            if (nNXOHlAajkUISYFindFragmentByTag == null || nNXOHlAajkUISYFindFragmentByTag.backFragment() == -1) {
                dismiss();
            }
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected NNXOHlAajkUISY createFragemnt(int i2) {
        switch (i2) {
            case 1:
                return new BHkzDf(this);
            case 2:
                return new VAswzYa(this);
            case 3:
                return new YqDvVAX(this);
            case 4:
                return new Zmxjahf(this);
            case 5:
                return new NALdIqmRM(this);
            case 6:
                return new OmoOpLlTaJfzAYs(this);
            case 7:
            default:
                return null;
            case 8:
                return new OvSFXgdxe(this);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_pay;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    public void dismiss() {
        LogUtils.e("支付界面关闭=====================================");
        ZGJWDCUOkpgHBx.paySuccess();
        KcUwgofnY.getInstance().setPayShow(false);
        super.dismiss();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity
    protected int fragmentLayout() {
        return R.id.layout_frag_right;
    }

    public Activity getActivity() {
        return this.context;
    }

    public RfybaJKCLilYpc getSelectPayChannel() {
        return this.selectPayChannel;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_left);
        NNXOHlAajkUISY nNXOHlAajkUISY = (NNXOHlAajkUISY) findViewById(R.id.layout_frag_right);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.layout_back);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.layout_close);
        relativeLayout2.setTag(Buttons.LAYOUT_BACK);
        relativeLayout3.setTag(Buttons.LAYOUT_CLOSE);
        relativeLayout2.setOnTouchListener(this);
        relativeLayout3.setOnTouchListener(this);
        List<RfybaJKCLilYpc> payChannelList = Response.getInstance().getPayChannelList();
        this.payChannelList = payChannelList;
        if (payChannelList.size() <= 0) {
            TextView textView = (TextView) findViewById(R.id.tv_pay_close);
            relativeLayout.setVisibility(4);
            textView.setVisibility(0);
            textView.setText(R.string.txt_pay_not_open);
            return;
        }
        if (this.payChannelList.size() == 1) {
            relativeLayout.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nNXOHlAajkUISY.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.setMargins(CommonUtils.dip2px(getContext(), 10.0f), CommonUtils.dip2px(getContext(), 50.0f), CommonUtils.dip2px(getContext(), 10.0f), CommonUtils.dip2px(getContext(), 6.0f));
            nNXOHlAajkUISY.setLayoutParams(layoutParams);
            nNXOHlAajkUISY.requestLayout();
        } else {
            ListView listView = (ListView) findViewById(R.id.list_select);
            SelectAdapter selectAdapter = new SelectAdapter();
            this.adapter = selectAdapter;
            listView.setAdapter((ListAdapter) selectAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    ((NNXOHlAajkUISYActivity) JqUIzeZd.this).leftSelectpos = i2;
                    JqUIzeZd jqUIzeZd = JqUIzeZd.this;
                    jqUIzeZd.showPayChannel(i2, (RfybaJKCLilYpc) jqUIzeZd.payChannelList.get(i2));
                    JqUIzeZd.this.adapter.setSelect(i2);
                }
            });
        }
        showPayChannel(-1, this.payChannelList.get(0));
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity, com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void onCreate(View view) {
        super.onCreate(view);
    }

    public void processFragement(int i2, RfybaJKCLilYpc rfybaJKCLilYpc) {
        String showMethod = rfybaJKCLilYpc.getShowMethod();
        showMethod.hashCode();
        switch (showMethod) {
            case "0":
                checkProceed(i2, 4);
                break;
            case "1":
            case "2":
                checkProceed(i2, 2);
                break;
            case "3":
            case "7":
            case "9":
            case "10":
            case "11":
            case "13":
                checkProceed(i2, 5);
                break;
            case "4":
                if (rfybaJKCLilYpc.getNodes().size() != 0) {
                    if (rfybaJKCLilYpc.getNodes().size() != 1) {
                        checkProceed(i2, 1);
                        break;
                    } else {
                        showPayChannel(i2, rfybaJKCLilYpc.getNodes().get(0));
                        break;
                    }
                } else {
                    Toast.makeText(this.context, "Server Pay way configuration is wrong!", 0).show();
                    break;
                }
            case "5":
                checkProceed(i2, 6);
                break;
            case "6":
                checkProceed(i2, 3);
                break;
            case "12":
                sendPay();
                break;
        }
    }

    public void showPayChannel(int i2, RfybaJKCLilYpc rfybaJKCLilYpc) {
        Response.getInstance().setChoosePayChannel(rfybaJKCLilYpc);
        this.selectPayChannel = rfybaJKCLilYpc;
        if (i2 == -1000) {
            rfybaJKCLilYpc.setShowProductList(0);
        }
        if (this.selectPayChannel.getShowProductList() == 0) {
            processFragement(i2, rfybaJKCLilYpc);
            return;
        }
        if (this.selectPayChannel.getShowProductList() == 1) {
            String showMethod = rfybaJKCLilYpc.getShowMethod();
            showMethod.hashCode();
            if (!showMethod.equals(ConstantUtil.SHOW_METHOD_SQUARED)) {
                checkProceed(i2, 8);
                return;
            }
            if (rfybaJKCLilYpc.getNodes().size() == 0) {
                Toast.makeText(this.context, "Server Pay way configuration is wrong!", 0).show();
            } else if (rfybaJKCLilYpc.getNodes().size() == 1) {
                showPayChannel(i2, rfybaJKCLilYpc.getNodes().get(0));
            } else {
                checkProceed(i2, 8);
            }
        }
    }
}
