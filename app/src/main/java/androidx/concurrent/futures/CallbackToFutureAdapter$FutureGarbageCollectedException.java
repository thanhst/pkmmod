package androidx.concurrent.futures;

/* loaded from: classes.dex */
final class CallbackToFutureAdapter$FutureGarbageCollectedException extends Throwable {
    CallbackToFutureAdapter$FutureGarbageCollectedException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
