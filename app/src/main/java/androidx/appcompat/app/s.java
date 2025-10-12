package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class s {

    /* renamed from: d, reason: collision with root package name */
    private static s f290d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f291a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f292b;

    /* renamed from: c, reason: collision with root package name */
    private final a f293c = new a();

    /* compiled from: TwilightManager.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f294a;

        /* renamed from: b, reason: collision with root package name */
        long f295b;

        a() {
        }
    }

    @VisibleForTesting
    s(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f291a = context;
        this.f292b = locationManager;
    }

    static s a(@NonNull Context context) {
        if (f290d == null) {
            Context applicationContext = context.getApplicationContext();
            f290d = new s(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f290d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationC = PermissionChecker.b(this.f291a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c(DataUtil.ORDER_COLUMN.ORDER_NET_WORK) : null;
        Location locationC2 = PermissionChecker.b(this.f291a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location c(String str) {
        try {
            if (this.f292b.isProviderEnabled(str)) {
                return this.f292b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f293c.f295b > System.currentTimeMillis();
    }

    private void f(@NonNull Location location) {
        long j2;
        a aVar = this.f293c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        r rVarB = r.b();
        rVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        rVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z2 = rVarB.f289c == 1;
        long j3 = rVarB.f288b;
        long j4 = rVarB.f287a;
        rVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j5 = rVarB.f288b;
        if (j3 == -1 || j4 == -1) {
            j2 = 43200000 + jCurrentTimeMillis;
        } else {
            j2 = (jCurrentTimeMillis > j4 ? j5 + 0 : jCurrentTimeMillis > j3 ? j4 + 0 : j3 + 0) + 60000;
        }
        aVar.f294a = z2;
        aVar.f295b = j2;
    }

    boolean d() {
        a aVar = this.f293c;
        if (e()) {
            return aVar.f294a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f294a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
