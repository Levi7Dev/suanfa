import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        quickSort(nums, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[(left + right) / 2];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            //交换
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        quickSort(nums, left, r);
        quickSort(nums, r + 1, right);
    }
}