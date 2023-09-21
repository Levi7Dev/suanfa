package xiaohongshu;


import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int cnt = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = in.next();
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == cnt) {
                ans++;
                cnt++;
            }
        }
        System.out.println(ans);
    }
}
