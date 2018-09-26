package com.ys.java8.test.section8.observer;

public class ObserverThree implements Observer {

    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("wine")){
            System.out.println("ObserverThree：Today cheese, wine and news! " + tweet);
        }
    }
}
