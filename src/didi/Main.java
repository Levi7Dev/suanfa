package didi;

import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        //
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //int[][] visit = new int[n + 1][m + 1];
        dp[1][1] = a[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //四个方向
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 1 && x <= n && y >= 1 && y <= m) {
                        if (a[i][j] == 1) {
                            dp[x][y] = Math.min(dp[x][y], dp[i][j] + 1);
                        } else {
                            dp[x][y] = Math.min(dp[x][y], dp[i][j]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}