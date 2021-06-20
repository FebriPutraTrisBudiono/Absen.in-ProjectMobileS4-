package com.bagusbachtiar.loginregister.ui.admin.jam_kerja;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JamKerjaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JamKerjaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is jam kerja fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}