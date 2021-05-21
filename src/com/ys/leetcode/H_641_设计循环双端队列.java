package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/21 17:19
 */
public class H_641_设计循环双端队列 {

    /**
     * 数组实现双端队列
     */
    class MyCircularDeque {

        private int[] elements;
        private int size;

        public MyCircularDeque(int k) {
            elements = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            System.arraycopy(elements, 0, elements, 1, size);
//            for (int i = size - 1; i >= 0; i--) {
//                elements[i + 1] = elements[i];
//            }
            elements[0] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            elements[size] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            System.arraycopy(elements, 1, elements, 0, size - 1);
//            for (int i = 0; i < size - 1; i++) {
//                elements[i] = elements[i + 1];
//            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            elements[size - 1] = 0;
            size--;
            return true;
        }

        public int getFront() {
            return size == 0 ? -1 : elements[0];
        }

        public int getRear() {
            return size == 0 ? -1 : elements[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == elements.length;
        }
    }

    /**
     * 使用链表实现双端队列
     */
    class MyCircularDeque2 {
        private int capacity;
        private int size;
        private Node firstNode;
        private Node lastNode;

        class Node {
            int value;
            Node next;
            Node prev;

            Node(int value) {
                this.value = value;
            }
        }

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque2(int k) {
            capacity = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            Node node = new Node(value);
            node.next = firstNode;
            if (firstNode != null) {
                firstNode.prev = node;
            }
            firstNode = node;
            if (lastNode == null) {
                lastNode = node;
            }
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Node node = new Node(value);
            node.prev = lastNode;
            if (lastNode != null) {
                lastNode.next = node;
            }
            lastNode = node;
            if (firstNode == null) {
                firstNode = node;
            }
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            Node next = firstNode.next;
            if (next != null) {
                next.prev = null;
                firstNode.next = null;
            } else {
                lastNode = null;
            }
            firstNode = next;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            Node pre = lastNode.prev;
            if (pre != null) {
                pre.next = null;
                lastNode.prev = null;
            } else {
                firstNode = null;
            }
            lastNode = pre;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return firstNode == null ? -1 : firstNode.value;
        }

        /**
         * Get the lastNode item from the deque.
         */
        public int getRear() {
            return lastNode == null ? -1 : lastNode.value;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (isEmpty()) {
                sb.append("This deque is empty");
                return sb.toString();
            }
            Node p = firstNode;
            for (int i = 0; i < size; i++) {
                sb.append("[").append(p.value).append("]");
                p = p.next;
            }
            sb.append(", firstNode == ").append(getFront())
                    .append(", lastNode == ").append(getRear())
                    .append(", size == ").append(size);
            return sb.toString();
        }
    }
}
