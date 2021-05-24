package strings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String str = strs[i];
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String sortedStr = new String(strCharArray);
            System.out.println(sortedStr + " " + str);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> values = new ArrayList<>();
                values.add (str);
                map.put (sortedStr, values);
            }
        }

        List<List<String>> results = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> eachValue = map.get(key);
            results.add(eachValue);
        }
        return results;
    }
}
