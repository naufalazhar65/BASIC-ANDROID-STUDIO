package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nama;
    Button simpan, hapus;
    TextView hasil;
    SharedPreferences.Editor setdata;
    SharedPreferences getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setdata=getSharedPreferences("data", MODE_PRIVATE).edit();
        getData=getSharedPreferences("data", MODE_PRIVATE);
        nama=(findViewById(R.id.nama));
        simpan=(findViewById(R.id.simoan));
        hapus=(findViewById(R.id.hapus));
        hasil=(findViewById(R.id.hasil));

        if(getData.contains("session nama")) //ini untuk mengecek ketersediaan session
        {
            hasil.setText(getData.getString("session nama", null) //ini untuk membaca data
            );
        }
        else{
            hasil.setText("Data belum disompan");
        }

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setdata.putString("session nama", nama.getText().toString());
                setdata.apply();
                hasil.setText(nama.getText().toString());

            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData.edit().clear().commit(); // untuk menghapus semua data
//                getData.edit().remove("session nama").commit(); // untuk menghapus satu case saja
                hasil.setText("");

            }
        });
    }
}