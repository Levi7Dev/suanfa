package meituan;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] st = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();

        int start = Math.min(x, y);
        int end = Math.max(x, y);
        int min1 = 0;
        for (int i = start; i < end; i++) {
            min1 += st[i];
        }
        int min2 = 0;
        for (int i = end; i < n; i++) {
            min2 += st[i];
        }
        min2 += st[n];
        for (int i = 1; i < start; i++) {
            min2 += st[i];
        }
        int ans = Math.min(min1, min2);
        System.out.println(ans);
    }
}
