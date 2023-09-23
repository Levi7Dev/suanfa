package wangyi;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        long ans = 0;
        while (n -- > 0) {
            char[] arr = in.next().toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if (map.containsKey(str)) {
                ans += map.get(str);
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.println(ans);
    }
}
