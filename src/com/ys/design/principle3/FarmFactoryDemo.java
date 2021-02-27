package com.ys.design.principle3;

/**
 * @author HuaDong
 * @since 2021/2/26 14:28
 */
public class FarmFactoryDemo {
    public static void main(String[] args) {
        FarmFactory farm = new Farming();
        farm.breed(new Dog());
        farm.breed(new Pig());
    }
}
