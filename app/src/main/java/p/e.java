package p;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: InputContentInfoCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final c f4051a;

    /* compiled from: InputContentInfoCompat.java */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final Uri f4053a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final ClipDescription f4054b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final Uri f4055c;

        b(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f4053a = uri;
            this.f4054b = clipDescription;
            this.f4055c = uri2;
        }

        @Override // p.e.c
        @NonNull
        public ClipDescription a() {
            return this.f4054b;
        }

        @Override // p.e.c
        @Nullable
        public Object b() {
            return null;
        }

        @Override // p.e.c
        @NonNull
        public Uri c() {
            return this.f4053a;
        }

        @Override // p.e.c
        public void d() {
        }

        @Override // p.e.c
        @Nullable
        public Uri e() {
            return this.f4055c;
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    private interface c {
        @NonNull
        ClipDescription a();

        @Nullable
        Object b();

        @NonNull
        Uri c();

        void d();

        @Nullable
        Uri e();
    }

    public e(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f4051a = new a(uri, clipDescription, uri2);
        } else {
            this.f4051a = new b(uri, clipDescription, uri2);
        }
    }

    @Nullable
    public static e f(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new e(new a(obj));
        }
        return null;
    }

    @NonNull
    public Uri a() {
        return this.f4051a.c();
    }

    @NonNull
    public ClipDescription b() {
        return this.f4051a.a();
    }

    @Nullable
    public Uri c() {
        return this.f4051a.e();
    }

    public void d() {
        this.f4051a.d();
    }

    @Nullable
    public Object e() {
        return this.f4051a.b();
    }

    /* compiled from: InputContentInfoCompat.java */
    @RequiresApi(25)
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        final InputContentInfo f4052a;

        a(@NonNull Object obj) {
            this.f4052a = (InputContentInfo) obj;
        }

        @Override // p.e.c
        @NonNull
        public ClipDescription a() {
            return this.f4052a.getDescription();
        }

        @Override // p.e.c
        @NonNull
        public Object b() {
            return this.f4052a;
        }

        @Override // p.e.c
        @NonNull
        public Uri c() {
            return this.f4052a.getContentUri();
        }

        @Override // p.e.c
        public void d() {
            this.f4052a.requestPermission();
        }

        @Override // p.e.c
        @Nullable
        public Uri e() {
            return this.f4052a.getLinkUri();
        }

        a(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f4052a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private e(@NonNull c cVar) {
        this.f4051a = cVar;
    }
}
