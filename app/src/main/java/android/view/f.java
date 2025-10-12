package android.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.StyleRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ComponentDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0003\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0015J\b\u0010\n\u001a\u00020\bH\u0015J\b\u0010\u000b\u001a\u00020\bH\u0015J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\bH\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/activity/f;", "Landroid/app/Dialog;", "Landroidx/lifecycle/m;", "Landroidx/activity/k;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/t;", "onCreate", "onStart", "onStop", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "onBackPressed", "Landroidx/lifecycle/n;", "e", "Landroidx/lifecycle/n;", "_lifecycleRegistry", "f", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "()V", "onBackPressedDispatcher", "()Landroidx/lifecycle/n;", "lifecycleRegistry", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "activity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public class f extends Dialog implements m, k {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n _lifecycleRegistry;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public f(@NotNull Context context, @StyleRes int i2) {
        super(context, i2);
        s.e(context, "context");
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                f.f(this.f39e);
            }
        });
    }

    private final n e() {
        n nVar = this._lifecycleRegistry;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this._lifecycleRegistry = nVar2;
        return nVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(f this$0) {
        s.e(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.m
    @NotNull
    public final Lifecycle getLifecycle() {
        return e();
    }

    @Override // android.view.k
    @NotNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onBackPressed() {
        this.onBackPressedDispatcher.f();
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.onBackPressedDispatcher.g(getOnBackInvokedDispatcher());
        }
        e().h(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStart() {
        super.onStart();
        e().h(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStop() {
        e().h(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }
}
