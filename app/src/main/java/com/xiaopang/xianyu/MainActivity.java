package com.xiaopang.xianyu;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.xiaopang.Constant;
import com.xiaopang.tools.Enviroment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textXianyuInstalled = findViewById(R.id.text_xianyuInstalled);
        textXianyuInstalled.setText("闲鱼安装状态:" + Enviroment.checkAppInstalled(getApplicationContext(), Constant.PackageNameXianyu));

        TextView textAsPermission = findViewById(R.id.text_Aspermission);
        boolean accessibilityEnabled = Enviroment.checkAccessibilityEnabled(getApplicationContext());

        textAsPermission.setText("无障碍权限:" + accessibilityEnabled);
//        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BIND_ACCESSIBILITY_SERVICE},);

        ArrayList<String> funcList = new ArrayList<>();
        funcList.add("启动应用");
        funcList.add("检测登录状态");
        LinearLayout layoutFuncCheckbox = findViewById(R.id.layout_func_checkbox);
        for (final String func:funcList){
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(func);

            layoutFuncCheckbox.addView(checkBox);
            checkBox.setChecked(true);


        }


    }
}