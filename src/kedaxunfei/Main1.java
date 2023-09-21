package kedaxunfei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Levi
 * @create 2023/8/13 14:38
 */
public class Main1 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dfs(n);
        //判断

    }

    static void dfs(int n) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            dfs(n);
            path.removeLast();
        }
    }
}
