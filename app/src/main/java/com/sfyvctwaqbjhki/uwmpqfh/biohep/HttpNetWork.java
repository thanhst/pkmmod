package com.sfyvctwaqbjhki.uwmpqfh.biohep;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.ebvmj.RDnIREMt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes.dex */
public class HttpNetWork {
    public static final int CONN_TIMEOUT = 30000;
    static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.8
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("ipage.com", sSLSession);
        }
    };
    private static final String KEY_STORE_TRUST_PASSWORD = "changic2017";
    private static final String KEY_STORE_TRUST_PATH = "cg_server.crt";
    private static final String KEY_STORE_TYPE_BKS = "X.509";
    private static final String KEY_STORE_TYPE_P12 = "PKCS12";
    public static final int READ_TIMEOUT = 30000;

    public interface HttpConnectionCallback {
        void onComplete(String str);

        void onFault(String str);
    }

    public enum HttpMethod {
        GET,
        POST
    }

    public static void asyncConnect(final String str, final Map<String, Object> map, final HttpMethod httpMethod, final HttpConnectionCallback httpConnectionCallback) {
        if (WoUjMp.getInstance().getContext() != null) {
            WoUjMp.getInstance().getContext().runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.1
                @Override // java.lang.Runnable
                public void run() {
                    RDnIREMt.getInstance().doShow();
                }
            });
        }
        new Thread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                if (str.contains("https://")) {
                    HttpNetWork.syncHttpsConnect(str, map, httpMethod, httpConnectionCallback);
                } else {
                    HttpNetWork.syncConnect(str, map, httpMethod, httpConnectionCallback);
                }
            }
        }).start();
    }

    private static String getGetRequest(Map<String, Object> map) throws UnsupportedEncodingException {
        String strEncode;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                Object obj = map.get(it.next());
                if (obj != null) {
                    if (stringBuffer.toString().equals("")) {
                        strEncode = URLEncoder.encode(obj.toString(), "utf-8");
                    } else {
                        strEncode = "/" + URLEncoder.encode(obj.toString(), "utf-8");
                    }
                    stringBuffer.append(strEncode);
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private static String getPostRequest(Map<String, Object> map) {
        String str = "";
        try {
            String str2 = "";
            for (String str3 : map.keySet()) {
                try {
                    Object obj = map.get(str3);
                    if (obj != null) {
                        if (!str2.equals("")) {
                            str2 = str2 + "&";
                        }
                        str2 = str2 + str3 + "=" + URLEncoder.encode(obj.toString(), "utf-8");
                    }
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    str = str2;
                    e.printStackTrace();
                    return str;
                }
            }
            return str2;
        } catch (UnsupportedEncodingException e3) {
            e = e3;
        }
    }

    private static SSLContext getSSLContext(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, KeyManagementException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE_BKS);
            InputStream inputStreamOpen = context.getResources().getAssets().open(KEY_STORE_TRUST_PATH);
            try {
                try {
                    keyStore.load(inputStreamOpen, KEY_STORE_TRUST_PASSWORD.toCharArray());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                sSLContext.init(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
                return sSLContext;
            } finally {
                try {
                    inputStreamOpen.close();
                } catch (Exception unused) {
                }
            }
        } catch (Exception e3) {
            Log.e(ViewHierarchyConstants.TAG_KEY, e3.getMessage(), e3);
            return null;
        }
    }

    private static SSLContext getSSLContexts(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        try {
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance(KEY_STORE_TYPE_BKS).generateCertificate(context.getResources().getAssets().open(KEY_STORE_TRUST_PATH));
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE_P12);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("trust", certificateGenerateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            return sSLContext;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static SSLContext getSSLContextt(Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance(KEY_STORE_TYPE_BKS).generateCertificate(context.getAssets().open(KEY_STORE_TRUST_PATH));
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE_P12);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("trust", certificateGenerateCertificate);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, KEY_STORE_TRUST_PASSWORD.toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sSLContext;
        } catch (Exception unused) {
            return null;
        }
    }

    private static X509Certificate readCert(Context context) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(KEY_STORE_TRUST_PATH);
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(KEY_STORE_TYPE_BKS).generateCertificate(inputStreamOpen);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused) {
                    }
                }
                return x509Certificate;
            } catch (Exception unused2) {
                if (inputStreamOpen == null) {
                    return null;
                }
                inputStreamOpen.close();
                return null;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void syncConnect(String str, Map<String, Object> map, HttpMethod httpMethod, HttpConnectionCallback httpConnectionCallback) throws IOException {
        HttpURLConnection httpURLConnection;
        try {
            if (httpMethod == HttpMethod.POST) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.connect();
                PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                printWriter.print(getPostRequest(map));
                printWriter.flush();
                printWriter.close();
            } else {
                httpURLConnection = (HttpURLConnection) new URL(str + "/" + getGetRequest(map)).openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setUseCaches(false);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str2 = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str2 = str2 + line;
            }
            inputStream.close();
            bufferedReader.close();
            httpURLConnection.disconnect();
            if (WoUjMp.getInstance().getContext() != null) {
                WoUjMp.getInstance().getContext().runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RDnIREMt.getInstance().doDismiss();
                    }
                });
            }
            httpConnectionCallback.onComplete(str2);
        } catch (Exception e2) {
            if (WoUjMp.getInstance().getContext() != null) {
                WoUjMp.getInstance().getContext().runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RDnIREMt.getInstance().doDismiss();
                    }
                });
            }
            httpConnectionCallback.onFault(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void syncHttpsConnect(String str, Map<String, Object> map, HttpMethod httpMethod, HttpConnectionCallback httpConnectionCallback) throws IOException {
        HttpsURLConnection httpsURLConnection;
        try {
            if (httpMethod == HttpMethod.POST) {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setInstanceFollowRedirects(false);
                SSLContext sSLContextt = getSSLContextt(WoUjMp.getInstance().getContext());
                if (sSLContextt != null) {
                    httpsURLConnection.setSSLSocketFactory(sSLContextt.getSocketFactory());
                }
                httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.5
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str2, SSLSession sSLSession) {
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
                    }
                });
                httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpsURLConnection.connect();
                PrintWriter printWriter = new PrintWriter(httpsURLConnection.getOutputStream());
                printWriter.print(getPostRequest(map));
                printWriter.flush();
                printWriter.close();
            } else {
                httpsURLConnection = (HttpsURLConnection) new URL(str + "/" + getGetRequest(map)).openConnection();
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setUseCaches(false);
            }
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str2 = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str2 = str2 + line;
            }
            inputStream.close();
            bufferedReader.close();
            httpsURLConnection.disconnect();
            if (WoUjMp.getInstance().getContext() != null) {
                WoUjMp.getInstance().getContext().runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.6
                    @Override // java.lang.Runnable
                    public void run() {
                        RDnIREMt.getInstance().doDismiss();
                    }
                });
            }
            httpConnectionCallback.onComplete(str2);
        } catch (Exception e2) {
            if (WoUjMp.getInstance().getContext() != null) {
                WoUjMp.getInstance().getContext().runOnUiThread(new Runnable() { // from class: com.sfyvctwaqbjhki.uwmpqfh.biohep.HttpNetWork.7
                    @Override // java.lang.Runnable
                    public void run() {
                        RDnIREMt.getInstance().doDismiss();
                    }
                });
            }
            httpConnectionCallback.onFault(e2.getMessage());
        }
    }
}
