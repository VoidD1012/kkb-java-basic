package com.kkb.chapter03.Demo10201002;

/**
 * @Description:
 * @Author: Du Junnan
 * @Date: Created in 9:04 2020/7/14
 * @Modified by:
 */
public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("这是一本书1");
        book1.setPageNum(100);
        book1.detail();
        System.out.println("-----------------");
        Book book2 = new Book("这是一本书2", 150);
        book2.detail();
        System.out.println("-----------------");
        Book book3 = new Book();
        book3.setTitle("这是一本书3");
        book3.setPageNum(459);
        book3.detail();
    }
}
