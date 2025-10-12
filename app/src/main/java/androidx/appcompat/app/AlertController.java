package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f81a;

    /* renamed from: b, reason: collision with root package name */
    final k f82b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f83c;

    /* renamed from: d, reason: collision with root package name */
    private final int f84d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f85e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f86f;

    /* renamed from: g, reason: collision with root package name */
    ListView f87g;

    /* renamed from: h, reason: collision with root package name */
    private View f88h;

    /* renamed from: i, reason: collision with root package name */
    private int f89i;

    /* renamed from: j, reason: collision with root package name */
    private int f90j;

    /* renamed from: k, reason: collision with root package name */
    private int f91k;

    /* renamed from: l, reason: collision with root package name */
    private int f92l;

    /* renamed from: m, reason: collision with root package name */
    private int f93m;

    /* renamed from: o, reason: collision with root package name */
    Button f95o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f96p;

    /* renamed from: q, reason: collision with root package name */
    Message f97q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f98r;

    /* renamed from: s, reason: collision with root package name */
    Button f99s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f100t;

    /* renamed from: u, reason: collision with root package name */
    Message f101u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f102v;

    /* renamed from: w, reason: collision with root package name */
    Button f103w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f104x;

    /* renamed from: y, reason: collision with root package name */
    Message f105y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f106z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f94n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: e, reason: collision with root package name */
        private final int f107e;

        /* renamed from: f, reason: collision with root package name */
        private final int f108f;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f108f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f107e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z2, boolean z3) {
            if (z3 && z2) {
                return;
            }
            setPadding(getPaddingLeft(), z2 ? getPaddingTop() : this.f107e, getPaddingRight(), z3 ? getPaddingBottom() : this.f108f);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f95o || (message3 = alertController.f97q) == null) ? (view != alertController.f99s || (message2 = alertController.f101u) == null) ? (view != alertController.f103w || (message = alertController.f105y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f82b).sendToTarget();
        }
    }

    class b implements NestedScrollView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f110a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f111b;

        b(View view, View view2) {
            this.f110a = view;
            this.f111b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.c
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.f(nestedScrollView, this.f110a, this.f111b);
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f113e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f114f;

        c(View view, View view2) {
            this.f113e = view;
            this.f114f = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.A, this.f113e, this.f114f);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f116e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f117f;

        d(View view, View view2) {
            this.f116e = view;
            this.f117f = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.f(absListView, this.f116e, this.f117f);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    class e implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f119e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f120f;

        e(View view, View view2) {
            this.f119e = view;
            this.f120f = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f87g, this.f119e, this.f120f);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f122a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f123b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f125d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f127f;

        /* renamed from: g, reason: collision with root package name */
        public View f128g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f129h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f130i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f131j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f132k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f133l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f134m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f135n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f136o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f137p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f138q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f140s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f141t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f142u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f143v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f144w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f145x;

        /* renamed from: y, reason: collision with root package name */
        public int f146y;

        /* renamed from: z, reason: collision with root package name */
        public View f147z;

        /* renamed from: c, reason: collision with root package name */
        public int f124c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f126e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f139r = true;

        class a extends ArrayAdapter<CharSequence> {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecycleListView f148e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f148e = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i2]) {
                    this.f148e.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* renamed from: e, reason: collision with root package name */
            private final int f150e;

            /* renamed from: f, reason: collision with root package name */
            private final int f151f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ RecycleListView f152g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ AlertController f153h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z2, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z2);
                this.f152g = recycleListView;
                this.f153h = alertController;
                Cursor cursor2 = getCursor();
                this.f150e = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f151f = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f150e));
                this.f152g.setItemChecked(cursor.getPosition(), cursor.getInt(this.f151f) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f123b.inflate(this.f153h.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AlertController f155e;

            c(AlertController alertController) {
                this.f155e = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                f.this.f145x.onClick(this.f155e.f82b, i2);
                if (f.this.H) {
                    return;
                }
                this.f155e.f82b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecycleListView f157e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AlertController f158f;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f157e = recycleListView;
                this.f158f = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i2] = this.f157e.isItemChecked(i2);
                }
                f.this.J.onClick(this.f158f.f82b, i2, this.f157e.isItemChecked(i2));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f122a = context;
            this.f123b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f123b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                hVar = this.K == null ? new a(this.f122a, alertController.M, R.id.text1, this.f143v, recycleListView) : new b(this.f122a, this.K, false, recycleListView, alertController);
            } else {
                int i2 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    hVar = new SimpleCursorAdapter(this.f122a, i2, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    hVar = this.f144w;
                    if (hVar == null) {
                        hVar = new h(this.f122a, i2, R.id.text1, this.f143v);
                    }
                }
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = hVar;
            alertController.I = this.I;
            if (this.f145x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f87g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f128g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f127f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f125d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i2 = this.f124c;
                if (i2 != 0) {
                    alertController.m(i2);
                }
                int i3 = this.f126e;
                if (i3 != 0) {
                    alertController.m(alertController.c(i3));
                }
            }
            CharSequence charSequence2 = this.f129h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f130i;
            if (charSequence3 != null || this.f131j != null) {
                alertController.k(-1, charSequence3, this.f132k, null, this.f131j);
            }
            CharSequence charSequence4 = this.f133l;
            if (charSequence4 != null || this.f134m != null) {
                alertController.k(-2, charSequence4, this.f135n, null, this.f134m);
            }
            CharSequence charSequence5 = this.f136o;
            if (charSequence5 != null || this.f137p != null) {
                alertController.k(-3, charSequence5, this.f138q, null, this.f137p);
            }
            if (this.f143v != null || this.K != null || this.f144w != null) {
                b(alertController);
            }
            View view2 = this.f147z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i4 = this.f146y;
            if (i4 != 0) {
                alertController.r(i4);
            }
        }
    }

    private static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f160a;

        public g(DialogInterface dialogInterface) {
            this.f160a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f160a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, k kVar, Window window) {
        this.f81a = context;
        this.f82b = kVar;
        this.f83c = window;
        this.R = new g(kVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f84d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        kVar.j(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @Nullable
    private ViewGroup i(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i2 = this.K;
        return i2 == 0 ? this.J : this.Q == 1 ? i2 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i2, int i3) {
        View viewFindViewById = this.f83c.findViewById(R$id.scrollIndicatorUp);
        View viewFindViewById2 = this.f83c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.Y(view, i2, i3);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f86f != null) {
            this.A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.A.post(new c(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f87g;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f87g.post(new e(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        int i2;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f95o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f96p) && this.f98r == null) {
            this.f95o.setVisibility(8);
            i2 = 0;
        } else {
            this.f95o.setText(this.f96p);
            Drawable drawable = this.f98r;
            if (drawable != null) {
                int i3 = this.f84d;
                drawable.setBounds(0, 0, i3, i3);
                this.f95o.setCompoundDrawables(this.f98r, null, null, null);
            }
            this.f95o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f99s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f100t) && this.f102v == null) {
            this.f99s.setVisibility(8);
        } else {
            this.f99s.setText(this.f100t);
            Drawable drawable2 = this.f102v;
            if (drawable2 != null) {
                int i4 = this.f84d;
                drawable2.setBounds(0, 0, i4, i4);
                this.f99s.setCompoundDrawables(this.f102v, null, null, null);
            }
            this.f99s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f103w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f104x) && this.f106z == null) {
            this.f103w.setVisibility(8);
        } else {
            this.f103w.setText(this.f104x);
            Drawable drawable3 = this.f106z;
            if (drawable3 != null) {
                int i5 = this.f84d;
                drawable3.setBounds(0, 0, i5, i5);
                this.f103w.setCompoundDrawables(this.f106z, null, null, null);
            }
            this.f103w.setVisibility(0);
            i2 |= 4;
        }
        if (z(this.f81a)) {
            if (i2 == 1) {
                b(this.f95o);
            } else if (i2 == 2) {
                b(this.f99s);
            } else if (i2 == 4) {
                b(this.f103w);
            }
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f83c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f86f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f87g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f87g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View viewInflate = this.f88h;
        if (viewInflate == null) {
            viewInflate = this.f89i != 0 ? LayoutInflater.from(this.f81a).inflate(this.f89i, viewGroup, false) : null;
        }
        boolean z2 = viewInflate != null;
        if (!z2 || !a(viewInflate)) {
            this.f83c.setFlags(131072, 131072);
        }
        if (!z2) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f83c.findViewById(R$id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f94n) {
            frameLayout.setPadding(this.f90j, this.f91k, this.f92l, this.f93m);
        }
        if (this.f87g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f83c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f83c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f85e)) || !this.P) {
            this.f83c.findViewById(R$id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f83c.findViewById(R$id.alertTitle);
        this.E = textView;
        textView.setText(this.f85e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f83c.findViewById(R$id.parentPanel);
        int i2 = R$id.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i2);
        int i3 = R$id.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i3);
        int i4 = R$id.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R$id.customPanel);
        w(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i2);
        View viewFindViewById8 = viewGroup.findViewById(i3);
        View viewFindViewById9 = viewGroup.findViewById(i4);
        ViewGroup viewGroupI = i(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupI2 = i(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupI3 = i(viewFindViewById9, viewFindViewById6);
        v(viewGroupI2);
        u(viewGroupI3);
        x(viewGroupI);
        boolean z2 = viewGroup.getVisibility() != 8;
        boolean z3 = (viewGroupI == null || viewGroupI.getVisibility() == 8) ? 0 : 1;
        boolean z4 = (viewGroupI3 == null || viewGroupI3.getVisibility() == 8) ? false : true;
        if (!z4 && viewGroupI2 != null && (viewFindViewById2 = viewGroupI2.findViewById(R$id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z3 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f86f == null && this.f87g == null) ? null : viewGroupI.findViewById(R$id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupI2 != null && (viewFindViewById = viewGroupI2.findViewById(R$id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f87g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view = this.f87g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(viewGroupI2, view, z3 | (z4 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f87g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i5 = this.I;
        if (i5 > -1) {
            listView2.setItemChecked(i5, true);
            listView2.setSelection(i5);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f81a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f87g;
    }

    public void e() {
        this.f82b.setContentView(j());
        y();
    }

    public boolean g(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public void k(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.f104x = charSequence;
            this.f105y = message;
            this.f106z = drawable;
        } else if (i2 == -2) {
            this.f100t = charSequence;
            this.f101u = message;
            this.f102v = drawable;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f96p = charSequence;
            this.f97q = message;
            this.f98r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f86f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f85e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i2) {
        this.f88h = null;
        this.f89i = i2;
        this.f94n = false;
    }

    public void s(View view) {
        this.f88h = view;
        this.f89i = 0;
        this.f94n = false;
    }

    public void t(View view, int i2, int i3, int i4, int i5) {
        this.f88h = view;
        this.f89i = 0;
        this.f94n = true;
        this.f90j = i2;
        this.f91k = i3;
        this.f92l = i4;
        this.f93m = i5;
    }
}
