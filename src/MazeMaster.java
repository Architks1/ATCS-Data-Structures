//name:    date:

import java.util.*;
import java.io.*;

public class MazeMaster {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maze's filename: ");
        char[][] retArr = buildCharArr(sc.next());
        Maze m = new Maze(retArr);
        m.display();
        System.out.println("Options: ");
        System.out.println("1: Mark all paths.");
        System.out.println("2: Mark all paths, and display the count of all STEPs.");
        System.out.println("3: Mark only the correct path.");
        System.out.println("4: Mark only the correct path. If no path exists, display 'No path exists'.");
        System.out.println("5: Mark only the correct path, and display the count of STEPs.");
        System.out.print("Please make a selection: ");
        m.solve(sc.nextInt());
        m.display();
    }

    //take in a filename (without .txt), and return a char[][]
    public static char[][] buildCharArr(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        char[][] arr = new char[sc.nextInt()][sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }
        return arr;
    }
}


class Maze {
    //Constants
    private final char WALL = 'W';
    private final char DOT = '.';
    private final char START = 'S';
    private final char EXIT = 'E';
    private final char STEP = '*';
    //fields
    private char[][] maze;
    private int startRow, startCol;
    private boolean S_Exists = false, E_Exists = false;

    //constructor initializes all the fields
    public Maze(char[][] inCharArr) {
        maze = inCharArr;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    S_Exists = true;
                }
                if (maze[i][j] == 'E') {
                    E_Exists = true;
                }
            }
        }
    }


    public void display() {
        if (maze == null)
            return;
        for (int a = 0; a < maze.length; a++) {
            for (int b = 0; b < maze[0].length; b++) {
                System.out.print(maze[a][b]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solve(int n) {
        if (n == 1) {
            markAllPaths(startRow, startCol);
        } else if (n == 2) {
            int count = markAllPathsAndCountStars(startRow, startCol);
            System.out.println("Number of steps = " + count);
        } else if (n == 3) {
            markTheCorrectPath(startRow, startCol);
        } else if (n == 4)   //use mazeNoPath.txt
        {
            if (!markTheCorrectPath(startRow, startCol)) {
                System.out.println("No path exists.");
            } else
                markTheCorrectPath(startRow, startCol);
        } else if (n == 5) {
            //int count = 0;
            markCorrectPathAndCountStars(startRow, startCol, 0);
            //System.out.println("Number of steps = " + count);
        } else System.out.println("invalid submission");
    }

    /*  1  just like AreaFill*/
    private void markAllPaths(int r, int c) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length) {
            return;
        }
        if (maze[r][c] == EXIT || maze[r][c] == WALL || maze[r][c] == STEP) {
            return;
        }
        if(maze[r][c] == START){

        }else {
            maze[r][c] = STEP;
        }
        markAllPaths(r + 1, c);
        markAllPaths(r - 1, c);
        markAllPaths(r, c + 1);
        markAllPaths(r, c - 1);
    }

    /*  2  just like AreaFill's counting without a static variable */
    private int markAllPathsAndCountStars(int r, int c) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length) {
            return 0;
        }
        if (maze[r][c] == EXIT || maze[r][c] == WALL || maze[r][c] == STEP) {
            return 0;
        }
        maze[r][c] = STEP;
        return 1 + markAllPathsAndCountStars(r + 1, c) + markAllPathsAndCountStars(r - 1, c) + markAllPathsAndCountStars(r, c + 1) + markAllPathsAndCountStars(r, c - 1);
    }

    /*  3   recur until you find E, then mark the True path */
    private boolean markTheCorrectPath(int r, int c) {
        if (r >= maze.length || c >= maze[0].length || r < 0 || c < 0 || maze[r][c] == WALL || maze[r][c] == '*' || !S_Exists || !E_Exists) {
            return false;
        }
        if (maze[r][c] == EXIT) {
            return true;
        }
        if (maze[r][c] == DOT || maze[r][c] == START) {
            char a = maze[r][c];
            maze[r][c] = '*';
            if (markTheCorrectPath(r + 1, c) || markTheCorrectPath(r - 1, c) || markTheCorrectPath(r, c + 1) || markTheCorrectPath(r, c - 1)) {
                if (a == START) {
                    maze[r][c] = START;
                }
                markTheCorrectPath(r + 1, c);
                markTheCorrectPath(r - 1, c);
                markTheCorrectPath(r, c + 1);
                markTheCorrectPath(r, c - 1);
                return true;
            } else {
                maze[r][c] = a;
                return false;
            }
        }
        return false;
    }
    /*  4   just !markTheCorrectPath(startRow, startCol) )
     */

    /*  5  */
    private boolean markCorrectPathAndCountStars(int r, int c, int count) {
        if (r >= maze.length || c >= maze[0].length || r < 0 || c < 0 || maze[r][c] == WALL || maze[r][c] == '*' || !S_Exists || !E_Exists) {
            return false;
        }
        if (maze[r][c] == EXIT) {
            //count += 1;
            System.out.println(count);
            return true;
        }
        count = count + 1;
        if (maze[r][c] == DOT || maze[r][c] == START) {
            char a = maze[r][c];
            maze[r][c] = '*';
            if (markCorrectPathAndCountStars(r + 1, c, count) || markCorrectPathAndCountStars(r - 1, c, count) || markCorrectPathAndCountStars(r, c + 1, count) || markCorrectPathAndCountStars(r, c - 1, count)) {
                if (a == START) {
                    maze[r][c] = START;
                }
                return true;
            } else {
                maze[r][c] = a;
                return false;
            }
        }
        return false;
    }
    private boolean markCorrectPathAndCountStarsTrial(int r, int c, int count) {

        return false;
    }

}
