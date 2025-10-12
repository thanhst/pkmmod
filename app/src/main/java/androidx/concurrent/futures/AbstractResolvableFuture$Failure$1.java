package androidx.concurrent.futures;

/* loaded from: classes.dex */
final class AbstractResolvableFuture$Failure$1 extends Throwable {
    AbstractResolvableFuture$Failure$1(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
