package com.sfyvctwaqbjhki.uwmpqfh.msdiykjb;

import android.app.Activity;
import com.sfyvctwaqbjhki.uwmpqfh.WoUjMp;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.ConstantUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.FileUtils;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.ConsumeInfo;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.JwpHqftVBZs;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LevelBean;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.LoginInfo;
import com.sfyvctwaqbjhki.uwmpqfh.fntrdjblkcx.UserInfo;
import com.sfyvctwaqbjhki.uwmpqfh.mcluykfz.DBManager;
import com.sfyvctwaqbjhki.uwmpqfh.splxzmkdtawb.DeQqdtXZTDrGxB;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PBvElADcPX {
    private static Activity context = WoUjMp.getInstance().getContext();
    public static boolean needSyncPocket = false;

    public static void clearLevel() {
        DBManager.getInstance(context).clearLevel();
    }

    public static void close() {
        DBManager.close();
    }

    public static void deleteUser(UserInfo userInfo) {
        userInfo.setUpdateTime(System.currentTimeMillis());
        userInfo.setIsDead(1);
        DBManager.getInstance(context).updateUser(userInfo);
        DBManager.getInstance(context).syncCheerAndJpg(false);
    }

    public static List<UserInfo> getAllUser() {
        return DBManager.getInstance(context).queryAllUser();
    }

    public static UserInfo getLoginInfo(int i2) {
        needSyncPocket = DataUtil.needSyncPocketData(context);
        LoginInfo loginInfoQueryLastLogin = DBManager.getInstance(context).queryLastLogin(i2);
        syncDatas();
        if (loginInfoQueryLastLogin != null) {
            return DBManager.getInstance(context).queryUser(loginInfoQueryLastLogin.getUserId());
        }
        return null;
    }

    public static UserInfo getUserVistor() {
        return DBManager.getInstance(context).queryUserByUserTpye(ConstantUtil.USER_TYPE_VISTOR);
    }

    public static void insertLevel(LevelBean levelBean) {
        if (DBManager.getInstance(context).queryLevel(levelBean) == null) {
            DBManager.getInstance(context).insertLevel(levelBean);
        }
    }

    public static void insertOrUpdateConsume(ConsumeInfo consumeInfo) {
        if (DBManager.getInstance(context).queryConsumes(consumeInfo.getTransactionId()) == null) {
            DBManager.getInstance(context).insertConsume(consumeInfo);
        } else {
            DBManager.getInstance(context).updateConsume(consumeInfo);
        }
    }

    public static void insertOrUpdateLogin(LoginInfo loginInfo) {
        if (DBManager.getInstance(context).queryLogin(loginInfo) == null) {
            DBManager.getInstance(context).insertLogin(loginInfo);
        } else {
            DBManager.getInstance(context).updateLogin(loginInfo);
        }
    }

    public static void insertOrUpdateOrder(JwpHqftVBZs jwpHqftVBZs) {
        if (DBManager.getInstance(context).queryOrder(jwpHqftVBZs.getTransactionId()) == null) {
            DBManager.getInstance(context).insertOrder(jwpHqftVBZs);
        } else {
            DBManager.getInstance(context).updateOrder(jwpHqftVBZs);
        }
    }

    public static void insertOrUpdateUser(UserInfo userInfo, boolean z2) {
        UserInfo userInfoQueryUser = DBManager.getInstance(context).queryUser(userInfo.getUserId());
        if (userInfoQueryUser == null) {
            if (userInfo.getUpdateTime() == 0) {
                userInfo.setUpdateTime(System.currentTimeMillis());
                userInfo.setIsDead(0);
            }
            DBManager.getInstance(context).insertUser(userInfo);
            DBManager.getInstance(context).syncCheerAndJpg(false);
            return;
        }
        boolean z3 = true;
        if (userInfoQueryUser.getIsDead() == 1 || userInfoQueryUser.getUpdateTime() == 0 || z2) {
            userInfo.setIsDead(0);
            userInfo.setUpdateTime(System.currentTimeMillis());
        } else {
            z3 = false;
        }
        if (userInfo.getUpdateTime() == 0) {
            userInfo.setUpdateTime(userInfoQueryUser.getUpdateTime());
        }
        DBManager.getInstance(context).updateUser(userInfo);
        if (z3) {
            DBManager.getInstance(context).syncCheerAndJpg(false);
        }
    }

    public static boolean isFirstLoadPackage(int i2) {
        return DBManager.getInstance(context).queryLastLogin(i2) == null;
    }

    public static ArrayList<LevelBean> queryAllLevel() {
        return DBManager.getInstance(context).queryAllLevel();
    }

    public static LevelBean queryLevel(LevelBean levelBean) {
        return DBManager.getInstance(context).queryLevel(levelBean);
    }

    public static ArrayList<ConsumeInfo> queryTenConsumeByTime(int i2, int i3, String str) {
        return DBManager.getInstance(context).queryTenConsumeByTime(i2, i3, str);
    }

    public static ArrayList<JwpHqftVBZs> queryTenOrderByTime(int i2, int i3, String str) {
        return DBManager.getInstance(context).queryTenOrderByTime(i2, i3, str);
    }

    public static void syncDatas() {
        DBManager.getInstance(context).syncDatas();
    }

    public static void transferOld() throws IOException {
        try {
            String str = FileUtils.getSDCardPath() + "/pocket/" + DeQqdtXZTDrGxB.DB_NAME + ".db";
            String str2 = FileUtils.getSDCardPath() + "/pocketgames/sdk_v2.db";
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists() && file2.exists()) {
                File file3 = new File(file.getParent());
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file.createNewFile();
                FileUtils.copyFile(str2, str);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
