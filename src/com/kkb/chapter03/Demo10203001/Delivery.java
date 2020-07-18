package com.kkb.chapter03.Demo10203001;

/**
 * @Description: 快递货物类
 * @Author: Du Junnan
 * @Date: Created in 22:24 2020/7/17
 * @Modified by:
 */
public class Delivery {
    //快递公司
    private String expressCompany;
    //快递单号
    private String trackingNumber;
    //取货码
    private String pickID;
    //当前操作人1:管理员/2:普通用户
    private int operator;
    //保存坐标
    private int x;
    private int y;

    public Delivery(String expressCompany, String trackingNumber) {
        this.expressCompany = expressCompany;
        this.trackingNumber = trackingNumber;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String getPickID() {
        return pickID;
    }

    public void setPickID(String pickID) {
        this.pickID = pickID;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "快递信息{" +
                "快递公司='" + expressCompany + '\'' +
                ", 快递单号='" + trackingNumber + '\'' +
                ", 快递保存在【 " + x + "，" + y + " 】" +
                '}';
    }
}
