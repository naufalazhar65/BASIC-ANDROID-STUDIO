package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText angka1, angka2; // Input teks untuk angka pertama dan angka kedua
    Button hitung; // Tombol untuk menghitung jumlah
    TextView hasil; // Tampilan teks untuk menampilkan hasil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen-elemen UI
        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);

        // Mengatur listener untuk tombol "Hitung"
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengambil nilai dari input teks angka1 dan angka2
                String nilaiAngka1 = angka1.getText().toString();
                String nilaiAngka2 = angka2.getText().toString();

                if (!nilaiAngka1.isEmpty() && !nilaiAngka2.isEmpty()) {
                    // Mengonversi nilai input teks menjadi integer
                    int integerAngka1 = Integer.parseInt(nilaiAngka1);
                    int integerAngka2 = Integer.parseInt(nilaiAngka2);

                    // Menghitung hasil penjumlahan
                    int hasilJumlah = integerAngka1 + integerAngka2;

                    // Menampilkan hasil penjumlahan pada TextView hasil
                    hasil.setText("Hasil = " + hasilJumlah);
                } else {
                    // Jika salah satu input teks kosong, menampilkan hasil kosong
                    hasil.setText("Hasil = ");
                }
            }
        });
    }
}
