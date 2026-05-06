import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int n = s.length();
        String doubled = s + s;

        int[] values = new int[doubled.length()];
        for (int i = 0; i < doubled.length(); i++) {
            values[i] = doubled.charAt(i) - 'a' + 1;
        }

        int maxSum = 0;
        int left = 0;
        int currentSum = 0;
        Set<Character> seen = new HashSet<>();

        for (int right = 0; right < doubled.length(); right++) {
            char c = doubled.charAt(right);

            while (seen.contains(c) || right - left >= n) {
                seen.remove(doubled.charAt(left));
                currentSum -= values[left];
                left++;
            }

            seen.add(c);
            currentSum += values[right];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
