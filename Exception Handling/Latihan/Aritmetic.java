package Latihan;

public class Aritmetic {
    public static void main(String[] args) {
        int a = 12; 
        int b = 0; 
        try{ 
            System.out.println(a/b); 
        } catch(ArithmeticException e){ 
            System.out.println("\nTerjadi kesalahan : " + e);
        } finally {
            System.out.println("\nini adalah final dari try-catch Artihmetic Exception");
        }
    }
}
