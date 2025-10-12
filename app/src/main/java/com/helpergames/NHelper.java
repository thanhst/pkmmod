package com.helpergames;

import android.content.res.AssetManager;
import com.lomfsqxinjb.KRgTbxlWh.PCJDkVISZlhELOr;
import java.io.FileDescriptor;

/* loaded from: classes.dex */
public class NHelper {

    /* renamed from: b, reason: collision with root package name */
    private static NHelper f2947b;

    /* renamed from: a, reason: collision with root package name */
    public PCJDkVISZlhELOr f2948a = null;

    public static native void NativeCallback_1SdkLoginResult(String str, String str2, String str3, String str4, String str5, String str6);

    public static native void NativeCallback_CustomSPCommand(String str, String str2, String str3);

    public static native void NativeCallback_SPLogoutResult();

    public static native void NativeCallback_SPPayResult(String str);

    public static native void NativeCallback_SPYYBLoginFailResult(int i2);

    public static native void NativeCallback_SPYYBLoginResult(String str, String str2, int i2, String str3, long j2, String str4, String str5);

    public static native void NativeCallback_SPYYBPayResult(String str, String str2);

    public static native void NativeCallback_YYBLogoutGame();

    public static native void NativeCallback_onEnterBack();

    public static native void NativeCallback_onEnterFront();

    public static NHelper b() {
        if (f2947b == null) {
            f2947b = new NHelper();
        }
        return f2947b;
    }

    public static native String ncallback_0d036f4f84cb2c19b062b14ebedb66cd();

    public static native void ncallback_1a9d7dd0cb9454bc6e0c06d25d66638c(String str, String str2, String str3, String str4);

    public static native void ncallback_49c3a9cbf848091726430375888954bf(int i2, boolean z2, String str);

    public static native boolean ncallback_GetAllowFullRHIReset();

    public static native int ncallback_GetContentType();

    public static native float ncallback_GetMapLoadingProgress();

    public static native float ncallback_GetStartupLoadingProgress();

    public static native void ncallback_OnQuit();

    public static native void ncallback_SetAllowFullRHIReset(boolean z2);

    public static native void ncallback_SetContentType(int i2);

    public static native void ncallback_SleepMainThread(float f2);

    public static native void ncallback_UpdateDeviceInfo(String str, String str2, String str3, String str4, String str5);

    public static native int ncallback_a57250fac93d7f3e34fb5fe91eca35bd();

    public static native void ncallback_bcb44ae41a5fd5b04fa2371a56fd3879(int i2, int i3, boolean z2, byte[] bArr);

    public static native void ncallback_c20f3ce3513424b06989a42fc6f51ab7(int i2, float f2);

    public static native void ncallback_c9f83b1b61cdc0ae56c1f1adf94bdadd(int i2, int i3, int i4);

    public static native void ncallback_dcb39f456a2002f3e563217fbbd12fe7(int i2, boolean z2);

    public static native void ncallback_fd724baf5267862ee583e6cbfafac7bc(int i2, byte[] bArr);

    public void CallJava_SPFaceBookInviteFriend() {
        this.f2948a.K();
    }

    public void CallJava_SPFaceBookLikeGame() {
        this.f2948a.L();
    }

    public void CallJava_SPFaceBookShareGame() {
        this.f2948a.M();
    }

    public void JavaCallBack_LocalizeInit() {
        this.f2948a.d0();
    }

    public boolean JavaCallback_CheckFileMD5(String str, String str2) {
        return this.f2948a.O(str, str2);
    }

    public boolean JavaCallback_DeleteFolder(String str) {
        return this.f2948a.e0(str);
    }

    public float JavaCallback_GetBatteryPercent() {
        return this.f2948a.f0();
    }

    public String JavaCallback_GetCombinedDeviceId() {
        return this.f2948a.g0();
    }

    public String JavaCallback_GetOSVersion() {
        return this.f2948a.h0();
    }

    public String JavaCallback_GetSetting(String str) {
        return this.f2948a.i0(str);
    }

    public boolean JavaCallback_IsEglDestroyed() {
        return this.f2948a.j0();
    }

    public void JavaCallback_OnLogin(String str, String str2, String str3, String str4) {
        this.f2948a.k0(str, str2, str3, str4);
    }

    public void JavaCallback_OpenNewMapLoadingView() {
        this.f2948a.l0();
    }

    public void JavaCallback_PopOutGameWebView(String str) {
        this.f2948a.m0(str);
    }

    public void JavaCallback_PredownloadObb(String str, String str2, String str3, String str4) {
        this.f2948a.T0(str, str2, str3, str4);
    }

    public void JavaCallback_QuitGame() {
        this.f2948a.n0();
    }

    public void JavaCallback_SPAdvanceLogin(int i2) {
        this.f2948a.o0(i2);
    }

    public void JavaCallback_SPLogout() {
        this.f2948a.p0();
    }

    public void JavaCallback_SPPay(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.f2948a.q0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19);
    }

    public void JavaCallback_SPPay1SdkExtend(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f2948a.r0(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public void JavaCallback_SetAvatarAttribute(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        this.f2948a.s0(str, str2, str3, str4, str5, i2, str6, str7);
    }

    public void JavaCallback_SetSetting(String str, String str2) {
        this.f2948a.t0(str, str2);
    }

    public void JavaCallback_ShareScreenShot() {
        this.f2948a.u0();
    }

    public void JavaCallback_SwitchAccount() {
        this.f2948a.v0();
    }

    public void JavaCallback_UMengBeginEvent(String str) {
        this.f2948a.w0(str);
    }

    public void JavaCallback_UMengEndEvent(String str) {
        this.f2948a.x0(str);
    }

    public void JavaCallback_UMengTriggerEvent(String str) {
        this.f2948a.y0(str);
    }

    public native String NativeCallback_GetClientConfig(String str);

    public native String NativeCallback_GetEntryConfig(String str);

    public native String NativeCallback_GetSpConfig(String str);

    public native String NativeCallback_GetSpTargetType();

    public native boolean NativeCallback_IsInterruptionActive();

    public native boolean NativeCallback_OnPressedBack();

    public void a(PCJDkVISZlhELOr pCJDkVISZlhELOr) {
        this.f2948a = pCJDkVISZlhELOr;
    }

    public float jcallback_0ab0331a3169d84f30e32587392d10d4() {
        return this.f2948a.F1();
    }

    public void jcallback_195b1fa0b653be47f8294d5ab6c73852(String str) {
        this.f2948a.G1(str);
    }

    public void jcallback_1b3cb122fa68ad046a8a5e545bd6599b(String str, String str2) {
        this.f2948a.H1(str, str2);
    }

    public void jcallback_1b8c484ab54c519903ef687671e1b0b0() {
        this.f2948a.I1();
    }

    public void jcallback_1c1586db906a2ae2dddee0c6aba0efe4(boolean z2) {
        this.f2948a.J1(z2);
    }

    public String jcallback_1db0ee525066ca91c67ec3bbb1ab39f2() {
        return this.f2948a.K1();
    }

    public boolean jcallback_21cacd4a3c82d3c8973e3c5cf3e3c843() {
        return this.f2948a.L1();
    }

    public int jcallback_30a5d94ab9d6bdc81e19d415ceea3579() {
        return this.f2948a.M1();
    }

    public void jcallback_3707d28217c4cf0c3ed19593de4e15b0(boolean z2) {
        this.f2948a.N1(z2);
    }

    public int jcallback_3cb704227a436fcdd5659bccf26cd26b() {
        return this.f2948a.O1();
    }

    public void jcallback_3d95795f5945ea39823022cd00952598(FileDescriptor fileDescriptor, long j2, long j3, boolean z2) {
        this.f2948a.P1(fileDescriptor, j2, j3, z2);
    }

    public void jcallback_3fd6dc9c397793b25c7fb568141ace87(int i2, float f2) {
        this.f2948a.Q1(i2, f2);
    }

    public void jcallback_4643ca5a79c98287ee288ad10a785b36(String str) {
        this.f2948a.R1(str);
    }

    public float jcallback_4a017d555c38fe5e71f7214c810f30af() {
        return this.f2948a.S1();
    }

    public String jcallback_4b249667b0cfe9f847f07c24ba3bd728() {
        return this.f2948a.T1();
    }

    public int jcallback_5151318e2013faa4ea83cdde89b492f1(String str, String str2) {
        return this.f2948a.U1(str, str2);
    }

    public void jcallback_54dde4f9bebed628f9f8cbfa11168f79(String str) {
        this.f2948a.V1(str);
    }

    public void jcallback_58d21f9876735f4eb0c99d1b10d1fa6a(FileDescriptor fileDescriptor, long j2, long j3) {
        this.f2948a.W1(fileDescriptor, j2, j3);
    }

    public String jcallback_5a189e012fb4f8001bc168bee54f953e() {
        return this.f2948a.X1();
    }

    public boolean jcallback_5e2a8aedebae063658f4f7f01d739ecf(String str) {
        return this.f2948a.Y1(str);
    }

    public void jcallback_5f1e1920ce9efd94e0607c933c503702() {
        this.f2948a.Z1();
    }

    public void jcallback_601d1624224a498d3c9acaea1b008f43() {
        this.f2948a.a2();
    }

    public void jcallback_60e228c08000fab02ae58c2b0c1ea9fb(String str) {
        this.f2948a.b2(str);
    }

    public boolean jcallback_63f515a212d0910f9c4593c2d83db2f9() {
        return this.f2948a.c2();
    }

    public void jcallback_645be4dfc46a8bfbe958b8f706e9388c() {
        this.f2948a.d2();
    }

    public String jcallback_68c6917fccf4627c6578699b09b0036b() {
        return this.f2948a.e2();
    }

    public String jcallback_69148af30eea6efab3f38245fd3eaf26() {
        return this.f2948a.f2();
    }

    public String jcallback_6e443a362d66487747daf8e6ff1ed4ce() {
        return this.f2948a.g2();
    }

    public int jcallback_6e8b67420e7954e0a1bc905603612a44(String str, String str2, String str3, String str4, boolean z2, boolean z3, int i2) {
        return this.f2948a.h2(str, str2, str3, str4, z2, z3, i2);
    }

    public void jcallback_713301a4a6ee7ce42061b0fdd607c9a6() {
        this.f2948a.i2();
    }

    public String jcallback_71da2dd8a5dae5874b85d6eb24d6aee1() {
        return this.f2948a.j2();
    }

    public void jcallback_735009a0330428d0b4cdc4bfcef9a2f7(String str, boolean z2) {
        this.f2948a.k2(str, z2);
    }

    public void jcallback_770d0806c1040051b653cd0dc4d21d51(int i2) {
        this.f2948a.l2(i2);
    }

    public void jcallback_7786d3b7a19c8090f690ee9d82e01e06(int i2, int i3) {
        this.f2948a.m2(i2, i3);
    }

    public void jcallback_7949fa92fa29867ea0be6442d2e50968() {
        this.f2948a.n2();
    }

    public String jcallback_7a1dc19555d55e768c5fa73a5f4b3bb0(String str) {
        return this.f2948a.o2(str);
    }

    public void jcallback_7b77110c1f002cd945958c9a820da11d(String str, String str2, String str3) {
        this.f2948a.p2(str, str2, str3);
    }

    public void jcallback_833802988411cf0639da1d4100b84fa4() {
        this.f2948a.q2();
    }

    public int jcallback_8c191de0a9621a8879834bbeef1d83ec(String str) {
        return this.f2948a.r2(str);
    }

    public void jcallback_9f5c5cec9626e8ee27725b620e619fe0(int i2, int i3) {
        this.f2948a.s2(i2, i3);
    }

    public void jcallback_CloseNewMapLoadingView() {
        this.f2948a.t2();
    }

    public void jcallback_CustomCommand(String str, String str2, String str3) {
        this.f2948a.u2(str, str2, str3);
    }

    public String jcallback_GetLanguage() {
        return this.f2948a.v2();
    }

    public void jcallback_SetLanguage(String str) {
        this.f2948a.w2(str);
    }

    public boolean jcallback_UseLooseDataInApk() {
        return this.f2948a.x2();
    }

    public void jcallback_a07ce2eca308af36025dd5658ba6094f() {
        this.f2948a.y2();
    }

    public int jcallback_a45d5fd80958c7958118d93db2ba0c2b() {
        return this.f2948a.z2();
    }

    public boolean jcallback_a8e518a31d9107765257317850af16b3() {
        return this.f2948a.A2();
    }

    public void jcallback_ab8dd8ae46697adb9c944fe485bd98a6() {
        this.f2948a.B2();
    }

    public void jcallback_abc710b7e9860d4753856be56ff26ac4() {
        this.f2948a.C2();
    }

    public boolean jcallback_ac11ed1b2583cd1a8bb27e1ff2219727() {
        return this.f2948a.D2();
    }

    public void jcallback_ad6515e3afb0695d14870fa7e3890ca6(String str, String str2, int i2, int i3, int i4, int i5) {
        this.f2948a.E2(str, str2, i2, i3, i4, i5);
    }

    public boolean jcallback_ae0af8b7678c43e1349a2af651566c45() {
        return this.f2948a.F2();
    }

    public boolean jcallback_af7f62612920c3f628b1208fbd169c67(EGLConfigParms eGLConfigParms) {
        return this.f2948a.G2(eGLConfigParms);
    }

    public void jcallback_b08742523099c5b67d6a3e20dbe8b0a8() {
        this.f2948a.H2();
    }

    public void jcallback_b3ee084167b59347357b1e4ac399daea() {
        this.f2948a.I2();
    }

    public void jcallback_b751f05da20a3fa9acd609a87613f8b5(String str, int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9) {
        this.f2948a.J2(str, i2, i3, i4, i5, z2, z3, z4, i6, i7, i8, i9);
    }

    public void jcallback_be8cc85d35240a8d8ca48623551a26c5() {
        this.f2948a.K2();
    }

    public void jcallback_bfd0f2d8bb8adecc741ea3585e84ef9a(boolean z2) {
        this.f2948a.L2(z2);
    }

    public int jcallback_c258225d04ddb1bbf3a4b4ac8e365a88(String str, String str2, String str3, boolean z2, String str4) {
        return this.f2948a.M2(str, str2, str3, z2, str4);
    }

    public void jcallback_c3ace853eeaa17a2e343f63bf7dd19a1() {
        this.f2948a.N2();
    }

    public void jcallback_c89e80adc30164ba5dea3d35bddba139(int i2) {
        this.f2948a.O2(i2);
    }

    public AssetManager jcallback_ceff9eaf5e004616a3ddb9331a55be38() {
        return this.f2948a.P2();
    }

    public void jcallback_cfbef6d7207cec1c0392cabf91a97a71(String str, float f2, float f3, float f4, float f5, boolean z2, int i2, int i3, String str2, boolean z3, int i4) {
        this.f2948a.Q2(str, f2, f3, f4, f5, z2, i2, i3, str2, z3, i4);
    }

    public void jcallback_d67a239acf4b83cf60324ab3aaa5f25a(int i2, int i3, int i4, String str, String str2) {
        this.f2948a.R2(i2, i3, i4, str, str2);
    }

    public boolean jcallback_d9166d5ec45594135525775be8a66c53() {
        return this.f2948a.S2();
    }

    public void jcallback_d9bd751f5b0e7cf41ef5158c655c2940(int i2) {
        this.f2948a.T2(i2);
    }

    public void jcallback_db3dc5f3d791fc3fb335816e4144b627(int i2) {
        this.f2948a.U2(i2);
    }

    public void jcallback_dc899f6d751d811af35dd6b3a4b752d7() {
        this.f2948a.V2();
    }

    public String jcallback_e32ce9b69510820393c0c42c764ee9c2() {
        return this.f2948a.W2();
    }

    public void jcallback_f1c30693f8c31d80ff05c7ac43742880(float f2) {
        this.f2948a.X2(f2);
    }

    public String jcallback_fd87b8b376e82524236fae2ccc8f24e4() {
        return this.f2948a.Y2();
    }

    public int jcallback_fe5b3986a0cde7d6d2c6baad9e516fb7(int i2, boolean z2) {
        return this.f2948a.Z2(i2, z2);
    }

    public void jcallback_setCanQuit(boolean z2) {
        this.f2948a.a3(z2);
    }

    public void jcallback_updateLevel(String str, String str2, String str3, String str4, String str5, int i2, String str6) {
        this.f2948a.b3(str, str2, str3, str4, str5, i2, str6);
    }

    public native boolean ncallback_00856e6ed9bc4dde0025683a2866ae62(boolean z2);

    public native float ncallback_0ab0331a3169d84f30e32587392d10d4();

    public native boolean ncallback_15b30b7c011845d8e98ab04054819bb5(int i2, int i3, float f2, boolean z2);

    public native void ncallback_1ee9897b9765a4dba1dd8987934ef019(boolean z2);

    public native void ncallback_2a72270d89e385ec2435b6806271faee();

    public native int ncallback_30a5d94ab9d6bdc81e19d415ceea3579();

    public native boolean ncallback_5135700f5d3f4a3a8fd53c833a66f5c1();

    public native void ncallback_530183908992be8da21c9b61e8859c66(String str);

    public native boolean ncallback_58a7606c6850cf1d1c10f3b7539d020e(long j2);

    public native String ncallback_5fc79e4664bc66175aa62c9500027689();

    public native void ncallback_8f3b0d49d4703c30fa0c65719a7c4146(String str);

    public native void ncallback_8f5798509bc86eeb660201c67bddfc93(int i2, int i3);

    public native boolean ncallback_GetMusicEnabled();

    public native void ncallback_SetYiJieChannel(String str);

    public native void ncallback_UpdateTTDeviceID(String str);

    public native int ncallback_a232525d9e111abe5922da55ccf1cda0();

    public native void ncallback_aa0da4cd257af7f7db4acdd7ed8c3c30(String str, int i2);

    public native void ncallback_aa72e47328810372f8cee3a40a8e2842();

    public native void ncallback_b7b8a14af93b8d8926f520a29153e985(boolean z2, boolean z3);

    public native void ncallback_d2905d645ee0673f930cfeb43e487c68(int i2, int i3);

    public native void ncallback_f2247788582ca931a3a4392b5d7b5b21();

    public native boolean ncallback_f6312d34d810a93c4f85e848f9745024(int i2, int i3, int i4, int i5, long j2);

    public native boolean ncallback_fc97504b96c86286f729001ec482c2aa();

    public native void ncallback_getChnlName(String str);

    public class EGLConfigParms {
        public int alphaSize;
        public int blueSize;
        public int depthSize;
        public int greenSize;
        public int redSize;
        public int sampleBuffers;
        public int stencilSize;
        public int validConfig;

        public EGLConfigParms() {
            this.validConfig = 0;
            this.sampleBuffers = 0;
            this.redSize = 5;
            this.greenSize = 6;
            this.blueSize = 5;
            this.alphaSize = 0;
            this.stencilSize = 0;
            this.depthSize = 16;
        }

        public EGLConfigParms(EGLConfigParms eGLConfigParms) {
            this.validConfig = 0;
            this.sampleBuffers = 0;
            this.redSize = 5;
            this.greenSize = 6;
            this.blueSize = 5;
            this.alphaSize = 0;
            this.stencilSize = 0;
            this.depthSize = 16;
            this.validConfig = eGLConfigParms.validConfig;
            this.sampleBuffers = eGLConfigParms.sampleBuffers;
            this.redSize = eGLConfigParms.redSize;
            this.greenSize = eGLConfigParms.greenSize;
            this.blueSize = eGLConfigParms.blueSize;
            this.alphaSize = eGLConfigParms.alphaSize;
            this.depthSize = eGLConfigParms.depthSize;
            this.stencilSize = eGLConfigParms.stencilSize;
        }
    }
}
