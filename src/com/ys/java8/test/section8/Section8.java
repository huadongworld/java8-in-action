package com.ys.java8.test.section8;

import com.ys.java8.test.section8.chain.HeaderTextProcessing;
import com.ys.java8.test.section8.chain.ProcessingObject;
import com.ys.java8.test.section8.chain.SpellCheckerProcessing;
import com.ys.java8.test.section8.observer.Feed;
import com.ys.java8.test.section8.observer.ObserverOne;
import com.ys.java8.test.section8.observer.ObserverThree;
import com.ys.java8.test.section8.observer.ObserverTwo;
import com.ys.java8.test.section8.strategy.IsAllLowerCase;
import com.ys.java8.test.section8.strategy.IsNumeric;
import com.ys.java8.test.section8.strategy.Validator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Section8 {

    /**
     * 策略模式
     */
    @Test
    public void Demo01() {

        // 原始实现
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("115o23");
        System.out.println(b1);
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbbbbb");
        System.out.println(b2);

        // Lambda实现（两个策略实现类都不用写了）
        Validator lowerCaseValidatorLambda = new Validator((String s) -> s.matches("\\d+"));
        Boolean b3 = lowerCaseValidatorLambda.validate("115o23");
        System.out.println(b3);
        Validator numericValidatorLambda = new Validator((String s) -> s.matches("[a-z]+"));
        Boolean b4 = numericValidator.validate("aaaaaaa");
        System.out.println(b4);

    }

    /**
     * 观察者模式
     */
    @Test
    public void Demo02() {

        //原始实现
        Feed feed = new Feed();
        feed.registerObserver(new ObserverOne());
        feed.registerObserver(new ObserverTwo());
        feed.registerObserver(new ObserverThree());
        feed.notifyObserver("The queen said her favourite book is Java 8 in Action!");

        //Lambda实现（观察者具体实现类都不用写了）
        Feed feed1 = new Feed();
        feed1.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Lambda--------> ObserverOne：Breaking news in NY! " + tweet);
            }
        });
        feed1.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Lambda--------> ObserverTwo：Yet another news in London... " + tweet);
            }
        });
        feed1.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("wine")){
                System.out.println("Lambda--------> ObserverThree：Today cheese, wine and news! " + tweet);
            }
        });
        feed1.notifyObserver("The queen and wine said her favourite book is Java 8 in Action!");

    }

    /**
     * 责任链模式
     */
    @Test
    public void Demo03() {

        //原始实现
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        //Lambda表达式
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        System.out.println(pipeline.apply("Aren't labdas really sexy?!!"));

    }

    /**
     * 使用日志调试
     */
    @Test
    public void Demo04() {

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        List<Integer> result =
                numbers.stream()
                        .peek(x -> System.out.println("from stream: " + x))
                        .map(x -> x + 17)
                        .peek(x -> System.out.println("after map: " + x))
                        .filter(x -> x % 2 == 0)
                        .peek(x -> System.out.println("after filter: " + x))
                        .limit(3)
                        .peek(x -> System.out.println("after limit: " + x))
                        .collect(Collectors.toList());

    }
}
