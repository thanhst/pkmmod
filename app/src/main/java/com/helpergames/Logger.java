package com.helpergames;

import android.util.Log;

public class Logger {

    private static final String DEFAULT_TAG = "ThanhLogger";

    /**
     * Ghi log kèm tên class + tên hàm gọi và nội dung.
     * @param message Nội dung cần log (String hoặc object)
     */
    public static void d(Object message) {
        // Lấy stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        String className = "UnknownClass";
        String methodName = "UnknownMethod";

        if (stackTrace.length > 3) {
            // Phần tử thứ 3 hoặc 4 thường là caller (tuỳ JVM)
            StackTraceElement caller = stackTrace[3];
            className = getSimpleClassName(caller.getClassName());
            methodName = caller.getMethodName();
        }

        // Định dạng log
        String formatted = "[" + className + "." + methodName + "] → " + message;

        // Ghi log
        Log.d(DEFAULT_TAG, formatted);
    }

    /**
     * Cắt bỏ package để chỉ lấy tên class.
     */
    private static String getSimpleClassName(String fullName) {
        int lastDot = fullName.lastIndexOf('.');
        return (lastDot != -1) ? fullName.substring(lastDot + 1) : fullName;
    }
}
