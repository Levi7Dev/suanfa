package meituan;

import sun.nio.cs.ext.MacArabic;

import java.util.Scanner;

/**
 * @author Levi
 * @create 2023/8/12 13:07
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] st = new int[n][m];
        int[] rows = new int[n];
        int[] cols = new int[m];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                st[i][j] = in.nextInt();
                sum += st[i][j];
                rows[i] += st[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[i] += st[j][i];
            }
        }

        int sum1 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum1 += rows[i];
            ans = Math.min(ans, Math.abs(sum - sum1 - sum1));
        }
        sum1 = 0;
        for (int i = 0; i < m; i++) {
            sum1 += cols[i];
            ans = Math.min(ans, Math.abs(sum - sum1 - sum1));
        }
        System.out.println(ans);
    }
}
