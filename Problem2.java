import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int mod = arr[0] % k;
        for (int i = 1; i < n; i++) {
            if (arr[i] % k != mod) {
                System.out.println(-1);
                return;
            }
        }

        int[] normalized = new int[n];
        for (int i = 0; i < n; i++) normalized[i] = arr[i] / k;

        Arrays.sort(normalized);
        int median = normalized[n / 2];

        long ops = 0;
        for (int val : normalized) ops += Math.abs(val - median);

        System.out.println(ops);
    }
}
