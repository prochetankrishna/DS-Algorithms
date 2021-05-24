package strings;

public class URLify {

    public static void main(String[] args) {

        String str = "Mr John Smith    ";
        System.out.println(replaceSpaces(str, 13));
    }

    public static String replaceSpaces (String str, int trueLength) {

        char[] stringCharArr = str.toCharArray();
        int spaceCount = 0, i = 0;

        for (i = 0; i < trueLength; i++) {
            if (stringCharArr[i] == ' ') {
                spaceCount++;
            }
        }
        System.out.println("Number of Spaces : " + spaceCount);

        int newLength = trueLength + spaceCount * 2;
        if (newLength > str.length()) {
            return str;
        }

        int index = newLength - 1;

        return null;
    }
}
