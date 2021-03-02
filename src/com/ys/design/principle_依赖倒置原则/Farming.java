package com.ys.design.principle_依赖倒置原则;

/**
 * @author HuaDong
 * @since 2021/2/26 14:29
 */
public class Farming implements FarmFactory {
    @Override
    public void breed(Animal animal) {
        System.out.println("农场饲养：" + animal.getAnimalName());
    }
}
