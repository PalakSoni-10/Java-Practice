import java.util.*;

public class MiniMax {

    public static void main(String[] args) {
        // defining an array of integer type
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array elements: ");

        int[] array = new int[6];
        for (int i = 0; i < 6; i++) {
            array[i] = sc.nextInt();
        }
        // invoking sort() method of the Arrays class
        Arrays.sort(array);

        long minSum = 0, maxSum = 0;
        for (int i = 0; i < 4; i++) {
            minSum += array[i];
        }
        for (int i = 5; i > 1; i--) {
            maxSum += array[i];
        }
        System.out.println(minSum + " " + maxSum);
    }
}
