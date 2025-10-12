package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WorkQueue.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f !B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0006\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0018\u00010\u0004R\u00020\u0000H\u0002J\u0014\u0010\b\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0004R\u00020\u0000H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007J\u0006\u0010\u000f\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\b\u0018\u00010\u0004R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0018\u00010\u0004R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012¨\u0006\""}, d2 = {"Lcom/facebook/internal/WorkQueue;", "", "Lkotlin/t;", "startItem", "Lcom/facebook/internal/WorkQueue$WorkNode;", "finished", "finishItemAndStartNew", "node", "execute", "Ljava/lang/Runnable;", "callback", "", "addToFront", "Lcom/facebook/internal/WorkQueue$WorkItem;", "addActiveWorkItem", "validate", "", "maxConcurrent", "I", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/locks/ReentrantLock;", "workLock", "Ljava/util/concurrent/locks/ReentrantLock;", "pendingJobs", "Lcom/facebook/internal/WorkQueue$WorkNode;", "runningJobs", "runningCount", "<init>", "(ILjava/util/concurrent/Executor;)V", "Companion", "WorkItem", "WorkNode", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WorkQueue {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;

    @NotNull
    private final Executor executor;
    private final int maxConcurrent;

    @Nullable
    private WorkNode pendingJobs;
    private int runningCount;

    @Nullable
    private WorkNode runningJobs;

    @NotNull
    private final ReentrantLock workLock;

    /* compiled from: WorkQueue.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/WorkQueue$Companion;", "", "", "condition", "Lkotlin/t;", "assert", "", "DEFAULT_MAX_CONCURRENT", "I", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: assert, reason: not valid java name */
        public final void m117assert(boolean z2) {
            if (!z2) {
                throw new FacebookException("Validation failed");
            }
        }
    }

    /* compiled from: WorkQueue.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&R\u0014\u0010\u0006\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkItem;", "", "", "cancel", "Lkotlin/t;", "moveToFront", "isRunning", "()Z", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface WorkItem {
        boolean cancel();

        /* renamed from: isRunning */
        boolean getIsRunning();

        void moveToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WorkQueue.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00060\u0000R\u00020\u00062\f\u0010\u0007\u001a\b\u0018\u00010\u0000R\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u001a\u0010\n\u001a\b\u0018\u00010\u0000R\u00020\u00062\f\u0010\u0007\u001a\b\u0018\u00010\u0000R\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R0\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\u00062\f\u0010\u0012\u001a\b\u0018\u00010\u0000R\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\b\u0018\u00010\u0000R\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkNode;", "Lcom/facebook/internal/WorkQueue$WorkItem;", "", "cancel", "Lkotlin/t;", "moveToFront", "Lcom/facebook/internal/WorkQueue;", "list", "addToFront", "addToList", "removeFromList", "shouldBeRunning", "verify", "Ljava/lang/Runnable;", "callback", "Ljava/lang/Runnable;", "getCallback", "()Ljava/lang/Runnable;", "<set-?>", "next", "Lcom/facebook/internal/WorkQueue$WorkNode;", "getNext", "()Lcom/facebook/internal/WorkQueue$WorkNode;", "prev", "isRunning", "Z", "()Z", "setRunning", "(Z)V", "<init>", "(Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    final class WorkNode implements WorkItem {

        @NotNull
        private final Runnable callback;
        private boolean isRunning;

        @Nullable
        private WorkNode next;

        @Nullable
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(@NotNull WorkQueue this$0, Runnable callback) {
            kotlin.jvm.internal.s.e(this$0, "this$0");
            kotlin.jvm.internal.s.e(callback, "callback");
            this.this$0 = this$0;
            this.callback = callback;
        }

        @NotNull
        public final WorkNode addToList(@Nullable WorkNode list, boolean addToFront) {
            Companion companion = WorkQueue.INSTANCE;
            companion.m117assert(this.next == null);
            companion.m117assert(this.prev == null);
            if (list == null) {
                this.prev = this;
                this.next = this;
                list = this;
            } else {
                this.next = list;
                WorkNode workNode = list.prev;
                this.prev = workNode;
                if (workNode != null) {
                    workNode.next = this;
                }
                WorkNode workNode2 = this.next;
                if (workNode2 != null) {
                    workNode2.prev = workNode == null ? null : workNode.next;
                }
            }
            return addToFront ? this : list;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!getIsRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    return true;
                }
                kotlin.t tVar = kotlin.t.f3507a;
                reentrantLock.unlock();
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }

        @NotNull
        public final Runnable getCallback() {
            return this.callback;
        }

        @Nullable
        public final WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        /* renamed from: isRunning, reason: from getter */
        public boolean getIsRunning() {
            return this.isRunning;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!getIsRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
                kotlin.t tVar = kotlin.t.f3507a;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Nullable
        public final WorkNode removeFromList(@Nullable WorkNode list) {
            Companion companion = WorkQueue.INSTANCE;
            companion.m117assert(this.next != null);
            companion.m117assert(this.prev != null);
            if (list == this && (list = this.next) == this) {
                list = null;
            }
            WorkNode workNode = this.next;
            if (workNode != null) {
                workNode.prev = this.prev;
            }
            WorkNode workNode2 = this.prev;
            if (workNode2 != null) {
                workNode2.next = workNode;
            }
            this.prev = null;
            this.next = null;
            return list;
        }

        public void setRunning(boolean z2) {
            this.isRunning = z2;
        }

        public final void verify(boolean z2) {
            WorkNode workNode;
            WorkNode workNode2;
            Companion companion = WorkQueue.INSTANCE;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            companion.m117assert(workNode == this);
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            companion.m117assert(workNode2 == this);
            companion.m117assert(getIsRunning() == z2);
        }
    }

    @JvmOverloads
    public WorkQueue() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public WorkQueue(int i2) {
        this(i2, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public WorkQueue(int i2, @NotNull Executor executor) {
        kotlin.jvm.internal.s.e(executor, "executor");
        this.maxConcurrent = i2;
        this.executor = executor;
        this.workLock = new ReentrantLock();
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return workQueue.addActiveWorkItem(runnable, z2);
    }

    private final void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.x
            @Override // java.lang.Runnable
            public final void run() {
                WorkQueue.m116execute$lambda2(workNode, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execute$lambda-2, reason: not valid java name */
    public static final void m116execute$lambda2(WorkNode node, WorkQueue this$0) {
        kotlin.jvm.internal.s.e(node, "$node");
        kotlin.jvm.internal.s.e(this$0, "this$0");
        try {
            node.getCallback().run();
        } finally {
            this$0.finishItemAndStartNew(node);
        }
    }

    private final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setRunning(true);
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void startItem() {
        finishItemAndStartNew(null);
    }

    @JvmOverloads
    @NotNull
    public final WorkItem addActiveWorkItem(@NotNull Runnable callback) {
        kotlin.jvm.internal.s.e(callback, "callback");
        return addActiveWorkItem$default(this, callback, false, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final WorkItem addActiveWorkItem(@NotNull Runnable callback, boolean addToFront) {
        kotlin.jvm.internal.s.e(callback, "callback");
        WorkNode workNode = new WorkNode(this, callback);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, addToFront);
            kotlin.t tVar = kotlin.t.f3507a;
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void validate() {
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            WorkNode next = this.runningJobs;
            int i2 = 0;
            if (next != null) {
                while (next != null) {
                    next.verify(true);
                    i2++;
                    next = next.getNext();
                    if (next == this.runningJobs) {
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            INSTANCE.m117assert(this.runningCount == i2);
            kotlin.t tVar = kotlin.t.f3507a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public /* synthetic */ WorkQueue(int i2, Executor executor, int i3, kotlin.jvm.internal.o oVar) {
        this((i3 & 1) != 0 ? 8 : i2, (i3 & 2) != 0 ? FacebookSdk.getExecutor() : executor);
    }
}
