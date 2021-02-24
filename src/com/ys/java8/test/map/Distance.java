package com.ys.java8.test.map;

import java.math.BigDecimal;

/**
 * @author HuaDong
 * @since 2021/1/26 9:51
 */
public class Distance {

    private Long id;

    private BigDecimal distance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Distance(Long id, BigDecimal item) {
        this.id = id;
        this.distance = item;
    }
}
