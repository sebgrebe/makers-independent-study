import java.util.ArrayList;

// can you remember how to set up your main function?
public class Arrays {
  public static void main(String [] args) {
    // declare an array of Strings and print it
    String[] arr_string = new String[2];
    arr_string[0] = "Hello";
    arr_string[1] = "World";
    System.out.println(arr_string[0]);
    System.out.println(arr_string[1]);
    // declare an array of integers and print it
    int[] arr_int = new int[3];
    arr_int[0] = 1;
    arr_int[1] = 2;
    arr_int[2] = 3;
    System.out.println(arr_int[0]);
    System.out.println(arr_int[1]);
    System.out.println(arr_int[2]);
    // declare an ArrayList of integers, add numbers to it, and then print it
    ArrayList<Integer> arrList = new ArrayList<Integer>(4);
    arrList.add(4);
    arrList.add(5);
    arrList.add(6);
    arrList.add(7);
    System.out.println(arrList);
  }
}
