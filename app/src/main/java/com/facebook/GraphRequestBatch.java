package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GraphRequestBatch.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003A@BB\t\b\u0016¢\u0006\u0004\b9\u0010:B\u0017\b\u0016\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020;¢\u0006\u0004\b9\u0010<B\u001d\b\u0016\u0012\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020=\"\u00020\u0002¢\u0006\u0004\b9\u0010>B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020\u0000¢\u0006\u0004\b9\u0010?J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0019\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\u0017\u001a\u00020\u0006R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R0\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R0\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R$\u0010.\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%\"\u0004\b0\u00101R$\u00106\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00103¨\u0006C"}, d2 = {"Lcom/facebook/GraphRequestBatch;", "Ljava/util/AbstractList;", "Lcom/facebook/GraphRequest;", "", "Lcom/facebook/GraphResponse;", "executeAndWaitImpl", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsyncImpl", "Lcom/facebook/GraphRequestBatch$Callback;", "callback", "Lkotlin/t;", "addCallback", "removeCallback", "element", "", "add", "", "index", "clear", "get", "removeAt", "set", "executeAndWait", "executeAsync", "Landroid/os/Handler;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "timeoutInMilliseconds", "I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "<set-?>", "requests", "Ljava/util/List;", "getRequests", "()Ljava/util/List;", "callbacks", "getCallbacks", "batchApplicationId", "getBatchApplicationId", "setBatchApplicationId", "(Ljava/lang/String;)V", "getTimeout", "()I", "setTimeout", "(I)V", "timeout", "getSize", "size", "<init>", "()V", "", "(Ljava/util/Collection;)V", "", "([Lcom/facebook/GraphRequest;)V", "(Lcom/facebook/GraphRequestBatch;)V", "Companion", "Callback", "OnProgressCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GraphRequestBatch extends AbstractList<GraphRequest> {

    @NotNull
    private static final AtomicInteger idGenerator = new AtomicInteger();

    @Nullable
    private String batchApplicationId;

    @Nullable
    private Handler callbackHandler;

    @NotNull
    private List<Callback> callbacks;

    @NotNull
    private final String id;

    @NotNull
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    /* compiled from: GraphRequestBatch.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequestBatch$Callback;", "", "Lcom/facebook/GraphRequestBatch;", "batch", "Lkotlin/t;", "onBatchCompleted", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Callback {
        void onBatchCompleted(@NotNull GraphRequestBatch graphRequestBatch);
    }

    /* compiled from: GraphRequestBatch.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/facebook/GraphRequestBatch$OnProgressCallback;", "Lcom/facebook/GraphRequestBatch$Callback;", "Lcom/facebook/GraphRequestBatch;", "batch", "", "current", "max", "Lkotlin/t;", "onBatchProgress", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface OnProgressCallback extends Callback {
        void onBatchProgress(@NotNull GraphRequestBatch graphRequestBatch, long j2, long j3);
    }

    public GraphRequestBatch() {
        this.id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    private final List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.INSTANCE.executeBatchAndWait(this);
    }

    private final GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.INSTANCE.executeBatchAsync(this);
    }

    public final void addCallback(@NotNull Callback callback) {
        kotlin.jvm.internal.s.e(callback, "callback");
        if (this.callbacks.contains(callback)) {
            return;
        }
        this.callbacks.add(callback);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.requests.clear();
    }

    public /* bridge */ boolean contains(GraphRequest graphRequest) {
        return super.contains((Object) graphRequest);
    }

    @NotNull
    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    @NotNull
    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    @Nullable
    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    @Nullable
    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    @NotNull
    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    public int getSize() {
        return this.requests.size();
    }

    /* renamed from: getTimeout, reason: from getter */
    public final int getTimeoutInMilliseconds() {
        return this.timeoutInMilliseconds;
    }

    public /* bridge */ int indexOf(GraphRequest graphRequest) {
        return super.indexOf((Object) graphRequest);
    }

    public /* bridge */ int lastIndexOf(GraphRequest graphRequest) {
        return super.lastIndexOf((Object) graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ GraphRequest remove(int i2) {
        return removeAt(i2);
    }

    @NotNull
    public GraphRequest removeAt(int index) {
        return this.requests.remove(index);
    }

    public final void removeCallback(@NotNull Callback callback) {
        kotlin.jvm.internal.s.e(callback, "callback");
        this.callbacks.remove(callback);
    }

    public final void setBatchApplicationId(@Nullable String str) {
        this.batchApplicationId = str;
    }

    public final void setCallbackHandler(@Nullable Handler handler) {
        this.callbackHandler = handler;
    }

    public final void setTimeout(int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.".toString());
        }
        this.timeoutInMilliseconds = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return contains((GraphRequest) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public GraphRequest get(int index) {
        return this.requests.get(index);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return indexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return lastIndexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public GraphRequest set(int index, @NotNull GraphRequest element) {
        kotlin.jvm.internal.s.e(element, "element");
        return this.requests.set(index, element);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(@NotNull GraphRequest element) {
        kotlin.jvm.internal.s.e(element, "element");
        return this.requests.add(element);
    }

    public /* bridge */ boolean remove(GraphRequest graphRequest) {
        return super.remove((Object) graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, @NotNull GraphRequest element) {
        kotlin.jvm.internal.s.e(element, "element");
        this.requests.add(i2, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return remove((GraphRequest) obj);
        }
        return false;
    }

    public GraphRequestBatch(@NotNull Collection<GraphRequest> requests) {
        kotlin.jvm.internal.s.e(requests, "requests");
        this.id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(requests);
    }

    public GraphRequestBatch(@NotNull GraphRequest... requests) {
        kotlin.jvm.internal.s.e(requests, "requests");
        this.id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(kotlin.collections.m.b(requests));
    }

    public GraphRequestBatch(@NotNull GraphRequestBatch requests) {
        kotlin.jvm.internal.s.e(requests, "requests");
        this.id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(requests);
        this.callbackHandler = requests.callbackHandler;
        this.timeoutInMilliseconds = requests.timeoutInMilliseconds;
        this.callbacks = new ArrayList(requests.callbacks);
    }
}
