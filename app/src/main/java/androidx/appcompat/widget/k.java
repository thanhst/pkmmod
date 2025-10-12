package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.z1;

/* compiled from: AppCompatDrawableManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f982b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static k f983c;

    /* renamed from: a, reason: collision with root package name */
    private z1 f984a;

    /* compiled from: AppCompatDrawableManager.java */
    class a implements z1.f {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f985a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f986b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f987c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f988d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f989e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f990f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(@NonNull Context context) {
            return h(context, 0);
        }

        private ColorStateList h(@NonNull Context context, @ColorInt int i2) {
            int iC = f2.c(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{f2.f941b, f2.f944e, f2.f942c, f2.f948i}, new int[]{f2.b(context, R$attr.colorButtonNormal), androidx.core.graphics.a.c(iC, i2), androidx.core.graphics.a.c(iC, i2), i2});
        }

        private ColorStateList i(@NonNull Context context) {
            return h(context, f2.c(context, R$attr.colorAccent));
        }

        private ColorStateList j(@NonNull Context context) {
            return h(context, f2.c(context, R$attr.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i2 = R$attr.colorSwitchThumbNormal;
            ColorStateList colorStateListE = f2.e(context, i2);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = f2.f941b;
                iArr2[0] = f2.b(context, i2);
                iArr[1] = f2.f945f;
                iArr2[1] = f2.c(context, R$attr.colorControlActivated);
                iArr[2] = f2.f948i;
                iArr2[2] = f2.c(context, i2);
            } else {
                int[] iArr3 = f2.f941b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = f2.f945f;
                iArr2[1] = f2.c(context, R$attr.colorControlActivated);
                iArr[2] = f2.f948i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(@NonNull z1 z1Var, @NonNull Context context, @DimenRes int i2) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            Drawable drawableJ = z1Var.j(context, R$drawable.abc_star_black_48dp);
            Drawable drawableJ2 = z1Var.j(context, R$drawable.abc_star_half_black_48dp);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i2, PorterDuff.Mode mode) {
            if (l1.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = k.f982b;
            }
            drawable.setColorFilter(k.e(i2, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.z1.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.k.a()
                int[] r1 = r6.f985a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = androidx.appcompat.R$attr.colorControlNormal
            L14:
                r8 = -1
            L15:
                r1 = 1
                goto L44
            L17:
                int[] r1 = r6.f987c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L22
                int r2 = androidx.appcompat.R$attr.colorControlActivated
                goto L14
            L22:
                int[] r1 = r6.f988d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = -1
                r1 = 0
                r2 = 0
            L44:
                if (r1 == 0) goto L61
                boolean r1 = androidx.appcompat.widget.l1.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = androidx.appcompat.widget.f2.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.k.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.z1.f
        public PorterDuff.Mode b(int i2) {
            if (i2 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.z1.f
        public Drawable c(@NonNull z1 z1Var, @NonNull Context context, int i2) {
            if (i2 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{z1Var.j(context, R$drawable.abc_cab_background_internal_bg), z1Var.j(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i2 == R$drawable.abc_ratingbar_material) {
                return l(z1Var, context, R$dimen.abc_star_big);
            }
            if (i2 == R$drawable.abc_ratingbar_indicator_material) {
                return l(z1Var, context, R$dimen.abc_star_medium);
            }
            if (i2 == R$drawable.abc_ratingbar_small_material) {
                return l(z1Var, context, R$dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.z1.f
        public ColorStateList d(@NonNull Context context, int i2) {
            if (i2 == R$drawable.abc_edit_text_material) {
                return e.a.a(context, R$color.abc_tint_edittext);
            }
            if (i2 == R$drawable.abc_switch_track_mtrl_alpha) {
                return e.a.a(context, R$color.abc_tint_switch_track);
            }
            if (i2 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i2 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i2 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i2 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i2 == R$drawable.abc_spinner_mtrl_am_alpha || i2 == R$drawable.abc_spinner_textfield_background_material) {
                return e.a.a(context, R$color.abc_tint_spinner);
            }
            if (f(this.f986b, i2)) {
                return f2.e(context, R$attr.colorControlNormal);
            }
            if (f(this.f989e, i2)) {
                return e.a.a(context, R$color.abc_tint_default);
            }
            if (f(this.f990f, i2)) {
                return e.a.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i2 == R$drawable.abc_seekbar_thumb_material) {
                return e.a.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.z1.f
        public boolean e(@NonNull Context context, int i2, @NonNull Drawable drawable) {
            if (i2 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i3 = R$attr.colorControlNormal;
                m(drawableFindDrawableByLayerId, f2.c(context, i3), k.f982b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), f2.c(context, i3), k.f982b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), f2.c(context, R$attr.colorControlActivated), k.f982b);
                return true;
            }
            if (i2 != R$drawable.abc_ratingbar_material && i2 != R$drawable.abc_ratingbar_indicator_material && i2 != R$drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), f2.b(context, R$attr.colorControlNormal), k.f982b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i4 = R$attr.colorControlActivated;
            m(drawableFindDrawableByLayerId2, f2.c(context, i4), k.f982b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), f2.c(context, i4), k.f982b);
            return true;
        }
    }

    public static synchronized k b() {
        if (f983c == null) {
            h();
        }
        return f983c;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        return z1.l(i2, mode);
    }

    public static synchronized void h() {
        if (f983c == null) {
            k kVar = new k();
            f983c = kVar;
            kVar.f984a = z1.h();
            f983c.f984a.u(new a());
        }
    }

    static void i(Drawable drawable, i2 i2Var, int[] iArr) {
        z1.w(drawable, i2Var, iArr);
    }

    public synchronized Drawable c(@NonNull Context context, @DrawableRes int i2) {
        return this.f984a.j(context, i2);
    }

    synchronized Drawable d(@NonNull Context context, @DrawableRes int i2, boolean z2) {
        return this.f984a.k(context, i2, z2);
    }

    synchronized ColorStateList f(@NonNull Context context, @DrawableRes int i2) {
        return this.f984a.m(context, i2);
    }

    public synchronized void g(@NonNull Context context) {
        this.f984a.s(context);
    }
}
