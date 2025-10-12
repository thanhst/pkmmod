package j0;

import android.os.Handler;
import com.helpergames.NHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HttpClient.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected static Handler f3320a = null;

    /* renamed from: b, reason: collision with root package name */
    public static ExecutorService f3321b = null;

    /* renamed from: c, reason: collision with root package name */
    public static int f3322c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<Integer> f3323d = new ArrayList<>();

    /* compiled from: HttpClient.java */
    class a extends Thread {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3324e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f3325f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3326g;

        a(String str, boolean z2, int i2) {
            this.f3324e = str;
            this.f3325f = z2;
            this.f3326g = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x00c8 A[Catch: Exception -> 0x00cb, TRY_LEAVE, TryCatch #4 {Exception -> 0x00cb, blocks: (B:52:0x00c3, B:54:0x00c8), top: B:64:0x00c3 }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 206
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j0.e.a.run():void");
        }
    }

    /* compiled from: HttpClient.java */
    class b extends Thread {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f3327e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3328f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3329g;

        b(String str, String str2, int i2) {
            this.f3327e = str;
            this.f3328f = str2;
            this.f3329g = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            HttpURLConnection httpURLConnection;
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            InputStream inputStream = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f3327e).openConnection();
                try {
                    try {
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        String str = new String(this.f3328f);
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.connect();
                        httpURLConnection.getOutputStream().write(str.getBytes());
                        httpURLConnection.getOutputStream().flush();
                        httpURLConnection.getOutputStream().close();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream2 = httpURLConnection.getInputStream();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                                StringBuilder sb = new StringBuilder();
                                char[] cArr = new char[1024];
                                while (true) {
                                    int i2 = bufferedReader.read(cArr);
                                    if (i2 <= 0) {
                                        break;
                                    } else {
                                        sb.append(cArr, 0, i2);
                                    }
                                }
                                inputStream2.close();
                                bufferedReader.close();
                                String string = sb.toString();
                                NHelper.b();
                                NHelper.ncallback_49c3a9cbf848091726430375888954bf(this.f3329g, false, string);
                            } catch (Exception unused) {
                                inputStream = inputStream2;
                                NHelper.b();
                                NHelper.ncallback_49c3a9cbf848091726430375888954bf(this.f3329g, true, "");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception unused2) {
                                        return;
                                    }
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                                httpURLConnection.disconnect();
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception unused3) {
                                        throw th;
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } else if (responseCode == 500) {
                            NHelper.b();
                            NHelper.ncallback_49c3a9cbf848091726430375888954bf(this.f3329g, false, "ERROR=MOERROR_SERVER_EXCEPTION;");
                        } else {
                            NHelper.b();
                            NHelper.ncallback_49c3a9cbf848091726430375888954bf(this.f3329g, true, "");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused4) {
                }
            } catch (Exception unused5) {
                httpURLConnection = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
            httpURLConnection.disconnect();
        }
    }

    /* compiled from: HttpClient.java */
    class c extends Thread {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f3330e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3331f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3332g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3333h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f3334i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f3335j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f3336k;

        c(boolean z2, String str, String str2, String str3, boolean z3, int i2, String str4) {
            this.f3330e = z2;
            this.f3331f = str;
            this.f3332g = str2;
            this.f3333h = str3;
            this.f3334i = z3;
            this.f3335j = i2;
            this.f3336k = str4;
        }

        /* JADX WARN: Removed duplicated region for block: B:126:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0186 A[Catch: all -> 0x01a2, TryCatch #4 {all -> 0x01a2, blocks: (B:54:0x010d, B:85:0x0182, B:87:0x0186, B:89:0x0196, B:88:0x018f, B:62:0x0135, B:73:0x015c, B:75:0x0167, B:76:0x0170), top: B:120:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x018f A[Catch: all -> 0x01a2, TryCatch #4 {all -> 0x01a2, blocks: (B:54:0x010d, B:85:0x0182, B:87:0x0186, B:89:0x0196, B:88:0x018f, B:62:0x0135, B:73:0x015c, B:75:0x0167, B:76:0x0170), top: B:120:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01a1 A[ORIG_RETURN, RETURN] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 465
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j0.e.c.run():void");
        }
    }

    public static synchronized void a(int i2) {
        if (!f3323d.contains(Integer.valueOf(i2))) {
            f3323d.add(Integer.valueOf(i2));
        }
    }

    public static int b(String str, String str2, String str3, String str4, boolean z2, boolean z3) {
        int i2 = f3322c + 1;
        f3322c = i2;
        int i3 = i2 % 65535;
        f3322c = i3;
        if (str4.length() <= 0) {
            str4 = str3 + ".d";
        }
        f3321b.execute(new c(z2, str, str2, str4, z3, i3, str3));
        return i3;
    }

    protected static int c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    protected static synchronized Boolean d(int i2) {
        if (f3323d.contains(Integer.valueOf(i2))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    protected static synchronized void e(int i2) {
        if (f3323d.contains(Integer.valueOf(i2))) {
            f3323d.remove(new Integer(i2));
        }
    }

    protected static void f(String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            new File(str).renameTo(new File(str2));
        } catch (Exception unused) {
        }
    }

    public static int g(String str, boolean z2) {
        int i2 = f3322c + 1;
        f3322c = i2;
        int i3 = i2 % 65535;
        f3322c = i3;
        f3321b.execute(new a(str, z2, i3));
        return i3;
    }

    public static int h(String str, String str2) {
        int i2 = f3322c + 1;
        f3322c = i2;
        int i3 = i2 % 65535;
        f3322c = i3;
        f3321b.execute(new b(str, str2, i3));
        return i3;
    }

    public static void i() {
        f3320a = new Handler();
        f3321b = Executors.newCachedThreadPool();
    }

    public static void j() {
    }
}
