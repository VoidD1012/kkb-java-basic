package com.kkb.day02.Demo10101005;

import java.util.Scanner;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 9:05 2020/7/9
 * @Modified by:
 */

public class Demo01 {
    public static void main(String[] args) {
        Demo01.method1();
    }

    /**
     * @Description: 1、计算应缴金额
     * 商场根据会员积分打折：
     * 2000 分以内打 9 折，
     * 4000 分以内打 8 折，
     * 8000 分以内打 7.5 折，
     * 8000 分以上打 7 折，使用 if-else-if 结构，实现手动输入购物金额和积分，
     * @Author dujunnan
     **/
    public static void method1() {

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("请输入本次购物金额：");
            double money = 0;
            int point = 0;
            double pay = 0;
            if(input.hasNextDouble()) {
                money = input.nextDouble();
            } else {
                System.out.println("请输入金额");
                continue;
            }
            System.out.println("请输入您的积分：");
            if(input.hasNextInt()) {
                point = input.nextInt();
            } else {
                System.out.println("请输入整数的积分");
                continue;
            }

            if (money < 0 || point < 0) {
                System.out.println("您的输入有误，请重新输入");
                continue;
            }
            if (point < 2000) {
                money *= 0.9;
            } else if (point >= 2000 & point < 4000) {
                money *= 0.8;
            } else if (point >= 4000 & point < 8000) {
                money *= 0.75;
            } else if (point >= 8000) {
                money *= 0.7;
            }
            System.out.println("您本次的消费金额是：" + money);
            System.out.println("继续录入请输入任意字符");
            System.out.println("输入q退出");
        } while(!input.next().equals("q"));

    }

}
