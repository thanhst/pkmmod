package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0003R\u001a\u0010\t\u001a\u00020\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/j1;", "Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/u;", "", "K0", "f", "Z", "b0", "()Z", "handlesException", "c0", "onCancelComplete", "Lkotlinx/coroutines/h1;", "parent", "<init>", "(Lkotlinx/coroutines/h1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class j1 extends n1 implements u {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean handlesException;

    public j1(@Nullable h1 h1Var) {
        super(true);
        i0(h1Var);
        this.handlesException = K0();
    }

    private final boolean K0() {
        q qVarE0 = e0();
        r rVar = qVarE0 instanceof r ? (r) qVarE0 : null;
        n1 n1VarR = rVar == null ? null : rVar.R();
        if (n1VarR == null) {
            return false;
        }
        while (!n1VarR.getHandlesException()) {
            q qVarE02 = n1VarR.e0();
            r rVar2 = qVarE02 instanceof r ? (r) qVarE02 : null;
            n1VarR = rVar2 == null ? null : rVar2.R();
            if (n1VarR == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.n1
    /* renamed from: b0, reason: from getter */
    public boolean getHandlesException() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.n1
    public boolean c0() {
        return true;
    }
}
