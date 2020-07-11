package com.kkb.day02.Demo10101004;

import java.util.Scanner;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 9:20 2020/7/10
 * @Modified by:
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String question;
        while(true) {
            //保存输入的对话
            question = scanner.next();
            //替换输入中的“吗”为空
            question = question.replace("吗", "");
            //替换输入中的“我”为“我也”
            question = question.replace("我", "我也");
            //替换输入中的“？”为“！”
            question = question.replace("？", "！");
            //回答输入的对话
            System.out.println(question);
        }
    }
}
