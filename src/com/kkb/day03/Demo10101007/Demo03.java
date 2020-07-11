package com.kkb.day03.Demo10101007;

import java.awt.*;

/**
 * @Description: 3、两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为
 * 目标值的那两个整数，并输出他们的数组下标
 * 假设每种输入只会对应一个答案，不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以输出 0，1
 * @Author: Du Junnan
 * @Date: Created in 9:18 2020/7/11
 * @Modified by:
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 18, 34};
        sum(nums, 26);
    }

    public static void sum(int[] nums, int target) {
        yes:
        //第一个加数
        for(int i = 0; i < nums.length; i++) {

            //第二个加数
            for(int j = i + 1; j < nums.length; j++) {
                //超过target的数被过滤
                if((target - nums[i] > 0) && (target-nums[i] == nums[j])) {
                    System.out.println(i + ", " + j);
                    break yes;
                }
            }
        }
    }
}
