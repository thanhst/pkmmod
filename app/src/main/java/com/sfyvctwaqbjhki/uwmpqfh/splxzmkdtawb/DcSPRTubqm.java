package com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb;

import android.content.ContentValues;
import android.database.Cursor;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.JwpHqftVBZs;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DcSPRTubqm {
    private static JwpHqftVBZs cursor2Object(Cursor cursor, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        JwpHqftVBZs jwpHqftVBZs = new JwpHqftVBZs();
        jwpHqftVBZs.setAppId(cursor.getInt(i3));
        jwpHqftVBZs.setUserId(cursor.getInt(i2));
        jwpHqftVBZs.setTransactionId(cursor.getString(i4));
        jwpHqftVBZs.setAmount(cursor.getString(i5));
        jwpHqftVBZs.setCurrency(cursor.getString(i6));
        jwpHqftVBZs.setChannel(cursor.getInt(i7));
        jwpHqftVBZs.setStatus(cursor.getInt(i8));
        jwpHqftVBZs.setChargingType(cursor.getInt(i9));
        jwpHqftVBZs.setClientTime(cursor.getString(i10));
        return jwpHqftVBZs;
    }

    public static void deleteOrder(DeQqdtXZTDrGxB deQqdtXZTDrGxB, String str) {
        deQqdtXZTDrGxB.delete("order_table", "transactionId=?", new String[]{String.valueOf(str)});
    }

    public static void insertOrder(DeQqdtXZTDrGxB deQqdtXZTDrGxB, JwpHqftVBZs jwpHqftVBZs) {
        deQqdtXZTDrGxB.insert("order_table", object2Values(jwpHqftVBZs));
    }

    private static ContentValues object2Values(JwpHqftVBZs jwpHqftVBZs) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", Integer.valueOf(jwpHqftVBZs.getUserId()));
        contentValues.put("appId", Integer.valueOf(jwpHqftVBZs.getAppId()));
        contentValues.put("transactionId", jwpHqftVBZs.getTransactionId());
        contentValues.put(DataUtil.ORDER_LIST_COLUMN.AMOUNT, jwpHqftVBZs.getAmount());
        contentValues.put(DataUtil.ORDER_LIST_COLUMN.CURRENCY, jwpHqftVBZs.getCurrency());
        contentValues.put("channel", Integer.valueOf(jwpHqftVBZs.getChannel()));
        contentValues.put("status", Integer.valueOf(jwpHqftVBZs.getStatus()));
        contentValues.put("chargingType", Integer.valueOf(jwpHqftVBZs.getChargingType()));
        contentValues.put("clientDate", jwpHqftVBZs.getClientTime());
        return contentValues;
    }

    public static ArrayList<JwpHqftVBZs> queryAllOrder(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2, int i3) {
        Cursor cursorQuery = deQqdtXZTDrGxB.query("order_table", null, "appId=? and userId=?", new String[]{String.valueOf(i2), String.valueOf(i3)});
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex("appId");
        int columnIndex3 = cursorQuery.getColumnIndex("transactionId");
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.ORDER_LIST_COLUMN.AMOUNT);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.ORDER_LIST_COLUMN.CURRENCY);
        int columnIndex6 = cursorQuery.getColumnIndex("channel");
        int columnIndex7 = cursorQuery.getColumnIndex("status");
        int columnIndex8 = cursorQuery.getColumnIndex("chargingType");
        int columnIndex9 = cursorQuery.getColumnIndex("clientDate");
        ArrayList<JwpHqftVBZs> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            int i4 = columnIndex;
            int i5 = columnIndex;
            ArrayList<JwpHqftVBZs> arrayList2 = arrayList;
            arrayList2.add(cursor2Object(cursorQuery, i4, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7, columnIndex8, columnIndex9));
            arrayList = arrayList2;
            columnIndex = i5;
        }
        ArrayList<JwpHqftVBZs> arrayList3 = arrayList;
        cursorQuery.close();
        return arrayList3;
    }

    public static JwpHqftVBZs queryOrder(DeQqdtXZTDrGxB deQqdtXZTDrGxB, String str) {
        JwpHqftVBZs jwpHqftVBZsCursor2Object = null;
        Cursor cursorQuery = deQqdtXZTDrGxB.query("order_table", null, "transactionId=?", new String[]{str});
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex("appId");
        int columnIndex3 = cursorQuery.getColumnIndex("transactionId");
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.ORDER_LIST_COLUMN.AMOUNT);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.ORDER_LIST_COLUMN.CURRENCY);
        int columnIndex6 = cursorQuery.getColumnIndex("channel");
        int columnIndex7 = cursorQuery.getColumnIndex("status");
        int columnIndex8 = cursorQuery.getColumnIndex("chargingType");
        int columnIndex9 = cursorQuery.getColumnIndex("clientDate");
        while (cursorQuery.moveToNext()) {
            jwpHqftVBZsCursor2Object = cursor2Object(cursorQuery, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7, columnIndex8, columnIndex9);
        }
        cursorQuery.close();
        return jwpHqftVBZsCursor2Object;
    }

    public static ArrayList<JwpHqftVBZs> queryTenOrderByTime(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2, int i3, String str) {
        Cursor cursorQuery = (str == null || str.length() == 0) ? deQqdtXZTDrGxB.query("order_table", null, "appId=? and userId=?", new String[]{String.valueOf(i2), String.valueOf(i3)}, "clientDate desc", ConstantUtil.SHOW_METHOD_CONFIRM_AND_SERIAL_PIN) : deQqdtXZTDrGxB.query("order_table", null, "appId=? and userId=? and clientDate <?", new String[]{String.valueOf(i2), String.valueOf(i3), str}, "clientDate desc", ConstantUtil.SHOW_METHOD_CONFIRM_AND_SERIAL_PIN);
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex("appId");
        int columnIndex3 = cursorQuery.getColumnIndex("transactionId");
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.ORDER_LIST_COLUMN.AMOUNT);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.ORDER_LIST_COLUMN.CURRENCY);
        int columnIndex6 = cursorQuery.getColumnIndex("channel");
        int columnIndex7 = cursorQuery.getColumnIndex("status");
        int columnIndex8 = cursorQuery.getColumnIndex("chargingType");
        int columnIndex9 = cursorQuery.getColumnIndex("clientDate");
        ArrayList<JwpHqftVBZs> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            int i4 = columnIndex;
            int i5 = columnIndex;
            ArrayList<JwpHqftVBZs> arrayList2 = arrayList;
            arrayList2.add(cursor2Object(cursorQuery, i4, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7, columnIndex8, columnIndex9));
            arrayList = arrayList2;
            columnIndex = i5;
        }
        ArrayList<JwpHqftVBZs> arrayList3 = arrayList;
        cursorQuery.close();
        return arrayList3;
    }

    public static void updateOrder(DeQqdtXZTDrGxB deQqdtXZTDrGxB, JwpHqftVBZs jwpHqftVBZs) {
        deQqdtXZTDrGxB.update("order_table", object2Values(jwpHqftVBZs), "transactionId=?", new String[]{String.valueOf(jwpHqftVBZs.getTransactionId())});
    }
}
