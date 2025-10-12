package android.view;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l;

/* compiled from: ViewTreeSavedStateRegistryOwner.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "Landroidx/savedstate/d;", "invoke", "(Landroid/view/View;)Landroidx/savedstate/d;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* renamed from: androidx.savedstate.ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
final class C0075x10fac0e3 extends Lambda implements l<View, InterfaceC0079d> {
    public static final C0075x10fac0e3 INSTANCE = new C0075x10fac0e3();

    C0075x10fac0e3() {
        super(1);
    }

    @Override // p0.l
    @Nullable
    public final InterfaceC0079d invoke(@NotNull View view) {
        s.e(view, "view");
        Object tag = view.getTag(C0074R$id.view_tree_saved_state_registry_owner);
        if (tag instanceof InterfaceC0079d) {
            return (InterfaceC0079d) tag;
        }
        return null;
    }
}
