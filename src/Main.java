import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int findLargestArea(char[][] grid, char landType) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == landType) {
                    int area = dfsArea(grid, i, j, landType);
                    if (area != -1) {
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        return maxArea;
    }

    static int dfsArea(char[][] grid, int i, int j, char landType) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return -1;
        }

        if (grid[i][j] != landType) {
            return 0;
        }

        grid[i][j] = '0';
        int size = 1;

        int[] rowDirs = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] colDirs = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int dir = 0; dir < 8; dir++) {
            int newSize = dfsArea(grid, i + rowDirs[dir], j + colDirs[dir], landType);
            if (newSize == -1) {
                size = -1;
            } else {
                size += newSize;
            }
        }

        return size;
    }

    static int findLongestRiver(char[][] grid) {
        int maxRiverLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'u') {
                    maxRiverLength = Math.max(maxRiverLength, dfsRiver(grid, i, j));
                }
            }
        }
        return maxRiverLength;
    }

    static int dfsRiver(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 'u') {
            return 0;
        }

        grid[i][j] = '0';

        int[] rowDirs = {-1, 1, 0, 0};
        int[] colDirs = {0, 0, -1, 1};

        int maxLength = 0;
        for (int dir = 0; dir < 4; dir++) {
            maxLength = Math.max(maxLength, dfsRiver(grid, i + rowDirs[dir], j + colDirs[dir]));
        }

        return 1 + maxLength;
    }

    public static void main(String[] args) {
        try {
            File file = new File("in.txt");
            Scanner scanner = new Scanner(file);

            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();

            char[][] grid = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            int largestLand = findLargestArea(grid, 'x');
            int longestRiver = findLongestRiver(grid);

            System.out.println("Largest Area: " + largestLand);
            System.out.println("Longest River: " + longestRiver);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No File");
            e.printStackTrace();
        }

    }
}































