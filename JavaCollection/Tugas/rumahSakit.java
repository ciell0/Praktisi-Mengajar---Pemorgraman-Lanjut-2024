package Tugas;
import java.util.*;

public class rumahSakit {
    public static void main(String[] args) {
        Queue<String> namaPasien = new ArrayDeque<>();
                
        // List pasien
        namaPasien.offer("ciello belleza");
        namaPasien.offer("aquila wangipratiwi");
        namaPasien.offer("ariela pramudiastri");
                
        // Output Nama Pasien
        System.out.println("Nama Pasien dalam antrian:");
        int i = 1;
                
        for(String next = namaPasien.poll(); next != null; next = namaPasien.poll()) {
            System.out.print(i + ") "); 
            System.out.println(next);
            i++;
        }
    }
}

