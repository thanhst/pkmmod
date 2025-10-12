package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.CustomGridView;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;

/* loaded from: classes.dex */
public class GXdbWD extends NNXOHlAajkUISY {
    private final String GRID_PAY_LIST;
    private JqUIzeZd activity;
    private InnerAdapter adapter;
    private CustomGridView grid_pay_list;
    private RfybaJKCLilYpc payChannel;
    public RfybaJKCLilYpc selectPayItem;

    class InnerAdapter extends BaseAdapter {
        private boolean isMoreClick = false;

        class ViewHolder {
            ImageView cardIv;
            TextView cardTv;

            ViewHolder() {
            }
        }

        InnerAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GXdbWD.this.payChannel.getNodes().size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return GXdbWD.this.payChannel.getNodes().get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = LayoutInflater.from(GXdbWD.this.getContext()).inflate(R.layout.cg_grid_view_item, (ViewGroup) null);
                viewHolder.cardIv = (ImageView) viewInflate.findViewById(R.id.cg_grid_image);
                viewHolder.cardTv = (TextView) viewInflate.findViewById(R.id.cg_grid_tx);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            if (!GXdbWD.this.grid_pay_list.isInMeasure()) {
                ViewHolder viewHolder2 = (ViewHolder) view.getTag();
                RfybaJKCLilYpc rfybaJKCLilYpc = GXdbWD.this.payChannel.getNodes().get(i2);
                Glide.with(GXdbWD.this.getContext()).load(rfybaJKCLilYpc.getCodeImg()).placeholder(R.drawable.pictures_no).into(viewHolder2.cardIv);
                viewHolder2.cardTv.setText(rfybaJKCLilYpc.getName());
            }
            return view;
        }

        public boolean isMoreClick() {
            return this.isMoreClick;
        }

        public void setMoreClick(boolean z2) {
            this.isMoreClick = z2;
        }
    }

    public GXdbWD(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
        this.GRID_PAY_LIST = "grid_pay_list";
        this.activity = (JqUIzeZd) nNXOHlAajkUISYActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoubleBtnDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.GXdbWD.4
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                GXdbWD.this.activity.dismiss();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                GXdbWD.this.activity.dismiss();
                SYwCAo.createAndShow(GXdbWD.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.GXdbWD.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    GXdbWD.this.activity.dismiss();
                }
            }
        });
    }

    private void startPay() {
        KcUwgofnY.getInstance().startPay(this.activity.getActivity(), this.selectPayItem, new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.GXdbWD.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                String string = GXdbWD.this.getContext().getString(ErrorUtil.getIdByCode(i2));
                GXdbWD gXdbWD = GXdbWD.this;
                gXdbWD.showSingleBtnDialog(i2 == 206, gXdbWD.getContext().getString(i2 == 206 ? R.string.txt_pay_pending : R.string.txt_buy_fail), string);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                if (GXdbWD.this.selectPayItem.getShowMethod().equals(ConstantUtil.SHOW_METHOD_SYS_BROWSER)) {
                    GXdbWD.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getNetParamsBean().getPaymentUrl())));
                    GXdbWD.this.activity.dismiss();
                    return;
                }
                String string = GXdbWD.this.getContext().getString(R.string.txt_buy_success);
                if (Response.getInstance().getUserInfo().getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                    GXdbWD.this.showDoubleBtnDialog(string, GXdbWD.this.getContext().getString(R.string.txt_tourist_update_tips));
                } else {
                    GXdbWD.this.showSingleBtnDialog(true, string, GXdbWD.this.getContext().getString(R.string.txt_buy_success_tip));
                }
            }
        });
    }

    public RfybaJKCLilYpc getSelectItems() {
        return this.selectPayItem;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        this.grid_pay_list = (CustomGridView) findViewById(R.id.grid_pay_list);
        this.payChannel = this.activity.getSelectPayChannel();
        InnerAdapter innerAdapter = new InnerAdapter();
        this.adapter = innerAdapter;
        this.grid_pay_list.setAdapter((ListAdapter) innerAdapter);
        this.grid_pay_list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.GXdbWD.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                GXdbWD gXdbWD = GXdbWD.this;
                gXdbWD.selectPayItem = (RfybaJKCLilYpc) gXdbWD.adapter.getItem(i2);
                if (GXdbWD.this.selectPayItem.getShowProductList() == 0) {
                    GXdbWD gXdbWD2 = GXdbWD.this;
                    gXdbWD2.proceeInnerFragment(gXdbWD2.selectPayItem);
                } else if (GXdbWD.this.selectPayItem.getShowProductList() == 1) {
                    Response.getInstance().setChoosePayChannel(GXdbWD.this.selectPayItem);
                    GXdbWD.this.proceeInnerFragment(8);
                }
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_select_card, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        this.payChannel = this.activity.getSelectPayChannel();
        this.adapter.notifyDataSetChanged();
    }

    public void proceeInnerFragment(RfybaJKCLilYpc rfybaJKCLilYpc) {
        Response.getInstance().setChoosePayChannel(rfybaJKCLilYpc);
        String showMethod = rfybaJKCLilYpc.getShowMethod();
        showMethod.hashCode();
        switch (showMethod) {
            case "0":
                clearInnerTaskAndProcee(4);
                break;
            case "1":
                clearInnerTaskAndProcee(2);
                break;
            case "2":
                clearInnerTaskAndProcee(2);
                break;
            case "3":
            case "9":
            case "10":
            case "11":
            case "13":
                clearInnerTaskAndProcee(5);
                break;
            case "5":
                clearInnerTaskAndProcee(6);
                break;
            case "6":
                clearInnerTaskAndProcee(2);
                break;
            case "12":
                startPay();
                break;
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void proceeInnerFragment(int i2) {
        clearInnerTaskAndProcee(i2);
    }
}
