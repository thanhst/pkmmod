package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J`\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR1\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001c\u0010 ¨\u0006$"}, d2 = {"Lkotlinx/coroutines/v;", "", "Lkotlinx/coroutines/l;", "cont", "", "cause", "Lkotlin/t;", "d", "result", "Lkotlinx/coroutines/i;", "cancelHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "idempotentResume", "cancelCause", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "b", "Lkotlinx/coroutines/i;", "c", "Lp0/l;", "e", "Ljava/lang/Throwable;", "()Z", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/i;Lp0/l;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* renamed from: kotlinx.coroutines.v, reason: from toString */
/* loaded from: classes.dex */
final /* data */ class CompletedContinuation {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @Nullable
    public final Object result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @Nullable
    public final i cancelHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @Nullable
    public final p0.l<Throwable, kotlin.t> onCancellation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @Nullable
    public final Object idempotentResume;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @Nullable
    public final Throwable cancelCause;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(@Nullable Object obj, @Nullable i iVar, @Nullable p0.l<? super Throwable, kotlin.t> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        this.result = obj;
        this.cancelHandler = iVar;
        this.onCancellation = lVar;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static /* synthetic */ CompletedContinuation b(CompletedContinuation completedContinuation, Object obj, i iVar, p0.l lVar, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i2 & 2) != 0) {
            iVar = completedContinuation.cancelHandler;
        }
        i iVar2 = iVar;
        if ((i2 & 4) != 0) {
            lVar = completedContinuation.onCancellation;
        }
        p0.l lVar2 = lVar;
        if ((i2 & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return completedContinuation.a(obj, iVar2, lVar2, obj4, th);
    }

    @NotNull
    public final CompletedContinuation a(@Nullable Object obj, @Nullable i iVar, @Nullable p0.l<? super Throwable, kotlin.t> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        return new CompletedContinuation(obj, iVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.cancelCause != null;
    }

    public final void d(@NotNull l<?> lVar, @NotNull Throwable th) {
        i iVar = this.cancelHandler;
        if (iVar != null) {
            lVar.j(iVar, th);
        }
        p0.l<Throwable, kotlin.t> lVar2 = this.onCancellation;
        if (lVar2 == null) {
            return;
        }
        lVar.l(lVar2, th);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) other;
        return kotlin.jvm.internal.s.a(this.result, completedContinuation.result) && kotlin.jvm.internal.s.a(this.cancelHandler, completedContinuation.cancelHandler) && kotlin.jvm.internal.s.a(this.onCancellation, completedContinuation.onCancellation) && kotlin.jvm.internal.s.a(this.idempotentResume, completedContinuation.idempotentResume) && kotlin.jvm.internal.s.a(this.cancelCause, completedContinuation.cancelCause);
    }

    public int hashCode() {
        Object obj = this.result;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.cancelHandler;
        int iHashCode2 = (iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        p0.l<Throwable, kotlin.t> lVar = this.onCancellation;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, i iVar, p0.l lVar, Object obj2, Throwable th, int i2, kotlin.jvm.internal.o oVar) {
        this(obj, (i2 & 2) != 0 ? null : iVar, (i2 & 4) != 0 ? null : lVar, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}
