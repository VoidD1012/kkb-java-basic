package com.kkb.chapter02.day02.Demo10101005;

/**
 * @Description:3、图形打印任务
 *      在控制台中，编写三个 Demo，分别输出如下图形：
 * @Author: Du Junnan
 * @Date: Created in 16:53 2020/7/9
 * @Modified by:
 */
public class Demo03_3 {
    public static void main(String[] args) {//1,3,5,7,9 2n-1  /
        for(int i = 1; i < 6; i++) {
            for(int k = 5-i; k > 0; k--){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
