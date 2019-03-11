package com.leeeyou.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ArrayReflect {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3};
        int[] a2 = new int[]{4, 5, 6};
        int[][] a3 = new int[2][2];
        String[] s4 = new String[]{"a", "b", "c"};

        System.out.println("a1.getClass() == a2.getClass() = " + (a1.getClass() == a2.getClass()));//字节码比较用==
        System.out.println("a1.getClass().getName() = " + a1.getClass().getName());//[I
        System.out.println("a2.getClass().getName() = " + a2.getClass().getName());//[I
        System.out.println("a3.getClass().getName() = " + a3.getClass().getName());//[[I
        System.out.println("s4.getClass().getName() = " + s4.getClass().getName());//[Ljava.lang.String;
        System.out.println("a1.getClass().getSuperclass().getName() = " + a1.getClass().getSuperclass().getName());//java.lang.Object
        System.out.println("s4.getClass().getSuperclass().getName() = " + s4.getClass().getSuperclass().getName());//java.lang.Object
        System.out.println("Arrays.asList(a1) = " + Arrays.asList(a1));//[[I@4554617c]
        System.out.println("Arrays.asList(s4) = " + Arrays.asList(s4));//[a, b, c]

        System.out.println("-----");

        ArrayReflect ar = new ArrayReflect();
        try {
            Method whichProject = ar.getClass().getDeclaredMethod("whichProject", int[].class);
            try {
                whichProject.invoke(null, a2);//反射调用静态方法，传入数组类型的入参
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void whichProject(int[] projectArray) {
        if (projectArray == null || projectArray.length == 0) {
            return;
        }
        for (int project : projectArray) {
            System.out.println(project);
        }
    }
}
