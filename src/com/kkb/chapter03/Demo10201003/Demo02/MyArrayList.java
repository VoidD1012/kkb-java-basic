package com.kkb.chapter03.Demo10201003.Demo02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: 2. 试题：设置一个类， 命名为 MyList
 * 类中包含属性：Object[] element
 * 方法有如下几个：
 * 1. 增加方法 add ： 可以向数组属性中依次存储 Object，数组内容
 * 存满时，需实现动态扩容（详解在下面）。
 * 2. 删除方法 remove ：可以根据数据或下标，从数组属性中删除
 * Object 数据，删除后，数组后续元素需前移。
 * 3. 查询方法 get ：方法传入下标，返回数组中指定下标的数据。
 * 当前存储数据量 size ： 获取当前存储的有效数据长度
 * 动态扩容详解：无需真正增加原数组的容量，只用将原内容复制到新
 * 的大数组，然后让原数组名称重新等于大数组即可。由于原数组数据在堆中，
 * 失去引用会被 GC 自动回收。
 * @Author: Du Junnan
 * @Date: Created in 13:11 2020/7/14
 * @Modified by:
 */
public class MyArrayList {
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;
    //底层使用Object数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] elementData;

    private int size;

    //构造方法
    public MyArrayList(int initialCapacity) {
        if(initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    //构造方法
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object obj) {
        //扩容
        if(size >= elementData.length) {
            expandArray();
        }
        elementData[size] = obj;
        size++;
    }

    public void remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("下标超过List的范围");
        }
        for(int i = index; i < size-1; i++) {
            elementData[i] = elementData[i+1];
        }
        size--;
    }

    public Object get(int index) {
        return elementData[index];
    }

    public void expandArray() {
        int newSize = elementData.length * 2;
        Object[] newObject = new Object[newSize];
        for(int i = 0; i < this.size; i++) {
            newObject[i] = elementData[i];
        }
        elementData = newObject;
    }

}
