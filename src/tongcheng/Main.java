package tongcheng;


import java.util.*;

public class Main {
    static Set<String> result = new TreeSet<>();
    static StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] a = in.next().toCharArray();
        int[] visit = new int[a.length];
        backTracking(a, visit);
        System.out.println(result);
        //((Main)null).test(); 正常运行
    }

    public static void backTracking(char[] a, int[] visit) {
        if (path.length() == a.length) {
            result.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            path.append(a[i]);
            backTracking(a, visit);
            visit[i] = 0;
            path.deleteCharAt(path.length() - 1);
        }
    }

    private static void test() {
        System.out.println("test");
    }
}
