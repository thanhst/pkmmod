package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultEmojiCompatConfig.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: DefaultEmojiCompatConfig.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final b f1919a;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public a(@Nullable b bVar) {
            this.f1919a = bVar == null ? e() : bVar;
        }

        @Nullable
        private EmojiCompat.c a(@NonNull Context context, @Nullable androidx.core.provider.e eVar) {
            if (eVar == null) {
                return null;
            }
            return new h(context, eVar);
        }

        @NonNull
        private List<List<byte[]>> b(@NonNull Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        @NonNull
        private androidx.core.provider.e d(@NonNull ProviderInfo providerInfo, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new androidx.core.provider.e(str, str2, "emojicompat-emoji-font", b(this.f1919a.b(packageManager, str2)));
        }

        @NonNull
        private static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new d() : new C0027c();
        }

        private boolean f(@Nullable ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        @Nullable
        private ProviderInfo g(@NonNull PackageManager packageManager) {
            Iterator<ResolveInfo> it = this.f1919a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo providerInfoA = this.f1919a.a(it.next());
                if (f(providerInfoA)) {
                    return providerInfoA;
                }
            }
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.c c(@NonNull Context context) {
            return a(context, h(context));
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @VisibleForTesting
        androidx.core.provider.e h(@NonNull Context context) {
            PackageManager packageManager = context.getPackageManager();
            androidx.core.util.h.g(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoG = g(packageManager);
            if (providerInfoG == null) {
                return null;
            }
            try {
                return d(providerInfoG, packageManager);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                return null;
            }
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class b {
        @Nullable
        public ProviderInfo a(@NonNull ResolveInfo resolveInfo) {
            throw null;
        }

        @NonNull
        public Signature[] b(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> c(@NonNull PackageManager packageManager, @NonNull Intent intent, int i2) {
            throw null;
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static class C0027c extends b {
        @Override // androidx.emoji2.text.c.b
        @Nullable
        public ProviderInfo a(@NonNull ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.c.b
        @NonNull
        public List<ResolveInfo> c(@NonNull PackageManager packageManager, @NonNull Intent intent, int i2) {
            return packageManager.queryIntentContentProviders(intent, i2);
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class d extends C0027c {
        @Override // androidx.emoji2.text.c.b
        @NonNull
        public Signature[] b(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    @Nullable
    public static h a(@NonNull Context context) {
        return (h) new a(null).c(context);
    }
}
