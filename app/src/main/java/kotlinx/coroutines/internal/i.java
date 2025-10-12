package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: FastServiceLoader.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J*\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J3\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/i;", "", "S", "Ljava/lang/Class;", "service", "Ljava/lang/ClassLoader;", "loader", "", "b", "", "name", "a", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/net/URL;", "url", "e", "Ljava/io/BufferedReader;", "r", "f", "Lkotlinx/coroutines/internal/s;", "c", "()Ljava/util/List;", "d", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f3821a = new i();

    private i() {
    }

    private final <S> S a(String name, ClassLoader loader, Class<S> service) throws ClassNotFoundException {
        Class<?> cls = Class.forName(name, false, loader);
        if (service.isAssignableFrom(cls)) {
            return service.cast(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + service + ", but found " + cls).toString());
    }

    private final <S> List<S> b(Class<S> service, ClassLoader loader) {
        try {
            return d(service, loader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.V(ServiceLoader.load(service, loader));
        }
    }

    private final List<String> e(URL url) throws IOException {
        BufferedReader bufferedReader;
        String string = url.toString();
        if (!kotlin.text.s.u(string, "jar", false, 2, null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listF = f3821a.f(bufferedReader);
                kotlin.io.a.a(bufferedReader, null);
                return listF;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        String strO0 = StringsKt__StringsKt.o0(StringsKt__StringsKt.j0(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strJ0 = StringsKt__StringsKt.j0(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strO0, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strJ0)), "UTF-8"));
            try {
                List<String> listF2 = f3821a.f(bufferedReader);
                kotlin.io.a.a(bufferedReader, null);
                jarFile.close();
                return listF2;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    kotlin.b.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private final List<String> f(BufferedReader r2) throws IOException {
        boolean z2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = r2.readLine();
            if (line == null) {
                return CollectionsKt___CollectionsKt.V(linkedHashSet);
            }
            String string = StringsKt__StringsKt.q0(StringsKt__StringsKt.p0(line, "#", null, 2, null)).toString();
            int i2 = 0;
            while (true) {
                if (i2 >= string.length()) {
                    z2 = true;
                    break;
                }
                char cCharAt = string.charAt(i2);
                i2++;
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                throw new IllegalArgumentException(kotlin.jvm.internal.s.m("Illegal service provider class name: ", string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }

    @NotNull
    public final List<s> c() {
        s sVar;
        if (!j.a()) {
            return b(s.class, s.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            s sVar2 = null;
            try {
                sVar = (s) s.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, s.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                sVar = null;
            }
            if (sVar != null) {
                arrayList.add(sVar);
            }
            try {
                sVar2 = (s) s.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, s.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (sVar2 == null) {
                return arrayList;
            }
            arrayList.add(sVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(s.class, s.class.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> d(@NotNull Class<S> service, @NotNull ClassLoader loader) {
        ArrayList list = Collections.list(loader.getResources(kotlin.jvm.internal.s.m("META-INF/services/", service.getName())));
        kotlin.jvm.internal.s.d(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.r(arrayList, f3821a.e((URL) it.next()));
        }
        Set setZ = CollectionsKt___CollectionsKt.Z(arrayList);
        if (!(!setZ.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.v.o(setZ, 10));
        Iterator it2 = setZ.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f3821a.a((String) it2.next(), loader, service));
        }
        return arrayList2;
    }
}
