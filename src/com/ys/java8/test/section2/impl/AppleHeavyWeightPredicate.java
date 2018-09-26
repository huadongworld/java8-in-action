package com.ys.java8.test.section2.impl;

import com.ys.java8.test.section2.model.Apple;
import com.ys.java8.test.section2.api.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
