package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f0;
import com.facebook.internal.AnalyticsEvents;

/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private final k f2270a;

    /* renamed from: b, reason: collision with root package name */
    private final q f2271b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final Fragment f2272c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2273d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f2274e = -1;

    /* compiled from: FragmentStateManager.java */
    class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f2275e;

        a(View view) {
            this.f2275e = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f2275e.removeOnAttachStateChangeListener(this);
            ViewCompat.L(this.f2275e);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: FragmentStateManager.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2277a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f2277a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2277a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2277a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2277a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    p(@NonNull k kVar, @NonNull q qVar, @NonNull Fragment fragment) {
        this.f2270a = kVar;
        this.f2271b = qVar;
        this.f2272c = fragment;
    }

    private boolean l(@NonNull View view) {
        if (view == this.f2272c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2272c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f2272c.performSaveInstanceState(bundle);
        this.f2270a.j(this.f2272c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2272c.mView != null) {
            s();
        }
        if (this.f2272c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2272c.mSavedViewState);
        }
        if (this.f2272c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2272c.mSavedViewRegistryState);
        }
        if (!this.f2272c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2272c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f2272c);
        }
        Fragment fragment = this.f2272c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        k kVar = this.f2270a;
        Fragment fragment2 = this.f2272c;
        kVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        int iJ = this.f2271b.j(this.f2272c);
        Fragment fragment = this.f2272c;
        fragment.mContainer.addView(fragment.mView, iJ);
    }

    void c() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f2272c);
        }
        Fragment fragment = this.f2272c;
        Fragment fragment2 = fragment.mTarget;
        p pVarM = null;
        if (fragment2 != null) {
            p pVarM2 = this.f2271b.m(fragment2.mWho);
            if (pVarM2 == null) {
                throw new IllegalStateException("Fragment " + this.f2272c + " declared target fragment " + this.f2272c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f2272c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            pVarM = pVarM2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (pVarM = this.f2271b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2272c + " declared target fragment " + this.f2272c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (pVarM != null && (FragmentManager.P || pVarM.k().mState < 1)) {
            pVarM.m();
        }
        Fragment fragment4 = this.f2272c;
        fragment4.mHost = fragment4.mFragmentManager.t0();
        Fragment fragment5 = this.f2272c;
        fragment5.mParentFragment = fragment5.mFragmentManager.w0();
        this.f2270a.g(this.f2272c, false);
        this.f2272c.performAttach();
        this.f2270a.b(this.f2272c, false);
    }

    int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f2272c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int iMin = this.f2274e;
        int i2 = b.f2277a[fragment2.mMaxState.ordinal()];
        if (i2 != 1) {
            iMin = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment3 = this.f2272c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                iMin = Math.max(this.f2274e, 2);
                View view = this.f2272c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f2274e < 4 ? Math.min(iMin, fragment3.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f2272c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactL = null;
        if (FragmentManager.P && (viewGroup = (fragment = this.f2272c).mContainer) != null) {
            lifecycleImpactL = SpecialEffectsController.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        }
        if (lifecycleImpactL == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactL == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f2272c;
            if (fragment4.mRemoving) {
                iMin = fragment4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f2272c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f2272c);
        }
        return iMin;
    }

    void e() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f2272c);
        }
        Fragment fragment = this.f2272c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f2272c.mState = 1;
            return;
        }
        this.f2270a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f2272c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        k kVar = this.f2270a;
        Fragment fragment3 = this.f2272c;
        kVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() {
        String resourceName;
        if (this.f2272c.mFromLayout) {
            return;
        }
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2272c);
        }
        Fragment fragment = this.f2272c;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f2272c;
        ViewGroup viewGroup2 = fragment2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment2.mContainerId;
            if (i2 != 0) {
                if (i2 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f2272c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.o0().c(this.f2272c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f2272c;
                    if (!fragment3.mRestored) {
                        try {
                            resourceName = fragment3.getResources().getResourceName(this.f2272c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2272c.mContainerId) + " (" + resourceName + ") for fragment " + this.f2272c);
                    }
                }
            }
        }
        Fragment fragment4 = this.f2272c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f2272c.mView;
        if (view != null) {
            boolean z2 = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f2272c;
            fragment5.mView.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f2272c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (ViewCompat.A(this.f2272c.mView)) {
                ViewCompat.L(this.f2272c.mView);
            } else {
                View view2 = this.f2272c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f2272c.performViewCreated();
            k kVar = this.f2270a;
            Fragment fragment7 = this.f2272c;
            kVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f2272c.mView.getVisibility();
            float alpha = this.f2272c.mView.getAlpha();
            if (FragmentManager.P) {
                this.f2272c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f2272c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View viewFindFocus = fragment8.mView.findFocus();
                    if (viewFindFocus != null) {
                        this.f2272c.setFocusedView(viewFindFocus);
                        if (FragmentManager.F0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f2272c);
                        }
                    }
                    this.f2272c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f2272c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z2 = true;
                }
                fragment9.mIsNewlyAdded = z2;
            }
        }
        this.f2272c.mState = 2;
    }

    void g() {
        Fragment fragmentF;
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f2272c);
        }
        Fragment fragment = this.f2272c;
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z2 || this.f2271b.o().p(this.f2272c))) {
            String str = this.f2272c.mTargetWho;
            if (str != null && (fragmentF = this.f2271b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f2272c.mTarget = fragmentF;
            }
            this.f2272c.mState = 0;
            return;
        }
        i<?> iVar = this.f2272c.mHost;
        if (iVar instanceof f0) {
            zIsChangingConfigurations = this.f2271b.o().m();
        } else if (iVar.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) iVar.f()).isChangingConfigurations();
        }
        if (z2 || zIsChangingConfigurations) {
            this.f2271b.o().g(this.f2272c);
        }
        this.f2272c.performDestroy();
        this.f2270a.d(this.f2272c, false);
        for (p pVar : this.f2271b.k()) {
            if (pVar != null) {
                Fragment fragmentK = pVar.k();
                if (this.f2272c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f2272c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.f2272c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.f2271b.f(str2);
        }
        this.f2271b.q(this);
    }

    void h() {
        View view;
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f2272c);
        }
        Fragment fragment = this.f2272c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f2272c.performDestroyView();
        this.f2270a.n(this.f2272c, false);
        Fragment fragment2 = this.f2272c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.i(null);
        this.f2272c.mInLayout = false;
    }

    void i() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f2272c);
        }
        this.f2272c.performDetach();
        boolean z2 = false;
        this.f2270a.e(this.f2272c, false);
        Fragment fragment = this.f2272c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z2 = true;
        }
        if (z2 || this.f2271b.o().p(this.f2272c)) {
            if (FragmentManager.F0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f2272c);
            }
            this.f2272c.initState();
        }
    }

    void j() {
        Fragment fragment = this.f2272c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2272c);
            }
            Fragment fragment2 = this.f2272c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f2272c.mSavedFragmentState);
            View view = this.f2272c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2272c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f2272c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f2272c.performViewCreated();
                k kVar = this.f2270a;
                Fragment fragment5 = this.f2272c;
                kVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f2272c.mState = 2;
            }
        }
    }

    @NonNull
    Fragment k() {
        return this.f2272c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f2273d) {
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f2273d = true;
            while (true) {
                int iD = d();
                Fragment fragment = this.f2272c;
                int i2 = fragment.mState;
                if (iD == i2) {
                    if (FragmentManager.P && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            SpecialEffectsController specialEffectsControllerN = SpecialEffectsController.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.f2272c.mHidden) {
                                specialEffectsControllerN.c(this);
                            } else {
                                specialEffectsControllerN.e(this);
                            }
                        }
                        Fragment fragment2 = this.f2272c;
                        FragmentManager fragmentManager = fragment2.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.D0(fragment2);
                        }
                        Fragment fragment3 = this.f2272c;
                        fragment3.mHiddenChanged = false;
                        fragment3.onHiddenChanged(fragment3.mHidden);
                    }
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f2272c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.F0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f2272c);
                            }
                            Fragment fragment4 = this.f2272c;
                            if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                s();
                            }
                            Fragment fragment5 = this.f2272c;
                            if (fragment5.mView != null && (viewGroup3 = fragment5.mContainer) != null) {
                                SpecialEffectsController.n(viewGroup3, fragment5.getParentFragmentManager()).d(this);
                            }
                            this.f2272c.mState = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                SpecialEffectsController.n(viewGroup2, fragment.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.from(this.f2272c.mView.getVisibility()), this);
                            }
                            this.f2272c.mState = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } finally {
            this.f2273d = false;
        }
    }

    void n() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f2272c);
        }
        this.f2272c.performPause();
        this.f2270a.f(this.f2272c, false);
    }

    void o(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.f2272c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f2272c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f2272c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f2272c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f2272c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f2272c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f2272c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f2272c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f2272c);
        }
        View focusedView = this.f2272c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (FragmentManager.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(zRequestFocus ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f2272c);
                sb.append(" resulting in focused view ");
                sb.append(this.f2272c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f2272c.setFocusedView(null);
        this.f2272c.performResume();
        this.f2270a.i(this.f2272c, false);
        Fragment fragment = this.f2272c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    @NonNull
    FragmentState r() {
        FragmentState fragmentState = new FragmentState(this.f2272c);
        Fragment fragment = this.f2272c;
        if (fragment.mState <= -1 || fragmentState.f2149q != null) {
            fragmentState.f2149q = fragment.mSavedFragmentState;
        } else {
            Bundle bundleQ = q();
            fragmentState.f2149q = bundleQ;
            if (this.f2272c.mTargetWho != null) {
                if (bundleQ == null) {
                    fragmentState.f2149q = new Bundle();
                }
                fragmentState.f2149q.putString("android:target_state", this.f2272c.mTargetWho);
                int i2 = this.f2272c.mTargetRequestCode;
                if (i2 != 0) {
                    fragmentState.f2149q.putInt("android:target_req_state", i2);
                }
            }
        }
        return fragmentState;
    }

    void s() {
        if (this.f2272c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f2272c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f2272c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f2272c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f2272c.mSavedViewRegistryState = bundle;
    }

    void t(int i2) {
        this.f2274e = i2;
    }

    void u() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f2272c);
        }
        this.f2272c.performStart();
        this.f2270a.k(this.f2272c, false);
    }

    void v() {
        if (FragmentManager.F0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f2272c);
        }
        this.f2272c.performStop();
        this.f2270a.l(this.f2272c, false);
    }

    p(@NonNull k kVar, @NonNull q qVar, @NonNull ClassLoader classLoader, @NonNull h hVar, @NonNull FragmentState fragmentState) {
        this.f2270a = kVar;
        this.f2271b = qVar;
        Fragment fragmentA = hVar.a(classLoader, fragmentState.f2137e);
        this.f2272c = fragmentA;
        Bundle bundle = fragmentState.f2146n;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.setArguments(fragmentState.f2146n);
        fragmentA.mWho = fragmentState.f2138f;
        fragmentA.mFromLayout = fragmentState.f2139g;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = fragmentState.f2140h;
        fragmentA.mContainerId = fragmentState.f2141i;
        fragmentA.mTag = fragmentState.f2142j;
        fragmentA.mRetainInstance = fragmentState.f2143k;
        fragmentA.mRemoving = fragmentState.f2144l;
        fragmentA.mDetached = fragmentState.f2145m;
        fragmentA.mHidden = fragmentState.f2147o;
        fragmentA.mMaxState = Lifecycle.State.values()[fragmentState.f2148p];
        Bundle bundle2 = fragmentState.f2149q;
        if (bundle2 != null) {
            fragmentA.mSavedFragmentState = bundle2;
        } else {
            fragmentA.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.F0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    p(@NonNull k kVar, @NonNull q qVar, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.f2270a = kVar;
        this.f2271b = qVar;
        this.f2272c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f2149q;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
