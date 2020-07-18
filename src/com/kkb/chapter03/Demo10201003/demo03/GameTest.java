package com.kkb.chapter03.Demo10201003.demo03;

import com.kkb.chapter03.Demo10201003.Demo02.MyArrayList;

import java.util.Scanner;

/**
 * @Description: 猜拳游戏训练任务
 * 今天的任务是通过控制台方式实现一个人机对战的猜拳游戏，用户通过输
 * 入（1.剪刀 2.石头 3.布），机器随机生成（1.剪刀 2.石头 3.布），胜者积分，
 * n 局以后通过积分的多少判定胜负。
 * @Author: Du Junnan
 * @Date: Created in 13:48 2020/7/14
 * @Modified by:
 */
public class GameTest {

    Player person;
    Player computer;
    int times;

    public GameTest(Player person, Player computer) {
        this.person = person;
        this.computer = computer;
        times = 0;
    }

    public void start() {
        System.out.println("游戏开始，请输入局数：");
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()) {
            times = input.nextInt();
        } else {
            System.out.println("**请输入数字！**");
            return;
        }
        while(times > 0) {
            play();
            times--;
        }
        end();
    }

    public void play() {
        person.chooseAMotion();
        computer.chooseAMotion();
        if(person.getMotion() == computer.getMotion()) {
            System.out.println("平局！");
        } else {
            int result = person.getMotion() - computer.getMotion();
            if(Math.abs(result) == 2) {
                if ((result > 0)) {
                    computer.setPoints(computer.getPoints() + 1);
                    System.out.println("电脑胜");
                } else {
                    person.setPoints(person.getPoints() + 1);
                    System.out.println("玩家胜");
                }
            } else {
                if ((result > 0)) {
                    person.setPoints(person.getPoints() + 1);
                    System.out.println("玩家胜");
                } else {
                    computer.setPoints(computer.getPoints() + 1);
                    System.out.println("电脑胜");
                }
            }
        }
    }

    public void end() {
        System.out.println("------------------------------------");
        System.out.println("游戏结束，本轮积分如下：");
        System.out.println("玩家积分：" + person.getPoints());
        System.out.println("电脑积分：" + computer.getPoints());
        if(person.getPoints() > computer.getPoints()) {
            System.out.println("玩家胜利！");
        } else if(person.getPoints() < computer.getPoints()) {
            System.out.println("电脑胜利！");
        } else {
            System.out.println("本次游戏平局！");
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        Computer computer = new Computer();
        GameTest game = new GameTest(person, computer);
        game.start();

    }
}
