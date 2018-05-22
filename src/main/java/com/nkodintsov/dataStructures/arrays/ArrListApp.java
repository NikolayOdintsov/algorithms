package com.nkodintsov.dataStructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay.odintsov on 22.05.18.
 */
public class ArrListApp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);

        list.add("Adam");
        list.add("Joe");
        list.add("Kevin");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
