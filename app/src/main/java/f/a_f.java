package f;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.z1;
import androidx.collection.h;
import androidx.core.content.res.p;
import androidx.core.graphics.drawable.r;
import androidx.vectordrawable.graphics.drawable.j;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public class a_f extends f_f.g implements r {

    /* renamed from: x, reason: collision with root package name */
    private static final String f3227x = a_f.class.getSimpleName();

    /* renamed from: s, reason: collision with root package name */
    private c f3228s;

    /* renamed from: t, reason: collision with root package name */
    private g f3229t;

    /* renamed from: u, reason: collision with root package name */
    private int f3230u;

    /* renamed from: v, reason: collision with root package name */
    private int f3231v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3232w;

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        private final Animatable f3233a;

        b(Animatable animatable) {
            super();
            this.f3233a = animatable;
        }

        @Override // f.a.g
        public void c() {
            this.f3233a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f3233a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    static class c extends g.a {
        androidx.collection.d<Long> K;
        h<Integer> L;

        c(@Nullable c cVar, @NonNull a_f aFVar, @Nullable Resources resources) {
            super(cVar, aFVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new androidx.collection.d<>();
                this.L = new h<>();
            }
        }

        private static long D(int i2, int i3) {
            return i3 | (i2 << 32);
        }

        int B(@NonNull int[] iArr, @NonNull Drawable drawable, int i2) {
            int iZ = super.z(iArr, drawable);
            this.L.h(iZ, Integer.valueOf(i2));
            return iZ;
        }

        int C(int i2, int i3, @NonNull Drawable drawable, boolean z2) {
            int iA = super.a(drawable);
            long jD = D(i2, i3);
            long j2 = z2 ? 8589934592L : 0L;
            long j3 = iA;
            this.K.a(jD, Long.valueOf(j3 | j2));
            if (z2) {
                this.K.a(D(i3, i2), Long.valueOf(4294967296L | j3 | j2));
            }
            return iA;
        }

        int E(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.f(i2, 0).intValue();
        }

        int F(@NonNull int[] iArr) {
            int iA = super.A(iArr);
            return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
        }

        int G(int i2, int i3) {
            return (int) this.K.f(D(i2, i3), -1L).longValue();
        }

        boolean H(int i2, int i3) {
            return (this.K.f(D(i2, i3), -1L).longValue() & 4294967296L) != 0;
        }

        boolean I(int i2, int i3) {
            return (this.K.f(D(i2, i3), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // f.g.a, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new a_f(this, null);
        }

        @Override // f.g.a, f.b.d
        void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // f.g.a, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new a_f(this, resources);
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.c f3234a;

        d(androidx.vectordrawable.graphics.drawable.c cVar) {
            super();
            this.f3234a = cVar;
        }

        @Override // f.a.g
        public void c() {
            this.f3234a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f3234a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f3235a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3236b;

        e(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z2 ? numberOfFrames - 1 : 0;
            int i3 = z2 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z2);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            g.b.a(objectAnimatorOfInt, true);
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f3236b = z3;
            this.f3235a = objectAnimatorOfInt;
        }

        @Override // f.a.g
        public boolean a() {
            return this.f3236b;
        }

        @Override // f.a.g
        public void b() {
            this.f3235a.reverse();
        }

        @Override // f.a.g
        public void c() {
            this.f3235a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f3235a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f3237a;

        /* renamed from: b, reason: collision with root package name */
        private int f3238b;

        /* renamed from: c, reason: collision with root package name */
        private int f3239c;

        f(AnimationDrawable animationDrawable, boolean z2) {
            b(animationDrawable, z2);
        }

        int a() {
            return this.f3239c;
        }

        int b(AnimationDrawable animationDrawable, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f3238b = numberOfFrames;
            int[] iArr = this.f3237a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f3237a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f3237a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z2 ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f3239c = i2;
            return i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * this.f3239c) + 0.5f);
            int i3 = this.f3238b;
            int[] iArr = this.f3237a;
            int i4 = 0;
            while (i4 < i3) {
                int i5 = iArr[i4];
                if (i2 < i5) {
                    break;
                }
                i2 -= i5;
                i4++;
            }
            return (i4 / i3) + (i4 < i3 ? i2 / this.f3239c : 0.0f);
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a_f() {
        this(null, null);
    }

    @NonNull
    public static a_f m(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a_f aFVar = new a_f();
            aFVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aFVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    r(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = p.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableJ = resourceId2 > 0 ? z1.h().j(context, resourceId2) : null;
        typedArrayK.recycle();
        int[] iArrK = k(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("vector") ? j.c(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? g.f.a(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableJ != null) {
            return this.f3228s.B(iArrK, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = p.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableJ = resourceId3 > 0 ? z1.h().j(context, resourceId3) : null;
        boolean z2 = typedArrayK.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayK.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("animated-vector") ? androidx.vectordrawable.graphics.drawable.c.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? g.f.a(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f3228s.C(resourceId, resourceId2, drawableJ, z2);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    private boolean s(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iC;
        int iG;
        g bVar;
        g gVar = this.f3229t;
        if (gVar == null) {
            iC = c();
        } else {
            if (i2 == this.f3230u) {
                return true;
            }
            if (i2 == this.f3231v && gVar.a()) {
                gVar.b();
                this.f3230u = this.f3231v;
                this.f3231v = i2;
                return true;
            }
            iC = this.f3230u;
            gVar.d();
        }
        this.f3229t = null;
        this.f3231v = -1;
        this.f3230u = -1;
        c cVar = this.f3228s;
        int iE = cVar.E(iC);
        int iE2 = cVar.E(i2);
        if (iE2 == 0 || iE == 0 || (iG = cVar.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = cVar.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(iE, iE2), zI);
        } else {
            if (!(current instanceof androidx.vectordrawable.graphics.drawable.c)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((androidx.vectordrawable.graphics.drawable.c) current);
        }
        bVar.c();
        this.f3229t = bVar;
        this.f3231v = iC;
        this.f3230u = i2;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.f3228s;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f3257d |= g.f.b(typedArray);
        }
        cVar.x(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f3262i));
        cVar.t(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f3265l));
        cVar.u(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.v(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f3277x));
    }

    @Override // f.g, f.b
    void h(@NonNull b.d dVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f3228s = (c) dVar;
        }
    }

    @Override // f.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // f.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.jumpToCurrentState();
        g gVar = this.f3229t;
        if (gVar != null) {
            gVar.d();
            this.f3229t = null;
            g(this.f3230u);
            this.f3230u = -1;
            this.f3231v = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f.g
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.f3228s, this, null);
    }

    @Override // f.g, f.b, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f3232w && super.mutate() == this) {
            this.f3228s.r();
            this.f3232w = true;
        }
        return this;
    }

    public void n(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        TypedArray typedArrayK = p.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayK.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        t(typedArrayK);
        i(resources);
        typedArrayK.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    @Override // f.g, f.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        int iF = this.f3228s.F(iArr);
        boolean z2 = iF != c() && (s(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z2 | current.setState(iArr) : z2;
    }

    @Override // f.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean visible = super.setVisible(z2, z3);
        g gVar = this.f3229t;
        if (gVar != null && (visible || z3)) {
            if (z2) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    a_f(@Nullable c cVar, @Nullable Resources resources) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(null);
        this.f3230u = -1;
        this.f3231v = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
