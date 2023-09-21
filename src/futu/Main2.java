package futu;


import java.util.Scanner;

public class Main2 {
    int i = getJ();
    int j = 0;

    public int getJ() {
        j = 10;
        System.out.println(i);
        return j;
    }

    public static void main(String[] args) {
        Main2 demo = new Main2();
        System.out.println(demo.j);
    }
}
