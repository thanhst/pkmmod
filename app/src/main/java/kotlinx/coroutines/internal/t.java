package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.q1;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainDispatchers.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/t;", "", "Lkotlinx/coroutines/q1;", "a", "", "b", "Z", "FAST_SERVICE_LOADER_ENABLED", "c", "Lkotlinx/coroutines/q1;", "dispatcher", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f3845a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean FAST_SERVICE_LOADER_ENABLED;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final q1 dispatcher;

    static {
        t tVar = new t();
        f3845a = tVar;
        FAST_SERVICE_LOADER_ENABLED = e0.e("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = tVar.a();
    }

    private t() {
    }

    private final q1 a() {
        Object next;
        try {
            List<s> listC = FAST_SERVICE_LOADER_ENABLED ? i.f3821a.c() : kotlin.sequences.k.l(SequencesKt__SequencesKt.c(ServiceLoader.load(s.class, s.class.getClassLoader()).iterator()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((s) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((s) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            s sVar = (s) next;
            q1 q1VarE = sVar == null ? null : u.e(sVar, listC);
            return q1VarE == null ? u.b(null, null, 3, null) : q1VarE;
        } catch (Throwable th) {
            return u.b(th, null, 2, null);
        }
    }
}
