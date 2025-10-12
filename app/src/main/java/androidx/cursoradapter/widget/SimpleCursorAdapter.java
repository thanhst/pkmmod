package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* renamed from: q, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] f1867q;

    /* renamed from: r, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] f1868r;

    /* renamed from: s, reason: collision with root package name */
    private int f1869s;

    /* renamed from: t, reason: collision with root package name */
    private a f1870t;

    /* renamed from: u, reason: collision with root package name */
    private b f1871u;

    /* renamed from: v, reason: collision with root package name */
    String[] f1872v;

    public interface a {
        CharSequence convertToString(Cursor cursor);
    }

    public interface b {
        boolean setViewValue(View view, Cursor cursor, int i2);
    }

    private void j(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.f1867q = null;
            return;
        }
        int length = strArr.length;
        int[] iArr = this.f1867q;
        if (iArr == null || iArr.length != length) {
            this.f1867q = new int[length];
        }
        for (int i2 = 0; i2 < length; i2++) {
            this.f1867q[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.a.InterfaceC0025a
    public CharSequence convertToString(Cursor cursor) {
        a aVar = this.f1870t;
        if (aVar != null) {
            return aVar.convertToString(cursor);
        }
        int i2 = this.f1869s;
        return i2 > -1 ? cursor.getString(i2) : super.convertToString(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void d(View view, Context context, Cursor cursor) {
        b bVar = this.f1871u;
        int[] iArr = this.f1868r;
        int length = iArr.length;
        int[] iArr2 = this.f1867q;
        for (int i2 = 0; i2 < length; i2++) {
            View viewFindViewById = view.findViewById(iArr[i2]);
            if (viewFindViewById != null) {
                if (bVar != null ? bVar.setViewValue(viewFindViewById, cursor, iArr2[i2]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i2]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewFindViewById instanceof TextView) {
                        l((TextView) viewFindViewById, string);
                    } else {
                        if (!(viewFindViewById instanceof ImageView)) {
                            throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        k((ImageView) viewFindViewById, string);
                    }
                }
            }
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor i(Cursor cursor) {
        j(cursor, this.f1872v);
        return super.i(cursor);
    }

    public void k(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void l(TextView textView, String str) {
        textView.setText(str);
    }
}
