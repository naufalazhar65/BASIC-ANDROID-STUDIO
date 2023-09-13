package com.example.latihansql;

public class Objek {
    String id = "", nama = "", alamat = "";

    // Konstruktor untuk membuat objek dengan data id, nama, dan alamat
    Objek(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    // Metode untuk mendapatkan nilai id
    public String getId() {
        return id;
    }

    // Metode untuk mendapatkan nilai nama
    public String getNama() {
        return nama;
    }

    // Metode untuk mendapatkan nilai alamat
    public String getAlamat() {
        return alamat;
    }
}
