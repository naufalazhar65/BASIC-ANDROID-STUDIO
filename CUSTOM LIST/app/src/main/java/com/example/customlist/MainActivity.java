package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data_siswa> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan listView dengan elemen UI di layout activity_main.xml
        listView = findViewById(R.id.listview);

        // Memanggil metode untuk menambahkan data ke dalam ArrayList
        tambah_data();

        // Membuat objek adapter kustom dan menghubungkannya dengan ArrayList
        Adapter adapter = new Adapter(getApplicationContext(), list);

        // Mengatur adapter ke dalam listView
        listView.setAdapter(adapter);

        // Menambahkan listener untuk menangani klik item di listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Menampilkan pesan Toast dengan nama siswa yang diklik
                Toast.makeText(getApplicationContext(), list.get(i).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Metode untuk menambahkan data ke dalam ArrayList
    void tambah_data() {
        list = new ArrayList<>();
        list.add(new Data_siswa("Naual", "Pamulang"));
        list.add(new Data_siswa("Rizal", "Bogor"));
    }
}
