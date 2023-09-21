package shunfeng;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] len = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            len[i] = i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //初始化，很重要的一步
        dp[0] = 0;
        //物品
        for (int i = 1; i * i <= n; i++) {
            //背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 4 * i);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
