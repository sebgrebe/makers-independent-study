import java.util.*;

public class timing {

  public static void main(String[] args) {

    List<Integer> arrayList = createList(100000);
    int rounds = 1000000;

    //get time for getting last element of array
    double diff = testGetLast(arrayList, rounds);
    printTestResult(diff, "get last element of an array");

    //get time for reversing array
    diff = testReverse(arrayList, 1000);
    printTestResult(diff, "reverse array");

    //get time for shuffling
    diff = testShuffle(arrayList, 1000);
    printTestResult(diff, "shuffle array");

    //get time for sorting
    diff = testShuffle(arrayList, 1000);
    printTestResult(diff, "sort array");
  }

  public static void printTestResult(double result, String operation) {
    System.out.println("It takes \n\t"
      + result + " ms\nto "
      + operation
    );
  }

  public static List<Integer> createList(int size) {
    List<Integer> arrayList = new ArrayList<Integer>();
    for (int i = 1; i < size; i++) {
      arrayList.add(i);
    }
    return arrayList;
  }

  public static double testGetLast(List testArrayList, int rounds) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    for (int i = 0; i < rounds; i++) {
      Object last = testArrayList.get(testArrayList.size() - 1);
    }
    endTime = System.currentTimeMillis();
    // System.out.println(startTime);
    double diff = (endTime - startTime) / rounds ;
    return diff;
  }

  public static double testReverse(List testArrayList, int rounds) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    for (int j=0; j < rounds; j++) {
      Collections.reverse(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

  public static double testShuffle(List testArrayList, int rounds) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    for (int j=0; j < rounds; j++) {
      Collections.shuffle(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

  public static double testSort(List testArrayList, int rounds) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    Collections.shuffle(testArrayList);
    for (int j=0; j < rounds; j++) {
      Collections.sort(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }


}
