package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: UIntArray.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0006\u0092\u0001\u00020\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lkotlin/n;", "", "Lkotlin/m;", "", "a", "([I)Ljava/util/Iterator;", "storage", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: classes.dex */
public final class n implements Collection<m>, q0.a {

    /* compiled from: UIntArray.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0016\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rø\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/n$a;", "", "Lkotlin/m;", "", "hasNext", "a", "()I", "", "e", "[I", "array", "", "f", "I", "index", "<init>", "([I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    private static final class a implements Iterator<m>, q0.a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final int[] array;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int index;

        public a(@NotNull int[] array) {
            kotlin.jvm.internal.s.e(array, "array");
            this.array = array;
        }

        public int a() {
            int i2 = this.index;
            int[] iArr = this.array;
            if (i2 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i2 + 1;
            return m.b(iArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ m next() {
            return m.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<m> a(int[] iArr) {
        return new a(iArr);
    }
}
