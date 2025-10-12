package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageResponseCache.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0007R\u001f\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/ImageResponseCache;", "", "Lcom/facebook/internal/FileLruCache;", "getCache", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Ljava/io/InputStream;", "getCachedImageStream", "Ljava/net/HttpURLConnection;", "connection", "interceptAndCacheImageStream", "", "isCDNURL", "Lkotlin/t;", "clearCache", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "imageCache", "Lcom/facebook/internal/FileLruCache;", "<init>", "()V", "BufferedHttpInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ImageResponseCache {

    @NotNull
    public static final ImageResponseCache INSTANCE = new ImageResponseCache();
    private static final String TAG = ImageResponseCache.class.getSimpleName();
    private static FileLruCache imageCache;

    /* compiled from: ImageResponseCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/ImageResponseCache$BufferedHttpInputStream;", "Ljava/io/BufferedInputStream;", "Lkotlin/t;", "close", "Ljava/net/HttpURLConnection;", "connection", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "setConnection", "(Ljava/net/HttpURLConnection;)V", "Ljava/io/InputStream;", "stream", "<init>", "(Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class BufferedHttpInputStream extends BufferedInputStream {

        @NotNull
        private HttpURLConnection connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BufferedHttpInputStream(@Nullable InputStream inputStream, @NotNull HttpURLConnection connection) {
            super(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            kotlin.jvm.internal.s.e(connection, "connection");
            this.connection = connection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Utility utility = Utility.INSTANCE;
            Utility.disconnectQuietly(this.connection);
        }

        @NotNull
        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(@NotNull HttpURLConnection httpURLConnection) {
            kotlin.jvm.internal.s.e(httpURLConnection, "<set-?>");
            this.connection = httpURLConnection;
        }
    }

    private ImageResponseCache() {
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e2) {
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String TAG2 = TAG;
            kotlin.jvm.internal.s.d(TAG2, "TAG");
            companion.log(loggingBehavior, 5, TAG2, kotlin.jvm.internal.s.m("clearCache failed ", e2.getMessage()));
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        if (imageCache == null) {
            String TAG2 = TAG;
            kotlin.jvm.internal.s.d(TAG2, "TAG");
            imageCache = new FileLruCache(TAG2, new FileLruCache.Limits());
        }
        fileLruCache = imageCache;
        if (fileLruCache == null) {
            kotlin.jvm.internal.s.t("imageCache");
            throw null;
        }
        return fileLruCache;
    }

    @JvmStatic
    @Nullable
    public static final InputStream getCachedImageStream(@Nullable Uri uri) {
        if (uri == null || !INSTANCE.isCDNURL(uri)) {
            return null;
        }
        try {
            FileLruCache cache = getCache();
            String string = uri.toString();
            kotlin.jvm.internal.s.d(string, "uri.toString()");
            return FileLruCache.get$default(cache, string, null, 2, null);
        } catch (IOException e2) {
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String TAG2 = TAG;
            kotlin.jvm.internal.s.d(TAG2, "TAG");
            companion.log(loggingBehavior, 5, TAG2, e2.toString());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final InputStream interceptAndCacheImageStream(@NotNull HttpURLConnection connection) throws IOException {
        kotlin.jvm.internal.s.e(connection, "connection");
        if (connection.getResponseCode() != 200) {
            return null;
        }
        Uri uri = Uri.parse(connection.getURL().toString());
        InputStream inputStream = connection.getInputStream();
        try {
            if (!INSTANCE.isCDNURL(uri)) {
                return inputStream;
            }
            FileLruCache cache = getCache();
            String string = uri.toString();
            kotlin.jvm.internal.s.d(string, "uri.toString()");
            return cache.interceptAndPut(string, new BufferedHttpInputStream(inputStream, connection));
        } catch (IOException unused) {
            return inputStream;
        }
    }

    private final boolean isCDNURL(Uri uri) {
        String host;
        return (uri == null || (host = uri.getHost()) == null || (!kotlin.jvm.internal.s.a(host, "fbcdn.net") && !kotlin.text.s.k(host, ".fbcdn.net", false, 2, null) && (!kotlin.text.s.u(host, "fbcdn", false, 2, null) || !kotlin.text.s.k(host, ".akamaihd.net", false, 2, null)))) ? false : true;
    }

    public final String getTAG() {
        return TAG;
    }
}
