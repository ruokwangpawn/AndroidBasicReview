package com.pawn.algorithm.array;

import java.util.Arrays;

/**
 * @ClassName: FirstNotRepeatingChar
 * @Author: wangzhao
 * @CreateDate: 2021/8/26 10:34 下午
 * @Description: 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
 * Input: abacc
 * Output: b
 * @Version: 1.0
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        int number = firstNotRepeatingChar("abacc");
        System.out.println("" + number);
    }

    public static int firstNotRepeatingChar(String str) {
        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        System.out.println(Arrays.toString(cnts));
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
