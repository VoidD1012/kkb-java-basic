package com.kkb.day02.Demo10101003;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description: 出租车计费训练任务
 * @Author: Du Junnan
 * @Date: Created in 9:33 2020/7/10
 * @Modified by:
 */

/*提示用户输入总里程数、总乘车时间、是否预约叫车（如果是预约叫车还需要确认是否在 4 小时以内）、
        是否有低速行驶（如果有，提示输入低速行驶时间，需要考虑早晚高峰），
        如果里程超过 15 公里，需要输入是否往返 2公里范围内，决定空驶费。
        分别将这些用户输入的值，通过赋值存入对应的变量中。
        里程数、低速行驶时长（早晚高峰期行驶时长和其他时间段行驶时长）、
        是否预约叫车（ 按四小时为标准）、
        开始乘坐出租车时间、
        出租车到达终点站时间，
 */

public class Demo {
    public static void main(String[] args) throws ParseException {
        //基础价格
        //3公里内价格
        double baseFeeBegin = 13;
        //超出3公里外每公里的价格
        double basePerKilo = 2.3;

        //基础费用
        double baseFee = 0;
        //等待费
        double lowTimeFee = 0;
        //预约费
        double orderFee = 0;
        //空驶费
        double nullFee = 0;
        //夜间费用
        double nightFee = 0;
        //燃油费
        double additionFee = 1;

        //基础时间常量
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //总费用
        double pay = 0;

        Scanner input = new Scanner(System.in);

        //总里程数
        double sum = 0;
        //上车时间
        String onTaxiTime = null;
//        Date onTaxiTime = null;
        //下车时间
        String offTaxiTime = null;
//        Date offTaxiTime = null;
        //是否预约叫车
        boolean isOrdered = false;
        //发起预约时间
        String orderTime = null;
//        Date orderTime = null;
        //是否低速行驶
        boolean isLowSpeed = false;
        //低速行驶开始时间
        String lowSpeedOnTime = null;
//        Date lowSpeedOnTime = null;
        //低速行驶结束时间
        String lowSpeedOffTime = null;
//        Date lowSpeedOffTime = null;
        //是否空驶
        boolean isNullRide = false;
        // 空驶路程计费
        double nullRide = 0;
        boolean isNightRide = false;

        System.out.println("请输入您本次行程的里程数：");
        if(input.hasNextDouble()) {
            sum = input.nextDouble();
            if(sum - 15 > 0) {
                System.out.println("您的行程超过15km,是否空驶(y/n)：");
                if(input.next().equals("y")) {
                    isNullRide = true;
                    nullRide = sum - 15;
                }
            }
        } else {
            System.out.println("您的输入有误，请重新输入");
            return;
        }

        System.out.println("请输入您的上车时间(yyyy-MM-dd HH:mm)：");
        if(input.hasNextLine()) {
            String time = input.next();
            onTaxiTime = time;
//            try {
//                onTaxiTime = format.parse(time);
//                System.out.println(onTaxiTime);
//            } catch (ParseException e) {
//                System.out.println("请输入正确的时间格式");
//                return;
//            }
        }

        System.out.println("请输入您的下车时间(yyyy-MM-dd hh:mm)：");
        if(input.hasNextLine()) {
            String time = input.next();
            offTaxiTime = time;
//            try {
//                offTaxiTime = format.parse(time);
//            } catch (ParseException e) {
//                System.out.println("请输入正确的时间格式");
//                return;
//            }
        }

        System.out.println("是否低速行驶或等待乘客(y/n):");
        if(input.hasNextLine()) {
            if (input.next().equals("y")) {
                isLowSpeed = true;
                System.out.println("请输入开始时间(yyyy-MM-dd hh:mm)：");
                if (input.hasNext()) {
                    String time = input.next();
                    lowSpeedOnTime = time;
//                try {
//                    lowSpeedOnTime = format.parse(time);
//                } catch (ParseException e) {
//                    System.out.println("请输入正确的时间格式");
//                    return;
//                }
                }
                System.out.println("请输入结束时间(yyyy-MM-dd hh:mm)：");
                if (input.hasNext()) {
                    String time = input.next();
                    lowSpeedOffTime = time;
//                try {
//                    lowSpeedOffTime = format.parse(time);
//                } catch (ParseException e) {
//                    System.out.println("请输入正确的时间格式");
//                    return;
//                }
                }
            }
        }

        System.out.println("是否预约(y/n)");
        if(input.hasNextLine()) {
            if (input.next().equals("y")) {
                isOrdered = true;
                System.out.println("请输入预约时间(yyyy-MM-dd hh:mm)：");
                if (input.hasNext()) {
                    String time = input.next();
                    orderTime = time;
//                try {
//                    orderTime = format.parse(time);
//                } catch (ParseException e) {
//                    System.out.println("请输入正确的时间格式");
//                    return;
//                }
                }
            }
        }


        //按照时间进行计费
         if (sum > 3 && sum <= 15) {
             pay += (sum*basePerKilo);
         }

        //与时间无关的计费
        //预约计费
        if(isOrdered) {
            //上车时间和预约时间相差4小时
            if(format.parse(onTaxiTime).getTime() - format.parse(orderTime).getTime() > 4 * 60 * 60 * 1000) {
                orderFee = 6;
            } else {
                orderFee = 5;
            }
        }

        //空驶计费
        if(isNullRide) {
            nullFee = (sum - 15) * basePerKilo * 1.5;
        }

        //起价
        pay += baseFee;
        //燃油费
        pay += 1;


        System.out.println();
        System.out.println("---------------------------");
        System.out.println("您的行车距离：" + sum + " km");
        System.out.println("您的上车时间：" + onTaxiTime);
        System.out.println("您的下车时间：" + offTaxiTime);
        System.out.println("是否预约：" + (isOrdered ? "是" : "否"));
        System.out.println("---------------------------");
        System.out.println("本次行车账单如下：");
        System.out.println("3公里内计费：" );
        if(isOrdered){
            System.out.println("预约费用：" + orderFee);
        }
        if(isLowSpeed) {
            System.out.println("等待/低速行驶：" + lowTimeFee);
        }
        if(isNullRide) {
            System.out.println("空驶计费：" + nullFee);
        }
        if(isNightRide) {
            System.out.println("夜间计费：" + nightFee);
        }
        if(sum > 3) {
            System.out.println("公里计费：" + sum*basePerKilo);
        }
        System.out.println("总费用：" + pay);

    }


}


