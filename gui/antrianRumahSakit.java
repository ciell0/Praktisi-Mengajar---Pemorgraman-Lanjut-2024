package com.mycompany.gui;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class antrianRumahSakit {
    Queue<Pasien> antrianPasien;

    public antrianRumahSakit() {
        antrianPasien = new LinkedList<>();
    }

    public void tambah(Pasien pasien) {
        antrianPasien.add(pasien);
    }

    public Pasien keluarkan() {
        return antrianPasien.poll();
    }

    public void tampilkanAntrian() {
        for (Pasien pasien : antrianPasien) {
            System.out.println(pasien);
        }
    }

    public void simpanAntrianKeFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Pasien pasien : antrianPasien) {
                writer.write(pasien.nomorAntrian + "," + pasien.nama + "," + pasien.umur + "," + pasien.tanggal);
                writer.newLine();
            }
        }
    }

    public void AntrianDariFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int nomorAntrian = Integer.parseInt(data[0]);
                    String nama = data[1];
                    int umur = Integer.parseInt(data[2]);
                    String tanggal = data[3];
                    antrianPasien.add(new Pasien(nama, umur, nomorAntrian, tanggal));
                }
            }
        }
    }
}
