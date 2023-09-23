package sanliuling;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        long seed = in.nextLong();
        Map<Long, Integer> map = new HashMap<>();
        int i = 1;
        long ans = 0;
        int t = q;
        while (t-- > 0) {
            seed = seed ^ (seed << 15);
            seed = seed ^ (seed >> 5);
            seed = seed ^ (seed << 1);
            seed = seed % (1 << 15);

            long op = (seed ^ (seed << 7) ^ (seed >> 5) )% 3 + 1;
            long m = (seed ^ (seed << 6) ^ (seed >> 10)) % q + 1;
            long x = (seed ^ (seed << 5) ^ (seed << 9) ^ (seed >> 6)) % 10 + 1;

            if (op == 1) {
                map.put(x, 1);
            } else if (op == 2) {
                int cnt = map.get(x);
                if (cnt < m) {
                    cnt = 0;
                } else {
                    cnt -= m;
                }
                map.put(x, cnt);
            } else if (op == 3) {
                long min = Integer.MAX_VALUE;
                long max = Integer.MIN_VALUE;
                Iterator<Map.Entry<Long, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Long, Integer> next = iterator.next();
                    long key = next.getKey();
                    int val = next.getValue();
                    if (key > max) {
                        max = key;
                    }
                    if (key < min) {
                        min = key;
                    }
                }
                long diff = max - min;
                ans = ans ^ (diff * i);
                System.out.println(ans);
            }
            i++;
        }
    }
}
