package com.pawn.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: DuplicateNumberInArray
 * @Author: wangzhao
 * @CreateDate: 2021/8/23 11:42 下午
 * @Version: 1.0
 * @Description: 数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * example:
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。
 */
public class DuplicateNumberInArray {

    public static void main(String[] args) {
//        int[] nums = new int[]{10, 3, 5, 0, 6, 9, 2, 5, 7, 1, 4};
//        System.out.println("结果为：" + duplicate(nums));

//        int[][] i = {{11, 22}, {33, 44, 55}, {66, 77, 88, 99}};
//        System.out.println("结果为：" + i.length + " --- " + i[0].length);

        // 111    7
        // 100    4
        // 0011
        // 1000
        // 1011   11
        // 0000

//        int a = 5, b = 6;
//        int c = a ^ b;
//        byte d = 0x00001;
//        System.out.println(c);

        System.out.println("12345678".substring(1,3));

    }

    public static int num(int i) {
        int ans = 0;
        while (i != 0) {
            ans++;
            i = i & (i - 1);
        }
        return ans;
    }

    public static int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                System.out.println("test1：" + i + " , nums[i] = " + nums[i]);
                swap(nums, i, nums[i]);
            }
            System.out.println("test2：" + i + " , nums[i] = " + nums[i]);
//            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
