import java.util.*;

public class Timing extends myMethods {

  public static void main(String[] args) {
    int size = 100_000;
    List<Integer> arrayList = createList(size);
    int rounds = 100;

    //get time for getting last element of array
    double diff;
    // diff = testGetLast(arrayList, 1000000);
    // printTestResult(diff, "get last element of an array", size);
    //
    // //get time for reversing array
    // diff = testReverse(arrayList, rounds);
    // printTestResult(diff, "reverse array", size);

    //get time for my reversing method
    diff = testMyReverse(arrayList, rounds);
    printTestResult(diff, "reverse array with my method", size);

    //get time for shuffling
    // diff = testShuffle(arrayList, rounds);
    // printTestResult(diff, "shuffle array", size);

    //get time for my shuffling
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

  public static List<Integer> createList(int size) {
    List<Integer> arrayList = new ArrayList<Integer>();
    for (int i = 1; i < (size + 1); i++) {
      arrayList.add(i);
    }
    return arrayList;
  }

  public static double testGetLast(List testArrayList, int rounds) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    for (int i = 0; i < rounds; i++) {
      Object last = testArrayList.get(testArrayList.size() - 1);
    }
    endTime = System.currentTimeMillis();
    // System.out.println(startTime);
    double diff = (endTime - startTime) / rounds ;
    return diff;
  }

  public static double testReverse(List testArrayList, int rounds) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    for (int j=0; j < rounds; j++) {
      Collections.reverse(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
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

  public static double testMyShuffle(List testArrayList, int rounds) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    Collections.shuffle(testArrayList);
    for (int j=0; j < rounds; j++) {
      myShuffle(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

}
