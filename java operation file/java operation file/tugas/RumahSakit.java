package tugas;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pasien {
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

class AntrianRumahSakit {
    Queue<Pasien> antrianPasien;

    public AntrianRumahSakit() {
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

public class RumahSakit {
    public static void main(String[] args) {
        AntrianRumahSakit antrianRumahSakit = new AntrianRumahSakit();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            antrianRumahSakit.AntrianDariFile("antrian.txt");
            System.out.println("Antrian berhasil dimuat dari file.");
        } catch (IOException e) {
            System.out.println("Gagal memuat antrian dari file: " + e.getMessage());
        }

        try {
            // Menambahkan pasien ke antrian
            System.out.print("Masukkan jumlah pasien yang akan ditambahkan: ");
            int jumlahPasien = Integer.parseInt(scanner.nextLine());

            int i = 0;
            while (i < jumlahPasien) {
                System.out.print("Masukkan nama pasien: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan umur pasien: ");
                String umurInput = scanner.nextLine();

                if (umurInput.isEmpty()) {
                    continue;
                }

                int umur = Integer.parseInt(umurInput);
                if (umur <= 0) {
                    throw new ArithmeticException("Umur pasien tidak valid. Umur harus lebih dari 0.");
                }

                String tanggal = formatter.format(new Date());
                int nomorAntrian = antrianRumahSakit.antrianPasien.size() + 1;

                antrianRumahSakit.tambah(new Pasien(nama, umur, nomorAntrian, tanggal));
                i++;
            }

            // Menampilkan antrian
            antrianRumahSakit.tampilkanAntrian();

            // Simpan antrian ke file
            try {
                antrianRumahSakit.simpanAntrianKeFile("antrian.txt");
                System.out.println("Antrian berhasil disimpan ke file.");
            } catch (IOException e) {
                System.out.println("Gagal menyimpan antrian ke file: " + e.getMessage());
            }

            // Memproses antrian
            for (i = 0; i < jumlahPasien; i++) {
                Pasien pasien = antrianRumahSakit.keluarkan();
                if (pasien != null) {
                    System.out.println(pasien.nama + " telah dikeluarkan dari antrian.");
                } else {
                    System.out.println("Antrian kosong.");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Jumlah pasien harus berupa angka.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
