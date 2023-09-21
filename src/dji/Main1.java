package dji;

/**
 * @author Levi
 * @create 2023/8/6 18:39
 */


import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        int[][] cropFiled = {
                {2,3,1,4},
                {1,2,0,3},
                {4,2,1,7},
                {3,1,4,2}
        };

        System.out.println(calc(cropFiled));
    }

    static int calc (int[][] cropFiled) {
        int row = cropFiled.length;
        int col = cropFiled[0].length;

        int[] sumRow = new int[row];
        int[] sumCol = new int[col];

        int total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumRow[i] += cropFiled[i][j];
            }
            total += sumRow[i];
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                sumCol[i] += cropFiled[j][i];
            }
        }

        int max = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(sumRow[i] + sumCol[j] - cropFiled[i][j], max);
            }
        }

        return max + total;
    }
}
