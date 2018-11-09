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

    public static ArrayList<String> frequencyWithHash(ArrayList<String> testArrayList) {
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
        for (int k=orderedValues.size()-1; k >= 0; k--) {
            int maxValue = orderedValues.get(k);
            if (k+1 < orderedValues.size()) {
                if (maxValue == orderedValues.get(k+1)) { continue;}
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
    }

//    public static ArrayList<String> frequencyWithCleverHash(ArrayList<String> testArrayList) {
//        ArrayList<String> mostFrequent = new ArrayList<String>();
//        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
//        Hashtable<Integer, ArrayList<String>> frequenciesHash = new Hashtable<Integer, ArrayList<String>>();
//        ArrayList<Integer> frequencyList = new ArrayList<Integer>();
//        for (int i=0; i < testArrayList.size(); i++) {
//            String word = testArrayList.get(i);
//            if (words.containsKey(word)) {
//                int wordFrequency = words.get(word);
//                words.put(word, wordFrequency + 1);
//                ArrayList<String> wordsWithFrequency = frequenciesHash.get(wordFrequency + 1);
//                wordsWithFrequency.add(word);
//                frequenciesHash.put(wordFrequency + 1, wordsWithFrequency);
//                frequencyList.add(wordFrequency + 1);
//            } else {
//                words.put(word, 1);
//                ArrayList<String> wordsWithFrequency1 = frequenciesHash.get(1);
//                if ()
//                wordsWithFrequency1.add(word);
//                frequenciesHash.put(1, wordsWithFrequency1);
//                frequencyList.add(1);
//            }
//        }
//        Collections.sort(frequencyList);
//        for (int j = frequencyList.size() - 1; j >= 0; j--) {
//            int maxFrequency = frequencyList.get(j);
//            if (j != frequencyList.size() - 1) {
//                if (maxFrequency == frequencyList.get(j + 1)) {
//                    continue;
//                }
//            }
//            for (int k=0; k < frequenciesHash.get(maxFrequency).size(); k++) {
//                mostFrequent.add(frequenciesHash.get(maxFrequency).get(k));
//            }
//            if (mostFrequent.size() >= 10) {
//                break;
//            }
//        }
//        return mostFrequent;
//    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int pivot = arr.get(0);
        arr.remove(0);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i) <= pivot) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(quickSort(left));
        result.add(pivot);
        result.addAll(quickSort(right));
        return result;
    }
}