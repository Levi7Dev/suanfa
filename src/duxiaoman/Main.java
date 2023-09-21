package duxiaoman;


import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        char[] arr = in.next().toCharArray();
        int cnt = 0;
        int i = 0;
        while (cnt < k) {
            if (arr[i % n] == 'A') {
                cnt++;
            }
            i++;
        }
        System.out.println(i);
    }
}


//    public static int getAns(char[] arr) {
//        int sA = 0;
//        for (int i = 0; i < n; i++) {
//            if(arr[i] == 'A') {
//                sA++;
//            }
//        }
//        int ans = 0;
//        int div = k / sA;
//        int mod = k % sA;
//        int cnt = 0;
//        if (mod == 0) {
//            ans += (div - 1) * n;
//            for (int i = 1; i <= n; i++) {
//                if (arr[i] == 'A') {
//                    cnt++;
//                    if (cnt == sA) {
//                        ans += i;
//                        break;
//                    }
//                }
//            }
//        } else {
//            ans += div * n;
//            for (int i = 1; i <= n; i++) {
//                if (arr[i] == 'A') {
//                    cnt++;
//                    if (cnt == mod) {
//                        ans += i;
//                        break;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
