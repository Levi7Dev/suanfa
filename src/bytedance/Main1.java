package bytedance;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] pos = new int[3];
            for (int i = 0; i < 3; i++) {
                pos[i] = sc.nextInt();
            }
            if (n-(1+2*k)<k) {
                System.out.println(-1);
                continue;
            }
            Arrays.sort(pos);

            int minSwap = Integer.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                int p1 = i;
                int p2 = (i + k) % n;
                int p3 = (i + 2 * k) % n + 1;
                int min = swap(p1, pos[0], n) + swap(p2, pos[1], n) + swap(p3, pos[2], n);
                min = Math.min(min, swap(p1, pos[1], n) + swap(p2, pos[0], n) + swap(p3, pos[2], n));
                min = Math.min(min, swap(p1, pos[2], n) + swap(p2, pos[0], n) + swap(p3, pos[1], n));
                if (min <= n && min != 0) {
                    minSwap = Math.min(minSwap, min);
                }
            }
            System.out.println(minSwap == Integer.MIN_VALUE ? -1 : minSwap);
        }
    }

//int totalSwaps = swapDistance(p1, redPos[0], n) + swapDistance(p2, redPos[1], n) + swapDistance(p3, redPos[2], n);
//totalSwaps = Math.min(totalSwaps, swapDistance(p1, redPos[1], n) + swapDistance(p2, redPos[0], n) + swapDistance(p3, redPos[2], n));
//totalSwaps = Math.min(totalSwaps, swapDistance(p1, redPos[2], n) + swapDistance(p2, redPos[0], n) + swapDistance(p3, redPos[1], n));

    private static int swap(int currPos, int targetPos, int n) {
        return Math.min(Math.abs(currPos - targetPos), n - Math.abs(currPos - targetPos));
    }
}


