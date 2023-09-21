package xiaohongshu;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            if (judge(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean judge2(String s) {
        //直接进行替换
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'w') {
                s = s.substring(0, i) + "vv" + s.substring(i + 1);
            } else if (c == 'm') {
                s = s.substring(0, i) + "nn" + s.substring(i + 1);
            } else if (c == 'b' || c == 'q' || c == 'p') {
                s = s.substring(0, i) + 'd' + s.substring(i + 1);
            } else if (c == 'u') {
                s = s.substring(0, i) + 'n' + s.substring(i + 1);
            }
        }

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean judge(String s) {
        int l = 0, r = s.length() - 1;
        char[] c = s.toCharArray();
        while (l < r) {
            if (c[l] != c[r]) {
                if (c[l] == 'w' && c[r] == 'v' && r - 1 > l && c[r - 1] == 'v' ||
                        c[l] == 'm' && c[r] == 'n' && r - 1 > l  && c[r - 1] == 'n') {
                    l++;
                    r -= 2;
                }
                else if (c[l] == 'v' && l + 1 < r && c[l + 1] == 'v' && c[r] == 'w' ||
                        c[l] == 'n' && l + 1 < r  && c[l + 1] == 'n' && c[r] == 'm') {
                    r--;
                    l += 2;
                }
                else if (c[l] == 'b' && c[r] == 'd' || c[l] == 'd' && c[r] == 'b' ||
                        c[l] == 'q' && c[r] == 'p' || c[l] == 'p' && c[r] == 'q') {
                    l++;
                    r--;
                }
                else if (c[l] == 'b' && c[r] == 'q' || c[l] == 'q' && c[r] == 'b' ||
                        c[l] == 'd' && c[r] == 'p' || c[l] == 'p' && c[r] == 'd' ||
                        c[l] == 'n' && c[r] == 'u' || c[l] == 'u' && c[r] == 'n') {
                    l++;
                    r--;
                } else {
                    return false;
                }
            } else {
                l++;
                r--;
            }
        }
        if (l > r) {
            return false;
        }
        return true;
    }
}
