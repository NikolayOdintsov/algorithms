package com.nkodintsov.dataStructures.dijkstraInterpreter;

import java.util.Stack;

/**
 * Created by nikolay.odintsov on 29.05.18.
 */
public class Algorithm {
    private Stack<String> operationsStack;
    private Stack<Double> valueStack;

    public Algorithm() {
        this.operationsStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        String[] expressionArray = expression.split(" ");
        for (String s : expressionArray) {
            if (s.equals("(")) {
                //do nothing
            } else if (s.equals("+")) {
                this.operationsStack.push(s);
            } else if (s.equals("*")) {
                this.operationsStack.push(s);
            } else if (s.equals(")")) {

                String operation = this.operationsStack.pop();

                if (operation.equals("+")) {
                    this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
                } else if (operation.equals("*")) {
                    this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
                }

            } else {
                this.valueStack.push(Double.parseDouble(s));
            }
        }
    }

    public void result() {
        System.out.println(this.valueStack.pop());
    }
}
