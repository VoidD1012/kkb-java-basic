package com.kkb.chapter03.Demo10201003.demo01;

import java.util.Scanner;

/**
 * @Description: 1. 试题：假设用户账号为：admin，密码为 123，编写用户登陆案例。 要
 * 求：请将登陆定义为 login 方法， 并将 login 方法写在 UserService 类中
 * @Author: Du Junnan
 * @Date: Created in 9:44 2020/7/14
 * @Modified by:
 */
public class UserService {

    private static String username = "admin";
    private static String password = "123";

    public void login(String name, String pwd) {
        if(name.equals(username) && pwd.equals(password)) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误，请重新登录");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = null;
        String pwd = null;
        System.out.println("请输入用户名：");
        if(input.hasNextLine()) {
            name = input.nextLine();
        }
        System.out.println("请输入密码：");
        if(input.hasNextLine()) {
            pwd = input.nextLine();
        }
        UserService us = new UserService();
        us.login(name, pwd);
    }

}
