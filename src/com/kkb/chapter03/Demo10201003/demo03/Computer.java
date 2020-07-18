package com.kkb.chapter03.Demo10201003.demo03;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 17:02 2020/7/14
 * @Modified by:
 */
public class Computer extends Player {

    public Computer() {
        super();
    }

    @Override
    public void chooseAMotion() {
        int motion = (int)((Math.random() * 3) + 1);
        this.setMotion(motion);
        System.out.println("请电脑出招（1.剪刀 2.石头 3.布）：");
        System.out.println(getMotion());
    }

}
