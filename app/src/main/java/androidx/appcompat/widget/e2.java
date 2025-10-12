package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
class e2 extends ResourceCursorAdapter implements View.OnClickListener {
    private int A;
    private int B;
    private int C;
    private int D;

    /* renamed from: q, reason: collision with root package name */
    private final SearchView f922q;

    /* renamed from: r, reason: collision with root package name */
    private final SearchableInfo f923r;

    /* renamed from: s, reason: collision with root package name */
    private final Context f924s;

    /* renamed from: t, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f925t;

    /* renamed from: u, reason: collision with root package name */
    private final int f926u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f927v;

    /* renamed from: w, reason: collision with root package name */
    private int f928w;

    /* renamed from: x, reason: collision with root package name */
    private ColorStateList f929x;

    /* renamed from: y, reason: collision with root package name */
    private int f930y;

    /* renamed from: z, reason: collision with root package name */
    private int f931z;

    /* compiled from: SuggestionsAdapter.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f932a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f933b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f934c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f935d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f936e;

        public a(View view) {
            this.f932a = (TextView) view.findViewById(R.id.text1);
            this.f933b = (TextView) view.findViewById(R.id.text2);
            this.f934c = (ImageView) view.findViewById(R.id.icon1);
            this.f935d = (ImageView) view.findViewById(R.id.icon2);
            this.f936e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public e2(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f927v = false;
        this.f928w = 1;
        this.f930y = -1;
        this.f931z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.f922q = searchView;
        this.f923r = searchableInfo;
        this.f926u = searchView.getSuggestionCommitIconResId();
        this.f924s = context;
        this.f925t = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = this.f925t.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f929x == null) {
            TypedValue typedValue = new TypedValue();
            this.f924s.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f929x = this.f924s.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f929x, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f924s.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    private Drawable m(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f925t.containsKey(strFlattenToShortString)) {
            Drawable drawableL = l(componentName);
            this.f925t.put(strFlattenToShortString, drawableL != null ? drawableL.getConstantState() : null);
            return drawableL;
        }
        Drawable.ConstantState constantState = this.f925t.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f924s.getResources());
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() throws PackageManager.NameNotFoundException {
        Drawable drawableM = m(this.f923r.getSearchActivity());
        return drawableM != null ? drawableM : this.f924s.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable p(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return q(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f924s.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                }
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable r(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i2 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f924s.getPackageName() + "/" + i2;
            Drawable drawableJ = j(str2);
            if (drawableJ != null) {
                return drawableJ;
            }
            Drawable drawableD = ContextCompat.d(this.f924s, i2);
            z(str2, drawableD);
            return drawableD;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableJ2 = j(str);
            if (drawableJ2 != null) {
                return drawableJ2;
            }
            Drawable drawableP = p(Uri.parse(str));
            z(str, drawableP);
            return drawableP;
        }
    }

    private Drawable s(Cursor cursor) throws NumberFormatException, IOException {
        int i2 = this.B;
        if (i2 == -1) {
            return null;
        }
        Drawable drawableR = r(cursor.getString(i2));
        return drawableR != null ? drawableR : o();
    }

    private Drawable t(Cursor cursor) {
        int i2 = this.C;
        if (i2 == -1) {
            return null;
        }
        return r(cursor.getString(i2));
    }

    private static String v(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f925t.put(str, drawable.getConstantState());
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0025a
    public void a(Cursor cursor) {
        if (this.f927v) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f930y = cursor.getColumnIndex("suggest_text_1");
                this.f931z = cursor.getColumnIndex("suggest_text_2");
                this.A = cursor.getColumnIndex("suggest_text_2_url");
                this.B = cursor.getColumnIndex("suggest_icon_1");
                this.C = cursor.getColumnIndex("suggest_icon_2");
                this.D = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0025a
    public Cursor c(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f922q.getVisibility() == 0 && this.f922q.getWindowVisibility() == 0) {
            try {
                Cursor cursorU = u(this.f923r, string, 50);
                if (cursorU != null) {
                    cursorU.getCount();
                    return cursorU;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0025a
    public CharSequence convertToString(Cursor cursor) {
        String strN;
        String strN2;
        if (cursor == null) {
            return null;
        }
        String strN3 = n(cursor, "suggest_intent_query");
        if (strN3 != null) {
            return strN3;
        }
        if (this.f923r.shouldRewriteQueryFromData() && (strN2 = n(cursor, "suggest_intent_data")) != null) {
            return strN2;
        }
        if (!this.f923r.shouldRewriteQueryFromText() || (strN = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strN;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void d(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i2 = this.D;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.f932a != null) {
            y(aVar.f932a, v(cursor, this.f930y));
        }
        if (aVar.f933b != null) {
            String strV = v(cursor, this.A);
            CharSequence charSequenceK = strV != null ? k(strV) : v(cursor, this.f931z);
            if (TextUtils.isEmpty(charSequenceK)) {
                TextView textView = aVar.f932a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f932a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f932a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f932a.setMaxLines(1);
                }
            }
            y(aVar.f933b, charSequenceK);
        }
        ImageView imageView = aVar.f934c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = aVar.f935d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i4 = this.f928w;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            aVar.f936e.setVisibility(8);
            return;
        }
        aVar.f936e.setVisibility(0);
        aVar.f936e.setTag(aVar.f932a.getText());
        aVar.f936e.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewG = super.g(context, cursor, viewGroup);
        viewG.setTag(new a(viewG));
        ((ImageView) viewG.findViewById(R$id.edit_query)).setImageResource(this.f926u);
        return viewG;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View viewF = f(this.f924s, b(), viewGroup);
            if (viewF != null) {
                ((a) viewF.getTag()).f932a.setText(e2.toString());
            }
            return viewF;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View viewG = g(this.f924s, b(), viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f932a.setText(e2.toString());
            }
            return viewG;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f922q.Q((CharSequence) tag);
        }
    }

    Drawable q(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f924s.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor u(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f924s.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void w(int i2) {
        this.f928w = i2;
    }
}
