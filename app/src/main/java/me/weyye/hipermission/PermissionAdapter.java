package me.weyye.hipermission;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes.dex */
public class PermissionAdapter extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    private List<PermissionItem> f4043e;

    /* renamed from: f, reason: collision with root package name */
    private int f4044f;

    /* renamed from: g, reason: collision with root package name */
    private int f4045g;

    public PermissionAdapter(List<PermissionItem> list) {
        this.f4043e = list;
    }

    public void a(int i2) {
        this.f4045g = i2;
        notifyDataSetChanged();
    }

    public void b(int i2) {
        this.f4044f = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4043e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f4043e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        PermissionItem permissionItem = this.f4043e.get(i2);
        View viewInflate = View.inflate(viewGroup.getContext(), R$layout.permission_info_item, null);
        int iBlue = Color.blue(this.f4045g);
        int iGreen = Color.green(this.f4045g);
        int iRed = Color.red(this.f4045g);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.icon);
        imageView.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, iRed, 0.0f, 1.0f, 0.0f, 0.0f, iGreen, 0.0f, 0.0f, 1.0f, 0.0f, iBlue, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f}));
        TextView textView = (TextView) viewInflate.findViewById(R$id.name);
        int i3 = this.f4044f;
        if (i3 != 0) {
            textView.setTextColor(i3);
        }
        imageView.setImageResource(permissionItem.PermissionIconRes);
        textView.setText(permissionItem.PermissionName);
        return viewInflate;
    }
}
