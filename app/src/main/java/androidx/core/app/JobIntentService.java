package androidx.core.app;

import android.annotation.NonNull;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.AuthenticationTokenClaims;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: l, reason: collision with root package name */
    static final Object f1353l = new Object();

    /* renamed from: m, reason: collision with root package name */
    static final HashMap<ComponentName, h> f1354m = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    b f1355e;

    /* renamed from: f, reason: collision with root package name */
    h f1356f;

    /* renamed from: g, reason: collision with root package name */
    a f1357g;

    /* renamed from: h, reason: collision with root package name */
    boolean f1358h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f1359i = false;

    /* renamed from: j, reason: collision with root package name */
    boolean f1360j = false;

    /* renamed from: k, reason: collision with root package name */
    final ArrayList<d> f1361k;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e eVarA = JobIntentService.this.a();
                if (eVarA == null) {
                    return null;
                }
                JobIntentService.this.e(eVarA.getIntent());
                eVarA.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.g();
        }
    }

    interface b {
        e a();

        IBinder b();
    }

    static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        private final Context f1363d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f1364e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f1365f;

        /* renamed from: g, reason: collision with root package name */
        boolean f1366g;

        /* renamed from: h, reason: collision with root package name */
        boolean f1367h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f1363d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f1364e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f1365f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                if (this.f1367h) {
                    if (this.f1366g) {
                        this.f1364e.acquire(60000L);
                    }
                    this.f1367h = false;
                    this.f1365f.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                if (!this.f1367h) {
                    this.f1367h = true;
                    this.f1365f.acquire(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
                    this.f1364e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f1366g = false;
            }
        }
    }

    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f1368a;

        /* renamed from: b, reason: collision with root package name */
        final int f1369b;

        d(Intent intent, int i2) {
            this.f1368a = intent;
            this.f1369b = i2;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f1369b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f1368a;
        }
    }

    interface e {
        void a();

        Intent getIntent();
    }

    @RequiresApi(26)
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f1371a;

        /* renamed from: b, reason: collision with root package name */
        final Object f1372b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f1373c;

        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f1374a;

            a(JobWorkItem jobWorkItem) {
                this.f1374a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f1372b) {
                    JobParameters jobParameters = f.this.f1373c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f1374a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f1374a.getIntent();
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f1372b = new Object();
            this.f1371a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public e a() {
            synchronized (this.f1372b) {
                JobParameters jobParameters = this.f1373c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f1371a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder b() {
            return getBinder();
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f1373c = jobParameters;
            this.f1371a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f1371a.b();
            synchronized (this.f1372b) {
                this.f1373c = null;
            }
            return zB;
        }
    }

    @RequiresApi(26)
    static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f1376d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f1377e;

        g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            a(i2);
            this.f1376d = new Object(i2, this.f1378a) { // from class: android.app.job.JobInfo.Builder
                static {
                    throw new NoClassDefFoundError();
                }

                public /* synthetic */ Builder(int i22, @NonNull ComponentName componentName2) {
                }

                public native /* synthetic */ JobInfo build();

                public native /* synthetic */ Builder setOverrideDeadline(long j2);
            }.setOverrideDeadline(0L).build();
            this.f1377e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f1378a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1379b;

        /* renamed from: c, reason: collision with root package name */
        int f1380c;

        h(ComponentName componentName) {
            this.f1378a = componentName;
        }

        void a(int i2) {
            if (!this.f1379b) {
                this.f1379b = true;
                this.f1380c = i2;
            } else {
                if (this.f1380c == i2) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f1380c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1361k = null;
        } else {
            this.f1361k = new ArrayList<>();
        }
    }

    static h d(Context context, ComponentName componentName, boolean z2, int i2) {
        h cVar;
        HashMap<ComponentName, h> map = f1354m;
        h hVar = map.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z2) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i2);
        }
        h hVar2 = cVar;
        map.put(componentName, hVar2);
        return hVar2;
    }

    e a() {
        b bVar = this.f1355e;
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.f1361k) {
            if (this.f1361k.size() <= 0) {
                return null;
            }
            return this.f1361k.remove(0);
        }
    }

    boolean b() {
        a aVar = this.f1357g;
        if (aVar != null) {
            aVar.cancel(this.f1358h);
        }
        this.f1359i = true;
        return f();
    }

    void c(boolean z2) {
        if (this.f1357g == null) {
            this.f1357g = new a();
            h hVar = this.f1356f;
            if (hVar != null && z2) {
                hVar.c();
            }
            this.f1357g.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(@androidx.annotation.NonNull Intent intent);

    public boolean f() {
        return true;
    }

    void g() {
        ArrayList<d> arrayList = this.f1361k;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1357g = null;
                ArrayList<d> arrayList2 = this.f1361k;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    c(false);
                } else if (!this.f1360j) {
                    this.f1356f.b();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(@androidx.annotation.NonNull Intent intent) {
        b bVar = this.f1355e;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1355e = new f(this);
            this.f1356f = null;
        } else {
            this.f1355e = null;
            this.f1356f = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f1361k;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1360j = true;
                this.f1356f.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.f1361k == null) {
            return 2;
        }
        this.f1356f.d();
        synchronized (this.f1361k) {
            ArrayList<d> arrayList = this.f1361k;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            c(true);
        }
        return 3;
    }
}
