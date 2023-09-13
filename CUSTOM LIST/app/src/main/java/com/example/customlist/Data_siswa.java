package com.example.customlist;

public class Data_siswa {
    // Variabel-variabel untuk menyimpan nama dan alamat siswa
    private String Nama = "";
    private String Alamat = "";

    // Konstruktor untuk menginisialisasi objek Data_siswa
    public Data_siswa(String setNama, String setAlamat) {
        this.Nama = setNama;
        this.Alamat = setAlamat;
    }

    // Metode getter untuk mendapatkan nama siswa
    public String getNama() {
        return Nama;
    }

    // Metode getter untuk mendapatkan alamat siswa
    public String getAlamat() {
        return Alamat;
    }
}
