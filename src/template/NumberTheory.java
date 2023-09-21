package template;

import java.util.ArrayList;
import java.util.List;

public class NumberTheory {
    public static void main(String[] args) {
        System.out.println(gcd(2, 6));
    }

    //判断素数
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //分解质因数
    public static void divide(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    s++;
                }
                System.out.println("质因子：" + i + "指数：" + s);
            }
        }
        //可能没有除尽
        if (n > 1) {
            System.out.println("质因子：" + n + "指数：" + 1);
        }
    }

    //约数,i是约数，n/i也是约数，但要判断是否相同
    public static List<Integer> getDividors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }

    //两数最大公约数
    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
