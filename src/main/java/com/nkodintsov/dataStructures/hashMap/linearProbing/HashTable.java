package com.nkodintsov.dataStructures.hashMap.linearProbing;


/**
 * Created by nikolay.odintsov on 06.06.18.
 */
public class HashTable {
    private HashItem[] hashTable;

    public HashTable() {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public int get(int key) {
        int generatedArrayIndex = hash(key);

        while (hashTable[generatedArrayIndex] != null && hashTable[generatedArrayIndex].getKey() != key) {
            generatedArrayIndex = (generatedArrayIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Hoping to the next index: " + generatedArrayIndex);
        }

        if (hashTable[generatedArrayIndex] == null) {
            return -1;
        } else {
            return hashTable[generatedArrayIndex].getValue();
        }
    }

    public void put(int key, int value) {
        int hashArrayIndex = hash(key);

        System.out.println("Put called for value: " + value + " and index: " + hashArrayIndex);

        while (hashTable[hashArrayIndex] != null) {
            hashArrayIndex = (hashArrayIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Collision -> next index: " + hashArrayIndex);
        }

        hashTable[hashArrayIndex] = new HashItem(key, value);
    }

    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }
}
