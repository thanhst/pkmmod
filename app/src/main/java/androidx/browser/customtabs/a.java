package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CustomTabColorSchemeParams.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f1202a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f1203b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f1204c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f1205d;

    /* compiled from: CustomTabColorSchemeParams.java */
    /* renamed from: androidx.browser.customtabs.a$a, reason: collision with other inner class name */
    public static final class C0009a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        @ColorInt
        private Integer f1206a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        @ColorInt
        private Integer f1207b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        @ColorInt
        private Integer f1208c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        @ColorInt
        private Integer f1209d;

        @NonNull
        public a a() {
            return new a(this.f1206a, this.f1207b, this.f1208c, this.f1209d);
        }
    }

    a(@Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2, @Nullable @ColorInt Integer num3, @Nullable @ColorInt Integer num4) {
        this.f1202a = num;
        this.f1203b = num2;
        this.f1204c = num3;
        this.f1205d = num4;
    }

    @NonNull
    Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1202a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1203b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1204c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f1205d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
