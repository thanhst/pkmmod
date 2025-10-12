package android.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewTreeSavedStateRegistryOwner.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "Landroidx/savedstate/d;", "owner", "Lkotlin/t;", "a", "(Landroid/view/View;Landroidx/savedstate/d;)V", "savedstate_release"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ViewTreeSavedStateRegistryOwner")
/* renamed from: androidx.savedstate.e, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0080e {
    @JvmName(name = "set")
    public static final void a(@NotNull View view, @Nullable InterfaceC0079d interfaceC0079d) {
        s.e(view, "<this>");
        view.setTag(C0074R$id.view_tree_saved_state_registry_owner, interfaceC0079d);
    }
}
