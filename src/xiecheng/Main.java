package xiecheng;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int ans = 0;
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] visit = new int[n + 1];
        backTracking(n, visit);
        System.out.println(ans);
    }

    static void backTracking(int n, int[] visit) {
        if (path.size() == n) {
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                int sum = path.get(i - 1) + path.get(i);
                if (isPrime(sum)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 1) {
                continue;
            }
            path.add(i);
            visit[i] = 1;
            backTracking(n, visit);
            visit[i] = 0;
            path.removeLast();
        }
    }

    static boolean isPrime(int n) {
        if (n <= 2) {
            return true;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
