package com.nkodintsov.dataStructures.hashMap.chaining;

/**
 * Created by nikolay.odintsov on 06.06.18.
 */
public class App {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(1, 10);
        hashTable.put(2, 100);
        hashTable.put(3, 1000);
        hashTable.put(4, 10000);
        hashTable.put(5, 10000);
        hashTable.put(6, 10000);
        hashTable.put(7, 10000);
        hashTable.put(8, 10000);
        hashTable.put(9, 10000);
        hashTable.put(10, 10000);
        hashTable.put(11, 10000);


        System.out.println(hashTable.get(4));

//        hashTable.put(4, 5);

//        System.out.println(hashTable.get(4));
    }
}
