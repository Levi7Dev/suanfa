package shuidi;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] split = str.substring(1, str.length() - 2).split("},");
        for (String s : split) {
            String ss = s.substring(1);
            List<String> list = new ArrayList<>();
            //'mon': '2021-10', 'p1': 124.0, 'p2': 103.0
            String[] split1 = ss.split(",");
            String mon = "";
            boolean flag = false;
            for (String a : split1) {
                String[] split2 = a.split(":");

                if ("'mon'".equals(split2[0])) {
                    mon = split2[1].trim();
                } else {
                    if (Double.parseDouble(split2[1]) == 0.0) {
                        list.add(split2[0].trim());
                        flag = true;
                    }
                }

            }
            if (flag) {
                list.add(mon);
                System.out.println(list);
            }


        }

    }
}
