package com.nkodintsov.dataStructures.redBlackTree;

/**
 * Created by nikolay.odintsov on 04.06.18.
 */
public class App {
    public static void main(String[] args) {
        Tree redBlackTree = new RedBlackTree();
        redBlackTree.insert(10);
        redBlackTree.insert(20);
        redBlackTree.insert(30);

        Tree redBlackTree2 = new RedBlackTree();
        redBlackTree2.insert(10);
        redBlackTree2.insert(5);
        redBlackTree2.insert(1);

        Tree redBlackTree3 = new RedBlackTree();
        redBlackTree3.insert(10);
        redBlackTree3.insert(5);
        redBlackTree3.insert(6);

    }
}
