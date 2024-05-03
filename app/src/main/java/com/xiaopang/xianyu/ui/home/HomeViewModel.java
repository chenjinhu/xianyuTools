package com.xiaopang.xianyu.ui.home;


import static com.xiaopang.Constant.XIAOPANG_INFO_HOME;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(XIAOPANG_INFO_HOME);
    }

    public LiveData<String> getText() {
        return mText;
    }
}