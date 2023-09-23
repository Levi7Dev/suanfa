package xiaomi;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] cntAndR = in.next().split(",");
        int towersLen = Integer.parseInt(cntAndR[0]);
        int r = Integer.parseInt(cntAndR[1]);

        int[][] val = new int[210][210];

        for (int k = 0; k < towersLen; k++) {
            String[] xyq = in.next().split(",");
            int x = Integer.parseInt(xyq[0]);
            int y = Integer.parseInt(xyq[1]);
            int q = Integer.parseInt(xyq[2]);
            int startX = x - r >= 0 ? x - r : 0;
            int startY = y - r >= 0 ? y - y : 0;
            for (int i = startX; i <= x + r; i++) {
                for (int j = startY; j <= y + r; j++) {
                    int a = (i - x) * (i - x);
                    int b = (j - y) * (j - y);
                    int d = (int)Math.sqrt(a + b);
                    if (d <= r) {
                        val[i][j] += q / (1 + d);
                    }
                }
            }
        }
        int max = -1;
        int ansx = 0, ansy = 0;
        for (int i = 0; i < 210; i++) {
            for (int j = 0; j < 210; j++) {
                if (val[i][j] > max) {
                    ansx = i;
                    ansy = j;
                    max = val[i][j];
                }
            }
        }
        System.out.println(ansx + "," + ansy);
    }
}
