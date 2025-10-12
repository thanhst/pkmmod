package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ContentInfoCompat {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final f f1639a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final c f1640a;

        public a(@NonNull ClipData clipData, int i2) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f1640a = new b(clipData, i2);
            } else {
                this.f1640a = new d(clipData, i2);
            }
        }

        @NonNull
        public ContentInfoCompat a() {
            return this.f1640a.build();
        }

        @NonNull
        public a b(@Nullable Bundle bundle) {
            this.f1640a.setExtras(bundle);
            return this;
        }

        @NonNull
        public a c(int i2) {
            this.f1640a.setFlags(i2);
            return this;
        }

        @NonNull
        public a d(@Nullable Uri uri) {
            this.f1640a.a(uri);
            return this;
        }
    }

    @RequiresApi(31)
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ContentInfo.Builder f1641a;

        b(@NonNull ClipData clipData, int i2) {
            this.f1641a = new ContentInfo.Builder(clipData, i2);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void a(@Nullable Uri uri) {
            this.f1641a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new e(this.f1641a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setExtras(@Nullable Bundle bundle) {
            this.f1641a.setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setFlags(int i2) {
            this.f1641a.setFlags(i2);
        }
    }

    private interface c {
        void a(@Nullable Uri uri);

        @NonNull
        ContentInfoCompat build();

        void setExtras(@Nullable Bundle bundle);

        void setFlags(int i2);
    }

    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        ClipData f1642a;

        /* renamed from: b, reason: collision with root package name */
        int f1643b;

        /* renamed from: c, reason: collision with root package name */
        int f1644c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        Uri f1645d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        Bundle f1646e;

        d(@NonNull ClipData clipData, int i2) {
            this.f1642a = clipData;
            this.f1643b = i2;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void a(@Nullable Uri uri) {
            this.f1645d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new g(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setExtras(@Nullable Bundle bundle) {
            this.f1646e = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setFlags(int i2) {
            this.f1644c = i2;
        }
    }

    @RequiresApi(31)
    private static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ContentInfo f1647a;

        e(@NonNull ContentInfo contentInfo) {
            this.f1647a = (ContentInfo) androidx.core.util.h.f(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @NonNull
        public ClipData a() {
            return this.f1647a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @NonNull
        public ContentInfo b() {
            return this.f1647a;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int c() {
            return this.f1647a.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int getFlags() {
            return this.f1647a.getFlags();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.f1647a + "}";
        }
    }

    private interface f {
        @NonNull
        ClipData a();

        @Nullable
        ContentInfo b();

        int c();

        int getFlags();
    }

    private static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ClipData f1648a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1649b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1650c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final Uri f1651d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final Bundle f1652e;

        g(d dVar) {
            this.f1648a = (ClipData) androidx.core.util.h.f(dVar.f1642a);
            this.f1649b = androidx.core.util.h.b(dVar.f1643b, 0, 5, "source");
            this.f1650c = androidx.core.util.h.e(dVar.f1644c, 1);
            this.f1651d = dVar.f1645d;
            this.f1652e = dVar.f1646e;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @NonNull
        public ClipData a() {
            return this.f1648a;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @Nullable
        public ContentInfo b() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int c() {
            return this.f1649b;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int getFlags() {
            return this.f1650c;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f1648a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.e(this.f1649b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.a(this.f1650c));
            if (this.f1651d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f1651d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f1652e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    ContentInfoCompat(@NonNull f fVar) {
        this.f1639a = fVar;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String a(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String e(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    @NonNull
    @RequiresApi(31)
    public static ContentInfoCompat g(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new e(contentInfo));
    }

    @NonNull
    public ClipData b() {
        return this.f1639a.a();
    }

    public int c() {
        return this.f1639a.getFlags();
    }

    public int d() {
        return this.f1639a.c();
    }

    @NonNull
    @RequiresApi(31)
    public ContentInfo f() {
        ContentInfo contentInfoB = this.f1639a.b();
        Objects.requireNonNull(contentInfoB);
        return contentInfoB;
    }

    @NonNull
    public String toString() {
        return this.f1639a.toString();
    }
}
