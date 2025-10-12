package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CustomTabPrefetchHelper.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Landroidx/browser/customtabs/e;", "Landroid/content/ComponentName;", "name", "Landroidx/browser/customtabs/c;", "newClient", "Lkotlin/t;", "onCustomTabsServiceConnected", "componentName", "onServiceDisconnected", "<init>", "()V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CustomTabPrefetchHelper extends androidx.browser.customtabs.e {

    @Nullable
    private static androidx.browser.customtabs.c client;

    @Nullable
    private static androidx.browser.customtabs.f session;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ReentrantLock lock = new ReentrantLock();

    /* compiled from: CustomTabPrefetchHelper.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", "", "Lkotlin/t;", "prepareSession", "Landroid/net/Uri;", "url", "mayLaunchUrl", "Landroidx/browser/customtabs/f;", "getPreparedSessionOnce", "Landroidx/browser/customtabs/c;", "client", "Landroidx/browser/customtabs/c;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Landroidx/browser/customtabs/f;", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void prepareSession() {
            androidx.browser.customtabs.c cVar;
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null && (cVar = CustomTabPrefetchHelper.client) != null) {
                CustomTabPrefetchHelper.session = cVar.d(null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        @JvmStatic
        @Nullable
        public final androidx.browser.customtabs.f getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            androidx.browser.customtabs.f fVar = CustomTabPrefetchHelper.session;
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return fVar;
        }

        @JvmStatic
        public final void mayLaunchUrl(@NotNull Uri url) {
            s.e(url, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            androidx.browser.customtabs.f fVar = CustomTabPrefetchHelper.session;
            if (fVar != null) {
                fVar.f(url, null, null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }
    }

    @JvmStatic
    @Nullable
    public static final androidx.browser.customtabs.f getPreparedSessionOnce() {
        return INSTANCE.getPreparedSessionOnce();
    }

    @JvmStatic
    public static final void mayLaunchUrl(@NotNull Uri uri) {
        INSTANCE.mayLaunchUrl(uri);
    }

    @Override // androidx.browser.customtabs.e
    public void onCustomTabsServiceConnected(@NotNull ComponentName name, @NotNull androidx.browser.customtabs.c newClient) {
        s.e(name, "name");
        s.e(newClient, "newClient");
        newClient.f(0L);
        client = newClient;
        INSTANCE.prepareSession();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@NotNull ComponentName componentName) {
        s.e(componentName, "componentName");
    }
}
