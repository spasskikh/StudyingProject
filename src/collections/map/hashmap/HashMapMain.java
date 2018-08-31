package collections.map.hashmap;

import java.util.*;

public class HashMapMain {

    public static void main(String[] args) {

        Map<String, Integer> wordMap = new HashMap<>();

        String str = "An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.";
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i].toLowerCase();
            Integer count = wordMap.get(word);

            if (wordMap.get(word) == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, ++count);
            }
        }

//        printMap(wordMap);

        NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
        printSet(wordWrappers);

    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
        wordMap.remove("a");
        wordMap.remove("to", 2);
        wordMap.replace("map", 0);

        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }
        return wordSet;
    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
        for (WordWrapper word : wordWrappers) {
            System.out.printf("%-10s%-10s\n", word.getWord(), word.getCount());
        }
    }

    private static void printMap(Map<String, Integer> wordMap) {

        Map<String, Integer> wordTreeMap = new TreeMap<>(wordMap);
        Set<String> keys = wordTreeMap.keySet();

        for (String key : keys) {
            System.out.printf("%-10s%-10s\n", key, wordTreeMap.get(key));
        }

    }


}
