package j0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.helpergames.NHelper;
import com.sfyvctwaqbjhki.uwmpqfh.HTQkfVEWv;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UGuwCakoQHjtD;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.CheckCallback;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.InitCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack;
import com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.MCBNKIfi;

/* compiled from: NybGBuo.java */
/* loaded from: classes.dex */
public class f_j0 extends j_j0 {

    /* renamed from: b, reason: collision with root package name */
    private boolean f3337b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3338c = true;

    /* renamed from: d, reason: collision with root package name */
    private String f3339d = "2qgbdv";

    /* renamed from: e, reason: collision with root package name */
    private String f3340e = "17u1yy";

    /* renamed from: f, reason: collision with root package name */
    private String f3341f = "biezvd";

    /* renamed from: g, reason: collision with root package name */
    private String f3342g = "hpyqjj";

    /* renamed from: h, reason: collision with root package name */
    private String f3343h = "2tqovt";

    /* renamed from: i, reason: collision with root package name */
    private String f3344i = "c0gll8";

    /* renamed from: j, reason: collision with root package name */
    private String f3345j = "knxvjj";

    /* renamed from: k, reason: collision with root package name */
    private String f3346k = "z8bfoh";

    /* compiled from: NybGBuo.java */
    class a implements CheckCallback {

        /* compiled from: NybGBuo.java */
        /* renamed from: j0.f$a$a, reason: collision with other inner class name */
        class C0053a implements InitCallBack {
            C0053a() {
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.InitCallBack
            public void doSwitch() {
                NHelper.b();
                NHelper.NativeCallback_CustomSPCommand("SPSwitch_Seven", "", "");
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.InitCallBack
            public void initFail(String str) {
                if (f_j0.this.f3337b) {
                    return;
                }
                Toast.makeText(f_j0.this.f3352a, "Init failed!", 0).show();
            }

            @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.InitCallBack
            public void initSuccess() {
                if (f_j0.this.f3337b) {
                    Toast.makeText(f_j0.this.f3352a, "Init successed!", 0).show();
                }
            }
        }

        a() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.CheckCallback
        public void isCheck(boolean z2) {
            if (z2) {
                Log.e("yuenan", "=============checkAppStatus22222============");
                NHelper.b();
                NHelper.ncallback_SetContentType(2);
            } else {
                Log.e("yuenan", "=============checkAppStatus11111============");
                NHelper.b();
                NHelper.ncallback_SetContentType(1);
            }
            Log.e("yuenan", "=============init1============");
            HTQkfVEWv.initSDK(f_j0.this.f3352a, new C0053a());
        }
    }

    /* compiled from: NybGBuo.java */
    class b implements LoginCallBack {
        b() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack
        public void loginFail(String str) {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack
        public void loginSuccess(String str, UserInfo userInfo) {
            Log.e("yuenan", "=============loginsucess in init 2============");
            int userId = userInfo.getUserId();
            NHelper.b();
            NHelper.ncallback_1a9d7dd0cb9454bc6e0c06d25d66638c("" + userId, "", "", str);
        }
    }

    /* compiled from: NybGBuo.java */
    class c implements LoginCallBack {
        c() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack
        public void loginFail(String str) {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.LoginCallBack
        public void loginSuccess(String str, UserInfo userInfo) {
            Log.e("yuenan", "=============login============");
            int userId = userInfo.getUserId();
            NHelper.b();
            NHelper.ncallback_1a9d7dd0cb9454bc6e0c06d25d66638c("" + userId, "", "", str);
        }
    }

    /* compiled from: NybGBuo.java */
    class d implements MCBNKIfi {
        d() {
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.MCBNKIfi
        public void payFail(String str) {
            Log.e("yuenan", "=============recharge fail call back============");
        }

        @Override // com.sfyvctwaqbjhki.uwmpqfh.wuehtlizdfpmg.MCBNKIfi
        public void payFinish() {
            Log.e("yuenan", "=============recharge success call back============");
        }
    }

    public void E(String str) {
        HTQkfVEWv.diamondGet(Integer.valueOf(str).intValue());
    }

    @Override // j0.j
    public void f(String str, String str2, String str3) {
        if (str.equals("UpdateVip")) {
            E(str2);
            return;
        }
        if (str.equals("UserCenter")) {
            Log.e("YUENAN", "===============UserCenCenter==============");
            HTQkfVEWv.openUserCenter(this.f3352a);
            return;
        }
        if (str.equals("CustomCenter")) {
            HTQkfVEWv.openCustomServiceCenter(this.f3352a);
            Log.e("YUENAN", "===============CustomCenCenter==============");
            return;
        }
        if (str.equals("GameEvent")) {
            if (str2.equals("VIP1")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3339d);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("VIP3")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3340e);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("VIP8")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3341f);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("VIP13")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3342g);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("level5")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3343h);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("level15")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3344i);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("level30")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3345j);
                Log.e("YUENAN", "GameEvent:" + str2);
            } else if (str2.equals("level40")) {
                HTQkfVEWv.gameEvent(this.f3352a, str2, this.f3346k);
                Log.e("YUENAN", "GameEvent:" + str2);
            }
            Log.e("YUENAN", "===============CustomCenCenter==============");
        }
    }

    @Override // j0.j
    public void i() {
        if (this.f3338c) {
            Log.e("yuenan", "=============auto login============");
            HTQkfVEWv.autoLogin(this.f3352a, new b());
        } else {
            Log.e("yuenan", "=============login============");
            HTQkfVEWv.openLogin(this.f3352a, new c());
        }
        this.f3338c = false;
    }

    @Override // j0.j
    public void j() {
    }

    @Override // j0.j
    public void k(int i2, int i3, Intent intent) {
        super.k(i2, i3, intent);
        HTQkfVEWv.onActivityResult(i2, i3, intent);
    }

    @Override // j0.j
    public void l(Bundle bundle) {
        super.l(bundle);
        Log.e("yuenan", "=============checkAppStatus============");
        HTQkfVEWv.checkAppStatus(this.f3352a, new a());
    }

    @Override // j0.j
    public void m() {
        super.m();
        HTQkfVEWv.onDestory();
    }

    @Override // j0.j
    public void p() {
        super.p();
        HTQkfVEWv.onPause();
    }

    @Override // j0.j
    public void q(int i2, String[] strArr, int[] iArr) {
        super.q(i2, strArr, iArr);
        HTQkfVEWv.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // j0.j
    public void s() {
        super.s();
        HTQkfVEWv.onResume();
    }

    @Override // j0.j
    public void v(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        Log.e("Indonesia", "=============recharge in============");
        UGuwCakoQHjtD uGuwCakoQHjtD = new UGuwCakoQHjtD();
        uGuwCakoQHjtD.setGameZoneId(str18);
        uGuwCakoQHjtD.setRoleId(str15);
        uGuwCakoQHjtD.setLevel(str12);
        uGuwCakoQHjtD.setGameOrderId(str);
        uGuwCakoQHjtD.setRoleName(str14);
        uGuwCakoQHjtD.setGameCoin(Integer.valueOf(str5).intValue());
        Log.e("yuenan", "=============recharge ining============");
        HTQkfVEWv.startPay(this.f3352a, uGuwCakoQHjtD, new d());
    }

    @Override // j0.j
    public void x() {
        HTQkfVEWv.onBackPressed(this.f3352a);
    }

    @Override // j0.j
    public void y(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        try {
            Log.e("yuenan", "=============setavatarinfo============ " + str6);
            HTQkfVEWv.bindZoon(i2 + "", str2, str3, str4, str6.equals("______________AvatarCreate_______________"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
