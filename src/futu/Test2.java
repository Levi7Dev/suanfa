package futu;

/**
 * @author Levi
 * @create 2023/9/10 19:07
 */
public class Test2 {
    public static void main(String[] args) {
        //method();
//        Double d = 6.00-4.90;
//        int i = 600-490;
//        System.out.println(i/d);
        int t1 = 8, t2 = 9, t3 = 7, t4, t5;
        int t6 = 15;
        t4 = t1 < t2 ? t1 : t2;
        t5 = t4 < t3 ? t4 : t6;
        System.out.println(t5);
    }

    int Test2(int a) {
        return 1;
    }

    private static void method() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 is finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 is finished");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 is finished");
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}

