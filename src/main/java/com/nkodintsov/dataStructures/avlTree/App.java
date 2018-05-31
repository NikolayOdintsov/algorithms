package com.nkodintsov.dataStructures.avlTree;

/**
 * Created by nikolay.odintsov on 31.05.18.
 */
public class App {
    public static void main(String[] args) {
        Tree<Integer> avlTreeDRight = new AvlTree<>();
        avlTreeDRight.insert(1);
        avlTreeDRight.insert(2);
        avlTreeDRight.insert(3);

        avlTreeDRight.traverse();


        Tree<Integer> avlTreeDLeft = new AvlTree<>();
        avlTreeDLeft.insert(3);
        avlTreeDLeft.insert(2);
        avlTreeDLeft.insert(1);

        avlTreeDLeft.traverse();


        Tree<Integer> avlTreeLeftRight = new AvlTree<>();
        avlTreeLeftRight.insert(3);
        avlTreeLeftRight.insert(1);
        avlTreeLeftRight.insert(2);

        avlTreeLeftRight.traverse();


        Tree<Integer> avlTreeRightLeft = new AvlTree<>();
        avlTreeRightLeft.insert(3);
        avlTreeRightLeft.insert(5);
        avlTreeRightLeft.insert(4);

        avlTreeRightLeft.traverse();


        Tree<Integer> avlTreeDeletion = new AvlTree<>();
        avlTreeDeletion.insert(10);
        avlTreeDeletion.insert(15);
        avlTreeDeletion.insert(5);
        avlTreeDeletion.insert(6);

        avlTreeDeletion.delete(5);

        avlTreeDeletion.traverse();



        Tree<String> stringTree = new AvlTree<>();
        stringTree.insert("a");
        stringTree.insert("b");
        stringTree.insert("c");

        stringTree.traverse();

    }
}
