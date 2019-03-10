package com.leeeyou.reflect;

/**
 * Created by leeeyou on 2019/3/10.
 */
public class ConstructorList {
    public static void main(String[] args) {
        try {
            //得到所有的构造函数
            java.lang.reflect.Constructor<?>[] constructors = Class.forName("java.lang.String").getConstructors();
            for (java.lang.reflect.Constructor<?> c : constructors) {
                System.out.println(c.toString());
            }
            System.out.println("------------");

            //得到特定的构造函数
            try {
                java.lang.reflect.Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
                System.out.println(constructor.toString());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
