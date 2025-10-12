package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.k2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class e implements n.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f510a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f511b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f512c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f513d;

    /* renamed from: e, reason: collision with root package name */
    private a f514e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f522m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f523n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f524o;

    /* renamed from: p, reason: collision with root package name */
    View f525p;

    /* renamed from: x, reason: collision with root package name */
    private g f533x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f535z;

    /* renamed from: l, reason: collision with root package name */
    private int f521l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f526q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f527r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f528s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f529t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f530u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<g> f531v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<k>> f532w = new CopyOnWriteArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    private boolean f534y = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<g> f515f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<g> f516g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f517h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<g> f518i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<g> f519j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f520k = true;

    /* compiled from: MenuBuilder.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface a {
        boolean a(@NonNull e eVar, @NonNull MenuItem menuItem);

        void b(@NonNull e eVar);
    }

    /* compiled from: MenuBuilder.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f510a = context;
        this.f511b = context.getResources();
        b0(true);
    }

    private static int B(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i2, boolean z2) {
        if (i2 < 0 || i2 >= this.f515f.size()) {
            return;
        }
        this.f515f.remove(i2);
        if (z2) {
            K(true);
        }
    }

    private void W(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f525p = view;
            this.f523n = null;
            this.f524o = null;
        } else {
            if (i2 > 0) {
                this.f523n = resourcesC.getText(i2);
            } else if (charSequence != null) {
                this.f523n = charSequence;
            }
            if (i3 > 0) {
                this.f524o = ContextCompat.d(u(), i3);
            } else if (drawable != null) {
                this.f524o = drawable;
            }
            this.f525p = null;
        }
        K(false);
    }

    private void b0(boolean z2) {
        this.f513d = z2 && this.f511b.getConfiguration().keyboard != 1 && k2.b(ViewConfiguration.get(this.f510a), this.f510a);
    }

    private g g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new g(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z2) {
        if (this.f532w.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<k>> it = this.f532w.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar = next.get();
            if (kVar == null) {
                this.f532w.remove(next);
            } else {
                kVar.f(z2);
            }
        }
        c0();
    }

    private boolean j(p pVar, k kVar) {
        if (this.f532w.isEmpty()) {
            return false;
        }
        boolean zE = kVar != null ? kVar.e(pVar) : false;
        Iterator<WeakReference<k>> it = this.f532w.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar2 = next.get();
            if (kVar2 == null) {
                this.f532w.remove(next);
            } else if (!zE) {
                zE = kVar2.e(pVar);
            }
        }
        return zE;
    }

    private static int n(ArrayList<g> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.f529t;
    }

    Resources C() {
        return this.f511b;
    }

    public e D() {
        return this;
    }

    @NonNull
    public ArrayList<g> E() {
        if (!this.f517h) {
            return this.f516g;
        }
        this.f516g.clear();
        int size = this.f515f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.f515f.get(i2);
            if (gVar.isVisible()) {
                this.f516g.add(gVar);
            }
        }
        this.f517h = false;
        this.f520k = true;
        return this.f516g;
    }

    public boolean F() {
        return this.f534y;
    }

    boolean G() {
        return this.f512c;
    }

    public boolean H() {
        return this.f513d;
    }

    void I(g gVar) {
        this.f520k = true;
        K(true);
    }

    void J(g gVar) {
        this.f517h = true;
        K(true);
    }

    public void K(boolean z2) {
        if (this.f526q) {
            this.f527r = true;
            if (z2) {
                this.f528s = true;
                return;
            }
            return;
        }
        if (z2) {
            this.f517h = true;
            this.f520k = true;
        }
        i(z2);
    }

    public boolean L(MenuItem menuItem, int i2) {
        return M(menuItem, null, i2);
    }

    public boolean M(MenuItem menuItem, k kVar, int i2) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        androidx.core.view.b bVarB = gVar.b();
        boolean z2 = bVarB != null && bVarB.a();
        if (gVar.j()) {
            zK |= gVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (gVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new p(u(), this, gVar));
            }
            p pVar = (p) gVar.getSubMenu();
            if (z2) {
                bVarB.f(pVar);
            }
            zK |= j(pVar, kVar);
            if (!zK) {
                e(true);
            }
        } else if ((i2 & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void O(k kVar) {
        Iterator<WeakReference<k>> it = this.f532w.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar2 = next.get();
            if (kVar2 == null || kVar2 == kVar) {
                this.f532w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).P(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f514e = aVar;
    }

    public e S(int i2) {
        this.f521l = i2;
        return this;
    }

    void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f515f.size();
        d0();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.f515f.get(i2);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    protected e U(int i2) {
        W(0, null, i2, null, null);
        return this;
    }

    protected e V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    protected e X(int i2) {
        W(i2, null, 0, null, null);
        return this;
    }

    protected e Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    protected e Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int iB = B(i4);
        g gVarG = g(i2, i3, i4, iB, charSequence, this.f521l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f522m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f515f;
        arrayList.add(n(arrayList, iB), gVarG);
        K(true);
        return gVarG;
    }

    public void a0(boolean z2) {
        this.f535z = z2;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f510a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(k kVar) {
        c(kVar, this.f510a);
    }

    public void c(k kVar, Context context) {
        this.f532w.add(new WeakReference<>(kVar));
        kVar.c(context, this);
        this.f520k = true;
    }

    public void c0() {
        this.f526q = false;
        if (this.f527r) {
            this.f527r = false;
            K(this.f528s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f533x;
        if (gVar != null) {
            f(gVar);
        }
        this.f515f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f524o = null;
        this.f523n = null;
        this.f525p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f514e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.f526q) {
            return;
        }
        this.f526q = true;
        this.f527r = false;
        this.f528s = false;
    }

    public final void e(boolean z2) {
        if (this.f530u) {
            return;
        }
        this.f530u = true;
        Iterator<WeakReference<k>> it = this.f532w.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar = next.get();
            if (kVar == null) {
                this.f532w.remove(next);
            } else {
                kVar.a(this, z2);
            }
        }
        this.f530u = false;
    }

    public boolean f(g gVar) {
        boolean zI = false;
        if (!this.f532w.isEmpty() && this.f533x == gVar) {
            d0();
            Iterator<WeakReference<k>> it = this.f532w.iterator();
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.f532w.remove(next);
                } else {
                    zI = kVar.i(this, gVar);
                    if (zI) {
                        break;
                    }
                }
            }
            c0();
            if (zI) {
                this.f533x = null;
            }
        }
        return zI;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.f515f.get(i3);
            if (gVar.getItemId() == i2) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i2)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.f515f.get(i2);
    }

    boolean h(@NonNull e eVar, @NonNull MenuItem menuItem) {
        a aVar = this.f514e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f535z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f515f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return p(i2, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean zJ = false;
        if (this.f532w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<k>> it = this.f532w.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar = next.get();
            if (kVar == null) {
                this.f532w.remove(next);
            } else {
                zJ = kVar.j(this, gVar);
                if (zJ) {
                    break;
                }
            }
        }
        c0();
        if (zJ) {
            this.f533x = gVar;
        }
        return zJ;
    }

    public int l(int i2) {
        return m(i2, 0);
    }

    public int m(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f515f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int o(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f515f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    g p(int i2, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f531v;
        arrayList.clear();
        q(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zG = G();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = arrayList.get(i3);
            char alphabeticShortcut = zG ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zG && alphabeticShortcut == '\b' && i2 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return L(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        g gVarP = p(i2, keyEvent);
        boolean zL = gVarP != null ? L(gVarP, i3) : false;
        if ((i3 & 2) != 0) {
            e(true);
        }
        return zL;
    }

    void q(List<g> list, int i2, KeyEvent keyEvent) {
        boolean zG = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f515f.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = this.f515f.get(i3);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i2, keyEvent);
                }
                char alphabeticShortcut = zG ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((zG ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zG && alphabeticShortcut == '\b' && i2 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<g> arrayListE = E();
        if (this.f520k) {
            Iterator<WeakReference<k>> it = this.f532w.iterator();
            boolean zH = false;
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.f532w.remove(next);
                } else {
                    zH |= kVar.h();
                }
            }
            if (zH) {
                this.f518i.clear();
                this.f519j.clear();
                int size = arrayListE.size();
                for (int i2 = 0; i2 < size; i2++) {
                    g gVar = arrayListE.get(i2);
                    if (gVar.l()) {
                        this.f518i.add(gVar);
                    } else {
                        this.f519j.add(gVar);
                    }
                }
            } else {
                this.f518i.clear();
                this.f519j.clear();
                this.f519j.addAll(E());
            }
            this.f520k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int iL = l(i2);
        if (iL >= 0) {
            int size = this.f515f.size() - iL;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f515f.get(iL).getGroupId() != i2) {
                    break;
                }
                N(iL, false);
                i3 = i4;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        N(o(i2), true);
    }

    public ArrayList<g> s() {
        r();
        return this.f518i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f515f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.f515f.get(i3);
            if (gVar.getGroupId() == i2) {
                gVar.t(z3);
                gVar.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f534y = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f515f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.f515f.get(i3);
            if (gVar.getGroupId() == i2) {
                gVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f515f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.f515f.get(i3);
            if (gVar.getGroupId() == i2 && gVar.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f512c = z2;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f515f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f510a;
    }

    public g v() {
        return this.f533x;
    }

    public Drawable w() {
        return this.f524o;
    }

    public CharSequence x() {
        return this.f523n;
    }

    public View y() {
        return this.f525p;
    }

    public ArrayList<g> z() {
        r();
        return this.f519j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f511b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f511b.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        g gVar = (g) a(i2, i3, i4, charSequence);
        p pVar = new p(this.f510a, this, gVar);
        gVar.x(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f511b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f511b.getString(i5));
    }
}
