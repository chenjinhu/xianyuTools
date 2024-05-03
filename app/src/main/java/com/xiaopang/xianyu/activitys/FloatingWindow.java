package com.xiaopang.xianyu.activitys;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import static com.xiaopang.Constant.*;
public class FloatingWindow extends Service {
//    DataReceiver dataReceiver = null;
    private static final String ACTIONR = "com.msg";

    private static final String TAG = tag;
    private WindowManager wm;
    private ScrollView sv;
    private int float_window_width = (int)(mWidth / 2.5);
    private int float_window_height = (int)(mHeight / 10.1333);
    private int offset_y = (mHeight / 5);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
