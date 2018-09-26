package com.ys.java8.test.section2;

import com.ys.java8.test.section2.api.ApplePredicate;
import com.ys.java8.test.section2.model.Apple;

import java.util.ArrayList;
import java.util.List;

public class Section2 {

    /**
     * 阶段一：筛选绿苹果
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 阶段二：筛选某种颜色的苹果
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 阶段三：筛选大于某个重量的苹果
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 阶段四：组合筛选
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 阶段五：行为参数化
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}