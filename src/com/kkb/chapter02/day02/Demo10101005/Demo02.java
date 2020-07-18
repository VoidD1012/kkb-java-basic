package com.kkb.chapter02.day02.Demo10101005;

import java.util.Scanner;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 16:52 2020/7/9
 * @Modified by:
 */
public class Demo02 {
    /**
     * @Description: 2、计算该年该月天数
     * 一年中有 12 个月，而每个月的天数是不一样的。其中大月 31 天，分别为
     * 1,3,5,7,8,10,12 月，小月 30 天，分别 为 4,6,9,11 月。还有二月比较特殊，平
     * 年的二月只有 28 天，而闰年的二月有 29 天，由用户在控制台输入年份和月份，
     * 程序计算该年该月的天数。
     * @Author dujunnan
     **/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        if(!input.hasNextInt()) {
            System.out.println("请输入数字格式的年份");
            return;
        }
        int year = input.nextInt();
        if(year < 1900 || year > 2100) {
            System.out.println("请输入1900-2100年之间的年份");
            return;
        }
        System.out.println("请输入月份：");
        if(!input.hasNextInt()) {
            System.out.println("请输入数字格式的月份");
            return;
        }
        int month = input.nextInt();
        int day = 0;
        switch(month) {
            case 1 :
            case 3 :
            case 5 :
            case 7 :
            case 8 :
            case 10 :
            case 12 :
                day = 31;
                break;
            case 4 :
            case 6 :
            case 9 :
            case 11 :
                day = 30;
                break;
            case 2 :
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    day = 29;
                } else
                    day = 28;
                break;
            default:
                System.out.println("请输入正确的月份");
                break;
        }
        System.out.println("本月有" + day + "天");
    }
}
