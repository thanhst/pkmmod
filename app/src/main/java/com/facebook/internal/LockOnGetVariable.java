package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockOnGetVariable.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eB\u0017\b\u0016\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\r\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u0018\u0010\u0005\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/LockOnGetVariable;", "T", "", "Lkotlin/t;", "waitOnInit", "storedValue", "Ljava/lang/Object;", "Ljava/util/concurrent/CountDownLatch;", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "getValue", "()Ljava/lang/Object;", "value", "<init>", "(Ljava/lang/Object;)V", "Ljava/util/concurrent/Callable;", "callable", "(Ljava/util/concurrent/Callable;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LockOnGetVariable<T> {

    @Nullable
    private CountDownLatch initLatch;

    @Nullable
    private T storedValue;

    public LockOnGetVariable(T t2) {
        this.storedValue = t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final Void m106_init_$lambda0(LockOnGetVariable this$0, Callable callable) {
        kotlin.jvm.internal.s.e(this$0, "this$0");
        kotlin.jvm.internal.s.e(callable, "$callable");
        try {
            this$0.storedValue = (T) callable.call();
        } finally {
            CountDownLatch countDownLatch = this$0.initLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private final void waitOnInit() throws InterruptedException {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch == null) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    @Nullable
    public final T getValue() throws InterruptedException {
        waitOnInit();
        return this.storedValue;
    }

    public LockOnGetVariable(@NotNull final Callable<T> callable) {
        kotlin.jvm.internal.s.e(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.internal.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LockOnGetVariable.m106_init_$lambda0(this.f2876a, callable);
            }
        }));
    }
}
