package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class EmojiMetadata {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<androidx.emoji2.text.flatbuffer.a> f1914d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private final int f1915a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final k f1916b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f1917c = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    EmojiMetadata(@NonNull k kVar, @IntRange(from = 0) int i2) {
        this.f1916b = kVar;
        this.f1915a = i2;
    }

    private androidx.emoji2.text.flatbuffer.a g() {
        ThreadLocal<androidx.emoji2.text.flatbuffer.a> threadLocal = f1914d;
        androidx.emoji2.text.flatbuffer.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new androidx.emoji2.text.flatbuffer.a();
            threadLocal.set(aVar);
        }
        this.f1916b.d().j(aVar, this.f1915a);
        return aVar;
    }

    public void a(@NonNull Canvas canvas, float f2, float f3, @NonNull Paint paint) {
        Typeface typefaceG = this.f1916b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f1916b.c(), this.f1915a * 2, 2, f2, f3, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i2) {
        return g().h(i2);
    }

    public int c() {
        return g().i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f1917c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void k(boolean z2) {
        this.f1917c = z2 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i2 = 0; i2 < iC; i2++) {
            sb.append(Integer.toHexString(b(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
