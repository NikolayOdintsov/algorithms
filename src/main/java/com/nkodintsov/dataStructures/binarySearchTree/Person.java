package com.nkodintsov.dataStructures.binarySearchTree;

/**
 * Created by nikolay.odintsov on 30.05.18.
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
//        return this.name.compareTo(person.getName());
//        return age - person.getAge();
        return -(age - person.getAge());
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
