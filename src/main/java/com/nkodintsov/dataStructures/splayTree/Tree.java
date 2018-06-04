package com.nkodintsov.dataStructures.splayTree;

/**
 * Created by nikolay.odintsov on 04.06.18.
 */
public interface Tree<T extends Comparable<T>> {
    void insert(T data);

    Node<T> find(T data);

    T getMin();

    T getMax();

    void inOrderTraversal();
}
