package stack;

import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {

        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostFix(infixExpression));
    }

    public static String infixToPostFix (String expression) {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            Character ch = expression.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push (ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {

                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append (stack.pop());
                }
                stack.push (ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Invalid Expression");
                return null;
            }
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static int precedence (Character operator) {

        switch (operator) {
            case '^' :
                return 3;
            case '*' :
            case '/' :
                return 2;
            case '+' :
            case '-' :
                return 1;
            default :
                return 0;
        }
    }


}
