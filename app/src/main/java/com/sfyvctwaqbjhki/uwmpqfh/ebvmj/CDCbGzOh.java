package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SmMyRuq;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class CDCbGzOh extends SLdJjpRXaI {
    private final String BTN_OK;
    private final String CHECKBOX_AGREE;
    private final String DATE_PICKER;
    private Button button_ok;
    private CheckBox checkBox_agree;
    private DatePicker datePicker;
    private DateAdapter dayAdapter;
    private RelativeLayout dayBlock;
    private ListView dayListView;
    private ArrayAdapter<String> day_adapter;
    private SmMyRuq day_select_list;
    private RelativeLayout day_select_list_layout;
    private ArrayList days28;
    private ArrayList days29;
    private ArrayList days30;
    private ArrayList days31;
    private DateAdapter monthAdapter;
    private RelativeLayout monthBlock;
    private ListView monthListView;
    private ArrayAdapter<String> month_adapter;
    private SmMyRuq month_select_list;
    private RelativeLayout month_select_list_layout;
    private ArrayList months;
    private Spinner sp_day;
    private Spinner sp_month;
    private Spinner sp_year;
    private TextView tv_day;
    private TextView tv_month;
    private TextView tv_protocol;
    private TextView tv_year;
    private DateAdapter yearAdapter;
    private RelativeLayout yearBlock;
    private ListView yearListView;
    private ArrayAdapter<String> year_adapter;
    private SmMyRuq year_select_list;
    private RelativeLayout year_select_list_layout;
    private ArrayList years;

    private class ClickSpannable extends ClickableSpan implements View.OnClickListener {
        private View.OnClickListener onClickListener;

        public ClickSpannable(View.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            this.onClickListener.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    private class DateAdapter extends BaseAdapter {
        private List list;

        class ViewHolder {
            TextView textView;

            ViewHolder() {
            }
        }

        public DateAdapter(List list) {
            this.list = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.size();
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
                view = LayoutInflater.from(((SLdJjpRXaI) CDCbGzOh.this).context).inflate(R.layout.cg_spinner_item, (ViewGroup) null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.text1);
                view.setTag(viewHolder);
            }
            ((ViewHolder) view.getTag()).textView.setText("" + this.list.get(i2));
            return view;
        }

        public void updateList(List list) {
            this.list = list;
        }
    }

    public CDCbGzOh(Context context) {
        super(context);
        this.BTN_OK = "btn_ok";
        this.DATE_PICKER = "date_picker";
        this.CHECKBOX_AGREE = "checkBox_agree";
        this.years = new ArrayList();
        this.months = new ArrayList();
        this.days31 = new ArrayList();
        this.days30 = new ArrayList();
        this.days29 = new ArrayList();
        this.days28 = new ArrayList();
        int i2 = Calendar.getInstance().get(1);
        for (int i3 = i2 - 100; i3 <= i2; i3++) {
            this.years.add(Integer.valueOf(i3));
        }
        for (int i4 = 1; i4 <= 12; i4++) {
            this.months.add(Integer.valueOf(i4));
        }
        for (int i5 = 1; i5 <= 31; i5++) {
            this.days31.add(Integer.valueOf(i5));
        }
        for (int i6 = 1; i6 <= 30; i6++) {
            this.days30.add(Integer.valueOf(i6));
        }
        for (int i7 = 1; i7 <= 29; i7++) {
            this.days29.add(Integer.valueOf(i7));
        }
        for (int i8 = 1; i8 <= 28; i8++) {
            this.days28.add(Integer.valueOf(i8));
        }
    }

    private void btnClick() throws NumberFormatException {
        if (!this.checkBox_agree.isChecked()) {
            OrmagP.createAndShow("Hãy chấp nhận điều khoản người dùng");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        boolean z2 = true;
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = Integer.parseInt(this.tv_year.getText().toString());
        int i6 = Integer.parseInt(this.tv_month.getText().toString());
        int i7 = Integer.parseInt(this.tv_day.getText().toString());
        if (i2 - i5 < 18 || (i3 - i5 == 18 && (i3 < i6 || (i3 == i6 && i4 < i7)))) {
            z2 = false;
        }
        if (!z2) {
            OrmagP.createAndShow("Chưa đủ 18 tuổi, không thể chơi game");
        } else {
            dismiss();
            AccTipsManager.getInstance().regCommonAccTip(getContext());
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) throws NumberFormatException {
        if (isDoubleClick()) {
            return;
        }
        String str = (String) view.getTag();
        str.hashCode();
        if (str.equals("btn_ok")) {
            btnClick();
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return getContext().getResources().getConfiguration().orientation == 2 ? R.layout.cg_activity_rating : R.layout.cg_activity_rating_portrait;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        this.checkBox_agree = (CheckBox) findViewById(R.id.checkBox_agree);
        this.button_ok = (Button) findViewById(R.id.btn_ok);
        this.datePicker = (DatePicker) findViewById(R.id.date_picker);
        this.tv_protocol = (TextView) findViewById(R.id.tv_protocol);
        this.sp_year = (Spinner) findViewById(R.id.sp_year);
        this.sp_month = (Spinner) findViewById(R.id.sp_month);
        this.sp_day = (Spinner) findViewById(R.id.sp_day);
        Activity context = getContext();
        int i2 = R.layout.cg_spinner_item;
        this.year_adapter = new ArrayAdapter<>(context, i2);
        this.month_adapter = new ArrayAdapter<>(getContext(), i2);
        this.day_adapter = new ArrayAdapter<>(getContext(), i2);
        this.year_adapter.addAll(this.years);
        this.month_adapter.addAll(this.months);
        this.day_adapter.addAll(this.days31);
        this.sp_year.setAdapter((SpinnerAdapter) this.year_adapter);
        this.sp_month.setAdapter((SpinnerAdapter) this.month_adapter);
        this.sp_day.setAdapter((SpinnerAdapter) this.day_adapter);
        this.sp_year.setSelection(this.years.indexOf(1995));
        this.sp_month.setSelection(0);
        this.sp_day.setSelection(0);
        this.sp_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j2) throws NumberFormatException {
                CDCbGzOh.this.day_adapter.clear();
                int iIntValue = ((Integer) CDCbGzOh.this.months.get(i3)).intValue();
                if (iIntValue == 2) {
                    int i4 = Integer.parseInt(CDCbGzOh.this.sp_year.getSelectedItem().toString());
                    if ((i4 % 4 != 0 || i4 % 100 == 0) && i4 % Constants.MINIMAL_ERROR_STATUS_CODE != 0) {
                        CDCbGzOh.this.day_adapter.addAll(CDCbGzOh.this.days28);
                        return;
                    } else {
                        CDCbGzOh.this.day_adapter.addAll(CDCbGzOh.this.days29);
                        return;
                    }
                }
                if (iIntValue == 1 || iIntValue == 3 || iIntValue == 5 || iIntValue == 7 || iIntValue == 8 || iIntValue == 10 || iIntValue == 12) {
                    CDCbGzOh.this.day_adapter.addAll(CDCbGzOh.this.days31);
                } else {
                    CDCbGzOh.this.day_adapter.addAll(CDCbGzOh.this.days30);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        String str = "Tôi đã đọc và đồng ý Điều khoản sử dụng";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ClickSpannable(this), str.indexOf("Điều khoản sử dụng"), str.indexOf("Điều khoản sử dụng") + 18, 33);
        this.tv_protocol.setMovementMethod(LinkMovementMethod.getInstance());
        this.tv_protocol.setText(spannableStringBuilder);
        this.button_ok.setTag("btn_ok");
        this.button_ok.setOnTouchListener(this);
        this.datePicker.init(1995, 0, 1, null);
        this.datePicker.setMaxDate(new Date().getTime());
        this.checkBox_agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2) {
                    CDCbGzOh.this.button_ok.setBackgroundColor(Color.parseColor("#36AFF7"));
                } else {
                    CDCbGzOh.this.button_ok.setBackgroundColor(Color.parseColor("#636363"));
                }
            }
        });
        this.yearListView = (ListView) findViewById(R.id.year_select);
        this.monthListView = (ListView) findViewById(R.id.month_select);
        this.dayListView = (ListView) findViewById(R.id.day_select);
        this.year_select_list = (SmMyRuq) findViewById(R.id.year_select_list);
        this.month_select_list = (SmMyRuq) findViewById(R.id.month_select_list);
        this.day_select_list = (SmMyRuq) findViewById(R.id.day_select_list);
        this.yearBlock = (RelativeLayout) findViewById(R.id.year_block);
        this.monthBlock = (RelativeLayout) findViewById(R.id.month_block);
        this.dayBlock = (RelativeLayout) findViewById(R.id.day_block);
        this.year_select_list_layout = (RelativeLayout) findViewById(R.id.year_select_list_layout);
        this.month_select_list_layout = (RelativeLayout) findViewById(R.id.month_select_list_layout);
        this.day_select_list_layout = (RelativeLayout) findViewById(R.id.day_select_list_layout);
        this.year_select_list_layout.setVisibility(4);
        this.month_select_list_layout.setVisibility(4);
        this.day_select_list_layout.setVisibility(4);
        this.tv_year = (TextView) findViewById(R.id.tv_year);
        this.tv_month = (TextView) findViewById(R.id.tv_month);
        this.tv_day = (TextView) findViewById(R.id.tv_day);
        this.tv_year.setText("1995");
        this.tv_month.setText("1");
        this.tv_day.setText("1");
        this.yearBlock.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CDCbGzOh.this.year_select_list_layout.getVisibility() == 0) {
                    CDCbGzOh.this.year_select_list.setVisibility(4);
                    CDCbGzOh.this.year_select_list_layout.setVisibility(4);
                    CDCbGzOh.this.yearListView.setVisibility(4);
                } else {
                    CDCbGzOh.this.year_select_list.setVisibility(0);
                    CDCbGzOh.this.year_select_list_layout.setVisibility(0);
                    CDCbGzOh.this.yearListView.setVisibility(0);
                }
            }
        });
        this.monthBlock.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CDCbGzOh.this.month_select_list_layout.getVisibility() == 0) {
                    CDCbGzOh.this.month_select_list.setVisibility(4);
                    CDCbGzOh.this.month_select_list_layout.setVisibility(4);
                    CDCbGzOh.this.monthListView.setVisibility(4);
                } else {
                    CDCbGzOh.this.month_select_list.setVisibility(0);
                    CDCbGzOh.this.month_select_list_layout.setVisibility(0);
                    CDCbGzOh.this.monthListView.setVisibility(0);
                }
            }
        });
        this.dayBlock.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CDCbGzOh.this.day_select_list_layout.getVisibility() == 0) {
                    CDCbGzOh.this.day_select_list.setVisibility(4);
                    CDCbGzOh.this.day_select_list_layout.setVisibility(4);
                    CDCbGzOh.this.dayListView.setVisibility(4);
                } else {
                    CDCbGzOh.this.day_select_list.setVisibility(0);
                    CDCbGzOh.this.day_select_list_layout.setVisibility(0);
                    CDCbGzOh.this.dayListView.setVisibility(0);
                }
            }
        });
        this.year_select_list.setVisibility(8);
        this.year_select_list.setAnimations(1, 1);
        this.month_select_list.setVisibility(8);
        this.month_select_list.setAnimations(1, 1);
        this.day_select_list.setVisibility(8);
        this.day_select_list.setAnimations(1, 1);
        this.yearAdapter = new DateAdapter(this.years);
        this.monthAdapter = new DateAdapter(this.months);
        this.dayAdapter = new DateAdapter(this.days31);
        this.yearListView.setAdapter((ListAdapter) this.yearAdapter);
        this.monthListView.setAdapter((ListAdapter) this.monthAdapter);
        this.dayListView.setAdapter((ListAdapter) this.dayAdapter);
        this.yearListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) {
                CDCbGzOh.this.yearListView.setVisibility(8);
                CDCbGzOh.this.year_select_list.setVisibility(8);
                CDCbGzOh.this.tv_year.setText("" + CDCbGzOh.this.years.get(i3));
            }
        });
        this.monthListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) throws NumberFormatException {
                CDCbGzOh.this.monthListView.setVisibility(8);
                CDCbGzOh.this.month_select_list.setVisibility(8);
                CDCbGzOh.this.tv_month.setText("" + CDCbGzOh.this.months.get(i3));
                int iIntValue = ((Integer) CDCbGzOh.this.months.get(i3)).intValue();
                if (iIntValue == 2) {
                    int i4 = Integer.parseInt(CDCbGzOh.this.tv_year.getText().toString());
                    if ((i4 % 4 != 0 || i4 % 100 == 0) && i4 % Constants.MINIMAL_ERROR_STATUS_CODE != 0) {
                        CDCbGzOh.this.dayAdapter.updateList(CDCbGzOh.this.days28);
                    } else {
                        CDCbGzOh.this.dayAdapter.updateList(CDCbGzOh.this.days29);
                    }
                } else if (iIntValue == 1 || iIntValue == 3 || iIntValue == 5 || iIntValue == 7 || iIntValue == 8 || iIntValue == 10 || iIntValue == 12) {
                    CDCbGzOh.this.dayAdapter.updateList(CDCbGzOh.this.days31);
                } else {
                    CDCbGzOh.this.dayAdapter.updateList(CDCbGzOh.this.days30);
                }
                CDCbGzOh.this.dayAdapter.notifyDataSetChanged();
            }
        });
        this.dayListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.CDCbGzOh.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) {
                CDCbGzOh.this.dayListView.setVisibility(8);
                CDCbGzOh.this.day_select_list.setVisibility(8);
                CDCbGzOh.this.tv_day.setText("" + CDCbGzOh.this.days31.get(i3));
            }
        });
        this.checkBox_agree.setChecked(true);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        String pg_protocol_url = Response.getInstance().getEDakAXiM().getPublics().getPg_protocol_url();
        if (pg_protocol_url == null || "".equals(pg_protocol_url)) {
            return;
        }
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(pg_protocol_url)));
    }
}
