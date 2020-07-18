package com.kkb.chapter03.Demo10201003.demo03;

/**
 * @Description: 今天的任务是通过控制台方式实现一个人机对战的猜拳游戏，用户通过输
 * 入（1.剪刀 2.石头 3.布），机器随机生成（1.剪刀 2.石头 3.布），胜者积分，
 * n 局以后通过积分的多少判定胜负。
 * @Author: Du Junnan
 * @Date: Created in 13:49 2020/7/14
 * @Modified by:
 */
public class Player {
    //手势：
    private int motion;
    //胜利积分
    private static Integer points;

    public Player() {
        points = 0;
    }

    //选择手势
    public void chooseAMotion() {
    }

    public int getMotion() {
        return motion;
    }

    public void setMotion(int motion) {
        this.motion = motion;
    }

    public static Integer getPoints() {
        return points;
    }

    public static void setPoints(Integer points) {
        Player.points = points;
    }
}
