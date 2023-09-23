package wangyi;


import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] odd = new int[(n + 1) / 2];
            int[] even = new int[n / 2];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (i % 2 == 0) {
                    even[i / 2] = arr[i];
                } else {
                    odd[i / 2] = arr[i];
                }
            }
            Arrays.sort(odd);
            Arrays.sort(even);
            if (getAns(n, arr, odd, even)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean getAns(int n, int[] arr, int[] odd, int[] even) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = even[i / 2];
            } else {
                arr[i] = odd[i / 2];
            }
            if (i > 0 && arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}






















