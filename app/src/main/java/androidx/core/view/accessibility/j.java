package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: AccessibilityRecordCompat.java */
/* loaded from: classes.dex */
public class j {

    /* compiled from: AccessibilityRecordCompat.java */
    @RequiresApi(15)
    static class a {
        @DoNotInline
        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        @DoNotInline
        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        @DoNotInline
        static void c(AccessibilityRecord accessibilityRecord, int i2) {
            accessibilityRecord.setMaxScrollX(i2);
        }

        @DoNotInline
        static void d(AccessibilityRecord accessibilityRecord, int i2) {
            accessibilityRecord.setMaxScrollY(i2);
        }
    }

    public static void a(@NonNull AccessibilityRecord accessibilityRecord, int i2) {
        a.c(accessibilityRecord, i2);
    }

    public static void b(@NonNull AccessibilityRecord accessibilityRecord, int i2) {
        a.d(accessibilityRecord, i2);
    }
}
