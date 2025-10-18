package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import s0.f_s0;
import s0.l_s0;

/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u001a\u001e\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002\u001a\u0014\u0010\u000f\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"", "Lkotlin/text/f;", "", "j", "Ljava/util/regex/Matcher;", "from", "", "input", "Lkotlin/text/i;", "f", "g", "Ljava/util/regex/MatchResult;", "Ls0/f;", "h", "groupIndex", "i", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i f(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f_s0 h(MatchResult matchResult) {
        return l_s0.h(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f_s0 i(MatchResult matchResult, int i2) {
        return l_s0.h(matchResult.start(i2), matchResult.end(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable<? extends f> iterable) {
        Iterator<? extends f> it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }
}
