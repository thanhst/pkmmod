package kotlin.sequences;

import com.facebook.internal.ServerProtocol;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SequenceBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u0010\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b \u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lkotlin/sequences/e;", "T", "Lkotlin/sequences/f;", "", "Lkotlin/coroutines/c;", "Lkotlin/t;", "g", "()Ljava/lang/Object;", "", "f", "", "hasNext", "next", "value", "a", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "iterator", "b", "(Ljava/util/Iterator;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "Lkotlin/sequences/State;", "e", "I", ServerProtocol.DIALOG_PARAM_STATE, "Ljava/lang/Object;", "nextValue", "Ljava/util/Iterator;", "nextIterator", "h", "Lkotlin/coroutines/c;", "getNextStep", "()Lkotlin/coroutines/c;", "(Lkotlin/coroutines/c;)V", "nextStep", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class e<T> extends f<T> implements Iterator<T>, kotlin.coroutines.c<t>, q0.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T nextValue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Iterator<? extends T> nextIterator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private kotlin.coroutines.c<? super t> nextStep;

    private final Throwable f() {
        int i2 = this.state;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.state);
    }

    private final T g() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.f
    @Nullable
    public Object a(T t2, @NotNull kotlin.coroutines.c<? super t> cVar) {
        this.nextValue = t2;
        this.state = 3;
        this.nextStep = cVar;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        if (objD == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objD == kotlin.coroutines.intrinsics.b.d() ? objD : t.f3507a;
    }

    @Override // kotlin.sequences.f
    @Nullable
    public Object b(@NotNull Iterator<? extends T> it, @NotNull kotlin.coroutines.c<? super t> cVar) {
        if (!it.hasNext()) {
            return t.f3507a;
        }
        this.nextIterator = it;
        this.state = 2;
        this.nextStep = cVar;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        if (objD == kotlin.coroutines.intrinsics.b.d()) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return objD == kotlin.coroutines.intrinsics.b.d() ? objD : t.f3507a;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final void h(@Nullable kotlin.coroutines.c<? super t> cVar) {
        this.nextStep = cVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i2 = this.state;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator<? extends T> it = this.nextIterator;
                s.b(it);
                if (it.hasNext()) {
                    this.state = 2;
                    return true;
                }
                this.nextIterator = null;
            }
            this.state = 5;
            kotlin.coroutines.c<? super t> cVar = this.nextStep;
            s.b(cVar);
            this.nextStep = null;
            Result.Companion aVar = Result.INSTANCE;
            cVar.resumeWith(Result.m158constructorimpl(t.f3507a));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i2 = this.state;
        if (i2 == 0 || i2 == 1) {
            return g();
        }
        if (i2 == 2) {
            this.state = 1;
            Iterator<? extends T> it = this.nextIterator;
            s.b(it);
            return it.next();
        }
        if (i2 != 3) {
            throw f();
        }
        this.state = 0;
        T t2 = this.nextValue;
        this.nextValue = null;
        return t2;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object result) {
        kotlin.h.b(result);
        this.state = 4;
    }
}
