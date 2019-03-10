package com.leeeyou.reflect;

/**
 * Created by leeeyou on 2019/3/10.
 */
public class Point {
    public Point(String x, String y) {
        this.x = x;
        this.y = y;
    }

    private static String z = "z:135";

    private String x;
    private String y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
