package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import y.b;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface AudioAttributesImpl extends b {

    public interface a {
        @NonNull
        a a(int i2);

        @NonNull
        AudioAttributesImpl build();
    }

    int a();
}
