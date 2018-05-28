package com.nkodintsov.dataStructures.linkedList;

/**
 * Created by nikolay.odintsov on 28.05.18.
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(int age, String name) {
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
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.getAge());
    }
}
