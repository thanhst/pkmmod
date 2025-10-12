package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {

    /* renamed from: u0, reason: collision with root package name */
    static final o f736u0;
    final ImageView A;
    private final View B;
    private p C;
    private Rect D;
    private Rect E;
    private int[] F;
    private int[] G;
    private final ImageView H;
    private final Drawable I;
    private final int J;
    private final int K;
    private final Intent L;
    private final Intent M;
    private final CharSequence N;
    private m O;
    private l P;
    View.OnFocusChangeListener Q;
    private n R;
    private View.OnClickListener S;
    private boolean T;
    private boolean U;
    CursorAdapter V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence f737a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f738b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f739c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f740d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f741e0;

    /* renamed from: f0, reason: collision with root package name */
    private CharSequence f742f0;

    /* renamed from: g0, reason: collision with root package name */
    private CharSequence f743g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f744h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f745i0;

    /* renamed from: j0, reason: collision with root package name */
    SearchableInfo f746j0;

    /* renamed from: k0, reason: collision with root package name */
    private Bundle f747k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Runnable f748l0;

    /* renamed from: m0, reason: collision with root package name */
    private Runnable f749m0;

    /* renamed from: n0, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f750n0;

    /* renamed from: o0, reason: collision with root package name */
    private final View.OnClickListener f751o0;

    /* renamed from: p0, reason: collision with root package name */
    View.OnKeyListener f752p0;

    /* renamed from: q0, reason: collision with root package name */
    private final TextView.OnEditorActionListener f753q0;

    /* renamed from: r0, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f754r0;

    /* renamed from: s0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f755s0;

    /* renamed from: t, reason: collision with root package name */
    final SearchAutoComplete f756t;

    /* renamed from: t0, reason: collision with root package name */
    private TextWatcher f757t0;

    /* renamed from: u, reason: collision with root package name */
    private final View f758u;

    /* renamed from: v, reason: collision with root package name */
    private final View f759v;

    /* renamed from: w, reason: collision with root package name */
    private final View f760w;

    /* renamed from: x, reason: collision with root package name */
    final ImageView f761x;

    /* renamed from: y, reason: collision with root package name */
    final ImageView f762y;

    /* renamed from: z, reason: collision with root package name */
    final ImageView f763z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: g, reason: collision with root package name */
        boolean f764g;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f764g + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f764g));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f764g = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* renamed from: i, reason: collision with root package name */
        private int f765i;

        /* renamed from: j, reason: collision with root package name */
        private SearchView f766j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f767k;

        /* renamed from: l, reason: collision with root package name */
        final Runnable f768l;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 < 600) {
                return (i2 < 640 || i3 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f736u0.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void d() {
            if (this.f767k) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f767k = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f765i <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f767k) {
                removeCallbacks(this.f768l);
                post(this.f768l);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z2, int i2, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z2, i2, rect);
            this.f766j.V();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f766j.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f766j.hasFocus() && getVisibility() == 0) {
                this.f767k = true;
                if (SearchView.I(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z2) {
                this.f767k = false;
                removeCallbacks(this.f768l);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f767k = true;
                    return;
                }
                this.f767k = false;
                removeCallbacks(this.f768l);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f766j = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f765i = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f768l = new a();
            this.f765i = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SearchView.this.U(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.b0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CursorAdapter cursorAdapter = SearchView.this.V;
            if (cursorAdapter instanceof e2) {
                cursorAdapter.a(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.Q;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z2);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            SearchView.this.x();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SearchView searchView = SearchView.this;
            if (view == searchView.f761x) {
                searchView.R();
                return;
            }
            if (view == searchView.f763z) {
                searchView.N();
                return;
            }
            if (view == searchView.f762y) {
                searchView.S();
            } else if (view == searchView.A) {
                searchView.W();
            } else if (view == searchView.f756t) {
                searchView.D();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f746j0 == null) {
                return false;
            }
            if (searchView.f756t.isPopupShowing() && SearchView.this.f756t.getListSelection() != -1) {
                return SearchView.this.T(view, i2, keyEvent);
            }
            if (SearchView.this.f756t.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.L(0, null, searchView2.f756t.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            SearchView.this.S();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.O(i2, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.P(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @RequiresApi(29)
    static class k {
        @DoNotInline
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @DoNotInline
        static void b(SearchAutoComplete searchAutoComplete, int i2) {
            searchAutoComplete.setInputMethodMode(i2);
        }
    }

    public interface l {
        boolean onClose();
    }

    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    public interface n {
        boolean a(int i2);

        boolean b(int i2);
    }

    private static class o {

        /* renamed from: a, reason: collision with root package name */
        private Method f780a;

        /* renamed from: b, reason: collision with root package name */
        private Method f781b;

        /* renamed from: c, reason: collision with root package name */
        private Method f782c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        o() throws NoSuchMethodException, SecurityException {
            this.f780a = null;
            this.f781b = null;
            this.f782c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f780a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f781b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f782c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.f781b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.f780a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.f782c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class p extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f783a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f784b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f785c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f786d;

        /* renamed from: e, reason: collision with root package name */
        private final int f787e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f788f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f787e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f784b = new Rect();
            this.f786d = new Rect();
            this.f785c = new Rect();
            a(rect, rect2);
            this.f783a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f784b.set(rect);
            this.f786d.set(rect);
            Rect rect3 = this.f786d;
            int i2 = this.f787e;
            rect3.inset(-i2, -i2);
            this.f785c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z2;
            boolean z3;
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z4 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z3 = this.f788f;
                    if (z3 && !this.f786d.contains(x2, y2)) {
                        z4 = z3;
                        z2 = false;
                    }
                } else {
                    if (action == 3) {
                        z3 = this.f788f;
                        this.f788f = false;
                    }
                    z2 = true;
                    z4 = false;
                }
                z4 = z3;
                z2 = true;
            } else {
                if (this.f784b.contains(x2, y2)) {
                    this.f788f = true;
                    z2 = true;
                }
                z2 = true;
                z4 = false;
            }
            if (!z4) {
                return false;
            }
            if (!z2 || this.f785c.contains(x2, y2)) {
                Rect rect = this.f785c;
                motionEvent.setLocation(x2 - rect.left, y2 - rect.top);
            } else {
                motionEvent.setLocation(this.f783a.getWidth() / 2, this.f783a.getHeight() / 2);
            }
            return this.f783a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f736u0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private Intent A(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f747k0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent B(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void C() {
        this.f756t.dismissDropDown();
    }

    private void E(View view, Rect rect) {
        view.getLocationInWindow(this.F);
        getLocationInWindow(this.G);
        int[] iArr = this.F;
        int i2 = iArr[1];
        int[] iArr2 = this.G;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence F(CharSequence charSequence) {
        if (!this.T || this.I == null) {
            return charSequence;
        }
        double textSize = this.f756t.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.I.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.I), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean G() {
        SearchableInfo searchableInfo = this.f746j0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f746j0.getVoiceSearchLaunchWebSearch()) {
            intent = this.L;
        } else if (this.f746j0.getVoiceSearchLaunchRecognizer()) {
            intent = this.M;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean I(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean J() {
        return (this.W || this.f741e0) && !H();
    }

    private void K(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private boolean M(int i2, int i3, String str) {
        Cursor cursorB = this.V.b();
        if (cursorB == null || !cursorB.moveToPosition(i2)) {
            return false;
        }
        K(z(cursorB, i3, str));
        return true;
    }

    private void X() {
        post(this.f748l0);
    }

    private void Y(int i2) {
        Editable text = this.f756t.getText();
        Cursor cursorB = this.V.b();
        if (cursorB == null) {
            return;
        }
        if (!cursorB.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceConvertToString = this.V.convertToString(cursorB);
        if (charSequenceConvertToString != null) {
            setQuery(charSequenceConvertToString);
        } else {
            setQuery(text);
        }
    }

    private void a0() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f756t.getText());
        if (!z3 && (!this.T || this.f744h0)) {
            z2 = false;
        }
        this.f763z.setVisibility(z2 ? 0 : 8);
        Drawable drawable = this.f763z.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void c0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f756t;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(F(queryHint));
    }

    private void d0() {
        this.f756t.setThreshold(this.f746j0.getSuggestThreshold());
        this.f756t.setImeOptions(this.f746j0.getImeOptions());
        int inputType = this.f746j0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f746j0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f756t.setInputType(inputType);
        CursorAdapter cursorAdapter = this.V;
        if (cursorAdapter != null) {
            cursorAdapter.a(null);
        }
        if (this.f746j0.getSuggestAuthority() != null) {
            e2 e2Var = new e2(getContext(), this, this.f746j0, this.f750n0);
            this.V = e2Var;
            this.f756t.setAdapter(e2Var);
            ((e2) this.V).w(this.f738b0 ? 2 : 1);
        }
    }

    private void e0() {
        this.f760w.setVisibility((J() && (this.f762y.getVisibility() == 0 || this.A.getVisibility() == 0)) ? 0 : 8);
    }

    private void f0(boolean z2) {
        this.f762y.setVisibility((this.W && J() && hasFocus() && (z2 || !this.f741e0)) ? 0 : 8);
    }

    private void g0(boolean z2) {
        this.U = z2;
        int i2 = z2 ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f756t.getText());
        this.f761x.setVisibility(i2);
        f0(z3);
        this.f758u.setVisibility(z2 ? 8 : 0);
        this.H.setVisibility((this.H.getDrawable() == null || this.T) ? 8 : 0);
        a0();
        h0(!z3);
        e0();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    private void h0(boolean z2) {
        int i2 = 8;
        if (this.f741e0 && !H() && z2) {
            this.f762y.setVisibility(8);
            i2 = 0;
        }
        this.A.setVisibility(i2);
    }

    private void setQuery(CharSequence charSequence) {
        this.f756t.setText(charSequence);
        this.f756t.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private Intent y(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f743g0);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f747k0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f746j0.getSearchActivity());
        return intent;
    }

    private Intent z(Cursor cursor, int i2, String str) {
        int position;
        String strN;
        try {
            String strN2 = e2.n(cursor, "suggest_intent_action");
            if (strN2 == null) {
                strN2 = this.f746j0.getSuggestIntentAction();
            }
            if (strN2 == null) {
                strN2 = "android.intent.action.SEARCH";
            }
            String str2 = strN2;
            String strN3 = e2.n(cursor, "suggest_intent_data");
            if (strN3 == null) {
                strN3 = this.f746j0.getSuggestIntentData();
            }
            if (strN3 != null && (strN = e2.n(cursor, "suggest_intent_data_id")) != null) {
                strN3 = strN3 + "/" + Uri.encode(strN);
            }
            return y(str2, strN3 == null ? null : Uri.parse(strN3), e2.n(cursor, "suggest_intent_extra_data"), e2.n(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    void D() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f756t);
            return;
        }
        o oVar = f736u0;
        oVar.b(this.f756t);
        oVar.a(this.f756t);
    }

    public boolean H() {
        return this.U;
    }

    void L(int i2, String str, String str2) {
        getContext().startActivity(y("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    void N() {
        if (!TextUtils.isEmpty(this.f756t.getText())) {
            this.f756t.setText("");
            this.f756t.requestFocus();
            this.f756t.setImeVisibility(true);
        } else if (this.T) {
            l lVar = this.P;
            if (lVar == null || !lVar.onClose()) {
                clearFocus();
                g0(true);
            }
        }
    }

    boolean O(int i2, int i3, String str) {
        n nVar = this.R;
        if (nVar != null && nVar.b(i2)) {
            return false;
        }
        M(i2, 0, null);
        this.f756t.setImeVisibility(false);
        C();
        return true;
    }

    boolean P(int i2) {
        n nVar = this.R;
        if (nVar != null && nVar.a(i2)) {
            return false;
        }
        Y(i2);
        return true;
    }

    protected void Q(@Nullable CharSequence charSequence) {
        setQuery(charSequence);
    }

    void R() {
        g0(false);
        this.f756t.requestFocus();
        this.f756t.setImeVisibility(true);
        View.OnClickListener onClickListener = this.S;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void S() {
        Editable text = this.f756t.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.O;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.f746j0 != null) {
                L(0, null, text.toString());
            }
            this.f756t.setImeVisibility(false);
            C();
        }
    }

    boolean T(View view, int i2, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f746j0 != null && this.V != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return O(this.f756t.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.f756t.setSelection(i2 == 21 ? 0 : this.f756t.length());
                this.f756t.setListSelection(0);
                this.f756t.clearListSelection();
                this.f756t.b();
                return true;
            }
            if (i2 == 19) {
                this.f756t.getListSelection();
                return false;
            }
        }
        return false;
    }

    void U(CharSequence charSequence) {
        Editable text = this.f756t.getText();
        this.f743g0 = text;
        boolean z2 = !TextUtils.isEmpty(text);
        f0(z2);
        h0(!z2);
        a0();
        e0();
        if (this.O != null && !TextUtils.equals(charSequence, this.f742f0)) {
            this.O.a(charSequence.toString());
        }
        this.f742f0 = charSequence.toString();
    }

    void V() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        g0(H());
        X();
        if (this.f756t.hasFocus()) {
            D();
        }
    }

    void W() {
        SearchableInfo searchableInfo = this.f746j0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(B(this.L, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(A(this.M, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public void Z(CharSequence charSequence, boolean z2) {
        this.f756t.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f756t;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f743g0 = charSequence;
        }
        if (!z2 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        S();
    }

    void b0() {
        int[] iArr = this.f756t.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f759v.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f760w.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f739c0 = true;
        super.clearFocus();
        this.f756t.clearFocus();
        this.f756t.setImeVisibility(false);
        this.f739c0 = false;
    }

    public int getImeOptions() {
        return this.f756t.getImeOptions();
    }

    public int getInputType() {
        return this.f756t.getInputType();
    }

    public int getMaxWidth() {
        return this.f740d0;
    }

    public CharSequence getQuery() {
        return this.f756t.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f737a0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f746j0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.N : getContext().getText(this.f746j0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.K;
    }

    int getSuggestionRowLayout() {
        return this.J;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.V;
    }

    @Override // androidx.appcompat.view.c
    public void onActionViewCollapsed() {
        Z("", false);
        clearFocus();
        g0(true);
        this.f756t.setImeOptions(this.f745i0);
        this.f744h0 = false;
    }

    @Override // androidx.appcompat.view.c
    public void onActionViewExpanded() {
        if (this.f744h0) {
            return;
        }
        this.f744h0 = true;
        int imeOptions = this.f756t.getImeOptions();
        this.f745i0 = imeOptions;
        this.f756t.setImeOptions(imeOptions | 33554432);
        this.f756t.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f748l0);
        post(this.f749m0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            E(this.f756t, this.D);
            Rect rect = this.E;
            Rect rect2 = this.D;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.C;
            if (pVar != null) {
                pVar.a(this.E, this.D);
                return;
            }
            p pVar2 = new p(this.E, this.D, this.f756t);
            this.C = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        if (H()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.f740d0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f740d0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.f740d0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        g0(savedState.f764g);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f764g = H();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        X();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.f739c0 || !isFocusable()) {
            return false;
        }
        if (H()) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.f756t.requestFocus(i2, rect);
        if (zRequestFocus) {
            g0(false);
        }
        return zRequestFocus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.f747k0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            N();
        } else {
            R();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.T == z2) {
            return;
        }
        this.T = z2;
        g0(z2);
        c0();
    }

    public void setImeOptions(int i2) {
        this.f756t.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f756t.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.f740d0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.P = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.Q = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.O = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.S = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.R = nVar;
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.f737a0 = charSequence;
        c0();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.f738b0 = z2;
        CursorAdapter cursorAdapter = this.V;
        if (cursorAdapter instanceof e2) {
            ((e2) cursorAdapter).w(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f746j0 = searchableInfo;
        if (searchableInfo != null) {
            d0();
            c0();
        }
        boolean zG = G();
        this.f741e0 = zG;
        if (zG) {
            this.f756t.setPrivateImeOptions("nm");
        }
        g0(H());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.W = z2;
        g0(H());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.V = cursorAdapter;
        this.f756t.setAdapter(cursorAdapter);
    }

    void x() {
        if (this.B.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f759v.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = v2.b(this);
            int dimensionPixelSize = this.T ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f756t.getDropDownBackground().getPadding(rect);
            this.f756t.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f756t.setDropDownWidth((((this.B.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.D = new Rect();
        this.E = new Rect();
        this.F = new int[2];
        this.G = new int[2];
        this.f748l0 = new b();
        this.f749m0 = new c();
        this.f750n0 = new WeakHashMap<>();
        f fVar = new f();
        this.f751o0 = fVar;
        this.f752p0 = new g();
        h hVar = new h();
        this.f753q0 = hVar;
        i iVar = new i();
        this.f754r0 = iVar;
        j jVar = new j();
        this.f755s0 = jVar;
        this.f757t0 = new a();
        int[] iArr = R$styleable.SearchView;
        k2 k2VarU = k2.u(context, attributeSet, iArr, i2, 0);
        ViewCompat.M(this, context, iArr, attributeSet, k2VarU.q(), i2, 0);
        LayoutInflater.from(context).inflate(k2VarU.m(R$styleable.SearchView_layout, R$layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f756t = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f758u = findViewById(R$id.search_edit_frame);
        View viewFindViewById = findViewById(R$id.search_plate);
        this.f759v = viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.submit_area);
        this.f760w = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.search_button);
        this.f761x = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.search_go_btn);
        this.f762y = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.search_close_btn);
        this.f763z = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.search_voice_btn);
        this.A = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.search_mag_icon);
        this.H = imageView5;
        ViewCompat.R(viewFindViewById, k2VarU.f(R$styleable.SearchView_queryBackground));
        ViewCompat.R(viewFindViewById2, k2VarU.f(R$styleable.SearchView_submitBackground));
        int i3 = R$styleable.SearchView_searchIcon;
        imageView.setImageDrawable(k2VarU.f(i3));
        imageView2.setImageDrawable(k2VarU.f(R$styleable.SearchView_goIcon));
        imageView3.setImageDrawable(k2VarU.f(R$styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(k2VarU.f(R$styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(k2VarU.f(i3));
        this.I = k2VarU.f(R$styleable.SearchView_searchHintIcon);
        p2.a(imageView, getResources().getString(R$string.abc_searchview_description_search));
        this.J = k2VarU.m(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.K = k2VarU.m(R$styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f757t0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f752p0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(k2VarU.a(R$styleable.SearchView_iconifiedByDefault, true));
        int iE = k2VarU.e(R$styleable.SearchView_android_maxWidth, -1);
        if (iE != -1) {
            setMaxWidth(iE);
        }
        this.N = k2VarU.o(R$styleable.SearchView_defaultQueryHint);
        this.f737a0 = k2VarU.o(R$styleable.SearchView_queryHint);
        int iJ = k2VarU.j(R$styleable.SearchView_android_imeOptions, -1);
        if (iJ != -1) {
            setImeOptions(iJ);
        }
        int iJ2 = k2VarU.j(R$styleable.SearchView_android_inputType, -1);
        if (iJ2 != -1) {
            setInputType(iJ2);
        }
        setFocusable(k2VarU.a(R$styleable.SearchView_android_focusable, true));
        k2VarU.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.L = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.M = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.B = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        g0(this.T);
        c0();
    }
}
