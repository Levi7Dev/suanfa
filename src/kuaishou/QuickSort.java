package kuaishou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi
 * @create 2023/8/10 20:45
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {9, 4, 5, 2, 6, 8, 7, 11, 10, 1, 2};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        //二分查找
        System.out.println(search(nums, 5));
        //字符串相加
        strAdd("999", "1");
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left - 1;
        int r = right + 1;
        int pivot = nums[(left + right) / 2];
        while (l < r) {
            while (nums[++l] < pivot) {}
            while (nums[--r] > pivot) {}
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        quickSort(nums, left, r);
        quickSort(nums, r + 1, right);
    }

    //字符串相加
    public static void strAdd(String a, String b) {
        List<Integer> aa = new ArrayList<>();
        List<Integer> bb = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            aa.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            bb.add(b.charAt(i) - '0');
        }

        List<Integer> result = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            if (i < a.length()) {
                t += aa.get(i);
            }
            if (i < b.length()) {
                t += bb.get(i);
            }
            result.add(t % 10);
            t /= 10;
        }
        if (t != 0) {
            result.add(t);
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
    }

    //二分查找
    public static int search(int[] nums, int a) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (a > nums[mid]) {
                l = mid + 1;
            } else if (a < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
