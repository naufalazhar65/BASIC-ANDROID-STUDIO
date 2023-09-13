package com.example.sessionlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Halaman_utama extends AppCompatActivity {

    SharedPreferences getData;
    TextView nama;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        // Mengambil data login dari SharedPreferences
        getData = getSharedPreferences("data login", MODE_PRIVATE);
        nama = findViewById(R.id.nama);
        logout = findViewById(R.id.logout);

        if (getData.contains("USERNAME")) {
            // Jika data USERNAME ada, tampilkan nama pengguna di TextView
            nama.setText(getData.getString("NAMA", null));
        } else {
            // Jika data USERNAME tidak ada, tampilkan pesan kesalahan dan arahkan ke MainActivity
            Toast.makeText(this, "Harap Login Dulu Ya", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish(); // Mengakhiri aktivitas saat ini
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menghapus semua data login dari SharedPreferences
                getData.edit().clear().apply();

                // Mengarahkan kembali ke MainActivity setelah logout
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish(); // Mengakhiri aktivitas saat ini
            }
        });
    }
}
