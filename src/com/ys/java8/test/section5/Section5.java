package com.ys.java8.test.section5;

import com.ys.java8.test.section6.Trader;
import com.ys.java8.test.section6.Transaction;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * 第五章 使用流
 */
public class Section5 {

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

    /**
     * 筛选和切片
     */
    @Test
    public void Demo01(){

        //菜单流
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        //数值流
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        //截短流
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        //跳过元素
        List<Dish> dishes1 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }

    /**
     * 映射
     */
    @Test
    public void Demo02() {

        //获取菜单名
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        //菜单名长度
        List<Integer> dishNameLength = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        //获取所有字符串数组的长度
        List<String> words = Arrays.asList("java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        //获取所有字符串所用到的字符
        List<String[]> uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .distinct()
                .collect(toList());
        uniqueCharacters.forEach(System.out::println);

        //流的扁平化 flatMap
        List<String> uniqueFlatCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        uniqueFlatCharacters.forEach(System.out::println);

        //映射练习
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(toList());

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i,j})
                    )
                .collect(toList());

        List<Integer> numbers01 = Arrays.asList(1, 2, 3);
        List<Integer> numbers02 = Arrays.asList(4, 5);
        List<int[]> pairs0 = numbers01.stream()
                .flatMap(i -> numbers02.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
    }

    /**
     * 查找和匹配
     */
    @Test
    public void Demo03() {

        //以下三个操作都用到了“短路”操作
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("has vegetarian!");
        }

        Boolean isHealth = menu.stream().allMatch(d -> d.getCalories() < 1000);

        Boolean isHealth1 = menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        //dish.isPresent();optional包含值true，不包含值false
        //dish.ifPresent(Consumer<T> block);值存在时执行一个代码块
        //dish.get();值存在时返回值，否则抛出一个NoSuchElement异常
        //dish.orElse(T other);值存在时返回值，否则返回一个默认值
        Optional<Dish> dish1 = menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst();

        /**
         * Optional 部分语法
         */
        Boolean hasValue = dish1.isPresent();//isPresent 有值返回true,~
        dish1.ifPresent(System.out::println);//ifPresent 有值的话执行括号里的代码块（此处为输出）
        Dish dish2 = dish1.get();// get 值存在时返回值，否则抛出NoSuchElement异常
        Dish dish3 = dish1.orElse(null);//orElse 值存在时返回值，否则返回other
    }

    /**
     * 归约 reduce
     */
    @Test
    public void Demo04() {

        /**
         * findFirst 和 findAny 的区别？ 并行，尽量使用findAny，findFirst在并行上限制很多
         */
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //求和
        int num = numbers.stream().reduce(0, (a, b) -> a + b);
        Optional<Integer> optional = numbers.stream().reduce((a, b) -> a + b);//reduce 另一种重载的变体

        int num1 = numbers.stream().reduce(0, Integer::sum);

        //最大值最小值
        Optional<Integer> max = numbers.stream().reduce((a, b) -> a > b ? a : b);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        //计算menu中有几个菜
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);
        int count1 = menu.stream()
                .collect(reducing(0, d -> 1, Integer::sum));
        System.out.println(count1);

    }

    /**
     * 流 实战
     */
    public void Demo05() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        Optional<Transaction> minTran = transactions
                .stream()
//                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
                .min(comparing(Transaction::getValue));

        Optional<Integer> sumValueInCambridge = transactions
                .stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(sumValueInCambridge.orElse(0));

        Boolean areaInMilan = transactions
                .stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));

        String names1 = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .distinct()
                .reduce("", (a, b) -> a + b);

        List<Trader> tradersInCambridge = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(comparing(Trader::getName))
                .collect(toList());

        List<Transaction> transactionsIn2011 = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        List<String> area = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        //找出2011年发生的所有交易，并按交易额排序
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getYear))
                .collect(toList());

        //交易员都在哪些不同的地方工作过
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        //或者
        Set<String> cites1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        //查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .collect(toList());

        //返回所有交易员的姓名字符串，按字母排序
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (s1, s2) -> s1 + s2);

        //以上拼接字符串的方式并不高效，一下是改进方案
        String names2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()                      )
                .distinct()
                .sorted()
                .collect(joining());

        //有没有交易员在米兰工作的？
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("milan"));

        //打印所有生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //所有的交易中，最高的交易额是多少？
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        //找到交易额最小的交易
        Optional<Transaction> smallestValue = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        //或者（流支持max和min方法）
        Optional<Transaction> smallestValue1 = transactions.stream()
                .min(comparing(Transaction::getValue));

    }

    /**
     * 流 实战（自测）
     */
    public void Demo05_1() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年发生的所有交易，并按交易额排序
        List<Transaction> transactionList = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        //交易员都在哪些不同的地方工作过
        List<String> areas = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        //或者
        Set<String> cites1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        //查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getName().equals("Cambridge"))
                .sorted()
                .collect(toList());


        //返回所有交易员的姓名字符串，按字母排序
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        //以上拼接字符串的方式并不高效，一下是改进方案
        String names1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        //有没有交易员在米兰工作的？
        Boolean isTrader = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("milan"));

        //打印所有生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //所有的交易中，最高的交易额是多少？
        Optional<Integer> value = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        //找到交易额最小的交易
        Optional<Transaction> transaction = transactions.stream()
                .reduce((t1, t2) -> (t1.getValue() < t2.getValue() ? t1 : t2));

        //或者（流支持max和min方法），
        Optional<Transaction> smallestValue1 = transactions.stream()
                .min(comparing(Transaction::getValue));

    }

    /**
     * 数值流、特化流
     */
    @Test
    public void Demo06() {

        //效率低、要进行拆箱或装箱操作
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        //使用特化流(IntStream)
        int calories1 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        //特化数值流和转换回对象流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> integerStream = intStream.boxed();//（装箱）

        //求最大值
        OptionalInt maxCalorie = menu.stream().mapToInt(Dish::getCalories).max();

        //如果没有最大值默认提供一个，maxCalorie有值直接返回值，没值返回默认值
        int max = maxCalorie.orElse(1);

        //range和rangeClosed
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);

    }

    /**
     * 数值流应用，求勾股数
     */
    @Test
    public void Demo07() {

        //筛选成立的组合
        //filter(b -> Math.sqrt(a*a + b*b) % 1 == 0);

        //生成三元组：
        //stream.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
        //      .map(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)});

        //生成b的值
        //IntStream.rangeClosed(1,100)
        //      .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
        //      .boxed() //map会为流中的每个元素返回一个int数组，而IntStream中的map方法只能为每个流中的每个元素返回另一个int
        //      .map(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)});

        //返回一个对象流的值（和上面等价）
        //IntStream.rangeClosed(1, 100)
        //      .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
        //      .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)});

        //生成值
        Stream<int[]> goGus = IntStream.rangeClosed(1, 100)
                .boxed()//将数值流装箱成为一个一般流时
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        goGus.forEach(g -> System.out.println("[" + g[0] + "," + g[1] + "," + g[2] + "]"));

        //以上方式还可做优化（上面的需要求两次平方根，效率偏低）
        Stream<double[]> goGus1 = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)
                );

        goGus1.forEach(g -> System.out.println("[" + g[0] + "," + g[1] + "," + g[2] + "]"));

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);
    }

    /**
     * 构建流
     */
    @Test
    public void Demo08() {

        //由值创建流
        Stream<String> stream = Stream.of("java8", "Lambda", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //由数组创建流
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        IntStream integerStream = Arrays.stream(numbers);
        int sum = integerStream.sum();

        try (Stream<String> lines = Files.lines(Paths.get("C:/Users/lenovo/Desktop/data.txt"), Charset.defaultCharset())) {
            long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .count();
            System.out.println("data.txt中不同的英文字母共有：" + uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //由函数生成流：创建无限流 iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        //斐波那契数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        // generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //generate版 斐波那契数列
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {

                int oldPrevious = this.previous;
                int nextValue = this.current + this.previous;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib)
                .limit(20)
                .forEach(System.out::println);
    }

    @Test
    public void Demo09() {

        Optional<Dish> dish = Optional.ofNullable(null);
        System.out.println(dish.map(Dish::getType).orElse(Dish.Type.FISH));

        List<String> strings = Arrays.asList("a", "bc", "def", "ghij");
        strings.stream()
                .map(String::length)
                .reduce(0, (a, b) -> a + b);

    }

}
