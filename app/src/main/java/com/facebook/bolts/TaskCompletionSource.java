package com.facebook.bolts;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TaskCompletionSource.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0004\u001a\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000b\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tJ\u0006\u0010\r\u001a\u00020\fJ\u0017\u0010\u000e\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/facebook/bolts/TaskCompletionSource;", "TResult", "", "", "trySetCancelled", "result", "trySetResult", "(Ljava/lang/Object;)Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "trySetError", "Lkotlin/t;", "setCancelled", "setResult", "(Ljava/lang/Object;)V", "setError", "Lcom/facebook/bolts/Task;", "task", "Lcom/facebook/bolts/Task;", "getTask", "()Lcom/facebook/bolts/Task;", "<init>", "()V", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {

    @NotNull
    private final Task<TResult> task = new Task<>();

    @NotNull
    public final Task<TResult> getTask() {
        return this.task;
    }

    public final void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.".toString());
        }
    }

    public final void setError(@Nullable Exception exc) {
        if (!trySetError(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.".toString());
        }
    }

    public final void setResult(@Nullable TResult result) {
        if (!trySetResult(result)) {
            throw new IllegalStateException("Cannot set the result of a completed task.".toString());
        }
    }

    public final boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    public final boolean trySetError(@Nullable Exception error) {
        return this.task.trySetError(error);
    }

    public final boolean trySetResult(@Nullable TResult result) {
        return this.task.trySetResult(result);
    }
}
