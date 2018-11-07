import java.util.*;
import java.util.function.*;

public class Timing {

  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    ArrayList<Integer> arrayList = createList(size);
    ArrayList<String> stringList = createStringList(size);
    int rounds = 100;
    double diff;

    //Functions
    Function<ArrayList<Integer>, Object> getLast = testArrayList -> {
      return testArrayList.get(testArrayList.size() - 1);
    };

    Function<ArrayList<Integer>, Object> reverse = testArrayList -> {
      Collections.reverse(testArrayList);
      return testArrayList;
    };

    Function<ArrayList<Integer>, Object> shuffle = testArrayList -> {
      Collections.shuffle(testArrayList);
      return testArrayList;
    };

    Function <ArrayList<Integer>, Object> sort = testArrayList -> {
      Collections.sort(testArrayList);
      return testArrayList;
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

    Function <ArrayList<Integer>, Object> mySort = testArrayList -> {
      int list_size = testArrayList.size();
      ArrayList<Integer> sorted = new ArrayList<Integer>();
      for (int i=0; i < list_size; i++) {
        int min = testArrayList.get(0);
        for (int j=0; j < testArrayList.size(); j++) {
          if (min > testArrayList.get(j)) {
            min = testArrayList.get(j);
          }
        }
        testArrayList.remove(Integer.valueOf(min));
        sorted.add(min);
      }
      return sorted;
    };

    Function <ArrayList<Integer>, Object> myCleverSort = testArrayList -> {
      for (int i = 1; i < testArrayList.size(); i++) {
        int comp = testArrayList.get(i);
        for (int j=(i-1); j > -1; j--) {
          if (comp > testArrayList.get(j)) {
            testArrayList.remove(i);
            testArrayList.add(j+1,comp);
            break;
          }
          if (comp <= testArrayList.get(j) && j == 0) {
            testArrayList.remove(i);
            testArrayList.add(j,comp);
            break;
          }
        }
      }
      return testArrayList;
    };

    Function <ArrayList<Integer>, Object> myClevererSort = testArrayList -> {
      ArrayList<Integer> sorted = new ArrayList<Integer>();
      sorted.add(testArrayList.get(0));
      for (int i = 1; i < testArrayList.size(); i++) {
        int comp = testArrayList.get(i);
        for (int j=sorted.size(); j > 0; j--) {
          if (comp > sorted.get(j-1)) {
            sorted.add(j,comp);
            break;
          }
          if (comp <= sorted.get(j-1) && j == 1) {
            sorted.add(j-1,comp);
            break;
          }
        }
      }
      return sorted;
    };

    Function <ArrayList<String>, Object> myDuplicate = testArrayList -> {
      ArrayList<String> newWords = new ArrayList<String>();
      ArrayList<String> duplicates = new ArrayList<String>();
      for (int i=0; i < testArrayList.size(); i++) {
          String nextWord = testArrayList.get(i);
          int sizeFoundWords = newWords.size();
          Boolean found = false;
          if (newWords.contains(nextWord) && !duplicates.contains(nextWord)) {
              duplicates.add(nextWord);
          }
          else if (!newWords.contains(nextWord)) {
              newWords.add(nextWord);
          }
      }
      return duplicates;
    };

    //get time for getting last element of array

    // diff = test(arrayList, 1000000, getLast);
    // printTestResult(diff, "get last element of an array", size);
    //
    // // get time for reversing array
    // diff = test(arrayList, rounds, reverse);
    // printTestResult(diff, "reverse array", size);
    //
    // //get time for my reversing method
    // diff = test(arrayList, rounds, myReverse);
    // printTestResult(diff, "reverse array with my method", size);
    // //
    // // get time for shuffling
    // diff = test(arrayList, rounds, shuffle);
    // printTestResult(diff, "shuffle array", size);
    //
    // // get time for my shuffling
    // diff = test(arrayList, rounds, myShuffle);
    // printTestResult(diff, "shuffle array with my method", size);
    //
    // // get time for sorting
    // diff = test(arrayList, rounds, sort);
    // printTestResult(diff, "sort array", size);

    // get time for my sorting
    // diff = test(arrayList, rounds, mySort);
    // printTestResult(diff, "sort array with my method", size);

    // get time for my clever sorting
    // diff = test(arrayList, rounds, myCleverSort);
    // printTestResult(diff, "sort array with my clever method", size);

    // get time for my cleverer sorting
    // diff = test(arrayList, rounds, myClevererSort);
    // printTestResult(diff, "sort array with my clever method", size);

    // get time for myDuplicate
    diff = testStrings(stringList, rounds, myDuplicate);
    printTestResult(diff, "find duplicates with my method", size);

  }

  public static void printTestResult(double result, String operation, int size) {
    System.out.println("It takes \n\t"
      + (result / 1_000_000) + " ms\nto "
      + operation
      + ", where array size is: " + size
    );
  }

  public static ArrayList<Integer> createList(int size) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    for (int i = 1; i < (size + 1); i++) {
      arrayList.add(i);
    }
    return arrayList;
  }

  public static ArrayList<String> createStringList(int size) {
    ArrayList<String> stringList = new ArrayList<String>();
    for (int i=0; i < size/10; i++) {
      ArrayList<String> pool = new ArrayList<String>(10);
      pool.add("This");
      pool.add("is");
      pool.add("pool");
      pool.add("ambience");
      pool.add("words");
      pool.add("words");
      pool.add("twice");
      pool.add("Superkalafristik");
      pool.add("words");
      pool.add("is");
      for (int j =0; j < 10; j++) {
        Random random = new Random();
        String word = pool.get(random.nextInt(pool.size()));
        stringList.add(word);
        pool.remove(word);
      }
    }
    return stringList;
  }

  public static double test(ArrayList testArrayList, int rounds, Function<ArrayList<Object>, Object> method) {
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

  public static double testStrings(ArrayList testArrayList, int rounds, Function<ArrayList<String>, Object> method) {
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
