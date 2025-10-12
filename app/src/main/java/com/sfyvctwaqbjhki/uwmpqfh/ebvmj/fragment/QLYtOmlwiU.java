package com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.NNXOHlAajkUISYActivity;

/* loaded from: classes.dex */
public class QLYtOmlwiU extends NNXOHlAajkUISY {
    private final String LIST_PROBLEM;
    private final String LIST_TYPE;
    private String[] channels;
    private String[][] child;
    private String[] group;
    private ExpandableListView list_problem;
    private ListView list_type;
    private ProblemAdapter problemAdapter;
    private TypeAdapter typeAdapter;

    class ProblemAdapter extends BaseExpandableListAdapter {
        private ViewChild mViewChild;
        private int select = -1;

        class ViewChild {
            TextView gridView;
            ImageView imageView;
            LinearLayout layout_line;
            TextView textView;

            ViewChild() {
            }
        }

        ProblemAdapter() {
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i2, int i3) {
            return QLYtOmlwiU.this.child[i2][i3];
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i2, int i3) {
            return i3;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
            if (view == null) {
                this.mViewChild = new ViewChild();
                view = LayoutInflater.from(QLYtOmlwiU.this.getContext()).inflate(R.layout.cg_expandlist_item, (ViewGroup) null);
                this.mViewChild.gridView = (TextView) view.findViewById(R.id.txt_item_child_gridView);
                view.setTag(this.mViewChild);
            } else {
                this.mViewChild = (ViewChild) view.getTag();
            }
            this.mViewChild.gridView.setText(getChild(i2, i3).toString());
            this.mViewChild.gridView.setTextColor(Color.argb(255, 191, 191, 191));
            this.mViewChild.gridView.setBackgroundColor(Color.argb(50, 255, 255, 255));
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i2) {
            return QLYtOmlwiU.this.child[i2].length;
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i2) {
            return QLYtOmlwiU.this.group[i2];
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return QLYtOmlwiU.this.group.length;
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i2) {
            return i2;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
            if (view == null) {
                this.mViewChild = new ViewChild();
                view = LayoutInflater.from(QLYtOmlwiU.this.getContext()).inflate(R.layout.cg_expandlist, (ViewGroup) null);
                this.mViewChild.textView = (TextView) view.findViewById(R.id.txt_group_name);
                this.mViewChild.imageView = (ImageView) view.findViewById(R.id.txt_imageview_orientation);
                this.mViewChild.layout_line = (LinearLayout) view.findViewById(R.id.layout_line);
                view.setTag(this.mViewChild);
            }
            ViewChild viewChild = (ViewChild) view.getTag();
            this.mViewChild = viewChild;
            if (z2) {
                viewChild.layout_line.setVisibility(8);
                view.setBackgroundColor(Color.argb(50, 255, 255, 255));
                this.mViewChild.imageView.setVisibility(8);
            } else {
                viewChild.layout_line.setVisibility(0);
                view.setBackgroundResource(R.color.cg_trancelucent);
                this.mViewChild.imageView.setVisibility(0);
                this.mViewChild.imageView.setImageResource(R.drawable.cg_icon_item_arrow);
            }
            this.mViewChild.textView.setText(getGroup(i2).toString());
            this.mViewChild.textView.setTextColor(Color.argb(255, 191, 191, 191));
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i2, int i3) {
            return true;
        }
    }

    class TypeAdapter extends BaseAdapter {
        private int select = 0;

        class ViewHolder {
            ImageView img_bg;
            TextView txt_name;

            ViewHolder() {
            }
        }

        TypeAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return QLYtOmlwiU.this.channels.length;
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
            int i3;
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = LayoutInflater.from(QLYtOmlwiU.this.getContext()).inflate(R.layout.cg_problem_type_item, (ViewGroup) null);
                viewHolder.img_bg = (ImageView) viewInflate.findViewById(R.id.img_bg);
                viewHolder.txt_name = (TextView) viewInflate.findViewById(R.id.txt_name);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            if (i2 == this.select) {
                i3 = -1;
                viewHolder2.img_bg.setBackgroundResource(R.drawable.cg_bg_btn_blue);
            } else {
                i3 = -7829368;
                viewHolder2.img_bg.setBackgroundResource(R.drawable.cg_bg_btn_gray);
            }
            viewHolder2.txt_name.setTextColor(i3);
            viewHolder2.txt_name.setText(QLYtOmlwiU.this.channels[i2]);
            return view;
        }
    }

    public QLYtOmlwiU(NNXOHlAajkUISYActivity nNXOHlAajkUISYActivity) {
        super(nNXOHlAajkUISYActivity);
        this.LIST_PROBLEM = "list_problem";
        this.LIST_TYPE = "list_type";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doClick(int i2) {
        if (this.problemAdapter.select == -1) {
            this.list_problem.expandGroup(i2);
            this.problemAdapter.select = i2;
        } else if (this.problemAdapter.select == i2) {
            this.list_problem.collapseGroup(this.problemAdapter.select);
            this.problemAdapter.select = -1;
        } else {
            this.list_problem.expandGroup(i2);
            this.list_problem.collapseGroup(this.problemAdapter.select);
            this.problemAdapter.select = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(int i2) {
        if (i2 == 0) {
            this.group = getResources().getStringArray(R.array.customer_question);
            this.child = new String[][]{new String[]{getContext().getString(R.string.ui_customer_answer_about_pwd)}, new String[]{getContext().getString(R.string.ui_customer_answer_about_account)}, new String[]{getContext().getString(R.string.ui_customer_answer_about_update)}, new String[]{getContext().getString(R.string.ui_customer_answer_about_modify_pwd)}, new String[]{getContext().getString(R.string.ui_customer_answer_about_change_accd)}, new String[]{getContext().getString(R.string.ui_customer_answer_about_bind_email)}};
        } else {
            this.group = getResources().getStringArray(R.array.customer_question_pay_type);
            this.child = new String[][]{new String[]{getContext().getString(R.string.ui_customer_answer_payment)}};
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public void onCreat(View view) {
        this.list_problem = (ExpandableListView) findViewById(R.id.list_problem);
        this.list_type = (ListView) findViewById(R.id.list_type);
        ((TextView) findViewById(R.id.customer_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.QLYtOmlwiU.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (Response.getInstance().getEDakAXiM() == null || Response.getInstance().getEDakAXiM().getPublics().getFbUrl() == null) {
                    return;
                }
                QLYtOmlwiU.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getEDakAXiM().getPublics().getFbUrl())));
            }
        });
        this.channels = getResources().getStringArray(R.array.customer_question_type);
        TypeAdapter typeAdapter = new TypeAdapter();
        this.typeAdapter = typeAdapter;
        this.list_type.setAdapter((ListAdapter) typeAdapter);
        this.list_type.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.QLYtOmlwiU.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                QLYtOmlwiU.this.typeAdapter.select = i2;
                QLYtOmlwiU.this.typeAdapter.notifyDataSetChanged();
                QLYtOmlwiU qLYtOmlwiU = QLYtOmlwiU.this;
                qLYtOmlwiU.initData(qLYtOmlwiU.typeAdapter.select);
                QLYtOmlwiU.this.problemAdapter.notifyDataSetChanged();
                QLYtOmlwiU.this.list_problem.collapseGroup(QLYtOmlwiU.this.problemAdapter.select);
                QLYtOmlwiU.this.problemAdapter.select = -1;
            }
        });
        initData(this.typeAdapter.select);
        ProblemAdapter problemAdapter = new ProblemAdapter();
        this.problemAdapter = problemAdapter;
        this.list_problem.setAdapter(problemAdapter);
        this.list_problem.setGroupIndicator(null);
        this.list_problem.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.QLYtOmlwiU.3
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView, View view2, int i2, long j2) {
                QLYtOmlwiU.this.doClick(i2);
                return true;
            }
        });
        this.list_problem.setOnChildClickListener(new ExpandableListView.OnChildClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.fragment.QLYtOmlwiU.4
            @Override // android.widget.ExpandableListView.OnChildClickListener
            public boolean onChildClick(ExpandableListView expandableListView, View view2, int i2, int i3, long j2) {
                QLYtOmlwiU.this.doClick(i2);
                return true;
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.lebktch.NNXOHlAajkUISY
    public View onCreateView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.cg_fragment_customer_probleme, (ViewGroup) null);
    }
}
