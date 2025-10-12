package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FragmentWrapper.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R(\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/FragmentWrapper;", "", "Landroid/content/Intent;", "intent", "", "requestCode", "Lkotlin/t;", "startActivityForResult", "Landroidx/fragment/app/Fragment;", "<set-?>", "supportFragment", "Landroidx/fragment/app/Fragment;", "getSupportFragment", "()Landroidx/fragment/app/Fragment;", "Landroid/app/Fragment;", "nativeFragment", "Landroid/app/Fragment;", "getNativeFragment", "()Landroid/app/Fragment;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "(Landroid/app/Fragment;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FragmentWrapper {

    @Nullable
    private Fragment nativeFragment;

    @Nullable
    private androidx.fragment.app.Fragment supportFragment;

    public FragmentWrapper(@NotNull androidx.fragment.app.Fragment fragment) {
        kotlin.jvm.internal.s.e(fragment, "fragment");
        this.supportFragment = fragment;
    }

    @Nullable
    public final Activity getActivity() {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }
        Fragment fragment2 = this.nativeFragment;
        if (fragment2 == null) {
            return null;
        }
        return fragment2.getActivity();
    }

    @Nullable
    public final Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    @Nullable
    public final androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public final void startActivityForResult(@Nullable Intent intent, int i2) {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            if (fragment == null) {
                return;
            }
            fragment.startActivityForResult(intent, i2);
        } else {
            Fragment fragment2 = this.nativeFragment;
            if (fragment2 == null) {
                return;
            }
            fragment2.startActivityForResult(intent, i2);
        }
    }

    public FragmentWrapper(@NotNull Fragment fragment) {
        kotlin.jvm.internal.s.e(fragment, "fragment");
        this.nativeFragment = fragment;
    }
}
