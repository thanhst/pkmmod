package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$style;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f333f;

    /* renamed from: a, reason: collision with root package name */
    private int f334a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f335b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f336c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f337d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f338e;

    /* compiled from: ContextThemeWrapper.java */
    @RequiresApi(17)
    static class a {
        @DoNotInline
        static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f338e == null) {
            Configuration configuration = this.f337d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f338e = super.getResources();
            } else {
                this.f338e = a.a(this, this.f337d).getResources();
            }
        }
        return this.f338e;
    }

    private void d() {
        boolean z2 = this.f335b == null;
        if (z2) {
            this.f335b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f335b.setTo(theme);
            }
        }
        f(this.f335b, this.f334a, z2);
    }

    @RequiresApi(26)
    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f333f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f333f = configuration2;
        }
        return configuration.equals(f333f);
    }

    public void a(Configuration configuration) {
        if (this.f338e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f337d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f337d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f334a;
    }

    protected void f(Resources.Theme theme, int i2, boolean z2) {
        theme.applyStyle(i2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f336c == null) {
            this.f336c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f336c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f335b;
        if (theme != null) {
            return theme;
        }
        if (this.f334a == 0) {
            this.f334a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f335b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.f334a != i2) {
            this.f334a = i2;
            d();
        }
    }

    public d(Context context, @StyleRes int i2) {
        super(context);
        this.f334a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f335b = theme;
    }
}
