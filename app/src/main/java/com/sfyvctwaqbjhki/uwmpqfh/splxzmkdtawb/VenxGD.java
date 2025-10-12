package com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb;

import android.content.ContentValues;
import android.database.Cursor;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.rsa.RSACoder;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VenxGD {
    private static UserInfo cursor2info(Cursor cursor, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(cursor.getInt(i2));
        userInfo.setUserName(cursor.getString(i3));
        userInfo.setPassword(RSACoder.decode(cursor.getString(i4)));
        userInfo.setBasepwd(RSACoder.decode(cursor.getString(i5)));
        userInfo.setAccountType(cursor.getInt(i6));
        userInfo.setUserType(cursor.getInt(i7));
        userInfo.setThirdPartyId(cursor.getString(i8));
        userInfo.setEmail(cursor.getString(i9));
        userInfo.setNickName(cursor.getString(i11));
        userInfo.setClientDate(cursor.getString(i12));
        userInfo.setIsDead(cursor.getInt(i13));
        userInfo.setUpdateTime(cursor.getInt(i14));
        return userInfo;
    }

    public static void deleteUser(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2) {
        deQqdtXZTDrGxB.delete(DeQqdtXZTDrGxB.USER_TABLE_V2, "userId=?", new String[]{String.valueOf(i2)});
    }

    private static ContentValues info2values(UserInfo userInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", Integer.valueOf(userInfo.getUserId()));
        contentValues.put(DataUtil.USER_COLUMN.USERNAME, userInfo.getUserName());
        contentValues.put(DataUtil.USER_COLUMN.PASSWORD, RSACoder.encode(userInfo.getPassword()));
        contentValues.put(DataUtil.USER_COLUMN.ACCOUNT_TYPE, Integer.valueOf(userInfo.getAccountType()));
        contentValues.put(DataUtil.USER_COLUMN.USER_TYPE, Integer.valueOf(userInfo.getUserType()));
        contentValues.put(DataUtil.USER_COLUMN.THIRDPARTYID, userInfo.getThirdPartyId());
        contentValues.put("email", userInfo.getEmail());
        contentValues.put(DataUtil.USER_COLUMN.NICKNAME, userInfo.getNickName());
        contentValues.put("clientDate", userInfo.getClientDate());
        contentValues.put(DataUtil.USER_COLUMN.BASEPWD, RSACoder.encode(userInfo.getBasepwd()));
        contentValues.put(DataUtil.USER_COLUMN.IS_DEAD, Integer.valueOf(userInfo.getIsDead()));
        contentValues.put(DataUtil.USER_COLUMN.UPDATE_TIME, Long.valueOf(userInfo.getUpdateTime()));
        return contentValues;
    }

    public static void insertUser(DeQqdtXZTDrGxB deQqdtXZTDrGxB, UserInfo userInfo) {
        deQqdtXZTDrGxB.insert(DeQqdtXZTDrGxB.USER_TABLE_V2, info2values(userInfo));
    }

    public static ArrayList<UserInfo> queryAllUser(DeQqdtXZTDrGxB deQqdtXZTDrGxB) {
        Cursor cursorQuery = deQqdtXZTDrGxB.query(DeQqdtXZTDrGxB.USER_TABLE_V2, null, null, null, "clientDate desc");
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.USERNAME);
        int columnIndex3 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.PASSWORD);
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.BASEPWD);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.ACCOUNT_TYPE);
        int columnIndex6 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.USER_TYPE);
        int columnIndex7 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.THIRDPARTYID);
        int columnIndex8 = cursorQuery.getColumnIndex("email");
        int columnIndex9 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.PHONE);
        int columnIndex10 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.NICKNAME);
        int columnIndex11 = cursorQuery.getColumnIndex("clientDate");
        int columnIndex12 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.IS_DEAD);
        int columnIndex13 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.UPDATE_TIME);
        ArrayList<UserInfo> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            int i2 = columnIndex;
            int i3 = columnIndex;
            ArrayList<UserInfo> arrayList2 = arrayList;
            arrayList2.add(cursor2info(cursorQuery, i2, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7, columnIndex8, columnIndex9, columnIndex10, columnIndex11, columnIndex12, columnIndex13));
            arrayList = arrayList2;
            columnIndex = i3;
        }
        ArrayList<UserInfo> arrayList3 = arrayList;
        cursorQuery.close();
        return arrayList3;
    }

    public static UserInfo queryUser(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2) {
        UserInfo userInfoCursor2info = null;
        Cursor cursorQuery = deQqdtXZTDrGxB.query(DeQqdtXZTDrGxB.USER_TABLE_V2, null, "userId=?", new String[]{String.valueOf(i2)});
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.USERNAME);
        int columnIndex3 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.PASSWORD);
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.BASEPWD);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.ACCOUNT_TYPE);
        int columnIndex6 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.USER_TYPE);
        int columnIndex7 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.THIRDPARTYID);
        int columnIndex8 = cursorQuery.getColumnIndex("email");
        int columnIndex9 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.PHONE);
        int columnIndex10 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.NICKNAME);
        int columnIndex11 = cursorQuery.getColumnIndex("clientDate");
        int columnIndex12 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.IS_DEAD);
        int columnIndex13 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.UPDATE_TIME);
        while (cursorQuery.moveToNext()) {
            userInfoCursor2info = cursor2info(cursorQuery, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7, columnIndex8, columnIndex9, columnIndex10, columnIndex11, columnIndex12, columnIndex13);
        }
        cursorQuery.close();
        return userInfoCursor2info;
    }

    public static UserInfo queryUserByUserType(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2) {
        UserInfo userInfoCursor2info = null;
        Cursor cursorQuery = deQqdtXZTDrGxB.query(DeQqdtXZTDrGxB.USER_TABLE_V2, null, "userType=?", new String[]{String.valueOf(i2)});
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.USERNAME);
        int columnIndex3 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.PASSWORD);
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.BASEPWD);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.ACCOUNT_TYPE);
        int columnIndex6 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.USER_TYPE);
        int columnIndex7 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.THIRDPARTYID);
        int columnIndex8 = cursorQuery.getColumnIndex("email");
        int columnIndex9 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.PHONE);
        int columnIndex10 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.NICKNAME);
        int columnIndex11 = cursorQuery.getColumnIndex("clientDate");
        int columnIndex12 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.IS_DEAD);
        int columnIndex13 = cursorQuery.getColumnIndex(DataUtil.USER_COLUMN.UPDATE_TIME);
        while (cursorQuery.moveToNext()) {
            userInfoCursor2info = cursor2info(cursorQuery, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7, columnIndex8, columnIndex9, columnIndex10, columnIndex11, columnIndex12, columnIndex13);
        }
        cursorQuery.close();
        return userInfoCursor2info;
    }

    public static void updateUser(DeQqdtXZTDrGxB deQqdtXZTDrGxB, UserInfo userInfo) {
        deQqdtXZTDrGxB.update(DeQqdtXZTDrGxB.USER_TABLE_V2, info2values(userInfo), "userId=?", new String[]{String.valueOf(userInfo.getUserId())});
    }
}
