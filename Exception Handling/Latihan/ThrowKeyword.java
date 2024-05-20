package Latihan;

public class ThrowKeyword {
    static void checkPrice(int price) {
        if (price < 2000000) {
          throw new ArithmeticException("Access denied - You must be at least have 2 million dollar.");
        }
        else {
          System.out.println("Access granted - You are in!");
        }
      }

      public static void main(String[] args) {
        checkPrice(1500000); // Set price to 1.5 million (which is below 2 million...)
      }
}
