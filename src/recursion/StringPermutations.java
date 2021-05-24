package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringPermutations {

    public static void main(String[] args) {

        String str = "AA";
        stringPermutations(str, 0, str.length() - 1);

        List<List<Character>> result = findPermutationsQueue(str.toCharArray());
        System.out.println(result);
    }

    public static List<List<Character>> findPermutationsQueue (char[] expression) {

        List<List<Character>> result = new ArrayList<>();

        Queue<List<Character>> permutationsQueue = new LinkedList<>();
        permutationsQueue.add(new ArrayList<>());

        for (char currentCharacter : expression) {

            int numberOfAvailablePermutations = permutationsQueue.size();
            for (int i = 0; i < numberOfAvailablePermutations; i++) {
                List<Character> oldPermutations = permutationsQueue.poll();

                for (int j = 0; j <= oldPermutations.size(); j++) {
                    List<Character> newPermutations = new ArrayList<>(oldPermutations);
                    newPermutations.add(j, currentCharacter);

                    if (newPermutations.size() == expression.length) {
                        result.add(newPermutations);
                    } else {
                        permutationsQueue.offer(newPermutations);
                    }
                }
            }
        }
        return result;
    }

    public static void stringPermutations (String str, int low, int high) {

        if (low == high) {
            //System.out.println("FIRST --> LOW [" + low + "] : HIGH : [" + high + "] STR :["  + str + "]");
            System.out.println(str);
        }

        for (int i = low; i <= high; i++) {

            str = swapCharacters(str, low, i);
            //System.out.println("SECOND --> LOW [" + low + "] : HIGH : [" + high + "] STR :["  + str + "]");
            stringPermutations(str, low + 1, high);
            str = swapCharacters(str, low, i);
            //System.out.println("THIRD --> LOW [" + low + "] : HIGH : [" + high + "] STR :["  + str + "]");
        }
    }

    public static String swapCharacters (String str, int i, int j) {

        char[] temp = str.toCharArray();
        char ch = temp[i];
        temp[i] = temp[j];
        temp[j] = ch;
        return String.valueOf(temp);
    }
}
