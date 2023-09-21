package test;

/**
 * @author Levi
 * @create 2023/8/24 13:39
 */
public class Test1 {

    static {
        a = 30;
    }
    //从上到下执行
    static int a = 20;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
