import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter space-separated numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Step 1: Arrange the elements in ascending order
        Arrays.sort(numbers);

        // Step 2: Find the frequency count
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Print the frequency count, including the frequency of 0
        System.out.println("Frequency of given numbers:");
        for (int i = 0; i <= numbers[numbers.length - 1]; i++) {
            System.out.print(frequencyMap.getOrDefault(i, 0)+" ");
        }
    }
}
