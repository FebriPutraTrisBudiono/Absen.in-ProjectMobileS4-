package com.bagusbachtiar.loginregister.ui.admin.anggota;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnggotaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AnggotaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is anggota fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}