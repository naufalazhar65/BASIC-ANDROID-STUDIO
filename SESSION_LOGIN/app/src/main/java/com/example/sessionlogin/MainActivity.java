package com.example.sessionlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username, password;

    // Data login yang ada
    String[] login_data = {
            "root",         // Username (index 0)
            "root",         // Password (index 1)
            "Naufal Azhar"  // Nama (index 2)
    };

    String tx_username, tx_password;
    SharedPreferences.Editor setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menginisialisasi SharedPreferences untuk menyimpan data login
        setData = getSharedPreferences("data login", MODE_PRIVATE).edit();
        setContentView(R.layout.activity_main);

        // Inisialisasi tampilan
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tx_username = username.getText().toString();
                tx_password = password.getText().toString();

                // Memeriksa apakah username dan password sesuai dengan data login
                if (tx_username.equals(login_data[0]) && tx_password.equals(login_data[1])) {
                    // Menyimpan username dan nama ke SharedPreferences
                    setData.putString("USERNAME", tx_username);
                    setData.putString("NAMA", login_data[2]);
                    setData.apply();

                    // Mengarahkan ke Halaman Utama setelah login berhasil
                    startActivity(new Intent(getApplicationContext(), Halaman_utama.class));
                    finish(); // Mengakhiri aktivitas saat ini
                } else {
                    // Menampilkan pesan kesalahan jika login gagal
                    Toast.makeText(getApplicationContext(), "Login salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
