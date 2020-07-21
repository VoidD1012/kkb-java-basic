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
        while(true) {
            System.out.println("请输入您的身份：（管理员：1，用户：2）");
            Scanner input = new Scanner(System.in);
            int operator;
            if (input.hasNextInt()) {
                int temp = input.nextInt();
                if (temp == 1) {
                    operator = 1;
                    System.out.println("欢迎您，管理员，请选择您的操作：");
                    while (true) {
                        System.out.println("1.快递录入");
                        System.out.println("2.删除快递(根据单号)");
                        System.out.println("3.修改快递(根据单号)");
                        System.out.println("4.查看当前已存的快递");
                        System.out.println("输入quit退出管理员模式");
                        if (input.hasNextInt()) {
                            int option = input.nextInt();
                            menu(operator, option, cabinet);
                        } else {
                            if(input.next().equals("quit")){
                                System.out.println("退出管理员模式");
                            } else {
                                System.out.println("未输入菜单中的操作序号,自动退出");
                            }
                            break;
                        }
                    }
                } else if (temp == 2) {
                    operator = 2;
                    System.out.println("请输入取货码：");
                    if (input.hasNext()) {
                        String pickID = input.next();
                        Delivery tempDeli = new Delivery();
                        tempDeli.setPickID(pickID);
                        Delivery deli = cabinet.remove(operator, tempDeli);
                        System.out.println("您来自" + deli.getExpressCompany() + "的快递：" + deli.getTrackingNumber() + "已经取出");
                        System.out.println("--------------------------------------------");
                    }
                } else {
                    throw new DeliveryException("用户身份有误，请重新输入");
                }
            } else {
                throw new DeliveryException("用户身份有误，请重新输入");
            }
        }

    }

    //管理员菜单
    public static void menu(int o, int option, Cabinet cabinet) {
        System.out.println("--------------------------------------------");
        Scanner input = new Scanner(System.in);
        switch(option) {
            case 1://新增
                if(cabinet.isFull()) {
                    System.out.println("快递柜已满，请等待快递被取出后使用");
                    break;
                }
                System.out.println("请输入要存放的快递单号：");
                String addTrackNumber = input.next();
                if(null == cabinet.findDeliveryByTrackingNumber(addTrackNumber)) {
                    System.out.println("请输入该快递的公司：");
                    String company= input.next();
                    Delivery delivery1 = new Delivery(company, addTrackNumber);
                    Delivery deliAdd = cabinet.add(delivery1);
                    String getDeliNum = deliAdd.getPickID();
                    deliAdd.toString();

                    System.out.println("已经存入柜子，取货码为：" + getDeliNum);
                } else {
                    System.out.println("该单号对应的快递已经入柜");
                    break;
                }

                break;
            case 2://删除
                System.out.println("请输入要删除的快递的单号：");
                String trackNumber = input.next();
                Delivery delivery2 = cabinet.findDeliveryByTrackingNumber(trackNumber);
                if(null == delivery2) {
                    System.out.println("该快递不存在，无法删除");
                    break;
                } else {
                    cabinet.remove(o, delivery2);
                    System.out.println("单号为" + trackNumber + "的快递已经删除");
                }
                break;
            case 3://修改
                System.out.println("请输入修改的单号");
                String trackNum = input.next();
                Delivery delivery3 = cabinet.findDeliveryByTrackingNumber(trackNum);
                if(null == delivery3) {
                    System.out.println("该快递不存在，请重新操作");
                    break;
                }
                System.out.println("请输入修改的快递公司:");
                String company= input.next();
                delivery3.setExpressCompany(company);
                delivery3.setOperator(1);
                cabinet.update(delivery3);
                System.out.println("快递已经修改");
                break;
            case 4://查看
                cabinet.findAll(o);
                break;
            default:
                System.out.println("请输入上述操作的正确编号");
                break;
        }
        System.out.println("--------------------------------------------");
    }

}
