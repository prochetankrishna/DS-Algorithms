package recursion;

import java.util.*;

public class NQueens {

    public static int N = 2;
    public static List<List<Integer>> result
            ;
    public static void main(String[] args) {

        solveNQueens();
    }

    public static void solveNQueens () {

        int[][] board = new int[N][N];
        for (int  i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        if (isSolveNQueens (board, 0)) {
            System.out.println("Solution Exists");
            printSolution (board);
        } else {
            System.out.println("No Solution Exits");
        }

        printAllSolutionOfNQueen();
        for (List<Integer> eachSolution : result) {
            System.out.println(eachSolution);
        }
    }

    private static boolean isSolveNQueens(int[][] board, int col) {

        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (isSolveNQueens(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }


    private static void printSolution(int[][] board) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe (int[][] board, int row, int col) {

        int i, j;

        for (i = col; i >= 0; i--) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (i = row, j = col; j >= 0 && i < N; j--, i++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }


    public static void printAllSolutionOfNQueen () {

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        result = new ArrayList<>();
        isPrintAllSolutionNQueenUtil (board, 0);
    }

    private static boolean isPrintAllSolutionNQueenUtil(int[][] board, int col) {

        if (col == N) {
            List<Integer> solution = new ArrayList<>();

            for (int i = 0 ; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        solution.add (j + 1);
                    }
                }
            }
            result.add(solution);
            return true;
        }

        boolean result = false;
        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1;
                result = isPrintAllSolutionNQueenUtil(board, col + 1) || result;
                board[i][col] = 0;
            }
        }
        return result;
    }
}
