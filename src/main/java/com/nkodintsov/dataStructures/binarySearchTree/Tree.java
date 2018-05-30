package com.nkodintsov.dataStructures.binarySearchTree;

/**
 * Created by nikolay.odintsov on 30.05.18.
 */
public interface Tree<T> {
    void traversal();

    void insert(T data);

    void delete(T data);

    T getMaxValue();

    T getMinValue();
}
