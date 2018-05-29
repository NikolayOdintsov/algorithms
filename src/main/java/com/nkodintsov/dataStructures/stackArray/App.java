package com.nkodintsov.dataStructures.stackArray;

/**
 * Created by nikolay.odintsov on 29.05.18.
 */
public class App {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(100);
        myStack.push(1000);

        System.out.println(myStack.size());

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
