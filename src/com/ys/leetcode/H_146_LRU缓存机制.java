package com.ys.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author HuaDong
 * @date 2021/6/6 16:17
 */
public class H_146_LRU缓存机制 {

    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return  super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }
}
