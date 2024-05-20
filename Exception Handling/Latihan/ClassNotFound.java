package Latihan;

public class ClassNotFound {
    public static void main(String[] args) {
        try{
            Class.forName("TI - C");

        } catch(ClassNotFoundException e){
            System.out.println("\nTerjadi kesalahan : " + e);

        } finally {
            System.out.println("\nini adalah finnal dari try-catch ClassNotFoundException");
        }
    }
}
