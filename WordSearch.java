import java.util.*;
import java.lang.*;
import java.io.*;

public class WordSearch
{
    public static boolean exist(char[][] board, String word)
    {
        if(board==null || board.length ==0 || board[0].length ==0 || word==null || word.isEmpty())
        return false;
        
        //char[] wordArray = target.toCharArray();
        int m =board.length;
        int n = board[0].length;
        
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                if(searchWord(board, i, j, word, 0))
                return true;
            }
        }
        return false;
    }
    
    private static boolean searchWord(char[][] board, int i, int j, String word, int index)
    {
        if(index == word.length())
        return true; //the entire target word is found 
        
        int m = board.length;
        int n = board[0].length;
        
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!=word.charAt(index))
        return false; //out of bounds or the current cell does not match the current character in the target word
        
        char originalChar = board[i][j];
        board[i][j] = '*'; //mark the current cell as visited 
        
        //Explore adjacent cells in all four direcions 
        boolean result = searchWord(board, i+1, j, word, index+1) ||
                         searchWord(board, i-1, j, word, index+1) ||
                         searchWord(board, i, j+1, word, index+1) ||
                         searchWord(board, i, j-1, word, index+1);
                         
        board[i][j] = originalChar; //restore original character
        
        return result;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        System.out.println("enter target word");
        String targetword = sc.next();
        
        System.out.println("enter word array");
        String inputString = sc.next();

        // Split the input string into words
        String[] words = inputString.split("\\s+");


        // Create the 2D char array
        char[][] board = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            // Ensure the word has the expected length before accessing characters
            if (words[i].length() == columns) {
                board[i] = words[i].toCharArray();
            } else {
                System.out.println("Error: Words have different lengths.");
                return;  // Exit the program if lengths are inconsistent
            }
        }

        // Print the 2D char array

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        //String word = "SEE";
       //char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        
        
        boolean result = exist(board, targetword);
        System.out.println(result); 
    }
}
                                                                                                                            