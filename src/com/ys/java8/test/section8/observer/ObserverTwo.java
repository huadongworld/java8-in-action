package com.ys.java8.test.section8.observer;

public class ObserverTwo implements Observer {

    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")){
            System.out.println("ObserverTwo：Yet another news in London... " + tweet);
        }
    }
}
