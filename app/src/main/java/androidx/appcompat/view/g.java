package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.k2;
import androidx.appcompat.widget.l1;
import androidx.core.view.x;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import n.a_n;

/* compiled from: SupportMenuInflater.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class<?>[] f352e;

    /* renamed from: f, reason: collision with root package name */
    static final Class<?>[] f353f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f354a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f355b;

    /* renamed from: c, reason: collision with root package name */
    Context f356c;

    /* renamed from: d, reason: collision with root package name */
    private Object f357d;

    /* compiled from: SupportMenuInflater.java */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f358c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f359a;

        /* renamed from: b, reason: collision with root package name */
        private Method f360b;

        public a(Object obj, String str) {
            this.f359a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f360b = cls.getMethod(str, f358c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f360b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f360b.invoke(this.f359a, menuItem)).booleanValue();
                }
                this.f360b.invoke(this.f359a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    private class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f361a;

        /* renamed from: b, reason: collision with root package name */
        private int f362b;

        /* renamed from: c, reason: collision with root package name */
        private int f363c;

        /* renamed from: d, reason: collision with root package name */
        private int f364d;

        /* renamed from: e, reason: collision with root package name */
        private int f365e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f366f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f367g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f368h;

        /* renamed from: i, reason: collision with root package name */
        private int f369i;

        /* renamed from: j, reason: collision with root package name */
        private int f370j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f371k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f372l;

        /* renamed from: m, reason: collision with root package name */
        private int f373m;

        /* renamed from: n, reason: collision with root package name */
        private char f374n;

        /* renamed from: o, reason: collision with root package name */
        private int f375o;

        /* renamed from: p, reason: collision with root package name */
        private char f376p;

        /* renamed from: q, reason: collision with root package name */
        private int f377q;

        /* renamed from: r, reason: collision with root package name */
        private int f378r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f379s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f380t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f381u;

        /* renamed from: v, reason: collision with root package name */
        private int f382v;

        /* renamed from: w, reason: collision with root package name */
        private int f383w;

        /* renamed from: x, reason: collision with root package name */
        private String f384x;

        /* renamed from: y, reason: collision with root package name */
        private String f385y;

        /* renamed from: z, reason: collision with root package name */
        private String f386z;

        public b(Menu menu) {
            this.f361a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f356c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z2 = false;
            menuItem.setChecked(this.f379s).setVisible(this.f380t).setEnabled(this.f381u).setCheckable(this.f378r >= 1).setTitleCondensed(this.f372l).setIcon(this.f373m);
            int i2 = this.f382v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.f386z != null) {
                if (g.this.f356c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f386z));
            }
            if (this.f378r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    ((androidx.appcompat.view.menu.h) menuItem).h(true);
                }
            }
            String str = this.f384x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f352e, g.this.f354a));
                z2 = true;
            }
            int i3 = this.f383w;
            if (i3 > 0) {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i3);
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                x.a(menuItem, bVar);
            }
            x.c(menuItem, this.B);
            x.g(menuItem, this.C);
            x.b(menuItem, this.f374n, this.f375o);
            x.f(menuItem, this.f376p, this.f377q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                x.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                x.d(menuItem, colorStateList);
            }
        }

        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f368h = true;
            i(this.f361a.add(this.f362b, this.f369i, this.f370j, this.f371k));
        }

        public SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f368h = true;
            SubMenu subMenuAddSubMenu = this.f361a.addSubMenu(this.f362b, this.f369i, this.f370j, this.f371k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f368h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f356c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f362b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f363c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f364d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f365e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f366f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f367g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            k2 k2VarT = k2.t(g.this.f356c, attributeSet, R$styleable.MenuItem);
            this.f369i = k2VarT.m(R$styleable.MenuItem_android_id, 0);
            this.f370j = (k2VarT.j(R$styleable.MenuItem_android_menuCategory, this.f363c) & (-65536)) | (k2VarT.j(R$styleable.MenuItem_android_orderInCategory, this.f364d) & 65535);
            this.f371k = k2VarT.o(R$styleable.MenuItem_android_title);
            this.f372l = k2VarT.o(R$styleable.MenuItem_android_titleCondensed);
            this.f373m = k2VarT.m(R$styleable.MenuItem_android_icon, 0);
            this.f374n = c(k2VarT.n(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f375o = k2VarT.j(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f376p = c(k2VarT.n(R$styleable.MenuItem_android_numericShortcut));
            this.f377q = k2VarT.j(R$styleable.MenuItem_numericModifiers, 4096);
            int i2 = R$styleable.MenuItem_android_checkable;
            if (k2VarT.r(i2)) {
                this.f378r = k2VarT.a(i2, false) ? 1 : 0;
            } else {
                this.f378r = this.f365e;
            }
            this.f379s = k2VarT.a(R$styleable.MenuItem_android_checked, false);
            this.f380t = k2VarT.a(R$styleable.MenuItem_android_visible, this.f366f);
            this.f381u = k2VarT.a(R$styleable.MenuItem_android_enabled, this.f367g);
            this.f382v = k2VarT.j(R$styleable.MenuItem_showAsAction, -1);
            this.f386z = k2VarT.n(R$styleable.MenuItem_android_onClick);
            this.f383w = k2VarT.m(R$styleable.MenuItem_actionLayout, 0);
            this.f384x = k2VarT.n(R$styleable.MenuItem_actionViewClass);
            String strN = k2VarT.n(R$styleable.MenuItem_actionProviderClass);
            this.f385y = strN;
            boolean z2 = strN != null;
            if (z2 && this.f383w == 0 && this.f384x == null) {
                this.A = (androidx.core.view.b) e(strN, g.f353f, g.this.f355b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = k2VarT.o(R$styleable.MenuItem_contentDescription);
            this.C = k2VarT.o(R$styleable.MenuItem_tooltipText);
            int i3 = R$styleable.MenuItem_iconTintMode;
            if (k2VarT.r(i3)) {
                this.E = l1.d(k2VarT.j(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = R$styleable.MenuItem_iconTint;
            if (k2VarT.r(i4)) {
                this.D = k2VarT.c(i4);
            } else {
                this.D = null;
            }
            k2VarT.v();
            this.f368h = false;
        }

        public void h() {
            this.f362b = 0;
            this.f363c = 0;
            this.f364d = 0;
            this.f365e = 0;
            this.f366f = true;
            this.f367g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f352e = clsArr;
        f353f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f356c = context;
        Object[] objArr = {context};
        this.f354a = objArr;
        this.f355b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        str = null;
                        z3 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            androidx.core.view.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z2 = true;
                    }
                }
            } else if (!z3) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z3 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f357d == null) {
            this.f357d = a(this.f356c);
        }
        return this.f357d;
    }

    @Override // android.view.MenuInflater
    public void inflate(@LayoutRes int i2, Menu menu) {
        if (!(menu instanceof a_n)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f356c.getResources().getLayout(i2);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
