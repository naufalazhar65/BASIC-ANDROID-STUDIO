package com.example.recyleview;

public class Objek {
    private String nama;   // Menyimpan nama objek
    private String alamat; // Menyimpan alamat objek

    // Konstruktor untuk menginisialisasi objek dengan nama dan alamat
    public Objek(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    // Getter untuk mendapatkan nama objek
    public String getNama() {
        return nama;
    }

    // Getter untuk mendapatkan alamat objek
    public String getAlamat() {
        return alamat;
    }
}
