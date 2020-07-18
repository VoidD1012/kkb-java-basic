package com.kkb.chapter03.Demo10203001;

import com.kkb.chapter03.Demo10203001.utils.DeliveryException;

import java.util.Scanner;

/**
 * @Description: 快递管理系统界面
 * @Author: Du Junnan
 * @Date: Created in 17:44 2020/7/18
 * @Modified by:
 */
public class Test {

    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        System.out.println("欢迎使用快递管理系统");
        System.out.println("请输入您的身份：（管理员：1，用户：2）");
        Scanner input = new Scanner(System.in);
        int operator;
        if(input.hasNextInt()) {
            int temp = input.nextInt();
            if(temp == 1) {
                operator = 1;
                System.out.println("欢迎您，管理员，请选择您的操作：");
                while(true) {
                    System.out.println("1.快递录入");
                    System.out.println("2.删除快递(根据单号)");
                    System.out.println("3.修改快递(根据单号)");
                    System.out.println("4.查看当前已存的快递");
                    if (input.hasNextInt()) {
                        int option = input.nextInt();
                        menu(operator, option, cabinet);
                    } else {
                        System.out.println("请输入菜单中的操作序号");
                    }
                }
            } else if(temp == 2) {
                operator = 2;
                System.out.println("请输入取货码：");
                if(input.hasNext()) {
                    String pickID = input.next();
                    Delivery deli = cabinet.remove(operator, pickID);
                    System.out.println(deli.toString());
                }
            } else {
                throw new DeliveryException("用户身份有误，请重新输入");
            }
        } else {
            throw new DeliveryException("用户身份有误，请重新输入");
        }

    }

    public static void menu(int o, int option, Cabinet cabinet) {
        System.out.println("--------------------------------------------");
        Scanner input = new Scanner(System.in);
        switch(option) {
            case 1://新增
                break;
            case 2://删除
                break;
            case 3://修改
                System.out.println("请输入修改的单号");
                String trackNum = input.next();
                System.out.println("请输入修改的快递公司:");
                String company= input.next();
                Delivery deli = new Delivery(trackNum, company);
                cabinet.update(deli);
                break;
            case 4://查看
                cabinet.findAll(o);
                break;
            default:
                System.out.println("请输入上述操作的正确编号");
        }
    }

}
