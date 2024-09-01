import java.util.HashMap;
import java.util.Map;

public class Cipher {

    static final Map<Character, Character> cipherDictionary = new HashMap<>();

    static {
        cipherDictionary.put('A', 'Z');
        cipherDictionary.put('B', 'Y');
        cipherDictionary.put('C', 'X');
        cipherDictionary.put('D', 'W');
        cipherDictionary.put('E', 'V');
        cipherDictionary.put('F', 'U');
        cipherDictionary.put('G', 'T');
        cipherDictionary.put('H', 'S');
        cipherDictionary.put('I', 'R');
        cipherDictionary.put('J', 'Q');
        cipherDictionary.put('K', 'P');
        cipherDictionary.put('L', 'O');
        cipherDictionary.put('M', 'N');
        cipherDictionary.put('N', 'M');
        cipherDictionary.put('O', 'L');
        cipherDictionary.put('P', 'K');
        cipherDictionary.put('Q', 'J');
        cipherDictionary.put('R', 'I');
        cipherDictionary.put('S', 'H');
        cipherDictionary.put('T', 'G');
        cipherDictionary.put('U', 'F');
        cipherDictionary.put('V', 'E');
        cipherDictionary.put('W', 'D');
        cipherDictionary.put('X', 'C');
        cipherDictionary.put('Y', 'B');
        cipherDictionary.put('Z', 'A');
    }

    public static String encrypt(String word, int key, String operation) {
        if (!operation.equals("addition") && !operation.equals("subtraction")) {
            return "Invalid Operation";
        }

        if (key <= 0 || key >= 26) {
            return "Enter valid key";
        }

        if (!word.equals(word.toUpperCase())) {
            return "Word should be in capitals";
        }

        StringBuilder encryptedWord = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (cipherDictionary.containsKey(c)) {
                char substitutedChar = cipherDictionary.get(c);
                int asciiValue;

                if (operation.equals("addition")) {
                    asciiValue = (substitutedChar + key - 'A') % 26 + 'A';
                } else {
                    asciiValue = (substitutedChar - key - 'A' + 26) % 26 + 'A';
                }

                encryptedWord.append((char) asciiValue);
            } else {
                // For non-alphabetic characters, keep them unchanged
                encryptedWord.append(c);
            }
        }

        return encryptedWord.toString();
    }

    public static void main(String[] args) {
        int key = 5;
        String word = "TOSS";
        String operation = "addition";

        // Encryption
        String encryptedResult = encrypt(word, key, operation);
        System.out.println("Encrypted Word: " + encryptedResult);
    }
}
