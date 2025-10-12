package c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ContextAwareHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f2756a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f2757b;

    public void a(@NonNull b bVar) {
        if (this.f2757b != null) {
            bVar.a(this.f2757b);
        }
        this.f2756a.add(bVar);
    }

    public void b() {
        this.f2757b = null;
    }

    public void c(@NonNull Context context) {
        this.f2757b = context;
        Iterator<b> it = this.f2756a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    @Nullable
    public Context d() {
        return this.f2757b;
    }

    public void e(@NonNull b bVar) {
        this.f2756a.remove(bVar);
    }
}
