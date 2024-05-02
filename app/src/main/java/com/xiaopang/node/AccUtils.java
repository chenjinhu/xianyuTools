package com.xiaopang.node;
import static com.xiaopang.Constant.*;
import android.accessibilityservice.AccessibilityService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
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
