package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.OnBackPressedDispatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.result.ActivityResult;
import android.view.result.ActivityResultRegistry;
import android.view.result.IntentSenderRequest;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.r;
import androidx.fragment.app.s;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import com.facebook.internal.security.CertificateUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager {
    private static boolean O = false;
    static boolean P = true;
    private android.view.result.b<IntentSenderRequest> A;
    private android.view.result.b<String[]> B;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<androidx.fragment.app.a> I;
    private ArrayList<Boolean> J;
    private ArrayList<Fragment> K;
    private ArrayList<o> L;
    private androidx.fragment.app.m M;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2077b;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f2079d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f2080e;

    /* renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f2082g;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<l> f2087l;

    /* renamed from: r, reason: collision with root package name */
    private androidx.fragment.app.i<?> f2093r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.fragment.app.e f2094s;

    /* renamed from: t, reason: collision with root package name */
    private Fragment f2095t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    Fragment f2096u;

    /* renamed from: z, reason: collision with root package name */
    private android.view.result.b<Intent> f2101z;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<m> f2076a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final q f2078c = new q();

    /* renamed from: f, reason: collision with root package name */
    private final androidx.fragment.app.j f2081f = new androidx.fragment.app.j(this);

    /* renamed from: h, reason: collision with root package name */
    private final android.view.g f2083h = new c(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f2084i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Bundle> f2085j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f2086k = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    private Map<Fragment, HashSet<androidx.core.os.f>> f2088m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final s.g f2089n = new d();

    /* renamed from: o, reason: collision with root package name */
    private final androidx.fragment.app.k f2090o = new androidx.fragment.app.k(this);

    /* renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.fragment.app.n> f2091p = new CopyOnWriteArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    int f2092q = -1;

    /* renamed from: v, reason: collision with root package name */
    private androidx.fragment.app.h f2097v = null;

    /* renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.h f2098w = new e();

    /* renamed from: x, reason: collision with root package name */
    private c0 f2099x = null;

    /* renamed from: y, reason: collision with root package name */
    private c0 f2100y = new f();
    ArrayDeque<LaunchedFragmentInfo> C = new ArrayDeque<>();
    private Runnable N = new g();

    /* renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.o f2103b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Lifecycle f2104c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FragmentManager f2105d;

        @Override // androidx.lifecycle.k
        public void d(@NonNull androidx.lifecycle.m mVar, @NonNull Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) this.f2105d.f2085j.get(this.f2102a)) != null) {
                this.f2103b.a(this.f2102a, bundle);
                this.f2105d.r(this.f2102a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f2104c.c(this);
                this.f2105d.f2086k.remove(this.f2102a);
            }
        }
    }

    class a implements android.view.result.a<ActivityResult> {
        a() {
        }

        @Override // android.view.result.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.C.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f2106e;
            int i2 = launchedFragmentInfoPollFirst.f2107f;
            Fragment fragmentI = FragmentManager.this.f2078c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i2, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    class b implements android.view.result.a<Map<String, Boolean>> {
        b() {
        }

        @Override // android.view.result.a
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.C.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f2106e;
            int i3 = launchedFragmentInfoPollFirst.f2107f;
            Fragment fragmentI = FragmentManager.this.f2078c.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i3, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class c extends android.view.g {
        c(boolean z2) {
            super(z2);
        }

        @Override // android.view.g
        public void b() {
            FragmentManager.this.B0();
        }
    }

    class d implements s.g {
        d() {
        }

        @Override // androidx.fragment.app.s.g
        public void a(@NonNull Fragment fragment, @NonNull androidx.core.os.f fVar) {
            if (fVar.b()) {
                return;
            }
            FragmentManager.this.b1(fragment, fVar);
        }

        @Override // androidx.fragment.app.s.g
        public void b(@NonNull Fragment fragment, @NonNull androidx.core.os.f fVar) {
            FragmentManager.this.f(fragment, fVar);
        }
    }

    class e extends androidx.fragment.app.h {
        e() {
        }

        @Override // androidx.fragment.app.h
        @NonNull
        public Fragment a(@NonNull ClassLoader classLoader, @NonNull String str) {
            return FragmentManager.this.t0().b(FragmentManager.this.t0().f(), str, null);
        }
    }

    class f implements c0 {
        f() {
        }

        @Override // androidx.fragment.app.c0
        @NonNull
        public SpecialEffectsController a(@NonNull ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.b0(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2115a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2116b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f2117c;

        h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2115a = viewGroup;
            this.f2116b = view;
            this.f2117c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2115a.endViewTransition(this.f2116b);
            animator.removeListener(this);
            Fragment fragment = this.f2117c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class i implements androidx.fragment.app.n {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f2119e;

        i(Fragment fragment) {
            this.f2119e = fragment;
        }

        @Override // androidx.fragment.app.n
        public void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            this.f2119e.onAttachFragment(fragment);
        }
    }

    class j implements android.view.result.a<ActivityResult> {
        j() {
        }

        @Override // android.view.result.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.C.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f2106e;
            int i2 = launchedFragmentInfoPollFirst.f2107f;
            Fragment fragmentI = FragmentManager.this.f2078c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i2, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    static class k extends d.a<IntentSenderRequest, ActivityResult> {
        k() {
        }

        @Override // d.a
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(@NonNull Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = intentSenderRequest.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.b(intentSenderRequest.d()).b(null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // d.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult parseResult(int i2, @Nullable Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    public interface l {
        @MainThread
        void onBackStackChanged();
    }

    interface m {
        boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    private class n implements m {

        /* renamed from: a, reason: collision with root package name */
        final String f2122a;

        /* renamed from: b, reason: collision with root package name */
        final int f2123b;

        /* renamed from: c, reason: collision with root package name */
        final int f2124c;

        n(@Nullable String str, int i2, int i3) {
            this.f2122a = str;
            this.f2123b = i2;
            this.f2124c = i3;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f2096u;
            if (fragment == null || this.f2123b >= 0 || this.f2122a != null || !fragment.getChildFragmentManager().X0()) {
                return FragmentManager.this.Z0(arrayList, arrayList2, this.f2122a, this.f2123b, this.f2124c);
            }
            return false;
        }
    }

    static class o implements Fragment.k {

        /* renamed from: a, reason: collision with root package name */
        final boolean f2126a;

        /* renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f2127b;

        /* renamed from: c, reason: collision with root package name */
        private int f2128c;

        o(@NonNull androidx.fragment.app.a aVar, boolean z2) {
            this.f2126a = z2;
            this.f2127b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.k
        public void a() {
            int i2 = this.f2128c - 1;
            this.f2128c = i2;
            if (i2 != 0) {
                return;
            }
            this.f2127b.f2170t.j1();
        }

        @Override // androidx.fragment.app.Fragment.k
        public void b() {
            this.f2128c++;
        }

        void c() {
            androidx.fragment.app.a aVar = this.f2127b;
            aVar.f2170t.u(aVar, this.f2126a, false, false);
        }

        void d() {
            boolean z2 = this.f2128c > 0;
            for (Fragment fragment : this.f2127b.f2170t.s0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z2 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.a aVar = this.f2127b;
            aVar.f2170t.u(aVar, this.f2126a, !z2, true);
        }

        public boolean e() {
            return this.f2128c == 0;
        }
    }

    static boolean F0(int i2) {
        return O || Log.isLoggable("FragmentManager", i2);
    }

    private boolean G0(@NonNull Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    private void M(@Nullable Fragment fragment) {
        if (fragment == null || !fragment.equals(g0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void O0(@NonNull androidx.collection.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragmentH = bVar.h(i2);
            if (!fragmentH.mAdded) {
                View viewRequireView = fragmentH.requireView();
                fragmentH.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(0.0f);
            }
        }
    }

    private void T(int i2) {
        try {
            this.f2077b = true;
            this.f2078c.d(i2);
            Q0(i2, false);
            if (P) {
                Iterator<SpecialEffectsController> it = s().iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
            }
            this.f2077b = false;
            b0(true);
        } catch (Throwable th) {
            this.f2077b = false;
            throw th;
        }
    }

    private void W() {
        if (this.H) {
            this.H = false;
            p1();
        }
    }

    private void Y() {
        if (P) {
            Iterator<SpecialEffectsController> it = s().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        } else {
            if (this.f2088m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.f2088m.keySet()) {
                n(fragment);
                R0(fragment);
            }
        }
    }

    private boolean Y0(@Nullable String str, int i2, int i3) {
        b0(false);
        a0(true);
        Fragment fragment = this.f2096u;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().X0()) {
            return true;
        }
        boolean zZ0 = Z0(this.I, this.J, str, i2, i3);
        if (zZ0) {
            this.f2077b = true;
            try {
                d1(this.I, this.J);
            } finally {
                q();
            }
        }
        q1();
        W();
        this.f2078c.b();
        return zZ0;
    }

    private void a0(boolean z2) {
        if (this.f2077b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2093r == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2093r.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2) {
            p();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
            this.J = new ArrayList<>();
        }
        this.f2077b = true;
        try {
            f0(null, null);
        } finally {
            this.f2077b = false;
        }
    }

    private int a1(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i2, int i3, @NonNull androidx.collection.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            boolean zBooleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.y() && !aVar.w(arrayList, i5 + 1, i3)) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                o oVar = new o(aVar, zBooleanValue);
                this.L.add(oVar);
                aVar.A(oVar);
                if (zBooleanValue) {
                    aVar.r();
                } else {
                    aVar.s(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                d(bVar);
            }
        }
        return i4;
    }

    private void d(@NonNull androidx.collection.b<Fragment> bVar) {
        int i2 = this.f2092q;
        if (i2 < 1) {
            return;
        }
        int iMin = Math.min(i2, 5);
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment.mState < iMin) {
                S0(fragment, iMin);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private static void d0(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.n(-1);
                aVar.s(i2 == i3 + (-1));
            } else {
                aVar.n(1);
                aVar.r();
            }
            i2++;
        }
    }

    private void d1(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        f0(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).f2298r) {
                if (i3 != i2) {
                    e0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).f2298r) {
                        i3++;
                    }
                }
                e0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            e0(arrayList, arrayList2, i3, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    private void e0(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i2, int i3) {
        ?? r1;
        boolean z2;
        int i4;
        int i5;
        ArrayList<Boolean> arrayList3;
        int i6;
        int iA1;
        ArrayList<Boolean> arrayList4;
        int i7;
        boolean z3;
        boolean z4 = arrayList.get(i2).f2298r;
        ArrayList<Fragment> arrayList5 = this.K;
        if (arrayList5 == null) {
            this.K = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.K.addAll(this.f2078c.n());
        Fragment fragmentX0 = x0();
        boolean z5 = false;
        for (int i8 = i2; i8 < i3; i8++) {
            androidx.fragment.app.a aVar = arrayList.get(i8);
            fragmentX0 = !arrayList2.get(i8).booleanValue() ? aVar.t(this.K, fragmentX0) : aVar.B(this.K, fragmentX0);
            z5 = z5 || aVar.f2289i;
        }
        this.K.clear();
        if (z4 || this.f2092q < 1) {
            r1 = 1;
        } else if (P) {
            for (int i9 = i2; i9 < i3; i9++) {
                Iterator<r.a> it = arrayList.get(i9).f2283c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f2301b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f2078c.p(w(fragment));
                    }
                }
            }
            r1 = 1;
        } else {
            r1 = 1;
            s.B(this.f2093r.f(), this.f2094s, arrayList, arrayList2, i2, i3, false, this.f2089n);
        }
        d0(arrayList, arrayList2, i2, i3);
        if (P) {
            boolean zBooleanValue = arrayList2.get(i3 - 1).booleanValue();
            for (int i10 = i2; i10 < i3; i10++) {
                androidx.fragment.app.a aVar2 = arrayList.get(i10);
                if (zBooleanValue) {
                    for (int size = aVar2.f2283c.size() - r1; size >= 0; size--) {
                        Fragment fragment2 = aVar2.f2283c.get(size).f2301b;
                        if (fragment2 != null) {
                            w(fragment2).m();
                        }
                    }
                } else {
                    Iterator<r.a> it2 = aVar2.f2283c.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = it2.next().f2301b;
                        if (fragment3 != null) {
                            w(fragment3).m();
                        }
                    }
                }
            }
            Q0(this.f2092q, r1);
            for (SpecialEffectsController specialEffectsController : t(arrayList, i2, i3)) {
                specialEffectsController.r(zBooleanValue);
                specialEffectsController.p();
                specialEffectsController.g();
            }
            i7 = i3;
            arrayList4 = arrayList2;
        } else {
            if (z4) {
                androidx.collection.b bVar = new androidx.collection.b();
                d(bVar);
                i6 = 1;
                z2 = z4;
                i4 = i3;
                i5 = i2;
                arrayList3 = arrayList2;
                iA1 = a1(arrayList, arrayList2, i2, i3, bVar);
                O0(bVar);
            } else {
                z2 = z4;
                i4 = i3;
                i5 = i2;
                arrayList3 = arrayList2;
                i6 = 1;
                iA1 = i4;
            }
            if (iA1 == i5 || !z2) {
                arrayList4 = arrayList3;
                i7 = i4;
            } else {
                if (this.f2092q >= i6) {
                    arrayList4 = arrayList3;
                    int i11 = iA1;
                    i7 = i4;
                    z3 = true;
                    s.B(this.f2093r.f(), this.f2094s, arrayList, arrayList2, i2, i11, true, this.f2089n);
                } else {
                    arrayList4 = arrayList3;
                    i7 = i4;
                    z3 = true;
                }
                Q0(this.f2092q, z3);
            }
        }
        for (int i12 = i2; i12 < i7; i12++) {
            androidx.fragment.app.a aVar3 = arrayList.get(i12);
            if (arrayList4.get(i12).booleanValue() && aVar3.f2172v >= 0) {
                aVar3.f2172v = -1;
            }
            aVar3.z();
        }
        if (z5) {
            f1();
        }
    }

    private void f0(@Nullable ArrayList<androidx.fragment.app.a> arrayList, @Nullable ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<o> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            o oVar = this.L.get(i2);
            if (arrayList != null && !oVar.f2126a && (iIndexOf2 = arrayList.indexOf(oVar.f2127b)) != -1 && arrayList2 != null && arrayList2.get(iIndexOf2).booleanValue()) {
                this.L.remove(i2);
                i2--;
                size--;
                oVar.c();
            } else if (oVar.e() || (arrayList != null && oVar.f2127b.w(arrayList, 0, arrayList.size()))) {
                this.L.remove(i2);
                i2--;
                size--;
                if (arrayList == null || oVar.f2126a || (iIndexOf = arrayList.indexOf(oVar.f2127b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf).booleanValue()) {
                    oVar.d();
                } else {
                    oVar.c();
                }
            }
            i2++;
        }
    }

    private void f1() {
        if (this.f2087l != null) {
            for (int i2 = 0; i2 < this.f2087l.size(); i2++) {
                this.f2087l.get(i2).onBackStackChanged();
            }
        }
    }

    static int h1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void k0() {
        if (P) {
            Iterator<SpecialEffectsController> it = s().iterator();
            while (it.hasNext()) {
                it.next().k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    private boolean l0(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.f2076a) {
            if (this.f2076a.isEmpty()) {
                return false;
            }
            int size = this.f2076a.size();
            boolean zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= this.f2076a.get(i2).a(arrayList, arrayList2);
            }
            this.f2076a.clear();
            this.f2093r.g().removeCallbacks(this.N);
            return zA;
        }
    }

    private void n(@NonNull Fragment fragment) {
        HashSet<androidx.core.os.f> hashSet = this.f2088m.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.os.f> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            x(fragment);
            this.f2088m.remove(fragment);
        }
    }

    @NonNull
    private androidx.fragment.app.m n0(@NonNull Fragment fragment) {
        return this.M.i(fragment);
    }

    private void n1(@NonNull Fragment fragment) {
        ViewGroup viewGroupP0 = p0(fragment);
        if (viewGroupP0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i2 = R$id.visible_removing_fragment_view_tag;
        if (viewGroupP0.getTag(i2) == null) {
            viewGroupP0.setTag(i2, fragment);
        }
        ((Fragment) viewGroupP0.getTag(i2)).setPopDirection(fragment.getPopDirection());
    }

    private void p() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private ViewGroup p0(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2094s.d()) {
            View viewC = this.f2094s.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void p1() {
        Iterator<p> it = this.f2078c.k().iterator();
        while (it.hasNext()) {
            V0(it.next());
        }
    }

    private void q() {
        this.f2077b = false;
        this.J.clear();
        this.I.clear();
    }

    private void q1() {
        synchronized (this.f2076a) {
            if (this.f2076a.isEmpty()) {
                this.f2083h.f(m0() > 0 && I0(this.f2095t));
            } else {
                this.f2083h.f(true);
            }
        }
    }

    private Set<SpecialEffectsController> s() {
        HashSet hashSet = new HashSet();
        Iterator<p> it = this.f2078c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, y0()));
            }
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> t(@NonNull ArrayList<androidx.fragment.app.a> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator<r.a> it = arrayList.get(i2).f2283c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f2301b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    private void v(@NonNull Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            d.C0030d c0030dC = androidx.fragment.app.d.c(this.f2093r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c0030dC == null || (animator = c0030dC.f2239b) == null) {
                if (c0030dC != null) {
                    fragment.mView.startAnimation(c0030dC.f2238a);
                    c0030dC.f2238a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c0030dC.f2239b.addListener(new h(viewGroup, view, fragment));
                }
                c0030dC.f2239b.start();
            }
        }
        D0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void x(@NonNull Fragment fragment) {
        fragment.performDestroyView();
        this.f2090o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.i(null);
        fragment.mInLayout = false;
    }

    @Nullable
    static Fragment z0(@NonNull View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    void A() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(0);
    }

    @NonNull
    e0 A0(@NonNull Fragment fragment) {
        return this.M.l(fragment);
    }

    void B(@NonNull Configuration configuration) {
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    void B0() {
        b0(true);
        if (this.f2083h.c()) {
            X0();
        } else {
            this.f2082g.f();
        }
    }

    boolean C(@NonNull MenuItem menuItem) {
        if (this.f2092q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void C0(@NonNull Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        n1(fragment);
    }

    void D() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(1);
    }

    void D0(@NonNull Fragment fragment) {
        if (fragment.mAdded && G0(fragment)) {
            this.D = true;
        }
    }

    boolean E(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.f2092q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null && H0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f2080e != null) {
            for (int i2 = 0; i2 < this.f2080e.size(); i2++) {
                Fragment fragment2 = this.f2080e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2080e = arrayList;
        return z2;
    }

    public boolean E0() {
        return this.G;
    }

    void F() {
        this.G = true;
        b0(true);
        Y();
        T(-1);
        this.f2093r = null;
        this.f2094s = null;
        this.f2095t = null;
        if (this.f2082g != null) {
            this.f2083h.d();
            this.f2082g = null;
        }
        android.view.result.b<Intent> bVar = this.f2101z;
        if (bVar != null) {
            bVar.d();
            this.A.d();
            this.B.d();
        }
    }

    void G() {
        T(1);
    }

    void H() {
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    boolean H0(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    void I(boolean z2) {
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    boolean I0(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.x0()) && I0(fragmentManager.f2095t);
    }

    void J(@NonNull Fragment fragment) {
        Iterator<androidx.fragment.app.n> it = this.f2091p.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    boolean J0(int i2) {
        return this.f2092q >= i2;
    }

    boolean K(@NonNull MenuItem menuItem) {
        if (this.f2092q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean K0() {
        return this.E || this.F;
    }

    void L(@NonNull Menu menu) {
        if (this.f2092q < 1) {
            return;
        }
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    void L0(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
        if (this.B == null) {
            this.f2093r.j(fragment, strArr, i2);
            return;
        }
        this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        this.B.b(strArr);
    }

    void M0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (this.f2101z == null) {
            this.f2093r.m(fragment, intent, i2, bundle);
            return;
        }
        this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f2101z.b(intent);
    }

    void N() {
        T(5);
    }

    void N0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.A == null) {
            this.f2093r.n(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (F0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.b(intentSender).b(intent2).c(i4, i3).a();
        this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        if (F0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.A.b(intentSenderRequestA);
    }

    void O(boolean z2) {
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    boolean P(@NonNull Menu menu) {
        boolean z2 = false;
        if (this.f2092q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null && H0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    void P0(@NonNull Fragment fragment) {
        if (!this.f2078c.c(fragment.mWho)) {
            if (F0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f2092q + "since it is not added to " + this);
                return;
            }
            return;
        }
        R0(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f2 = fragment.mPostponedAlpha;
            if (f2 > 0.0f) {
                view.setAlpha(f2);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            d.C0030d c0030dC = androidx.fragment.app.d.c(this.f2093r.f(), fragment, true, fragment.getPopDirection());
            if (c0030dC != null) {
                Animation animation = c0030dC.f2238a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    c0030dC.f2239b.setTarget(fragment.mView);
                    c0030dC.f2239b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            v(fragment);
        }
    }

    void Q() {
        q1();
        M(this.f2096u);
    }

    void Q0(int i2, boolean z2) {
        androidx.fragment.app.i<?> iVar;
        if (this.f2093r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i2 != this.f2092q) {
            this.f2092q = i2;
            if (P) {
                this.f2078c.r();
            } else {
                Iterator<Fragment> it = this.f2078c.n().iterator();
                while (it.hasNext()) {
                    P0(it.next());
                }
                for (p pVar : this.f2078c.k()) {
                    Fragment fragmentK = pVar.k();
                    if (!fragmentK.mIsNewlyAdded) {
                        P0(fragmentK);
                    }
                    if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                        this.f2078c.q(pVar);
                    }
                }
            }
            p1();
            if (this.D && (iVar = this.f2093r) != null && this.f2092q == 7) {
                iVar.o();
                this.D = false;
            }
        }
    }

    void R() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(7);
    }

    void R0(@NonNull Fragment fragment) {
        S0(fragment, this.f2092q);
    }

    void S() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(5);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void S0(@androidx.annotation.NonNull androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.S0(androidx.fragment.app.Fragment, int):void");
    }

    void T0() {
        if (this.f2093r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.o(false);
        for (Fragment fragment : this.f2078c.n()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void U() {
        this.F = true;
        this.M.o(true);
        T(4);
    }

    void U0(@NonNull androidx.fragment.app.f fVar) {
        View view;
        for (p pVar : this.f2078c.k()) {
            Fragment fragmentK = pVar.k();
            if (fragmentK.mContainerId == fVar.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = fVar;
                pVar.b();
            }
        }
    }

    void V() {
        T(2);
    }

    void V0(@NonNull p pVar) {
        Fragment fragmentK = pVar.k();
        if (fragmentK.mDeferStart) {
            if (this.f2077b) {
                this.H = true;
                return;
            }
            fragmentK.mDeferStart = false;
            if (P) {
                pVar.m();
            } else {
                R0(fragmentK);
            }
        }
    }

    public void W0(int i2, int i3) {
        if (i2 >= 0) {
            Z(new n(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public void X(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2078c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f2080e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = this.f2080e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f2079d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = this.f2079d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.p(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2084i.get());
        synchronized (this.f2076a) {
            int size3 = this.f2076a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    m mVar = this.f2076a.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(mVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2093r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2094s);
        if (this.f2095t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2095t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2092q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public boolean X0() {
        return Y0(null, -1, 0);
    }

    void Z(@NonNull m mVar, boolean z2) {
        if (!z2) {
            if (this.f2093r == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            p();
        }
        synchronized (this.f2076a) {
            if (this.f2093r == null) {
                if (!z2) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f2076a.add(mVar);
                j1();
            }
        }
    }

    boolean Z0(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i2, int i3) {
        int i4;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f2079d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2079d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f2079d.get(size2);
                    if ((str != null && str.equals(aVar.u())) || (i2 >= 0 && i2 == aVar.f2172v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f2079d.get(size2);
                        if (str == null || !str.equals(aVar2.u())) {
                            if (i2 < 0 || i2 != aVar2.f2172v) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f2079d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2079d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f2079d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    boolean b0(boolean z2) {
        a0(z2);
        boolean z3 = false;
        while (l0(this.I, this.J)) {
            this.f2077b = true;
            try {
                d1(this.I, this.J);
                q();
                z3 = true;
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        q1();
        W();
        this.f2078c.b();
        return z3;
    }

    void b1(@NonNull Fragment fragment, @NonNull androidx.core.os.f fVar) {
        HashSet<androidx.core.os.f> hashSet = this.f2088m.get(fragment);
        if (hashSet != null && hashSet.remove(fVar) && hashSet.isEmpty()) {
            this.f2088m.remove(fragment);
            if (fragment.mState < 5) {
                x(fragment);
                R0(fragment);
            }
        }
    }

    void c0(@NonNull m mVar, boolean z2) {
        if (z2 && (this.f2093r == null || this.G)) {
            return;
        }
        a0(z2);
        if (mVar.a(this.I, this.J)) {
            this.f2077b = true;
            try {
                d1(this.I, this.J);
            } finally {
                q();
            }
        }
        q1();
        W();
        this.f2078c.b();
    }

    void c1(@NonNull Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.f2078c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            n1(fragment);
        }
    }

    void e(androidx.fragment.app.a aVar) {
        if (this.f2079d == null) {
            this.f2079d = new ArrayList<>();
        }
        this.f2079d.add(aVar);
    }

    void e1(@NonNull Fragment fragment) {
        this.M.n(fragment);
    }

    void f(@NonNull Fragment fragment, @NonNull androidx.core.os.f fVar) {
        if (this.f2088m.get(fragment) == null) {
            this.f2088m.put(fragment, new HashSet<>());
        }
        this.f2088m.get(fragment).add(fVar);
    }

    p g(@NonNull Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        p pVarW = w(fragment);
        fragment.mFragmentManager = this;
        this.f2078c.p(pVarW);
        if (!fragment.mDetached) {
            this.f2078c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
        return pVarW;
    }

    @Nullable
    Fragment g0(@NonNull String str) {
        return this.f2078c.f(str);
    }

    void g1(@Nullable Parcelable parcelable) {
        p pVar;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f2129e == null) {
            return;
        }
        this.f2078c.t();
        Iterator<FragmentState> it = fragmentManagerState.f2129e.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            if (next != null) {
                Fragment fragmentH = this.M.h(next.f2138f);
                if (fragmentH != null) {
                    if (F0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentH);
                    }
                    pVar = new p(this.f2090o, this.f2078c, fragmentH, next);
                } else {
                    pVar = new p(this.f2090o, this.f2078c, this.f2093r.f().getClassLoader(), q0(), next);
                }
                Fragment fragmentK = pVar.k();
                fragmentK.mFragmentManager = this;
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                pVar.o(this.f2093r.f().getClassLoader());
                this.f2078c.p(pVar);
                pVar.t(this.f2092q);
            }
        }
        for (Fragment fragment : this.M.k()) {
            if (!this.f2078c.c(fragment.mWho)) {
                if (F0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f2129e);
                }
                this.M.n(fragment);
                fragment.mFragmentManager = this;
                p pVar2 = new p(this.f2090o, this.f2078c, fragment);
                pVar2.t(1);
                pVar2.m();
                fragment.mRemoving = true;
                pVar2.m();
            }
        }
        this.f2078c.u(fragmentManagerState.f2130f);
        if (fragmentManagerState.f2131g != null) {
            this.f2079d = new ArrayList<>(fragmentManagerState.f2131g.length);
            int i2 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f2131g;
                if (i2 >= backStackStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarA = backStackStateArr[i2].a(this);
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVarA.f2172v + "): " + aVarA);
                    PrintWriter printWriter = new PrintWriter(new b0("FragmentManager"));
                    aVarA.q("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2079d.add(aVarA);
                i2++;
            }
        } else {
            this.f2079d = null;
        }
        this.f2084i.set(fragmentManagerState.f2132h);
        String str = fragmentManagerState.f2133i;
        if (str != null) {
            Fragment fragmentG0 = g0(str);
            this.f2096u = fragmentG0;
            M(fragmentG0);
        }
        ArrayList<String> arrayList = fragmentManagerState.f2134j;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bundle bundle = fragmentManagerState.f2135k.get(i3);
                bundle.setClassLoader(this.f2093r.f().getClassLoader());
                this.f2085j.put(arrayList.get(i3), bundle);
            }
        }
        this.C = new ArrayDeque<>(fragmentManagerState.f2136l);
    }

    public void h(@NonNull androidx.fragment.app.n nVar) {
        this.f2091p.add(nVar);
    }

    @Nullable
    public Fragment h0(@IdRes int i2) {
        return this.f2078c.g(i2);
    }

    void i(@NonNull Fragment fragment) {
        this.M.f(fragment);
    }

    @Nullable
    public Fragment i0(@Nullable String str) {
        return this.f2078c.h(str);
    }

    Parcelable i1() {
        int size;
        k0();
        Y();
        b0(true);
        this.E = true;
        this.M.o(true);
        ArrayList<FragmentState> arrayListV = this.f2078c.v();
        BackStackState[] backStackStateArr = null;
        if (arrayListV.isEmpty()) {
            if (F0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListW = this.f2078c.w();
        ArrayList<androidx.fragment.app.a> arrayList = this.f2079d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f2079d.get(i2));
                if (F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f2079d.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2129e = arrayListV;
        fragmentManagerState.f2130f = arrayListW;
        fragmentManagerState.f2131g = backStackStateArr;
        fragmentManagerState.f2132h = this.f2084i.get();
        Fragment fragment = this.f2096u;
        if (fragment != null) {
            fragmentManagerState.f2133i = fragment.mWho;
        }
        fragmentManagerState.f2134j.addAll(this.f2085j.keySet());
        fragmentManagerState.f2135k.addAll(this.f2085j.values());
        fragmentManagerState.f2136l = new ArrayList<>(this.C);
        return fragmentManagerState;
    }

    int j() {
        return this.f2084i.getAndIncrement();
    }

    Fragment j0(@NonNull String str) {
        return this.f2078c.i(str);
    }

    void j1() {
        synchronized (this.f2076a) {
            ArrayList<o> arrayList = this.L;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z3 = this.f2076a.size() == 1;
            if (z2 || z3) {
                this.f2093r.g().removeCallbacks(this.N);
                this.f2093r.g().post(this.N);
                q1();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    void k(@NonNull androidx.fragment.app.i<?> iVar, @NonNull androidx.fragment.app.e eVar, @Nullable Fragment fragment) {
        String str;
        if (this.f2093r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2093r = iVar;
        this.f2094s = eVar;
        this.f2095t = fragment;
        if (fragment != null) {
            h(new i(fragment));
        } else if (iVar instanceof androidx.fragment.app.n) {
            h((androidx.fragment.app.n) iVar);
        }
        if (this.f2095t != null) {
            q1();
        }
        if (iVar instanceof android.view.k) {
            android.view.k kVar = (android.view.k) iVar;
            OnBackPressedDispatcher onBackPressedDispatcher = kVar.getOnBackPressedDispatcher();
            this.f2082g = onBackPressedDispatcher;
            androidx.lifecycle.m mVar = kVar;
            if (fragment != null) {
                mVar = fragment;
            }
            onBackPressedDispatcher.b(mVar, this.f2083h);
        }
        if (fragment != null) {
            this.M = fragment.mFragmentManager.n0(fragment);
        } else if (iVar instanceof f0) {
            this.M = androidx.fragment.app.m.j(((f0) iVar).getViewModelStore());
        } else {
            this.M = new androidx.fragment.app.m(false);
        }
        this.M.o(K0());
        this.f2078c.x(this.M);
        Object obj = this.f2093r;
        if (obj instanceof android.view.result.c) {
            ActivityResultRegistry activityResultRegistry = ((android.view.result.c) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + CertificateUtil.DELIMITER;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f2101z = activityResultRegistry.j(str2 + "StartActivityForResult", new d.c(), new j());
            this.A = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new k(), new a());
            this.B = activityResultRegistry.j(str2 + "RequestPermissions", new d.b(), new b());
        }
    }

    void k1(@NonNull Fragment fragment, boolean z2) {
        ViewGroup viewGroupP0 = p0(fragment);
        if (viewGroupP0 == null || !(viewGroupP0 instanceof androidx.fragment.app.f)) {
            return;
        }
        ((androidx.fragment.app.f) viewGroupP0).setDrawDisappearingViewsLast(!z2);
    }

    void l(@NonNull Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f2078c.a(fragment);
            if (F0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
    }

    void l1(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @NonNull
    public r m() {
        return new androidx.fragment.app.a(this);
    }

    public int m0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f2079d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void m1(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2096u;
            this.f2096u = fragment;
            M(fragment2);
            M(this.f2096u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    boolean o() {
        boolean zG0 = false;
        for (Fragment fragment : this.f2078c.l()) {
            if (fragment != null) {
                zG0 = G0(fragment);
            }
            if (zG0) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    androidx.fragment.app.e o0() {
        return this.f2094s;
    }

    void o1(@NonNull Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    @NonNull
    public androidx.fragment.app.h q0() {
        androidx.fragment.app.h hVar = this.f2097v;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.f2095t;
        return fragment != null ? fragment.mFragmentManager.q0() : this.f2098w;
    }

    public final void r(@NonNull String str) {
        this.f2085j.remove(str);
    }

    @NonNull
    q r0() {
        return this.f2078c;
    }

    @NonNull
    public List<Fragment> s0() {
        return this.f2078c.n();
    }

    @NonNull
    androidx.fragment.app.i<?> t0() {
        return this.f2093r;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2095t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2095t)));
            sb.append("}");
        } else {
            androidx.fragment.app.i<?> iVar = this.f2093r;
            if (iVar != null) {
                sb.append(iVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f2093r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    void u(@NonNull androidx.fragment.app.a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.s(z4);
        } else {
            aVar.r();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 && this.f2092q >= 1) {
            s.B(this.f2093r.f(), this.f2094s, arrayList, arrayList2, 0, 1, true, this.f2089n);
        }
        if (z4) {
            Q0(this.f2092q, true);
        }
        for (Fragment fragment : this.f2078c.l()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.v(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z4) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    @NonNull
    LayoutInflater.Factory2 u0() {
        return this.f2081f;
    }

    @NonNull
    androidx.fragment.app.k v0() {
        return this.f2090o;
    }

    @NonNull
    p w(@NonNull Fragment fragment) {
        p pVarM = this.f2078c.m(fragment.mWho);
        if (pVarM != null) {
            return pVarM;
        }
        p pVar = new p(this.f2090o, this.f2078c, fragment);
        pVar.o(this.f2093r.f().getClassLoader());
        pVar.t(this.f2092q);
        return pVar;
    }

    @Nullable
    Fragment w0() {
        return this.f2095t;
    }

    @Nullable
    public Fragment x0() {
        return this.f2096u;
    }

    void y(@NonNull Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (F0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f2078c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            n1(fragment);
        }
    }

    @NonNull
    c0 y0() {
        c0 c0Var = this.f2099x;
        if (c0Var != null) {
            return c0Var;
        }
        Fragment fragment = this.f2095t;
        return fragment != null ? fragment.mFragmentManager.y0() : this.f2100y;
    }

    void z() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(4);
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f2106e;

        /* renamed from: f, reason: collision with root package name */
        int f2107f;

        class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        }

        LaunchedFragmentInfo(@NonNull String str, int i2) {
            this.f2106e = str;
            this.f2107f = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f2106e);
            parcel.writeInt(this.f2107f);
        }

        LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.f2106e = parcel.readString();
            this.f2107f = parcel.readInt();
        }
    }
}
