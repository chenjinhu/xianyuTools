package com.xiaopang.xianyu;

import android.app.Application;
import android.content.Context;

public class WrapperApplication extends Application {
    private boolean privacyPolicyAgreed = true;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        privacyPolicyAgreed = true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //注意APP合规性，若最终用户未同意隐私政策则不要调用
        if (privacyPolicyAgreed) {

        }
    }

}
