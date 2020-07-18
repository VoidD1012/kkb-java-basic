package com.kkb.chapter03.Demo10203001.utils;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 23:48 2020/7/17
 * @Modified by:
 */
public class NullCabinetDeliveryException extends RuntimeException {
    public NullCabinetDeliveryException() {
        super("柜子中没有快递，请确认快递信息");
    }
}
