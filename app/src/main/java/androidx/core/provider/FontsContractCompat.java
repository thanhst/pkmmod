package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class FontsContractCompat {

    public static class FontRequestCallback {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public void a(int i2) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f1572a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f1573b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public a(int i2, @Nullable b[] bVarArr) {
            this.f1572a = i2;
            this.f1573b = bVarArr;
        }

        static a a(int i2, @Nullable b[] bVarArr) {
            return new a(i2, bVarArr);
        }

        public b[] b() {
            return this.f1573b;
        }

        public int c() {
            return this.f1572a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f1574a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1575b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1576c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f1577d;

        /* renamed from: e, reason: collision with root package name */
        private final int f1578e;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public b(@NonNull Uri uri, @IntRange(from = 0) int i2, @IntRange(from = 1, to = 1000) int i3, boolean z2, int i4) {
            this.f1574a = (Uri) h.f(uri);
            this.f1575b = i2;
            this.f1576c = i3;
            this.f1577d = z2;
            this.f1578e = i4;
        }

        static b a(@NonNull Uri uri, @IntRange(from = 0) int i2, @IntRange(from = 1, to = 1000) int i3, boolean z2, int i4) {
            return new b(uri, i2, i3, z2, i4);
        }

        public int b() {
            return this.f1578e;
        }

        @IntRange(from = 0)
        public int c() {
            return this.f1575b;
        }

        @NonNull
        public Uri d() {
            return this.f1574a;
        }

        @IntRange(from = 1, to = 1000)
        public int e() {
            return this.f1576c;
        }

        public boolean f() {
            return this.f1577d;
        }
    }

    @Nullable
    public static Typeface a(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull b[] bVarArr) {
        return androidx.core.graphics.f.b(context, cancellationSignal, bVarArr, 0);
    }

    @NonNull
    public static a b(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull e eVar) throws PackageManager.NameNotFoundException {
        return d.e(context, eVar, cancellationSignal);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface c(@NonNull Context context, @NonNull e eVar, int i2, boolean z2, @IntRange(from = 0) int i3, @NonNull Handler handler, @NonNull FontRequestCallback fontRequestCallback) {
        androidx.core.provider.a aVar = new androidx.core.provider.a(fontRequestCallback, handler);
        return z2 ? f.e(context, eVar, aVar, i2, i3) : f.d(context, eVar, i2, null, aVar);
    }
}
