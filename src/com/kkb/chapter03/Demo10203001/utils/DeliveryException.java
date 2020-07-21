package com.kkb.chapter03.Demo10203001.utils;

/**
 * @Description: 异常类
 * @Author: Du Junnan
 * @Date: Created in 23:54 2020/7/17
 * @Modified by:
 */
public class DeliveryException extends RuntimeException {
    public DeliveryException(String message) {
        System.out.println(message);
    }
}
