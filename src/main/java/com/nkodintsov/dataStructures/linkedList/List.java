package com.nkodintsov.dataStructures.linkedList;

/**
 * Created by nikolay.odintsov on 28.05.18.
 */
public interface List<T> {
    void insert(T data);

    void remove(T data);

    void traverseList();

    int size();
}
