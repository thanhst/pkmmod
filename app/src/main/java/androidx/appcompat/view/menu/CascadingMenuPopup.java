package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.u1;
import androidx.appcompat.widget.x1;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class CascadingMenuPopup extends i implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int F = R$layout.abc_cascading_menu_item_layout;
    private boolean A;
    private k.a B;
    ViewTreeObserver C;
    private PopupWindow.OnDismissListener D;
    boolean E;

    /* renamed from: f, reason: collision with root package name */
    private final Context f409f;

    /* renamed from: g, reason: collision with root package name */
    private final int f410g;

    /* renamed from: h, reason: collision with root package name */
    private final int f411h;

    /* renamed from: i, reason: collision with root package name */
    private final int f412i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f413j;

    /* renamed from: k, reason: collision with root package name */
    final Handler f414k;

    /* renamed from: s, reason: collision with root package name */
    private View f422s;

    /* renamed from: t, reason: collision with root package name */
    View f423t;

    /* renamed from: v, reason: collision with root package name */
    private boolean f425v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f426w;

    /* renamed from: x, reason: collision with root package name */
    private int f427x;

    /* renamed from: y, reason: collision with root package name */
    private int f428y;

    /* renamed from: l, reason: collision with root package name */
    private final List<e> f415l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    final List<d> f416m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f417n = new a();

    /* renamed from: o, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f418o = new b();

    /* renamed from: p, reason: collision with root package name */
    private final u1 f419p = new c();

    /* renamed from: q, reason: collision with root package name */
    private int f420q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f421r = 0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f429z = false;

    /* renamed from: u, reason: collision with root package name */
    private int f424u = D();

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.b() || CascadingMenuPopup.this.f416m.size() <= 0 || CascadingMenuPopup.this.f416m.get(0).f437a.x()) {
                return;
            }
            View view = CascadingMenuPopup.this.f423t;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.dismiss();
                return;
            }
            Iterator<d> it = CascadingMenuPopup.this.f416m.iterator();
            while (it.hasNext()) {
                it.next().f437a.d();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.C;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.C = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.C.removeGlobalOnLayoutListener(cascadingMenuPopup.f417n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements u1 {

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f433e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ MenuItem f434f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f435g;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f433e = dVar;
                this.f434f = menuItem;
                this.f435g = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f433e;
                if (dVar != null) {
                    CascadingMenuPopup.this.E = true;
                    dVar.f438b.e(false);
                    CascadingMenuPopup.this.E = false;
                }
                if (this.f434f.isEnabled() && this.f434f.hasSubMenu()) {
                    this.f435g.L(this.f434f, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.u1
        public void c(@NonNull e eVar, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.f414k.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f416m.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (eVar == CascadingMenuPopup.this.f416m.get(i2).f438b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            CascadingMenuPopup.this.f414k.postAtTime(new a(i3 < CascadingMenuPopup.this.f416m.size() ? CascadingMenuPopup.this.f416m.get(i3) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.u1
        public void e(@NonNull e eVar, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.f414k.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final x1 f437a;

        /* renamed from: b, reason: collision with root package name */
        public final e f438b;

        /* renamed from: c, reason: collision with root package name */
        public final int f439c;

        public d(@NonNull x1 x1Var, @NonNull e eVar, int i2) {
            this.f437a = x1Var;
            this.f438b = eVar;
            this.f439c = i2;
        }

        public ListView a() {
            return this.f437a.g();
        }
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i2, @StyleRes int i3, boolean z2) {
        this.f409f = context;
        this.f422s = view;
        this.f411h = i2;
        this.f412i = i3;
        this.f413j = z2;
        Resources resources = context.getResources();
        this.f410g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f414k = new Handler();
    }

    private int A(@NonNull e eVar) {
        int size = this.f416m.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (eVar == this.f416m.get(i2).f438b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem B(@NonNull e eVar, @NonNull e eVar2) {
        int size = eVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = eVar.getItem(i2);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    private View C(@NonNull d dVar, @NonNull e eVar) {
        MenuAdapter menuAdapter;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f438b, eVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            headersCount = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (menuItemB == menuAdapter.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return ViewCompat.r(this.f422s) == 1 ? 0 : 1;
    }

    private int E(int i2) {
        List<d> list = this.f416m;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f423t.getWindowVisibleDisplayFrame(rect);
        return this.f424u == 1 ? (iArr[0] + listViewA.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void F(@NonNull e eVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        d dVar;
        View viewC;
        int i2;
        int i3;
        int i4;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f409f);
        MenuAdapter menuAdapter = new MenuAdapter(eVar, layoutInflaterFrom, this.f413j, F);
        if (!b() && this.f429z) {
            menuAdapter.d(true);
        } else if (b()) {
            menuAdapter.d(i.x(eVar));
        }
        int iO = i.o(menuAdapter, null, this.f409f, this.f410g);
        x1 x1VarZ = z();
        x1VarZ.p(menuAdapter);
        x1VarZ.B(iO);
        x1VarZ.C(this.f421r);
        if (this.f416m.size() > 0) {
            List<d> list = this.f416m;
            dVar = list.get(list.size() - 1);
            viewC = C(dVar, eVar);
        } else {
            dVar = null;
            viewC = null;
        }
        if (viewC != null) {
            x1VarZ.Q(false);
            x1VarZ.N(null);
            int iE = E(iO);
            boolean z2 = iE == 1;
            this.f424u = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                x1VarZ.z(viewC);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.f422s.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.f421r & 7) == 5) {
                    iArr[0] = iArr[0] + this.f422s.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.f421r & 5) == 5) {
                if (!z2) {
                    iO = viewC.getWidth();
                    i4 = i2 - iO;
                }
                i4 = i2 + iO;
            } else {
                if (z2) {
                    iO = viewC.getWidth();
                    i4 = i2 + iO;
                }
                i4 = i2 - iO;
            }
            x1VarZ.l(i4);
            x1VarZ.I(true);
            x1VarZ.j(i3);
        } else {
            if (this.f425v) {
                x1VarZ.l(this.f427x);
            }
            if (this.f426w) {
                x1VarZ.j(this.f428y);
            }
            x1VarZ.D(n());
        }
        this.f416m.add(new d(x1VarZ, eVar, this.f424u));
        x1VarZ.d();
        ListView listViewG = x1VarZ.g();
        listViewG.setOnKeyListener(this);
        if (dVar == null && this.A && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.x());
            listViewG.addHeaderView(frameLayout, null, false);
            x1VarZ.d();
        }
    }

    private x1 z() {
        x1 x1Var = new x1(this.f409f, null, this.f411h, this.f412i);
        x1Var.P(this.f419p);
        x1Var.H(this);
        x1Var.G(this);
        x1Var.z(this.f422s);
        x1Var.C(this.f421r);
        x1Var.F(true);
        x1Var.E(2);
        return x1Var;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(e eVar, boolean z2) {
        int iA = A(eVar);
        if (iA < 0) {
            return;
        }
        int i2 = iA + 1;
        if (i2 < this.f416m.size()) {
            this.f416m.get(i2).f438b.e(false);
        }
        d dVarRemove = this.f416m.remove(iA);
        dVarRemove.f438b.O(this);
        if (this.E) {
            dVarRemove.f437a.O(null);
            dVarRemove.f437a.A(0);
        }
        dVarRemove.f437a.dismiss();
        int size = this.f416m.size();
        if (size > 0) {
            this.f424u = this.f416m.get(size - 1).f439c;
        } else {
            this.f424u = D();
        }
        if (size != 0) {
            if (z2) {
                this.f416m.get(0).f438b.e(false);
                return;
            }
            return;
        }
        dismiss();
        k.a aVar = this.B;
        if (aVar != null) {
            aVar.a(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.C;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.C.removeGlobalOnLayoutListener(this.f417n);
            }
            this.C = null;
        }
        this.f423t.removeOnAttachStateChangeListener(this.f418o);
        this.D.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b() {
        return this.f416m.size() > 0 && this.f416m.get(0).f437a.b();
    }

    @Override // androidx.appcompat.view.menu.n
    public void d() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (b()) {
            return;
        }
        Iterator<e> it = this.f415l.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f415l.clear();
        View view = this.f422s;
        this.f423t = view;
        if (view != null) {
            boolean z2 = this.C == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.C = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f417n);
            }
            this.f423t.addOnAttachStateChangeListener(this.f418o);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void dismiss() {
        int size = this.f416m.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f416m.toArray(new d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d dVar = dVarArr[i2];
                if (dVar.f437a.b()) {
                    dVar.f437a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean e(p pVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (d dVar : this.f416m) {
            if (pVar == dVar.f438b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        l(pVar);
        k.a aVar = this.B;
        if (aVar != null) {
            aVar.b(pVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void f(boolean z2) {
        Iterator<d> it = this.f416m.iterator();
        while (it.hasNext()) {
            i.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public ListView g() {
        if (this.f416m.isEmpty()) {
            return null;
        }
        return this.f416m.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(k.a aVar) {
        this.B = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void l(e eVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eVar.c(this, this.f409f);
        if (b()) {
            F(eVar);
        } else {
            this.f415l.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f416m.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f416m.get(i2);
            if (!dVar.f437a.b()) {
                break;
            } else {
                i2++;
            }
        }
        if (dVar != null) {
            dVar.f438b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public void p(@NonNull View view) {
        if (this.f422s != view) {
            this.f422s = view;
            this.f421r = androidx.core.view.d.a(this.f420q, ViewCompat.r(view));
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void r(boolean z2) {
        this.f429z = z2;
    }

    @Override // androidx.appcompat.view.menu.i
    public void s(int i2) {
        if (this.f420q != i2) {
            this.f420q = i2;
            this.f421r = androidx.core.view.d.a(i2, ViewCompat.r(this.f422s));
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void t(int i2) {
        this.f425v = true;
        this.f427x = i2;
    }

    @Override // androidx.appcompat.view.menu.i
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.D = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.i
    public void v(boolean z2) {
        this.A = z2;
    }

    @Override // androidx.appcompat.view.menu.i
    public void w(int i2) {
        this.f426w = true;
        this.f428y = i2;
    }
}
