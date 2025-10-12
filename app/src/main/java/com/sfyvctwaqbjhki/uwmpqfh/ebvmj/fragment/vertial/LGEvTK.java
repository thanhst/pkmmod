package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial;

import android.graphics.Color;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.EDakAXiM;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ErrorUtil;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.SYwCAo;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.WxGIMQL;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.AnimatedExpandableListView;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LGEvTK extends NNXOHlAajkUISY {
    private final String EXTAB_PAY_LIST;
    private InnerAdapter adapter;
    private EDakAXiM configbean;
    private AnimatedExpandableListView extab_pay_list;
    private List<RfybaJKCLilYpc> payChannelList;
    private RfybaJKCLilYpc selectPayChannel;

    private class InnerAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

        class ChlidViewHolder {
            List<ImageView> list_logos = new ArrayList();
            List<TextView> list_names = new ArrayList();
            List<RelativeLayout> list_layout = new ArrayList();

            ChlidViewHolder() {
            }
        }

        class ViewHolder {
            ImageView arrow;
            ImageView discountImage;
            ImageView hotImage;
            RelativeLayout layout;
            TextView name;

            ViewHolder() {
            }
        }

        private InnerAdapter() {
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i2, int i3) {
            return ((RfybaJKCLilYpc) LGEvTK.this.payChannelList.get(i2)).getNodes().get(i3);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i2, int i3) {
            return i3;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return LGEvTK.this.payChannelList.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i2) {
            return i2;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = LayoutInflater.from(LGEvTK.this.getContext()).inflate(R.layout.group_item_portrait, (ViewGroup) null);
                viewHolder.arrow = (ImageView) viewInflate.findViewById(R.id.imageView2);
                viewHolder.name = (TextView) viewInflate.findViewById(R.id.textView1);
                viewHolder.layout = (RelativeLayout) viewInflate.findViewById(R.id.layout);
                viewHolder.hotImage = (ImageView) viewInflate.findViewById(R.id.iv_hot_logo);
                viewHolder.discountImage = (ImageView) viewInflate.findViewById(R.id.iv_discount);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            viewHolder2.name.setText(getGroup(i2).getName());
            if (z2) {
                viewHolder2.layout.setBackgroundColor(Color.rgb(27, 189, 227));
                viewHolder2.arrow.setImageResource(R.drawable.group_item_pressed);
                viewHolder2.name.setTextColor(-1);
            } else {
                viewHolder2.layout.setBackgroundResource(R.drawable.cg_shape_rec_rou_blue_white);
                viewHolder2.arrow.setImageResource(R.drawable.cg_map_right_arrow);
                viewHolder2.name.setTextColor(Color.rgb(27, 189, 227));
            }
            if (getGroup(i2).getHotImg().length() != 0) {
                viewHolder2.hotImage.setVisibility(0);
                Glide.with(LGEvTK.this.getContext()).load(getGroup(i2).getHotImg()).placeholder(R.drawable.pictures_no).into(viewHolder2.hotImage);
            } else {
                viewHolder2.hotImage.setVisibility(8);
            }
            if (getGroup(i2).getDiscountImg().length() != 0) {
                viewHolder2.discountImage.setVisibility(0);
                Glide.with(LGEvTK.this.getContext()).load(getGroup(i2).getDiscountImg()).placeholder(R.drawable.pictures_no).into(viewHolder2.discountImage);
            } else {
                viewHolder2.discountImage.setVisibility(8);
            }
            return view;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.AnimatedExpandableListView.AnimatedExpandableListAdapter
        public View getRealChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
            View viewInflate;
            if (view == null) {
                viewInflate = LayoutInflater.from(LGEvTK.this.getContext()).inflate(R.layout.child_item_portrait, (ViewGroup) null);
                ChlidViewHolder chlidViewHolder = new ChlidViewHolder();
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                SparseIntArray sparseIntArray3 = new SparseIntArray();
                sparseIntArray.put(1, R.id.image1);
                sparseIntArray.put(2, R.id.image2);
                sparseIntArray.put(3, R.id.image3);
                sparseIntArray2.put(1, R.id.text1);
                sparseIntArray2.put(2, R.id.text2);
                sparseIntArray2.put(3, R.id.text3);
                sparseIntArray3.put(1, R.id.layout1);
                sparseIntArray3.put(2, R.id.layout2);
                sparseIntArray3.put(3, R.id.layout3);
                for (int i4 = 1; i4 < 4; i4++) {
                    ImageView imageView = (ImageView) viewInflate.findViewById(sparseIntArray.get(i4));
                    TextView textView = (TextView) viewInflate.findViewById(sparseIntArray2.get(i4));
                    RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(sparseIntArray3.get(i4));
                    chlidViewHolder.list_logos.add(imageView);
                    chlidViewHolder.list_names.add(textView);
                    chlidViewHolder.list_layout.add(relativeLayout);
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK.InnerAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            int[] iArr = (int[]) view2.getTag();
                            LGEvTK lGEvTK = LGEvTK.this;
                            lGEvTK.onItemChildClicked(iArr[0], ((RfybaJKCLilYpc) lGEvTK.payChannelList.get(iArr[0])).getNodes().get(iArr[1]));
                        }
                    });
                }
                viewInflate.setTag(chlidViewHolder);
            } else {
                viewInflate = view;
            }
            ChlidViewHolder chlidViewHolder2 = (ChlidViewHolder) viewInflate.getTag();
            List<RfybaJKCLilYpc> nodes = ((RfybaJKCLilYpc) LGEvTK.this.payChannelList.get(i2)).getNodes();
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = (i3 * 3) + i5;
                if (i6 < nodes.size()) {
                    RfybaJKCLilYpc rfybaJKCLilYpc = nodes.get(i6);
                    Glide.with(LGEvTK.this.getContext()).load(rfybaJKCLilYpc.getCodeImg()).placeholder(R.drawable.pictures_no).into(chlidViewHolder2.list_logos.get(i5));
                    chlidViewHolder2.list_names.get(i5).setText(rfybaJKCLilYpc.getName());
                    chlidViewHolder2.list_layout.get(i5).setVisibility(0);
                    chlidViewHolder2.list_layout.get(i5).setTag(new int[]{i2, i6});
                } else {
                    chlidViewHolder2.list_layout.get(i5).setVisibility(4);
                }
            }
            return viewInflate;
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.AnimatedExpandableListView.AnimatedExpandableListAdapter
        public int getRealChildrenCount(int i2) {
            double size = ((RfybaJKCLilYpc) LGEvTK.this.payChannelList.get(i2)).getNodes().size();
            Double.isNaN(size);
            return (int) Math.ceil(size / 3.0d);
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i2, int i3) {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public RfybaJKCLilYpc getGroup(int i2) {
            return (RfybaJKCLilYpc) LGEvTK.this.payChannelList.get(i2);
        }
    }

    public LGEvTK(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.EXTAB_PAY_LIST = "extab_pay_list";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemChildClicked(int i2, RfybaJKCLilYpc rfybaJKCLilYpc) {
        proceeInnerFragment(i2, rfybaJKCLilYpc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoubleBtnDialog(String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_cancel), getContext().getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK.4
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
            public void cancel() {
                ((NNXOHlAajkUISY) LGEvTK.this).activity.dismiss();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                ((NNXOHlAajkUISY) LGEvTK.this).activity.dismiss();
                SYwCAo.createAndShow(LGEvTK.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSingleBtnDialog(final boolean z2, String str, String str2) {
        WxGIMQL.createAndShow(str, str2, getContext().getString(R.string.txt_confirm), new SingleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK.3
            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
            public void confirm() {
                if (z2) {
                    ((NNXOHlAajkUISY) LGEvTK.this).activity.dismiss();
                }
            }
        });
    }

    private void thirdFuctionPay() {
        KcUwgofnY.getInstance().startPay(this.activity.getContext(), this.selectPayChannel, new KcUwgofnY.PayComponentCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK.2
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void payFail(int i2, String str) {
                if (LGEvTK.this.selectPayChannel.getChannel().equals("21")) {
                    return;
                }
                LGEvTK.this.showSingleBtnDialog(false, LGEvTK.this.getContext().getString(R.string.txt_buy_fail), LGEvTK.this.getContext().getString(ErrorUtil.getIdByCode(i2)));
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.KcUwgofnY.PayComponentCallBack
            public void paySuccess() {
                if (LGEvTK.this.selectPayChannel.getChannel().equals("21")) {
                    ((NNXOHlAajkUISY) LGEvTK.this).activity.dismiss();
                    return;
                }
                String string = LGEvTK.this.getContext().getString(R.string.txt_buy_success);
                if (Response.getInstance().getUserInfo().getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                    LGEvTK.this.showDoubleBtnDialog(string, LGEvTK.this.getContext().getString(R.string.txt_tourist_update_tips));
                } else {
                    LGEvTK.this.showSingleBtnDialog(true, string, LGEvTK.this.getContext().getString(R.string.txt_buy_success_tip));
                }
            }
        });
    }

    public RfybaJKCLilYpc getSelectPayments() {
        return this.selectPayChannel;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        super.onCreat(view);
        this.extab_pay_list = (AnimatedExpandableListView) findViewById(R.id.extab_pay_list);
        this.configbean = Response.getInstance().getEDakAXiM();
        this.payChannelList = Response.getInstance().getPayChannelList();
        this.extab_pay_list.setGroupIndicator(null);
        InnerAdapter innerAdapter = new InnerAdapter();
        this.adapter = innerAdapter;
        this.extab_pay_list.setAdapter(innerAdapter);
        this.extab_pay_list.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK.1
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView, View view2, int i2, long j2) {
                LGEvTK lGEvTK = LGEvTK.this;
                lGEvTK.onItemChildClicked(i2, (RfybaJKCLilYpc) lGEvTK.payChannelList.get(i2));
                return true;
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_pay_select_card_vertial, (ViewGroup) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void proceeInnerFragment(int r18, com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc r19) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.vertial.LGEvTK.proceeInnerFragment(int, com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc):void");
    }
}
