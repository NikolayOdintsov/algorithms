package com.nkodintsov.dataStructures.linkedList;

/**
 * Created by nikolay.odintsov on 28.05.18.
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(100);

        System.out.println(list.size());
        list.traverseList();

        System.out.println();
        list.remove(10);
        list.traverseList();


        System.out.println();
        List<Person> personList = new LinkedList<Person>();
        personList.insert(new Person(10, "Adam"));
        personList.insert(new Person(22, "Joe"));
        personList.insert(new Person(1, "Kevin"));
        personList.insert(new Person(45, "Michael"));
        personList.traverseList();
    }
}
