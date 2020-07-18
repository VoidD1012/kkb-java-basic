package com.kkb.chapter02.day03.Demo10101007;

/**
 * @Description: 2、找出数组的最值
 * 定义一个长度为 10 的整型数组 nums ，循环输入 10 个整数。输出数组
 * 的最大值、最小值。
 * @Author: Du Junnan
 * @Date: Created in 23:03 2020/7/10
 * @Modified by:
 */
public class Demo02 {
    public static void main(String[] args) {
//        System.out.println("请在提示下输入10个整数");
//        Scanner input = new Scanner(System.in);
//        int[] nums = new int[10];
//        for(int i = 0; i < 10; i++) {
//            System.out.println("输入第" + (i + 1) + "个整数:");
//            nums[i] = input.nextInt();
//        }
        int[] nums = {45,932,86,9,85,83,65,12,13,659};
        nums = bubbleSort(nums);
        System.out.println("最大值：" + nums[nums.length-1]);
        System.out.println("最小值：" + nums[0]);
    }

    public static int[] bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    nums[i] = nums[i] + nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];
                }
                System.out.println(nums[i] + "------" + nums[j]);
            }
        }

        return nums;
    }
}
