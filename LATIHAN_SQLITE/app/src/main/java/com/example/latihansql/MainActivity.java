package com.example.latihansql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button tambah_data;
    ArrayList<Objek> list;
    Cursor cursor;
    BiodataTbl biodataTbl;
    custome_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        tambah_data = findViewById(R.id.tambah_data);

        biodataTbl = new BiodataTbl(getApplicationContext());

        // Mengatur tindakan saat tombol "Tambah Data" diklik
        tambah_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Tambah_data.class));
            }
        });
        ambil_data();
    }

    // Metode untuk mengambil data dari database dan menampilkannya dalam daftar
    void ambil_data() {
        list = new ArrayList<Objek>();
        cursor = biodataTbl.tampil_data();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(0); // id_data
                String nama = cursor.getString(1); // get_nama
                String alamat = cursor.getString(2);
                list.add(new Objek(id, nama, alamat));
            }
            adapter = new custome_adapter(getApplicationContext(), list, MainActivity.this);
            listView.setAdapter(adapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ambil_data();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }

    // Kelas adapter kustom untuk mengatur tampilan item dalam daftar
    class custome_adapter extends BaseAdapter {

        Activity activity;
        BiodataTbl biodataTbl;
        Context context;
        LayoutInflater layoutInflater;
        ArrayList<Objek> model;

        custome_adapter(Context context, ArrayList<Objek> list, Activity activity) {
            this.context = context;
            this.model = list;
            this.activity = activity;
            layoutInflater = LayoutInflater.from(context);
            biodataTbl = new BiodataTbl(context);
        }

        @Override
        public int getCount() {
            return model.size();
        }

        @Override
        public Object getItem(int position) {
            return model.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        TextView id, nama, alamat;
        Button edit, hapus;

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View view1 = layoutInflater.inflate(R.layout.list_data, viewGroup, false);
            id = view1.findViewById(R.id.id);
            nama = view1.findViewById(R.id.nama);
            alamat = view1.findViewById(R.id.alamat);

            id.setText(model.get(position).getId());
            nama.setText(model.get(position).getNama());
            alamat.setText(model.get(position).getAlamat());

            edit = view1.findViewById(R.id.edit);
            hapus = view1.findViewById(R.id.hapus);

            // Mengatur tindakan saat tombol "Edit" diklik
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, Edit_data.class);
                    intent.putExtra("id", model.get(position).getId());
                    intent.putExtra("nama", model.get(position).getNama());
                    intent.putExtra("alamat", model.get(position).getAlamat());
                    activity.startActivity(intent);
                }
            });

            // Mengatur tindakan saat tombol "Hapus" diklik
            hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Tanya");
                    builder.setMessage("Apakah anda ingin menghapus data ini?");
                    builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Menghapus data dari database
                            biodataTbl.delete(model.get(position).getId());
                            // Mengambil ulang data dan memperbarui tampilan
                            ambil_data();
                        }
                    });
                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            return view1;
        }
    }
}
