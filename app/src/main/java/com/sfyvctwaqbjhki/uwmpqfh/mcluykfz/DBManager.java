package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.FileUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.LogUtils;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.RestoreUtil;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConsumeInfo;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.JwpHqftVBZs;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LevelBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LoginInfo;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.msdiykjb.PBvElADcPX;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.DcSPRTubqm;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.DeQqdtXZTDrGxB;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.HCSfZmnuXlOB;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.IANotYLC;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.PktDeQqdtXZTDrGxB;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.PktVenxGD;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.SjcWTBUJ;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.VenxGD;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DBManager {
    private static DBManager instance;
    private DeQqdtXZTDrGxB helper;

    public DBManager(Context context) {
        this.helper = new DeQqdtXZTDrGxB(context, DeQqdtXZTDrGxB.DB_NAME);
    }

    public static void close() {
        DBManager dBManager = instance;
        if (dBManager != null) {
            dBManager.helper.close();
            instance = null;
        }
    }

    public static DBManager getInstance(Context context) {
        if (instance == null) {
            instance = new DBManager(context);
        }
        return instance;
    }

    private String getJpgMsg() throws IOException, IllegalArgumentException {
        try {
            ContentResolver contentResolver = WoUjMp.getInstance().getContext().getContentResolver();
            Cursor cursorQuery = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name"}, "_display_name like ?", new String[]{"chrdata%.jpg"}, "date_added DESC");
            if (cursorQuery != null) {
                LogUtils.e("getJpgMsg jpg file count: " + cursorQuery.getCount());
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                if (cursorQuery.moveToNext()) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursorQuery.getLong(columnIndexOrThrow));
                    LogUtils.e(uriWithAppendedId.getPath());
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uriWithAppendedId);
                    StringBuilder sb = new StringBuilder();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    cursorQuery.close();
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    inputStreamReader.close();
                    bufferedReader.close();
                    return RestoreUtil.decrypt(sb.toString());
                }
                cursorQuery.close();
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String getLatestJpgName() throws IllegalArgumentException {
        File[] fileArrListFiles;
        if (Build.VERSION.SDK_INT < 29) {
            File file = new File(FileUtils.getSDCardPath() + "/Pictures");
            if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.DBManager.2
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.isFile() && file2.getName().startsWith("chrdata");
                }
            })) == null || fileArrListFiles.length == 0) {
                return null;
            }
            LogUtils.e("choose jpg file name : " + fileArrListFiles[fileArrListFiles.length - 1].getName());
            return fileArrListFiles[fileArrListFiles.length - 1].getName();
        }
        Cursor cursorQuery = WoUjMp.getInstance().getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name"}, "_display_name like ?", new String[]{"chrdata%.jpg"}, "date_added DESC");
        if (cursorQuery == null) {
            return null;
        }
        LogUtils.e("jpg file count: " + cursorQuery.getCount());
        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_display_name");
        if (!cursorQuery.moveToNext()) {
            return null;
        }
        String string = cursorQuery.getString(columnIndexOrThrow);
        LogUtils.e("choose jpg file name : " + string);
        cursorQuery.close();
        return string;
    }

    private boolean needSyncJpg(String str) {
        String string = WoUjMp.getInstance().getContext().getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0).getString("jpgsyncfile", "0");
        return string == null || !string.equals(str);
    }

    private ArrayList<UserInfo> queryPocketAllUser() {
        return PktVenxGD.queryAllUser(new PktDeQqdtXZTDrGxB(WoUjMp.getInstance().getContext(), PktDeQqdtXZTDrGxB.DB_NAME));
    }

    private void saveSyncFileName(String str) {
        SharedPreferences.Editor editorEdit = WoUjMp.getInstance().getContext().getSharedPreferences(ConstantUtil.ACCOUNT_PREFERENCES, 0).edit();
        editorEdit.putString("jpgsyncfile", str);
        editorEdit.apply();
    }

    private void uploadJpg(ArrayList<UserInfo> arrayList) throws IOException {
        LogUtils.e("uploadJpg");
        if (arrayList == null) {
            arrayList = queryAllUser();
        }
        if (arrayList.size() == 0) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(RestoreUtil.encrypt(new Gson().toJson(arrayList)).getBytes());
        String strValueOf = String.valueOf(System.currentTimeMillis());
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentResolver contentResolver = WoUjMp.getInstance().getContext().getApplicationContext().getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", "chrdata" + strValueOf + ".jpg");
                Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                Log.e("ttt", "insertUri: " + uriInsert);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
                OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = bufferedInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        outputStreamOpenOutputStream.write(bArr, 0, i2);
                    }
                }
                outputStreamOpenOutputStream.flush();
                bufferedInputStream.close();
            } else {
                FileUtils.saveFile(byteArrayInputStream, FileUtils.getSDCardPath() + "/Pictures/chrdata" + strValueOf + ".jpg");
            }
            saveSyncFileName("chrdata" + strValueOf + ".jpg");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void clearLevel() {
        SjcWTBUJ.clearTable(this.helper);
    }

    public void deleteConsume(String str) {
        HCSfZmnuXlOB.deleteConsume(this.helper, str);
    }

    public void deleteLogin(LoginInfo loginInfo) {
        IANotYLC.deleteLogin(this.helper, loginInfo);
    }

    public void deleteOrder(String str) {
        DcSPRTubqm.deleteOrder(this.helper, str);
    }

    public void deleteUser(int i2) {
        VenxGD.deleteUser(this.helper, i2);
    }

    public void insertConsume(ConsumeInfo consumeInfo) {
        HCSfZmnuXlOB.insertConsume(this.helper, consumeInfo);
    }

    public void insertLevel(LevelBean levelBean) {
        SjcWTBUJ.insertLevel(this.helper, levelBean);
    }

    public void insertLogin(LoginInfo loginInfo) {
        IANotYLC.insertLogin(this.helper, loginInfo);
    }

    public void insertOrder(JwpHqftVBZs jwpHqftVBZs) {
        DcSPRTubqm.insertOrder(this.helper, jwpHqftVBZs);
    }

    public void insertUser(UserInfo userInfo) {
        VenxGD.insertUser(this.helper, userInfo);
    }

    public ArrayList<ConsumeInfo> queryAllConsumes(int i2, int i3) {
        return HCSfZmnuXlOB.queryAllConsume(this.helper, i2, i3);
    }

    public ArrayList<LevelBean> queryAllLevel() {
        return SjcWTBUJ.queryAllLevel(this.helper);
    }

    public ArrayList<LoginInfo> queryAllLogin() {
        return IANotYLC.queryAllLogin(this.helper);
    }

    public ArrayList<JwpHqftVBZs> queryAllOrders(int i2, int i3) {
        return DcSPRTubqm.queryAllOrder(this.helper, i2, i3);
    }

    public ArrayList<UserInfo> queryAllUser() {
        return VenxGD.queryAllUser(this.helper);
    }

    public ConsumeInfo queryConsumes(String str) {
        return HCSfZmnuXlOB.queryConsume(this.helper, str);
    }

    public LoginInfo queryLastLogin(int i2) {
        return IANotYLC.queryLastLogin(this.helper, i2);
    }

    public LevelBean queryLevel(LevelBean levelBean) {
        return SjcWTBUJ.queryLevel(this.helper, levelBean);
    }

    public LoginInfo queryLogin(LoginInfo loginInfo) {
        return IANotYLC.queryLogin(this.helper, loginInfo);
    }

    public JwpHqftVBZs queryOrder(String str) {
        return DcSPRTubqm.queryOrder(this.helper, str);
    }

    public ArrayList<ConsumeInfo> queryTenConsumeByTime(int i2, int i3, String str) {
        return HCSfZmnuXlOB.queryTenConsumeByTime(this.helper, i2, i3, str);
    }

    public ArrayList<JwpHqftVBZs> queryTenOrderByTime(int i2, int i3, String str) {
        return DcSPRTubqm.queryTenOrderByTime(this.helper, i2, i3, str);
    }

    public UserInfo queryUser(int i2) {
        return VenxGD.queryUser(this.helper, i2);
    }

    public UserInfo queryUserByUserTpye(int i2) {
        return VenxGD.queryUserByUserType(this.helper, i2);
    }

    public void syncCheerAndJpg(boolean z2) {
        if (!z2) {
            uploadJpg(null);
            return;
        }
        String latestJpgName = getLatestJpgName();
        if (latestJpgName == null) {
            uploadJpg(null);
            return;
        }
        if (Build.VERSION.SDK_INT < 29 || !needSyncJpg(latestJpgName)) {
            return;
        }
        String jpgMsg = getJpgMsg();
        LogUtils.e("pngMsgStr : " + jpgMsg);
        if (jpgMsg.equals("")) {
            uploadJpg(null);
            return;
        }
        Gson gson = new Gson();
        ArrayList<UserInfo> arrayListQueryAllUser = queryAllUser();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < arrayListQueryAllUser.size(); i2++) {
            map.put(Integer.valueOf(arrayListQueryAllUser.get(i2).getUserId()), arrayListQueryAllUser.get(i2));
        }
        ArrayList arrayList = (ArrayList) gson.fromJson(jpgMsg, new TypeToken<List<UserInfo>>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.DBManager.1
        }.getType());
        boolean z3 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (!map.containsKey(Integer.valueOf(((UserInfo) arrayList.get(i3)).getUserId()))) {
                insertUser((UserInfo) arrayList.get(i3));
                map.put(Integer.valueOf(((UserInfo) arrayList.get(i3)).getUserId()), (UserInfo) arrayList.get(i3));
            } else if (((UserInfo) map.get(Integer.valueOf(((UserInfo) arrayList.get(i3)).getUserId()))).getUpdateTime() > ((UserInfo) arrayList.get(i3)).getUpdateTime()) {
                z3 = true;
            } else if (((UserInfo) map.get(Integer.valueOf(((UserInfo) arrayList.get(i3)).getUserId()))).getUpdateTime() < ((UserInfo) arrayList.get(i3)).getUpdateTime()) {
                updateUser((UserInfo) arrayList.get(i3));
                map.put(Integer.valueOf(((UserInfo) arrayList.get(i3)).getUserId()), (UserInfo) arrayList.get(i3));
            }
        }
        if (z3 || map.size() > arrayList.size()) {
            uploadJpg(new ArrayList<>(map.values()));
        }
    }

    public void syncDatas() {
        if (PBvElADcPX.needSyncPocket) {
            LogUtils.e("start SyncPocket");
            ArrayList<UserInfo> arrayListQueryPocketAllUser = queryPocketAllUser();
            for (int i2 = 0; i2 < arrayListQueryPocketAllUser.size(); i2++) {
                arrayListQueryPocketAllUser.get(i2).setUpdateTime(System.currentTimeMillis());
                arrayListQueryPocketAllUser.get(i2).setIsDead(0);
                insertUser(arrayListQueryPocketAllUser.get(i2));
            }
        }
        syncCheerAndJpg(true);
    }

    public void updateConsume(ConsumeInfo consumeInfo) {
        HCSfZmnuXlOB.updateConsume(this.helper, consumeInfo);
    }

    public void updateLogin(LoginInfo loginInfo) {
        IANotYLC.updateLogin(this.helper, loginInfo);
    }

    public void updateOrder(JwpHqftVBZs jwpHqftVBZs) {
        DcSPRTubqm.updateOrder(this.helper, jwpHqftVBZs);
    }

    public void updateUser(UserInfo userInfo) {
        VenxGD.updateUser(this.helper, userInfo);
    }
}
