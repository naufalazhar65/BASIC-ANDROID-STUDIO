package com.example.bottomnavigationdanfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    TextView text;
    Button ganti;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout fragment3.xml ke tampilan Fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);

        // Inisialisasi TextView dan Button
        text = view.findViewById(R.id.text);
        ganti = view.findViewById(R.id.ganti);

        // Set OnClickListener untuk Button
        ganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ubah teks dalam TextView saat Button diklik
                text.setText("Oke, ini adalah fragment 3");
            }
        });

        return view;
    }
}
