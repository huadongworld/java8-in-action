package com.ys.java8.test.section8.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void notifyObserver(String tweet);
}
