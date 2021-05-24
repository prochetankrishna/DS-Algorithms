package recursion;

public class CountWaysRatMaze {

    public static void main(String[] args) {

        int[][] maze = {{0, 0, 0, 0},
                        {0, -1, 0, 0},
                        {-1, 0, 0, 0},
                        {0, 0, 0, 0}};

        System.out.println(numberOfWays(maze));
//        printSolution(maze);
    }

    public static int numberOfWays (int[][] maze) {

        int numRow = maze.length;
        int numCol = maze[0].length;

        if (maze[0][0] == -1) {
            return 0;
        }

        for (int i = 0; i < numRow; i++) {
            if (maze[i][0] == 0) {
                maze[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < numCol; i++) {
            if (maze[0][i] == 0) {
                maze[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < numRow; i++) {
            for (int j = 1; j < numCol; j++) {

                if (maze[i][j] == -1){
                    continue;
                }

                if (maze[i - 1][j] > 0) {
                    maze[i][j] += maze[i - 1][j];
                }

                if (maze[i][j - 1] > 0) {
                    maze[i][j] += maze[i][j - 1];
                }
            }
        }

        return maze[numRow - 1][numCol - 1] > 0 ? maze[numRow - 1][numCol - 1] : 0;
    }

    public static void printSolution (int[][] solution) {

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
