package kotlin.sequences;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.z;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.random.Random;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p_p0;

/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"T", "Lkotlin/sequences/f;", "Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements p_p0<f<Object>, c<? super t>, Object> {
    final /* synthetic */ Random $random;
    final /* synthetic */ d<Object> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(d<Object> dVar, Random random, kotlin.coroutines.c<? super SequencesKt__SequencesKt$shuffled$1> cVar) {
        super(2, cVar);
        this.$this_shuffled = dVar;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<t> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, cVar);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // p0.p
    @Nullable
    public final Object invoke(@NotNull f<Object> fVar, @Nullable kotlin.coroutines.c<? super t> cVar) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(fVar, cVar)).invokeSuspend(t.f3507a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List listM;
        f fVar;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.h.b(obj);
            f fVar2 = (f) this.L$0;
            listM = k.m(this.$this_shuffled);
            fVar = fVar2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            listM = (List) this.L$1;
            fVar = (f) this.L$0;
            kotlin.h.b(obj);
        }
        while (!listM.isEmpty()) {
            int iNextInt = this.$random.nextInt(listM.size());
            Object objT = z.t(listM);
            if (iNextInt < listM.size()) {
                objT = listM.set(iNextInt, objT);
            }
            this.L$0 = fVar;
            this.L$1 = listM;
            this.label = 1;
            if (fVar.a(objT, this) == objD) {
                return objD;
            }
        }
        return t.f3507a;
    }
}
