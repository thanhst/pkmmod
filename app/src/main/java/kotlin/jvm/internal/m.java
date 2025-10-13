package kotlin.jvm.internal;

import com.adjust.sdk.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.k0;
import kotlin.collections.l0;
import kotlin.text.StringsKt__StringsKt;
import o0.a_o0;
import p0.a_p0;
import p0.b_p0;
import p0.c_p0;
import p0.d_p0;
import p0.e_p0;
import p0.f_p0;
import p0.g_p0;
import p0.h_p0;
import p0.i_p0;
import p0.j_p0;
import p0.k_p0;
import p0.l_p0;
import p0.m_p0;
import p0.n_p0;
import p0.o_p0;
import p0.p_p0;
import p0.q_p0;
import p0.r_p0;
import p0.s_p0;
import p0.t_p0;
import p0.u_p0;
import p0.v_p0;
import p0.w_p0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassReference.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0011B\u0013\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001e\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlin/jvm/internal/m;", "Lkotlin/reflect/c;", "", "Lkotlin/jvm/internal/l;", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/lang/Class;", "e", "Ljava/lang/Class;", "b", "()Ljava/lang/Class;", "jClass", "a", "()Ljava/lang/String;", "simpleName", "<init>", "(Ljava/lang/Class;)V", "f", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class m implements kotlin.reflect.c<Object>, l {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f3448g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f3449h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f3450i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f3451j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f3452k;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<?> jClass;

    /* compiled from: ClassReference.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002R,\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0002\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\n¨\u0006\u0014"}, d2 = {"Lkotlin/jvm/internal/m$a;", "", "Ljava/lang/Class;", "jClass", "", "a", "", "Lkotlin/c;", "", "FUNCTION_CLASSES", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "classFqNames", "Ljava/util/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kotlin.jvm.internal.m$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        @Nullable
        public final String a(@NotNull Class<?> jClass) {
            String str;
            s.e(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        s.d(name, "name");
                        String strJ0 = StringsKt__StringsKt.j0(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (strJ0 != null) {
                            return strJ0;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        s.d(name, "name");
                        return StringsKt__StringsKt.i0(name, '$', null, 2, null);
                    }
                    s.d(name, "name");
                    return StringsKt__StringsKt.j0(name, enclosingConstructor.getName() + '$', null, 2, null);
                }
                if (!jClass.isArray()) {
                    String str3 = (String) m.f3452k.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) m.f3452k.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
            }
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i2 = 0;
        List listK = kotlin.collections.u.k(a_p0.class, l_p0.class, p_p0.class, q_p0.class, r_p0.class, s_p0.class, t_p0.class, u_p0.class, v_p0.class, w_p0.class, b_p0.class, c_p0.class, d_p0.class, e_p0.class, f_p0.class, g_p0.class, h_p0.class, i_p0.class, j_p0.class, k_p0.class, m_p0.class, n_p0.class, o_p0.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.v.o(listK, 10));
        for (Object obj : listK) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.u.n();
            }
            arrayList.add(kotlin.j.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f3448g = l0.l(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put(Constants.LONG, "kotlin.Long");
        map.put("double", "kotlin.Double");
        f3449h = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f3450i = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        s.d(collectionValues, "primitiveFqNames.values");
        for (String kotlinName : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            s.d(kotlinName, "kotlinName");
            sb.append(StringsKt__StringsKt.l0(kotlinName, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair pairA = kotlin.j.a(sb.toString(), kotlinName + ".Companion");
            map3.put(pairA.getFirst(), pairA.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.c<?>>, Integer> entry : f3448g.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f3451j = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(k0.c(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.l0((String) entry2.getValue(), '.', null, 2, null));
        }
        f3452k = linkedHashMap;
    }

    public m(@NotNull Class<?> jClass) {
        s.e(jClass, "jClass");
        this.jClass = jClass;
    }

    @Override // kotlin.reflect.c
    @Nullable
    public String a() {
        return INSTANCE.a(b());
    }

    @Override // kotlin.jvm.internal.l
    @NotNull
    public Class<?> b() {
        return this.jClass;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof m) && s.a(a_o0.b(this), a_o0.b((kotlin.reflect.c) other));
    }

    public int hashCode() {
        return a_o0.b(this).hashCode();
    }

    @NotNull
    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
