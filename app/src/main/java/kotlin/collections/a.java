package kotlin.collections;

import com.facebook.internal.ServerProtocol;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractIterator.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH$J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\bH\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/collections/a;", "T", "", "", "d", "hasNext", "next", "()Ljava/lang/Object;", "Lkotlin/t;", "a", "value", "c", "(Ljava/lang/Object;)V", "b", "Lkotlin/collections/State;", "e", "Lkotlin/collections/State;", ServerProtocol.DIALOG_PARAM_STATE, "f", "Ljava/lang/Object;", "nextValue", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public abstract class a<T> implements Iterator<T>, q0.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private State state = State.NotReady;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T nextValue;

    /* compiled from: AbstractIterator.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0054a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3357a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            f3357a = iArr;
        }
    }

    private final boolean d() {
        this.state = State.Failed;
        a();
        return this.state == State.Ready;
    }

    protected abstract void a();

    protected final void b() {
        this.state = State.Done;
    }

    protected final void c(T value) {
        this.nextValue = value;
        this.state = State.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.state;
        if (!(state != State.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = C0054a.f3357a[state.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = State.NotReady;
        return this.nextValue;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
