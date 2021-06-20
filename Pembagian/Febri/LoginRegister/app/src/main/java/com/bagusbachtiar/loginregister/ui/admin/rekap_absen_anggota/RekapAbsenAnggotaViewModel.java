package com.bagusbachtiar.loginregister.ui.admin.rekap_absen_anggota;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RekapAbsenAnggotaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public RekapAbsenAnggotaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is absen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}