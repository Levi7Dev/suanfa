package shunfeng;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n + 1];
        //int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (k >= arr[i]) {
                arr[n - 1] += arr[i];
                k -= arr[i];
                arr[i] = 0;
            } else {
                arr[n - 1] += k;
                arr[i] -= k;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
















