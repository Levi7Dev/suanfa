package futu;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();
            double vx = in.nextDouble();
            double vy = in.nextDouble();
            double vz = in.nextDouble();
            double r = in.nextDouble();
            double dist = r - Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
            double v = Math.sqrt(Math.pow(vx,2)+Math.pow(vy,2)+Math.pow(vz,2));
            BigDecimal ans = new BigDecimal(String.valueOf(dist/v));
            ans.setScale(5,BigDecimal.ROUND_DOWN);
            System.out.println(ans);
            //确定速度方向，求各方向距离
        }

    }
}
