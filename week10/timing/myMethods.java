import java.util.*;

public class myMethods {
  public static double testMyReverse(List testArrayList, int rounds) {
    Collections.shuffle(testArrayList);
    double endTime = 0;
    double startTime = System.currentTimeMillis();
    for (int j=0; j < rounds; j++) {
      myReverse(testArrayList);
    }
    endTime = System.currentTimeMillis();
    double diff = (endTime - startTime) / rounds;
    return diff;
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

  public static double testMyShuffle(List testArrayList, int rounds) {
    System.out.println("rounds: " + rounds);
    double endTime = 0;
    Collections.shuffle(testArrayList);
    double startTime = System.currentTimeMillis();
    for (int j=0; j < rounds; j++) {
      myShuffle(testArrayList);
    }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
    double diff = (endTime - startTime) / rounds;
    return diff;
  }


}
