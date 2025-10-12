package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: MetadataRepo.java */
@AnyThread
@RequiresApi(19)
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final androidx.emoji2.text.flatbuffer.b f1964a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final char[] f1965b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final a f1966c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Typeface f1967d;

    /* compiled from: MetadataRepo.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<a> f1968a;

        /* renamed from: b, reason: collision with root package name */
        private EmojiMetadata f1969b;

        private a() {
            this(1);
        }

        a a(int i2) {
            SparseArray<a> sparseArray = this.f1968a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i2);
        }

        final EmojiMetadata b() {
            return this.f1969b;
        }

        void c(@NonNull EmojiMetadata emojiMetadata, int i2, int i3) {
            a aVarA = a(emojiMetadata.b(i2));
            if (aVarA == null) {
                aVarA = new a();
                this.f1968a.put(emojiMetadata.b(i2), aVarA);
            }
            if (i3 > i2) {
                aVarA.c(emojiMetadata, i2 + 1, i3);
            } else {
                aVarA.f1969b = emojiMetadata;
            }
        }

        a(int i2) {
            this.f1968a = new SparseArray<>(i2);
        }
    }

    private k(@NonNull Typeface typeface, @NonNull androidx.emoji2.text.flatbuffer.b bVar) {
        this.f1967d = typeface;
        this.f1964a = bVar;
        this.f1965b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(androidx.emoji2.text.flatbuffer.b bVar) {
        int iK = bVar.k();
        for (int i2 = 0; i2 < iK; i2++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i2);
            Character.toChars(emojiMetadata.f(), this.f1965b, i2 * 2);
            h(emojiMetadata);
        }
    }

    @NonNull
    public static k b(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            androidx.core.os.k.a("EmojiCompat.MetadataRepo.create");
            return new k(typeface, j.b(byteBuffer));
        } finally {
            androidx.core.os.k.b();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] c() {
        return this.f1965b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public androidx.emoji2.text.flatbuffer.b d() {
        return this.f1964a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    int e() {
        return this.f1964a.l();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    a f() {
        return this.f1966c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Typeface g() {
        return this.f1967d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    void h(@NonNull EmojiMetadata emojiMetadata) {
        androidx.core.util.h.g(emojiMetadata, "emoji metadata cannot be null");
        androidx.core.util.h.a(emojiMetadata.c() > 0, "invalid metadata codepoint length");
        this.f1966c.c(emojiMetadata, 0, emojiMetadata.c() - 1);
    }
}
