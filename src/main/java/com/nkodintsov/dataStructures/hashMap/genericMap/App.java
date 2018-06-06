package com.nkodintsov.dataStructures.hashMap.genericMap;

/**
 * Created by nikolay.odintsov on 06.06.18.
 */
public class App {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("1", 1);
        hashTable.put("2", 2);
        hashTable.put("3", 3);
        hashTable.put("4", 4);
        hashTable.put("5", 5);
        hashTable.put("6", 6);
        hashTable.put("7", 7);
        hashTable.put("8", 8);
        hashTable.put("9", 9);
        hashTable.put("10", 10);
        hashTable.put("11", 11);

        System.out.println(hashTable.get("11"));

    }
}
