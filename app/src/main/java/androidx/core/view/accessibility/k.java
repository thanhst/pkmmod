package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: AccessibilityViewCommand.java */
/* loaded from: classes.dex */
public interface k {

    /* compiled from: AccessibilityViewCommand.java */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        Bundle f1745a;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@Nullable Bundle bundle) {
            this.f1745a = bundle;
        }
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class b extends a {
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class c extends a {
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class d extends a {
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class e extends a {
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class f extends a {
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class g extends a {
    }

    /* compiled from: AccessibilityViewCommand.java */
    public static final class h extends a {
    }

    boolean a(@NonNull View view, @Nullable a aVar);
}
