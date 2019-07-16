package com.ys.java8.test.tag;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @author HuaDong
 * @date 2019/7/17 7:28
 */
public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
