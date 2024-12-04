package com.xiaopang.xianyu.utils;

import static com.xiaopang.Constant.tag;
import static com.xiaopang.xianyu.node.AccUtils.printLogMsg;
import static com.xiaopang.xianyu.utils.AbstractShell.COMMAND_EXIT;
import static com.xiaopang.xianyu.utils.AbstractShell.COMMAND_LINE_END;
import static com.xiaopang.xianyu.utils.AbstractShell.COMMAND_SH;
import static com.xiaopang.xianyu.utils.AbstractShell.COMMAND_SU;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;


public class ShellUtils {
    private static final String TAG = tag;
    private Process mProcess;
    private DataOutputStream mCommandOutputStream;
    private BufferedReader mSucceedReader;
    private BufferedReader mErrorReader;

    private StringBuilder mSucceedOutput = new StringBuilder();
    private StringBuilder mErrorOutput = new StringBuilder();


    public static String execCommand(String command, boolean isRoot){
        AbstractShell.Result commandResult  = new AbstractShell.Result();
        // 对于空指令，直接返回空字符串
        if (command == null || command.length() == 0){
            return "";
        }
        Process process = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec(isRoot ? COMMAND_SU : COMMAND_SH);
            os = new DataOutputStream(process.getOutputStream());

            // 写入命令
            StringBuilder output = new StringBuilder();
            os.write(command.getBytes());
            os.writeBytes(COMMAND_LINE_END);
            os.flush();

            // 退出
            os.writeBytes(COMMAND_EXIT);
            os.flush();

            commandResult.code = process.waitFor();
            commandResult.result = readAll(process.getInputStream());
            commandResult.error = readAll(process.getErrorStream());


        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }finally {
            return commandResult.result;
        }
    }
    public static String execCommand(String command){
        return execCommand(command,false);
    }

    public static String sudo(String command){
        return execCommand(command,true);
    }
    private static String readAll(InputStream inputStream) throws IOException {
        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = reader.readLine()) != null) {
            builder.append(line).append('\n');
        }
        return builder.toString();
    }
    public static boolean installApp(String path){
        String str = execCommand("pm install -r " + path);
        printLogMsg(str);
        return false;

    }

    public ShellUtils readAll() {
        return readSucceedOutput().readErrorOutput();
    }

    public ShellUtils readSucceedOutput() {
        read(mSucceedReader, mSucceedOutput);
        return this;
    }
    public ShellUtils readErrorOutput() {
        read(mErrorReader, mErrorOutput);
        return this;
    }
    private void read(BufferedReader reader, StringBuilder sb) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }



}
