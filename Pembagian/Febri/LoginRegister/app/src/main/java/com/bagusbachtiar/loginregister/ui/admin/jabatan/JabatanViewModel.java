package com.bagusbachtiar.loginregister.ui.admin.jabatan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JabatanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JabatanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is jabatan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}