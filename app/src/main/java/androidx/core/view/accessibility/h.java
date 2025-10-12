package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.core.R$id;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.k;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static int f1714d;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f1715a;

    /* renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int f1716b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f1717c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;

        @NonNull
        public static final a G;

        @NonNull
        public static final a H;

        @NonNull
        public static final a I;

        @NonNull
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;

        @NonNull
        public static final a P;

        @NonNull
        public static final a Q;

        @NonNull
        public static final a R;

        @NonNull
        public static final a S;

        @NonNull
        public static final a T;

        @NonNull
        public static final a U;

        /* renamed from: e, reason: collision with root package name */
        public static final a f1718e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f1719f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f1720g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f1721h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f1722i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f1723j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f1724k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f1725l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f1726m = new a(256, null, k.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f1727n = new a(512, null, k.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f1728o = new a(1024, null, k.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f1729p = new a(2048, null, k.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f1730q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f1731r = new a(Utility.DEFAULT_STREAM_BUFFER_SIZE, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f1732s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f1733t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f1734u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f1735v = new a(131072, null, k.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f1736w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f1737x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f1738y = new a(1048576, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f1739z = new a(2097152, null, k.h.class);

        /* renamed from: a, reason: collision with root package name */
        final Object f1740a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1741b;

        /* renamed from: c, reason: collision with root package name */
        private final Class<? extends k.a> f1742c;

        /* renamed from: d, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final k f1743d;

        static {
            int i2 = Build.VERSION.SDK_INT;
            A = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, k.e.class);
            C = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(i2 >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            H = new a(i2 >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            I = new a(i2 >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            J = new a(i2 >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            K = new a(i2 >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            L = new a(i2 >= 24 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, k.f.class);
            M = new a(i2 >= 26 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, k.d.class);
            N = new a(i2 >= 28 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(i2 >= 28 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            P = new a(i2 >= 30 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(i2 >= 30 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            R = new a(i2 >= 32 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            S = new a(i2 >= 32 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            T = new a(i2 >= 32 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            U = new a(i2 >= 33 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo$AccessibilityAction) this.f1740a).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo$AccessibilityAction) this.f1740a).getLabel();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean c(View view, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (this.f1743d == null) {
                return false;
            }
            k.a aVar = null;
            Class<? extends k.a> cls = this.f1742c;
            if (cls != null) {
                try {
                    k.a aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.a(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e2) {
                        e = e2;
                        aVar = aVarNewInstance;
                        Class<? extends k.a> cls2 = this.f1742c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                        return this.f1743d.a(view, aVar);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            return this.f1743d.a(view, aVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f1740a;
            return obj2 == null ? aVar.f1740a == null : obj2.equals(aVar.f1740a);
        }

        public int hashCode() {
            Object obj = this.f1740a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends k.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, k kVar, Class<? extends k.a> cls) {
            this.f1741b = i2;
            this.f1743d = kVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f1740a = new AccessibilityNodeInfo$AccessibilityAction(i2, charSequence);
            } else {
                this.f1740a = obj;
            }
            this.f1742c = cls;
        }
    }

    private h(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1715a = accessibilityNodeInfo;
    }

    private void H(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayQ = q(view);
        if (sparseArrayQ != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArrayQ.size(); i2++) {
                if (sparseArrayQ.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sparseArrayQ.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void I(int i2, boolean z2) {
        Bundle bundleN = n();
        if (bundleN != null) {
            int i3 = bundleN.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i2 ^ (-1));
            if (!z2) {
                i2 = 0;
            }
            bundleN.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    public static h Q(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new h(accessibilityNodeInfo);
    }

    private void b(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    private void d() {
        this.f1715a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f1715a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f1715a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f1715a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> e(String str) {
        ArrayList<Integer> integerArrayList = this.f1715a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f1715a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String g(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] l(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> o(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayQ = q(view);
        if (sparseArrayQ != null) {
            return sparseArrayQ;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> q(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    private boolean u() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int v(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f1714d;
        f1714d = i3 + 1;
        return i3;
    }

    public boolean A() {
        return this.f1715a.isFocusable();
    }

    public boolean B() {
        return this.f1715a.isFocused();
    }

    public boolean C() {
        return this.f1715a.isLongClickable();
    }

    public boolean D() {
        return this.f1715a.isPassword();
    }

    public boolean E() {
        return this.f1715a.isScrollable();
    }

    public boolean F() {
        return this.f1715a.isSelected();
    }

    public boolean G(int i2, Bundle bundle) {
        return this.f1715a.performAction(i2, bundle);
    }

    public void J(CharSequence charSequence) {
        this.f1715a.setClassName(charSequence);
    }

    public void K(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1715a.setHeading(z2);
        } else {
            I(2, z2);
        }
    }

    public void L(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1715a.setPaneTitle(charSequence);
        } else {
            this.f1715a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void M(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1715a.setScreenReaderFocusable(z2);
        } else {
            I(1, z2);
        }
    }

    public void N(boolean z2) {
        this.f1715a.setScrollable(z2);
    }

    public void O(@Nullable CharSequence charSequence) {
        if (BuildCompat.c()) {
            this.f1715a.setStateDescription(charSequence);
        } else {
            this.f1715a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public AccessibilityNodeInfo P() {
        return this.f1715a;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1715a.addAction((AccessibilityNodeInfo$AccessibilityAction) aVar.f1740a);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            d();
            H(view);
            ClickableSpan[] clickableSpanArrL = l(charSequence);
            if (clickableSpanArrL == null || clickableSpanArrL.length <= 0) {
                return;
            }
            n().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
            SparseArray<WeakReference<ClickableSpan>> sparseArrayO = o(view);
            for (int i2 = 0; i2 < clickableSpanArrL.length; i2++) {
                int iV = v(clickableSpanArrL[i2], sparseArrayO);
                sparseArrayO.put(iV, new WeakReference<>(clickableSpanArrL[i2]));
                b(clickableSpanArrL[i2], (Spanned) charSequence, iV);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1715a;
        if (accessibilityNodeInfo == null) {
            if (hVar.f1715a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(hVar.f1715a)) {
            return false;
        }
        return this.f1717c == hVar.f1717c && this.f1716b == hVar.f1716b;
    }

    public List<a> f() {
        List actionList = Build.VERSION.SDK_INT >= 21 ? this.f1715a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(actionList.get(i2)));
        }
        return arrayList;
    }

    @Deprecated
    public int h() {
        return this.f1715a.getActions();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1715a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    @Deprecated
    public void i(Rect rect) {
        this.f1715a.getBoundsInParent(rect);
    }

    public void j(Rect rect) {
        this.f1715a.getBoundsInScreen(rect);
    }

    public CharSequence k() {
        return this.f1715a.getClassName();
    }

    public CharSequence m() {
        return this.f1715a.getContentDescription();
    }

    public Bundle n() {
        return this.f1715a.getExtras();
    }

    public CharSequence p() {
        return this.f1715a.getPackageName();
    }

    public CharSequence r() {
        if (!u()) {
            return this.f1715a.getText();
        }
        List<Integer> listE = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listE2 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listE3 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listE4 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1715a.getText(), 0, this.f1715a.getText().length()));
        for (int i2 = 0; i2 < listE.size(); i2++) {
            spannableString.setSpan(new androidx.core.view.accessibility.a(listE4.get(i2).intValue(), this, n().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listE.get(i2).intValue(), listE2.get(i2).intValue(), listE3.get(i2).intValue());
        }
        return spannableString;
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public String s() {
        return BuildCompat.d() ? this.f1715a.getUniqueId() : this.f1715a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String t() {
        return this.f1715a.getViewIdResourceName();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        i(rect);
        sb.append("; boundsInParent: " + rect);
        j(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(p());
        sb.append("; className: ");
        sb.append(k());
        sb.append("; text: ");
        sb.append(r());
        sb.append("; contentDescription: ");
        sb.append(m());
        sb.append("; viewId: ");
        sb.append(t());
        sb.append("; uniqueId: ");
        sb.append(s());
        sb.append("; checkable: ");
        sb.append(w());
        sb.append("; checked: ");
        sb.append(x());
        sb.append("; focusable: ");
        sb.append(A());
        sb.append("; focused: ");
        sb.append(B());
        sb.append("; selected: ");
        sb.append(F());
        sb.append("; clickable: ");
        sb.append(y());
        sb.append("; longClickable: ");
        sb.append(C());
        sb.append("; enabled: ");
        sb.append(z());
        sb.append("; password: ");
        sb.append(D());
        sb.append("; scrollable: " + E());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> listF = f();
            for (int i2 = 0; i2 < listF.size(); i2++) {
                a aVar = listF.get(i2);
                String strG = g(aVar.a());
                if (strG.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    strG = aVar.b().toString();
                }
                sb.append(strG);
                if (i2 != listF.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iH = h();
            while (iH != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iH);
                iH &= iNumberOfTrailingZeros ^ (-1);
                sb.append(g(iNumberOfTrailingZeros));
                if (iH != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean w() {
        return this.f1715a.isCheckable();
    }

    public boolean x() {
        return this.f1715a.isChecked();
    }

    public boolean y() {
        return this.f1715a.isClickable();
    }

    public boolean z() {
        return this.f1715a.isEnabled();
    }
}
