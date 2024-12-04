package com.xiaopang.xianyu.utils;

import static com.xiaopang.Constant.tag;

public class ShellUtils {
    private static final String TAG = tag;


    public static boolean shell(String command){
        try {
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean installApp(String path){
        return shell("pm install -r " + path);
    }
}
