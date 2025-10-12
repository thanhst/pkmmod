package com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces;

/* loaded from: classes.dex */
public interface LoginCallBack<T> {
    void onCancel();

    void onError(String str);

    void onSuccess(T t2);
}
