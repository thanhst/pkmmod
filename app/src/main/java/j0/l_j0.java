package j0;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

/* compiled from: XXEQLWV.java */
/* loaded from: classes.dex */
public class l_j0 {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Typeface> f3353a = new HashMap<>();

    public static synchronized Typeface a(Context context, String str) {
        HashMap<String, Typeface> map;
        map = f3353a;
        if (!map.containsKey(str)) {
            map.put(str, str.startsWith("/") ? Typeface.createFromFile(str) : str.equals("DefaultFont") ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.createFromAsset(context.getAssets(), str));
        }
        return map.get(str);
    }
}
