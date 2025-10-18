package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import p0.l_p0;
import p0.p_p0;

/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@"}, d2 = {"T", "C", "R", "Lkotlin/sequences/f;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
/* loaded from: classes.dex */
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements p_p0<f<Object>, c<? super t>, Object> {
    final /* synthetic */ l_p0<Object, Iterator<Object>> $iterator;
    final /* synthetic */ d<Object> $source;
    final /* synthetic */ p_p0<Integer, Object, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$flatMapIndexed$1(d<Object> dVar, p_p0<? super Integer, Object, Object> pP0Var, l_p0<Object, ? extends Iterator<Object>> lP0Var, kotlin.coroutines.c<? super SequencesKt__SequencesKt$flatMapIndexed$1> cVar) {
        super(2, cVar);
        this.$source = dVar;
        this.$transform = pP0Var;
        this.$iterator = lP0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, cVar);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull f<Object> fVar, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(fVar, cVar)).invokeSuspend(t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i2;
        Iterator<Object> it;
        f fVar;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i3 = this.label;
        if (i3 == 0) {
            kotlin.h.b(obj);
            f fVar2 = (f) this.L$0;
            i2 = 0;
            it = this.$source.iterator();
            fVar = fVar2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.I$0;
            it = (Iterator) this.L$1;
            fVar = (f) this.L$0;
            kotlin.h.b(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            p_p0<Integer, Object, Object> pP0Var = this.$transform;
            int i4 = i2 + 1;
            if (i2 < 0) {
                u.n();
            }
            Iterator<Object> itInvoke = this.$iterator.invoke(pP0Var.invoke(kotlin.coroutines.jvm.internal.a.b(i2), next));
            this.L$0 = fVar;
            this.L$1 = it;
            this.I$0 = i4;
            this.label = 1;
            if (fVar.b(itInvoke, this) == objD) {
                return objD;
            }
            i2 = i4;
        }
        return t.f3507a;
    }
}
