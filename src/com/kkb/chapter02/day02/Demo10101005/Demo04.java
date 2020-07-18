package com.kkb.chapter02.day02.Demo10101005;

/**
 * @Description: 4、打印九九乘法表 ，效果如图
 * @Author: Du Junnan
 * @Date: Created in 8:57 2020/7/10
 * @Modified by:
 */
public class Demo04 {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }
}
