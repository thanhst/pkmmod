package com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb;

import android.content.ContentValues;
import android.database.Cursor;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConsumeInfo;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HCSfZmnuXlOB {
    private static ConsumeInfo cursor2Object(Cursor cursor, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ConsumeInfo consumeInfo = new ConsumeInfo();
        consumeInfo.setAppId(cursor.getInt(i3));
        consumeInfo.setUserId(cursor.getInt(i2));
        consumeInfo.setTransactionId(cursor.getString(i4));
        consumeInfo.setPlatformCoin(cursor.getString(i5));
        consumeInfo.setProductDesc(cursor.getString(i6));
        consumeInfo.setStatus(cursor.getInt(i7));
        consumeInfo.setClientTime(cursor.getString(i8));
        return consumeInfo;
    }

    public static void deleteConsume(DeQqdtXZTDrGxB deQqdtXZTDrGxB, String str) {
        deQqdtXZTDrGxB.delete("consume_table", "transactionId=?", new String[]{String.valueOf(str)});
    }

    public static void insertConsume(DeQqdtXZTDrGxB deQqdtXZTDrGxB, ConsumeInfo consumeInfo) {
        deQqdtXZTDrGxB.insert("consume_table", object2Values(consumeInfo));
    }

    private static ContentValues object2Values(ConsumeInfo consumeInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", Integer.valueOf(consumeInfo.getUserId()));
        contentValues.put("appId", Integer.valueOf(consumeInfo.getAppId()));
        contentValues.put("transactionId", consumeInfo.getTransactionId());
        contentValues.put(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PLATFORMCOIN, consumeInfo.getPlatformCoin());
        contentValues.put(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PRODUCTDESC, consumeInfo.getProductDesc());
        contentValues.put("status", Integer.valueOf(consumeInfo.getStatus()));
        contentValues.put("clientTime", consumeInfo.getClientTime());
        return contentValues;
    }

    public static ArrayList<ConsumeInfo> queryAllConsume(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2, int i3) {
        Cursor cursorQuery = deQqdtXZTDrGxB.query("consume_table", null, "appId=? and userId=?", new String[]{String.valueOf(i2), String.valueOf(i3)});
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex("appId");
        int columnIndex3 = cursorQuery.getColumnIndex("transactionId");
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PLATFORMCOIN);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PRODUCTDESC);
        int columnIndex6 = cursorQuery.getColumnIndex("status");
        int columnIndex7 = cursorQuery.getColumnIndex("clientTime");
        ArrayList<ConsumeInfo> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            int i4 = columnIndex;
            int i5 = columnIndex;
            ArrayList<ConsumeInfo> arrayList2 = arrayList;
            arrayList2.add(cursor2Object(cursorQuery, i4, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7));
            arrayList = arrayList2;
            columnIndex = i5;
        }
        ArrayList<ConsumeInfo> arrayList3 = arrayList;
        cursorQuery.close();
        return arrayList3;
    }

    public static ConsumeInfo queryConsume(DeQqdtXZTDrGxB deQqdtXZTDrGxB, String str) {
        ConsumeInfo consumeInfoCursor2Object = null;
        Cursor cursorQuery = deQqdtXZTDrGxB.query("consume_table", null, "transactionId=?", new String[]{str});
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex("appId");
        int columnIndex3 = cursorQuery.getColumnIndex("transactionId");
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PLATFORMCOIN);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PRODUCTDESC);
        int columnIndex6 = cursorQuery.getColumnIndex("status");
        int columnIndex7 = cursorQuery.getColumnIndex("clientTime");
        while (cursorQuery.moveToNext()) {
            consumeInfoCursor2Object = cursor2Object(cursorQuery, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7);
        }
        cursorQuery.close();
        return consumeInfoCursor2Object;
    }

    public static ArrayList<ConsumeInfo> queryTenConsumeByTime(DeQqdtXZTDrGxB deQqdtXZTDrGxB, int i2, int i3, String str) {
        Cursor cursorQuery = (str == null || str.length() == 0) ? deQqdtXZTDrGxB.query("consume_table", null, "appId=? and userId=?", new String[]{String.valueOf(i2), String.valueOf(i3)}, "clientTime desc", ConstantUtil.SHOW_METHOD_CONFIRM_AND_SERIAL_PIN) : deQqdtXZTDrGxB.query("consume_table", null, "appId=? and userId=? and clientTime <?", new String[]{String.valueOf(i2), String.valueOf(i3), str}, "clientTime desc", ConstantUtil.SHOW_METHOD_CONFIRM_AND_SERIAL_PIN);
        int columnIndex = cursorQuery.getColumnIndex("userId");
        int columnIndex2 = cursorQuery.getColumnIndex("appId");
        int columnIndex3 = cursorQuery.getColumnIndex("transactionId");
        int columnIndex4 = cursorQuery.getColumnIndex(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PLATFORMCOIN);
        int columnIndex5 = cursorQuery.getColumnIndex(DataUtil.CONSUME_LIST_COLUMN.CONSUME_LIST_PRODUCTDESC);
        int columnIndex6 = cursorQuery.getColumnIndex("status");
        int columnIndex7 = cursorQuery.getColumnIndex("clientTime");
        ArrayList<ConsumeInfo> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            int i4 = columnIndex;
            int i5 = columnIndex;
            ArrayList<ConsumeInfo> arrayList2 = arrayList;
            arrayList2.add(cursor2Object(cursorQuery, i4, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, columnIndex7));
            arrayList = arrayList2;
            columnIndex = i5;
        }
        ArrayList<ConsumeInfo> arrayList3 = arrayList;
        cursorQuery.close();
        return arrayList3;
    }

    public static void updateConsume(DeQqdtXZTDrGxB deQqdtXZTDrGxB, ConsumeInfo consumeInfo) {
        deQqdtXZTDrGxB.update("consume_table", object2Values(consumeInfo), "transactionId=?", new String[]{String.valueOf(consumeInfo.getTransactionId())});
    }
}
