package meituan;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        while (q-- > 0) {
            long idx = 0;
            long m = in.nextLong();
            long x = in.nextLong();
            for (long i = 1; i <= x; i++) {
                idx++;
                if (idx > m) {
                    idx = 1;
                }
            }
            System.out.println(idx);
        }
    }
}
