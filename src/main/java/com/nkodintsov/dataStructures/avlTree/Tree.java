package com.nkodintsov.dataStructures.avlTree;

/**
 * Created by nikolay.odintsov on 31.05.18.
 */
public interface Tree<T> {
    void insert(T data);

    void traverse();

    void delete(T data);
}
