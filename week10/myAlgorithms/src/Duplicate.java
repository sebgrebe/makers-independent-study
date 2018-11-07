import java.util.*;

public class Duplicate {
  public static void main(String[] args) {
    String[] names = {"Skaiste", "Ugne", "Ausrine", "Darius", "Iveta", "Asterix", "Edvardas"};
    int groupNo = 3;
    ArrayList<String[]> result = randomGroups(names, groupNo);
    for (int i = 0; i < result.size(); i++) {
        System.out.println("Group No: " + (i + 1));
        for (int j = 0; j < result.get(i).length; j++) {
          System.out.println(result.get(i)[j]);
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
