package com.kkb.chapter04.Demo10203001;

import com.kkb.chapter04.Demo10203001.utils.DeliveryException;
import com.kkb.chapter04.Demo10203001.utils.OutOfSizeDeliveryException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //柜子的取货码和对应柜子
    private static Map<String, int[]> map = new HashMap<String, int[]>();
    //快递保存文件路径
    private String filename = "cabinet";

    public Cabinet() {
        cabinet = new Delivery[DEFAULT_X_SIZE][DEFAULT_Y_SIZE];
        size = DEFAULT_X_SIZE * DEFAULT_Y_SIZE;
        File f = new File(filename);
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int getInUsing() {
        return inUsing;
    }

    //生成随机柜子序号,去重
    private int[] randomPoint() {
        int[] point = new int[2];
        do {
            point[0] = (int)(Math.random() * (cabinet.length-1) + 1);
            point[1] = (int)(Math.random() * (cabinet[0].length-1) + 1);
        } while(isUsing(point[0], point[1]));
        return point;
    }

    //生成随机取货码,未去重
    private String randomNum() {
        StringBuffer nums = new StringBuffer();
        for(int i = 0; i < 6; i++) {
            nums.append((int)((Math.random() * 9) + 1));
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

    //通过快递单号查询该快递是否在柜子中
    public Delivery findDeliveryByTrackingNumber(String trackingNumber) {
        if(this.size <= 0) {
            return null;
        }
        for(int i = 0; i < cabinet.length; i++) {
            for(int j = 0; j < cabinet[i].length; j++) {
                if(cabinet[i][j] != null) {
                    Delivery temp = cabinet[i][j];
                    if(temp.getTrackingNumber().equals(trackingNumber)) {
                        return temp;
                    }
                }
            }
        }
        return null;
    }

    //存入柜子,返回快递信息
    public Delivery add(Delivery delivery) {
        get();
        if(isFull()) {
            throw new OutOfSizeDeliveryException();
        }
        int[] point = randomPoint();
        //存入柜子
        cabinet[point[0]][point[1]] = delivery;
        //将信息保存在快递对象中
        delivery.setX(point[0]);
        delivery.setY(point[1]);
        //生成保存随机码,去重，保存在map对象中
        String num = randomNum();
        while(null != map.get(num)) {
            num = randomNum();
        }
        map.put(num, point);
        this.inUsing++;
        //保存随机码
        cabinet[point[0]][point[1]].setPickID(num);
        this.put();
        return cabinet[point[0]][point[1]];
    }

    //取出快递
    public Delivery remove(int operator, Delivery delivery) {
        get();
        Delivery deli = null;
        //管理员：通过单号删除
        if(operator == 1) {
            cabinet[delivery.getX()][delivery.getY()] = null;
            deli = delivery;
            inUsing--;
        } else if(operator == 2) { //通过取货码删除
            String trackingNumber = delivery.getPickID();
            if(null != map.get(trackingNumber)) {
                int[] point = map.get(trackingNumber);
                deli = cabinet[point[0]][point[1]];
                cabinet[point[0]][point[1]] = null;
                map.remove(trackingNumber);
                inUsing--;
            } else {
                throw new DeliveryException("请确认取货码是否正确");
            }
        }
        if(null == deli) {
            throw new DeliveryException("取出快递失败,请联系管理员");
        }
        put();
        return deli;
    }

    //修改快递信息,通过单号
    public void update(Delivery delivery) {
        get();
        if(delivery.getOperator() == 1) {
            if(delivery.getX() != 0 && delivery.getY() != 0) {
                cabinet[delivery.getX()][delivery.getY()] = delivery;
            }
        } else {
            throw new DeliveryException("只有管理员才能进行操作");
        }
        put();
    }

    //查看所有快递（遍历）
    public void findAll(int operator) {
        get();
        if(operator != 1) {
            throw new DeliveryException("只有管理员才能进行操作");
        }
        if(this.inUsing <= 0) {
            System.out.println("当前柜中无快递");
        }
        for(int i = 0; i < cabinet.length; i++) {
            for(int j = 0; j < cabinet[i].length; j++) {
                if(cabinet[i][j] != null) {
                    System.out.println(cabinet[i][j].toString());
                }
            }
        }
    }

    //保存快递柜子状态
    private void put() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);

            List list = new ArrayList();
            list.add(cabinet);
            list.add(inUsing);
            list.add(map);
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //获取快递柜子对象
    private void get() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            List list = (List) ois.readObject();
            cabinet = (Delivery[][]) list.get(0);
            inUsing = (int) list.get(1);
            map = (Map) list.get(2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            this.inUsing = 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
                if(ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
