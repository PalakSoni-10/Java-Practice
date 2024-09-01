import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

    public static String checkGridSorting(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        // Check if rows are sorted
        for (int i = 0; i < rows; i++) {
            char[] rowChars = grid[i].toCharArray();
            Arrays.sort(rowChars);
            String sortedRow = new String(rowChars);
            if (!grid[i].equals(sortedRow)) {
                return "NO";
            }
        }

        // Check if columns are sorted
        for (int j = 0; j < cols; j++) {
            StringBuilder columnChars = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                columnChars.append(grid[i].charAt(j));
            }
            char[] colCharsArray = columnChars.toString().toCharArray();
            Arrays.sort(colCharsArray);
            String sortedColumn = new String(colCharsArray);
            if (!columnChars.toString().equals(sortedColumn)) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of test cases:");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter the number of rows:");
            int rows = scanner.nextInt();

            System.out.println("Enter the number of columns:");
            int cols = scanner.nextInt();

            String[] grid = new String[rows];
            System.out.println("Enter the grid:");

            for (int i = 0; i < rows; i++) {
                grid[i] = scanner.next();
            }

            String result = checkGridSorting(grid);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}
