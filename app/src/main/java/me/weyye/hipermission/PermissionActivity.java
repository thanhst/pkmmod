package me.weyye.hipermission;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.a;
import androidx.core.content.ContextCompat;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class PermissionActivity extends AppCompatActivity {

    /* renamed from: q, reason: collision with root package name */
    public static int f4025q = 1;

    /* renamed from: r, reason: collision with root package name */
    private static PermissionCallback f4026r;

    /* renamed from: g, reason: collision with root package name */
    private int f4027g;

    /* renamed from: h, reason: collision with root package name */
    private String f4028h;

    /* renamed from: i, reason: collision with root package name */
    private String f4029i;

    /* renamed from: j, reason: collision with root package name */
    private List<PermissionItem> f4030j;

    /* renamed from: k, reason: collision with root package name */
    private Dialog f4031k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f4032l;

    /* renamed from: m, reason: collision with root package name */
    private int f4033m;

    /* renamed from: n, reason: collision with root package name */
    private int f4034n;

    /* renamed from: o, reason: collision with root package name */
    private int f4035o;

    /* renamed from: p, reason: collision with root package name */
    private int f4036p;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PermissionActivity.this.f4031k != null && PermissionActivity.this.f4031k.isShowing()) {
                PermissionActivity.this.f4031k.dismiss();
            }
            androidx.core.app.b.q(PermissionActivity.this, PermissionActivity.this.A(), 2);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            if (PermissionActivity.f4026r != null) {
                PermissionActivity.f4026r.onClose();
            }
            PermissionActivity.this.finish();
        }
    }

    class c implements DialogInterface.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f4039e;

        c(String str) {
            this.f4039e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            PermissionActivity.this.H(new String[]{this.f4039e}, 3);
        }
    }

    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            PermissionActivity.this.C();
        }
    }

    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            try {
                PermissionActivity.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + PermissionActivity.this.getPackageName())), 110);
            } catch (Exception e2) {
                e2.printStackTrace();
                PermissionActivity.this.C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] A() {
        String[] strArr = new String[this.f4030j.size()];
        for (int i2 = 0; i2 < this.f4030j.size(); i2++) {
            strArr[i2] = this.f4030j.get(i2).Permission;
        }
        return strArr;
    }

    private String B() {
        return TextUtils.isEmpty(this.f4028h) ? String.format(getString(R$string.permission_dialog_title), this.f4032l) : this.f4028h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        PermissionCallback permissionCallback = f4026r;
        if (permissionCallback != null) {
            permissionCallback.onClose();
        }
        finish();
    }

    private void D(String str, int i2) {
        PermissionCallback permissionCallback = f4026r;
        if (permissionCallback != null) {
            permissionCallback.onDeny(str, i2);
        }
    }

    private void E() {
        PermissionCallback permissionCallback = f4026r;
        if (permissionCallback != null) {
            permissionCallback.onFinish();
        }
        finish();
    }

    private void F(String str, int i2) {
        PermissionCallback permissionCallback = f4026r;
        if (permissionCallback != null) {
            permissionCallback.onGuarantee(str, i2);
        }
    }

    private void G(String str) {
        String str2 = z(str).PermissionName;
        I(String.format(getString(R$string.permission_title), str2), String.format(getString(R$string.permission_denied), str2, this.f4032l), getString(R$string.permission_cancel), getString(R$string.permission_ensure), new c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String[] strArr, int i2) {
        androidx.core.app.b.q(this, strArr, i2);
    }

    private void I(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        new a.C0005a(this).l(str).g(str2).d(false).h(str3, new d()).j(str4, onClickListener).a().show();
    }

    private void J() {
        String strB = B();
        String str = TextUtils.isEmpty(this.f4029i) ? String.format(getString(R$string.permission_dialog_msg), this.f4032l) : this.f4029i;
        v0.a aVar = new v0.a(this);
        aVar.setGridViewColum(this.f4030j.size() < 3 ? this.f4030j.size() : 3);
        aVar.setTitle(strB);
        aVar.setMsg(str);
        aVar.setGridViewAdapter(new PermissionAdapter(this.f4030j));
        if (this.f4033m == -1) {
            this.f4033m = R$style.PermissionDefaultNormalStyle;
            this.f4034n = getResources().getColor(R$color.permissionColorGreen);
        }
        aVar.setStyleId(this.f4033m);
        aVar.setFilterColor(this.f4034n);
        aVar.setBtnOnClickListener(new a());
        Dialog dialog = new Dialog(this);
        this.f4031k = dialog;
        dialog.requestWindowFeature(1);
        this.f4031k.setContentView(aVar);
        if (this.f4035o != -1) {
            this.f4031k.getWindow().setWindowAnimations(this.f4035o);
        }
        this.f4031k.setCanceledOnTouchOutside(false);
        this.f4031k.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f4031k.setOnCancelListener(new b());
        this.f4031k.show();
    }

    private void x() {
        ListIterator<PermissionItem> listIterator = this.f4030j.listIterator();
        while (listIterator.hasNext()) {
            if (ContextCompat.a(getApplicationContext(), listIterator.next().Permission) == 0) {
                listIterator.remove();
            }
        }
    }

    private void y() {
        Intent intent = getIntent();
        this.f4027g = intent.getIntExtra("data_permission_type", f4025q);
        this.f4028h = intent.getStringExtra("data_title");
        this.f4029i = intent.getStringExtra("data_msg");
        this.f4034n = intent.getIntExtra("data_color_filter", 0);
        this.f4033m = intent.getIntExtra("data_style_id", -1);
        this.f4035o = intent.getIntExtra("data_anim_style", -1);
        this.f4030j = (List) intent.getSerializableExtra("data_permissions");
    }

    private PermissionItem z(String str) {
        for (PermissionItem permissionItem : this.f4030j) {
            if (permissionItem.Permission.equals(str)) {
                return permissionItem;
            }
        }
        return null;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.e("PermissionActivity", "onActivityResult--requestCode:" + i2 + ",resultCode:" + i3);
        if (i2 == 110) {
            Dialog dialog = this.f4031k;
            if (dialog != null && dialog.isShowing()) {
                this.f4031k.dismiss();
            }
            x();
            if (this.f4030j.size() <= 0) {
                E();
            } else {
                this.f4036p = 0;
                G(this.f4030j.get(0).Permission);
            }
        }
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        y();
        if (this.f4027g != f4025q) {
            this.f4032l = getApplicationInfo().loadLabel(getPackageManager());
            J();
            return;
        }
        List<PermissionItem> list = this.f4030j;
        if (list == null || list.size() == 0) {
            return;
        }
        H(new String[]{this.f4030j.get(0).Permission}, 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        f4026r = null;
        Dialog dialog = this.f4031k;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f4031k.dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            String str = z(strArr[0]).Permission;
            if (iArr[0] == 0) {
                F(str, 0);
            } else {
                D(str, 0);
            }
            finish();
            return;
        }
        if (i2 == 2) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (iArr[i3] == 0) {
                    this.f4030j.remove(z(strArr[i3]));
                    F(strArr[i3], i3);
                } else {
                    D(strArr[i3], i3);
                }
            }
            if (this.f4030j.size() > 0) {
                G(this.f4030j.get(this.f4036p).Permission);
                return;
            } else {
                E();
                return;
            }
        }
        if (i2 != 3) {
            return;
        }
        if (iArr[0] != -1) {
            F(strArr[0], 0);
            if (this.f4036p >= this.f4030j.size() - 1) {
                E();
                return;
            }
            List<PermissionItem> list = this.f4030j;
            int i4 = this.f4036p + 1;
            this.f4036p = i4;
            G(list.get(i4).Permission);
            return;
        }
        try {
            String str2 = z(strArr[0]).PermissionName;
            String str3 = String.format(getString(R$string.permission_title), str2);
            String string = getString(R$string.permission_denied_with_naac);
            CharSequence charSequence = this.f4032l;
            I(str3, String.format(string, charSequence, str2, charSequence), getString(R$string.permission_reject), getString(R$string.permission_go_to_setting), new e());
            D(strArr[0], 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            C();
        }
    }
}
