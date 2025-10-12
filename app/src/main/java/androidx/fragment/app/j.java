package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R$styleable;

/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
class j implements LayoutInflater.Factory2 {

    /* renamed from: e, reason: collision with root package name */
    final FragmentManager f2256e;

    /* compiled from: FragmentLayoutInflaterFactory.java */
    class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f2257e;

        a(p pVar) {
            this.f2257e = pVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f2257e.k();
            this.f2257e.m();
            SpecialEffectsController.n((ViewGroup) fragmentK.mView.getParent(), j.this.f2256e).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    j(FragmentManager fragmentManager) {
        this.f2256e = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        p pVarW;
        if (f.class.getName().equals(str)) {
            return new f(context, attributeSet, this.f2256e);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !h.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentH0 = resourceId != -1 ? this.f2256e.h0(resourceId) : null;
        if (fragmentH0 == null && string != null) {
            fragmentH0 = this.f2256e.i0(string);
        }
        if (fragmentH0 == null && id != -1) {
            fragmentH0 = this.f2256e.h0(id);
        }
        if (fragmentH0 == null) {
            fragmentH0 = this.f2256e.q0().a(context.getClassLoader(), attributeValue);
            fragmentH0.mFromLayout = true;
            fragmentH0.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentH0.mContainerId = id;
            fragmentH0.mTag = string;
            fragmentH0.mInLayout = true;
            FragmentManager fragmentManager = this.f2256e;
            fragmentH0.mFragmentManager = fragmentManager;
            fragmentH0.mHost = fragmentManager.t0();
            fragmentH0.onInflate(this.f2256e.t0().f(), attributeSet, fragmentH0.mSavedFragmentState);
            pVarW = this.f2256e.g(fragmentH0);
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentH0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentH0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentH0.mInLayout = true;
            FragmentManager fragmentManager2 = this.f2256e;
            fragmentH0.mFragmentManager = fragmentManager2;
            fragmentH0.mHost = fragmentManager2.t0();
            fragmentH0.onInflate(this.f2256e.t0().f(), attributeSet, fragmentH0.mSavedFragmentState);
            pVarW = this.f2256e.w(fragmentH0);
            if (FragmentManager.F0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentH0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        fragmentH0.mContainer = (ViewGroup) view;
        pVarW.m();
        pVarW.j();
        View view2 = fragmentH0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentH0.mView.getTag() == null) {
            fragmentH0.mView.setTag(string);
        }
        fragmentH0.mView.addOnAttachStateChangeListener(new a(pVarW));
        return fragmentH0.mView;
    }
}
