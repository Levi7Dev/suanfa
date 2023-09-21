package huawei;

import java.util.*;

public class Main {

    //6833023887793076998810418710
    //2211
    //-

    //68846787793076946788418710
    //4210
    //+

    //139804444677899222
    //2
    //*

    /***
     * long数据类型64位，可以表示到亿亿亿的级别
     * 秘码长度3-12位，表示的数值最大到百亿级别
     * 秘钥数值最大值不超过百亿，在最坏情况下，密码最大值乘以秘钥最大值：百亿 * 百亿 = 万亿
     * 而万亿远小于long的数据范围亿亿亿，所以直接用数学运算可行，不会出现数据溢出的情况。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //加密串
        String M = sc.nextLine();
        //秘钥
        String n = sc.nextLine();
        long N = Long.parseLong(n);
        //操作符，小写k
        char k = sc.nextLine().charAt(0);
        long res = -1;

        //用暴力法来做，密码长度在3-12位，枚举每一位的情况
        for (int i = 0; i < M.length(); i++) {
            for (int j = 3; j <= 12; j++) {
                //超过字符串的长度就退出
                if (i + j > M.length()) {
                    break;
                }
                long num = Long.parseLong(M.substring(i, i + j));
                long result = calc(num, N, k);
                if (check(result)) {
                    res = num > res ? num : res;
                }
            }
        }
        System.out.println(res);
    }

    static boolean check(long num) {
        String str = num + "";
        char c = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    static long calc(long num, long N, char k) {
        if (k == '*') {
            return num * N;
        } else if (k == '+') {
            return num + N;
        } else if (k == '-') {
            return num - N;
        }
        return -1;
    }
}










//import java.util.*;
//
//public class huawei.Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str  = in.nextLine();
//        String[] split = str.split(" ");
//        Stack<Integer> stack = new Stack<>();
//        stack.push(Integer.parseInt(split[0]));
//
//        for (int i = 1; i < split.length; i++) {
//            int num = Integer.parseInt(split[i]);
//            while (!stack.isEmpty()) {
//                int top = stack.peek();
//                if (top == num) {
//                    stack.pop();
//                    stack.push(2 * num);
//                } else {
//
//                }
//            }
//        }
//    }
//}

//import java.util.*;
//
//public class huawei.Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Stack<Integer> stack = new Stack<>();
//        String[] s = sc.nextLine().split(" ");
//        for (int i = 0; i< s.length; i++) {
//            int num = Integer.parseInt(s[i]);
//            while (!stack.empty() && checkStack(stack, num)) {
//                num = stack.pop();
//            }
//            stack.push(num);
//        }
//        while (!stack.empty()) {
//            System.out.print(stack.pop() + " ");
//        }
//    }
//
//    private static boolean checkStack(Stack<Integer> stack, int num) {
//        int sum = num;
//        int k = 0;
//        for (int i = stack.size() - 1; i >= 0; i--) {
//            sum += stack.get(i);
//            k++;
//            if (sum == num * 2) {
//                for (int j = 0; j < k; j++) {
//                    stack.pop();
//                }
//                stack.push(num * 2);
//                return true;
//            }
//        }
//        return false;
//    }
//}
