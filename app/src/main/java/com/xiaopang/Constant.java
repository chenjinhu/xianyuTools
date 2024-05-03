package com.xiaopang;

import android.content.Context;

import com.xiaopang.xianyu.activitys.MainActivity;


public class Constant {
    public static String tag = "xiaopang";
    // 上下文
    public static Context context = null;
    public static MainActivity mainActivity = null;

    // 当前ActivityName
    public static volatile String currentActivityName = "";
    // 屏幕宽高
    public static int text_size = 11;
    public static int mWidth = 1440;
    public static int mHeight = 3040;
    public static int __mHeight = -1; //去掉导航栏和状态栏的高度
    // 中控服务端接口, 预留
    public static String API = "http://192.168.1.37:5000";

    // 闲鱼包名
    public static String PackageNameXianyu = "com.taobao.idlefish";

    public static String ActivityPrimary = "com.taobao.idlefish.ui.alert.base.container.FishDialog";

    // 是否已经打开过闲鱼, 一般情况下，只默认打开一次闲鱼进程
    public static boolean OpenXianyu = true;

    public static boolean isClickMe = false;
    // 是否强制关闭线程
    public static boolean  killThread = false;
    // 暂停标志
    public static boolean isStop = false;
    //
}
