package android.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l;

/* compiled from: ViewTreeOnBackPressedDispatcherOwner.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Landroidx/activity/k;", "invoke", "(Landroid/view/View;)Landroidx/activity/k;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* renamed from: androidx.activity.ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2, reason: from Kotlin metadata */
/* loaded from: classes.dex */
final class View extends Lambda implements l<android.view.View, k> {
    public static final View INSTANCE = new View();

    View() {
        super(1);
    }

    @Override // p0.l
    @Nullable
    public final k invoke(@NotNull android.view.View it) {
        s.e(it, "it");
        Object tag = it.getTag(R$id.view_tree_on_back_pressed_dispatcher_owner);
        if (tag instanceof k) {
            return (k) tag;
        }
        return null;
    }
}
