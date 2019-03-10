package com.leeeyou.reflect;

import java.lang.reflect.Field;

/**
 * Created by leeeyou on 2019/3/10.
 */
public class FieldValue {
    public static void main(String[] args) {
        Point point = new Point("x:10.1", "y:0.99");
        try {
            Field filedX = point.getClass().getDeclaredField("x");
            Field filedZ = point.getClass().getDeclaredField("z");//获取声明的属性，不管什么修饰符
            try {
                filedZ.setAccessible(true);//设置可访问
                System.out.println("获取静态属性变量的值：" + filedZ.get(null));//获取静态属性的值，传入null正常

                filedX.setAccessible(true);
                //System.out.println(filedX.get(null));//获取非静态属性的值，传入null不正常，NullPointerException
                System.out.println("获取私有属性变量的值：" + filedX.get(point));

                //接着修改x的值为x:200.1
                filedX.set(point, "x:200.1");
                System.out.println("反射修改后的值，filedX.get(point) = " + filedX.get(point));
                System.out.println("反射修改后的值，point.getX() = " + point.getX());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
