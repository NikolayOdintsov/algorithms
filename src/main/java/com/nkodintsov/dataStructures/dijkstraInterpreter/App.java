package com.nkodintsov.dataStructures.dijkstraInterpreter;

/**
 * Created by nikolay.odintsov on 29.05.18.
 */
public class App {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.interpretExpression("( ( 1 + 2 ) * ( 2 + 1 ) )");

        algorithm.result();
    }
}
