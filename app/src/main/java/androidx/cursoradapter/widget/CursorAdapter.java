package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import androidx.cursoradapter.widget.a;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, a.InterfaceC0025a {

    /* renamed from: e, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean f1853e;

    /* renamed from: f, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean f1854f;

    /* renamed from: g, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor f1855g;

    /* renamed from: h, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context f1856h;

    /* renamed from: i, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int f1857i;

    /* renamed from: j, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected a f1858j;

    /* renamed from: k, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver f1859k;

    /* renamed from: l, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected androidx.cursoradapter.widget.a f1860l;

    /* renamed from: m, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider f1861m;

    private class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            CursorAdapter.this.h();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f1853e = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f1853e = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z2) {
        e(context, cursor, z2 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor cursorI = i(cursor);
        if (cursorI != null) {
            cursorI.close();
        }
    }

    @Override // androidx.cursoradapter.widget.a.InterfaceC0025a
    public Cursor b() {
        return this.f1855g;
    }

    public Cursor c(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f1861m;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f1855g;
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public abstract void d(View view, Context context, Cursor cursor);

    void e(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f1854f = true;
        } else {
            this.f1854f = false;
        }
        boolean z2 = cursor != null;
        this.f1855g = cursor;
        this.f1853e = z2;
        this.f1856h = context;
        this.f1857i = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1858j = new a();
            this.f1859k = new b();
        } else {
            this.f1858j = null;
            this.f1859k = null;
        }
        if (z2) {
            a aVar = this.f1858j;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1859k;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return g(context, cursor, viewGroup);
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1853e || (cursor = this.f1855g) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1853e) {
            return null;
        }
        this.f1855g.moveToPosition(i2);
        if (view == null) {
            view = f(this.f1856h, this.f1855g, viewGroup);
        }
        d(view, this.f1856h, this.f1855g);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1860l == null) {
            this.f1860l = new androidx.cursoradapter.widget.a(this);
        }
        return this.f1860l;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f1853e || (cursor = this.f1855g) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1855g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.f1853e && (cursor = this.f1855g) != null && cursor.moveToPosition(i2)) {
            return this.f1855g.getLong(this.f1857i);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1853e) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f1855g.moveToPosition(i2)) {
            if (view == null) {
                view = g(this.f1856h, this.f1855g, viewGroup);
            }
            d(view, this.f1856h, this.f1855g);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i2);
    }

    protected void h() {
        Cursor cursor;
        if (!this.f1854f || (cursor = this.f1855g) == null || cursor.isClosed()) {
            return;
        }
        this.f1853e = this.f1855g.requery();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f1855g;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.f1858j;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1859k;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1855g = cursor;
        if (cursor != null) {
            a aVar2 = this.f1858j;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f1859k;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1857i = cursor.getColumnIndexOrThrow("_id");
            this.f1853e = true;
            notifyDataSetChanged();
        } else {
            this.f1857i = -1;
            this.f1853e = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
