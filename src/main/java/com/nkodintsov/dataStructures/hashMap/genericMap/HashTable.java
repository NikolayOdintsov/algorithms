package com.nkodintsov.dataStructures.hashMap.genericMap;

/**
 * Created by nikolay.odintsov on 06.06.18.
 */
public class HashTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int numOfItems;
    private int capacity; //max number of items that can be inserted in the table: numOfItems <= capacity

    public HashTable() {
        this.keys = (Key[]) new Object[Constant.TABLE_SIZE];
        this.values = (Value[]) new Object[Constant.TABLE_SIZE];
        this.capacity = Constant.TABLE_SIZE;
        this.numOfItems = 0;
    }

    public HashTable(int newCapacity) {
        this.keys = (Key[]) new Object[newCapacity];
        this.values = (Value[]) new Object[newCapacity];
        this.capacity = newCapacity;
        this.numOfItems = 0;
    }

    //O(1)
    public int size() {
        return this.numOfItems;
    }

    //O(1)
    public boolean isEmpty() {
        return this.numOfItems == 0;
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            return;
        }

        if (this.numOfItems >= this.capacity * 0.75) { //O(1) -> O(n)
            System.out.println("Resizing the table * 2");
            resize(2 * this.capacity);
        }

        int index = hash(key);
        while (keys[index] != null) {
            //update
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            index = (index + 1) % this.capacity;
        }

        //insert
        keys[index] = key;
        values[index] = value;
        this.numOfItems++;
    }

    public void remove(Key key) {
        if (key == null) {
            return;
        }

        int index = hash(key);
        while (!keys[index].equals(key)) {
            index = (index + 1) % this.capacity;
        }

        keys[index] = null;
        values[index] = null;

        while (keys[index] != null) {
            Key tempKey = keys[index];
            Value tempValue = values[index];

            keys[index] = null;
            values[index] = null;

            numOfItems--;
            put(tempKey, tempValue);
            index = (index + 1) % capacity;
        }

        numOfItems--;

        if (numOfItems <= capacity / 3) {
            System.out.println("Resizing the table / 2");
            resize(capacity / 2);
        }
    }

    //O(n)
    private void resize(int newCapacity) {
        HashTable<Key, Value> newHashTable = new HashTable<>(newCapacity);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newHashTable.put(keys[i], values[i]);
            }
        }

        this.keys = newHashTable.getKeys();
        this.values = newHashTable.getValues();
        this.capacity = newHashTable.getCapacity();
    }

    public Value get(Key key) {
        if (key == null) {
            return null;
        }

        int index = hash(key);

        // linear probing
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % this.capacity;
        }

        return null;
    }

    public Key[] getKeys() {
        return keys;
    }

    public void setKeys(Key[] keys) {
        this.keys = keys;
    }

    public Value[] getValues() {
        return values;
    }

    public void setValues(Value[] values) {
        this.values = values;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private int hash(Key key) {
        //index out of bound exception could happen without 'abs'
        return Math.abs(key.hashCode()) % this.capacity;
    }
}
