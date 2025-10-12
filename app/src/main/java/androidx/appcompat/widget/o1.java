package androidx.appcompat.widget;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;

/* compiled from: FitWindowsViewGroup.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface o1 {

    /* compiled from: FitWindowsViewGroup.java */
    public interface a {
        void a(Rect rect);
    }

    void setOnFitSystemWindowsListener(a aVar);
}
