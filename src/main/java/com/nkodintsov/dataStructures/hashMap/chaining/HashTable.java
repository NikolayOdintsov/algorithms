package com.nkodintsov.dataStructures.hashMap.chaining;

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
        if (hashTable[generatedArrayIndex] == null) {
            return -1;
        } else {
            HashItem hashItem = hashTable[generatedArrayIndex];
            while (hashItem != null && hashItem.getKey() != key) {
                hashItem = hashItem.getNextHashItem();
            }

            if (hashItem == null) {
                return -1;
            } else {
                return hashItem.getValue();
            }
        }
    }

    public void put(int key, int value) {
        int hashArrayIndex = hash(key);

        if (hashTable[hashArrayIndex] == null) {

            System.out.println("No collision case with key: " + key);
            hashTable[hashArrayIndex] = new HashItem(key, value);
        } else {

            System.out.println("Collision case with key: " + key);
            HashItem hashItem = hashTable[hashArrayIndex];
            while (hashItem.getNextHashItem() != null) {
                hashItem = hashItem.getNextHashItem();
                System.out.println("Linked list case for value: " + hashItem.getValue());
            }

            hashItem.setNextHashItem(new HashItem(key, value));

        }
    }

    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }
}
