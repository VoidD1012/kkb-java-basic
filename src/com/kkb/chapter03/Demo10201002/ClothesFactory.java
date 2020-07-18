package com.kkb.chapter03.Demo10201002;

/**
 * @Description: 3. 通过类描述衣服， 每个衣服对象创建时需要自动生成一个序号值。
 * 要求：每个衣服的序号是不同的， 且是依次递增 1 的。
 * @Author: Du Junnan
 * @Date: Created in 9:17 2020/7/14
 * @Modified by:
 */
public class ClothesFactory {
    private int id;//序号
    private String producter;//生产商
    private double prize;//价格
    private String madeOf;//材质
    private static int count = 0; //计数

    {
        count++;
        id = count;
    }

    public ClothesFactory() {
    }

    public ClothesFactory(String producter, double prize, String madeOf) {
        this.producter = producter;
        this.prize = prize;
        this.madeOf = madeOf;
    }

    public int getId() {
        return id;
    }

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getMadeOf() {
        return madeOf;
    }

    public void setMadeOf(String madeOf) {
        this.madeOf = madeOf;
    }

}
