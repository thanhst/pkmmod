package f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.lang.reflect.InvocationTargetException;

/* compiled from: StateListDrawableCompat.java */
/* loaded from: classes.dex */
public class g_f extends b_f {

    /* renamed from: q, reason: collision with root package name */
    private a f3281q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3282r;

    /* compiled from: StateListDrawableCompat.java */
    static class a extends b_f.d {
        int[][] J;

        a(a aVar, g_f gFVar, Resources resources) {
            super(aVar, gFVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int iH = h();
            for (int i2 = 0; i2 < iH; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new g_f(this, null);
        }

        @Override // f.b.d
        public void o(int i2, int i3) {
            super.o(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }

        @Override // f.b.d
        void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.J = iArr2;
        }

        int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.J[iA] = iArr;
            return iA;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new g_f(this, resources);
        }
    }

    g_f(a aVar, Resources resources) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // f.b, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // f.b
    void h(@NonNull b_f.d dVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f3281q = (a) dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.f3281q, this, null);
    }

    int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    @Override // f.b, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f3282r && super.mutate() == this) {
            this.f3281q.r();
            this.f3282r = true;
        }
        return this;
    }

    @Override // f.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iA = this.f3281q.A(iArr);
        if (iA < 0) {
            iA = this.f3281q.A(StateSet.WILD_CARD);
        }
        return g(iA) || zOnStateChange;
    }

    g_f(@Nullable a aVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (aVar != null) {
            h(aVar);
        }
    }
}
