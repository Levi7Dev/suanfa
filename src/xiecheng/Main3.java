package xiecheng;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            long l = in.nextLong();
            long r = in.nextLong();
            long njia = 0, njian = 0, canjia = 0, canjian = 0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                if (x < l) {
                    njia += (l - x);
                } else if (x > r) {
                    njian += (x - r);
                } else {
                    canjia += (r - x);
                    canjian += (x - l);
                }
            }
            if (njian >= njia && (njian - njia) <= canjia) {
                System.out.println(njian);
            } else if (njia > njian && (njia - njian) <= canjia) {
                System.out.println(njia);
            } else {
                System.out.println(-1);
            }
        }

    }

}
