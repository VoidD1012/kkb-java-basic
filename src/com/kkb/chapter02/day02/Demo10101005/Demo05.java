package com.kkb.chapter02.day02.Demo10101005;

/**
 * @Description: 5、打印三位数中的所有水仙花数
 * 所谓“水仙花数”即一个整数满足其值等于各个数位的立方和。
 * 如: 153 是一个水仙花数，因为 153= 1³+5³+3³
 * @Author: Du Junnan
 * @Date: Created in 9:01 2020/7/10
 * @Modified by:
 */
public class Demo05 {
    public static void main(String[] args) {
        for(int i = 100; i < 1000; i++){
            int hundred = i/100;
            int decade = i%100/10;
            int unit = i%10;
            double sum = Math.pow(hundred, 3) + Math.pow(decade, 3) + Math.pow(unit, 3);
            if(i == (int)sum) {
                System.out.println(i);
            }
        }
    }
}
