//package dji;
//
///**
// * @author Levi
// * @create 2023/8/13 19:39
// */
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class Solution {
//
//    /* Write Code Here */
//    public int[] calculateFinalPositi(String instructions) {
//        char[] chars = instructions.toCharArray();
//        int x = 0, y = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == 'R') {
//                x++;
//            } else if (chars[i] == 'L') {
//                x--;
//            } else if (chars[i] == 'U') {
//                y++;
//            } else if (chars[i] == 'D') {
//                y--;
//            }
//        }
//
//        return new int[] {x, y};
//    }
//}
//
//public class Main2 {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int[] res;
//
//        String instructions;
//        try {
//            instructions = in.nextLine();
//        } catch (Exception e) {
//            instructions = null;
//        }
//
//        res = new Solution().calculateFinalPositi(instructions);
//        for(int res_i=0; res_i < res.length; res_i++) {
//            System.out.println(String.valueOf(res[res_i]));
//        }
//
//    }
//}
//
