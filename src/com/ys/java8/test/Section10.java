package com.ys.java8.test;

import com.ys.java8.test.section10.Car;
import com.ys.java8.test.section10.Insurance;
import com.ys.java8.test.section10.Person;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class Section10 {

    /**
     * 创建Optional对象
     */
    @Test
    public void Demo01() {

        //静态工厂方法empty()
        Optional<Car> optCar = Optional.empty();
        System.out.println(optCar);

        //依据一个非空值创建，car为空抛出空指针异常
        Car car = new Car();
        Optional<Car> optCar1 = Optional.of(car);
        System.out.println(optCar1);

        //可接受null的Optional，car1为空得到空对象
        Car car1 = null;
        Optional<Car> optCar2 = Optional.ofNullable(car1);
        System.out.println(optCar2);
    }

    @Test
    public void Demo02() {

        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        Person person = new Person();
        Optional<Person> optPerson = Optional.ofNullable(null);
        System.out.println(getCarInsuranceName(optPerson));
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    @Test
    public void Demo03() {

        //如果为null将不会执行equals操作
        Optional<Insurance> optional = Optional.ofNullable(new Insurance());
        optional.filter(insurance -> "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x -> System.out.println("ok"));
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(person1 -> person1.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public static Optional<Integer> stringToInt(String s) {

        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * 练习
     */
    @Test
    public void Demo04() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDuration(props, "a"));
        assertEquals(0, readDuration(props, "b"));
        assertEquals(0, readDuration(props, "c"));
        assertEquals(0, readDuration(props, "d"));
    }

    /**
     * 原始做法
     * @param props
     * @param name
     * @return
     */
    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) { }
        }
        return 0;
    }

    /**
     * 运用Optional
     * @param props
     * @param name
     * @return
     */
    public int readDuration1(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(Section10::stringToInt)//上面定义的方法
                .filter(i -> i > 0)
                .orElse(0);
    }

}
