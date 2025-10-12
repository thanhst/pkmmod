package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f711e;

    /* renamed from: f, reason: collision with root package name */
    private TypedValue f712f;

    /* renamed from: g, reason: collision with root package name */
    private TypedValue f713g;

    /* renamed from: h, reason: collision with root package name */
    private TypedValue f714h;

    /* renamed from: i, reason: collision with root package name */
    private TypedValue f715i;

    /* renamed from: j, reason: collision with root package name */
    private TypedValue f716j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f717k;

    /* renamed from: l, reason: collision with root package name */
    private a f718l;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void b(int i2, int i3, int i4, int i5) {
        this.f717k.set(i2, i3, i4, i5);
        if (ViewCompat.B(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f715i == null) {
            this.f715i = new TypedValue();
        }
        return this.f715i;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f716j == null) {
            this.f716j = new TypedValue();
        }
        return this.f716j;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f713g == null) {
            this.f713g = new TypedValue();
        }
        return this.f713g;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f714h == null) {
            this.f714h = new TypedValue();
        }
        return this.f714h;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f711e == null) {
            this.f711e = new TypedValue();
        }
        return this.f711e;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f712f == null) {
            this.f712f = new TypedValue();
        }
        return this.f712f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f718l;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f718l;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f718l = aVar;
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f717k = new Rect();
    }
}
