package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import s0.f_s0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/i;", "next", "Ljava/util/regex/Matcher;", "a", "Ljava/util/regex/Matcher;", "matcher", "", "b", "Ljava/lang/CharSequence;", "input", "Lkotlin/text/h;", "c", "Lkotlin/text/h;", "getGroups", "()Lkotlin/text/h;", "groups", "Ljava/util/regex/MatchResult;", "()Ljava/util/regex/MatchResult;", "matchResult", "Ls0/f;", "()Ls0/f;", "range", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
final class MatcherMatchResult implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matcher matcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence input;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h groups;

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence input) {
        kotlin.jvm.internal.s.e(matcher, "matcher");
        kotlin.jvm.internal.s.e(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult c() {
        return this.matcher;
    }

    @Override // kotlin.text.i
    @NotNull
    public f_s0 a() {
        return j.h(c());
    }

    @Override // kotlin.text.i
    @Nullable
    public i next() {
        int iEnd = c().end() + (c().end() == c().start() ? 1 : 0);
        if (iEnd > this.input.length()) {
            return null;
        }
        Matcher matcher = this.matcher.pattern().matcher(this.input);
        kotlin.jvm.internal.s.d(matcher, "matcher.pattern().matcher(input)");
        return j.f(matcher, iEnd, this.input);
    }
}
