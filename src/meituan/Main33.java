package meituan;

import java.util.*;
public class Main33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                sum += getValue(s.substring(i, j + 1));
            }
        }
        System.out.println(sum);
    }

    public static int getValue(String s) {
        char[] chars = s.toCharArray();
        int cntLeft= 0;
        for (int i = 0; i < chars.length - 1; i ++) {
            if (chars[i] == chars[i + 1]) {
                cntLeft++;
                if (chars[i] == '0') {
                    chars[i + 1] = '1';
                } else {
                    chars[i + 1] = '0';
                }
            }
        }
        int cntRight = 0;
        chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == chars[i - 1]) {
                cntRight++;
                if (chars[i] == '0') {
                    chars[i - 1] = '1';
                } else {
                    chars[i - 1] = '0';
                }
            }
        }

        return Math.min(cntLeft, cntRight);
    }
}
