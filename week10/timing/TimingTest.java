import java.util.*;
import org.junit.Test;
import org.junit.Before;

public class TimingTest {

  public static void main(String[] args) {
    List<Integer> testList = new ArrayList<Integer>(10);
    for (int i = 0; i < 10; i++) {
      testList.add(i);
    }

    List<Integer> testLongList = new ArrayList<Integer>(10000);
    for (int i = 0; i < 10000; i++) {
      testLongList.add(i);
    }
    myReverse(testList);
    myReverseBig(testLongList);
    myShuffle(testList);

  }

  @Test
  public static void myReverse(List testList) {
    Timing timing = new Timing();
    List<Integer> reversedList = timing.myReverse(testList);
    System.out.print("myReverse, test 1: ");
    System.out.println(testList.get(0) == reversedList.get(9));
    System.out.print("myReverse, test 2: ");
    System.out.println(testList.get(2) == reversedList.get(7));
  }

  @Test
  public static void myReverseBig(List testLongList) {
    Timing timing = new Timing();
    List<Integer> reversedList = timing.myReverse(testLongList);
    System.out.print("myBigReverse, test 1: ");
    System.out.println(testLongList.get(0) == reversedList.get(9999));
    System.out.print("myBigReverse, test 2: ");
    System.out.println(testLongList.get(2378) == reversedList.get(7621));
  }

  @Test
  public static void myShuffle(List testList) {
    Timing timing = new Timing();
    System.out.println(timing.myShuffle(testList));
  }

}
