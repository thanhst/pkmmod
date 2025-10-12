package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import p0.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r*\f\b\u0002\u0010\u000f\"\u00020\u000e2\u00020\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlin/sequences/f;", "Lkotlin/coroutines/c;", "Lkotlin/t;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlin/sequences/d;", "b", "(Lp0/p;)Lkotlin/sequences/d;", "", "a", "(Lp0/p;)Ljava/util/Iterator;", "", "State", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/h$a", "Lkotlin/sequences/d;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f3501a;

        public a(p pVar) {
            this.f3501a = pVar;
        }

        @Override // kotlin.sequences.d
        @NotNull
        public Iterator<T> iterator() {
            return h.a(this.f3501a);
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Iterator<T> a(@BuilderInference @NotNull p<? super f<? super T>, ? super kotlin.coroutines.c<? super t>, ? extends Object> block) {
        s.e(block, "block");
        e eVar = new e();
        eVar.h(IntrinsicsKt__IntrinsicsJvmKt.b(block, eVar, eVar));
        return eVar;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> d<T> b(@BuilderInference @NotNull p<? super f<? super T>, ? super kotlin.coroutines.c<? super t>, ? extends Object> block) {
        s.e(block, "block");
        return new a(block);
    }
}
