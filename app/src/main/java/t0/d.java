package t0;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.s;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

/* compiled from: DurationUnitJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¨\u0006\u0006"}, d2 = {"", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "a", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes.dex */
class d {
    @SinceKotlin(version = "1.5")
    public static final long a(long j2, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        s.e(sourceUnit, "sourceUnit");
        s.e(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j2, sourceUnit.getTimeUnit());
    }
}
