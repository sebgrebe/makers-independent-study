import java.util.*;
import java.util.function.*;

public class Timing {

  public static void main(String[] args) {
      
    // pass in the array size that you want to test on the command line
    int size = Integer.parseInt(args[0]);

    //setting up test arrays
    CreateLists createList = new CreateLists();
    ArrayList<Integer> arrayList = createList(size);
    ArrayList<String> stringList = createList.createStringList(size);
    ArrayList<Integer> intList = new ArrayList<Integer>();
    intList.add(8);
    intList.add(3);
    intList.add(5);
    intList.add(1);
    intList.add(1);
    intList.add(7);
    intList.add(0);
    intList.add(4);

    int rounds = 100;
    double diff;

    // Uncomment the individual timing test if you want to run it

    // diff = testInts(arrayList, 1000000, getLast);
    // printTestResult(diff, "get last element of an array", size);

    // diff = testInts(arrayList, rounds, reverse);
    // printTestResult(diff, "reverse array", size);

    // diff = testInts(arrayList, rounds, myReverse);
    // printTestResult(diff, "reverse array with my method", size);

    // diff = testInts(arrayList, rounds, shuffle);
    // printTestResult(diff, "shuffle array", size);

    // diff = testInts(arrayList, rounds, myShuffle);
    // printTestResult(diff, "shuffle array with my method", size);

    // diff = testInts(arrayList, rounds, sort);
    // printTestResult(diff, "sort array", size);

    // diff = testInts(arrayList, rounds, mySort);
    // printTestResult(diff, "sort array with my method", size);

    // diff = testInts(arrayList, rounds, myCleverSort);
    // printTestResult(diff, "sort array with my clever method", size);

    // diff = testInts(arrayList, rounds, myClevererSort);
    // printTestResult(diff, "sort array with my clever method", size);

    // diff = testInts(stringList, rounds, myDuplicate);
    // printTestResult(diff, "find duplicates with my method", size);

    // diff = testStrings(stringList, rounds, myDuplicateWithHash);
    // printTestResult(diff, "find duplicates with my hash method", size);

    // diff = testStrings(stringList, rounds, myFrequency);
    // printTestResult(diff, "find most common words with my array method", size);

    // diff = testStrings(stringList, rounds, myFrequencyWithHash);
    // printTestResult(diff, "find most common words with my array method", size);

    // diff = testStrings(arrayList, rounds, myQuickSort);
    // printTestResult(diff, "sort array with my quick sort", size);

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

  public static double testInts(ArrayList testArrayList, int rounds, Function<ArrayList<Integer>, ArrayList<Integer>> method) {
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

    //Java standard functions
    public static Function<ArrayList<Integer>, ArrayList<Integer>> getLast = testArrayList -> {
        return testArrayList.get(testArrayList.size() - 1);
    };

    public static Function<ArrayList<Integer>, ArrayList<Integer>> reverse = testArrayList -> {
        Collections.reverse(testArrayList);
        return testArrayList;
    };

    public static Function<ArrayList<Integer>, ArrayList<Integer>> shuffle = testArrayList -> {
        Collections.shuffle(testArrayList);
        return testArrayList;
    };

    public static Function <ArrayList<Integer>, ArrayList<Integer>> sort = testArrayList -> {
        Collections.sort(testArrayList);
        return testArrayList;
    };

  public static Function <ArrayList<Integer>, ArrayList<Integer>> myReverse = testArrayList -> {
      int arraySize = testArrayList.size();
      for (int i=0; i < (arraySize /2); i++) {
          int first = testArrayList.get(i);
          int last = testArrayList.get(arraySize - (i + 1));
          testArrayList.set(i, last);
          testArrayList.set(arraySize - (i + 1), arraySize);
      }
      return testArrayList;
  };

    public static Function <ArrayList<Integer>, ArrayList<Integer>> myQuickSort = (testArrayList) -> {
        if (testArrayList.size() <= 1) {
            return testArrayList;
        }
        int pivot = testArrayList.get(0);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (int i=1; i<testArrayList.size(); i++) {
            if (testArrayList.get(i) <= pivot) {
                left.add(testArrayList.get(i));
            } else {
                right.add(testArrayList.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>(Timing.myQuickSort.apply(left));
        result.add(pivot);
        result.addAll(Timing.myQuickSort.apply(right));
        return result;
    };

    public static Function <ArrayList<Integer>, ArrayList<Integer>> myShuffle = testArrayList -> {
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

    //Three different implementations for Selection sort
    public static Function <ArrayList<Integer>, ArrayList<Integer>> mySort = testArrayList -> {
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

    public static Function <ArrayList<Integer>, ArrayList<Integer>> myCleverSort = testArrayList -> {
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

    public static Function <ArrayList<Integer>, ArrayList<Integer>> myClevererSort = testArrayList -> {
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

    //comparing methods for finding duplicates and most frequents using array vs hash

    public static Function <ArrayList<String>, ArrayList<String>> myDuplicateWithHash = testArrayList -> {
        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
        ArrayList<String> duplicates = new ArrayList<String>();
        for (int i = 0; i < testArrayList.size(); i++) {
            String word = testArrayList.get(i);
            if (words.containsKey(word)) {
                if (words.get(word) == 1) {
                    duplicates.add(word);
                    words.put(word, 2);
                }
            } else {
                words.put(word, 1);
            }
        }
        return duplicates;
    };

    public static Function <ArrayList<String>, <ArrayList<String>> myFrequency = testArrayList -> {
        ArrayList<ArrayList<String>> groupedList = new ArrayList<ArrayList<String>>();
        for (int i=0; i<testArrayList.size(); i++) {
            String word = testArrayList.get(i);
            Boolean found = false;
            for (int j=0; j<groupedList.size(); j++) {
                if (word == groupedList.get(j).get(0)) {
                    ArrayList<String> incrementedGroup = groupedList.get(j);
                    incrementedGroup.add(word);
                    found = true;
                    break;
                }
            }
            if (!found) {
                ArrayList<String> newGroup = new ArrayList<String>();
                newGroup.add(word);
                groupedList.add(newGroup);
            }
        }
        ArrayList<ArrayList> sortedList = new ArrayList<ArrayList>();
        int listSize = groupedList.size();
        for (int k=0; k<listSize; k++) {
            ArrayList<String> maxGroup = groupedList.get(0);
            for (int l=0; l<groupedList.size(); l++) {
                if (maxGroup.size() < groupedList.get(l).size()){
                    maxGroup = groupedList.get(l);
                }
            }
            sortedList.add(maxGroup);
            groupedList.remove(maxGroup);
        }
        ArrayList<String> mostFrequent = new ArrayList<String>();
        for (int m=0; m<sortedList.size() && m < 10; m++) {
            String frequentWord = (String) sortedList.get(m).get(0);
            mostFrequent.add(frequentWord);
        }
        return mostFrequent;
    };

    public static Function <ArrayList<String>, <ArrayList<String>> myFrequencyWithHash = testArrayList -> {
        ArrayList<String> mostFrequent = new ArrayList<String>();
        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
        for (int i = 0; i < testArrayList.size(); i++) {
            String word = testArrayList.get(i);
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
        Collection frequencies = words.values();
        Iterator itr = frequencies.iterator();
        ArrayList<Integer> orderedValues = new ArrayList<Integer>();
        while (itr.hasNext()) {
            int j = (int) itr.next();
            orderedValues.add(j);
        }
        Collections.sort(orderedValues);
        for (int k = orderedValues.size() - 1; k >= 0; k--) {
            int maxValue = orderedValues.get(k);
            if (k + 1 < orderedValues.size()) {
                if (maxValue == orderedValues.get(k + 1)) {
                    continue;
                }
            }
            Enumeration<String> keys = words.keys();
            while (keys.hasMoreElements()) {
                String word = keys.nextElement();
                if (words.get(word) == maxValue) {
                    mostFrequent.add(word);
                }
            }
            if (mostFrequent.size() == 10) {
                break;
            }
        }
        return mostFrequent;
    };



}
