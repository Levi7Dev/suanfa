package nowcode;

import java.util.*;

public class Main {
    static int[] p = new int[100010];

    public static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        int[][] city = new int[n + 1][n + 1];
        int[][] visit = new int[n + 1][n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < 100010; i++) {
            p[i] = i;
        }

        //建立图
        for (int i = 1; i <= m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            city[u][v] = w;
            city[v][u] = w;
            //并查集
            p[u] = find(v);
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visit[1][1] = 1;
        while (!que.isEmpty()) {
            int h = que.poll();
            //h城市连接的城市
            for (int i = 1; i <= n; i++) {
                //有路
                if (city[h][i] != 0 && visit[h][i] != 1) {
                    if (dp[i] == 0) {
                        dp[i] = dp[h] + city[h][i];
                    } else {
                        dp[i] = Math.min(dp[i], dp[h] + city[h][i]);
                    }
                    que.offer(i);
                    visit[h][i] = 1;
                    visit[i][h] = 1;
                }
            }
        }
        if (find(1) == 1) {
            System.out.println("-1");
        }
        //用x更新dp数组

        int min = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            boolean flag = false;
            int tmin = Integer.MAX_VALUE;
            for (int j = i + 1; j <= n; j++) {
                if (dp[i] + x < dp[j] || dp[j] == 0) {
                    tmin = (dp[i] + x) < tmin ? dp[i] + x : tmin;
                    flag = true;
                }
            }

        }
    }
}
