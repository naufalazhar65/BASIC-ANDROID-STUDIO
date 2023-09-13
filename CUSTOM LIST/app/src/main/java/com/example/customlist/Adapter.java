package com.example.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Data_siswa> model;

    // Konstruktor Adapter untuk menginisialisasi konteks dan data model
    public Adapter(Context context, ArrayList<Data_siswa> model) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.size(); // Mengembalikan jumlah data dalam ArrayList
    }

    @Override
    public Object getItem(int i) {
        return model.get(i); // Mengembalikan objek Data_siswa pada posisi tertentu
    }

    @Override
    public long getItemId(int position) {
        return position; // Mengembalikan ID item, biasanya posisi dalam ArrayList
    }

    static class ViewHolder {
        TextView nama;
        TextView alamat;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            // Jika view belum ada, inflate layout list_item.xml
            view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);

            // Inisialisasi ViewHolder untuk menyimpan referensi tampilan
            viewHolder = new ViewHolder();
            viewHolder.nama = view.findViewById(R.id.nama);
            viewHolder.alamat = view.findViewById(R.id.alamat);

            // Menyimpan ViewHolder dalam tag view untuk digunakan nanti
            view.setTag(viewHolder);
        } else {
            // Jika view sudah ada, dapatkan ViewHolder dari tag view
            viewHolder = (ViewHolder) view.getTag();
        }

        // Mengisi data ke tampilan dengan menggunakan ViewHolder
        viewHolder.nama.setText(model.get(index).getNama());
        viewHolder.alamat.setText(model.get(index).getAlamat());

        return view;
    }
}
