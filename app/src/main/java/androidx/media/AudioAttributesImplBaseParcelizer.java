package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2506a = versionedParcel.p(audioAttributesImplBase.f2506a, 1);
        audioAttributesImplBase.f2507b = versionedParcel.p(audioAttributesImplBase.f2507b, 2);
        audioAttributesImplBase.f2508c = versionedParcel.p(audioAttributesImplBase.f2508c, 3);
        audioAttributesImplBase.f2509d = versionedParcel.p(audioAttributesImplBase.f2509d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f2506a, 1);
        versionedParcel.F(audioAttributesImplBase.f2507b, 2);
        versionedParcel.F(audioAttributesImplBase.f2508c, 3);
        versionedParcel.F(audioAttributesImplBase.f2509d, 4);
    }
}
