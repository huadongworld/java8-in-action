package com.ys.java8.test.section8.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver(String tweet) {
        observers.forEach(observer -> observer.notify(tweet));
    }

}
