package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JqUIzeZd;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.vertial.DMPOSpjVN;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.WOMSQzPaksWfHUC;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import java.util.List;

/* loaded from: classes.dex */
public class OvSFXgdxe extends NNXOHlAajkUISY {
    private final int FRAGMENT_SUQERAD;
    private ListView list_goods;
    private GoodsListAdapter mAdapter;
    private List<RfybaJKCLilYpc.Products> mList;
    private TextView titleTvx;

    private enum Buttons {
        PAY_BTN
    }

    private class GoodsListAdapter extends BaseAdapter {

        class ViewHolder {
            TextView goods_des;
            Button goods_pay;
            TextView goods_price;

            ViewHolder() {
            }
        }

        private GoodsListAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (OvSFXgdxe.this.mList == null) {
                return 0;
            }
            return OvSFXgdxe.this.mList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return OvSFXgdxe.this.mList.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(final int i2, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = ((NNXOHlAajkUISY) OvSFXgdxe.this).activity.getContext().getResources().getConfiguration().orientation == 2 ? LayoutInflater.from(((NNXOHlAajkUISY) OvSFXgdxe.this).activity.getContext()).inflate(R.layout.cg_fragment_pay_goodslist_item, (ViewGroup) null) : LayoutInflater.from(((NNXOHlAajkUISY) OvSFXgdxe.this).activity.getContext()).inflate(R.layout.cg_fragment_pay_goodslist_item_vertical, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.goods_des = (TextView) view.findViewById(R.id.goods_des);
                viewHolder.goods_price = (TextView) view.findViewById(R.id.goods_price);
                Button button = (Button) view.findViewById(R.id.goods_pay);
                viewHolder.goods_pay = button;
                button.setTag(Buttons.PAY_BTN);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.goods_des.setText(Html.fromHtml(((RfybaJKCLilYpc.Products) OvSFXgdxe.this.mList.get(i2)).getProductDesc()));
            viewHolder.goods_price.setText(((RfybaJKCLilYpc.Products) OvSFXgdxe.this.mList.get(i2)).getShortCurrency() + " " + ((RfybaJKCLilYpc.Products) OvSFXgdxe.this.mList.get(i2)).getAmount());
            viewHolder.goods_pay.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.OvSFXgdxe.GoodsListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
                    choosePayChannel.setSelectedProduct((RfybaJKCLilYpc.Products) OvSFXgdxe.this.mList.get(i2));
                    if (((NNXOHlAajkUISY) OvSFXgdxe.this).innerFragment == null) {
                        if (((NNXOHlAajkUISY) OvSFXgdxe.this).activity instanceof JqUIzeZd) {
                            ((JqUIzeZd) ((NNXOHlAajkUISY) OvSFXgdxe.this).activity).showPayChannel(-1000, choosePayChannel);
                            return;
                        } else {
                            if (((NNXOHlAajkUISY) OvSFXgdxe.this).activity instanceof DMPOSpjVN) {
                                ((DMPOSpjVN) ((NNXOHlAajkUISY) OvSFXgdxe.this).activity).showPayChannel(-1000, choosePayChannel);
                                return;
                            }
                            return;
                        }
                    }
                    if (((NNXOHlAajkUISY) OvSFXgdxe.this).innerFragment instanceof BHkzDf) {
                        GXdbWD gXdbWD = ((BHkzDf) ((NNXOHlAajkUISY) OvSFXgdxe.this).innerFragment).cardSelectFragment;
                        RfybaJKCLilYpc rfybaJKCLilYpc = gXdbWD.selectPayItem;
                        rfybaJKCLilYpc.setSelectedProduct((RfybaJKCLilYpc.Products) OvSFXgdxe.this.mList.get(i2));
                        gXdbWD.proceeInnerFragment(rfybaJKCLilYpc);
                    }
                }
            });
            return view;
        }
    }

    public OvSFXgdxe(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.FRAGMENT_SUQERAD = 1;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        this.list_goods = (ListView) view.findViewById(R.id.list_goods);
        this.titleTvx = (TextView) view.findViewById(R.id.txt_title);
        GoodsListAdapter goodsListAdapter = new GoodsListAdapter();
        this.mAdapter = goodsListAdapter;
        this.list_goods.setAdapter((ListAdapter) goodsListAdapter);
        onRefresh();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_goodslist, (ViewGroup) null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onRefresh() {
        RfybaJKCLilYpc choosePayChannel = Response.getInstance().getChoosePayChannel();
        this.titleTvx.setText(choosePayChannel.getName() + " list");
        this.mList = Response.getInstance().getChoosePayChannel().getProducts();
        ListView listView = this.list_goods;
        if (listView != null) {
            listView.setSelection(0);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public OvSFXgdxe(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity, WOMSQzPaksWfHUC wOMSQzPaksWfHUC) {
        super(nNXOHlAajkUISYActivity, wOMSQzPaksWfHUC);
        this.FRAGMENT_SUQERAD = 1;
    }
}
