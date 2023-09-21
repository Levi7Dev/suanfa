package xiaohongshu;

/**
 * @author Levi
 * @create 2023/7/23 20:29
 */
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m= in.nextInt();
        int k= in.nextInt();
        int[] arr=new int[n+1];
        int sum=0;
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<m;i++) {
            int l=in.nextInt();
            int r=in.nextInt();
            for(int j=l;j<=r;j++) {
                arr[j]=1;
            }
        }

        for(int i=0;i<k;i++) {
            sum+=arr[i];
        }
        ans=Math.max(ans,sum);
        for(int i=k;i<n+1-k;i++) {
            sum+=arr[i];
            sum-=arr[i-k-1];
            ans=Math.max(ans,sum);
        }
        System.out.println(ans);
    }

}
