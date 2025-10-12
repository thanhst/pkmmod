package androidx.core.os;

import androidx.annotation.IntRange;
import java.util.Locale;

/* compiled from: LocaleListInterface.java */
/* loaded from: classes.dex */
interface i {
    String a();

    Object b();

    Locale get(int i2);

    boolean isEmpty();

    @IntRange(from = 0)
    int size();
}
