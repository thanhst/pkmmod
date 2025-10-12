package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class x1 extends q1 implements u1 {
    private static Method O;
    private u1 N;

    /* compiled from: MenuPopupWindow.java */
    @RequiresApi(23)
    static class a {
        @DoNotInline
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        @DoNotInline
        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    @RequiresApi(29)
    static class b {
        @DoNotInline
        static void a(PopupWindow popupWindow, boolean z2) {
            popupWindow.setTouchModal(z2);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class c extends n1 {

        /* renamed from: r, reason: collision with root package name */
        final int f1169r;

        /* renamed from: s, reason: collision with root package name */
        final int f1170s;

        /* renamed from: t, reason: collision with root package name */
        private u1 f1171t;

        /* renamed from: u, reason: collision with root package name */
        private MenuItem f1172u;

        /* compiled from: MenuPopupWindow.java */
        @RequiresApi(17)
        static class a {
            @DoNotInline
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z2) {
            super(context, z2);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f1169r = 21;
                this.f1170s = 22;
            } else {
                this.f1169r = 22;
                this.f1170s = 21;
            }
        }

        @Override // androidx.appcompat.widget.n1
        public /* bridge */ /* synthetic */ int d(int i2, int i3, int i4, int i5, int i6) {
            return super.d(i2, i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.n1
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i2) {
            return super.e(motionEvent, i2);
        }

        @Override // androidx.appcompat.widget.n1, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.n1, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.n1, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.n1, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.n1, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            MenuAdapter menuAdapter;
            int iPointToPosition;
            int i2;
            if (this.f1171t != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                androidx.appcompat.view.menu.g item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = iPointToPosition - headersCount) >= 0 && i2 < menuAdapter.getCount()) {
                    item = menuAdapter.getItem(i2);
                }
                MenuItem menuItem = this.f1172u;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = menuAdapter.b();
                    if (menuItem != null) {
                        this.f1171t.e(eVarB, menuItem);
                    }
                    this.f1172u = item;
                    if (item != null) {
                        this.f1171t.c(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f1169r) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i2 != this.f1170s) {
                return super.onKeyDown(i2, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (MenuAdapter) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.n1, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(u1 u1Var) {
            this.f1171t = u1Var;
        }

        @Override // androidx.appcompat.widget.n1, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                O = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public x1(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void N(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.J, (Transition) obj);
        }
    }

    public void O(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.J, (Transition) obj);
        }
    }

    public void P(u1 u1Var) {
        this.N = u1Var;
    }

    public void Q(boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.J, z2);
            return;
        }
        Method method = O;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.u1
    public void c(@NonNull androidx.appcompat.view.menu.e eVar, @NonNull MenuItem menuItem) {
        u1 u1Var = this.N;
        if (u1Var != null) {
            u1Var.c(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.u1
    public void e(@NonNull androidx.appcompat.view.menu.e eVar, @NonNull MenuItem menuItem) {
        u1 u1Var = this.N;
        if (u1Var != null) {
            u1Var.e(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.q1
    @NonNull
    n1 s(Context context, boolean z2) {
        c cVar = new c(context, z2);
        cVar.setHoverListener(this);
        return cVar;
    }
}
