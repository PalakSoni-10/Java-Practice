import java.util.*;


public class SubstringEven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // Replace this with your input string
        int result = findLongestEvenVowelSubstring(s);
        System.out.println("Size of the longest substring with even vowel counts: " + result);

        scanner.close();
    }

    public static int findLongestEvenVowelSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int maxLength = 0;

        Map<Character, Integer> vowelCount = new HashMap<>();
        vowelCount.put('a', 0);
        vowelCount.put('e', 0);
        vowelCount.put('i', 0);
        vowelCount.put('o', 0);
        vowelCount.put('u', 0);

        Map<String, Integer> stateMap = new HashMap<>();
        stateMap.put("00000", -1);

        for (int i = 0; i < n; i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if (vowelCount.containsKey(ch)) {
                vowelCount.put(ch, vowelCount.get(ch) + 1);
            }

            StringBuilder state = new StringBuilder();
            for (char vowel : "aeiou".toCharArray()) {
                state.append(vowelCount.getOrDefault(vowel, 0) % 2);
            }

            if (stateMap.containsKey(state.toString())) {
                maxLength = Math.max(maxLength, i - stateMap.get(state.toString()));
            } else {
                stateMap.put(state.toString(), i);
            }
        }

        return maxLength;
    }
    
}
