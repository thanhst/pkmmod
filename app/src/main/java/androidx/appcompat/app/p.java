package androidx.appcompat.app;

import androidx.annotation.RequiresApi;
import java.util.LinkedHashSet;
import java.util.Locale;

/* compiled from: LocaleOverlayHelper.java */
@RequiresApi(24)
/* loaded from: classes.dex */
final class p {
    private static androidx.core.os.g a(androidx.core.os.g gVar, androidx.core.os.g gVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (i2 < gVar.g() + gVar2.g()) {
            Locale localeD = i2 < gVar.g() ? gVar.d(i2) : gVar2.d(i2 - gVar.g());
            if (localeD != null) {
                linkedHashSet.add(localeD);
            }
            i2++;
        }
        return androidx.core.os.g.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static androidx.core.os.g b(androidx.core.os.g gVar, androidx.core.os.g gVar2) {
        return (gVar == null || gVar.f()) ? androidx.core.os.g.e() : a(gVar, gVar2);
    }
}
