package com.ys.java8.test.section2;

import com.ys.java8.test.section2.api.ApplePredicate;
import com.ys.java8.test.section2.impl.AppleGreenColorPredicate;
import com.ys.java8.test.section2.impl.AppleHeavyWeightPredicate;
import com.ys.java8.test.section2.model.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class Demo {

    @Test
    public void Demo01() {

        List<Apple> inventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples =
                Section2.filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> heavyApples =
                Section2.filterApples(inventory, new AppleHeavyWeightPredicate());
    }

    /**
     * 阶段六：匿名内部类
     */
    @Test
    public void Demo02() {

        List<Apple> inventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples =
                Section2.filterApples(inventory, new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return "red".equals(apple.getColor());
                    }
                });
        List<Apple> heavyApples =
                Section2.filterApples(inventory, new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return apple.getWeight() <= 150;
                    }
                });
    }

    /**
     * 阶段七：Lambda表达式
     */
    @Test
    public void Demo03() {

        List<Apple> inventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples =
                Section2.filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        List<Apple> heavyApples =
                Section2.filterApples(inventory, (Apple apple) -> 150 >= apple.getWeight());
    }

    /**
     * 阶段八：List类型抽象化（泛型）
     */
    @Test
    public void Demo04() {

    }

    /**
     * 练习：用 Comparator 来排序
     */
    @Test
    public void Demo05() {

        List<Apple> inventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        inventory.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));
        inventory.stream().forEach(System.out::println);

        inventory.sort(comparing(Apple::getWeight));
        inventory.stream().forEach(System.out::println);
    }

}
