package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment2 extends Fragment {

    // Konstruktor kosong yang diperlukan oleh Fragment
    public fragment2() {
        // Biasanya tidak perlu melakukan apa pun di sini.
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Menggunakan inflater untuk menggembalikan tampilan/layout yang sesuai dengan fragment ini.
        // R.layout.fragment2 adalah layout XML yang akan digunakan untuk fragment ini.
        View view = inflater.inflate(R.layout.fragment2, container, false);

        // Pastikan untuk mengembalikan tampilan yang sudah di-inflate.
        return view;
    }
}
