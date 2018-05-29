package com.nkodintsov.dataStructures.queue;

/**
 * Created by nikolay.odintsov on 29.05.18.
 */
public class App {

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(10);
        myQueue.enqueue(100);
        myQueue.enqueue(1000);

        System.out.println(myQueue.size());

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
