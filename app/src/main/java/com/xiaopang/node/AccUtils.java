package com.xiaopang.node;
import static com.xiaopang.Constant.*;
import android.accessibilityservice.AccessibilityService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.content.pm.PackageManager;

import com.xiaopang.utils.ExceptionUtil;

import java.util.List;

public class AccUtils extends AccessibilityService {
    public static AccessibilityService AccessibilityHelper;
    private static final String TAG = tag;

    public AccUtils() {
        AccessibilityHelper = this;
    }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }


    // ===============  工具类   ===============
    public static Boolean startApplication(Context ctx, String pkName) {
        PackageManager packageManager = ctx.getPackageManager();
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pkName);
        List<ResolveInfo> apps = packageManager.queryIntentActivities(resolveIntent, 0);
        if (apps == null || apps.size() == 0) {
            printLogMsg("Exception startApplication failed: No matching activities found", 0);
            return false;
        }
        ResolveInfo ri = apps.get(0); // Get the first matching activity

        if (ri != null && ri.activityInfo != null) {
            String packageName = ri.activityInfo.packageName;
            String className = ri.activityInfo.name;
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName cn = new ComponentName(packageName, className);
            intent.setComponent(cn);
            try {
                ctx.startActivity(intent);
                return true;
            } catch (SecurityException e) {
                e.printStackTrace();
                printLogMsg("Exception startApplication failed: SecurityException", 0);
            }
        }
        return false;
    }

    /**
     * 获取当前Activity
     */
    public static String currentActivityName() {
        return currentActivityName;
    }
    /**
     * 刷新当前activity
     * @param event
     */
    protected void refreshCurrentActivity(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOWS_CHANGED) {
            String packageName = String.valueOf(event.getPackageName());
            String className = String.valueOf(event.getClassName());
// 获取到了当前活动的包名和类名，可以进行相应处理
             printLogMsg(packageName, 0);
            if (
                    className.startsWith("android.widget.") ||
                            className.startsWith("android.view.") ||
                            currentActivityName.equals(className)
            ) {
                return;
            }
            currentActivityName = className;
            Log.i(TAG, "refreshCurrentActivity: " + className);
        }
    }

    protected void systemClickListener(AccessibilityEvent event) {
        // 监听系统事件
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            // 当发生点击事件时执行相应的操作
            // 可以在这里处理系统点击事件的逻辑
            // printLogMsg("当发生点击事件时执行相应的操作", 0);
        }
    }
        // 日志打印
    public static void printLogMsg(String msg) {
        Intent intent = new Intent();
        intent.setAction("com.msg");
        intent.putExtra("msg", msg);
        context.sendBroadcast(intent);

        if (killThread) { // 停止当前任务
            int i = 1 / 0;
        }
        while (isStop) {
            if (killThread) { // 停止当前任务
                int t = 1 / 0;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                printLogMsg(ExceptionUtil.toString(e), 0);
            }
        }
    }

    // 日志打印
    public static void printLogMsg(String msg, int type) {
        Intent intent = new Intent();
        intent.setAction("com.msg");
        intent.putExtra("msg", msg);
        context.sendBroadcast(intent);
    }
}
