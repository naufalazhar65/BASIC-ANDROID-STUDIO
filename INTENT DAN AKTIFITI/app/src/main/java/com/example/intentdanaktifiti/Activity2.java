package com.example.intentdanaktifiti;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView namaTextView, tempatLahirTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Inisialisasi elemen UI
        namaTextView = findViewById(R.id.nama);
        tempatLahirTextView = findViewById(R.id.tempat_lahir);

        // Mendapatkan data yang dikirim dari MainActivity melalui intent
        String getNama = getIntent().getStringExtra("Kirim nama");
        String getTempatLahir = getIntent().getStringExtra("Kirim tempat lahir");

        // Menampilkan data yang diterima pada TextView
        namaTextView.setText(getNama);
        tempatLahirTextView.setText(getTempatLahir);
    }
}
