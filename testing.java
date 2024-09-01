import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter a string with spaces to denote rows and letters for columns:");

        // Read the input line
        String userInput = scanner.nextLine();

        // Split the input into rows based on spaces
        String[] rows = userInput.split(" ");

        // Create a 2D array to store the characters
        char[][] charArray = new char[rows.length][];

        // Iterate over each row and split it into characters
        for (int i = 0; i < rows.length; i++) {
            charArray[i] = rows[i].toCharArray();
        }

        // Display the 2D array
        System.out.println("Resulting 2D array:");
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println(); // Move to the next row
        }

        // Close the scanner
        scanner.close();
    }
}
