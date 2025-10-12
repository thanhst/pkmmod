package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.FileLruCache;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UrlRedirectCache.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "Lcom/facebook/internal/FileLruCache;", "getCache", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "getRedirectedUri", "fromUri", "toUri", "Lkotlin/t;", "cacheUriRedirect", "clearCache", "", ViewHierarchyConstants.TAG_KEY, "Ljava/lang/String;", "redirectContentTag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UrlRedirectCache {

    @NotNull
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();

    @NotNull
    private static final String redirectContentTag;

    @NotNull
    private static final String tag;

    @Nullable
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String strA = kotlin.jvm.internal.v.b(UrlRedirectCache.class).a();
        if (strA == null) {
            strA = "UrlRedirectCache";
        }
        tag = strA;
        redirectContentTag = kotlin.jvm.internal.s.m(strA, "_Redirect");
    }

    private UrlRedirectCache() {
    }

    @JvmStatic
    public static final void cacheUriRedirect(@Nullable Uri uri, @Nullable Uri uri2) throws IOException {
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStreamOpenPutStream = null;
        try {
            try {
                FileLruCache cache = getCache();
                String string = uri.toString();
                kotlin.jvm.internal.s.d(string, "fromUri.toString()");
                outputStreamOpenPutStream = cache.openPutStream(string, redirectContentTag);
                String string2 = uri2.toString();
                kotlin.jvm.internal.s.d(string2, "toUri.toString()");
                byte[] bytes = string2.getBytes(kotlin.text.d.UTF_8);
                kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStreamOpenPutStream.write(bytes);
            } catch (IOException e2) {
                Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, kotlin.jvm.internal.s.m("IOException when accessing cache: ", e2.getMessage()));
            }
        } finally {
            Utility.closeQuietly(outputStreamOpenPutStream);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e2) {
            Logger.INSTANCE.log(LoggingBehavior.CACHE, 5, tag, kotlin.jvm.internal.s.m("clearCache failed ", e2.getMessage()));
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        fileLruCache = urlRedirectFileLruCache;
        if (fileLruCache == null) {
            fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
        }
        urlRedirectFileLruCache = fileLruCache;
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (kotlin.jvm.internal.s.a(r3, r11) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        com.facebook.internal.Logger.INSTANCE.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        com.facebook.internal.Utility.closeQuietly(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00aa: MOVE (r0 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:171), block:B:44:0x00aa */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.net.Uri getRedirectedUri(@org.jetbrains.annotations.Nullable android.net.Uri r11) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            java.lang.String r11 = r11.toString()
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.s.d(r11, r1)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r1.add(r11)
            com.facebook.internal.FileLruCache r2 = getCache()     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            java.io.InputStream r3 = r2.get(r11, r3)     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            r4 = 0
            r5 = r0
            r6 = 0
        L22:
            if (r3 == 0) goto L81
            r6 = 1
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L7f java.lang.Throwable -> La9
            r7.<init>(r3)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> La9
            r3 = 128(0x80, float:1.8E-43)
            char[] r5 = new char[r3]     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            r8.<init>()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            int r9 = r7.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
        L37:
            if (r9 <= 0) goto L41
            r8.append(r5, r4, r9)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            int r9 = r7.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            goto L37
        L41:
            com.facebook.internal.Utility.closeQuietly(r7)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r3 = r8.toString()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r5 = "urlBuilder.toString()"
            kotlin.jvm.internal.s.d(r3, r5)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            boolean r5 = r1.contains(r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            if (r5 == 0) goto L6b
            boolean r1 = kotlin.jvm.internal.s.a(r3, r11)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            if (r1 == 0) goto L5b
            r5 = r7
            goto L81
        L5b:
            com.facebook.internal.Logger$Companion r11 = com.facebook.internal.Logger.INSTANCE     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            r2 = 6
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r4 = "A loop detected in UrlRedirectCache"
            r11.log(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            com.facebook.internal.Utility.closeQuietly(r7)
            return r0
        L6b:
            r1.add(r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r11 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.io.InputStream r11 = r2.get(r3, r11)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            r5 = r7
            r10 = r3
            r3 = r11
            r11 = r10
            goto L22
        L79:
            r11 = move-exception
            r0 = r7
            goto Lab
        L7c:
            r11 = move-exception
            r5 = r7
            goto L93
        L7f:
            r11 = move-exception
            goto L93
        L81:
            if (r6 == 0) goto L8b
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> La9
            com.facebook.internal.Utility.closeQuietly(r5)
            return r11
        L8b:
            com.facebook.internal.Utility.closeQuietly(r5)
            goto La8
        L8f:
            r11 = move-exception
            goto Lab
        L91:
            r11 = move-exception
            r5 = r0
        L93:
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.INSTANCE     // Catch: java.lang.Throwable -> La9
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> La9
            r3 = 4
            java.lang.String r4 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> La9
            java.lang.String r6 = "IOException when accessing cache: "
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> La9
            java.lang.String r11 = kotlin.jvm.internal.s.m(r6, r11)     // Catch: java.lang.Throwable -> La9
            r1.log(r2, r3, r4, r11)     // Catch: java.lang.Throwable -> La9
            goto L8b
        La8:
            return r0
        La9:
            r11 = move-exception
            r0 = r5
        Lab:
            com.facebook.internal.Utility.closeQuietly(r0)
            goto Lb0
        Laf:
            throw r11
        Lb0:
            goto Laf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }
}
