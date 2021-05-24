package strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder resultBuilder = new StringBuilder();

        boolean isMatch = true;
        int k = 0;

        while (k < strs[0].length()) {

            char ch = strs[0].charAt(k);

            for (int i = 1; i < strs.length; i++) {

                if (strs[i].length() > k) {
                    if (strs[i].charAt(k) == ch) {
                        continue;
                    } else {
                        isMatch = false;
                        break;
                    }
                } else {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                resultBuilder.append(ch);
                k++;
            } else {
                break;
            }
        }
        return resultBuilder.toString();
    }
}
