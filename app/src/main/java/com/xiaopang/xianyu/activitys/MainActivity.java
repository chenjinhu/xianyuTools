package com.xiaopang.xianyu.activitys;

import static com.xiaopang.Constant.*;
import static com.xiaopang.xianyu.node.AccUtils.startApplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.xiaopang.Constant;
import static com.xiaopang.xianyu.node.AccUtils.*;

import com.xiaopang.xianyu.R;
import com.xiaopang.xianyu.activitys.FloatingButton;
import com.xiaopang.xianyu.activitys.FloatingWindow;
import com.xiaopang.xianyu.config.WindowPermission;
import com.xiaopang.xianyu.service.MyService;
import com.xiaopang.xianyu.tools.Enviroment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String TAG = tag;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_color));
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.argb(165,0,0,0)));
        }

        context = getApplicationContext();
        mainActivity = this;
        // 开启前台服务 未适配低版本安卓
        openFloatWindow();
        openForwardService();
        other();
    }

    private void openFloatWindow() {
        // 在其他应用上层显示
        boolean permission = WindowPermission.checkPermission(this);
        if (permission) {
            printLogMsg("onCreate: permission true => " + permission, 0);
            // 打开悬浮窗
            startService(new Intent(context, FloatingWindow.class));
            // 打开悬浮窗
            startService(new Intent(context, FloatingButton.class));
        }
    }

    public void other(){
        TextView textXianyuInstalled = findViewById(R.id.text_xianyuInstalled);
        textXianyuInstalled.setText("闲鱼安装状态:" + Enviroment.checkAppInstalled(getApplicationContext(), Constant.PackageNameXianyu));

        TextView textAsPermission = findViewById(R.id.text_Aspermission);
        boolean accessibilityEnabled = Enviroment.checkAccessibilityEnabled(getApplicationContext());

        textAsPermission.setText("无障碍权限:" + accessibilityEnabled);

        ArrayList<String> funcList = new ArrayList<>();
        funcList.add("启动应用");
        funcList.add("检测登录状态");
        LinearLayout layoutFuncCheckbox = findViewById(R.id.layout_func_checkbox);
        for (final String func:funcList){
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(func);

            layoutFuncCheckbox.addView(checkBox);
            checkBox.setChecked(true);

            work();

        }
        // 绑定按钮
        Button btnDoTask = findViewById(R.id.btnDotask);
        btnDoTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testFunc();
                Toast.makeText(getApplicationContext(),"点击启动养号按钮",Toast.LENGTH_SHORT).show();
            }
        });
        // TaskFlow
    }
    public void initDisplay() {
        
    }

    private void testFunc(){

    };
    private void openForwardService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    protected void work(){
        startApplication(getApplicationContext(),Constant.PackageNameXianyu);
        String acctivityName = currentActivityName();
        Log.d(TAG, "acctivityName: " + acctivityName);
    }
}