package com.kkb.chapter03.Demo10201002;

/**
 * @Description: 2. 通过类描述开课吧的 Java 学员。
 * 具有属性： 姓名，年龄，性别，爱好，公司（都是：开课吧），学科（都
 * 是：Java 学科）。
 * 思考：请结合 static 修饰属性进行更好的类设计。
 * @Author: Du Junnan
 * @Date: Created in 9:07 2020/7/14
 * @Modified by:
 */
public class KkbStudent {

    private String name;//姓名
    private int age;//年龄
    private String gender;//性别
    private String hobby;//爱好
    private static String office = "开课吧";
    private static String subject = "Java学科";

    public KkbStudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 120) {
            System.out.println("设定的年龄有误，设置为默认值18");
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender != "男" || gender != "女") {
            System.out.println("输入的性别有误，设置为默认值：男");
            this.gender = "男";
        } else {
            this.gender = gender;
        }
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public static String getOffice() {
        return office;
    }

    public static String getSubject() {
        return subject;
    }
}
