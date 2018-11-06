import java.util.*;
import java.util.function.*;

public class Timing {

  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    ArrayList<Integer> arrayList = createList(size);
    int rounds = 100;

    Function<ArrayList<Integer>, Void> getLast = testArrayList -> {
      testArrayList.get(testArrayList.size() - 1);
      return null;
    };

    Function<ArrayList<Integer>, Void> reverse = testArrayList -> {
      Collections.reverse(testArrayList);
      return null;
    };

    Function<ArrayList<Integer>, Void> shuffle = testArrayList -> {
      Collections.shuffle(testArrayList);
      return null;
    };

    Function <ArrayList<Integer>, Void> sort = testArrayList -> {
      Collections.sort(testArrayList);
      return null;
    };

    Function <ArrayList<Integer>, Object> myReverse = testArrayList -> {
      int arraySize = testArrayList.size();
      for (int i=0; i < (arraySize /2); i++) {
        int first = testArrayList.get(i);
        int last = testArrayList.get(arraySize - (i + 1));
        testArrayList.set(i, last);
        testArrayList.set(arraySize - (i + 1), arraySize);
      }
      return testArrayList;
    };

    Function <ArrayList<Integer>, Object> myShuffle = testArrayList -> {
      int original_size = testArrayList.size();
      int current_size = original_size;
      ArrayList<Integer> shuffledList = new ArrayList<Integer>(original_size);
      for (int i=0; i < original_size; i++) {
        Random random = new Random();
        Object found = testArrayList.get(random.nextInt(current_size));
        int foundInteger = (int) found;
        shuffledList.add(foundInteger);
        testArrayList.remove(found);
        current_size--;
      }
      return shuffledList;
    };


    //get time for getting last element of array
    double diff;
    // diff = test(arrayList, 1000000, getLast);
    // printTestResult(diff, "get last element of an array", size);
    //
    // // get time for reversing array
    // diff = test(arrayList, rounds, reverse);
    // printTestResult(diff, "reverse array", size);
    //
    //get time for my reversing method
    // diff = test(arrayList, rounds, myReverse);
    // printTestResult(diff, "reverse array with my method", size);
    //
    // // get time for shuffling
    // diff = test(arrayList, rounds, shuffle);
    // printTestResult(diff, "shuffle array", size);

    // get time for my shuffling
    diff = test(arrayList, rounds, myShuffle);
    printTestResult(diff, "shuffle array with my method", size);

    // get time for sorting
    // diff = test(arrayList, rounds, sort);
    // printTestResult(diff, "sort array", size);
  }

  public static void printTestResult(double result, String operation, int size) {
    System.out.println("It takes \n\t"
      + (result / 1_000_000) + " ms\nto "
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

  public static double test(ArrayList testArrayList, int rounds, Function<ArrayList<Integer>, Object> method) {
    double endTime = 0;
    double startTime = System.nanoTime();
    for (int i = 0; i < rounds; i++) {
      Object last = method.apply(testArrayList);
    }
    endTime = System.nanoTime();
    System.out.println("start time " + startTime);
    System.out.println("end time " + endTime);
    double diff = (endTime - startTime) / rounds ;
    return diff;
  }

}
