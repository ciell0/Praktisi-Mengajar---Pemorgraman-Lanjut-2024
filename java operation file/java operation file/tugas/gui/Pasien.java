package com.mycompany.gui;

public class Pasien {
    String nama;
    int umur;
    int nomorAntrian;
    String tanggal;

    public Pasien(String nama, int umur, int nomorAntrian, String tanggal) {
        this.nama = nama;
        this.umur = umur;
        this.nomorAntrian = nomorAntrian;
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Nomor Antrian: " + nomorAntrian + ", Nama: " + nama + ", Umur: " + umur + ", Tanggal: " + tanggal;
    }
}
