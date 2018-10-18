// what imports will you need?
import java.util.Scanner;
// can you remember how to set up your main function?
public class ControlFlow {
  public static void main (String [] args) {
    // find a way to read in user input
    while (true) {
      System.out.println("Please enter an integer");
      Scanner scanner = new Scanner(System.in);
      int input = scanner.nextInt();
      if (input == 17) {
        break;
      }
      else if (input % 2 == 0) {
        System.out.println("even");
      } else {
        System.out.println("odd");
      }
    }
    System.out.println("My number 17! Show is over");
  }
}
