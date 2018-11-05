import java.util.*;

public class timing {

  public static void main(String[] args) {
    int[] array = {1,2,3,4};
    List<Integer> arrayList = new ArrayList<>();
    for (int i = 1; i < 11; i++) {
      arrayList.add(i);
    }

    //get time for getting last element of array
    double diff = testGetLast(array);
    printTestResult(diff, "get last element of an array");

    //get time for reversing array
    diff = testReverse(array);
    printTestResult(diff, "reverse array");

    //get time for shuffling
    diff = testShuffle(arrayList);
    printTestResult(diff, "shuffle array");

    //get time for sorting
    diff = testShuffle(arrayList);
    printTestResult(diff, "sort array");
  }

  public static double testGetLast(int[] testArray) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    int rounds = 1000000;
    for (int i = 0; i < rounds; i++) {
      int last = testArray[testArray.length - 1];
    }
    endTime = System.currentTimeMillis();
    // System.out.println(startTime);
    double diff = (endTime - startTime) / rounds ;
    return diff;
  }

  public static void printTestResult(double result, String operation) {
    System.out.println("It takes \n\t"
      + result + " ms\nto "
      + operation
    );
  }

  public static double testReverse(int[] testArray) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    int[] reversedArray = new int[testArray.length];
    int rounds = 1000000;
    for (int j=0; j < rounds; j++) {
      for (int i=0; i < testArray.length / 2; i++) {
        reversedArray[i] = testArray[testArray.length - (i + 1)];
      }
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

  public static double testShuffle(List testArrayList) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    int rounds = 1000000;
    for (int j=0; j < rounds; j++) {
      Collections.shuffle(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

  public static double testSort(List testArrayList) {
    double startTime = System.currentTimeMillis();
    double endTime = 0;
    int rounds = 1000000;
    Collections.shuffle(testArrayList);
    for (int j=0; j < rounds; j++) {
      Collections.sort(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }


}
