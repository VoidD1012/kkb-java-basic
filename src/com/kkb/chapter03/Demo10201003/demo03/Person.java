package com.kkb.chapter03.Demo10201003.demo03;

import java.util.Scanner;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 15:28 2020/7/14
 * @Modified by:
 */
public class Person extends Player {

    public Person() {
        super();
    }

    @Override
    public void chooseAMotion() {
        Scanner input = new Scanner(System.in);
        System.out.println("请玩家出招（1.剪刀 2.石头 3.布）：");
        if(input.hasNextInt()) {
            int temp = input.nextInt();
            if(temp < 4 && temp > 0) {
                this.setMotion(temp);
            } else {
                System.out.println("请重新输入范围内的数字");
            }
        } else {
            System.out.println("请重新输入范围内的数字");
        }
    }
}
