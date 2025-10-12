package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.t;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import s0.l;

/* compiled from: ConcurrentWeakMap.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003#\u001f\u001bB\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00052\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0007R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R&\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 ¨\u0006("}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "Lkotlin/collections/f;", "Lkotlin/t;", "h", "()V", "key", "value", "i", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/f;", "w", "g", "(Lkotlinx/coroutines/debug/internal/f;)V", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "remove", "clear", "j", "Ljava/lang/ref/ReferenceQueue;", "e", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "", "c", "()I", "size", "", "b", "()Ljava/util/Set;", "keys", "", "a", "entries", "", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class ConcurrentWeakMap<K, V> extends kotlin.collections.f<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3609f = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    @NotNull
    private volatile /* synthetic */ int _size;

    @NotNull
    volatile /* synthetic */ Object core;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ReferenceQueue<K> weakRefQueue;

    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\"\u0004\b\u0002\u0010\u00182\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001f¨\u0006%"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a;", "", "", "hash", "d", "(I)I", "index", "Lkotlin/t;", "i", "(I)V", "key", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "Lkotlinx/coroutines/debug/internal/f;", "weakKey0", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "h", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a;", "weakRef", "b", "(Lkotlinx/coroutines/debug/internal/f;)V", "E", "Lkotlin/Function2;", "factory", "", "e", "(Lp0/p;)Ljava/util/Iterator;", "a", "I", "allocated", "shift", "threshold", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class a {

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f3611g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int allocated;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int shift;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int threshold;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        /* synthetic */ AtomicReferenceArray f3615d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        /* synthetic */ AtomicReferenceArray f3616e;

        @NotNull
        private volatile /* synthetic */ int load = 0;

        /* compiled from: ConcurrentWeakMap.kt */
        @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0002J\u0010\u0010\u0007\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00028\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a$a;", "E", "", "Lkotlin/t;", "a", "", "hasNext", "next", "()Ljava/lang/Object;", "", "b", "Lkotlin/Function2;", "e", "Lp0/p;", "factory", "", "f", "I", "index", "g", "Ljava/lang/Object;", "key", "h", "value", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$a;Lp0/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        private final class C0061a<E> implements Iterator<E>, q0.a {

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final p<K, V, E> factory;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            private int index = -1;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata */
            private K key;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            private V value;

            /* JADX WARN: Multi-variable type inference failed */
            public C0061a(@NotNull p<? super K, ? super V, ? extends E> pVar) {
                this.factory = pVar;
                a();
            }

            private final void a() {
                while (true) {
                    int i2 = this.index + 1;
                    this.index = i2;
                    if (i2 >= ((a) a.this).allocated) {
                        return;
                    }
                    f fVar = (f) a.this.f3615d.get(this.index);
                    K k2 = fVar == null ? null : (K) fVar.get();
                    if (k2 != null) {
                        this.key = k2;
                        Object obj = (V) a.this.f3616e.get(this.index);
                        if (obj instanceof g) {
                            obj = (V) ((g) obj).ref;
                        }
                        if (obj != null) {
                            this.value = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.b.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < ((a) a.this).allocated;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index >= ((a) a.this).allocated) {
                    throw new NoSuchElementException();
                }
                p<K, V, E> pVar = this.factory;
                K k2 = this.key;
                if (k2 == false) {
                    s.t("key");
                    k2 = (K) t.f3507a;
                }
                V v2 = this.value;
                if (v2 == false) {
                    s.t("value");
                    v2 = (V) t.f3507a;
                }
                E e2 = (E) pVar.invoke(k2, v2);
                a();
                return e2;
            }
        }

        public a(int i2) {
            this.allocated = i2;
            this.shift = Integer.numberOfLeadingZeros(i2) + 1;
            this.threshold = (i2 * 2) / 3;
            this.f3615d = new AtomicReferenceArray(i2);
            this.f3616e = new AtomicReferenceArray(i2);
        }

        private final int d(int hash) {
            return (hash * (-1640531527)) >>> this.shift;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(a aVar, Object obj, Object obj2, f fVar, int i2, Object obj3) {
            if ((i2 & 4) != 0) {
                fVar = null;
            }
            return aVar.f(obj, obj2, fVar);
        }

        private final void i(int index) {
            Object obj;
            do {
                obj = this.f3616e.get(index);
                if (obj == null || (obj instanceof g)) {
                    return;
                }
            } while (!kotlinx.coroutines.debug.internal.a.a(this.f3616e, index, obj, null));
            ConcurrentWeakMap.this.h();
        }

        public final void b(@NotNull f<?> weakRef) {
            int iD = d(weakRef.hash);
            while (true) {
                f<?> fVar = (f) this.f3615d.get(iD);
                if (fVar == null) {
                    return;
                }
                if (fVar == weakRef) {
                    i(iD);
                    return;
                } else {
                    if (iD == 0) {
                        iD = this.allocated;
                    }
                    iD--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final V c(@NotNull K key) {
            int iD = d(key.hashCode());
            while (true) {
                f fVar = (f) this.f3615d.get(iD);
                if (fVar == null) {
                    return null;
                }
                T t2 = fVar.get();
                if (s.a(key, t2)) {
                    V v2 = (V) this.f3616e.get(iD);
                    return v2 instanceof g ? (V) ((g) v2).ref : v2;
                }
                if (t2 == 0) {
                    i(iD);
                }
                if (iD == 0) {
                    iD = this.allocated;
                }
                iD--;
            }
        }

        @NotNull
        public final <E> Iterator<E> e(@NotNull p<? super K, ? super V, ? extends E> factory) {
            return new C0061a(factory);
        }

        @Nullable
        public final Object f(@NotNull K key, @Nullable V value, @Nullable f<K> weakKey0) {
            int i2;
            Object obj;
            int iD = d(key.hashCode());
            boolean z2 = false;
            while (true) {
                f fVar = (f) this.f3615d.get(iD);
                if (fVar != null) {
                    T t2 = fVar.get();
                    if (!s.a(key, t2)) {
                        if (t2 == 0) {
                            i(iD);
                        }
                        if (iD == 0) {
                            iD = this.allocated;
                        }
                        iD--;
                    } else if (z2) {
                        f3611g.decrementAndGet(this);
                    }
                } else {
                    if (value == null) {
                        return null;
                    }
                    if (!z2) {
                        do {
                            i2 = this.load;
                            if (i2 >= this.threshold) {
                                return kotlinx.coroutines.debug.internal.b.f3632a;
                            }
                        } while (!f3611g.compareAndSet(this, i2, i2 + 1));
                        z2 = true;
                    }
                    if (weakKey0 == null) {
                        weakKey0 = new f<>(key, ((ConcurrentWeakMap) ConcurrentWeakMap.this).weakRefQueue);
                    }
                    if (kotlinx.coroutines.debug.internal.a.a(this.f3615d, iD, null, weakKey0)) {
                        break;
                    }
                }
            }
            do {
                obj = this.f3616e.get(iD);
                if (obj instanceof g) {
                    return kotlinx.coroutines.debug.internal.b.f3632a;
                }
            } while (!kotlinx.coroutines.debug.internal.a.a(this.f3616e, iD, obj, value));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ConcurrentWeakMap<K, V>.a h() {
            int i2;
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = (ConcurrentWeakMap<K, V>.a) ConcurrentWeakMap.this.new a(Integer.highestOneBit(l.a(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i3 = this.allocated;
                while (i2 < i3) {
                    int i4 = i2 + 1;
                    f fVar = (f) this.f3615d.get(i2);
                    Object obj2 = fVar == null ? null : fVar.get();
                    if (fVar != null && obj2 == null) {
                        i(i2);
                    }
                    while (true) {
                        obj = this.f3616e.get(i2);
                        if (obj instanceof g) {
                            obj = ((g) obj).ref;
                            break;
                        }
                        if (kotlinx.coroutines.debug.internal.a.a(this.f3616e, i2, obj, kotlinx.coroutines.debug.internal.b.d(obj))) {
                            break;
                        }
                    }
                    i2 = (obj2 == null || obj == null || aVar.f(obj2, obj, fVar) != kotlinx.coroutines.debug.internal.b.f3632a) ? i4 : 0;
                }
                return aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\u000e\u001a\u00028\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$b;", "K", "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "e", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", "f", "getValue", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    static final class b<K, V> implements Map.Entry<K, V>, q0.a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final K key;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final V value;

        public b(K k2, V v2) {
            this.key = k2;
            this.value = v2;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            kotlinx.coroutines.debug.internal.b.e();
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$c;", "E", "Lkotlin/collections/g;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "Lkotlin/Function2;", "e", "Lp0/p;", "factory", "", "getSize", "()I", "size", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lp0/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class c<E> extends kotlin.collections.g<E> {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final p<K, V, E> factory;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull p<? super K, ? super V, ? extends E> pVar) {
            this.factory = pVar;
        }

        @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E element) {
            kotlinx.coroutines.debug.internal.b.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.g
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.this.core).e(this.factory);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z2, int i2, o oVar) {
        this((i2 & 1) != 0 ? false : z2);
    }

    private final void g(f<?> w2) {
        ((a) this.core).b(w2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        f3609f.decrementAndGet(this);
    }

    private final synchronized V i(K key, V value) {
        V v2;
        a aVarH = (a) this.core;
        while (true) {
            v2 = (V) a.g(aVarH, key, value, null, 4, null);
            if (v2 == kotlinx.coroutines.debug.internal.b.f3632a) {
                aVarH = aVarH.h();
                this.core = aVarH;
            }
        }
        return v2;
    }

    @Override // kotlin.collections.f
    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new c(new p<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p0.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // p0.p
            @NotNull
            public final Map.Entry<K, V> invoke(@NotNull K k2, @NotNull V v2) {
                return new ConcurrentWeakMap.b(k2, v2);
            }
        });
    }

    @Override // kotlin.collections.f
    @NotNull
    public Set<K> b() {
        return new c(new p<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // p0.p
            @NotNull
            public final K invoke(@NotNull K k2, @NotNull V v2) {
                return k2;
            }
        });
    }

    @Override // kotlin.collections.f
    /* renamed from: c, reason: from getter */
    public int get_size() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        return (V) ((a) this.core).c(key);
    }

    public final void j() throws InterruptedException {
        if (!(this.weakRefQueue != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> referenceRemove = this.weakRefQueue.remove();
                if (referenceRemove == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                }
                g((f) referenceRemove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K key, @NotNull V value) {
        V vI = (V) a.g((a) this.core, key, value, null, 4, null);
        if (vI == kotlinx.coroutines.debug.internal.b.f3632a) {
            vI = i(key, value);
        }
        if (vI == null) {
            f3609f.incrementAndGet(this);
        }
        return vI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object key) {
        if (key == 0) {
            return null;
        }
        V vI = (V) a.g((a) this.core, key, null, null, 4, null);
        if (vI == kotlinx.coroutines.debug.internal.b.f3632a) {
            vI = i(key, null);
        }
        if (vI != null) {
            f3609f.decrementAndGet(this);
        }
        return vI;
    }

    public ConcurrentWeakMap(boolean z2) {
        this._size = 0;
        this.core = new a(16);
        this.weakRefQueue = z2 ? new ReferenceQueue<>() : null;
    }
}
