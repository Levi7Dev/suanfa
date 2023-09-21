package meituan;

/**
 * @author Levi
 * @create 2023/8/12 13:38
 */
import java.util.*;

public class Main3 {
    static char[][] g;
    static int[][] st;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void getGraph(int row, int col, String s) {
        int flag = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                g[i][j] = s.charAt(flag++);
            }
        }
    }

    static int bfs(int row, int col) {
        for (int i = 0; i < row; i++) {
            Arrays.fill(st[i], 0);
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (st[i][j] == 0) {
                    char flag = g[i][j];
                    ans++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] t = q.poll();
                        int x = t[0];
                        int y = t[1];
                        st[x][y] = 1;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < row && ny >= 0 && ny < col &&
                                    g[nx][ny] == flag && st[nx][ny] == 0) {
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        int ans = n;
        g = new char[n][n];
        st = new int[n][n];
        for (int i = 1; i <= n - 1; i++) {
            if (n % i == 0) {
                int row = i;
                int col = n / i;
                getGraph(row, col, s);
                ans = Math.min(ans, bfs(row, col));
            }
        }
        System.out.println(ans);
    }
}
