import java.util.*;
import java.util.function.*;

public class Timing extends myMethods {

  public static void main(String[] args) {
    int size = 1000000;
    ArrayList<Integer> arrayList = createList(size);
    int rounds = 10;

    Function<ArrayList, Void> getLast = testArrayList -> {
      testArrayList.get(testArrayList.size() - 1);
      return null;
    };

    Function<ArrayList, Void> reverse = testArrayList -> {
      Collections.reverse(testArrayList);
      return null;
    };

    Function<ArrayList, Void> shuffle = testArrayList -> {
      Collections.shuffle(testArrayList);
      return null;
    };


    //get time for getting last element of array
    double diff;
    diff = test(arrayList, 1000000, getLast);
    printTestResult(diff, "get last element of an array", size);

    // get time for reversing array
    diff = test(arrayList, rounds, reverse);
    printTestResult(diff, "reverse array", size);

    //get time for my reversing method
    // diff = testMyReverse(arrayList, rounds);
    // printTestResult(diff, "reverse array with my method", size);

    get time for shuffling
    diff = test(arrayList, rounds, shuffle);
    printTestResult(diff, "shuffle array", size);

    // get time for my shuffling
    // diff = testMyShuffle(arrayList, rounds);
    // printTestResult(diff, "shuffle array with my method", size);

    //get time for sorting
    // diff = testSort(arrayList, rounds);
    // printTestResult(diff, "sort array", size);
  }

  public static void printTestResult(double result, String operation, int size) {
    System.out.println("It takes \n\t"
      + result + " ms\nto "
      + operation
      + " with an array of size " + size
    );
  }

  public static ArrayList<Integer> createList(int size) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    for (int i = 1; i < (size + 1); i++) {
      arrayList.add(i);
    }
    return arrayList;
  }

  public static double test(ArrayList testArrayList, int rounds, Function<ArrayList, Void> method) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    for (int i = 0; i < rounds; i++) {
      Object last = method.apply(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds ;
    return diff;
  }

  public static double testShuffle(List testArrayList, int rounds) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    for (int j=0; j < rounds; j++) {
      Collections.shuffle(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

  public static double testSort(List testArrayList, int rounds) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    Collections.shuffle(testArrayList);
    for (int j=0; j < rounds; j++) {
      Collections.sort(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

}
