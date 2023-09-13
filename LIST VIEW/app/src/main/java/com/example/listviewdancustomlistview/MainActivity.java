package com.example.listviewdancustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Cara pertama
    String[] data={
            "Naufal",
            "Azhar",
            "Fazri",
            "Rizal"
    };
    //Cara Kedua
    ArrayList<String> data_nama;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data();
        listView=findViewById(R.id.listview);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, data_nama);
        listView.setAdapter(adapter);
    }
    //Lanjutan cara kedua
    void data(){
        data_nama=new ArrayList<String>();
        for (int i=0; i<20;i++) {
            data_nama.add(String.valueOf(i+1)+" Naufal A");
        }
    }
}