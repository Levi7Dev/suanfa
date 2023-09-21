package futu;

/**
 * @author Levi
 * @create 2023/9/10 19:03
 */
class A {
}

class B extends A {
}

public class Test {
    public static void main(String[] args) {
        A b1 = new B();
        B b2 = new B();
        get(b1);
        get(b2);
    }

    public static void get(A a) {
        System.out.println("A");
    }

    public static void get(B b) {
        System.out.println("B");
    }
}
