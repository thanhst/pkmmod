package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewGroup.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroid/view/ViewGroup;", "Lkotlin/sequences/d;", "Landroid/view/View;", "a", "(Landroid/view/ViewGroup;)Lkotlin/sequences/d;", "descendants", "core-ktx_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class ViewGroupKt {
    @NotNull
    public static final kotlin.sequences.d<View> a(@NotNull ViewGroup viewGroup) {
        kotlin.jvm.internal.s.e(viewGroup, "<this>");
        return kotlin.sequences.h.b(new ViewGroupKt$descendants$1(viewGroup, null));
    }
}
