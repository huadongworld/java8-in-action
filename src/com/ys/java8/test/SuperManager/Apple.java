package com.ys.java8.test.SuperManager;

/**
 * @author HD
 */
public class Apple {

    private String name;
    private Long weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Apple() {
    }

    public Apple(String name, Long weight) {

        this.name = name;
        this.weight = weight;
    }
}
