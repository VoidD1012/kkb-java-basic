package com.kkb.chapter03.Demo10203001;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //定义红球池
        int[] redPool = new int[33];
        //添加红球数字
        for (int i = 0; i < redPool.length; i++) {
            redPool[i] = i + 1;
        }
        //定义篮球池
        int[] bluePool=new int[16];
        for (int j = 0; j < bluePool.length; j++) {
            bluePool[j] = j + 1;
        }
        //定义被选中的红球数组
        int[] redBalls = new int[6];
        int x;
        A: for (int i = 0; i < redBalls.length; i++) {
            x = redPool[(int)(Math.random()*33)];
            for (int j = 0; j <= i; j++) {
                //去重
                //判断当前循环取出的红球是否跟前几次取出的一样
                //如果一样 大循环A向后退一次，重新取出红球
                if (redBalls[j] == x) {
                    i--;
                    continue A;
                }
            }
            //如果不一样，则把取出的红球池中取出的红球放入红球数组中

            redBalls[i] = x;
        }
        //取出篮球
        int blueBalls = bluePool[(int)(Math.random()*16)];
        //利用冒泡排序对红球进行排序
        int temp;
        for (int i = 0; i < redBalls.length-1; i++) {
            for (int j = 0; j < redBalls.length-i-1; j++) {
                if (redBalls[j]>redBalls[j+1]) {
                    temp=redBalls[j+1];
                    redBalls[j+1]=redBalls[j];
                    redBalls[j]=temp;
                }
            }
        }
        System.out.println("开奖号码：");
        System.out.print("红球为：");
        for(int i=0;i<redBalls.length;i++){
            System.out.print(redBalls[i]+" ");
        }
        System.out.println("蓝球为：" +blueBalls);

        System.out.println("请输入您购买的红球");
        int[] redBuy = new int[6];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<redBuy.length;i++){
            redBuy[i] = input.nextInt();
        }

        /*System.out.println("您购买的红球");
        for(int i = 0; i < redBuy.length; i++){
            System.out.print(redBuy[i]+" ");
        }*/
        boolean go =true;
        System.out.println("请输入您购买的蓝球(1-16)任选");
        int blueBuy = input.nextInt();

        int count=0;
        for(int i=0;i<redBuy.length;i++){
            for(int j=0;j<redBuy.length;j++){
                if(redBuy[j]==redBalls[i]){
                    count++;
                }
            }
        }
        if(blueBuy==blueBalls){
            if(count==6){
                System.out.println("恭喜您中了1等奖");
            }else if(count==5){
                System.out.println("恭喜您中了3等奖");
            }else if (count==4){
                System.out.println("恭喜您中了4等奖");
            }else if (count==3){
                System.out.println("恭喜您中了5等奖");
            }else if (count==2){
                System.out.println("恭喜您中了6等奖");
            }else if (count==1){
                System.out.println("恭喜您中了6等奖");
            }else {
                System.out.println("恭喜您中了6等奖");
            }
        }else {
            if(count==6){
                System.out.println("恭喜您中了2等奖");
            }else if(count==5){
                System.out.println("恭喜您中了4等奖");
            }else if (count==4){
                System.out.println("恭喜您中了5等奖");
            }else {
                System.out.println("很遗憾，欢迎您再来。。。");
            }
        }


    }
}
