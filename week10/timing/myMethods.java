import java.util.*;

public class myMethods {
  public static double testMyReverse(List testArrayList, int rounds) {
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    for (int j=0; j < rounds; j++) {
      myReverse(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
  }

  public static List<Integer> myReverse(List<Integer> testArrayList) {
    Collections.shuffle(testArrayList);
    int size = testArrayList.size();
    List<Integer> reversedList = new ArrayList<Integer>(size);
    for (int j=size; j > 0; j--){
      reversedList.add(0);
    }
    for (int i=0; i < (size /2); i++) {
      reversedList.set(i, testArrayList.get(size - (i + 1)));
      reversedList.set(size - (i + 1), testArrayList.get(i));
    }
    return reversedList;
  }

  public static List<Integer> myShuffle(List<Integer> testArrayList) {
    int original_size = testArrayList.size();
    int current_size = original_size;
    List<Integer> shuffledList = new ArrayList<Integer>(original_size);
    for (int i=0; i < original_size; i++) {
      Random random = new Random();
      Object found = testArrayList.get(random.nextInt(current_size));
      int foundInteger = (int) found;
      shuffledList.add(foundInteger);
      testArrayList.remove(found);
      current_size--;
    }
    return shuffledList;
  }


}
