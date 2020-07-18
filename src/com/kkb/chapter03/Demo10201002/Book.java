package com.kkb.chapter03.Demo10201002;

/**
 * @Description: 1. 编写一个类 Book，代表图书。
 * @Author: Du Junnan
 * @Date: Created in 22:27 2020/7/13
 * @Modified by:
 */
public class Book {
    private String title;
    private int pageNum;

    public Book() {
    }

    public Book(String title, int pageNum) {
        this.setTitle(title);
        this.setPageNum(pageNum);
    }

    public void detail() {
        System.out.println("书名：" + title + ",页数："+ pageNum);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if(pageNum < 200) {
            System.out.println("页数应不少于200，设定为默认值200");
            this.pageNum = 200;
        } else {
            this.pageNum = pageNum;
        }
    }
}
