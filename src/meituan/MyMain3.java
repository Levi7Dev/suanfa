package meituan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Levi
 * @create 2023/8/12 13:43
 */
public class MyMain3 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int[][] graph = new int[n][n];

        int ans = n;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                int row = i;
                int col = n / i;
                getGraph(graph, row, col, s);
                ans = Math.min(ans, bfs(graph, row, col));
            }
        }
        System.out.println(ans);
    }

    //构造图
    public static void getGraph(int[][] graph, int row, int col, String s) {
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                graph[i][j] = s.charAt(index++);
            }
        }
    }

    public static int bfs(int[][] graph, int row, int col) {
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0) {
                    ans++;
                    Queue<int[]> que = new LinkedList<>();
                    que.offer(new int[]{i ,j});
                    while (!que.isEmpty()) {
                        int[] point = que.poll();
                        int x = point[0];
                        int y = point[1];
                        visited[x][y] = 1;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < row && ny >= 0 && ny < col && visited[nx][ny] == 0
                                    && graph[nx][ny] == graph[i][j]) {
                                que.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
