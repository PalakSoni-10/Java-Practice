import java.util.*;


public class IPAddress {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        restoreIpAddressesHelper(s, 0, "", result);

        return result;
    }

    private static void restoreIpAddressesHelper(String s, int segmentCount, String current, List<String> result) {
        if (segmentCount == 4) {
            // If we have formed a valid IP address with 4 segments, add it to the result
            if (s.length() == 0) {
                result.add(current);
            }
            return;
        }

        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String segment = s.substring(0, i);

            if (isValid(segment)) {
                // Recurse with the remaining string and updated segment count
                String newCurrent = current + (segmentCount == 0 ? "" : ".") + segment;
                restoreIpAddressesHelper(s.substring(i), segmentCount + 1, newCurrent, result);
            }
        }
    }

    private static boolean isValid(String segment) {
        if (segment.length() == 1) {
            return true;
        }
        if (segment.length() == 2 && segment.charAt(0) != '0') {
            return true;
        }
        if (segment.length() == 3 && segment.charAt(0) != '0' && Integer.parseInt(segment) <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "25525511135";
        List<String> result = restoreIpAddresses(input);

        System.out.println("Restored IP Addresses:");
        for (String ipAddress : result) {
            System.out.println(ipAddress);
        }
    }
}
