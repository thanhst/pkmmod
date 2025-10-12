package g;

import android.animation.ObjectAnimator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Compatibility.java */
@RequiresApi(18)
/* loaded from: classes.dex */
public class b {
    @DoNotInline
    public static void a(@NonNull ObjectAnimator objectAnimator, boolean z2) {
        objectAnimator.setAutoCancel(z2);
    }
}
