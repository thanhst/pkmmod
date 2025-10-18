package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import p0.l_p0;
import s0.f_s0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H\u0096\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/g;", "", "isEmpty", "", "iterator", "", "index", "c", "a", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements h {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f3511e;

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f3511e = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: a */
    public int getSize() {
        return this.f3511e.c().groupCount() + 1;
    }

    public /* bridge */ boolean b(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    @Nullable
    public MatchGroup c(int index) {
        f_s0 fS0VarI = j.i(this.f3511e.c(), index);
        if (fS0VarI.h().intValue() < 0) {
            return null;
        }
        String strGroup = this.f3511e.c().group(index);
        kotlin.jvm.internal.s.d(strGroup, "matchResult.group(index)");
        return new MatchGroup(strGroup, fS0VarI);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return b((MatchGroup) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<MatchGroup> iterator() {
        return kotlin.sequences.k.j(CollectionsKt___CollectionsKt.v(kotlin.collections.u.i(this)), new l_p0<Integer, MatchGroup>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @Override // p0.l
            public /* bridge */ /* synthetic */ MatchGroup invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final MatchGroup invoke(int i2) {
                return this.this$0.c(i2);
            }
        }).iterator();
    }
}
