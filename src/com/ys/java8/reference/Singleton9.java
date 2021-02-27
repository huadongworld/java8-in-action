package com.ys.java8.reference;

/**
 * @author HuaDong
 * @date 2020/3/8 17:09
 */
public class Singleton9 {

    private Singleton9() {

    }

    private enum SingletonEnum {

        /**
         * 枚举单例
         */
        SINGLETON;

        private Singleton9 singleton;

        SingletonEnum() {
            singleton = new Singleton9();
        }

        public Singleton9 getInstance() {
            return singleton;
        }
    }

    public Singleton9 getInstance() {
        return SingletonEnum.SINGLETON.getInstance();
    }
}
