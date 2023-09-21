package dji;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int selectedDigits_size = 0;
        selectedDigits_size = in.nextInt();
        int[] selectedDigits = new int[selectedDigits_size];
        for(int selectedDigits_i = 0; selectedDigits_i < selectedDigits_size; selectedDigits_i++) {
            selectedDigits[selectedDigits_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new Solution().ThreeDigitNumbers (selectedDigits);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

class Solution {

    /* Write Code Here */
    public int[] ThreeDigitNumbers (int[] selectedDigits) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(selectedDigits);
        int len = selectedDigits.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < len; k++) {
                    if (k != i && k != j) {
                        int num = selectedDigits[i] * 100
                                + selectedDigits[j] * 10 + selectedDigits[k];
                        list.add(num);
                    }
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}

