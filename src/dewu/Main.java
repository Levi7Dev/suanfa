package dewu;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= a[i]; j--) {
                if (dp[j - a[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
                }
            }
        }
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println("No solution");
        } else {
            System.out.println(dp[m]);
        }
    }
}
