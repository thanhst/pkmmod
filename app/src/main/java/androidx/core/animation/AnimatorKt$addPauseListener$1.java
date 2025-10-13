package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import p0.l_p0;

/* compiled from: Animator.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/animation/Animator;", "it", "Lkotlin/t;", "invoke", "(Landroid/animation/Animator;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class AnimatorKt$addPauseListener$1 extends Lambda implements l_p0<Animator, t> {
    public static final AnimatorKt$addPauseListener$1 INSTANCE = new AnimatorKt$addPauseListener$1();

    AnimatorKt$addPauseListener$1() {
        super(1);
    }

    @Override // p0.l
    public /* bridge */ /* synthetic */ t invoke(Animator animator) {
        invoke2(animator);
        return t.f3507a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Animator it) {
        s.e(it, "it");
    }
}
