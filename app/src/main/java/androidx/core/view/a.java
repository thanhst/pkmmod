package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R$id;
import androidx.core.view.accessibility.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f1707c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f1708a;

    /* renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f1709b;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0021a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final a f1710a;

        C0021a(a aVar) {
            this.f1710a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1710a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.view.accessibility.i iVarB = this.f1710a.b(view);
            if (iVarB != null) {
                return (AccessibilityNodeProvider) iVarB.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1710a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.view.accessibility.h hVarQ = androidx.core.view.accessibility.h.Q(accessibilityNodeInfo);
            hVarQ.M(ViewCompat.C(view));
            hVarQ.K(ViewCompat.z(view));
            hVarQ.L(ViewCompat.m(view));
            hVarQ.O(ViewCompat.v(view));
            this.f1710a.g(view, hVarQ);
            hVarQ.c(accessibilityNodeInfo.getText(), view);
            List<h.a> listC = a.c(view);
            for (int i2 = 0; i2 < listC.size(); i2++) {
                hVarQ.a(listC.get(i2));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1710a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1710a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f1710a.j(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.f1710a.l(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1710a.m(view, accessibilityEvent);
        }
    }

    /* compiled from: AccessibilityDelegateCompat.java */
    @RequiresApi(16)
    static class b {
        @DoNotInline
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        @DoNotInline
        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i2, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i2, bundle);
        }
    }

    public a() {
        this(f1707c);
    }

    static List<h.a> c(View view) {
        List<h.a> list = (List) view.getTag(R$id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrL = androidx.core.view.accessibility.h.l(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; clickableSpanArrL != null && i2 < clickableSpanArrL.length; i2++) {
                if (clickableSpan.equals(clickableSpanArrL[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f1708a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Nullable
    public androidx.core.view.accessibility.i b(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = b.a(this.f1708a, view);
        if (accessibilityNodeProviderA != null) {
            return new androidx.core.view.accessibility.i(accessibilityNodeProviderA);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f1709b;
    }

    public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f1708a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(@NonNull View view, @NonNull androidx.core.view.accessibility.h hVar) {
        this.f1708a.onInitializeAccessibilityNodeInfo(view, hVar.P());
    }

    public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f1708a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f1708a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(@NonNull View view, int i2, @Nullable Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        List<h.a> listC = c(view);
        boolean zB = false;
        int i3 = 0;
        while (true) {
            if (i3 >= listC.size()) {
                break;
            }
            h.a aVar = listC.get(i3);
            if (aVar.a() == i2) {
                zB = aVar.c(view, bundle);
                break;
            }
            i3++;
        }
        if (!zB) {
            zB = b.b(this.f1708a, view, i2, bundle);
        }
        return (zB || i2 != R$id.accessibility_action_clickable_span || bundle == null) ? zB : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(@NonNull View view, int i2) {
        this.f1708a.sendAccessibilityEvent(view, i2);
    }

    public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f1708a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public a(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.f1708a = accessibilityDelegate;
        this.f1709b = new C0021a(this);
    }
}
