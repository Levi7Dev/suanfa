package wuba;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> longs = getListElement(list);
        System.out.println(longs);
    }


    public static <T> List<T> getListElement(List<T> list){  //这里的<T>,跟类<T>,是不一样的，它俩互不影响！
        return  list;
    }


    StringBuilder path = new StringBuilder();
    int ans = 0;
    public  int subsequence (String source, String pattern) {

        return 0;
    }

    public void backTracking(String source, String pattern, int startIndex) {
        if (path.toString().equals(pattern)) {
            ans++;
        }
        for (int i = startIndex; i < source.length(); i++) {
            path.append(source.charAt(i));
            backTracking(source, pattern, i + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static int calculate (int m, int n, int[] scores) {
        Arrays.sort(scores);
        int min = scores[0];
        int max = scores[scores.length - 1];

        for (int x = min; x <= max; x++) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int j = 0; j < scores.length; j++) {
                if (scores[j] > x) {
                    cnt1++;
                } else {
                    cnt2++;
                }
            }
            if (cnt1 >= m && cnt1 <= n && cnt2 >= m && cnt2 <= n) {
                return x;
            }
        }
        return -1;
    }
}
