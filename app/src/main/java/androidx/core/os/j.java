package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* compiled from: LocaleListPlatformWrapper.java */
@RequiresApi(24)
/* loaded from: classes.dex */
final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f1566a;

    j(Object obj) {
        this.f1566a = (LocaleList) obj;
    }

    @Override // androidx.core.os.i
    public String a() {
        return this.f1566a.toLanguageTags();
    }

    @Override // androidx.core.os.i
    public Object b() {
        return this.f1566a;
    }

    public boolean equals(Object obj) {
        return this.f1566a.equals(((i) obj).b());
    }

    @Override // androidx.core.os.i
    public Locale get(int i2) {
        return this.f1566a.get(i2);
    }

    public int hashCode() {
        return this.f1566a.hashCode();
    }

    @Override // androidx.core.os.i
    public boolean isEmpty() {
        return this.f1566a.isEmpty();
    }

    @Override // androidx.core.os.i
    public int size() {
        return this.f1566a.size();
    }

    public String toString() {
        return this.f1566a.toString();
    }
}
