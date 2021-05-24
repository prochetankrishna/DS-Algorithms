package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllAnagramsFromSequence {

    public static void main(String[] args) {
        String arr[] = { "cat", "dog", "tac", "god", "act" };
        printAllAnagramsTogether(arr);
    }

    public static void printAllAnagramsTogether (String arr[]) {

        HashMap <String, List<String>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            String word = arr[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String sortedWord = new String(letters);

            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord, list);
            }
        }

        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1) {
                System.out.println(values);
            }
        }
    }

}
