package com.tarjani.navigationdemo.ui.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Test fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}