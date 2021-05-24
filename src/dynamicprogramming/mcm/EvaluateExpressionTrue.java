package dynamicprogramming.mcm;

import java.util.HashMap;

public class EvaluateExpressionTrue {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();

        char expression[] = new char[symbols.length + operators.length];

        int i = 0;
        int j = 0;
        int k = 0;
        boolean isSymbol = true;
        while (true) {
            if (isSymbol) {
                expression[k++] = symbols[i++];
                isSymbol = false;
            } else {
                expression[k++] = operators[j++];
                isSymbol = true;
            }
            if (j > operators.length - 1) {
                break;
            }
            if (i > symbols.length - 1) {
                break;
            }
        }
        expression[k] = symbols[i];

        System.out.println(waysToEvaluateExpressionToTrue(expression, 0, expression.length - 1, true));
    }

    public static int waysToEvaluateExpressionToTrue (char[] expression, int i, int j, boolean isTrue) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue) {
                if (expression[i] == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (expression[i] == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        String tempKey = i + " " + j + " " + isTrue;
        if (map.containsKey(tempKey)) {
            return map.get(tempKey);
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k++) {

            int leftTrue = waysToEvaluateExpressionToTrue(expression, i, k - 1, true);
            int leftFalse = waysToEvaluateExpressionToTrue(expression, i, k - 1, false);

            int rightTrue = waysToEvaluateExpressionToTrue(expression, k + 1, j, true);
            int rightFalse = waysToEvaluateExpressionToTrue(expression, k + 1, j, false);

            if (expression[k] == '&') {
                if (isTrue) {
                    ans += leftTrue * rightTrue;
                } else {
                    ans += leftTrue * rightFalse + leftFalse * rightFalse + leftFalse * rightTrue;
                }
            } else if (expression[k] == '|') {
                if (isTrue) {
                    ans += leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                } else {
                    ans += leftFalse * rightFalse;
                }
            } else if (expression[k] == '^') {
                if (isTrue) {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }

        map.put(tempKey, ans);
        return ans;
    }
}
