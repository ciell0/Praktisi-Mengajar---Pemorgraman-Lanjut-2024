package Latihan;

public class NullPointer {
    public static void main(String[] args) {
        try { 
            String nama = null; 

        } catch(NullPointerException e) { 
            System.out.println("\nTerjadi kesalahan: " + e);
        } finally {
            System.out.println("\nini adalah final dari try-catch Null Pointer Exception");
        }
    }
}
