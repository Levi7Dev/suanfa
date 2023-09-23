package sanliuling;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        int index = 0;
        int[] has = new int[n + 1];
        int[] day = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = a[i];
            has[k] = 1;
            if (k - 1 == index) {
                day[k] = i;
                int j = k + 1;
                index++;
                while (j <= n && has[j] != 0) {
                    day[j++] = i;
                    index++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(day[i] + " ");
        }
    }
}















