package u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f4133f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static a f4134g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f4135a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f4136b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f4137c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f4138d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f4139e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: u.a$a, reason: collision with other inner class name */
    class HandlerC0072a extends Handler {
        HandlerC0072a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f4141a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<c> f4142b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f4141a = intent;
            this.f4142b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f4143a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f4144b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4145c;

        /* renamed from: d, reason: collision with root package name */
        boolean f4146d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f4143a = intentFilter;
            this.f4144b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f4144b);
            sb.append(" filter=");
            sb.append(this.f4143a);
            if (this.f4146d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f4135a = context;
        this.f4139e = new HandlerC0072a(context.getMainLooper());
    }

    @NonNull
    public static a b(@NonNull Context context) {
        a aVar;
        synchronized (f4133f) {
            if (f4134g == null) {
                f4134g = new a(context.getApplicationContext());
            }
            aVar = f4134g;
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f4136b) {
                size = this.f4138d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f4138d.toArray(bVarArr);
                this.f4138d.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = bVarArr[i2];
                int size2 = bVar.f4142b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    c cVar = bVar.f4142b.get(i3);
                    if (!cVar.f4146d) {
                        cVar.f4144b.onReceive(this.f4135a, bVar.f4141a);
                    }
                }
            }
        }
    }

    public void c(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f4136b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f4136b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f4136b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<c> arrayList2 = this.f4137c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f4137c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(@NonNull Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f4136b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4135a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z2 = (intent.getFlags() & 8) != 0;
            if (z2) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f4137c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z2) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    c cVar = arrayList3.get(i3);
                    if (z2) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f4143a);
                    }
                    if (cVar.f4145c) {
                        if (z2) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = cVar.f4143a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z2) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f4145c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z2) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : ShareConstants.MEDIA_TYPE : ShareConstants.WEB_DIALOG_PARAM_DATA : NativeProtocol.WEB_DIALOG_ACTION : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((c) arrayList5.get(i4)).f4145c = false;
                    }
                    this.f4138d.add(new b(intent, arrayList5));
                    if (!this.f4139e.hasMessages(1)) {
                        this.f4139e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.f4136b) {
            ArrayList<c> arrayListRemove = this.f4136b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                c cVar = arrayListRemove.get(size);
                cVar.f4146d = true;
                for (int i2 = 0; i2 < cVar.f4143a.countActions(); i2++) {
                    String action = cVar.f4143a.getAction(i2);
                    ArrayList<c> arrayList = this.f4137c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f4144b == broadcastReceiver) {
                                cVar2.f4146d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f4137c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
