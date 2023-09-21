package huawei;

import java.util.*;

//10 20 50 80 1 1

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            int num = Integer.parseInt(strs[i]);
            //获取需要弹出多少位
            int n = check(list, num);
            if (n == 0) {
                list.add(num);
            } else {
                //从后往前弹出n个数
                pop(list, n);
                num *= 2;
                //判断再次添加进去之后会不会出现后几位之和等与新的num的
                //两次添加即可
                n = check(list, num);
                if (n == 0) {
                    list.add(num);
                } else {
                    pop(list, n);
                    list.add(2 * num);
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    static void pop(List<Integer> list, int n) {
        //从后往前弹出n个数
        for (int i = 0; i < n; i++) {
            list.remove(list.size() - 1);
        }
    }

    //返回需要弹出多少位，没有则返回0
    static int check(List<Integer> list, int num) {
        int n = 0;
        int sum = num;
        boolean flag = true;
        for (int i = list.size() - 1 ; i  >= 0; i--) {
            sum += list.get(i);
            n++;
            if (sum == 2 * num) {
                flag = false;
                break;
            }
        }
        if (flag) {
            n = 0;
        }
        return n;
    }
}
