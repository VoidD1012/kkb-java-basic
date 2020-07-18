package com.kkb.chapter02.day03.Demo10101007;

/**
 * @Description: 5、移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保
 * 持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 * @Author: Du Junnan
 * @Date: Created in 10:47 2020/7/11
 * @Modified by:
 */
public class Demo05 {
    public static void main(String[] args) {
        int[] nums = {1,3,0,0,5,6,0,15,4,8};
        nums = zeroOut(nums);
        Demo04.print(nums);
    }
    public static int[] zeroOut(int[] nums) {
        //保存原数组的最后一位数的位置
        int end = nums.length-1;
        for(int i = 0; i <= end; ) {
            //找到数组中的0
            if(nums[i] == 0) {
                //将0之后的数字前移一位
                for(int j = i; j < end; j++) {
                    nums[j] = nums[j+1];
                }
                //在结尾添加0
                nums[end] = 0;
                //末尾前移
                end -= 1;
            }else { //非0，跳过
                i++;
            }
        }
        return nums;
    }
}
