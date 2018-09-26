package com.ys.java8.test.section8.chain;

public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    //继任者
    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
