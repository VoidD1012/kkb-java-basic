package com.kkb.chapter03.Demo10203001.utils;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 22:50 2020/7/17
 * @Modified by:
 */
public class OutOfSizeDeliveryException extends RuntimeException {
    public OutOfSizeDeliveryException() {
        super("快递柜存储已经达到上限，请在快递柜空闲时进行操作");
    }

    public OutOfSizeDeliveryException(String message) {
        super(message);
    }
}
