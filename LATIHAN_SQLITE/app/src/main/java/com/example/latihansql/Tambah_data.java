package com.example.latihansql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tambah_data extends AppCompatActivity {

    BiodataTbl biodataTbl;
    EditText nama, alamat;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data);

        // Inisialisasi tampilan dan database helper
        nama = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        simpan = findViewById(R.id.simpan_data); // Menggunakan ID "simpan" untuk tombol
        biodataTbl = new BiodataTbl(getApplicationContext());

        // Menonaktifkan tombol simpan saat aplikasi pertama kali dimuat
        simpan.setEnabled(false);

        // Menambahkan pendengar teks untuk EditText "nama"
        nama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Tidak perlu melakukan apa-apa di sini
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Panggil metode untuk memperbarui status tombol simpan
                updateSimpanButton();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Tidak perlu melakukan apa-apa di sini
            }
        });

        // Menambahkan pendengar teks untuk EditText "alamat"
        alamat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Tidak perlu melakukan apa-apa di sini
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Panggil metode untuk memperbarui status tombol simpan
                updateSimpanButton();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Tidak perlu melakukan apa-apa di sini
            }
        });

        // Menambahkan pendengar klik untuk tombol "simpan_data"
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpan_data();
                finish();
            }
        });
    }

    // Metode untuk memperbarui status tombol "simpan"
    private void updateSimpanButton() {
        String namaValue = nama.getText().toString();
        String alamatValue = alamat.getText().toString();

        // Aktifkan tombol jika kedua nama dan alamat sudah diisi, nonaktifkan jika salah satu kosong
        simpan.setEnabled(!namaValue.isEmpty() && !alamatValue.isEmpty());
    }

    // Metode untuk menyimpan data ke database
    void simpan_data() {
        String namaValue = nama.getText().toString();
        String alamatValue = alamat.getText().toString();

        // Periksa apakah nama dan alamat tidak kosong sebelum disimpan
        if (!namaValue.isEmpty() && !alamatValue.isEmpty()) {
            biodataTbl.simpan_data(namaValue, alamatValue);
            // Kosongkan input setelah disimpan
            nama.setText("");
            alamat.setText("");
            Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
        } else {
            // Tampilkan pesan kesalahan jika salah satu atau kedua input kosong
            Toast.makeText(getApplicationContext(), "Nama dan Alamat harus diisi", Toast.LENGTH_SHORT).show();
        }
    }
}
