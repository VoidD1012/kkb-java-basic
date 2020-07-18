package com.kkb.chapter03.Demo10203001;

import com.kkb.chapter03.Demo10203001.utils.DeliveryException;
import com.kkb.chapter03.Demo10203001.utils.NullCabinetDeliveryException;
import com.kkb.chapter03.Demo10203001.utils.OutOfSizeDeliveryException;

import java.util.ArrayList;

/**
 * @Description: 快递柜子类，保存数据结构，定义增删改查的操作方式
 * @Author: Du Junnan
 * @Date: Created in 22:17 2020/7/17
 * @Modified by:
 */
public class Cabinet {

    //柜子模型：二维数组保存快递货物
    private static Delivery[][] cabinet;
    //默认柜子大小
    private static final int DEFAULT_X_SIZE = 30;
    private static final int DEFAULT_Y_SIZE = 20;
    //柜子坐标
    private int x;
    private int y;
    //正在使用的柜子数量
    private int inUsing;
    //柜子总格数
    private int size;

    //生成随机柜子序号
    private int[] randomPoint() {
        int[] point = new int[2];
        do {
            point[0] = (int)(Math.random() * cabinet.length + 1);
            point[1] = (int)(Math.random() * cabinet[0].length + 1);
        } while(isUsing(point[0], point[1]));
System.out.println("柜子x:" + point[0]);
System.out.println("柜子y:" + point[1]);
        return point;
    }

    //生成随机取货码---------保证不重复？
    private String randomNum() {
        int[] nums = new int[6];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (int)((Math.random() * 10) + 1);
        }
        return nums.toString();
    }

    //检查柜子是否正在被使用
    public boolean isUsing(int x, int y) {
        return (null == cabinet[x][y]) ? false : true;
    }

    //检查柜子当前是否被全部使用
    public boolean isFull() {
        return inUsing == size ? true : false;
    }

    //存入柜子,返回取货码
    public String add(Delivery delivery) {
        if(isFull()) {
            throw new OutOfSizeDeliveryException();
        }
        int[] point = randomPoint();
        //存入柜子
        cabinet[point[0]][point[1]] = delivery;
        //将信息保存在快递对象中
        delivery.setX(point[0]);
        delivery.setY(point[1]);
        //生成保存随机码
        String num = randomNum();
        delivery.setPickID(num);
        return num;
    }

    //取出快递，通过单号
    public Delivery remove(Delivery info) {
        Delivery deli = cabinet[info.getX()][info.getY()];
        //



        if(null == deli) {
            throw new DeliveryException("取出快递失败,请联系管理员");
        }
        return deli;
    }

    //修改快递信息,通过单号
    public Delivery update(Delivery info) {
        if(info.getOperator() == 1) {
            Delivery deli = cabinet[info.getX()][info.getY()];
            deli.setX();
        }
    }
    //查看所有快递（遍历）
    public Delivery findAll(Delivery delivery) {

    }
    //快递取出
}
