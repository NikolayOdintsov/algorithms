package com.nkodintsov.dataStructures.stackArray;

/**
 * Created by nikolay.odintsov on 29.05.18.
 */
public class Stack<T> {

    private T[] stack;
    private int numOfItems;

    public Stack() {
        this.stack = (T[]) new Object[1];
    }

    //O(1) if no resize
    public void push(T newData) {
        if (this.numOfItems == this.stack.length) {
            resize(2 * this.stack.length);
        }

        this.stack[numOfItems++] = newData;
    }

    //O(1) if no resize
    public T pop() {
        T itemToPop = this.stack[--numOfItems];
        this.stack[numOfItems] = null;

        if (numOfItems > 0 && numOfItems == this.stack.length / 4) {
            resize(this.stack.length / 2);
        }

        return itemToPop;
    }

    public boolean isEmpty() {
        return this.numOfItems == 0;
    }

    public int size() {
        return this.numOfItems;
    }

    //O(n)
    private void resize(int capacity) {
        T[] stackCopy = (T[]) new Object[capacity];
        for (int i = 0; i < numOfItems; i++) {
            stackCopy[i] = this.stack[i];
        }

        this.stack = stackCopy;
    }
}
