package xiecheng;

import java.util.Scanner;

/**
 * @author Levi
 * @create 2023/9/7 20:18
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(getAns(s));
    }

    public static long getAns(String s) {
        int[] zeroCount = new int[s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            }
            zeroCount[i] = count;
        }
        long res = 0;
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
            if (count > 1) {
                res += zeroCount[i];
            }
        }
        return res;
    }
}