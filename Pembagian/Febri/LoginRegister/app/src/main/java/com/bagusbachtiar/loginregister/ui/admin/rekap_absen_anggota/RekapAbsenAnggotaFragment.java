package com.bagusbachtiar.loginregister.ui.admin.rekap_absen_anggota;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bagusbachtiar.loginregister.R;

public class RekapAbsenAnggotaFragment extends Fragment {

    private RekapAbsenAnggotaViewModel mViewModel;

    public static RekapAbsenAnggotaFragment newInstance() {
        return new RekapAbsenAnggotaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rekap_absen_anggota, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RekapAbsenAnggotaViewModel.class);
        // TODO: Use the ViewModel
    }

}