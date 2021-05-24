package stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        String inputTest = "]";
        System.out.println(isValid(inputTest));
    }

    public static boolean isValid (String s) {

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            Character character = s.charAt(i);

            if (character.equals('(') || character.equals('{') || character.equals('[')) {
                characterStack.push(character);
            } else if (character.equals(')') || character.equals('}') || character.equals(']')) {

                if (characterStack.isEmpty()) {
                    return false;
                } else {
                    if (character.equals(')') && characterStack.peek().equals('(')) {
                        characterStack.pop();
                    } else if (character.equals('}') && characterStack.peek().equals('{')) {
                        characterStack.pop();
                    } else if (character.equals(']') && characterStack.peek().equals('[')) {
                        characterStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (characterStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
