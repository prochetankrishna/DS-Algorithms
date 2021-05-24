package recursion;

import java.util.Arrays;

public class RatMaze {

    static final int N = 4;
    public static void main(String[] args) {

        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 1, 0 },
                         { 1, 1, 1, 1 } };

        solveRatMaze(maze);
    }

    public static void printSolution (int[][] solution) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe (int[][] maze, int nextX, int nextY) {

        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && maze[nextX][nextY] != 0) {
            return true;
        }
        return false;
    }

    public static boolean isSolveRatMazeUtil (int[][] maze, int currentX, int currentY, int[][] sol) {

        if (currentX == N - 1 && currentY == N - 1 && maze[currentX][currentY] == 1) {
            sol[currentX][currentY] = 1;
            return true;
        }

        if (isSafe (maze, currentX, currentY)) {

            //Already Visited
            if (sol[currentX][currentY] == 1) {
                return false;
            }

            sol[currentX][currentY] = 1;

            if (isSolveRatMazeUtil(maze, currentX + 1, currentY, sol)) {
                return true;
            }

            if (isSolveRatMazeUtil(maze, currentX, currentY + 1, sol)) {
                return true;
            }

//            if (isSolveRatMazeUtil(maze, currentX - 1, currentY, sol)) {
//                return true;
//            }
//
//            if (isSolveRatMazeUtil(maze, currentX, currentY - 1, sol)) {
//                return true;
//            }

            sol[currentX][currentY] = 0;
            return false;
        } else {
            return false;
        }
    }

    public static void solveRatMaze (int[][] maze) {

        int[][] sol = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }

        if (isSolveRatMazeUtil (maze, 0, 0, sol)) {
            System.out.println("Solution Exists");
            printSolution (sol);
        } else {
            System.out.println("Solution Doesn't Exists");
        }
    }
}
