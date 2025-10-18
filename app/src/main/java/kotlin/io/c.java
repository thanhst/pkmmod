package kotlin.io;

import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.l_p0;
import p0.p_p0;

/* compiled from: FileTreeWalk.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0005\t\u000eB\u008b\u0001\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f\u00128\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010!J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fRF\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001d¨\u0006\""}, d2 = {"Lkotlin/io/c;", "Lkotlin/sequences/d;", "Ljava/io/File;", "", "iterator", "a", "Ljava/io/File;", "start", "Lkotlin/io/FileWalkDirection;", "b", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/Function1;", "", "c", "Lp0/l;", "onEnter", "Lkotlin/t;", "d", "onLeave", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "Lp0/p;", "onFail", "", "I", "maxDepth", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lp0/l;Lp0/l;Lp0/p;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class c implements kotlin.sequences.d<File> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final File start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileWalkDirection direction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final l_p0<File, Boolean> onEnter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final l_p0<File, t> onLeave;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final p_p0<File, IOException, t> onFail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int maxDepth;

    /* compiled from: FileTreeWalk.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/c$a;", "Lkotlin/io/c$c;", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    private static abstract class a extends AbstractC0059c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull File rootDir) {
            super(rootDir);
            s.e(rootDir, "rootDir");
        }
    }

    /* compiled from: FileTreeWalk.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\b\u0010\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0082\u0010J\b\u0010\b\u001a\u00020\u0007H\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lkotlin/io/c$b;", "Lkotlin/collections/a;", "Ljava/io/File;", "root", "Lkotlin/io/c$a;", "e", "f", "Lkotlin/t;", "a", "Ljava/util/ArrayDeque;", "Lkotlin/io/c$c;", "g", "Ljava/util/ArrayDeque;", ServerProtocol.DIALOG_PARAM_STATE, "<init>", "(Lkotlin/io/c;)V", "b", "c", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    private final class b extends kotlin.collections.a<File> {

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayDeque<AbstractC0059c> state;

        /* compiled from: FileTreeWalk.kt */
        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005¨\u0006\u0014"}, d2 = {"Lkotlin/io/c$b$a;", "Lkotlin/io/c$a;", "Ljava/io/File;", "b", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "e", "failed", "rootDir", "<init>", "(Lkotlin/io/c$b;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        private final class a extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean rootVisited;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private File[] fileList;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int fileIndex;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private boolean failed;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f3414f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, File rootDir) {
                super(rootDir);
                s.e(rootDir, "rootDir");
                this.f3414f = bVar;
            }

            @Override // kotlin.io.c.AbstractC0059c
            @Nullable
            public File b() {
                if (!this.failed && this.fileList == null) {
                    l_p0 lP0Var = c.this.onEnter;
                    boolean z2 = false;
                    if (lP0Var != null && !((Boolean) lP0Var.invoke(getRoot())).booleanValue()) {
                        z2 = true;
                    }
                    if (z2) {
                        return null;
                    }
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.fileList = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        p_p0 pP0Var = c.this.onFail;
                        if (pP0Var != null) {
                            pP0Var.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.failed = true;
                    }
                }
                File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i2 = this.fileIndex;
                    s.b(fileArr);
                    if (i2 < fileArr.length) {
                        File[] fileArr2 = this.fileList;
                        s.b(fileArr2);
                        int i3 = this.fileIndex;
                        this.fileIndex = i3 + 1;
                        return fileArr2[i3];
                    }
                }
                if (!this.rootVisited) {
                    this.rootVisited = true;
                    return getRoot();
                }
                l_p0 lP0Var2 = c.this.onLeave;
                if (lP0Var2 != null) {
                    lP0Var2.invoke(getRoot());
                }
                return null;
            }
        }

        /* compiled from: FileTreeWalk.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005¨\u0006\n"}, d2 = {"Lkotlin/io/c$b$b;", "Lkotlin/io/c$c;", "Ljava/io/File;", "b", "", "Z", "visited", "rootFile", "<init>", "(Lkotlin/io/c$b;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* renamed from: kotlin.io.c$b$b, reason: collision with other inner class name */
        private final class C0057b extends AbstractC0059c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean visited;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f3416c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0057b(@NotNull b bVar, File rootFile) {
                super(rootFile);
                s.e(rootFile, "rootFile");
                this.f3416c = bVar;
            }

            @Override // kotlin.io.c.AbstractC0059c
            @Nullable
            public File b() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return getRoot();
            }
        }

        /* compiled from: FileTreeWalk.kt */
        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lkotlin/io/c$b$c;", "Lkotlin/io/c$a;", "Ljava/io/File;", "b", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "rootDir", "<init>", "(Lkotlin/io/c$b;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* renamed from: kotlin.io.c$b$c, reason: collision with other inner class name */
        private final class C0058c extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean rootVisited;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private File[] fileList;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int fileIndex;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f3420e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0058c(@NotNull b bVar, File rootDir) {
                super(rootDir);
                s.e(rootDir, "rootDir");
                this.f3420e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
            
                if (r0.length == 0) goto L33;
             */
            @Override // kotlin.io.c.AbstractC0059c
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.rootVisited
                    r1 = 0
                    if (r0 != 0) goto L2c
                    kotlin.io.c$b r0 = r10.f3420e
                    kotlin.io.c r0 = kotlin.io.c.this
                    p0.l r0 = kotlin.io.c.c(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L22
                    java.io.File r4 = r10.getRoot()
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L22
                    r2 = 1
                L22:
                    if (r2 == 0) goto L25
                    return r1
                L25:
                    r10.rootVisited = r3
                    java.io.File r0 = r10.getRoot()
                    return r0
                L2c:
                    java.io.File[] r0 = r10.fileList
                    if (r0 == 0) goto L4b
                    int r2 = r10.fileIndex
                    kotlin.jvm.internal.s.b(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L39
                    goto L4b
                L39:
                    kotlin.io.c$b r0 = r10.f3420e
                    kotlin.io.c r0 = kotlin.io.c.this
                    p0.l r0 = kotlin.io.c.e(r0)
                    if (r0 == 0) goto L4a
                    java.io.File r2 = r10.getRoot()
                    r0.invoke(r2)
                L4a:
                    return r1
                L4b:
                    java.io.File[] r0 = r10.fileList
                    if (r0 != 0) goto L97
                    java.io.File r0 = r10.getRoot()
                    java.io.File[] r0 = r0.listFiles()
                    r10.fileList = r0
                    if (r0 != 0) goto L7b
                    kotlin.io.c$b r0 = r10.f3420e
                    kotlin.io.c r0 = kotlin.io.c.this
                    p0.p r0 = kotlin.io.c.d(r0)
                    if (r0 == 0) goto L7b
                    java.io.File r2 = r10.getRoot()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.getRoot()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L7b:
                    java.io.File[] r0 = r10.fileList
                    if (r0 == 0) goto L85
                    kotlin.jvm.internal.s.b(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L97
                L85:
                    kotlin.io.c$b r0 = r10.f3420e
                    kotlin.io.c r0 = kotlin.io.c.this
                    p0.l r0 = kotlin.io.c.e(r0)
                    if (r0 == 0) goto L96
                    java.io.File r2 = r10.getRoot()
                    r0.invoke(r2)
                L96:
                    return r1
                L97:
                    java.io.File[] r0 = r10.fileList
                    kotlin.jvm.internal.s.b(r0)
                    int r1 = r10.fileIndex
                    int r2 = r1 + 1
                    r10.fileIndex = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.c.b.C0058c.b():java.io.File");
            }
        }

        /* compiled from: FileTreeWalk.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class d {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3421a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                f3421a = iArr;
            }
        }

        public b() {
            ArrayDeque<AbstractC0059c> arrayDeque = new ArrayDeque<>();
            this.state = arrayDeque;
            if (c.this.start.isDirectory()) {
                arrayDeque.push(e(c.this.start));
            } else if (c.this.start.isFile()) {
                arrayDeque.push(new C0057b(this, c.this.start));
            } else {
                b();
            }
        }

        private final a e(File root) {
            int i2 = d.f3421a[c.this.direction.ordinal()];
            if (i2 == 1) {
                return new C0058c(this, root);
            }
            if (i2 == 2) {
                return new a(this, root);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File f() {
            File fileB;
            while (true) {
                AbstractC0059c abstractC0059cPeek = this.state.peek();
                if (abstractC0059cPeek == null) {
                    return null;
                }
                fileB = abstractC0059cPeek.b();
                if (fileB == null) {
                    this.state.pop();
                } else {
                    if (s.a(fileB, abstractC0059cPeek.getRoot()) || !fileB.isDirectory() || this.state.size() >= c.this.maxDepth) {
                        break;
                    }
                    this.state.push(e(fileB));
                }
            }
            return fileB;
        }

        @Override // kotlin.collections.a
        protected void a() {
            File fileF = f();
            if (fileF != null) {
                c(fileF);
            } else {
                b();
            }
        }
    }

    /* compiled from: FileTreeWalk.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlin/io/c$c;", "", "Ljava/io/File;", "b", "a", "Ljava/io/File;", "()Ljava/io/File;", "root", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kotlin.io.c$c, reason: collision with other inner class name */
    private static abstract class AbstractC0059c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final File root;

        public AbstractC0059c(@NotNull File root) {
            s.e(root, "root");
            this.root = root;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final File getRoot() {
            return this.root;
        }

        @Nullable
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c(File file, FileWalkDirection fileWalkDirection, l_p0<? super File, Boolean> lP0Var, l_p0<? super File, t> lP0Var2, p_p0<? super File, ? super IOException, t> pP0Var, int i2) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = lP0Var;
        this.onLeave = lP0Var2;
        this.onFail = pP0Var;
        this.maxDepth = i2;
    }

    @Override // kotlin.sequences.d
    @NotNull
    public Iterator<File> iterator() {
        return new b();
    }

    /* synthetic */ c(File file, FileWalkDirection fileWalkDirection, l_p0 lP0Var, l_p0 lP0Var2, p_p0 pP0Var, int i2, int i3, o oVar) {
        this(file, (i3 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, lP0Var, lP0Var2, pP0Var, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull File start, @NotNull FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        s.e(start, "start");
        s.e(direction, "direction");
    }
}
