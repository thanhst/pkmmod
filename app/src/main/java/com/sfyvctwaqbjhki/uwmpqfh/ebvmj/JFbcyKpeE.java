package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SmMyRuq;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class JFbcyKpeE extends SLdJjpRXaI {
    private final String BTN_CHANGE_LOGIN;
    private final String BTN_LOGIN;
    private final String BTN_REGISTER;
    private final String IMG_CLEAR_PWD;
    private final String LAYOUT_ACC_SELECT;
    private final String TXT_FOGRET_PWD;
    private String basePwd;
    private Button btn_change_login;
    private Button btn_login;
    private Button btn_register;
    private EditText edit_account;
    private EditText edit_pwd;
    private ImageView img_clear_pwd;
    private RelativeLayout layout_acc_select;
    private SmMyRuq layout_select_list;
    private RelativeLayout layout_select_list_layout;
    private ListView list_select;
    private String password;
    private TextView txt_fogret_pwd;
    private List<UserInfo> userInfos;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JFbcyKpeE$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons = iArr;
            try {
                iArr[Buttons.LAYOUT_ACC_SELECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons[Buttons.TXT_FOGRET_PWD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons[Buttons.BTN_LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons[Buttons.BTN_CHANGE_LOGIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons[Buttons.BTN_REGISTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons[Buttons.IMG_CLEAR_PWD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private enum Buttons {
        LAYOUT_ACC_SELECT,
        TXT_FOGRET_PWD,
        BTN_LOGIN,
        BTN_CHANGE_LOGIN,
        BTN_REGISTER,
        IMG_CLEAR_PWD
    }

    private class NameAdapter extends BaseAdapter {

        class ViewHolder {
            RelativeLayout button;
            ImageView img_close;
            TextView textView;

            ViewHolder() {
            }
        }

        public NameAdapter() {
            List<UserInfo> allUser = PBvElADcPX.getAllUser();
            JFbcyKpeE.this.userInfos = new ArrayList();
            for (int i2 = 0; i2 < allUser.size(); i2++) {
                if (allUser.get(i2).getIsDead() == 0 && (allUser.get(i2).getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || allUser.get(i2).getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL)) {
                    JFbcyKpeE.this.userInfos.add(allUser.get(i2));
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return JFbcyKpeE.this.userInfos.size();
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
                view = LayoutInflater.from(((SLdJjpRXaI) JFbcyKpeE.this).context).inflate(R.layout.cg_login_select_item, (ViewGroup) null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.txt_name);
                viewHolder.button = (RelativeLayout) view.findViewById(R.id.btn_close);
                viewHolder.img_close = (ImageView) view.findViewById(R.id.img_close);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            if (((UserInfo) JFbcyKpeE.this.userInfos.get(i2)).getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                viewHolder2.textView.setText(((SLdJjpRXaI) JFbcyKpeE.this).context.getString(R.string.txt_name_vistor) + ((UserInfo) JFbcyKpeE.this.userInfos.get(i2)).getUserName());
            } else {
                viewHolder2.textView.setText(((UserInfo) JFbcyKpeE.this.userInfos.get(i2)).getUserName());
            }
            viewHolder2.img_close.setImageResource(R.drawable.cg_img_close);
            viewHolder2.button.setTag(Integer.valueOf(i2));
            viewHolder2.button.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JFbcyKpeE.NameAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(final View view2) {
                    WxGIMQL.createAndShow(((SLdJjpRXaI) JFbcyKpeE.this).context.getString(R.string.txt_delete_account), ((SLdJjpRXaI) JFbcyKpeE.this).context.getString(R.string.txt_are_you_sure) + ((UserInfo) JFbcyKpeE.this.userInfos.get(Integer.parseInt(view2.getTag().toString()))).getUserName() + ((SLdJjpRXaI) JFbcyKpeE.this).context.getString(R.string.txt_delete_from_table), ((SLdJjpRXaI) JFbcyKpeE.this).context.getString(R.string.txt_cancel), ((SLdJjpRXaI) JFbcyKpeE.this).context.getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JFbcyKpeE.NameAdapter.1.1
                        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
                        public void cancel() {
                        }

                        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
                        public void confirm() {
                            PBvElADcPX.deleteUser((UserInfo) JFbcyKpeE.this.userInfos.get(Integer.parseInt(view2.getTag().toString())));
                            JFbcyKpeE.this.userInfos.remove(JFbcyKpeE.this.userInfos.get(Integer.parseInt(view2.getTag().toString())));
                            if (JFbcyKpeE.this.userInfos.size() <= 0) {
                                JFbcyKpeE.this.edit_account.setText("");
                            }
                            NameAdapter.this.notifyDataSetChanged();
                        }
                    });
                }
            });
            return view;
        }
    }

    public JFbcyKpeE(Context context) {
        super(context);
        this.LAYOUT_ACC_SELECT = "layout_acc_select";
        this.TXT_FOGRET_PWD = "txt_fogret_pwd";
        this.BTN_LOGIN = "btn_login";
        this.BTN_CHANGE_LOGIN = "txt_change_login";
        this.BTN_REGISTER = "btn_register";
        this.IMG_CLEAR_PWD = "img_clear_pwd";
        this.password = "";
        this.basePwd = "";
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) throws NoSuchAlgorithmException {
        String str;
        if (isDoubleClick()) {
        }
        switch (AnonymousClass4.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$JFbcyKpeE$Buttons[((Buttons) view.getTag()).ordinal()]) {
            case 1:
                this.edit_account.requestFocus();
                if (this.layout_select_list_layout.getVisibility() != 0) {
                    this.layout_select_list.setVisibility(0);
                    this.layout_select_list_layout.setVisibility(0);
                    break;
                } else {
                    this.layout_select_list.setVisibility(4);
                    this.layout_select_list_layout.setVisibility(4);
                    break;
                }
            case 2:
                jumpToActivity(new ZxCBKtlNarIqgjb(this.context));
                break;
            case 3:
                String strTrim = this.edit_pwd.getText().toString().trim();
                if (!this.edit_account.getText().toString().trim().equals("")) {
                    if (!strTrim.equals("")) {
                        if (this.password.equals(strTrim)) {
                            str = this.basePwd;
                        } else if (strTrim.length() < 6 || strTrim.length() > 20) {
                            Toast.makeText(this.context, R.string.txt_password_err, 0).show();
                            break;
                        } else {
                            str = strTrim;
                            strTrim = CryptogramUtil.encryptMD5(strTrim);
                        }
                        String strTrim2 = this.edit_account.getText().toString().trim();
                        UserInfo userInfo = new UserInfo();
                        userInfo.setUserName(strTrim2);
                        userInfo.setPassword(strTrim);
                        userInfo.setBasepwd(str);
                        NetParamsBean netParamsBean = new NetParamsBean();
                        netParamsBean.setAutoLogin(false);
                        Response.getInstance().setNetParamsBean(netParamsBean);
                        Response.getInstance().setUserInfo(userInfo);
                        jumpToActivity(new VwEiglxMTZuLV(this.context));
                        break;
                    } else {
                        Toast.makeText(this.context, R.string.txt_hint_password, 0).show();
                        break;
                    }
                } else {
                    Toast.makeText(this.context, R.string.txt_hint_account, 0).show();
                    break;
                }
                break;
            case 4:
                jumpToActivity(new OMUbvus(this.context));
                break;
            case 5:
                if (Response.getInstance().getConfigBean().getIsVNCheck() != 1) {
                    jumpToActivity(new AJlqeOYiZ(this.context, 2));
                    break;
                } else {
                    this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getEDakAXiM().getPublics().getRegisterPage())));
                    break;
                }
            case 6:
                this.edit_pwd.setText("");
                this.img_clear_pwd.setVisibility(8);
                break;
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_login_two;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        int i2 = R.id.img_logo;
        findViewById(i2).setVisibility(0);
        findViewById(R.id.txt_title).setVisibility(8);
        findViewById(R.id.layout_close).setVisibility(8);
        findViewById(R.id.layout_back).setVisibility(8);
        this.edit_account = (EditText) findViewById(R.id.txt_account);
        this.edit_pwd = (EditText) findViewById(R.id.txt_password);
        this.img_clear_pwd = (ImageView) findViewById(R.id.img_clear_pwd);
        this.layout_select_list_layout = (RelativeLayout) findViewById(R.id.layout_select_list_layout);
        this.layout_select_list = (SmMyRuq) findViewById(R.id.layout_select_list);
        this.list_select = (ListView) findViewById(R.id.list_select);
        this.layout_acc_select = (RelativeLayout) findViewById(R.id.layout_acc_select);
        this.btn_login = (Button) findViewById(R.id.btn_login);
        this.btn_register = (Button) findViewById(R.id.btn_register);
        this.txt_fogret_pwd = (TextView) findViewById(R.id.txt_fogret_pwd);
        this.btn_change_login = (Button) findViewById(R.id.txt_change_login);
        this.layout_acc_select.setTag(Buttons.LAYOUT_ACC_SELECT);
        this.btn_login.setTag(Buttons.BTN_LOGIN);
        this.btn_register.setTag(Buttons.BTN_REGISTER);
        this.txt_fogret_pwd.setTag(Buttons.TXT_FOGRET_PWD);
        this.btn_change_login.setTag(Buttons.BTN_CHANGE_LOGIN);
        this.img_clear_pwd.setTag(Buttons.IMG_CLEAR_PWD);
        this.layout_acc_select.setOnTouchListener(this);
        this.btn_login.setOnTouchListener(this);
        this.btn_register.setOnTouchListener(this);
        this.txt_fogret_pwd.setOnTouchListener(this);
        this.btn_change_login.setOnTouchListener(this);
        this.img_clear_pwd.setOnTouchListener(this);
        this.layout_select_list_layout.setVisibility(8);
        this.layout_select_list.setVisibility(8);
        this.layout_select_list.setAnimations(1, 1);
        UserInfo userInfo = Response.getInstance().getUserInfo();
        if (userInfo == null || !(userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || userInfo.getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL)) {
            this.edit_account.setText("");
        } else {
            this.edit_account.setText(userInfo.getUserName());
        }
        this.list_select.setAdapter((ListAdapter) new NameAdapter());
        this.list_select.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JFbcyKpeE.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) {
                JFbcyKpeE.this.edit_account.setText(((UserInfo) JFbcyKpeE.this.userInfos.get(i3)).getUserName());
                JFbcyKpeE.this.edit_pwd.setText(((UserInfo) JFbcyKpeE.this.userInfos.get(i3)).getPassword());
                JFbcyKpeE.this.layout_select_list_layout.setVisibility(8);
                JFbcyKpeE jFbcyKpeE = JFbcyKpeE.this;
                jFbcyKpeE.password = ((UserInfo) jFbcyKpeE.userInfos.get(i3)).getPassword();
                JFbcyKpeE jFbcyKpeE2 = JFbcyKpeE.this;
                jFbcyKpeE2.basePwd = ((UserInfo) jFbcyKpeE2.userInfos.get(i3)).getBasepwd();
            }
        });
        this.edit_pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JFbcyKpeE.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z2) {
                if (!z2 || JFbcyKpeE.this.edit_pwd.getText().toString().trim().length() <= 0) {
                    JFbcyKpeE.this.img_clear_pwd.setVisibility(8);
                } else {
                    JFbcyKpeE.this.img_clear_pwd.setVisibility(0);
                }
            }
        });
        this.edit_pwd.addTextChangedListener(new TextWatcher() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.JFbcyKpeE.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!JFbcyKpeE.this.edit_pwd.hasFocus() || editable.toString().trim().length() <= 0) {
                    JFbcyKpeE.this.img_clear_pwd.setVisibility(8);
                } else {
                    JFbcyKpeE.this.img_clear_pwd.setVisibility(0);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }
        });
        ImageView imageView = (ImageView) findViewById(i2);
        if (Response.getInstance().getConfigBean().getIsVNCheck() == 1) {
            imageView.setImageResource(R.drawable.cg_18logo);
        } else {
            imageView.setImageResource(R.drawable.cg_logo);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.layout_select_list_layout.setVisibility(8);
        }
        return super.onTouchEvent(motionEvent);
    }
}
