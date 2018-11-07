import java.util.*;

public class MyMethods {

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

    public static ArrayList<String> duplicate(ArrayList<String> list) {
        ArrayList<String> newWords = new ArrayList<String>();
        ArrayList<String> duplicates = new ArrayList<String>();
        for (int i=0; i < list.size(); i++) {
            String nextWord = list.get(i);
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
    }

    public static ArrayList<String> duplicateWithHash(ArrayList<String> list) {
        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
        ArrayList<String> duplicates = new ArrayList<String>();
        for (int i=0; i < list.size(); i++) {
            String word = list.get(i);
            if (words.containsKey(word)) {
                if (words.get(word) == 1) {
                    duplicates.add(word);
                    words.put(word, 2);
                }
            }
            else {
                words.put(word, 1);
            }
        }
        return duplicates;
    }

    public static ArrayList<String> frequency(ArrayList<String> list) {
        ArrayList<ArrayList<String>> groupedList = new ArrayList<ArrayList<String>>();
        for (int i=0; i<list.size(); i++) {
            String word = list.get(i);
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
    }



}
