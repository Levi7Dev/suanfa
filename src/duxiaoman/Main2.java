package duxiaoman;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 1000000007;
        int[] p = new int[n + 1];
        int[] c = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            p[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
        }

        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }
        for (int i = n; i >= 2; i -= 2) {
            if (c[p[i]] == 1) {
                dp[p[i]] = dp[i] + dp[i - 1];
            } else {
                dp[p[i]] = dp[i] * dp[i - 1];
            }
            if (dp[p[i]] > cnt) {
                dp[p[i]] %= cnt;
            }
        }
        System.out.println(dp[1]);
    }
}
