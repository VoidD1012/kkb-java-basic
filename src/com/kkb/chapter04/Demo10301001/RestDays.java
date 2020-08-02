package com.kkb.chapter04.Demo10301001;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 找到休息日
 */
public class RestDays {

    public static final Date FIRST_REST_DATE = new Date(2020-1900, 1, 2);

    public static void print(int year, int month) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("星期日\t" + "星期一\t" + "星期二\t" + "星期三\t" + "星期四\t" + "星期五\t" + "星期六\t");
        System.out.println("--------------------------------------------------------------------");

        //新建输入的Date，通过当月的第一天作为种子，找到当月的第一个休息日
        //根据第一个休息日找到整月的所有休息日，计算总天数
        //计算休息日是周末的日子，计数
        Calendar basic = Calendar.getInstance();
        basic.setTime(FIRST_REST_DATE);
        Calendar need = Calendar.getInstance();
        Date date = new Date(year-1900, month-1, 2);
        need.setTime(date);

        int basicDay = basic.get(Calendar.DAY_OF_YEAR);
        int needDay = need.get(Calendar.DAY_OF_YEAR);
        int minusDay = 0;
        if(year == basic.get(Calendar.YEAR)) {
            minusDay = needDay - basicDay;
        } else {
            for(int i = basic.get(Calendar.YEAR); i < year; i++) {
                if(i % 4 == 0 || i % 100 != 0 || i % 400 == 0) {
                    minusDay += 366;
                } else {
                    minusDay += 365;
                }
            }
        }
        //当月第一个休息日的日期
        int firstDay = need.get(Calendar.DAY_OF_MONTH) - (minusDay % 4);
        if(minusDay % 4 == 0) {
            firstDay = need.get(Calendar.DAY_OF_MONTH);
        } else {
            firstDay += 4;
        }

        //打印日历，并计数
        int all = 0;
        int inWeekend = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(year-1900, month-1, 1));
        firstDay += (c.get(Calendar.DAY_OF_WEEK) - 1);
        for(int i = 0; i < c.getActualMaximum(Calendar.DAY_OF_MONTH) + c.get(Calendar.DAY_OF_WEEK); i++) {
            if(i >= c.get(Calendar.DAY_OF_WEEK)) {
                if ((i - firstDay) % 4 == 0) {
                    System.out.print("[");
                    all++;
                    int temp = (i - c.get(Calendar.DAY_OF_WEEK)) % 7;
                    if(temp == 0 || temp == 1) {
                        inWeekend++;
                    }
                }
                System.out.print((i + 1 - c.get(Calendar.DAY_OF_WEEK)));
                if ((i - firstDay) % 4 == 0) {
                    System.out.print("]");
                }
            }
            if(i != 0) {
                System.out.print("   \t");
            }
            if(i % 7 == 0 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("本月休息日有" + all + "天");
        System.out.println("本月轮到周末休息有" + inWeekend + "天");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int year = 0;
        int month = 0;
        System.out.println("请输入年份");
        //输入年月
        if(input.hasNextInt()) {
            int temp = input.nextInt();
            if(temp >= 2020) {
                year = temp;
            } else {
                System.out.println("请输入2020年及以后的年份");
                return;
            }
        } else {
            System.out.println("请输入正确的年份");
            return;
        }
        System.out.println("请输入月份");
        if(input.hasNextInt()) {
            int temp = input.nextInt();
            if(temp > 1 && temp < 13 && year == 2020) {
                month = temp;
            } else {
                System.out.println("请输入符合事实的月份");
                return;
            }
        } else {
            System.out.println("请输入正确的月份");
            return;
        }
        //保证输入正确
        //保证月份不小于2，年份不小于2020
        print(year, month);
    }
}
