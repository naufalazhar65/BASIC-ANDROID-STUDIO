package com.example.latihansql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_data extends AppCompatActivity {

    BiodataTbl biodataTbl;
    EditText nama, alamat;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data);

        // Inisialisasi tampilan dan database helper
        nama = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        update = findViewById(R.id.update_data);
        getSupportActionBar().setTitle("Edit Data " + getIntent().getStringExtra("nama"));

        biodataTbl = new BiodataTbl(getApplicationContext());

        // Mengisi field nama dan alamat dengan data yang dikirimkan
        nama.setText(getIntent().getStringExtra("nama"));
        alamat.setText(getIntent().getStringExtra("alamat"));

        // Mengatur tindakan saat tombol "Update" diklik
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Memanggil metode update_data untuk memperbarui data dalam database
                biodataTbl.update_data(
                        getIntent().getStringExtra("id"),
                        nama.getText().toString(),
                        alamat.getText().toString()
                );
                // Menutup aktivitas edit_data
                finish();
            }
        });
    }
}
