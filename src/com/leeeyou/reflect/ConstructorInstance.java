package com.leeeyou.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by leeeyou on 2019/3/10.
 */
public class ConstructorInstance {
    public static void main(String[] args) {
        try {
            Object strObj = Class.forName("java.lang.String").newInstance();
            if (strObj instanceof String) {
                System.out.println("yes! an object of type String is created");
            }
            System.out.println("--------");

            try {
                Constructor<?> constructor = Class.forName("java.lang.String").getConstructor(StringBuffer.class);
                Object shenZhen = constructor.newInstance(new StringBuffer("shenZhen"));
                if (shenZhen instanceof String) {
                    System.out.println("yes! an object of type String is created");
                    String shenzhenString = (String) shenZhen;//强制转换成String类型
                    System.out.println(shenzhenString);
                }
            } catch (NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
