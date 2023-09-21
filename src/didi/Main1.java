package didi;


import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        System.out.println(max(a, k));
    }
    public static int max(int[] a, int k) {
        int low = 1;
        int high = a[a.length - 1] - a[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (can(a, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean can (int[] arr, int k, int dist) {
        int cnt = 1;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pre >= dist) {
                cnt++;
                if (cnt == k) {
                    return true;
                }
                pre = arr[i];
            }
        }
        return false;
    }
}






