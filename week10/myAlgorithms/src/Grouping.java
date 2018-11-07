import java.util.*;

public class Grouping {

  private String[] names = {"Skaiste", "Ugne", "Ausrine", "Darius", "Iveta", "Asterix", "Edvardas"};

  public Grouping() {
      this.names = names;
  }

  public static void printGroup(ArrayList<String[]> grouped ) {
    for (int i = 0; i < grouped.size(); i++) {
      System.out.println("Group No: " + (i + 1));
      for (int j = 0; j < grouped.get(i).length; j++) {
        System.out.println(grouped.get(i)[j]);
      }
    }
  }

  public static ArrayList<String[]> randomGroups(String[] names, int groupNo) {
    int size = names.length;
    int maxSize = (size / groupNo) + 1;
    int modulo = size % groupNo;
    ArrayList<String[]> groups = new ArrayList<String[]>();
    for (int j=0; j < groupNo; j++) {
      boolean bigGroup = (modulo > j) ? true : false;
      int groupSize = bigGroup ? maxSize : maxSize - 1;
      String[] group = new String[groupSize];
      System.out.println("size: " + group.length);
      groups.add(group);
    }
    for (int i=0; i < size; i++) {
      String[] currentGroup = groups.get(i % groupNo);
      currentGroup[i / groupNo] = names[i];
      groups.set(i % groupNo,currentGroup);
    }
    return groups;
  }
}
