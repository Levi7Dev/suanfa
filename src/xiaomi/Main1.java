package xiaomi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    static int[] vis;
    static List<Integer>[] l;
    static boolean flag = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        l = new List[n];
        for (int i = 0; i < n; i++) {
            l[i] = new ArrayList<>();
        }
        vis = new int[n];
        String[] s = in.next().split(",");
        for (String t : s) {
            String[] str = t.split(":");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            l[b].add(a);
        }
        for (int i = 0; i < n && flag; i++) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }
        System.out.println(flag ? 1 : 0);
    }

    static void dfs(int x) {
        vis[x] = 1;
        for (int y : l[x]) {
            if (vis[y] == 0) {
                dfs(y);
                if (!flag) {
                    return;
                }
            } else if (vis[y] == 1) {
                flag = false;
                return;
            }
        }
        vis[x] = 2;
    }
}
