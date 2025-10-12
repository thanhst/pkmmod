package g;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Compatibility.java */
@RequiresApi(15)
/* loaded from: classes.dex */
public class a {
    @DoNotInline
    public static void a(@NonNull Resources resources, int i2, int i3, @NonNull TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        resources.getValueForDensity(i2, i3, typedValue, z2);
    }
}
