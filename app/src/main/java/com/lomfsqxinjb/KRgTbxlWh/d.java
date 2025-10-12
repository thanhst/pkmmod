package com.lomfsqxinjb.KRgTbxlWh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;
import com.thucungdoithu9gp.vn.R;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ImageAnimView.java */
/* loaded from: classes.dex */
public class d extends ImageView {

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Bitmap> f3205e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3206f;

    /* renamed from: g, reason: collision with root package name */
    private Timer f3207g;

    /* renamed from: h, reason: collision with root package name */
    private int f3208h;

    /* renamed from: i, reason: collision with root package name */
    private int f3209i;

    /* renamed from: j, reason: collision with root package name */
    private int f3210j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f3211k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f3212l;

    /* compiled from: ImageAnimView.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.setImageBitmap(dVar.f3205e.get(dVar.f3209i));
        }
    }

    /* compiled from: ImageAnimView.java */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.this.d();
        }
    }

    public d(Context context) {
        super(context);
        this.f3205e = new ArrayList<>();
        this.f3206f = false;
        this.f3207g = null;
        this.f3208h = 0;
        this.f3209i = 0;
        this.f3210j = 0;
        this.f3211k = new Handler();
        this.f3212l = new a();
    }

    public void b() {
        if (this.f3210j <= 0) {
            e.a("image anim:no frame");
            return;
        }
        this.f3206f = true;
        this.f3209i = 0;
        Timer timer = this.f3207g;
        if (timer != null) {
            timer.cancel();
        } else {
            this.f3207g = new Timer();
        }
        d();
        Timer timer2 = this.f3207g;
        b bVar = new b();
        int i2 = this.f3208h;
        timer2.schedule(bVar, i2, i2);
    }

    public void c(String str, int i2, int i3, int i4) {
        try {
            if (getContext() != null) {
                this.f3205e.clear();
                this.f3210j = 0;
                int[] iArr = {R.drawable.loading_anim_1, R.drawable.loading_anim_2, R.drawable.loading_anim_3, R.drawable.loading_anim_4, R.drawable.loading_anim_5, R.drawable.loading_anim_6, R.drawable.loading_anim_7, R.drawable.loading_anim_8, R.drawable.loading_anim_9, R.drawable.loading_anim_10, R.drawable.loading_anim_11, R.drawable.loading_anim_12, R.drawable.loading_anim_13, R.drawable.loading_anim_14, R.drawable.loading_anim_15, R.drawable.loading_anim_16, R.drawable.loading_anim_17, R.drawable.loading_anim_18, R.drawable.loading_anim_19, R.drawable.loading_anim_20, R.drawable.loading_anim_21, R.drawable.loading_anim_22, R.drawable.loading_anim_23, R.drawable.loading_anim_24, R.drawable.loading_anim_25, R.drawable.loading_anim_26, R.drawable.loading_anim_27, R.drawable.loading_anim_28, R.drawable.loading_anim_29, R.drawable.loading_anim_30, R.drawable.loading_anim_31, R.drawable.loading_anim_32, R.drawable.loading_anim_33, R.drawable.loading_anim_34};
                for (int i5 = i3 - 1; i5 < i4; i5++) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), iArr[i5], options);
                    if (bitmapDecodeResource != null) {
                        this.f3205e.add(bitmapDecodeResource);
                        this.f3210j++;
                    } else {
                        e.a("image anim:no image=>loading_anim_" + i5);
                    }
                }
            }
            this.f3208h = i2;
            b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d() {
        this.f3209i = (this.f3209i + 1) % this.f3210j;
        this.f3211k.post(this.f3212l);
    }
}
