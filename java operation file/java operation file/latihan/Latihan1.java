package latihan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Latihan1 {
    public static void main(String[] args) {
        // Membuat File
        File file1 = new File("Example.txt");
        
        try {
            file1.createNewFile();
        } catch(IOException e) {
            System.out.println("Terjadi Kesalahan : " + e);
        }
        
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.exists()); // True jika file sudah dibuat sebelumnya
        
        // Membuat Direktori
        File dir1 = new File("Folder1");
        System.out.println(dir1.mkdir());

        File file2 = new File(dir1,"Example2.txt");
        System.out.println(file2.getPath());
        System.out.println(dir1.isDirectory());
        
        // Menggunakan Separator untuk Direktori
        String Folder1 = "data" + File.separator + "save";
        System.out.println("Creating folder " + Folder1);
        File dir2 = new File(Folder1);
        System.out.println(dir2.getAbsolutePath());
    }
}