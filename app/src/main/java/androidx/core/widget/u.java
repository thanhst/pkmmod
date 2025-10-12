package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: ListViewCompat.java */
/* loaded from: classes.dex */
public final class u {

    /* compiled from: ListViewCompat.java */
    @RequiresApi(19)
    static class a {
        @DoNotInline
        static boolean a(ListView listView, int i2) {
            return listView.canScrollList(i2);
        }

        @DoNotInline
        static void b(ListView listView, int i2) {
            listView.scrollListBy(i2);
        }
    }

    public static void a(@NonNull ListView listView, int i2) {
        a.b(listView, i2);
    }
}
