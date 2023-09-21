package xiaohongshu;

import java.util.Scanner;

/**
 * @author Levi
 * @create 2023/7/27 9:05
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long sum = 0l;
        for (long i = 1; i <= n; i++) {
            sum += i * k;
        }
        System.out.println(sum);

        //或求和公式
        System.out.println((n * (n + 1) / 2) * k);
    }
}
