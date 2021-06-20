package com.bagusbachtiar.loginregister.ui.admin.anggota;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bagusbachtiar.loginregister.R;

public class AnggotaFragment extends Fragment {
    private AnggotaViewModel anggotaViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        anggotaViewModel =
                new ViewModelProvider(this).get(AnggotaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_anggota, container, false);
        final TextView textView = root.findViewById(R.id.text_anggota);
        anggotaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}