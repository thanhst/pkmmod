package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: SlidingWindow.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r\u0012\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b&\u0010(J\u0018\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0005R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR$\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lkotlin/collections/o0;", "T", "Lkotlin/collections/b;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", "get", "(I)Ljava/lang/Object;", "", "g", "", "iterator", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "maxCapacity", "f", "element", "Lkotlin/t;", "e", "(Ljava/lang/Object;)V", "n", "h", "[Ljava/lang/Object;", "buffer", "I", "capacity", "startIndex", "<set-?>", "i", "a", "()I", "size", "filledSize", "<init>", "([Ljava/lang/Object;I)V", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class o0<T> extends b<T> implements RandomAccess {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object[] buffer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int capacity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int startIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int size;

    /* compiled from: SlidingWindow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"kotlin/collections/o0$a", "Lkotlin/collections/a;", "Lkotlin/t;", "a", "", "g", "I", "count", "h", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a extends kotlin.collections.a<T> {

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int count;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int index;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ o0<T> f3390i;

        a(o0<T> o0Var) {
            this.f3390i = o0Var;
            this.count = o0Var.size();
            this.index = ((o0) o0Var).startIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.a
        protected void a() {
            if (this.count == 0) {
                b();
                return;
            }
            c(((o0) this.f3390i).buffer[this.index]);
            this.index = (this.index + 1) % ((o0) this.f3390i).capacity;
            this.count--;
        }
    }

    public o0(@NotNull Object[] buffer, int i2) {
        kotlin.jvm.internal.s.e(buffer, "buffer");
        this.buffer = buffer;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        }
        if (i2 <= buffer.length) {
            this.capacity = buffer.length;
            this.size = i2;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: a, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public final void e(T element) {
        if (g()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final o0<T> f(int maxCapacity) {
        Object[] array;
        int i2 = this.capacity;
        int iC = s0.l.c(i2 + (i2 >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, iC);
            kotlin.jvm.internal.s.d(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iC]);
        }
        return new o0<>(array, size());
    }

    public final boolean g() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.b, java.util.List
    public T get(int index) {
        b.INSTANCE.a(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    public final void h(int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
        }
        if (!(i2 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
        }
        if (i2 > 0) {
            int i3 = this.startIndex;
            int i4 = (i3 + i2) % this.capacity;
            if (i3 > i4) {
                m.g(this.buffer, null, i3, this.capacity);
                m.g(this.buffer, null, 0, i4);
            } else {
                m.g(this.buffer, null, i3, i4);
            }
            this.startIndex = i4;
            this.size = size() - i2;
        }
    }

    @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.s.e(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.s.d(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.startIndex; i3 < size && i4 < this.capacity; i4++) {
            array[i3] = this.buffer[i4];
            i3++;
        }
        while (i3 < size) {
            array[i3] = this.buffer[i2];
            i3++;
            i2++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        kotlin.jvm.internal.s.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return array;
    }

    public o0(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
