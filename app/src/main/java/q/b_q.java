package q;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.l;

/* compiled from: EmojiEditableFactory.java */
/* loaded from: classes.dex */
final class b_q extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f4061a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("INSTANCE_LOCK")
    private static volatile Editable.Factory f4062b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static Class<?> f4063c;

    @SuppressLint({"PrivateApi"})
    private b_q() {
        try {
            f4063c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b_q.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f4062b == null) {
            synchronized (f4061a) {
                if (f4062b == null) {
                    f4062b = new b_q();
                }
            }
        }
        return f4062b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = f4063c;
        return cls != null ? l.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
