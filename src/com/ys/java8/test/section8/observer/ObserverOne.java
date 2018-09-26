package com.ys.java8.test.section8.observer;

public class ObserverOne implements Observer {

    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("ObserverOne：Breaking news in NY! " + tweet);
        }
    }
}
