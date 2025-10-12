package com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb;

import android.content.ContentValues;
import android.database.Cursor;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LoginInfo;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class IANotYLC {
    private static LoginInfo cursor2info(Cursor cursor, int i2, int i3, int i4) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAppId(cursor.getInt(i2));
        loginInfo.setUserId(cursor.getInt(i3));
        loginInfo.setClientDate(cursor.getString(i4));
        return loginInfo;
    }

    public static void deleteLogin(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LoginInfo loginInfo) {
        deQqdtXZTDrGxB.delete("login_table", "userId=?", new String[]{String.valueOf(loginInfo.getUserId())});
    }

    private static ContentValues info2value(LoginInfo loginInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(loginInfo.getAppId()));
        contentValues.put("userId", Integer.valueOf(loginInfo.getUserId()));
        contentValues.put("clientDate", loginInfo.getClientDate());
        return contentValues;
    }

    public static void insertLogin(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LoginInfo loginInfo) {
        deQqdtXZTDrGxB.insert("login_table", info2value(loginInfo));
    }

    public static ArrayList<LoginInfo> queryAllLogin(DeQqdtXZTDrGxB deQqdtXZTDrGxB) {
        Cursor cursorQuery = deQqdtXZTDrGxB.query("login_table", null, null, null, "clientDate");
        int columnIndex = cursorQuery.getColumnIndex("appId");
        int columnIndex2 = cursorQuery.getColumnIndex("userId");
        int columnIndex3 = cursorQuery.getColumnIndex("clientDate");
        ArrayList<LoginInfo> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            arrayList.add(cursor2info(cursorQuery, columnIndex, columnIndex2, columnIndex3));
        }
        cursorQuery.close();
        return arrayList;
    }

    public static LoginInfo queryLastLogin(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2) {
        Cursor cursorQuery = deQqdtXZTDrGxB.query("login_table", null, "appId=?", new String[]{String.valueOf(i2)}, "clientDate");
        int columnIndex = cursorQuery.getColumnIndex("appId");
        int columnIndex2 = cursorQuery.getColumnIndex("userId");
        int columnIndex3 = cursorQuery.getColumnIndex("clientDate");
        LoginInfo loginInfoCursor2info = null;
        while (cursorQuery.moveToNext()) {
            loginInfoCursor2info = cursor2info(cursorQuery, columnIndex, columnIndex2, columnIndex3);
        }
        cursorQuery.close();
        return loginInfoCursor2info;
    }

    public static LoginInfo queryLogin(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LoginInfo loginInfo) {
        LoginInfo loginInfoCursor2info = null;
        Cursor cursorQuery = deQqdtXZTDrGxB.query("login_table", null, "appId=? and userId=?", new String[]{String.valueOf(loginInfo.getAppId()), String.valueOf(loginInfo.getUserId())});
        int columnIndex = cursorQuery.getColumnIndex("appId");
        int columnIndex2 = cursorQuery.getColumnIndex("userId");
        int columnIndex3 = cursorQuery.getColumnIndex("clientDate");
        while (cursorQuery.moveToNext()) {
            loginInfoCursor2info = cursor2info(cursorQuery, columnIndex, columnIndex2, columnIndex3);
        }
        cursorQuery.close();
        return loginInfoCursor2info;
    }

    public static void updateLogin(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LoginInfo loginInfo) {
        deQqdtXZTDrGxB.update("login_table", info2value(loginInfo), "appId=? and userId=?", new String[]{String.valueOf(loginInfo.getAppId()), String.valueOf(loginInfo.getUserId())});
    }
}
