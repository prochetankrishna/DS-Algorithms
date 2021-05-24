package strings;

public class StringPermutations {

    public static void main(String[] args) {
        String str = "ABA";
        permuteString(str, 0, str.length() - 1);
    }

    public static String swapCharactersInStringAtPosition (String str, int positionOne, int positionTwo) {

        char[] charRepresentationOfStr = str.toCharArray();
        char temp = charRepresentationOfStr[positionOne];
        charRepresentationOfStr[positionOne] = charRepresentationOfStr[positionTwo];
        charRepresentationOfStr[positionTwo] = temp;
        return String.valueOf(charRepresentationOfStr);
    }

    public static void permuteString (String str, int low, int high) {

        if (low == high) {
            System.out.println(str);
        } else {
            for (int i = low; i <= high; i++) {
                str = swapCharactersInStringAtPosition(str, low, i);
                permuteString(str, low + 1, high);
                str = swapCharactersInStringAtPosition(str, low, i);
            }
        }
    }
}
