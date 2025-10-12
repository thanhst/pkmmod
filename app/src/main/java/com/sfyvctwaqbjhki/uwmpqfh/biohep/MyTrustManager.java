package com.sfyvctwaqbjhki.uwmpqfh.biohep;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class MyTrustManager implements X509TrustManager {
    X509Certificate cert;

    MyTrustManager(X509Certificate x509Certificate) {
        this.cert = x509Certificate;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!x509CertificateArr[0].equals(this.cert)) {
            throw new CertificateException("checkServerTrusted No trusted server cert found!");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
