package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class a extends k {

    /* renamed from: i, reason: collision with root package name */
    final AlertController f174i;

    /* compiled from: AlertDialog.java */
    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0005a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.f f175a;

        /* renamed from: b, reason: collision with root package name */
        private final int f176b;

        public C0005a(@NonNull Context context) {
            this(context, a.l(context, 0));
        }

        @NonNull
        public a a() {
            a aVar = new a(this.f175a.f122a, this.f176b);
            this.f175a.a(aVar.f174i);
            aVar.setCancelable(this.f175a.f139r);
            if (this.f175a.f139r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.f175a.f140s);
            aVar.setOnDismissListener(this.f175a.f141t);
            DialogInterface.OnKeyListener onKeyListener = this.f175a.f142u;
            if (onKeyListener != null) {
                aVar.setOnKeyListener(onKeyListener);
            }
            return aVar;
        }

        @NonNull
        public Context b() {
            return this.f175a.f122a;
        }

        public C0005a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f175a;
            fVar.f144w = listAdapter;
            fVar.f145x = onClickListener;
            return this;
        }

        public C0005a d(boolean z2) {
            this.f175a.f139r = z2;
            return this;
        }

        public C0005a e(@Nullable View view) {
            this.f175a.f128g = view;
            return this;
        }

        public C0005a f(@Nullable Drawable drawable) {
            this.f175a.f125d = drawable;
            return this;
        }

        public C0005a g(@Nullable CharSequence charSequence) {
            this.f175a.f129h = charSequence;
            return this;
        }

        public C0005a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f175a;
            fVar.f133l = charSequence;
            fVar.f135n = onClickListener;
            return this;
        }

        public C0005a i(DialogInterface.OnKeyListener onKeyListener) {
            this.f175a.f142u = onKeyListener;
            return this;
        }

        public C0005a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f175a;
            fVar.f130i = charSequence;
            fVar.f132k = onClickListener;
            return this;
        }

        public C0005a k(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f175a;
            fVar.f144w = listAdapter;
            fVar.f145x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public C0005a l(@Nullable CharSequence charSequence) {
            this.f175a.f127f = charSequence;
            return this;
        }

        public C0005a(@NonNull Context context, @StyleRes int i2) {
            this.f175a = new AlertController.f(new ContextThemeWrapper(context, a.l(context, i2)));
            this.f176b = i2;
        }
    }

    protected a(@NonNull Context context, @StyleRes int i2) {
        super(context, l(context, i2));
        this.f174i = new AlertController(getContext(), this, getWindow());
    }

    static int l(@NonNull Context context, @StyleRes int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView k() {
        return this.f174i.d();
    }

    @Override // androidx.appcompat.app.k, android.view.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f174i.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f174i.g(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f174i.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.k, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f174i.q(charSequence);
    }
}
