package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import com.facebook.bolts.AppLinks;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewModelProvider.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0006\n\u0013\u001bB#\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017B\u0019\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u001aJ(\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0097\u0002¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0097\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/b0;", "", "Landroidx/lifecycle/a0;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/a0;", "", "key", "b", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/a0;", "Landroidx/lifecycle/e0;", "Landroidx/lifecycle/e0;", "store", "Landroidx/lifecycle/b0$b;", "Landroidx/lifecycle/b0$b;", "factory", "Ls/a;", "c", "Ls/a;", "defaultCreationExtras", "<init>", "(Landroidx/lifecycle/e0;Landroidx/lifecycle/b0$b;Ls/a;)V", "Landroidx/lifecycle/f0;", "owner", "(Landroidx/lifecycle/f0;Landroidx/lifecycle/b0$b;)V", "d", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e0 store;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b factory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final s.a defaultCreationExtras;

    /* compiled from: ViewModelProvider.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/b0$b;", "", "Landroidx/lifecycle/a0;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/a0;", "Ls/a;", AppLinks.KEY_NAME_EXTRAS, "b", "(Ljava/lang/Class;Ls/a;)Landroidx/lifecycle/a0;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
    public interface b {
        @NotNull
        <T extends a0> T a(@NotNull Class<T> modelClass);

        @NotNull
        <T extends a0> T b(@NotNull Class<T> modelClass, @NotNull s.a extras);
    }

    /* compiled from: ViewModelProvider.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/lifecycle/b0$c;", "Landroidx/lifecycle/b0$b;", "Landroidx/lifecycle/a0;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/a0;", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
    public static class c implements b {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private static c f2444b;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final a.b<String> f2445c = Companion.C0034a.f2446a;

        /* compiled from: ViewModelProvider.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/b0$c$a;", "", "Landroidx/lifecycle/b0$c;", "a", "()Landroidx/lifecycle/b0$c;", "getInstance$annotations", "()V", "instance", "Ls/a$b;", "", "VIEW_MODEL_KEY", "Ls/a$b;", "sInstance", "Landroidx/lifecycle/b0$c;", "<init>", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
        /* renamed from: androidx.lifecycle.b0$c$a, reason: from kotlin metadata */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/b0$c$a$a;", "Ls/a$b;", "", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
            /* renamed from: androidx.lifecycle.b0$c$a$a, reason: collision with other inner class name */
            private static final class C0034a implements a.b<String> {

                /* renamed from: a, reason: collision with root package name */
                @NotNull
                public static final C0034a f2446a = new C0034a();

                private C0034a() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
                this();
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            @NotNull
            public final c a() {
                if (c.f2444b == null) {
                    c.f2444b = new c();
                }
                c cVar = c.f2444b;
                kotlin.jvm.internal.s.b(cVar);
                return cVar;
            }
        }

        @Override // androidx.lifecycle.b0.b
        @NotNull
        public <T extends a0> T a(@NotNull Class<T> modelClass) throws IllegalAccessException, InstantiationException {
            kotlin.jvm.internal.s.e(modelClass, "modelClass");
            try {
                T tNewInstance = modelClass.newInstance();
                kotlin.jvm.internal.s.d(tNewInstance, "{\n                modelC…wInstance()\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            }
        }

        @Override // androidx.lifecycle.b0.b
        public /* synthetic */ a0 b(Class cls, s.a aVar) {
            return c0.b(this, cls, aVar);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Landroidx/lifecycle/b0$d;", "", "Landroidx/lifecycle/a0;", "viewModel", "Lkotlin/t;", "c", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class d {
        public void c(@NotNull a0 viewModel) {
            kotlin.jvm.internal.s.e(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public b0(@NotNull e0 store, @NotNull b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.s.e(store, "store");
        kotlin.jvm.internal.s.e(factory, "factory");
    }

    @JvmOverloads
    public b0(@NotNull e0 store, @NotNull b factory, @NotNull s.a defaultCreationExtras) {
        kotlin.jvm.internal.s.e(store, "store");
        kotlin.jvm.internal.s.e(factory, "factory");
        kotlin.jvm.internal.s.e(defaultCreationExtras, "defaultCreationExtras");
        this.store = store;
        this.factory = factory;
        this.defaultCreationExtras = defaultCreationExtras;
    }

    @MainThread
    @NotNull
    public <T extends a0> T a(@NotNull Class<T> modelClass) {
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    @MainThread
    @NotNull
    public <T extends a0> T b(@NotNull String key, @NotNull Class<T> modelClass) {
        T t2;
        kotlin.jvm.internal.s.e(key, "key");
        kotlin.jvm.internal.s.e(modelClass, "modelClass");
        T viewModel = (T) this.store.b(key);
        if (!modelClass.isInstance(viewModel)) {
            s.d dVar = new s.d(this.defaultCreationExtras);
            dVar.c(c.f2445c, key);
            try {
                t2 = (T) this.factory.b(modelClass, dVar);
            } catch (AbstractMethodError unused) {
                t2 = (T) this.factory.a(modelClass);
            }
            this.store.d(key, t2);
            return t2;
        }
        Object obj = this.factory;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            kotlin.jvm.internal.s.d(viewModel, "viewModel");
            dVar2.c(viewModel);
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }

    /* compiled from: ViewModelProvider.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u000eB\u001b\b\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\t\b\u0016¢\u0006\u0004\b\u0015\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0018J/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/b0$a;", "Landroidx/lifecycle/b0$c;", "Landroidx/lifecycle/a0;", "T", "Ljava/lang/Class;", "modelClass", "Landroid/app/Application;", "app", "g", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/a0;", "Ls/a;", AppLinks.KEY_NAME_EXTRAS, "b", "(Ljava/lang/Class;Ls/a;)Landroidx/lifecycle/a0;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/a0;", "d", "Landroid/app/Application;", "application", "", "unused", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "e", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
    public static class a extends c {

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private static a f2439f;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Application application;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: g, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final a.b<Application> f2440g = Companion.C0033a.f2442a;

        /* compiled from: ViewModelProvider.kt */
        @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/b0$a$a;", "", "Landroid/app/Application;", "application", "Landroidx/lifecycle/b0$a;", "a", "Ls/a$b;", "APPLICATION_KEY", "Ls/a$b;", "", "DEFAULT_KEY", "Ljava/lang/String;", "sInstance", "Landroidx/lifecycle/b0$a;", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
        /* renamed from: androidx.lifecycle.b0$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/b0$a$a$a;", "Ls/a$b;", "Landroid/app/Application;", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0})
            /* renamed from: androidx.lifecycle.b0$a$a$a, reason: collision with other inner class name */
            private static final class C0033a implements a.b<Application> {

                /* renamed from: a, reason: collision with root package name */
                @NotNull
                public static final C0033a f2442a = new C0033a();

                private C0033a() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
                this();
            }

            @JvmStatic
            @NotNull
            public final a a(@NotNull Application application) {
                kotlin.jvm.internal.s.e(application, "application");
                if (a.f2439f == null) {
                    a.f2439f = new a(application);
                }
                a aVar = a.f2439f;
                kotlin.jvm.internal.s.b(aVar);
                return aVar;
            }
        }

        private a(Application application, int i2) {
            this.application = application;
        }

        private final <T extends a0> T g(Class<T> modelClass, Application app) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (!androidx.lifecycle.a.class.isAssignableFrom(modelClass)) {
                return (T) super.a(modelClass);
            }
            try {
                T tNewInstance = modelClass.getConstructor(Application.class).newInstance(app);
                kotlin.jvm.internal.s.d(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e5);
            }
        }

        @Override // androidx.lifecycle.b0.c, androidx.lifecycle.b0.b
        @NotNull
        public <T extends a0> T a(@NotNull Class<T> modelClass) {
            kotlin.jvm.internal.s.e(modelClass, "modelClass");
            Application application = this.application;
            if (application != null) {
                return (T) g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.b0.c, androidx.lifecycle.b0.b
        @NotNull
        public <T extends a0> T b(@NotNull Class<T> modelClass, @NotNull s.a extras) {
            kotlin.jvm.internal.s.e(modelClass, "modelClass");
            kotlin.jvm.internal.s.e(extras, "extras");
            if (this.application != null) {
                return (T) a(modelClass);
            }
            Application application = (Application) extras.a(f2440g);
            if (application != null) {
                return (T) g(modelClass, application);
            }
            if (androidx.lifecycle.a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.a(modelClass);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Application application) {
            this(application, 0);
            kotlin.jvm.internal.s.e(application, "application");
        }
    }

    public /* synthetic */ b0(e0 e0Var, b bVar, s.a aVar, int i2, kotlin.jvm.internal.o oVar) {
        this(e0Var, bVar, (i2 & 4) != 0 ? a.C0069a.f4091b : aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b0(@NotNull f0 owner, @NotNull b factory) {
        kotlin.jvm.internal.s.e(owner, "owner");
        kotlin.jvm.internal.s.e(factory, "factory");
        e0 viewModelStore = owner.getViewModelStore();
        kotlin.jvm.internal.s.d(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, factory, d0.a(owner));
    }
}
