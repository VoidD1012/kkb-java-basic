package com.kkb.day02.Demo10101005;

/**
 * @Description:3、图形打印任务
 *      在控制台中，编写三个 Demo，分别输出如下图形：
 * @Author: Du Junnan
 * @Date: Created in 16:53 2020/7/9
 * @Modified by:
 */
public class Demo03_2 {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
