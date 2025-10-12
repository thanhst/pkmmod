package com.ykiocnwpdseglq.cubgy.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class FileUtils {
    public static void copyFile(String str, String str2) throws IOException {
        try {
            if (!new File(str).exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1444];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception unused) {
            System.out.println("复制单个文件操作出错");
        }
    }

    public static String getSDCardPath() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return "";
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        StatFs statFs = new StatFs(absolutePath);
        return (statFs.getBlockSizeLong() == 0 || statFs.getAvailableBlocksLong() == 0) ? System.getenv("EXTERNAL_STORAGE") : absolutePath;
    }

    public static String getStoragePath(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            return context.getExternalCacheDir().getPath();
        }
        if (context.getCacheDir() != null) {
            return context.getCacheDir().getPath();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.getenv("EXTERNAL_STORAGE"));
        String str = File.separator;
        stringBuffer.append(str);
        stringBuffer.append("Android");
        stringBuffer.append(str);
        stringBuffer.append(ShareConstants.WEB_DIALOG_PARAM_DATA);
        stringBuffer.append(str);
        stringBuffer.append(context.getPackageName());
        stringBuffer.append(str);
        stringBuffer.append("cache");
        return stringBuffer.toString();
    }

    public static boolean isSDCardExist() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String readGAID(Context context) throws IOException {
        try {
            String str = getSDCardPath() + File.separator + "temp.txt";
            LogUtil.e("read device msg file:" + str);
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            String line = new BufferedReader(new InputStreamReader(new FileInputStream(file))).readLine();
            LogUtil.e("gaid: " + line);
            return line;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void unZip(Context context, String str, String str2) throws IOException {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            ZipInputStream zipInputStream = new ZipInputStream(context.getAssets().open(str));
            byte[] bArr = new byte[1048576];
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + nextEntry.getName()).mkdir();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("解压==");
                    sb.append(str2);
                    String str3 = File.separator;
                    sb.append(str3);
                    sb.append(nextEntry.getName());
                    LogUtil.e(sb.toString());
                    File file2 = new File(str2 + str3 + nextEntry.getName());
                    file2.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    while (true) {
                        int i2 = zipInputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                    }
                    fileOutputStream.close();
                }
            }
            zipInputStream.close();
        } catch (Exception unused) {
        }
    }
}
