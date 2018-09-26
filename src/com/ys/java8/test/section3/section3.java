package com.ys.java8.test.section3;

import com.ys.java8.test.section2.model.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class section3 {

    @Test
    public void Demo01() {

        List<Apple> inventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        inventory.forEach(System.out::println);
    }

    /**
     * 方法引用
     */
    @Test
    public void Demo02() {

        List<String> str = Arrays.asList("a","b","A","B");

        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        str.forEach(System.out::println);

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger1 = Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains1 = List::contains;

    }

    /**
     * 构造函数方法引用
     */
    @Test
    public void Demo03() {

        Supplier<Apple> newApple = Apple::new;
        Apple apple = newApple.get();

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);//注意调用的构造函数是哪个？
        // 当需要调用两个参数的构造函数用哪个函数式接口呢？三个呢？

        apples.stream().forEach(System.out::println);

        /**
         * 比较器复合 reversed、then
         */
        apples.sort(comparing(Apple::getWeight));//正序
        apples.sort(comparing(Apple::getWeight).reversed());//逆序

        apples.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor)
        );//两个苹果一样大时按颜色字符串排序

        /**
         * 谓词复合negate、and、or
         */
        Predicate<Apple> redApple = a -> "red".equals(a.getColor());//红苹果
        Predicate<Apple> notRedApple = redApple.negate();//不是红苹果
        Predicate<Apple> redAndHeavyApple = redApple.and(
                a -> a.getWeight() > 150
        );//又大又红的苹果
        Predicate<Apple> redAndHeavyOrGreenApple = redAndHeavyApple
                .or(a -> "green".equals(a.getColor()));//或者

        /**
         * 函数复合andThen、compose
         */
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){

        List<Apple> result = new ArrayList<>();
        for(Integer e: list){
            result.add(f.apply(e));
        }

        return result;
    }
}
