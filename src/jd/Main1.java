package jd;

import java.util.Scanner;

/**
 * @author Levi
 * @create 2023/8/12 14:25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();

        int ans = n / 2;
        int cnt1 = 0;
        while ((cnt1 = isABA(s)) != 0) {
            String s1 = s.substring(1, s.length()) + s.substring(0, 1);
            int cnt2 = isABA(s1);
            if (cnt2 < cnt1) {
                ans = Math.min(ans, cnt2 + 1);
                s = s1;
            } else {
                ans = Math.min(ans, cnt1);
                s = getString(s);
            }
        }
        System.out.println(ans);
    }

    public static int isABA(String s) {
        int l = 0;
        int r = s.length() - 1;
        int cnt = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                cnt++;
            }
            l++;
            r--;
        }
        //0：回文，其他不回文，返回需要操作的次数
        return cnt;
    }

    public static String getString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                char c = sb.charAt(r);
                sb.setCharAt(l, c);
                break;
            }
        }
        return sb.toString();
    }
}
