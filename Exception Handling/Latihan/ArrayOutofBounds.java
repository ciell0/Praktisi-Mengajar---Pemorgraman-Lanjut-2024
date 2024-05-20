package Latihan;

public class ArrayOutofBounds {
    public static void main(String[] args) {
        try{
            int []arr = new int[2];
            System.out.println(arr[3]);
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nTerjadi kesalahan : " + e);

        } finally {
            System.out.println("\nini adalah final dari try-catch Array Index Out Of Bounds Exception");
        }
    }
    
}
