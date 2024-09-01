import java.util.Scanner;

public class TowerBreakers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // Input: Number of towers and the initial height of each tower
            System.out.print("Enter the number of towers and initial height of each tower: ");
            int n = scanner.nextInt();
            int[] heights = new int[n];

            System.out.println("Enter the initial height of each tower:");
            for (int j = 0; j < n; j++) {
                heights[j] = scanner.nextInt();
            }

            // Determine the winner based on the initial heights
            int winner = findWinner(n, heights);
            System.out.println("Player " + winner + " wins!");
        }

        scanner.close();
    }

    // Function to find the winner of the Tower Breakers game
    private static int findWinner(int n, int[] heights) {
        // If there is only one tower or all towers have height 1, Player 1 wins
        if (n == 1 || allTowersHeightOne(heights)) {
            return 1;
        }

        // If any tower has an even height, Player 2 wins
        for (int height : heights) {
            if (height % 2 == 0) {
                return 2;
            }
        }

        // Otherwise, Player 1 wins
        return 1;
    }

    // Helper function to check if all towers have height 1
    private static boolean allTowersHeightOne(int[] heights) {
        for (int height : heights) {
            if (height != 1) {
                return false;
            }
        }
        return true;
    }
}
