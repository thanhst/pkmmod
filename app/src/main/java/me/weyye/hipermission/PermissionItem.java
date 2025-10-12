package me.weyye.hipermission;

import java.io.Serializable;

/* loaded from: classes.dex */
public class PermissionItem implements Serializable {
    public String Permission;
    public int PermissionIconRes;
    public String PermissionName;

    public PermissionItem(String str, String str2, int i2) {
        this.Permission = str;
        this.PermissionName = str2;
        this.PermissionIconRes = i2;
    }

    public PermissionItem(String str) {
        this.Permission = str;
    }
}
