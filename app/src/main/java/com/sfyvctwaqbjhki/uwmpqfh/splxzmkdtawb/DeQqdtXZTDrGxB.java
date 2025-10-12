package com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.FileUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;

/* loaded from: classes.dex */
public class DeQqdtXZTDrGxB extends SQLiteOpenHelper {
    public static final String CONSUME_TABLE = "consume_table";
    public static final String DB_NAME = "sdk_v1";
    public static final int DB_VERSION = 1;
    public static final String LEVEL_TABLE = "level_table";
    public static final String LOGIN_TABLE = "login_table";
    public static final String ORDER_TABLE = "order_table";
    public static final String USER_TABLE_V2 = "user_table_v2";
    private final String CREATE_CONSUMELIST_TABLE;
    private final String CREATE_LEVEL_TABLE;
    private final String CREATE_LOGIN_TABLE;
    private final String CREATE_ORDERLIST_TABLE;
    private final String CREATE_USER_TABLE_V2;
    private SQLiteDatabase db;

    public DeQqdtXZTDrGxB(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) throws SQLException {
        StringBuilder sb;
        String str2;
        if (Build.VERSION.SDK_INT >= 29) {
            sb = new StringBuilder();
            sb.append(context.getFilesDir());
            str2 = "/";
        } else {
            sb = new StringBuilder();
            sb.append(FileUtils.getSDCardPath());
            str2 = "/chrlife/";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(".db");
        super(context, sb.toString(), cursorFactory, i2);
        this.CREATE_USER_TABLE_V2 = "CREATE TABLE  IF NOT EXISTS user_table_v2 (_id INTEGER PRIMARY KEY,userId INTEGER, userName TEXT, password TEXT, basepwd TEXT, accountType INTEGER, userType INTEGER, thirdPartyId TEXT, email TEXT, phone TEXT, nickName TEXT, clientDate TEXT, isDead INTEGER, updateTime BIGINT)";
        this.CREATE_LOGIN_TABLE = "CREATE TABLE  IF NOT EXISTS login_table(appId INTEGER,userId INTEGER,clientDate TEXT)";
        this.CREATE_ORDERLIST_TABLE = "CREATE TABLE  if not exists order_table(_id INTEGER PRIMARY KEY  AUTOINCREMENT, userId INTERGER, appId INTERGER, transactionId TEXT, amount TEXT, currency TEXT, channel INTERGER, status INTERGER,chargingType INTERGER,clientDate TEXT)";
        this.CREATE_CONSUMELIST_TABLE = "CREATE TABLE if not exists consume_table(_id INTEGER PRIMARY KEY  AUTOINCREMENT, appId INTERGER, userId INTERGER, transactionId TEXT, platformCoin TEXT, productDesc TEXT, status INTERGER,clientTime TEXT)";
        this.CREATE_LEVEL_TABLE = "CREATE TABLE  IF NOT EXISTS level_table(packageName TEXT,appId INTEGER,level INTEGER,clientDate TEXT)";
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.db = readableDatabase;
        onCreate(readableDatabase);
    }

    public void delete(String str, String str2, String[] strArr) {
        LogUtils.e("sql delete");
        this.db.delete(str, str2, strArr);
    }

    public void insert(String str, ContentValues contentValues) {
        LogUtils.e("sql insert");
        this.db.insert(str, null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        LogUtils.e("sql create table");
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS user_table_v2 (_id INTEGER PRIMARY KEY,userId INTEGER, userName TEXT, password TEXT, basepwd TEXT, accountType INTEGER, userType INTEGER, thirdPartyId TEXT, email TEXT, phone TEXT, nickName TEXT, clientDate TEXT, isDead INTEGER, updateTime BIGINT)");
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS login_table(appId INTEGER,userId INTEGER,clientDate TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE  if not exists order_table(_id INTEGER PRIMARY KEY  AUTOINCREMENT, userId INTERGER, appId INTERGER, transactionId TEXT, amount TEXT, currency TEXT, channel INTERGER, status INTERGER,chargingType INTERGER,clientDate TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE if not exists consume_table(_id INTEGER PRIMARY KEY  AUTOINCREMENT, appId INTERGER, userId INTERGER, transactionId TEXT, platformCoin TEXT, productDesc TEXT, status INTERGER,clientTime TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS level_table(packageName TEXT,appId INTEGER,level INTEGER,clientDate TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        LogUtils.e("sql update a Database");
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2) {
        LogUtils.e("sql query");
        return this.db.query(str, strArr, str2, strArr2, null, null, null, null);
    }

    public void update(String str, ContentValues contentValues, String str2, String[] strArr) {
        LogUtils.e("sql update");
        this.db.update(str, contentValues, str2, strArr);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        LogUtils.e("sql query");
        return this.db.query(str, strArr, str2, strArr2, null, null, str3, null);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        LogUtils.e("sql query");
        return this.db.query(str, strArr, str2, strArr2, null, null, str3, str4);
    }

    public DeQqdtXZTDrGxB(Context context, String str) {
        this(context, str, 1);
    }

    public DeQqdtXZTDrGxB(Context context, String str, int i2) {
        this(context, str, null, i2);
    }
}
