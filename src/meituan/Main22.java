package meituan;


import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            num[i] = in.nextInt();
            sum += num[i];
        }
        int a = 0, b = 0;
        int max = -1;
        for (int i = 1; i < n; i++) {
            if (num[i] * num[i + 1] > max) {
                max = num[i] * num[i + 1];
                a = i;
                b = i + 1;
            }
        }
        int ans = Math.max(sum, sum - num[a] - num[b] + max);
        System.out.println(ans);
    }
}
