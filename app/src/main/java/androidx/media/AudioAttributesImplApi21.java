package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributes f2503a;

    /* renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f2504b;

    @RequiresApi(21)
    static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        final AudioAttributes.Builder f2505a = new AudioAttributes.Builder();

        a() {
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(int i2) {
            this.f2505a.setLegacyStreamType(i2);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f2505a.build());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi21() {
        this.f2504b = -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        int i2 = this.f2504b;
        return i2 != -1 ? i2 : AudioAttributesCompat.b(false, b(), c());
    }

    public int b() {
        return this.f2503a.getFlags();
    }

    public int c() {
        return this.f2503a.getUsage();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f2503a.equals(((AudioAttributesImplApi21) obj).f2503a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2503a.hashCode();
    }

    @NonNull
    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2503a;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
        this.f2503a = audioAttributes;
        this.f2504b = i2;
    }
}
