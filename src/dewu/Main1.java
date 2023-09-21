package dewu;

import java.util.*;
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        System.out.println(getAns(h, n));
    }

    public static int getAns(int[] h, int n) {
        int[] res = new int[n];
        int cur = n / 2;
        int l = cur - 1;
        int r = cur + 1;
        res[cur] = h[0];
        Arrays.sort(h);
        int flag = 0;
        for (int i = 1; i < n; i++) {
            if (flag == 1) {
                flag = 0;
                res[r] = h[i];
                r++;
            } else {
                flag = 1;
                res[l] = h[i];
                l--;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = cur + 1; i < n; i++) {
            max = Math.max(max, res[i] - res[i - 1]);
        }
        for (int i = cur - 1; i >= 0; i--) {
            max = Math.max(max, -res[i + 1] + res[i]);
        }
        max = Math.max(max, Math.abs(res[0] - res[n - 1]));
        return max;
    }
}








