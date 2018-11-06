import java.util.*;

public class myMethods {

  public static void main(String[] args) {

    ArrayList<Integer> list_random = new ArrayList<Integer>();
    int list_size = 100;
    for (int i=0; i < list_size; i++) {
        Random random = new Random();
        list_random.add(random.nextInt(list_size));
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(7);
    list.add(3);
    list.add(8);
    list.add(1);
    list.add(5);
    list.add(0);

    ArrayList<Integer> mySorted = myClevererSort(list_random);

    System.out.println(mySorted);
    System.out.println(mySorted.size());

  }

  public static ArrayList<Integer> mySort(ArrayList<Integer> list) {
    int size = list.size();
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    for (int i=0; i < size; i++) {
      System.out.println(list);
      int min = list.get(0);
      for (int j=0; j < list.size(); j++) {
        if (min > list.get(j)) {
          min = list.get(j);
        }
      }
      list.remove(Integer.valueOf(min));
      sorted.add(min);
    }
    return sorted;
  }

  public static ArrayList<Integer> myCleverSort(ArrayList<Integer> list) {
    for (int i = 1; i < list.size(); i++) {
      int comp = list.get(i);
      for (int j=(i-1); j > -1; j--) {
        if (comp > list.get(j)) {
          list.remove(i);
          list.add(j+1,comp);
          break;
        }
        if (comp <= list.get(j) && j == 0) {
          list.remove(i);
          list.add(j,comp);
          break;
        }
      }
    }
    return list;
  }

  public static ArrayList<Integer> myClevererSort(ArrayList<Integer> list) {
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    sorted.add(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      int comp = list.get(i);
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
  }



}
