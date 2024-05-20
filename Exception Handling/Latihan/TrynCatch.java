package Latihan;
import java.util.*;

public class TrynCatch {
    public static void main(String[ ] args) {

    // TRY and CATCH //
    try {

      int[] numbers = {1, 2, 3};
      System.out.println(numbers[10]);

    } catch (Exception e) {

      System.out.println("Something went wrong.");

    // FINALLY //
    } finally {
      System.out.println("The 'try catch' is finished.");
    } 
}
}
