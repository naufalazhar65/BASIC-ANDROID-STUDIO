package com.example.intentdanaktifiti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Deklarasi variabel
    EditText nama, tempat_lahir;
    Button kirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen UI
        nama = findViewById(R.id.nama);
        tempat_lahir = findViewById(R.id.tempat_lahir);
        kirim = findViewById(R.id.kirim_data);

        // Menambahkan event listener untuk tombol "Kirim Data"
        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Membuat intent untuk berpindah ke Activity2
                Intent intent = new Intent(getApplicationContext(), Activity2.class);

                // Mengirim data melalui intent
                intent.putExtra("Kirim nama", nama.getText().toString());
                intent.putExtra("Kirim tempat lahir", tempat_lahir.getText().toString());

                // Memulai Activity2 dengan intent
                startActivity(intent);
            }
        });
    }
}
