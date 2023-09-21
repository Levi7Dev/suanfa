public class Test1 {
    public static void main(String[] args) {
       int mode = 5;
       int n = 15;
       int k = 0;
       int ans = 0;
       for (int i = 0; i <= n; i++) {
           if (k % mode == 0) {
               ans = k;
               k = 1;
               mode = mode * 2;
           } else {
               //ans = k;
               k++;
           }
       }
       System.out.println(ans);
    }
}
