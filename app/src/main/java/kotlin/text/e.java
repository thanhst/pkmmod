package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import p0.p_p0;
import s0.f_s0;
import s0.l_s0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Strings.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B[\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012:\u0010\u0017\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00130\u000f¢\u0006\u0002\b\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bRH\u0010\u0017\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00130\u000f¢\u0006\u0002\b\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lkotlin/text/e;", "Lkotlin/sequences/d;", "Ls0/f;", "", "iterator", "", "a", "Ljava/lang/CharSequence;", "input", "", "b", "I", "startIndex", "c", "limit", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "d", "Lp0/p;", "getNextMatch", "<init>", "(Ljava/lang/CharSequence;IILp0/p;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class e implements kotlin.sequences.d<f_s0> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence input;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int startIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int limit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p_p0<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;

    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006#"}, d2 = {"kotlin/text/e$a", "", "Ls0/f;", "Lkotlin/t;", "a", "b", "", "hasNext", "", "e", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "f", "getCurrentStartIndex", "setCurrentStartIndex", "currentStartIndex", "g", "getNextSearchIndex", "setNextSearchIndex", "nextSearchIndex", "h", "Ls0/f;", "getNextItem", "()Ls0/f;", "setNextItem", "(Ls0/f;)V", "nextItem", "i", "getCounter", "setCounter", "counter", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class a_q0 implements Iterator<f_s0>, q0.a_q0 {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int nextState = -1;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int currentStartIndex;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int nextSearchIndex;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private f_s0 nextItem;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int counter;

        a_q0() {
            int iE = l_s0.e(e.this.startIndex, 0, e.this.input.length());
            this.currentStartIndex = iE;
            this.nextSearchIndex = iE;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.nextSearchIndex
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.nextState = r1
                r0 = 0
                r6.nextItem = r0
                goto L9e
            Lc:
                kotlin.text.e r0 = kotlin.text.e.this
                int r0 = kotlin.text.e.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.counter
                int r0 = r0 + r3
                r6.counter = r0
                kotlin.text.e r4 = kotlin.text.e.this
                int r4 = kotlin.text.e.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.nextSearchIndex
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                s0.f r0 = new s0.f
                int r1 = r6.currentStartIndex
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.A(r4)
                r0.<init>(r1, r4)
                r6.nextItem = r0
                r6.nextSearchIndex = r2
                goto L9c
            L47:
                kotlin.text.e r0 = kotlin.text.e.this
                p0.p r0 = kotlin.text.e.a(r0)
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r5 = r6.nextSearchIndex
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                s0.f r0 = new s0.f
                int r1 = r6.currentStartIndex
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.A(r4)
                r0.<init>(r1, r4)
                r6.nextItem = r0
                r6.nextSearchIndex = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.currentStartIndex
                s0.f r4 = s0.j.h(r4, r2)
                r6.nextItem = r4
                int r2 = r2 + r0
                r6.currentStartIndex = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.nextSearchIndex = r2
            L9c:
                r6.nextState = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.a():void");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f_s0 next() {
            if (this.nextState == -1) {
                a_q0();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            f_s0 fS0Var = this.nextItem;
            kotlin.jvm.internal.s.c(fS0Var, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return fS0Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState == -1) {
                a_q0();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull CharSequence input, int i2, int i3, @NotNull p_p0<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.s.e(input, "input");
        kotlin.jvm.internal.s.e(getNextMatch, "getNextMatch");
        this.input = input;
        this.startIndex = i2;
        this.limit = i3;
        this.getNextMatch = getNextMatch;
    }

    @Override // kotlin.sequences.d
    @NotNull
    public Iterator<f_s0> iterator() {
        return new a_q0();
    }
}
