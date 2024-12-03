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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xiaopang.Constant;
import static com.xiaopang.xianyu.node.AccUtils.*;

import com.xiaopang.xianyu.R;
import com.xiaopang.xianyu.activitys.FloatingButton;
import com.xiaopang.xianyu.activitys.FloatingWindow;
import com.xiaopang.xianyu.config.WindowPermission;
import com.xiaopang.xianyu.databinding.ActivityMainBinding;
import com.xiaopang.xianyu.service.MyService;
import com.xiaopang.xianyu.tools.Enviroment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String TAG = tag;
    private ActivityMainBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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

        // 底部导航栏
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
               .build();
        // 导航栏点击事件
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        if (__mHeight == -1) {
            initDisplay();
        }

//        DevicesOAID(); // OAID/AAID
        reviewConfig(); // 回显 config 数据

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