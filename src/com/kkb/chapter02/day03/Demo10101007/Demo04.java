package com.kkb.chapter02.day03.Demo10101007;

/**
 * @Description: 4、排序并查找
 * 对数组{1,3,9,5,6,7,15,4,8}进行排序,然后使用二分查找 6 并
 * 输出排序后的下标。
 * @Author: Du Junnan
 * @Date: Created in 9:32 2020/7/11
 * @Modified by:
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] nums = {1,3,9,5,6,7,15,4,8};
        nums = sort(nums);
        int result = binarySearch(nums, 9);
        if(result < 0) {
            System.out.println("没有找到");
        } else {
            System.out.println("下标为：" + result);
        }
        print(nums);
    }

    public static int[] sort(int[] nums) {
        for(int i = nums.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++){
                if(nums[i] < nums[j]) {
                    nums[j] = nums[i] + nums[j];
                    nums[i] = nums[j] - nums[i];
                    nums[j] = nums[j] - nums[i];
                }
            }
        }
        return nums;
    }

    //非递归
    public static int binarySearch(int[] nums, int target) {
        int result = -1;
        //初始化
        int head = 0;
        int end = nums.length-1;
        do {
            if(nums[head] == target) {
                result = head;
                break;
            }
            if(nums[end] == target) {
                result = end;
                break;
            }
            int mid = (head + end)/2;
            if(target == nums[mid]) {
                result = mid;
                break;
            } else if(target > nums[mid]) {
                head = mid;
            } else {
                end = mid;
            }
        }while(head != end);
        return result;
    }

    public static void print(int[] num) {
        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
