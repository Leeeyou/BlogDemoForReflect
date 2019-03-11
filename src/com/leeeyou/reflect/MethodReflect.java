package com.leeeyou.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodReflect {
    public static void main(String[] args) {
        MethodReflect methodReflect = new MethodReflect();

        Method[] methods = methodReflect.getClass().getMethods();
        for (Method m : methods) {
            //打印MethodReflect类所有方法，包括接口、父类
            System.out.println(m.toString());
        }

        System.out.println("----");

        Method[] declaredMethods = methodReflect.getClass().getDeclaredMethods();
        for (Method m : declaredMethods) {
            //打印MethodReflect类所有方法，不包括继承关系中的方法
            System.out.println(m.toString());
        }

        System.out.println("----");

        try {
            Method witchCityDoYouLive = methodReflect.getClass().getDeclaredMethod("witchCityDoYouLive", String.class);
            Method cityBusinessCard = methodReflect.getClass().getDeclaredMethod("cityBusinessCard", String.class);
            try {
                witchCityDoYouLive.invoke(null, "shenzhen");//第一个参数null表示该方法是static的
                cityBusinessCard.invoke(methodReflect, "shenzhen");//第一个参数不为null，表示该方法不是static的，代表目标对象
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void witchCityDoYouLive(String cityCode) {
        if (cityCode == null) {
            return;
        }
        switch (cityCode) {
            case "beijing":
                System.out.print("我来自北京，");
                break;
            case "shenzhen":
                System.out.print("我来自深圳，");
                break;
            case "shanghai":
                System.out.print("我来自上海，");
                break;
        }
    }

    public void cityBusinessCard(String cityCode) {
        if (cityCode == null) {
            return;
        }
        switch (cityCode) {
            case "beijing":
                System.out.println("北京是中国的首都!");
                break;
            case "shenzhen":
                System.out.println("深圳是一座创新之城!");
                break;
            case "shanghai":
                System.out.println("上海是一座魔幻之城!");
                break;
        }
    }
}
