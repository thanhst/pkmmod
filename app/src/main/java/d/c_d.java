package d;

import android.content.Context;
import android.content.Intent;
import android.view.result.ActivityResult;
import kotlin.Metadata;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityResultContracts.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Ld/c;", "Ld/a;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "Landroid/content/Context;", "context", "input", "createIntent", "", "resultCode", "intent", "a", "<init>", "()V", "activity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class c_d extends a_d<Intent, ActivityResult> {
    @Override // d.a
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ActivityResult parseResult(int resultCode, @Nullable Intent intent) {
        return new ActivityResult(resultCode, intent);
    }

    @Override // d.a
    @NotNull
    public Intent createIntent(@NotNull Context context, @NotNull Intent input) {
        s.e(context, "context");
        s.e(input, "input");
        return input;
    }
}
