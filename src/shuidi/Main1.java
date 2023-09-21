package shuidi;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n + 1];
            int[] b = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i] && (a[i] + 1) != b[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}








