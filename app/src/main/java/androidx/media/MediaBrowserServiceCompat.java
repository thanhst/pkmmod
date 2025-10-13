package androidx.media;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import v.a_v;
import v.b_v;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: l, reason: collision with root package name */
    static final boolean f2514l = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: e, reason: collision with root package name */
    private g f2515e;

    /* renamed from: i, reason: collision with root package name */
    f f2519i;

    /* renamed from: k, reason: collision with root package name */
    MediaSessionCompat.Token f2521k;

    /* renamed from: f, reason: collision with root package name */
    final f f2516f = new f("android.media.session.MediaController", -1, -1, null, null);

    /* renamed from: g, reason: collision with root package name */
    final ArrayList<f> f2517g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    final androidx.collection.a<IBinder, f> f2518h = new androidx.collection.a<>();

    /* renamed from: j, reason: collision with root package name */
    final r f2520j = new r();

    class a extends m<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f2522f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2523g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Bundle f2524h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f2525i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f2522f = fVar;
            this.f2523g = str;
            this.f2524h = bundle;
            this.f2525i = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f2518h.get(this.f2522f.f2540f.asBinder()) != this.f2522f) {
                if (MediaBrowserServiceCompat.f2514l) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f2522f.f2535a + " id=" + this.f2523g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f2524h);
            }
            try {
                this.f2522f.f2540f.c(this.f2523g, list, this.f2524h, this.f2525i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f2523g + " package=" + this.f2522f.f2535a);
            }
        }
    }

    class b extends m<MediaBrowserCompat.MediaItem> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f2527f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f2527f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f2527f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f2527f.send(0, bundle);
        }
    }

    class c extends m<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f2529f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f2529f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
            if ((a() & 4) != 0 || list == null) {
                this.f2529f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f2529f.send(0, bundle);
        }
    }

    class d extends m<Bundle> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f2531f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f2531f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        void c(@Nullable Bundle bundle) {
            this.f2531f.send(-1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable Bundle bundle) {
            this.f2531f.send(0, bundle);
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f2533a;

        /* renamed from: b, reason: collision with root package name */
        private final Bundle f2534b;

        public e(@NonNull String str, @Nullable Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            }
            this.f2533a = str;
            this.f2534b = bundle;
        }

        public Bundle c() {
            return this.f2534b;
        }

        public String d() {
            return this.f2533a;
        }
    }

    private class f implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f2535a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2536b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2537c;

        /* renamed from: d, reason: collision with root package name */
        public final b_v f2538d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f2539e;

        /* renamed from: f, reason: collision with root package name */
        public final p f2540f;

        /* renamed from: g, reason: collision with root package name */
        public final HashMap<String, List<androidx.core.util.d<IBinder, Bundle>>> f2541g = new HashMap<>();

        /* renamed from: h, reason: collision with root package name */
        public e f2542h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.f2518h.remove(fVar.f2540f.asBinder());
            }
        }

        f(String str, int i2, int i3, Bundle bundle, p pVar) {
            this.f2535a = str;
            this.f2536b = i2;
            this.f2537c = i3;
            this.f2538d = new b_v(str, i2, i3);
            this.f2539e = bundle;
            this.f2540f = pVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f2520j.post(new a());
        }
    }

    interface g {
        void a();

        IBinder b(Intent intent);
    }

    @RequiresApi(21)
    class h implements g {

        /* renamed from: a, reason: collision with root package name */
        final List<Bundle> f2545a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        MediaBrowserService f2546b;

        /* renamed from: c, reason: collision with root package name */
        Messenger f2547c;

        class a extends m<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n f2549f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, n nVar) {
                super(obj);
                this.f2549f = nVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.m
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList(list.size());
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f2549f.b(arrayList);
            }
        }

        @RequiresApi(21)
        class b extends MediaBrowserService {
            b(Context context) {
                attachBaseContext(context);
            }

            @SuppressLint({"SyntheticAccessor"})
            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                e eVarC = h.this.c(str, i2, bundle == null ? null : new Bundle(bundle));
                if (eVarC == null) {
                    return null;
                }
                return new Object(eVarC.f2533a, eVarC.f2534b) { // from class: android.service.media.MediaBrowserService.BrowserRoot
                    static {
                        throw new NoClassDefFoundError();
                    }

                    public /* synthetic */ BrowserRoot(@android.annotation.NonNull String str2, @android.annotation.Nullable Bundle bundle2) {
                    }
                };
            }

            public void onLoadChildren(String str, MediaBrowserService.Result result) {
                h.this.d(str, new n<>(result));
            }
        }

        h() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f2546b = bVar;
            bVar.onCreate();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder b(Intent intent) {
            return this.f2546b.onBind(intent);
        }

        public e c(String str, int i2, Bundle bundle) {
            Bundle bundleC;
            int i3;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundleC = null;
                i3 = -1;
            } else {
                bundle.remove("extra_client_version");
                this.f2547c = new Messenger(MediaBrowserServiceCompat.this.f2520j);
                bundleC = new Bundle();
                bundleC.putInt("extra_service_version", 2);
                androidx.core.app.q.b(bundleC, "extra_messenger", this.f2547c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f2521k;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    androidx.core.app.q.b(bundleC, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.f2545a.add(bundleC);
                }
                int i4 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
                i3 = i4;
            }
            f fVar = MediaBrowserServiceCompat.this.new f(str, i3, i2, bundle, null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f2519i = fVar;
            e eVarE = mediaBrowserServiceCompat.e(str, i2, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.f2519i = null;
            if (eVarE == null) {
                return null;
            }
            if (this.f2547c != null) {
                mediaBrowserServiceCompat2.f2517g.add(fVar);
            }
            if (bundleC == null) {
                bundleC = eVarE.c();
            } else if (eVarE.c() != null) {
                bundleC.putAll(eVarE.c());
            }
            return new e(eVarE.d(), bundleC);
        }

        public void d(String str, n<List<Parcel>> nVar) {
            a aVar = new a(str, nVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f2519i = mediaBrowserServiceCompat.f2516f;
            mediaBrowserServiceCompat.f(str, aVar);
            MediaBrowserServiceCompat.this.f2519i = null;
        }
    }

    @RequiresApi(23)
    class i extends h {

        class a extends m<MediaBrowserCompat.MediaItem> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n f2553f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, n nVar) {
                super(obj);
                this.f2553f = nVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.m
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f2553f.b(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.f2553f.b(parcelObtain);
            }
        }

        class b extends h.b {
            b(Context context) {
                super(context);
            }

            public void onLoadItem(String str, MediaBrowserService.Result result) {
                i.this.e(str, new n<>(result));
            }
        }

        i() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f2546b = bVar;
            bVar.onCreate();
        }

        public void e(String str, n<Parcel> nVar) {
            a aVar = new a(str, nVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f2519i = mediaBrowserServiceCompat.f2516f;
            mediaBrowserServiceCompat.h(str, aVar);
            MediaBrowserServiceCompat.this.f2519i = null;
        }
    }

    @RequiresApi(26)
    class j extends i {

        class a extends m<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n f2557f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f2558g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, n nVar, Bundle bundle) {
                super(obj);
                this.f2557f = nVar;
                this.f2558g = bundle;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.m
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                if (list == null) {
                    this.f2557f.b(null);
                    return;
                }
                if ((a() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, this.f2558g);
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                    Parcel parcelObtain = Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    arrayList.add(parcelObtain);
                }
                this.f2557f.b(arrayList);
            }
        }

        class b extends i.b {
            b(Context context) {
                super(context);
            }

            public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                j jVar = j.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f2519i = mediaBrowserServiceCompat.f2516f;
                jVar.f(str, new n<>(result), bundle);
                MediaBrowserServiceCompat.this.f2519i = null;
            }
        }

        j() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.i, androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f2546b = bVar;
            bVar.onCreate();
        }

        public void f(String str, n<List<Parcel>> nVar, Bundle bundle) {
            a aVar = new a(str, nVar, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f2519i = mediaBrowserServiceCompat.f2516f;
            mediaBrowserServiceCompat.g(str, aVar, bundle);
            MediaBrowserServiceCompat.this.f2519i = null;
        }
    }

    @RequiresApi(28)
    class k extends j {
        k() {
            super();
        }
    }

    class l implements g {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f2562a;

        l() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            this.f2562a = new Messenger(MediaBrowserServiceCompat.this.f2520j);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder b(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.f2562a.getBinder();
            }
            return null;
        }
    }

    public static class m<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f2564a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f2565b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f2566c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2567d;

        /* renamed from: e, reason: collision with root package name */
        private int f2568e;

        m(Object obj) {
            this.f2564a = obj;
        }

        int a() {
            return this.f2568e;
        }

        boolean b() {
            return this.f2565b || this.f2566c || this.f2567d;
        }

        void c(@Nullable Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f2564a);
        }

        void d(@Nullable T t2) {
            throw null;
        }

        public void e(@Nullable Bundle bundle) {
            if (!this.f2566c && !this.f2567d) {
                this.f2567d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f2564a);
            }
        }

        public void f(@Nullable T t2) {
            if (!this.f2566c && !this.f2567d) {
                this.f2566c = true;
                d(t2);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f2564a);
            }
        }

        void g(int i2) {
            this.f2568e = i2;
        }
    }

    @RequiresApi(21)
    static class n<T> {

        /* renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f2569a;

        n(MediaBrowserService.Result result) {
            this.f2569a = result;
        }

        List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(T t2) {
            if (t2 instanceof List) {
                this.f2569a.sendResult(a((List) t2));
                return;
            }
            if (!(t2 instanceof Parcel)) {
                this.f2569a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) t2;
            parcel.setDataPosition(0);
            this.f2569a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    private class o {

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2571e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2572f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f2573g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f2574h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Bundle f2575i;

            a(p pVar, String str, int i2, int i3, Bundle bundle) {
                this.f2571e = pVar;
                this.f2572f = str;
                this.f2573g = i2;
                this.f2574h = i3;
                this.f2575i = bundle;
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                IBinder iBinderAsBinder = this.f2571e.asBinder();
                MediaBrowserServiceCompat.this.f2518h.remove(iBinderAsBinder);
                f fVar = MediaBrowserServiceCompat.this.new f(this.f2572f, this.f2573g, this.f2574h, this.f2575i, this.f2571e);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f2519i = fVar;
                e eVarE = mediaBrowserServiceCompat.e(this.f2572f, this.f2574h, this.f2575i);
                fVar.f2542h = eVarE;
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.f2519i = null;
                if (eVarE != null) {
                    try {
                        mediaBrowserServiceCompat2.f2518h.put(iBinderAsBinder, fVar);
                        iBinderAsBinder.linkToDeath(fVar, 0);
                        if (MediaBrowserServiceCompat.this.f2521k != null) {
                            this.f2571e.b(fVar.f2542h.d(), MediaBrowserServiceCompat.this.f2521k, fVar.f2542h.c());
                            return;
                        }
                        return;
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.f2572f);
                        MediaBrowserServiceCompat.this.f2518h.remove(iBinderAsBinder);
                        return;
                    }
                }
                Log.i("MBServiceCompat", "No root for client " + this.f2572f + " from service " + getClass().getName());
                try {
                    this.f2571e.a();
                } catch (RemoteException unused2) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f2572f);
                }
            }
        }

        class b implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2577e;

            b(p pVar) {
                this.f2577e = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVarRemove = MediaBrowserServiceCompat.this.f2518h.remove(this.f2577e.asBinder());
                if (fVarRemove != null) {
                    fVarRemove.f2540f.asBinder().unlinkToDeath(fVarRemove, 0);
                }
            }
        }

        class c implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2579e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2580f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ IBinder f2581g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Bundle f2582h;

            c(p pVar, String str, IBinder iBinder, Bundle bundle) {
                this.f2579e = pVar;
                this.f2580f = str;
                this.f2581g = iBinder;
                this.f2582h = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f2518h.get(this.f2579e.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.a(this.f2580f, fVar, this.f2581g, this.f2582h);
                    return;
                }
                Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f2580f);
            }
        }

        class d implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2584e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2585f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ IBinder f2586g;

            d(p pVar, String str, IBinder iBinder) {
                this.f2584e = pVar;
                this.f2585f = str;
                this.f2586g = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f2518h.get(this.f2584e.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f2585f);
                    return;
                }
                if (MediaBrowserServiceCompat.this.p(this.f2585f, fVar, this.f2586g)) {
                    return;
                }
                Log.w("MBServiceCompat", "removeSubscription called for " + this.f2585f + " which is not subscribed");
            }
        }

        class e implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2588e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2589f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f2590g;

            e(p pVar, String str, ResultReceiver resultReceiver) {
                this.f2588e = pVar;
                this.f2589f = str;
                this.f2590g = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f2518h.get(this.f2588e.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.n(this.f2589f, fVar, this.f2590g);
                    return;
                }
                Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f2589f);
            }
        }

        class f implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2592e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f2593f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f2594g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f2595h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Bundle f2596i;

            f(p pVar, int i2, String str, int i3, Bundle bundle) {
                this.f2592e = pVar;
                this.f2593f = i2;
                this.f2594g = str;
                this.f2595h = i3;
                this.f2596i = bundle;
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                f fVar;
                IBinder iBinderAsBinder = this.f2592e.asBinder();
                MediaBrowserServiceCompat.this.f2518h.remove(iBinderAsBinder);
                Iterator<f> it = MediaBrowserServiceCompat.this.f2517g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    if (next.f2537c == this.f2593f) {
                        fVar = (TextUtils.isEmpty(this.f2594g) || this.f2595h <= 0) ? MediaBrowserServiceCompat.this.new f(next.f2535a, next.f2536b, next.f2537c, this.f2596i, this.f2592e) : null;
                        it.remove();
                    }
                }
                if (fVar == null) {
                    fVar = MediaBrowserServiceCompat.this.new f(this.f2594g, this.f2595h, this.f2593f, this.f2596i, this.f2592e);
                }
                MediaBrowserServiceCompat.this.f2518h.put(iBinderAsBinder, fVar);
                try {
                    iBinderAsBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        class g implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2598e;

            g(p pVar) {
                this.f2598e = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f2598e.asBinder();
                f fVarRemove = MediaBrowserServiceCompat.this.f2518h.remove(iBinderAsBinder);
                if (fVarRemove != null) {
                    iBinderAsBinder.unlinkToDeath(fVarRemove, 0);
                }
            }
        }

        class h implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2600e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2601f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f2602g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f2603h;

            h(p pVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f2600e = pVar;
                this.f2601f = str;
                this.f2602g = bundle;
                this.f2603h = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f2518h.get(this.f2600e.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.o(this.f2601f, this.f2602g, fVar, this.f2603h);
                    return;
                }
                Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f2601f);
            }
        }

        class i implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f2605e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2606f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f2607g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f2608h;

            i(p pVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f2605e = pVar;
                this.f2606f = str;
                this.f2607g = bundle;
                this.f2608h = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f2518h.get(this.f2605e.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.l(this.f2606f, this.f2607g, fVar, this.f2608h);
                    return;
                }
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f2606f + ", extras=" + this.f2607g);
            }
        }

        o() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, p pVar) {
            MediaBrowserServiceCompat.this.f2520j.a(new c(pVar, str, iBinder, bundle));
        }

        public void b(String str, int i2, int i3, Bundle bundle, p pVar) {
            if (MediaBrowserServiceCompat.this.c(str, i3)) {
                MediaBrowserServiceCompat.this.f2520j.a(new a(pVar, str, i2, i3, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + str);
        }

        public void c(p pVar) {
            MediaBrowserServiceCompat.this.f2520j.a(new b(pVar));
        }

        public void d(String str, ResultReceiver resultReceiver, p pVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2520j.a(new e(pVar, str, resultReceiver));
        }

        public void e(p pVar, String str, int i2, int i3, Bundle bundle) {
            MediaBrowserServiceCompat.this.f2520j.a(new f(pVar, i3, str, i2, bundle));
        }

        public void f(String str, IBinder iBinder, p pVar) {
            MediaBrowserServiceCompat.this.f2520j.a(new d(pVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, p pVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2520j.a(new h(pVar, str, bundle, resultReceiver));
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, p pVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f2520j.a(new i(pVar, str, bundle, resultReceiver));
        }

        public void i(p pVar) {
            MediaBrowserServiceCompat.this.f2520j.a(new g(pVar));
        }
    }

    private interface p {
        void a() throws RemoteException;

        IBinder asBinder();

        void b(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void c(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    private static class q implements p {

        /* renamed from: a, reason: collision with root package name */
        final Messenger f2610a;

        q(Messenger messenger) {
            this.f2610a = messenger;
        }

        private void d(int i2, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f2610a.send(messageObtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.p
        public void a() throws RemoteException {
            d(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.p
        public IBinder asBinder() {
            return this.f2610a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.p
        public void b(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            d(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.p
        public void c(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }
    }

    private final class r extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final o f2611a;

        r() {
            this.f2611a = MediaBrowserServiceCompat.this.new o();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f2611a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new q(message.replyTo));
                    break;
                case 2:
                    this.f2611a.c(new q(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f2611a.a(data.getString("data_media_item_id"), androidx.core.app.q.a(data, "data_callback_token"), bundle2, new q(message.replyTo));
                    break;
                case 4:
                    this.f2611a.f(data.getString("data_media_item_id"), androidx.core.app.q.a(data, "data_callback_token"), new q(message.replyTo));
                    break;
                case 5:
                    this.f2611a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new q(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.f2611a.e(new q(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    break;
                case 7:
                    this.f2611a.i(new q(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f2611a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new q(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f2611a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new q(message.replyTo));
                    break;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j2) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j2);
        }
    }

    void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.d<IBinder, Bundle>> arrayList = fVar.f2541g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (androidx.core.util.d<IBinder, Bundle> dVar : arrayList) {
            if (iBinder == dVar.f1634a && a_v.a(bundle, dVar.f1635b)) {
                return;
            }
        }
        arrayList.add(new androidx.core.util.d<>(iBinder, bundle));
        fVar.f2541g.put(str, arrayList);
        m(str, fVar, bundle, null);
        this.f2519i = fVar;
        j(str, bundle);
        this.f2519i = null;
    }

    List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int size = i4 + i3;
        if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
            return Collections.emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i4, size);
    }

    boolean c(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(@NonNull String str, Bundle bundle, @NonNull m<Bundle> mVar) {
        mVar.e(null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Nullable
    public abstract e e(@NonNull String str, int i2, @Nullable Bundle bundle);

    public abstract void f(@NonNull String str, @NonNull m<List<MediaBrowserCompat.MediaItem>> mVar);

    public void g(@NonNull String str, @NonNull m<List<MediaBrowserCompat.MediaItem>> mVar, @NonNull Bundle bundle) {
        mVar.g(1);
        f(str, mVar);
    }

    public void h(String str, @NonNull m<MediaBrowserCompat.MediaItem> mVar) {
        mVar.g(2);
        mVar.f(null);
    }

    public void i(@NonNull String str, Bundle bundle, @NonNull m<List<MediaBrowserCompat.MediaItem>> mVar) {
        mVar.g(4);
        mVar.f(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void j(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void k(String str) {
    }

    void l(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f2519i = fVar;
        d(str, bundle, dVar);
        this.f2519i = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f2519i = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.f2519i = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f2535a + " id=" + str);
    }

    void n(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f2519i = fVar;
        h(str, bVar);
        this.f2519i = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void o(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f2519i = fVar;
        i(str, bundle, cVar);
        this.f2519i = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2515e.b(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f2515e = new k();
        } else if (i2 >= 26) {
            this.f2515e = new j();
        } else if (i2 >= 23) {
            this.f2515e = new i();
        } else if (i2 >= 21) {
            this.f2515e = new h();
        } else {
            this.f2515e = new l();
        }
        this.f2515e.a();
    }

    boolean p(String str, f fVar, IBinder iBinder) {
        boolean z2 = false;
        try {
            if (iBinder == null) {
                return fVar.f2541g.remove(str) != null;
            }
            List<androidx.core.util.d<IBinder, Bundle>> list = fVar.f2541g.get(str);
            if (list != null) {
                Iterator<androidx.core.util.d<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().f1634a) {
                        it.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    fVar.f2541g.remove(str);
                }
            }
            return z2;
        } finally {
            this.f2519i = fVar;
            k(str);
            this.f2519i = null;
        }
    }
}
