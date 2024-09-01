import java.util.Arrays;
import java.util.Comparator;

public class ColourSort {
    public static void main(String[] args) {
        Object[] nums = {1, 2, 1, 2, 0, 1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(Object[] nums) {
        Arrays.sort(nums, new ColorComparator());
    }

    private static class ColorComparator implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            // Define the order: Crimson (0), Ivory (1), Azure (2)
            int colorOrder = getColorOrder(o1) - getColorOrder(o2);
            return colorOrder;
        }

        private int getColorOrder(Object color) {
            if (color.equals("Crimson") || color.equals(0)) {
                return 0;
            } else if (color.equals("Ivory") || color.equals(1)) {
                return 1;
            } else if (color.equals("Azure") || color.equals(2)) {
                return 2;
            }
            return -1; // Handle other cases if needed
        }
    }
}
