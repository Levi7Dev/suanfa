package xiaohongshu;

import java.util.Scanner;


public class test {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m= in.nextInt();
        int k= in.nextInt();
        int[] arr=new int[n+1];

        int ans=Integer.MIN_VALUE;

        int max_r = 0;
        for(int i=0;i<m;i++) {
            int l=in.nextInt();
            int r=in.nextInt();
            max_r = r > max_r ? r : max_r;
            for(int j=l;j<=r;j++) {
                arr[j]=1;
            }
        }

        int sum= 0;
        int left = 0;
        for (int i = 0; i <= n; i++) {
            sum += arr[i];
            if (i - left + 1 < k) {
                continue;
            }
            sum -= arr[left++];
            ans = sum > ans ? sum : ans;
        }
        System.out.println(ans);
    }
}
