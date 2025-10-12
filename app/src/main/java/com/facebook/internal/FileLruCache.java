package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: FileLruCache.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 /2\u00020\u0001:\b01/23456B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b-\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0087\u0002J\u001c\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010%\u001a\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010,\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00067"}, d2 = {"Lcom/facebook/internal/FileLruCache;", "", "", FileLruCache.HEADER_CACHEKEY_KEY, "Ljava/io/File;", "buffer", "Lkotlin/t;", "renameToTargetAndTrim", "postTrim", "trim", "", "sizeInBytesForTest", "contentTag", "Ljava/io/InputStream;", "get", "Ljava/io/OutputStream;", "openPutStream", "clearCache", "input", "interceptAndPut", "toString", "tag", "Ljava/lang/String;", "Lcom/facebook/internal/FileLruCache$Limits;", "limits", "Lcom/facebook/internal/FileLruCache$Limits;", "directory", "Ljava/io/File;", "", "isTrimPending", "Z", "isTrimInProgress", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "condition", "Ljava/util/concurrent/locks/Condition;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastClearCacheTime", "Ljava/util/concurrent/atomic/AtomicLong;", "getLocation", "()Ljava/lang/String;", "location", "<init>", "(Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V", "Companion", "BufferFile", "CloseCallbackOutputStream", "CopyingInputStream", "Limits", "ModifiedFile", "StreamCloseCallback", "StreamHeader", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FileLruCache {

    @NotNull
    private static final String HEADER_CACHEKEY_KEY = "key";

    @NotNull
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    private final Condition condition;

    @NotNull
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;

    @NotNull
    private final AtomicLong lastClearCacheTime;

    @NotNull
    private final Limits limits;

    @NotNull
    private final ReentrantLock lock;

    @NotNull
    private final String tag;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = FileLruCache.class.getSimpleName();

    @NotNull
    private static final AtomicLong bufferIndex = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/FileLruCache$BufferFile;", "", "Ljava/io/File;", "root", "Lkotlin/t;", "deleteAll", "Ljava/io/FilenameFilter;", "excludeBufferFiles", "excludeNonBufferFiles", "newFile", "", "FILE_NAME_PREFIX", "Ljava/lang/String;", "filterExcludeBufferFiles", "Ljava/io/FilenameFilter;", "filterExcludeNonBufferFiles", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    static final class BufferFile {

        @NotNull
        private static final String FILE_NAME_PREFIX = "buffer";

        @NotNull
        public static final BufferFile INSTANCE = new BufferFile();

        @NotNull
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.m
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return FileLruCache.BufferFile.m103filterExcludeBufferFiles$lambda0(file, str);
            }
        };

        @NotNull
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.n
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return FileLruCache.BufferFile.m104filterExcludeNonBufferFiles$lambda1(file, str);
            }
        };

        private BufferFile() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: filterExcludeBufferFiles$lambda-0, reason: not valid java name */
        public static final boolean m103filterExcludeBufferFiles$lambda0(File file, String filename) {
            kotlin.jvm.internal.s.d(filename, "filename");
            return !kotlin.text.s.u(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: filterExcludeNonBufferFiles$lambda-1, reason: not valid java name */
        public static final boolean m104filterExcludeNonBufferFiles$lambda1(File file, String filename) {
            kotlin.jvm.internal.s.d(filename, "filename");
            return kotlin.text.s.u(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        public final void deleteAll(@NotNull File root) {
            kotlin.jvm.internal.s.e(root, "root");
            File[] fileArrListFiles = root.listFiles(excludeNonBufferFiles());
            if (fileArrListFiles != null) {
                int i2 = 0;
                int length = fileArrListFiles.length;
                while (i2 < length) {
                    File file = fileArrListFiles[i2];
                    i2++;
                    file.delete();
                }
            }
        }

        @NotNull
        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        @NotNull
        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        @NotNull
        public final File newFile(@Nullable File root) {
            return new File(root, kotlin.jvm.internal.s.m(FILE_NAME_PREFIX, Long.valueOf(FileLruCache.bufferIndex.incrementAndGet())));
        }
    }

    /* compiled from: FileLruCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0017\u0010\f\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/FileLruCache$CloseCallbackOutputStream;", "Ljava/io/OutputStream;", "Lkotlin/t;", "close", "flush", "", "buffer", "", "offset", "count", "write", "oneByte", "innerStream", "Ljava/io/OutputStream;", "getInnerStream", "()Ljava/io/OutputStream;", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "callback", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "getCallback", "()Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class CloseCallbackOutputStream extends OutputStream {

        @NotNull
        private final StreamCloseCallback callback;

        @NotNull
        private final OutputStream innerStream;

        public CloseCallbackOutputStream(@NotNull OutputStream innerStream, @NotNull StreamCloseCallback callback) {
            kotlin.jvm.internal.s.e(innerStream, "innerStream");
            kotlin.jvm.internal.s.e(callback, "callback");
            this.innerStream = innerStream;
            this.callback = callback;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.innerStream.flush();
        }

        @NotNull
        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        @NotNull
        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] buffer, int i2, int i3) throws IOException {
            kotlin.jvm.internal.s.e(buffer, "buffer");
            this.innerStream.write(buffer, i2, i3);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] buffer) throws IOException {
            kotlin.jvm.internal.s.e(buffer, "buffer");
            this.innerStream.write(buffer);
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            this.innerStream.write(i2);
        }
    }

    /* compiled from: FileLruCache.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/internal/FileLruCache$Companion;", "", "()V", "HEADER_CACHEKEY_KEY", "", "HEADER_CACHE_CONTENT_TAG_KEY", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "bufferIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final String getTAG() {
            return FileLruCache.TAG;
        }
    }

    /* compiled from: FileLruCache.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/facebook/internal/FileLruCache$Limits;", "", "()V", "value", "", "byteCount", "getByteCount", "()I", "setByteCount", "(I)V", "fileCount", "getFileCount", "setFileCount", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setByteCount(int i2) {
            if (i2 < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i2;
        }

        public final void setFileCount(int i2) {
            if (i2 < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i2;
        }
    }

    /* compiled from: FileLruCache.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FileLruCache$ModifiedFile;", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "modified", "", "getModified", "()J", "compareTo", "", "another", "equals", "", "", "hashCode", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class ModifiedFile implements Comparable<ModifiedFile> {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;

        @NotNull
        private final File file;
        private final long modified;

        public ModifiedFile(@NotNull File file) {
            kotlin.jvm.internal.s.e(file, "file");
            this.file = file;
            this.modified = file.lastModified();
        }

        public boolean equals(@Nullable Object another) {
            return (another instanceof ModifiedFile) && compareTo((ModifiedFile) another) == 0;
        }

        @NotNull
        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % Integer.MAX_VALUE));
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull ModifiedFile another) {
            kotlin.jvm.internal.s.e(another, "another");
            long j2 = this.modified;
            long j3 = another.modified;
            if (j2 < j3) {
                return -1;
            }
            if (j2 > j3) {
                return 1;
            }
            return this.file.compareTo(another.file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "", "Lkotlin/t;", "onClose", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    interface StreamCloseCallback {
        void onClose();
    }

    /* compiled from: FileLruCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamHeader;", "", "Ljava/io/OutputStream;", "stream", "Lorg/json/JSONObject;", "header", "Lkotlin/t;", "writeHeader", "Ljava/io/InputStream;", "readHeader", "", "HEADER_VERSION", "I", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        @NotNull
        public static final StreamHeader INSTANCE = new StreamHeader();

        private StreamHeader() {
        }

        @Nullable
        public final JSONObject readHeader(@NotNull InputStream stream) throws JSONException, IOException {
            kotlin.jvm.internal.s.e(stream, "stream");
            if (stream.read() != 0) {
                return null;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                int i5 = stream.read();
                if (i5 == -1) {
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String TAG = FileLruCache.INSTANCE.getTAG();
                    kotlin.jvm.internal.s.d(TAG, "TAG");
                    companion.log(loggingBehavior, TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i3 = (i3 << 8) + (i5 & 255);
            }
            byte[] bArr = new byte[i3];
            while (i2 < i3) {
                int i6 = stream.read(bArr, i2, i3 - i2);
                if (i6 < 1) {
                    Logger.Companion companion2 = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    String TAG2 = FileLruCache.INSTANCE.getTAG();
                    kotlin.jvm.internal.s.d(TAG2, "TAG");
                    companion2.log(loggingBehavior2, TAG2, "readHeader: stream.read stopped at " + Integer.valueOf(i2) + " when expected " + i3);
                    return null;
                }
                i2 += i6;
            }
            try {
                Object objNextValue = new JSONTokener(new String(bArr, kotlin.text.d.UTF_8)).nextValue();
                if (objNextValue instanceof JSONObject) {
                    return (JSONObject) objNextValue;
                }
                Logger.Companion companion3 = Logger.INSTANCE;
                LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                String TAG3 = FileLruCache.INSTANCE.getTAG();
                kotlin.jvm.internal.s.d(TAG3, "TAG");
                companion3.log(loggingBehavior3, TAG3, kotlin.jvm.internal.s.m("readHeader: expected JSONObject, got ", objNextValue.getClass().getCanonicalName()));
                return null;
            } catch (JSONException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final void writeHeader(@NotNull OutputStream stream, @NotNull JSONObject header) throws IOException {
            kotlin.jvm.internal.s.e(stream, "stream");
            kotlin.jvm.internal.s.e(header, "header");
            String string = header.toString();
            kotlin.jvm.internal.s.d(string, "header.toString()");
            byte[] bytes = string.getBytes(kotlin.text.d.UTF_8);
            kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
            stream.write(0);
            stream.write((bytes.length >> 16) & 255);
            stream.write((bytes.length >> 8) & 255);
            stream.write((bytes.length >> 0) & 255);
            stream.write(bytes);
        }
    }

    public FileLruCache(@NotNull String tag, @NotNull Limits limits) {
        kotlin.jvm.internal.s.e(tag, "tag");
        kotlin.jvm.internal.s.e(limits, "limits");
        this.tag = tag;
        this.limits = limits;
        File file = new File(FacebookSdk.getCacheDir(), tag);
        this.directory = file;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.lastClearCacheTime = new AtomicLong(0L);
        if (file.mkdirs() || file.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearCache$lambda-1, reason: not valid java name */
    public static final void m101clearCache$lambda1(File[] filesToDelete) {
        kotlin.jvm.internal.s.d(filesToDelete, "filesToDelete");
        int length = filesToDelete.length;
        int i2 = 0;
        while (i2 < length) {
            File file = filesToDelete[i2];
            i2++;
            file.delete();
        }
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.get(str, str2);
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileLruCache.m102postTrim$lambda3$lambda2(this.f2869e);
                    }
                });
            }
            kotlin.t tVar = kotlin.t.f3507a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: postTrim$lambda-3$lambda-2, reason: not valid java name */
    public static final void m102postTrim$lambda3$lambda2(FileLruCache this$0) {
        kotlin.jvm.internal.s.e(this$0, "this$0");
        this$0.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    private final void trim() {
        long j2;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            kotlin.t tVar = kotlin.t.f3507a;
            reentrantLock.unlock();
            try {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                kotlin.jvm.internal.s.d(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] fileArrListFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long length = 0;
                if (fileArrListFiles != null) {
                    int length2 = fileArrListFiles.length;
                    j2 = 0;
                    int i2 = 0;
                    while (i2 < length2) {
                        File file = fileArrListFiles[i2];
                        i2++;
                        kotlin.jvm.internal.s.d(file, "file");
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue.add(modifiedFile);
                        Logger.Companion companion2 = Logger.INSTANCE;
                        LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                        String TAG3 = TAG;
                        kotlin.jvm.internal.s.d(TAG3, "TAG");
                        companion2.log(loggingBehavior2, TAG3, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + ((Object) modifiedFile.getFile().getName()));
                        length += file.length();
                        j2++;
                        fileArrListFiles = fileArrListFiles;
                    }
                } else {
                    j2 = 0;
                }
                while (true) {
                    if (length <= this.limits.getByteCount() && j2 <= this.limits.getFileCount()) {
                        this.lock.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            kotlin.t tVar2 = kotlin.t.f3507a;
                            return;
                        } finally {
                        }
                    }
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.Companion companion3 = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                    String TAG4 = TAG;
                    kotlin.jvm.internal.s.d(TAG4, "TAG");
                    companion3.log(loggingBehavior3, TAG4, kotlin.jvm.internal.s.m("  trim removing ", file2.getName()));
                    length -= file2.length();
                    j2--;
                    file2.delete();
                }
            } catch (Throwable th) {
                this.lock.lock();
                try {
                    this.isTrimInProgress = false;
                    this.condition.signalAll();
                    kotlin.t tVar3 = kotlin.t.f3507a;
                    throw th;
                } finally {
                }
            }
        } finally {
        }
    }

    public final void clearCache() {
        final File[] fileArrListFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (fileArrListFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.l
                @Override // java.lang.Runnable
                public final void run() {
                    FileLruCache.m101clearCache$lambda1(fileArrListFiles);
                }
            });
        }
    }

    @JvmOverloads
    @Nullable
    public final InputStream get(@NotNull String key) throws IOException {
        kotlin.jvm.internal.s.e(key, "key");
        return get$default(this, key, null, 2, null);
    }

    @JvmOverloads
    @Nullable
    public final InputStream get(@NotNull String key, @Nullable String contentTag) throws IOException {
        kotlin.jvm.internal.s.e(key, "key");
        File file = new File(this.directory, Utility.md5hash(key));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                JSONObject header = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (header == null) {
                    return null;
                }
                if (!kotlin.jvm.internal.s.a(header.optString(HEADER_CACHEKEY_KEY), key)) {
                    return null;
                }
                String strOptString = header.optString("tag", null);
                if (contentTag == null && !kotlin.jvm.internal.s.a(contentTag, strOptString)) {
                    return null;
                }
                long time = new Date().getTime();
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                kotlin.jvm.internal.s.d(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "Setting lastModified to " + Long.valueOf(time) + " for " + ((Object) file.getName()));
                file.setLastModified(time);
                return bufferedInputStream;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @NotNull
    public final String getLocation() {
        String path = this.directory.getPath();
        kotlin.jvm.internal.s.d(path, "directory.path");
        return path;
    }

    @NotNull
    public final InputStream interceptAndPut(@NotNull String key, @NotNull InputStream input) throws IOException {
        kotlin.jvm.internal.s.e(key, "key");
        kotlin.jvm.internal.s.e(input, "input");
        return new CopyingInputStream(input, openPutStream$default(this, key, null, 2, null));
    }

    @JvmOverloads
    @NotNull
    public final OutputStream openPutStream(@NotNull String key) throws IOException {
        kotlin.jvm.internal.s.e(key, "key");
        return openPutStream$default(this, key, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final OutputStream openPutStream(@NotNull final String key, @Nullable String contentTag) throws IOException {
        kotlin.jvm.internal.s.e(key, "key");
        final File fileNewFile = BufferFile.INSTANCE.newFile(this.directory);
        fileNewFile.delete();
        if (!fileNewFile.createNewFile()) {
            throw new IOException(kotlin.jvm.internal.s.m("Could not create file at ", fileNewFile.getAbsolutePath()));
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNewFile);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() { // from class: com.facebook.internal.FileLruCache$openPutStream$renameToTargetCallback$1
                @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                public void onClose() {
                    if (jCurrentTimeMillis < this.lastClearCacheTime.get()) {
                        fileNewFile.delete();
                    } else {
                        this.renameToTargetAndTrim(key, fileNewFile);
                    }
                }
            }), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HEADER_CACHEKEY_KEY, key);
                    if (!Utility.isNullOrEmpty(contentTag)) {
                        jSONObject.put("tag", contentTag);
                    }
                    StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (JSONException e2) {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                kotlin.jvm.internal.s.d(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, kotlin.jvm.internal.s.m("Error creating JSON header for cache file: ", e2));
                throw new IOException(e2.getMessage());
            }
        } catch (FileNotFoundException e3) {
            Logger.Companion companion2 = Logger.INSTANCE;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
            String TAG3 = TAG;
            kotlin.jvm.internal.s.d(TAG3, "TAG");
            companion2.log(loggingBehavior2, 5, TAG3, kotlin.jvm.internal.s.m("Error creating buffer output stream: ", e3));
            throw new IOException(e3.getMessage());
        }
    }

    public final long sizeInBytesForTest() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.condition.await();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        kotlin.t tVar = kotlin.t.f3507a;
        reentrantLock.unlock();
        File[] fileArrListFiles = this.directory.listFiles();
        long length = 0;
        if (fileArrListFiles != null) {
            int i2 = 0;
            int length2 = fileArrListFiles.length;
            while (i2 < length2) {
                File file = fileArrListFiles[i2];
                i2++;
                length += file.length();
            }
        }
        return length;
    }

    @NotNull
    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + ((Object) this.directory.getName()) + '}';
    }

    /* compiled from: FileLruCache.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0017\u0010\u0013\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/facebook/internal/FileLruCache$CopyingInputStream;", "Ljava/io/InputStream;", "", "available", "Lkotlin/t;", "close", "readlimit", "mark", "", "markSupported", "", "buffer", "read", "offset", "length", "reset", "", "byteCount", "skip", "input", "Ljava/io/InputStream;", "getInput", "()Ljava/io/InputStream;", "Ljava/io/OutputStream;", "output", "Ljava/io/OutputStream;", "getOutput", "()Ljava/io/OutputStream;", "<init>", "(Ljava/io/InputStream;Ljava/io/OutputStream;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class CopyingInputStream extends InputStream {

        @NotNull
        private final InputStream input;

        @NotNull
        private final OutputStream output;

        public CopyingInputStream(@NotNull InputStream input, @NotNull OutputStream output) {
            kotlin.jvm.internal.s.e(input, "input");
            kotlin.jvm.internal.s.e(output, "output");
            this.input = input;
            this.output = output;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.input.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @NotNull
        public final InputStream getInput() {
            return this.input;
        }

        @NotNull
        public final OutputStream getOutput() {
            return this.output;
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read(@NotNull byte[] buffer) throws IOException {
            kotlin.jvm.internal.s.e(buffer, "buffer");
            int i2 = this.input.read(buffer);
            if (i2 > 0) {
                this.output.write(buffer, 0, i2);
            }
            return i2;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long byteCount) throws IOException {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < byteCount) {
                int i2 = read(bArr, 0, (int) Math.min(byteCount - j2, 1024));
                if (i2 < 0) {
                    return j2;
                }
                j2 += i2;
            }
            return j2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i2 = this.input.read();
            if (i2 >= 0) {
                this.output.write(i2);
            }
            return i2;
        }

        @Override // java.io.InputStream
        public int read(@NotNull byte[] buffer, int offset, int length) throws IOException {
            kotlin.jvm.internal.s.e(buffer, "buffer");
            int i2 = this.input.read(buffer, offset, length);
            if (i2 > 0) {
                this.output.write(buffer, offset, i2);
            }
            return i2;
        }
    }
}
