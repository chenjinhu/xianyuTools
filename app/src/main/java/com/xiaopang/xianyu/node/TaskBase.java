package com.xiaopang.xianyu.node;

import static com.xiaopang.Constant.*;
import static com.xiaopang.xianyu.node.AccUtils.loadScriptFromAssets;
import static com.xiaopang.xianyu.node.AccUtils.printLogMsg;

import android.content.Intent;
import android.widget.Toast;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.converters.JavetProxyConverter;
import com.xiaopang.xianyu.okhttp3.HttpUtils;
import com.xiaopang.xianyu.utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;

public class TaskBase implements ITaskBase{
    private static String base;
    public void _print(String msg) {
        printLogMsg(msg);
    }


    public void _openPkName(String packageName) {
        AccUtils.startApplication(context, packageName);
    }

    public void initJavet(String script_path) {

        // V8 解析核心
        try {
            // 创建 v8 runtime
            v8Runtime = V8Host.getV8Instance().createV8Runtime();
            isRunning = true;
            isStop = false;
            killThread = false;
            // 加载脚本
            String script = FileUtils.readFile(script_path);

            // 加载基础脚本
            if (base == null) {
                base = loadScriptFromAssets("base.js");
            }

            v8Runtime.setConverter(new JavetProxyConverter());
            // 设置全局变量 engines
            v8Runtime.getGlobalObject().set("engines", TaskBase.class);
            // 设置全局变量 http
            v8Runtime.getGlobalObject().set("http", HttpUtils.class);
//            v8Runtime.getGlobalObject().set("websocket", WebSocketUtils.class);
//            v8Runtime.getGlobalObject().set("UiObject", UiObject.class);
//            v8Runtime.getGlobalObject().set("app", App.class);
//            v8Runtime.getGlobalObject().set("Intent", Intent.class);
//            v8Runtime.getGlobalObject().set("ntpService", NtpService.class);

            // 判断脚本是否包含 task 变量
            if (!script.contains("let task = new engines()")) {
                script = base + "\n" + script;
            }
            v8Runtime.getExecutor(script).executeVoid();
            Toast.makeText(context, "脚本加载成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            killThread = false;
            printLogMsg(e.toString());
        } finally {
            isRunning = false;
            isStop = true;
            killThread = true;
        }
    }




}
