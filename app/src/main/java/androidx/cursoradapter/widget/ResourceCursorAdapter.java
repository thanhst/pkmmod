package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: n, reason: collision with root package name */
    private int f1864n;

    /* renamed from: o, reason: collision with root package name */
    private int f1865o;

    /* renamed from: p, reason: collision with root package name */
    private LayoutInflater f1866p;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.f1865o = i2;
        this.f1864n = i2;
        this.f1866p = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1866p.inflate(this.f1865o, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1866p.inflate(this.f1864n, viewGroup, false);
    }
}
