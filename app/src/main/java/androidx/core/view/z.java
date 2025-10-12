package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class z {
    public static boolean a(@NonNull MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
