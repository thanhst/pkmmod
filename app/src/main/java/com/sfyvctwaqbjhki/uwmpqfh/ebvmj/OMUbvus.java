package com.sfyvctwaqbjhki.uwmpqfh.ebvmj;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.CryptogramUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.RandomUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.NetParamsBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.AccTipsManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.ThreeLoginManager;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.MhrJWomE;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.ZGJWDCUOkpgHBx;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI;
import com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SmMyRuq;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OMUbvus extends SLdJjpRXaI {
    private static final String FACEBOOK_LOGIN = "facebook";
    private static final String GOOGLE_LOGIN = "google";
    private static final String KAKAO_LOGIN = "kakao";
    private static final String LOGIN = "login";
    private static final String LOGIN_REGISTER = "login_register";
    private static final String REGISTER = "register";
    private List<String> bottomLoginList;
    private Button btn_fast;
    private LinearLayout gridLayout;
    private GridView grid_login;
    private RelativeLayout layout_main_login;
    private RelativeLayout layout_select;
    private SmMyRuq layout_select_list;
    private RelativeLayout layout_select_list_layout;
    private ListView listView;
    private String mainLogin;
    private ImageView ratingImgView;
    private List<UserInfo> userInfos;

    /* renamed from: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$OMUbvus$Buttons;

        static {
            int[] iArr = new int[Buttons.values().length];
            $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$OMUbvus$Buttons = iArr;
            try {
                iArr[Buttons.BTN_FAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$OMUbvus$Buttons[Buttons.LAYOUT_MAIN_LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$OMUbvus$Buttons[Buttons.LAYOUT_SELECT_NOCC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum Buttons {
        BTN_FAST,
        LAYOUT_MAIN_LOGIN,
        BTN_REGISTER,
        LAYOUT_SELECT_NOCC
    }

    private class GridViewAdapter extends BaseAdapter {

        class ViewHolder {
            ImageView img_login_icon;
            TextView txt_login_des;

            ViewHolder() {
            }
        }

        private GridViewAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OMUbvus.this.bottomLoginList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return OMUbvus.this.bottomLoginList.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(((SLdJjpRXaI) OMUbvus.this).context).inflate(R.layout.cg_login_grid_item, (ViewGroup) null);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.txt_login_des = (TextView) view.findViewById(R.id.txt_login_des);
                viewHolder2.img_login_icon = (ImageView) view.findViewById(R.id.img_login_icon);
                view.setTag(viewHolder2);
            }
            viewHolder = (ViewHolder) view.getTag();
            String str = (String) OMUbvus.this.bottomLoginList.get(i2);
            str.hashCode();
            switch (str) {
                case "login_register":
                    viewHolder.img_login_icon.setImageResource(R.drawable.cg_login_reg1);
                    viewHolder.txt_login_des.setText(R.string.txt_login_register);
                    return view;
                case "google":
                    viewHolder.img_login_icon.setImageResource(R.drawable.cg_google);
                    viewHolder.txt_login_des.setText("Google");
                    return view;
                case "register":
                    viewHolder.img_login_icon.setImageResource(R.drawable.cg_register);
                    viewHolder.txt_login_des.setText(R.string.txt_register_usa);
                    return view;
                case "kakao":
                    viewHolder.img_login_icon.setImageResource(R.drawable.cg_kakao);
                    viewHolder.txt_login_des.setText("Kakao");
                    return view;
                case "login":
                    viewHolder.img_login_icon.setImageResource(R.drawable.cg_login_reg);
                    viewHolder.txt_login_des.setText(R.string.txt_login);
                    return view;
                case "facebook":
                    viewHolder.img_login_icon.setImageResource(R.drawable.cg_icon_facebook);
                    viewHolder.txt_login_des.setText("Facebook");
                    return view;
                default:
                    return view;
            }
        }
    }

    private class NameAdapter extends BaseAdapter {

        class ViewHolder {
            RelativeLayout button;
            ImageView img_close;
            TextView textView;

            ViewHolder() {
            }
        }

        private NameAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OMUbvus.this.userInfos.size();
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
                view = LayoutInflater.from(((SLdJjpRXaI) OMUbvus.this).context).inflate(R.layout.cg_login_select_item, (ViewGroup) null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.txt_name);
                viewHolder.button = (RelativeLayout) view.findViewById(R.id.btn_close);
                viewHolder.img_close = (ImageView) view.findViewById(R.id.img_close);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            if (((UserInfo) OMUbvus.this.userInfos.get(i2)).getUserType() == ConstantUtil.USER_TYPE_VISTOR) {
                viewHolder2.textView.setText(((SLdJjpRXaI) OMUbvus.this).context.getString(R.string.txt_name_vistor) + ((UserInfo) OMUbvus.this.userInfos.get(i2)).getUserName());
            } else {
                viewHolder2.textView.setText(((UserInfo) OMUbvus.this.userInfos.get(i2)).getUserName());
            }
            viewHolder2.img_close.setImageResource(R.drawable.cg_img_close);
            if (((UserInfo) OMUbvus.this.userInfos.get(i2)).getUserId() == -1) {
                viewHolder2.img_close.setVisibility(4);
                viewHolder2.textView.setTextColor(-65536);
            } else {
                viewHolder2.img_close.setVisibility(0);
                viewHolder2.textView.setTextColor(Color.rgb(51, 181, 229));
            }
            viewHolder2.button.setTag(Integer.valueOf(i2));
            viewHolder2.button.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.NameAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(final View view2) {
                    WxGIMQL.createAndShow(((SLdJjpRXaI) OMUbvus.this).context.getString(R.string.txt_delete_account), ((SLdJjpRXaI) OMUbvus.this).context.getString(R.string.txt_are_you_sure) + ((UserInfo) OMUbvus.this.userInfos.get(Integer.parseInt(view2.getTag().toString()))).getUserName() + ((SLdJjpRXaI) OMUbvus.this).context.getString(R.string.txt_delete_from_table), ((SLdJjpRXaI) OMUbvus.this).context.getString(R.string.txt_cancel), ((SLdJjpRXaI) OMUbvus.this).context.getString(R.string.txt_confirm), new DoubleBtnCallBack() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.NameAdapter.1.1
                        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.DoubleBtnCallBack
                        public void cancel() {
                        }

                        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.SingleBtnCallBack
                        public void confirm() {
                            PBvElADcPX.deleteUser((UserInfo) OMUbvus.this.userInfos.get(Integer.parseInt(view2.getTag().toString())));
                            OMUbvus.this.userInfos.remove(OMUbvus.this.userInfos.get(Integer.parseInt(view2.getTag().toString())));
                            NameAdapter.this.notifyDataSetChanged();
                            if (OMUbvus.this.userInfos.size() <= 0) {
                                OMUbvus.this.setControlState();
                            }
                        }
                    });
                }
            });
            return view;
        }
    }

    public OMUbvus(Context context) {
        super(context);
        this.mainLogin = "facebook";
    }

    public static OMUbvus createAndShow(Context context) {
        OMUbvus oMUbvus = new OMUbvus(context);
        oMUbvus.show();
        return oMUbvus;
    }

    private void initLoginGrid() {
        final int size = this.bottomLoginList.size();
        this.grid_login.setHorizontalSpacing(0);
        this.grid_login.setStretchMode(0);
        this.grid_login.setNumColumns(size);
        this.grid_login.setSelector(new ColorDrawable(0));
        this.grid_login.setAdapter((ListAdapter) new GridViewAdapter());
        this.gridLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LinearLayout.LayoutParams layoutParams;
                OMUbvus.this.grid_login.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int i2 = OMUbvus.this.gridLayout.getLayoutParams().width;
                if (OMUbvus.this.bottomLoginList.size() < 3) {
                    int i3 = i2 / 2;
                    OMUbvus.this.grid_login.setColumnWidth(i3);
                    layoutParams = new LinearLayout.LayoutParams(i3 * size, -1);
                } else {
                    int i4 = i2 / 3;
                    OMUbvus.this.grid_login.setColumnWidth(i4);
                    layoutParams = new LinearLayout.LayoutParams(i4 * size, -1);
                }
                OMUbvus.this.grid_login.setLayoutParams(layoutParams);
            }
        });
        this.grid_login.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (OMUbvus.this.isDoubleClick()) {
                }
                String str = (String) OMUbvus.this.bottomLoginList.get(i2);
                str.hashCode();
                switch (str) {
                    case "login_register":
                        if (Response.getInstance().getConfigBean().getIsVNCheck() != 1) {
                            OMUbvus oMUbvus = OMUbvus.this;
                            oMUbvus.jumpToActivity(new JFbcyKpeE(oMUbvus.getContext()));
                            break;
                        } else {
                            ((SLdJjpRXaI) OMUbvus.this).context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Response.getInstance().getEDakAXiM().getPublics().getRegisterPage())));
                            break;
                        }
                    case "google":
                        ThreeLoginManager.getInstance().googlePlayLogin(OMUbvus.this);
                        break;
                    case "register":
                        OMUbvus oMUbvus2 = OMUbvus.this;
                        oMUbvus2.jumpToActivity(new AJlqeOYiZ(oMUbvus2.getContext(), 1));
                        break;
                    case "kakao":
                        ThreeLoginManager.getInstance().kakaoLogin(OMUbvus.this);
                        break;
                    case "login":
                        OMUbvus oMUbvus3 = OMUbvus.this;
                        oMUbvus3.jumpToActivity(new JFbcyKpeE(oMUbvus3.getContext()));
                        break;
                    case "facebook":
                        ThreeLoginManager.getInstance().facebookLogin(OMUbvus.this);
                        break;
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initMainAndBottom() {
        /*
            r5 = this;
            java.lang.String r0 = "bottom"
            java.lang.String r1 = "main"
            com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response r2 = com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.Response.getInstance()
            com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConfigBean r2 = r2.getConfigBean()
            java.lang.String r3 = r2.getLoginJson()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5.bottomLoginList = r4
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L49
            r4.<init>(r3)     // Catch: java.lang.Exception -> L49
            boolean r3 = r4.has(r1)     // Catch: java.lang.Exception -> L49
            if (r3 == 0) goto L28
            java.lang.String r1 = r4.getString(r1)     // Catch: java.lang.Exception -> L49
            r5.mainLogin = r1     // Catch: java.lang.Exception -> L49
        L28:
            boolean r1 = r4.has(r0)     // Catch: java.lang.Exception -> L49
            if (r1 == 0) goto L4d
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L49
            r1.<init>()     // Catch: java.lang.Exception -> L49
            java.lang.String r0 = r4.getString(r0)     // Catch: java.lang.Exception -> L49
            com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus$2 r3 = new com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus$2     // Catch: java.lang.Exception -> L49
            r3.<init>()     // Catch: java.lang.Exception -> L49
            java.lang.reflect.Type r3 = r3.getType()     // Catch: java.lang.Exception -> L49
            java.lang.Object r0 = r1.fromJson(r0, r3)     // Catch: java.lang.Exception -> L49
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> L49
            r5.bottomLoginList = r0     // Catch: java.lang.Exception -> L49
            goto L4d
        L49:
            r0 = move-exception
            r0.printStackTrace()
        L4d:
            int r0 = r2.getIsVNCheck()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto Laf
            java.lang.String r0 = r5.mainLogin
            r0.hashCode()
            r3 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -1240244679: goto L78;
                case 101812419: goto L6f;
                case 497130182: goto L64;
                default: goto L62;
            }
        L62:
            r2 = -1
            goto L82
        L64:
            java.lang.String r2 = "facebook"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6d
            goto L62
        L6d:
            r2 = 2
            goto L82
        L6f:
            java.lang.String r4 = "kakao"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L82
            goto L62
        L78:
            java.lang.String r2 = "google"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L81
            goto L62
        L81:
            r2 = 0
        L82:
            switch(r2) {
                case 0: goto La2;
                case 1: goto L94;
                case 2: goto L86;
                default: goto L85;
            }
        L85:
            goto Laf
        L86:
            android.app.Activity r0 = r5.context
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = com.sfyvctwaqbjhki.uwmpqfh.R.layout.cg_btn_lay_facebook
            android.widget.RelativeLayout r3 = r5.layout_main_login
            r0.inflate(r2, r3)
            goto Laf
        L94:
            android.app.Activity r0 = r5.context
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = com.sfyvctwaqbjhki.uwmpqfh.R.layout.cg_btn_lay_kakao
            android.widget.RelativeLayout r3 = r5.layout_main_login
            r0.inflate(r2, r3)
            goto Laf
        La2:
            android.app.Activity r0 = r5.context
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = com.sfyvctwaqbjhki.uwmpqfh.R.layout.cg_btn_lay_google
            android.widget.RelativeLayout r3 = r5.layout_main_login
            r0.inflate(r2, r3)
        Laf:
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            int r0 = r0.size()
            java.lang.String r2 = "register"
            java.lang.String r3 = "login"
            if (r0 != 0) goto Lc6
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            r0.add(r3)
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            r0.add(r2)
            goto Le5
        Lc6:
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto Le5
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto Le5
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            java.lang.String r2 = "login_register"
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto Le5
            java.util.List<java.lang.String> r0 = r5.bottomLoginList
            r0.add(r1, r2)
        Le5:
            r5.initLoginGrid()
            r5.initPrivacyLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.initMainAndBottom():void");
    }

    private void initPrivacyLayout() {
        final String privacyPolicyLink = Response.getInstance().getEDakAXiM().getPublics().getPrivacyPolicyLink();
        if (privacyPolicyLink.isEmpty()) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.privacy_tv);
        textView.getPaint().setFlags(8);
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3215e.lambda$initPrivacyLayout$0(privacyPolicyLink, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPrivacyLayout$0(String str, View view) {
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private void mainLogin() {
        String str = this.mainLogin;
        str.hashCode();
        switch (str) {
            case "google":
                ThreeLoginManager.getInstance().googlePlayLogin(this);
                break;
            case "kakao":
                ThreeLoginManager.getInstance().kakaoLogin(this);
                break;
            case "facebook":
                ThreeLoginManager.getInstance().facebookLogin(this);
                break;
        }
    }

    private void register() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("");
        String strGenRandom = RandomUtil.genRandom(8);
        userInfo.setPassword(CryptogramUtil.encryptMD5(strGenRandom));
        userInfo.setBasepwd(strGenRandom);
        userInfo.setAccountType(ConstantUtil.ACCOUNTTYPE_NORMAL);
        userInfo.setEmail("");
        Response.getInstance().setUserInfo(userInfo);
        Response.getInstance().setNetParamsBean(new NetParamsBean());
        MhrJWomE.netRegister(new UserManager(UserManager.Type.REGISTER) { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.1
            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void fail(int i2, String str) {
                WoUjMp.getInstance().setLogin(false);
                ZGJWDCUOkpgHBx.loginFail(str);
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.UserManager
            public void response(Response response) {
                OMUbvus.this.dismiss();
                WoUjMp.getInstance().setLogin(true);
                ZGJWDCUOkpgHBx.loginSuccess(response.getToken(), response.getUserInfo());
                AccTipsManager.getInstance().visitorEntry(((SLdJjpRXaI) OMUbvus.this).context, response.getUserInfo().getUserId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControlState() {
        List<UserInfo> allUser = PBvElADcPX.getAllUser();
        this.userInfos = new ArrayList();
        for (int i2 = 0; i2 < allUser.size(); i2++) {
            if (allUser.get(i2).getIsDead() == 0 && (allUser.get(i2).getAccountType() == ConstantUtil.ACCOUNTTYPE_NORMAL || allUser.get(i2).getAccountType() == ConstantUtil.ACCOUNTTYPE_EMAIL)) {
                this.userInfos.add(allUser.get(i2));
            }
        }
        if (this.userInfos.size() == 0) {
            Response.getInstance().setUserInfo(null);
            this.btn_fast.setVisibility(0);
            this.layout_select.setVisibility(8);
            this.layout_select_list_layout.setVisibility(8);
            return;
        }
        this.btn_fast.setVisibility(8);
        this.layout_select.setVisibility(0);
        this.layout_select_list_layout.setVisibility(8);
        this.listView.setAdapter((ListAdapter) new NameAdapter());
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sfyvctwaqbjhki.uwmpqfh.ebvmj.OMUbvus.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) {
                OMUbvus.this.layout_select_list.setVisibility(8);
                Response.getInstance().setUserInfo((UserInfo) OMUbvus.this.userInfos.get(i3));
                OMUbvus oMUbvus = OMUbvus.this;
                oMUbvus.click(oMUbvus.btn_fast);
            }
        });
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void click(View view) {
        if (isDoubleClick()) {
            return;
        }
        int i2 = AnonymousClass6.$SwitchMap$com$sfyvctwaqbjhki$uwmpqfh$ebvmj$OMUbvus$Buttons[((Buttons) view.getTag()).ordinal()];
        if (i2 == 1) {
            if (Response.getInstance().getUserInfo() == null) {
                register();
                return;
            }
            NetParamsBean netParamsBean = new NetParamsBean();
            netParamsBean.setAutoLogin(false);
            Response.getInstance().setNetParamsBean(netParamsBean);
            jumpToActivity(new VwEiglxMTZuLV(this.context));
            return;
        }
        if (i2 == 2) {
            mainLogin();
            return;
        }
        if (i2 != 3) {
            return;
        }
        if (this.layout_select_list_layout.getVisibility() == 0) {
            this.layout_select_list.setVisibility(4);
            this.layout_select_list_layout.setVisibility(4);
        } else {
            this.layout_select_list.setVisibility(0);
            this.layout_select_list_layout.setVisibility(0);
        }
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected int createView() {
        return R.layout.cg_activity_login;
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    public void dismiss() {
        this.ratingImgView.setVisibility(4);
        super.dismiss();
        WoUjMp.getInstance().setActivityListener(null);
    }

    @Override // com.sfyvctwaqbjhki.uwmpqfh.qnaumypvbsxtz.SLdJjpRXaI
    protected void initView() {
        Button button = (Button) findViewById(R.id.btn_fast);
        this.btn_fast = button;
        button.setTag(Buttons.BTN_FAST);
        this.btn_fast.setOnTouchListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_main_login);
        this.layout_main_login = relativeLayout;
        relativeLayout.setTag(Buttons.LAYOUT_MAIN_LOGIN);
        this.layout_main_login.setOnTouchListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.layout_select);
        this.layout_select = relativeLayout2;
        relativeLayout2.setTag(Buttons.LAYOUT_SELECT_NOCC);
        this.layout_select.setOnTouchListener(this);
        this.ratingImgView = (ImageView) findViewById(R.id.img_rating_18);
        if (Response.getInstance().getEDakAXiM().getPublics().getPg_is_rating() != 0) {
            this.ratingImgView.setVisibility(0);
        }
        this.layout_select_list_layout = (RelativeLayout) findViewById(R.id.layout_select_list_layout);
        SmMyRuq smMyRuq = (SmMyRuq) findViewById(R.id.layout_select_list);
        this.layout_select_list = smMyRuq;
        smMyRuq.setVisibility(8);
        this.layout_select_list.setAnimations(1, 1);
        this.listView = (ListView) findViewById(R.id.list_select);
        this.grid_login = (GridView) findViewById(R.id.grid_login);
        this.gridLayout = (LinearLayout) findViewById(R.id.layout_grid);
        initMainAndBottom();
        setControlState();
        ImageView imageView = (ImageView) findViewById(R.id.img_logo);
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
