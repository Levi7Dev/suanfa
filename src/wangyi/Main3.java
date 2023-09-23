package wangyi;


import java.util.Scanner;

public class Main3 {
    static double ans = 0.0;
    static long res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        backTracking(a, 0.0, 0, 0);
        System.out.println(res);
    }

    public static void backTracking(int[] a, double sum, int size, int startIndex) {
        if (size != 0) {
            ans += sum / size;
            res = (long)ans % 1000000007;
        }
        for (int i = startIndex; i < a.length; i++) {
            backTracking(a, sum + a[i], size + 1, i + 1);
        }
    }
}
