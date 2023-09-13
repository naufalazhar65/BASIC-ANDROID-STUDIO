package com.example.latihansql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Random;

public class BiodataTbl extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase database;

    public static final String nama_database = "data";
    public static final String nama_table = "biodata";

    public BiodataTbl(@Nullable Context context) {
        super(context, nama_database, null, 3);
        this.context = context;
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Membuat tabel jika belum ada
        String query = "CREATE TABLE IF NOT EXISTS " + nama_table + " (id varchar(50), nama varchar(50), alamat varchar(100))";
        sqLiteDatabase.execSQL(query);
    }

    // Metode untuk menghasilkan nomor acak
    private String random() {
        // Membangkitkan nomor acak dari 100 hingga 999
        int acak = new Random().nextInt(888) + 100;
        return String.valueOf(acak);
    }

    // Metode untuk menyimpan data ke database
    public void simpan_data(String nama, String alamat) {
        // Memasukkan data ke dalam tabel dengan nomor acak sebagai id
        database.execSQL(
                "INSERT INTO " + nama_table + " values" +
                        "('" + random() + "','" + nama + "','" + alamat + "')"
        );
        // Menampilkan pesan sukses
        Toast.makeText(context, "Data Tersimpan", Toast.LENGTH_SHORT).show();
    }

    // Metode untuk memperbarui data dalam database
    void update_data(String id, String nama, String alamat) {
        database.execSQL("UPDATE " + nama_table +
                " SET nama='" + nama + "', alamat='" + alamat + "'" +
                " WHERE id='" + id + "'");
        // Menampilkan pesan sukses
        Toast.makeText(context, "Data Berhasil di Update", Toast.LENGTH_SHORT).show();
    }

    // Metode untuk menghapus data dari database
    void delete(String id) {
        database.execSQL("DELETE FROM " + nama_table + " WHERE id='" + id + "'");
        // Menampilkan pesan sukses
        Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

    // Metode untuk mengambil semua data dari tabel
    public Cursor tampil_data() {
        Cursor cursor = database.rawQuery("SELECT * FROM " + nama_table, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Handle pembaruan database jika diperlukan
    }
}
