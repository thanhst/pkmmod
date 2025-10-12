package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R$drawable;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourceManagerInternal.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class z1 {

    /* renamed from: i, reason: collision with root package name */
    private static z1 f1174i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, androidx.collection.h<ColorStateList>> f1176a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.collection.g<String, e> f1177b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.collection.h<String> f1178c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap<Context, androidx.collection.d<WeakReference<Drawable.ConstantState>>> f1179d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f1180e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1181f;

    /* renamed from: g, reason: collision with root package name */
    private f f1182g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f1173h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final c f1175j = new c(6);

    /* compiled from: ResourceManagerInternal.java */
    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.z1.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return f.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.z1.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    private static class c extends androidx.collection.e<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        private static int h(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i2, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(i2, mode)));
        }

        PorterDuffColorFilter j(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(h(i2, mode)), porterDuffColorFilter);
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.z1.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        g.f.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e2) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                }
            }
            return null;
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    private interface e {
        Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface f {
        boolean a(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);

        @Nullable
        PorterDuff.Mode b(int i2);

        @Nullable
        Drawable c(@NonNull z1 z1Var, @NonNull Context context, @DrawableRes int i2);

        @Nullable
        ColorStateList d(@NonNull Context context, @DrawableRes int i2);

        boolean e(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);
    }

    /* compiled from: ResourceManagerInternal.java */
    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.z1.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.j.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(@NonNull String str, @NonNull e eVar) {
        if (this.f1177b == null) {
            this.f1177b = new androidx.collection.g<>();
        }
        this.f1177b.put(str, eVar);
    }

    private synchronized boolean b(@NonNull Context context, long j2, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.d<WeakReference<Drawable.ConstantState>> dVar = this.f1179d.get(context);
        if (dVar == null) {
            dVar = new androidx.collection.d<>();
            this.f1179d.put(context, dVar);
        }
        dVar.h(j2, new WeakReference<>(constantState));
        return true;
    }

    private void c(@NonNull Context context, @DrawableRes int i2, @NonNull ColorStateList colorStateList) {
        if (this.f1176a == null) {
            this.f1176a = new WeakHashMap<>();
        }
        androidx.collection.h<ColorStateList> hVar = this.f1176a.get(context);
        if (hVar == null) {
            hVar = new androidx.collection.h<>();
            this.f1176a.put(context, hVar);
        }
        hVar.a(i2, colorStateList);
    }

    private void d(@NonNull Context context) {
        if (this.f1181f) {
            return;
        }
        this.f1181f = true;
        Drawable drawableJ = j(context, R$drawable.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f1181f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(@NonNull Context context, @DrawableRes int i2) throws Resources.NotFoundException {
        if (this.f1180e == null) {
            this.f1180e = new TypedValue();
        }
        TypedValue typedValue = this.f1180e;
        context.getResources().getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f1182g;
        Drawable drawableC = fVar == null ? null : fVar.c(this, context, i2);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableC);
        }
        return drawableC;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized z1 h() {
        if (f1174i == null) {
            z1 z1Var = new z1();
            f1174i = z1Var;
            p(z1Var);
        }
        return f1174i;
    }

    private synchronized Drawable i(@NonNull Context context, long j2) {
        androidx.collection.d<WeakReference<Drawable.ConstantState>> dVar = this.f1179d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceE = dVar.e(j2);
        if (weakReferenceE != null) {
            Drawable.ConstantState constantState = weakReferenceE.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.i(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        c cVar = f1175j;
        porterDuffColorFilterI = cVar.i(i2, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i2, mode);
            cVar.j(i2, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList n(@NonNull Context context, @DrawableRes int i2) {
        androidx.collection.h<ColorStateList> hVar;
        WeakHashMap<Context, androidx.collection.h<ColorStateList>> weakHashMap = this.f1176a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.e(i2);
    }

    private static void p(@NonNull z1 z1Var) {
        if (Build.VERSION.SDK_INT < 24) {
            z1Var.a("vector", new g());
            z1Var.a("animated-vector", new b());
            z1Var.a("animated-selector", new a());
            z1Var.a("drawable", new d());
        }
    }

    private static boolean q(@NonNull Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.j) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(@NonNull Context context, @DrawableRes int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        androidx.collection.g<String, e> gVar = this.f1177b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        androidx.collection.h<String> hVar = this.f1178c;
        if (hVar != null) {
            String strE = hVar.e(i2);
            if ("appcompat_skip_skip".equals(strE) || (strE != null && this.f1177b.get(strE) == null)) {
                return null;
            }
        } else {
            this.f1178c = new androidx.collection.h<>();
        }
        if (this.f1180e == null) {
            this.f1180e = new TypedValue();
        }
        TypedValue typedValue = this.f1180e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1178c.a(i2, name);
                e eVar = this.f1177b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableI == null) {
            this.f1178c.a(i2, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(@NonNull Context context, @DrawableRes int i2, boolean z2, @NonNull Drawable drawable) {
        ColorStateList colorStateListM = m(context, i2);
        if (colorStateListM == null) {
            f fVar = this.f1182g;
            if ((fVar == null || !fVar.e(context, i2, drawable)) && !x(context, i2, drawable) && z2) {
                return null;
            }
            return drawable;
        }
        if (l1.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable);
        androidx.core.graphics.drawable.a.n(drawableP, colorStateListM);
        PorterDuff.Mode modeO = o(i2);
        if (modeO == null) {
            return drawableP;
        }
        androidx.core.graphics.drawable.a.o(drawableP, modeO);
        return drawableP;
    }

    static void w(Drawable drawable, i2 i2Var, int[] iArr) {
        int[] state = drawable.getState();
        if (l1.a(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z2 = i2Var.f974d;
        if (z2 || i2Var.f973c) {
            drawable.setColorFilter(g(z2 ? i2Var.f971a : null, i2Var.f973c ? i2Var.f972b : f1173h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(@NonNull Context context, @DrawableRes int i2) {
        return k(context, i2, false);
    }

    synchronized Drawable k(@NonNull Context context, @DrawableRes int i2, boolean z2) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i2);
        if (drawableR == null) {
            drawableR = f(context, i2);
        }
        if (drawableR == null) {
            drawableR = ContextCompat.d(context, i2);
        }
        if (drawableR != null) {
            drawableR = v(context, i2, z2, drawableR);
        }
        if (drawableR != null) {
            l1.b(drawableR);
        }
        return drawableR;
    }

    synchronized ColorStateList m(@NonNull Context context, @DrawableRes int i2) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i2);
        if (colorStateListN == null) {
            f fVar = this.f1182g;
            colorStateListN = fVar == null ? null : fVar.d(context, i2);
            if (colorStateListN != null) {
                c(context, i2, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i2) {
        f fVar = this.f1182g;
        if (fVar == null) {
            return null;
        }
        return fVar.b(i2);
    }

    public synchronized void s(@NonNull Context context) {
        androidx.collection.d<WeakReference<Drawable.ConstantState>> dVar = this.f1179d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    synchronized Drawable t(@NonNull Context context, @NonNull u2 u2Var, @DrawableRes int i2) {
        Drawable drawableR = r(context, i2);
        if (drawableR == null) {
            drawableR = u2Var.a(i2);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i2, false, drawableR);
    }

    public synchronized void u(f fVar) {
        this.f1182g = fVar;
    }

    boolean x(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable) {
        f fVar = this.f1182g;
        return fVar != null && fVar.a(context, i2, drawable);
    }
}
