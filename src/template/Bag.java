package template;

import java.util.Scanner;

public class Bag {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //01背包
        bag01(in);
        //完全背包
        bag02(in);
        //多重背包
        bag03(in);
    }

    //多重背包(每个物品限定数量)，先遍历物品，再反向遍历背包，再遍历选择的物品数量
    private static void bag03(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] dp = new int[m + 10];
        //先遍历物品
        for (int i = 1; i <= n; i++) {
            //体积，价值，数量
            int v = in.nextInt();
            int w = in.nextInt();
            int s = in.nextInt();
            //再遍历背包
            for (int j = m; j >= v; j--) {
                //遍历数量
                for (int k = 1; k <= s && k * v <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - v * k] + w * k);
                }
            }
        }

        System.out.println(dp[m]);
    }

    //完全背包，先遍历物品，再正向遍历背包
    private static void bag02(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n + 10];
        int[] w = new int[n + 10];
        int[] dp = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[m]);
    }

    //01背包，先遍历物品，再反向遍历背包
    public static void bag01(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n + 10];
        int[] w = new int[n + 10];
        int[] dp = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        //先遍历物品，再反向遍历背包
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
