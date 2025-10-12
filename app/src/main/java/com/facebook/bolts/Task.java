package com.facebook.bolts;

import com.facebook.appevents.UserDataStore;
import com.facebook.bolts.BoltsExecutors;
import com.facebook.bolts.Task;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Task.kt */
@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0013\u0018\u0000 G*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003GHIB\t\b\u0010¢\u0006\u0004\bB\u0010CB\u0013\b\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bB\u0010DB\u0011\b\u0012\u0012\u0006\u0010E\u001a\u00020\n¢\u0006\u0004\bB\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\u0016\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0000J4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00000\u0011J>\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00000\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014JJ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00000\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J.\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016J8\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011J0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00112\u0006\u0010\u0017\u001a\u00020\u0016J>\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00112\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0011J6\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016J8\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011J0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00112\u0006\u0010\u0017\u001a\u00020\u0016J>\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00112\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0011J6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00182\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001d\u001a\u00020\nJ\u0017\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010$\u001a\u00020\n2\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\n )*\u0004\u0018\u00010(0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00101\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R*\u00108\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u0011\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b<\u0010;R\u0011\u0010=\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0013\u0010\u001e\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0019\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"8F¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006J"}, d2 = {"Lcom/facebook/bolts/Task;", "TResult", "", "Lkotlin/t;", "runContinuations", "waitForCompletion", "", "duration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "TOut", "cast", "Ljava/lang/Void;", "makeVoid", "Ljava/util/concurrent/Callable;", "predicate", "Lcom/facebook/bolts/Continuation;", "continuation", "continueWhile", "Lcom/facebook/bolts/CancellationToken;", UserDataStore.CITY, "Ljava/util/concurrent/Executor;", "executor", "TContinuationResult", "continueWith", "continueWithTask", "onSuccess", "onSuccessTask", "trySetCancelled", "result", "trySetResult", "(Ljava/lang/Object;)Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "trySetError", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "condition", "Ljava/util/concurrent/locks/Condition;", "completeField", "Z", "cancelledField", "resultField", "Ljava/lang/Object;", "errorField", "Ljava/lang/Exception;", "errorHasBeenObserved", "Lcom/facebook/bolts/UnobservedErrorNotifier;", "unobservedErrorNotifier", "Lcom/facebook/bolts/UnobservedErrorNotifier;", "", "continuations", "Ljava/util/List;", "isCompleted", "()Z", "isCancelled", "isFaulted", "getResult", "()Ljava/lang/Object;", "getError", "()Ljava/lang/Exception;", "<init>", "()V", "(Ljava/lang/Object;)V", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "(Z)V", "Companion", "TaskCompletionSource", "UnobservedExceptionHandler", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Task<TResult> {

    @JvmField
    @NotNull
    public static final ExecutorService BACKGROUND_EXECUTOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Executor IMMEDIATE_EXECUTOR;

    @NotNull
    private static final Task<?> TASK_CANCELLED;

    @NotNull
    private static final Task<Boolean> TASK_FALSE;

    @NotNull
    private static final Task<?> TASK_NULL;

    @NotNull
    private static final Task<Boolean> TASK_TRUE;

    @JvmField
    @NotNull
    public static final Executor UI_THREAD_EXECUTOR;

    @Nullable
    private static volatile UnobservedExceptionHandler unobservedExceptionHandler;
    private boolean cancelledField;
    private boolean completeField;
    private final Condition condition;

    @Nullable
    private List<Continuation<TResult, Void>> continuations;

    @Nullable
    private Exception errorField;
    private boolean errorHasBeenObserved;

    @NotNull
    private final ReentrantLock lock;

    @Nullable
    private TResult resultField;

    @Nullable
    private UnobservedErrorNotifier unobservedErrorNotifier;

    /* compiled from: Task.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b=\u0010>JV\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\\\u0010\u0010\u001a\u00020\u000e\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0007J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u001a\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H\u0007J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u0003H\u0007J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\"\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\fH\u0007J1\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\"\u0010#J$\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010$H\u0007J.\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010$2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J,\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010$2\u0006\u0010\u000b\u001a\u00020\nH\u0007J6\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010$2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J$\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010$H\u0007J.\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010\u00032\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010$2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J.\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\b\"\u0004\b\u0001\u0010\u00032\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0(H\u0007J$\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\b2\u0010\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0(H\u0007J0\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010,0\b\"\u0004\b\u0001\u0010\u00032\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0(H\u0007J \u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\b2\u0010\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0(H\u0007R\u0014\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00105R\u0018\u00108\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00105R\u0014\u0010:\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u00103R\u0018\u0010;\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/facebook/bolts/Task$Companion;", "", "TContinuationResult", "TResult", "Lcom/facebook/bolts/TaskCompletionSource;", "tcs", "Lcom/facebook/bolts/Continuation;", "continuation", "Lcom/facebook/bolts/Task;", "task", "Ljava/util/concurrent/Executor;", "executor", "Lcom/facebook/bolts/CancellationToken;", UserDataStore.CITY, "Lkotlin/t;", "completeImmediately", "completeAfterTask", "Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "getUnobservedExceptionHandler", "eh", "setUnobservedExceptionHandler", "value", "forResult", "(Ljava/lang/Object;)Lcom/facebook/bolts/Task;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "forError", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "", "delay", "Ljava/lang/Void;", "cancellationToken", "Ljava/util/concurrent/ScheduledExecutorService;", "delay$facebook_bolts_release", "(JLjava/util/concurrent/ScheduledExecutorService;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "Ljava/util/concurrent/Callable;", "callable", "callInBackground", "call", "", "tasks", "whenAnyResult", "whenAny", "", "whenAllResult", "whenAll", "Ljava/util/concurrent/ExecutorService;", "BACKGROUND_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "IMMEDIATE_EXECUTOR", "Ljava/util/concurrent/Executor;", "TASK_CANCELLED", "Lcom/facebook/bolts/Task;", "", "TASK_FALSE", "TASK_NULL", "TASK_TRUE", "UI_THREAD_EXECUTOR", "unobservedExceptionHandler", "Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "<init>", "()V", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: call$lambda-2, reason: not valid java name */
        public static final void m84call$lambda2(CancellationToken cancellationToken, com.facebook.bolts.TaskCompletionSource tcs, Callable callable) {
            s.e(tcs, "$tcs");
            s.e(callable, "$callable");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return;
            }
            try {
                tcs.setResult(callable.call());
            } catch (CancellationException unused) {
                tcs.setCancelled();
            } catch (Exception e2) {
                tcs.setError(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeAfterTask(final com.facebook.bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m85completeAfterTask$lambda7(cancellationToken, taskCompletionSource, continuation, task);
                    }
                });
            } catch (Exception e2) {
                taskCompletionSource.setError(new ExecutorException(e2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: completeAfterTask$lambda-7, reason: not valid java name */
        public static final void m85completeAfterTask$lambda7(final CancellationToken cancellationToken, final com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Task task) {
            s.e(tcs, "$tcs");
            s.e(continuation, "$continuation");
            s.e(task, "$task");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return;
            }
            try {
                Task task2 = (Task) continuation.then(task);
                if (task2 == null) {
                    tcs.setResult(null);
                } else {
                    task2.continueWith(new Continuation() { // from class: com.facebook.bolts.n
                        @Override // com.facebook.bolts.Continuation
                        public final Object then(Task task3) {
                            return Task.Companion.m86completeAfterTask$lambda7$lambda6(cancellationToken, tcs, task3);
                        }
                    });
                }
            } catch (CancellationException unused) {
                tcs.setCancelled();
            } catch (Exception e2) {
                tcs.setError(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: completeAfterTask$lambda-7$lambda-6, reason: not valid java name */
        public static final Void m86completeAfterTask$lambda7$lambda6(CancellationToken cancellationToken, com.facebook.bolts.TaskCompletionSource tcs, Task task) {
            s.e(tcs, "$tcs");
            s.e(task, "task");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return null;
            }
            if (task.isCancelled()) {
                tcs.setCancelled();
            } else if (task.isFaulted()) {
                tcs.setError(task.getError());
            } else {
                tcs.setResult(task.getResult());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeImmediately(final com.facebook.bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m87completeImmediately$lambda5(cancellationToken, taskCompletionSource, continuation, task);
                    }
                });
            } catch (Exception e2) {
                taskCompletionSource.setError(new ExecutorException(e2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: completeImmediately$lambda-5, reason: not valid java name */
        public static final void m87completeImmediately$lambda5(CancellationToken cancellationToken, com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Task task) {
            s.e(tcs, "$tcs");
            s.e(continuation, "$continuation");
            s.e(task, "$task");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                tcs.setCancelled();
                return;
            }
            try {
                tcs.setResult(continuation.then(task));
            } catch (CancellationException unused) {
                tcs.setCancelled();
            } catch (Exception e2) {
                tcs.setError(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: delay$lambda-0, reason: not valid java name */
        public static final void m88delay$lambda0(com.facebook.bolts.TaskCompletionSource tcs) {
            s.e(tcs, "$tcs");
            tcs.trySetResult(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: delay$lambda-1, reason: not valid java name */
        public static final void m89delay$lambda1(ScheduledFuture scheduledFuture, com.facebook.bolts.TaskCompletionSource tcs) {
            s.e(tcs, "$tcs");
            scheduledFuture.cancel(true);
            tcs.trySetCancelled();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: whenAny$lambda-4, reason: not valid java name */
        public static final Void m90whenAny$lambda4(AtomicBoolean isAnyTaskComplete, com.facebook.bolts.TaskCompletionSource firstCompleted, Task it) {
            s.e(isAnyTaskComplete, "$isAnyTaskComplete");
            s.e(firstCompleted, "$firstCompleted");
            s.e(it, "it");
            if (isAnyTaskComplete.compareAndSet(false, true)) {
                firstCompleted.setResult(it);
                return null;
            }
            it.getError();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: whenAnyResult$lambda-3, reason: not valid java name */
        public static final Void m91whenAnyResult$lambda3(AtomicBoolean isAnyTaskComplete, com.facebook.bolts.TaskCompletionSource firstCompleted, Task it) {
            s.e(isAnyTaskComplete, "$isAnyTaskComplete");
            s.e(firstCompleted, "$firstCompleted");
            s.e(it, "it");
            if (isAnyTaskComplete.compareAndSet(false, true)) {
                firstCompleted.setResult(it);
                return null;
            }
            it.getError();
            return null;
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable, @NotNull Executor executor) {
            s.e(callable, "callable");
            s.e(executor, "executor");
            return call(callable, executor, null);
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> callInBackground(@NotNull Callable<TResult> callable) {
            s.e(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, null);
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> cancelled() {
            return Task.TASK_CANCELLED;
        }

        @JvmStatic
        @NotNull
        public final Task<Void> delay(long delay) {
            return delay$facebook_bolts_release(delay, BoltsExecutors.INSTANCE.scheduled$facebook_bolts_release(), null);
        }

        @JvmStatic
        @NotNull
        public final Task<Void> delay$facebook_bolts_release(long delay, @NotNull ScheduledExecutorService executor, @Nullable CancellationToken cancellationToken) {
            s.e(executor, "executor");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return cancelled();
            }
            if (delay <= 0) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final ScheduledFuture<?> scheduledFutureSchedule = executor.schedule(new Runnable() { // from class: com.facebook.bolts.k
                @Override // java.lang.Runnable
                public final void run() {
                    Task.Companion.m88delay$lambda0(taskCompletionSource);
                }
            }, delay, TimeUnit.MILLISECONDS);
            if (cancellationToken != null) {
                cancellationToken.register(new Runnable() { // from class: com.facebook.bolts.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m89delay$lambda1(scheduledFutureSchedule, taskCompletionSource);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> forError(@Nullable Exception error) {
            com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            taskCompletionSource.setError(error);
            return taskCompletionSource.getTask();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> forResult(@Nullable TResult value) {
            if (value == 0) {
                return Task.TASK_NULL;
            }
            if (value instanceof Boolean) {
                return ((Boolean) value).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
            }
            com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            taskCompletionSource.setResult(value);
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        @Nullable
        public final UnobservedExceptionHandler getUnobservedExceptionHandler() {
            return Task.unobservedExceptionHandler;
        }

        @JvmStatic
        public final void setUnobservedExceptionHandler(@Nullable UnobservedExceptionHandler unobservedExceptionHandler) {
            Task.unobservedExceptionHandler = unobservedExceptionHandler;
        }

        @JvmStatic
        @NotNull
        public final Task<Void> whenAll(@NotNull Collection<? extends Task<?>> tasks) {
            s.e(tasks, "tasks");
            if (tasks.isEmpty()) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final ArrayList arrayList = new ArrayList();
            final ReentrantLock reentrantLock = new ReentrantLock();
            final AtomicInteger atomicInteger = new AtomicInteger(tasks.size());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Iterator<? extends Task<?>> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().continueWith(new Continuation() { // from class: com.facebook.bolts.Task$Companion$whenAll$1
                    @Override // com.facebook.bolts.Continuation
                    public /* bridge */ /* synthetic */ Object then(Task task) {
                        return then((Task<Object>) task);
                    }

                    @Override // com.facebook.bolts.Continuation
                    @Nullable
                    public final Void then(@NotNull Task<Object> it2) {
                        s.e(it2, "it");
                        if (it2.isFaulted()) {
                            ReentrantLock reentrantLock2 = reentrantLock;
                            ArrayList<Exception> arrayList2 = arrayList;
                            reentrantLock2.lock();
                            try {
                                arrayList2.add(it2.getError());
                            } finally {
                                reentrantLock2.unlock();
                            }
                        }
                        if (it2.isCancelled()) {
                            atomicBoolean.set(true);
                        }
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (arrayList.size() != 0) {
                                if (arrayList.size() == 1) {
                                    taskCompletionSource.setError(arrayList.get(0));
                                } else {
                                    x xVar = x.f3460a;
                                    String str = String.format("There were %d exceptions.", Arrays.copyOf(new Object[]{Integer.valueOf(arrayList.size())}, 1));
                                    s.d(str, "java.lang.String.format(format, *args)");
                                    taskCompletionSource.setError(new AggregateException(str, arrayList));
                                }
                            } else if (atomicBoolean.get()) {
                                taskCompletionSource.setCancelled();
                            } else {
                                taskCompletionSource.setResult(null);
                            }
                        }
                        return null;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<List<TResult>> whenAllResult(@NotNull final Collection<Task<TResult>> tasks) {
            s.e(tasks, "tasks");
            return (Task<List<TResult>>) whenAll(tasks).onSuccess(new Continuation<Void, List<? extends TResult>>() { // from class: com.facebook.bolts.Task$Companion$whenAllResult$1
                @Override // com.facebook.bolts.Continuation
                @NotNull
                public List<TResult> then(@NotNull Task<Void> task) {
                    s.e(task, "task");
                    if (tasks.isEmpty()) {
                        return u.h();
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task<TResult>> it = tasks.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getResult());
                    }
                    return arrayList;
                }
            });
        }

        @JvmStatic
        @NotNull
        public final Task<Task<?>> whenAny(@NotNull Collection<? extends Task<?>> tasks) {
            s.e(tasks, "tasks");
            if (tasks.isEmpty()) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Iterator<? extends Task<?>> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().continueWith(new Continuation() { // from class: com.facebook.bolts.m
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        return Task.Companion.m90whenAny$lambda4(atomicBoolean, taskCompletionSource, task);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<Task<TResult>> whenAnyResult(@NotNull Collection<Task<TResult>> tasks) {
            s.e(tasks, "tasks");
            if (tasks.isEmpty()) {
                return forResult(null);
            }
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Iterator<Task<TResult>> it = tasks.iterator();
            while (it.hasNext()) {
                it.next().continueWith(new Continuation() { // from class: com.facebook.bolts.g
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        return Task.Companion.m91whenAnyResult$lambda3(atomicBoolean, taskCompletionSource, task);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> call(@NotNull final Callable<TResult> callable, @NotNull Executor executor, @Nullable final CancellationToken ct) {
            s.e(callable, "callable");
            s.e(executor, "executor");
            final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.m84call$lambda2(ct, taskCompletionSource, callable);
                    }
                });
            } catch (Exception e2) {
                taskCompletionSource.setError(new ExecutorException(e2));
            }
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> callInBackground(@NotNull Callable<TResult> callable, @Nullable CancellationToken ct) {
            s.e(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, ct);
        }

        @JvmStatic
        @NotNull
        public final Task<Void> delay(long delay, @Nullable CancellationToken cancellationToken) {
            return delay$facebook_bolts_release(delay, BoltsExecutors.INSTANCE.scheduled$facebook_bolts_release(), cancellationToken);
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable) {
            s.e(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, null);
        }

        @JvmStatic
        @NotNull
        public final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable, @Nullable CancellationToken ct) {
            s.e(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, ct);
        }
    }

    /* compiled from: Task.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/bolts/Task$TaskCompletionSource;", "Lcom/facebook/bolts/TaskCompletionSource;", "(Lcom/facebook/bolts/Task;)V", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Deprecated(message = "Please use [TaskCompletionSource] instead. ")
    public final class TaskCompletionSource extends com.facebook.bolts.TaskCompletionSource<TResult> {
        final /* synthetic */ Task<TResult> this$0;

        public TaskCompletionSource(Task this$0) {
            s.e(this$0, "this$0");
            this.this$0 = this$0;
        }
    }

    /* compiled from: Task.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "", "Lcom/facebook/bolts/Task;", "t", "Lcom/facebook/bolts/UnobservedTaskException;", "e", "Lkotlin/t;", "unobservedException", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
    public interface UnobservedExceptionHandler {
        void unobservedException(@NotNull Task<?> task, @NotNull UnobservedTaskException unobservedTaskException);
    }

    static {
        BoltsExecutors.Companion companion = BoltsExecutors.INSTANCE;
        BACKGROUND_EXECUTOR = companion.background();
        IMMEDIATE_EXECUTOR = companion.immediate$facebook_bolts_release();
        UI_THREAD_EXECUTOR = AndroidExecutors.INSTANCE.uiThread();
        TASK_NULL = new Task<>((Object) null);
        TASK_TRUE = new Task<>(Boolean.TRUE);
        TASK_FALSE = new Task<>(Boolean.FALSE);
        TASK_CANCELLED = new Task<>(true);
    }

    public Task() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable) {
        return INSTANCE.call(callable);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable, @Nullable CancellationToken cancellationToken) {
        return INSTANCE.call(callable, cancellationToken);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable, @NotNull Executor executor) {
        return INSTANCE.call(callable, executor);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> call(@NotNull Callable<TResult> callable, @NotNull Executor executor, @Nullable CancellationToken cancellationToken) {
        return INSTANCE.call(callable, executor, cancellationToken);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> callInBackground(@NotNull Callable<TResult> callable) {
        return INSTANCE.callInBackground(callable);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> callInBackground(@NotNull Callable<TResult> callable, @Nullable CancellationToken cancellationToken) {
        return INSTANCE.callInBackground(callable, cancellationToken);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> cancelled() {
        return INSTANCE.cancelled();
    }

    public static /* synthetic */ Task continueWhile$default(Task task, Callable callable, Continuation continuation, Executor executor, CancellationToken cancellationToken, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        if ((i2 & 8) != 0) {
            cancellationToken = null;
        }
        return task.continueWhile(callable, continuation, executor, cancellationToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: continueWith$lambda-10$lambda-9, reason: not valid java name */
    public static final Void m79continueWith$lambda10$lambda9(com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        s.e(tcs, "$tcs");
        s.e(continuation, "$continuation");
        s.e(executor, "$executor");
        s.e(task, "task");
        INSTANCE.completeImmediately(tcs, continuation, task, executor, cancellationToken);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: continueWithTask$lambda-12$lambda-11, reason: not valid java name */
    public static final Void m80continueWithTask$lambda12$lambda11(com.facebook.bolts.TaskCompletionSource tcs, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        s.e(tcs, "$tcs");
        s.e(continuation, "$continuation");
        s.e(executor, "$executor");
        s.e(task, "task");
        INSTANCE.completeAfterTask(tcs, continuation, task, executor, cancellationToken);
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Task<Void> delay(long j2) {
        return INSTANCE.delay(j2);
    }

    @JvmStatic
    @NotNull
    public static final Task<Void> delay(long j2, @Nullable CancellationToken cancellationToken) {
        return INSTANCE.delay(j2, cancellationToken);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> forError(@Nullable Exception exc) {
        return INSTANCE.forError(exc);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<TResult> forResult(@Nullable TResult tresult) {
        return INSTANCE.forResult(tresult);
    }

    @JvmStatic
    @Nullable
    public static final UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return INSTANCE.getUnobservedExceptionHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: makeVoid$lambda-8, reason: not valid java name */
    public static final Task m81makeVoid$lambda8(Task task) {
        s.e(task, "task");
        return task.isCancelled() ? INSTANCE.cancelled() : task.isFaulted() ? INSTANCE.forError(task.getError()) : INSTANCE.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-13, reason: not valid java name */
    public static final Task m82onSuccess$lambda13(CancellationToken cancellationToken, Continuation continuation, Task task) {
        s.e(continuation, "$continuation");
        s.e(task, "task");
        return (cancellationToken == null || !cancellationToken.isCancellationRequested()) ? task.isFaulted() ? INSTANCE.forError(task.getError()) : task.isCancelled() ? INSTANCE.cancelled() : task.continueWith(continuation) : INSTANCE.cancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccessTask$lambda-14, reason: not valid java name */
    public static final Task m83onSuccessTask$lambda14(CancellationToken cancellationToken, Continuation continuation, Task task) {
        s.e(continuation, "$continuation");
        s.e(task, "task");
        return (cancellationToken == null || !cancellationToken.isCancellationRequested()) ? task.isFaulted() ? INSTANCE.forError(task.getError()) : task.isCancelled() ? INSTANCE.cancelled() : task.continueWithTask(continuation) : INSTANCE.cancelled();
    }

    private final void runContinuations() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List<Continuation<TResult, Void>> list = this.continuations;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            ((Continuation) it.next()).then(this);
                        } catch (Throwable th) {
                            throw new RuntimeException(th);
                        }
                    } catch (RuntimeException e2) {
                        throw e2;
                    }
                }
            }
            this.continuations = null;
            t tVar = t.f3507a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @JvmStatic
    public static final void setUnobservedExceptionHandler(@Nullable UnobservedExceptionHandler unobservedExceptionHandler2) {
        INSTANCE.setUnobservedExceptionHandler(unobservedExceptionHandler2);
    }

    @JvmStatic
    @NotNull
    public static final Task<Void> whenAll(@NotNull Collection<? extends Task<?>> collection) {
        return INSTANCE.whenAll(collection);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<List<TResult>> whenAllResult(@NotNull Collection<Task<TResult>> collection) {
        return INSTANCE.whenAllResult(collection);
    }

    @JvmStatic
    @NotNull
    public static final Task<Task<?>> whenAny(@NotNull Collection<? extends Task<?>> collection) {
        return INSTANCE.whenAny(collection);
    }

    @JvmStatic
    @NotNull
    public static final <TResult> Task<Task<TResult>> whenAnyResult(@NotNull Collection<Task<TResult>> collection) {
        return INSTANCE.whenAnyResult(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <TOut> Task<TOut> cast() {
        return this;
    }

    @NotNull
    public final Task<Void> continueWhile(@NotNull Callable<Boolean> predicate, @NotNull Continuation<Void, Task<Void>> continuation) {
        s.e(predicate, "predicate");
        s.e(continuation, "continuation");
        return continueWhile(predicate, continuation, IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NotNull Continuation<TResult, TContinuationResult> continuation, @NotNull Executor executor) {
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return continueWith(continuation, executor, null);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NotNull Continuation<TResult, Task<TContinuationResult>> continuation, @NotNull Executor executor) {
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return continueWithTask(continuation, executor, null);
    }

    @Nullable
    public final Exception getError() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.errorField != null) {
                this.errorHasBeenObserved = true;
                UnobservedErrorNotifier unobservedErrorNotifier = this.unobservedErrorNotifier;
                if (unobservedErrorNotifier != null) {
                    unobservedErrorNotifier.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            return this.errorField;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    public final TResult getResult() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.resultField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.cancelledField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCompleted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.completeField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isFaulted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.errorField != null;
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public final Task<Void> makeVoid() {
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.e
            @Override // com.facebook.bolts.Continuation
            public final Object then(Task task) {
                return Task.m81makeVoid$lambda8(task);
            }
        });
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@NotNull Continuation<TResult, TContinuationResult> continuation, @NotNull Executor executor) {
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return onSuccess(continuation, executor, null);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NotNull Continuation<TResult, Task<TContinuationResult>> continuation, @NotNull Executor executor) {
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return onSuccessTask(continuation, executor, null);
    }

    public final boolean trySetCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.cancelledField = true;
            this.condition.signalAll();
            runContinuations();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetError(@Nullable Exception error) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.errorField = error;
            this.errorHasBeenObserved = false;
            this.condition.signalAll();
            runContinuations();
            if (!this.errorHasBeenObserved && unobservedExceptionHandler != null) {
                this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetResult(@Nullable TResult result) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.resultField = result;
            this.condition.signalAll();
            runContinuations();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void waitForCompletion() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await();
            }
            t tVar = t.f3507a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public final Task<Void> continueWhile(@NotNull Callable<Boolean> predicate, @NotNull Continuation<Void, Task<Void>> continuation, @Nullable CancellationToken ct) {
        s.e(predicate, "predicate");
        s.e(continuation, "continuation");
        return continueWhile(predicate, continuation, IMMEDIATE_EXECUTOR, ct);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NotNull final Continuation<TResult, TContinuationResult> continuation, @NotNull final Executor executor, @Nullable final CancellationToken ct) {
        List<Continuation<TResult, Void>> list;
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean zIsCompleted = isCompleted();
            if (!zIsCompleted && (list = this.continuations) != null) {
                list.add(new Continuation() { // from class: com.facebook.bolts.c
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        return Task.m79continueWith$lambda10$lambda9(taskCompletionSource, continuation, executor, ct, task);
                    }
                });
            }
            t tVar = t.f3507a;
            if (zIsCompleted) {
                INSTANCE.completeImmediately(taskCompletionSource, continuation, this, executor, ct);
            }
            return taskCompletionSource.getTask();
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NotNull final Continuation<TResult, Task<TContinuationResult>> continuation, @NotNull final Executor executor, @Nullable final CancellationToken ct) {
        List<Continuation<TResult, Void>> list;
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        final com.facebook.bolts.TaskCompletionSource taskCompletionSource = new com.facebook.bolts.TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean zIsCompleted = isCompleted();
            if (!zIsCompleted && (list = this.continuations) != null) {
                list.add(new Continuation() { // from class: com.facebook.bolts.d
                    @Override // com.facebook.bolts.Continuation
                    public final Object then(Task task) {
                        return Task.m80continueWithTask$lambda12$lambda11(taskCompletionSource, continuation, executor, ct, task);
                    }
                });
            }
            t tVar = t.f3507a;
            if (zIsCompleted) {
                INSTANCE.completeAfterTask(taskCompletionSource, continuation, this, executor, ct);
            }
            return taskCompletionSource.getTask();
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@NotNull final Continuation<TResult, TContinuationResult> continuation, @NotNull Executor executor, @Nullable final CancellationToken ct) {
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.b
            @Override // com.facebook.bolts.Continuation
            public final Object then(Task task) {
                return Task.m82onSuccess$lambda13(ct, continuation, task);
            }
        }, executor);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NotNull final Continuation<TResult, Task<TContinuationResult>> continuation, @NotNull Executor executor, @Nullable final CancellationToken ct) {
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.f
            @Override // com.facebook.bolts.Continuation
            public final Object then(Task task) {
                return Task.m83onSuccessTask$lambda14(ct, continuation, task);
            }
        }, executor);
    }

    @NotNull
    public final Task<Void> continueWhile(@NotNull final Callable<Boolean> predicate, @NotNull final Continuation<Void, Task<Void>> continuation, @NotNull final Executor executor, @Nullable final CancellationToken ct) {
        s.e(predicate, "predicate");
        s.e(continuation, "continuation");
        s.e(executor, "executor");
        return makeVoid().continueWithTask((Continuation<Void, Task<TContinuationResult>>) new Continuation<Void, Task<Void>>() { // from class: com.facebook.bolts.Task$continueWhile$predicateContinuation$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.bolts.Continuation
            @NotNull
            public Task<Void> then(@NotNull Task<Void> task) throws Exception {
                s.e(task, "task");
                CancellationToken cancellationToken = ct;
                if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                    return Task.INSTANCE.cancelled();
                }
                Boolean boolCall = predicate.call();
                s.d(boolCall, "predicate.call()");
                return boolCall.booleanValue() ? Task.INSTANCE.forResult(null).onSuccessTask(continuation, executor).onSuccessTask(this, executor) : Task.INSTANCE.forResult(null);
            }
        }, executor);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@NotNull Continuation<TResult, TContinuationResult> continuation) {
        s.e(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NotNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        s.e(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR);
    }

    private Task(TResult tresult) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
        trySetResult(tresult);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@NotNull Continuation<TResult, TContinuationResult> continuation, @Nullable CancellationToken ct) {
        s.e(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, ct);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NotNull Continuation<TResult, Task<TContinuationResult>> continuation, @Nullable CancellationToken ct) {
        s.e(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR, ct);
    }

    public final boolean waitForCompletion(long duration, @NotNull TimeUnit timeUnit) throws InterruptedException {
        s.e(timeUnit, "timeUnit");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await(duration, timeUnit);
            }
            return isCompleted();
        } finally {
            reentrantLock.unlock();
        }
    }

    private Task(boolean z2) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
        if (z2) {
            trySetCancelled();
        } else {
            trySetResult(null);
        }
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NotNull Continuation<TResult, TContinuationResult> continuation) {
        s.e(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NotNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        s.e(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NotNull Continuation<TResult, TContinuationResult> continuation, @Nullable CancellationToken ct) {
        s.e(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, ct);
    }

    @NotNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NotNull Continuation<TResult, Task<TContinuationResult>> continuation, @Nullable CancellationToken ct) {
        s.e(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, ct);
    }
}
