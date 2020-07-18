package com.kkb.chapter02.day03.Demo10101007;

import java.util.Scanner;

/**
 * @Description: 1、查找某个整数
 * 定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。 然后将输
 * 入一个整数，查找此整数，找到输出下标， 没找到给出提示
 * @Author: Du Junnan
 * @Date: Created in 22:57 2020/7/10
 * @Modified by:
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("请在提示下输入10个整数");
        Scanner input = new Scanner(System.in);
        int[] nums = new int[10];
        for(int i = 0; i < 10; i++) {
            System.out.println("输入第" + i + "个整数:");
            nums[i] = input.nextInt();
        }
        System.out.println("请输入需要查询的整数：");
        int find = input.nextInt();
        int index = -1;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == find){
                index = j;
            }
        }
        if(index < 0) {
            System.out.println("没有在该数组中找到这个数");
        } else {
            System.out.println("在数组的第" + (index+1) + "个位置");
        }
    }
}
