package com.xiaopang;

import static com.xiaopang.xianyu.node.AccUtils.printLogMsg;

import android.content.Context;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xiaopang.xianyu.activitys.MainActivity;
import com.xiaopang.xianyu.utils.FileUtils;
import com.xiaopang.xianyu.utils.StringUtils;


public class Constant {
    public static boolean DEV_MODE = false; // 开发者模式
    public static String XIAOPANG_INFO = "小胖";
    public static String XIAOPANG_INFO_HOME = "小胖 XIAOPANG_INFO_HOME";
    public static final String PATH = "/XIAOPANG_DIR/";


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

    public static boolean isRunning = false; // 是否有任务在运行
    public static boolean isOpenFloatWin = false; // 悬浮窗是否打开
    public static String checkedFileName = ""; // 当前选中的脚本文件名称


    public static void saveConfig() {

        // 使用Gson的JsonObject来构建和填充数据
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("DEV_MODE", DEV_MODE);
        jsonObject.addProperty("CHECKED_FILE_NAME", checkedFileName);

        // 将JsonObject转换为字符串
        String configString = jsonObject.toString();
        printLogMsg(configString, 0);
        FileUtils.writeToTxt("/sdcard/FATJS_DIR/config.json", configString);
    }

    public static void reviewConfig() {
        String readFile = FileUtils.readFile("/sdcard/FATJS_DIR/config.json");
        if (StringUtils.isEmpty(readFile)) {
            printLogMsg("reviewConfig empty", 0);
            saveConfig();
            return;
        }
        // 使用Gson的JsonParser来解析字符串
        JsonObject parseObject = JsonParser.parseString(readFile).getAsJsonObject();

        // 从解析后的JsonObject中获取特定的值
        DEV_MODE = parseObject.get("DEV_MODE").getAsBoolean();
        checkedFileName = parseObject.get("CHECKED_FILE_NAME").getAsString();
    }
}
