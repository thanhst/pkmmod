package androidx.media;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f2506a;

    /* renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f2507b;

    /* renamed from: c, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f2508c;

    /* renamed from: d, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f2509d;

    static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        private int f2510a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f2511b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f2512c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f2513d = -1;

        a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private a b(int i2) {
            switch (i2) {
                case 0:
                    this.f2511b = 1;
                    break;
                case 1:
                    this.f2511b = 4;
                    break;
                case 2:
                    this.f2511b = 4;
                    break;
                case 3:
                    this.f2511b = 2;
                    break;
                case 4:
                    this.f2511b = 4;
                    break;
                case 5:
                    this.f2511b = 4;
                    break;
                case 6:
                    this.f2511b = 1;
                    this.f2512c |= 4;
                    break;
                case 7:
                    this.f2512c = 1 | this.f2512c;
                    this.f2511b = 4;
                    break;
                case 8:
                    this.f2511b = 4;
                    break;
                case 9:
                    this.f2511b = 4;
                    break;
                case 10:
                    this.f2511b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i2 + " for AudioAttributesCompat");
                    break;
            }
            this.f2510a = AudioAttributesImplBase.e(i2);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f2511b, this.f2512c, this.f2510a, this.f2513d);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(int i2) {
            if (i2 == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.f2513d = i2;
            return b(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplBase() {
        this.f2506a = 0;
        this.f2507b = 0;
        this.f2508c = 0;
        this.f2509d = -1;
    }

    static int e(int i2) {
        switch (i2) {
        }
        return 2;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        int i2 = this.f2509d;
        return i2 != -1 ? i2 : AudioAttributesCompat.b(false, this.f2508c, this.f2506a);
    }

    public int b() {
        return this.f2507b;
    }

    public int c() {
        int i2 = this.f2508c;
        int iA = a();
        if (iA == 6) {
            i2 |= 4;
        } else if (iA == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int d() {
        return this.f2506a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f2507b == audioAttributesImplBase.b() && this.f2508c == audioAttributesImplBase.c() && this.f2506a == audioAttributesImplBase.d() && this.f2509d == audioAttributesImplBase.f2509d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2507b), Integer.valueOf(this.f2508c), Integer.valueOf(this.f2506a), Integer.valueOf(this.f2509d)});
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2509d != -1) {
            sb.append(" stream=");
            sb.append(this.f2509d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.c(this.f2506a));
        sb.append(" content=");
        sb.append(this.f2507b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2508c).toUpperCase());
        return sb.toString();
    }

    AudioAttributesImplBase(int i2, int i3, int i4, int i5) {
        this.f2507b = i2;
        this.f2508c = i3;
        this.f2506a = i4;
        this.f2509d = i5;
    }
}
