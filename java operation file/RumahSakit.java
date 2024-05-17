package tugas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class rumahSakit {
    public static void main(String[] args) {
        Queue<String> namaPasien = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Silahkan tulis nama pasien: ");
                String nama = input.nextLine();
                if (nama == null || nama.trim().isEmpty()) {
                    System.err.println("Nama pasien tidak boleh kosong!");
                    continue; // Skip this iteration and prompt again
                }
                namaPasien.offer(nama);

                System.out.println();
                System.out.println("Berhenti input? (Y to stop)");
                String stopInput = input.nextLine();
                if (stopInput.equalsIgnoreCase("Y")) {
                    break;
                }
            }

            // Add predefined patients
            namaPasien.offer("ciello belleza");
            namaPasien.offer("aquila wangipratiwi");
            namaPasien.offer("ariela pramudiastri");

            // Output Nama Pasien
            System.out.println("Nama Pasien dalam antrian:");
            StringBuilder dataToWrite = new StringBuilder();
            int i = 1;

            for (String next : namaPasien) {
                System.out.println(i + ") " + next);
                dataToWrite.append(i).append(") ").append(next).append("\n");
                i++;
            }

            // Save to file
            try (FileWriter writer = new FileWriter("Example.txt")) {
                writer.write(dataToWrite.toString());
                System.out.println("Data has been saved to Example.txt");
            } catch (IOException e) {
                System.err.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
            }

        } finally {
            input.close();
        }
    }
}
