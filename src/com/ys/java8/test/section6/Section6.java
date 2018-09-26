package com.ys.java8.test.section6;

import com.ys.java8.test.section5.CaloricLevel;
import com.ys.java8.test.section5.Dish;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * 第六章 用流收集数据
 */
public class Section6 {

    /**
     * 预定义收集器提供的三大功能：
     * 将流元素归约和汇总为一个值
     * 元素分组
     * 元素分区
     */
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    //归约和汇总
    @Test
    public void Demo01() {

        long howManyDishes = menu.stream().collect(counting());
        //或者
        long howManyDishes1 = menu.stream().count();

        //定义比较器
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        //筛选出最大热量的菜
        Optional<Dish> mostCaloriesDish = menu.stream()
                .collect(maxBy(dishComparator));

        Optional<Dish> dishOptional = menu
                .stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));

        //summingInt接收一个int函数，并返回一个收集器
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        double avgCalories = menu.stream().collect(averagingDouble(Dish::getCalories));

        //一次性返回所有
        IntSummaryStatistics intSummaryStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        //连接字符串joining
        String menus = menu.stream()
                .map(Dish::getName)
                .collect(joining());
        System.out.println(menus);
        String menus1 = menu.stream()
                .map(Dish::getName)
                .collect(joining(","));
        System.out.println(menus1);

        /**
         * reducing（以上情况的收集器，都可以通过它来实现）
         * 它需要三个参数。
         * 初始值：第一个参数是归约操作的起始值，也是流中没有元素时的返回值，所以很显然对于数值和而言0是一个合适的值。
         * 转换函数：第二个参数就是你在6.2.2节中使用的函数，将菜肴转换成一个表示其所含热量的int。
         * 累计函数：第三个参数是一个BinaryOperator，将两个项目累积成一个同类型的值。这里它就是对两个int求和。
         */
        int totalCalories1 = menu.stream().collect(reducing(0,
                Dish::getCalories,
                Integer::sum));

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
//                    System.out.println("l" + l.size());
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {
//                    System.out.println("l1" + l1.size());
//                    System.out.println("l2" + l2.size());
                    l1.addAll(l2);
                    return l1;
                }
        );
//        System.out.println("-------------");
//        for (Integer n : numbers) {
//            System.out.println(n);
//        }
//        System.out.println("-------------");

    }

    /**
     * 分组
     */
    @Test
    public void Demo02() {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        //复杂的分组可以写成lambda表达式
        Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })
        );

        //多级分组，使用groupingBy第二个参数
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }))
                );

        //传递给第一个groupingBy的第二个收集器可以是任何类型
        Map<Dish.Type, Long> typeLongMap = menu.stream().collect(
                groupingBy(Dish::getType, counting())
        );

        //注意：普通的单参数groupingBy(f)（其中f是分类函数）实际上是groupingBy(f, toList())的简便写法

        //把收集器的结果转换为另一种类型 collectingAndThen
        //原先：
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparing(Dish::getCalories))));
        //结果：{FISH=Optional[salmon], OTHER=Optional[pizza], MEAT=Optional[pork]}

        //之后：
        Map<Dish.Type, Dish> mostCaloricByType1 =
                menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(//接收两个参数，要转换的收集器和转换函数，并返回另一个收集器
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get
                        )));
        //结果：{FISH=salmon, OTHER=pizza, MEAT=pork}

        //和groupingBy联合使用的另一个收集器是mapping方法生成的
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType =
                menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping(//接收两个参数，一个函数
                                dish -> {
                                    if (dish.getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return CaloricLevel.NORMAL;
                                    else
                                        return CaloricLevel.FAT;
                                },
                                toSet()//为了保留不同的值
                        ))
                );
    }

    /**
     * 分区
     */
    @Test
    public void Demo03() {
        //分区是分组的特殊情况：由一个谓词（返回一个布尔值的函数）作为分类函数，它称分区函数，key即boolean值，使用partitioningBy
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));

        //第二个参数：二级Map
        Map<Boolean, Map<Dish.Type, List<Dish>>> partitionedMenu1 =
                menu.stream().collect(partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getType)));

        //得到素食和非素食中热量最高的菜
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get
                                ))
                );
        System.out.println(mostCaloricPartitionedByVegetarian);
        System.out.println(partitionPrimes(100));
    }

    /**
     * 将数字按质数和非质数分区之判断某个数是否是质数
     */
    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)//产生一个自然数
                .noneMatch(i -> candidate % i == 0);//除以所有比他小的数，如果都满足则是质数
    }

    /**
     * 将数字按指数和非质数分区
     */
    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate))
                );
    }

}
