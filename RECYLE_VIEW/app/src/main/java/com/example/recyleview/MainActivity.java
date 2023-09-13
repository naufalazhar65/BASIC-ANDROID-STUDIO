package com.example.recyleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Objek> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tambah_data();
        recyclerView = findViewById(R.id.res);
        CustomAdapter adapter = new CustomAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Jika ingin Horizontal Scroll
        // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(adapter);
        adapter.setKlikListener(new CustomAdapter.RecycleClick() {
            @Override
            public void onItemClicked(View view, int position) {
                // Menampilkan pesan Toast saat item di-klik
                Toast.makeText(MainActivity.this, list.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void tambah_data() {
        list = new ArrayList<Objek>();
        list.add(new Objek("Naufal", "Bandung, Jawa Barat"));
        list.add(new Objek("Rizal", "Bandung, Jawa Barat"));
        list.add(new Objek("Fazri", "Bandung, Jawa Barat"));
        list.add(new Objek("Debdy", "Bandung, Jawa Barat"));
        list.add(new Objek("Babi", "Bandung, Jawa Barat"));
        list.add(new Objek("Monyet", "Bandung, Jawa Barat"));

    }
}

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    // Interface untuk menangani klik pada item RecyclerView
    interface RecycleClick {
        void onItemClicked(View view, int position);
    }

    private RecycleClick listener;
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Objek> model;

    CustomAdapter(Context context, ArrayList<Objek> list) {
        this.context = context;
        this.model = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nama.setText(model.get(position).getNama());
        holder.alamat.setText(model.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    // Metode untuk mengatur listener klik
    void setKlikListener(RecycleClick recycleClick) {
        this.listener = recycleClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, alamat;

        ViewHolder(View view) {
            super(view);
            nama = view.findViewById(R.id.nama);
            alamat = view.findViewById(R.id.alamat);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Memastikan listener tidak null sebelum memanggilnya
                    if (listener != null) {
                        listener.onItemClicked(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}
