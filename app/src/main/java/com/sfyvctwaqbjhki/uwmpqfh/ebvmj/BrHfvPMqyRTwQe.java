package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.biohepbeans.RfybaJKCLilYpc;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import java.util.List;

/* loaded from: classes.dex */
public class BrHfvPMqyRTwQe extends SLdJjpRXaI {
    private List<RfybaJKCLilYpc.Products> list;
    private Button mCloseBtn;
    private ListView mExchangeLv;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.BrHfvPMqyRTwQe$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$BrHfvPMqyRTwQe$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$BrHfvPMqyRTwQe$Buttons = iArr;
            try {
                iArr[Buttons.CLOSEBTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum Buttons {
        CLOSEBTN
    }

    private class ListAdapter extends BaseAdapter {

        class ViewHolder {
            TextView mMoneyTv;
            TextView mVirtualCoinTv;

            ViewHolder() {
            }
        }

        private ListAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (BrHfvPMqyRTwQe.this.list == null) {
                return 0;
            }
            return BrHfvPMqyRTwQe.this.list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return BrHfvPMqyRTwQe.this.list.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(((SLdJjpRXaI) BrHfvPMqyRTwQe.this).context).inflate(R.layout.cg_exchange_rate_item, (ViewGroup) null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.mMoneyTv = (TextView) view.findViewById(R.id.txt_money);
                viewHolder.mVirtualCoinTv = (TextView) view.findViewById(R.id.txt_virtual_coin);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            RfybaJKCLilYpc.Products products = (RfybaJKCLilYpc.Products) BrHfvPMqyRTwQe.this.list.get(i2);
            if (products == null) {
                return view;
            }
            viewHolder2.mMoneyTv.setText(products.getAmount() + " " + products.getCurrency() + " ");
            viewHolder2.mVirtualCoinTv.setText(" " + products.getGameCoin() + " " + products.getGameCurrency());
            return view;
        }
    }

    private BrHfvPMqyRTwQe(Context context) {
        super(context);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        if (AnonymousClass1.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$BrHfvPMqyRTwQe$Buttons[((Buttons) view.getTag()).ordinal()] != 1) {
            return;
        }
        dismiss();
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_dialog_exchange_rate;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        this.mExchangeLv = (ListView) findViewById(R.id.exchange_list);
        Button button = (Button) findViewById(R.id.close_btn);
        this.mCloseBtn = button;
        button.setTag(Buttons.CLOSEBTN);
        this.mCloseBtn.setOnTouchListener(this);
        this.mExchangeLv.setAdapter((android.widget.ListAdapter) new ListAdapter());
    }

    public BrHfvPMqyRTwQe(Context context, List<RfybaJKCLilYpc.Products> list) {
        this(context);
        this.list = list;
    }
}
