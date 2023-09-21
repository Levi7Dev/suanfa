package shuidi;


import java.util.*;

public class Main2 {
    static int N = 510;
    static int[] c = new int[N];
    static int[] h = new int[N];
    static int[] e = new int[N * 2];
    static int[] ne = new int[N * 2];
    static int idx = 0;
    static int[] st = new int[N];
    static int[] d = new int[N];


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b ,a);
        }
        int ans = 10000;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, bfs(i));
        }
        if (ans > 9000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static int bfs(int a) {
        Arrays.fill(st, 0);
        Arrays.fill(d, 0);
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        st[a] = 1;
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (st[j] == 0) {
                    q.offer(j);
                    st[j] = 1;
                    d[j] = d[t] + 1;
                    if (c[j] == c[a]) {
                        return d[j];
                    }
                }
            }
        }
        return 10000;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}