package com.xiaopang.xianyu.activitys;

import static com.xiaopang.Constant.PATH;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.xiaopang.xianyu.R;

public class EditorActivity extends AppCompatActivity {
    public static final String scripts_path = Environment.getExternalStorageDirectory() + PATH;
    private boolean isDark;

    private void isDark() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        isDark = sharedPref.getBoolean("dark_mode", false);
        if (isDark) super.setTheme(R.style.AppThemeDark);
        else super.setTheme(R.style.AppThemeLight);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        isDark();
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_color));
        setContentView(R.layout.editor);
//
        init_editor();
//
//        ed = new Editor(editor, lines, title, this, isDark);
//        ed.SCRIPT_PATH = scripts_path;
//
//        read_script();
    }

    private void init_editor() {
        LinearLayout layout = findViewById(R.id.editor_layout);

        // 判断是否为夜间模式
        if (isDark) {
            layout.setBackgroundColor(getResources().getColor(android.R.color.black));
        }else{
            layout.setBackgroundColor(getResources().getColor(android.R.color.white));
        }

        final View header = findViewById(R.id.header);

        final View insert_btn = findViewById(R.id.insert_btns);

    }



}
