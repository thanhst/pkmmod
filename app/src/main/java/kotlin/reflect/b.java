package kotlin.reflect;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KCallable.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\t\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH&¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0015\u001a\u0004\b \u0010\u001eR\u001a\u0010\"\u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0015\u001a\u0004\b\"\u0010\u001eR\u001a\u0010$\u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u001e¨\u0006&"}, d2 = {"Lkotlin/reflect/b;", "R", "Lkotlin/reflect/a;", "", "", "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "", "getParameters", "()Ljava/util/List;", "parameters", "Lkotlin/reflect/o;", "getReturnType", "()Lkotlin/reflect/o;", "returnType", "getTypeParameters", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public interface b<R> extends a {
    R call(@NotNull Object... args);

    R callBy(@NotNull Map<Object, ? extends Object> args);

    @NotNull
    List<Object> getParameters();

    @NotNull
    o getReturnType();

    @NotNull
    List<Object> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
