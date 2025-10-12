package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AggregateException.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00102\u00060\u0001j\u0002`\u0002:\u0001\u0010B#\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/io/PrintStream;", "err", "Lkotlin/t;", "printStackTrace", "Ljava/io/PrintWriter;", "", "", "innerThrowables", "Ljava/util/List;", "", "detailMessage", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AggregateException extends Exception {
    private static final long serialVersionUID = 1;

    @NotNull
    private final List<Throwable> innerThrowables;

    public AggregateException(@Nullable String str, @Nullable List<? extends Throwable> list) {
        super(str, (list == null || !(list.isEmpty() ^ true)) ? null : list.get(0));
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(list == null ? u.h() : list);
        s.d(listUnmodifiableList, "unmodifiableList(innerThrowables ?: emptyList())");
        this.innerThrowables = listUnmodifiableList;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(@NotNull PrintStream err) {
        s.e(err, "err");
        super.printStackTrace(err);
        int i2 = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i2++;
            err.append((CharSequence) String.valueOf(i2));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(@NotNull PrintWriter err) {
        s.e(err, "err");
        super.printStackTrace(err);
        int i2 = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i2++;
            err.append((CharSequence) String.valueOf(i2));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }
}
