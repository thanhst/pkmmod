package com.sfyvctwaqbjhki.uwmpqfh.mcluykfz;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
public class ActManager {
    private static Stack<Activity> activityStack;
    private static ActManager instance;

    public static ActManager getAppManager() {
        if (instance == null) {
            instance = new ActManager();
        }
        return instance;
    }

    private void initActivityStack() {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
    }

    public void AppExit(Context context) {
        try {
            finishAllActivity();
        } catch (Exception unused) {
        }
    }

    public void addActivity(Activity activity) {
        initActivityStack();
        activityStack.add(activity);
    }

    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    public void finishAllActivity() {
        Stack<Activity> stack = activityStack;
        if (stack == null) {
            return;
        }
        int size = stack.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (activityStack.get(i2) != null) {
                Activity activity = activityStack.get(i2);
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
        activityStack.clear();
    }

    public void finishActivity() {
        finishActivity(activityStack.lastElement());
    }

    public void finishActivity(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<Activity> it = activityStack.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(cls)) {
                arrayList.add(next);
            }
        }
        activityStack.removeAll(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            finishActivity((Activity) it2.next());
        }
    }
}
