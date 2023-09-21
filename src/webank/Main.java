package webank;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int N = 1000010;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Double u = in.nextDouble();
        Double v = in.nextDouble();
        Double[] s = new Double[N];
        Double[] q = new Double[n + 1];
        s[0] = 0.0;
        for (int i = 1; i <= n; i++) {
            q[i] = in.nextDouble();
            s[i] = s[i - 1] + q[i];
        }
        for (int i = 1; i <= n; i++) {
            s[i] = s[i] - (i * u / v);
        }
        Map<Double, Integer> h = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            h.put(s[i], h.getOrDefault(s[i], 0) + 1);
        }
        h.put(0.0, h.getOrDefault(0.0, 0) + 1);
        long res = 0;
        for (Double x : h.keySet()) {
            long t = h.get(x);
            if (t > 1) {
                res += t * (t - 1) / 2;
            }
        }
        System.out.println(res);



//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(), u = in.nextInt(), v = in.nextInt();
//        int [] q = new int[n + 1];
//        long[] pre = new long[n + 1];
//        for (int i = 1; i <= n; i++) {
//            q[i] = in.nextInt();
//            pre[i] = pre[i - 1] + q[i];
//        }
//        System.out.println(getAve2(n, u, v, q, pre));
    }

    public static long getAve3() {
        long ans = 0;



        return ans;
    }

    public static long getAve(int n, int u, int v, int[] q) {
        //前缀和
        long[] pre = new long[n + 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + q[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((j - i + 1) * u == v * (pre[j + 1] - pre[i])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static long getAve2(int n, int u, int v, int[] q, long[] pre) {
        long ans = 0;
//        long[] pre = new long[n + 1];
//        for (int i = 1; i <= n; i++) {
//            pre[i] = q[i] + pre[i - 1];
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if((j - i + 1) * u == v * (pre[j] - pre[i - 1])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

//        int[] st = new int[50010];
//        int ans = 1;
//        for (int i = 1, j = 1; i <= n; i++) {
//            st[q[i]]++;
//            while (j < n && st[q[i]] > 1) {
//                st[q[j++]]--;
//            }
//            ans = i - j + 1;
//            //break;
//        }
//        System.out.println(ans);


//    public static int getAns(int[] a) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int ans = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (map.containsKey(a[i])) {
//                break;
//            } else {
//                ans++;
//                map.put(a[i], 1);
//            }
//        }
//        return ans;
//    }

//    public static int getAns(int[] q) {
//        int ans = 0;
//        Arrays.sort(q);
//        for (int i = 1; i < q.length; i++) {
//            while (q[i] <= q[i - 1]) {
//                ans++;
//                q[i]++;
//            }
//        }
//        return ans;
//    }



