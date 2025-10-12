package com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LevelBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SjcWTBUJ {
    public static void clearTable(DeQqdtXZTDrGxB deQqdtXZTDrGxB) throws SQLException {
        deQqdtXZTDrGxB.getWritableDatabase().execSQL("delete from level_table");
        deQqdtXZTDrGxB.getWritableDatabase().execSQL("update sqlite_sequence SET seq = 0 where name ='level_table'");
    }

    private static LevelBean cursor2info(Cursor cursor, int i2, int i3, int i4, int i5) {
        LevelBean levelBean = new LevelBean();
        levelBean.setAppId(cursor.getInt(i2));
        levelBean.setLevel(cursor.getInt(i4));
        levelBean.setPackageName(cursor.getString(i3));
        levelBean.setClientDate(cursor.getString(i5));
        return levelBean;
    }

    public static void deleteLevel(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LevelBean levelBean) {
        deQqdtXZTDrGxB.delete("level_table", "packageName=? and level=?", new String[]{String.valueOf(levelBean.getPackageName()), String.valueOf(levelBean.getLevel())});
    }

    private static ContentValues info2value(LevelBean levelBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(levelBean.getAppId()));
        contentValues.put("level", Integer.valueOf(levelBean.getLevel()));
        contentValues.put(DataUtil.LEVEL_COLUMN.PACKAGENAME, levelBean.getPackageName());
        contentValues.put("clientDate", levelBean.getClientDate());
        return contentValues;
    }

    public static void insertLevel(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LevelBean levelBean) {
        deQqdtXZTDrGxB.insert("level_table", info2value(levelBean));
    }

    public static ArrayList<LevelBean> queryAllLevel(DeQqdtXZTDrGxB deQqdtXZTDrGxB) {
        Cursor cursorQuery = deQqdtXZTDrGxB.query("level_table", null, null, null, "clientDate");
        int columnIndex = cursorQuery.getColumnIndex("appId");
        int columnIndex2 = cursorQuery.getColumnIndex("level");
        int columnIndex3 = cursorQuery.getColumnIndex(DataUtil.LEVEL_COLUMN.PACKAGENAME);
        int columnIndex4 = cursorQuery.getColumnIndex("clientDate");
        ArrayList<LevelBean> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            arrayList.add(cursor2info(cursorQuery, columnIndex, columnIndex3, columnIndex2, columnIndex4));
        }
        cursorQuery.close();
        return arrayList;
    }

    public static LevelBean queryLevel(DeQqdtXZTDrGxB deQqdtXZTDrGxB, LevelBean levelBean) {
        LevelBean levelBeanCursor2info = null;
        Cursor cursorQuery = deQqdtXZTDrGxB.query("level_table", null, "packageName=? and level=?", new String[]{String.valueOf(levelBean.getPackageName()), String.valueOf(levelBean.getLevel())});
        int columnIndex = cursorQuery.getColumnIndex("appId");
        int columnIndex2 = cursorQuery.getColumnIndex(DataUtil.LEVEL_COLUMN.PACKAGENAME);
        int columnIndex3 = cursorQuery.getColumnIndex("level");
        int columnIndex4 = cursorQuery.getColumnIndex("clientDate");
        while (cursorQuery.moveToNext()) {
            levelBeanCursor2info = cursor2info(cursorQuery, columnIndex, columnIndex2, columnIndex3, columnIndex4);
        }
        cursorQuery.close();
        return levelBeanCursor2info;
    }
}
