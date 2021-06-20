package com.bagusbachtiar.loginregister.ui.admin.jam_kerja;

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

public class JamKerjaFragment extends Fragment {

    private JamKerjaViewModel jamkerjaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        jamkerjaViewModel =
                new ViewModelProvider(this).get(JamKerjaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_jam_kerja, container, false);
        final TextView textView = root.findViewById(R.id.text_jamkerja);
        jamkerjaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}