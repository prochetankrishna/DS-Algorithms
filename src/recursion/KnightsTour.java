package recursion;

public class KnightsTour {

    public static void main(String[] args) {
        solveKT(8);
    }

    public static void solveKT (int N) {

        int[][] sol = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        sol[0][0] = 0;

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        if (!isSolveKTUtil (0, 0, 1, sol, xMove, yMove, N)) {
            System.out.println("No Solution Exists");
        } else {
            System.out.println("Solution Exists");
            printSolution(sol, N);
        }
    }

    public static boolean isSolveKTUtil (int currentX, int currentY, int moveNumber,
                                         int[][] sol, int[] xMove, int[] yMove, int N) {

        if (moveNumber == N * N) {
            return true;
        }
        int k, nextX, nextY;
        for (k = 0; k < N; k++) {
            nextX = currentX + xMove[k];
            nextY = currentY + yMove[k];

            if (isSafeMove (nextX, nextY, sol, N)) {
                sol[nextX][nextY] = moveNumber;
                if (isSolveKTUtil(nextX, nextY, moveNumber + 1, sol, xMove, yMove, N)) {
                    return true;
                } else {
                    sol[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    public static boolean isSafeMove (int positionOfX, int positionOfY, int[][] sol, int N) {

        return (positionOfX >= 0 && positionOfX < N && positionOfY >= 0 && positionOfY < N
                && sol[positionOfX][positionOfY] == -1);
    }

    public static void printSolution (int[][] sol, int N) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
