package com.nkodintsov.dataStructures.splayTree;

/**
 * Created by nikolay.odintsov on 04.06.18.
 */
public class App {
    public static void main(String[] args) {
        Tree<Integer> splayTree = new SplayTree<>();
        splayTree.insert(10);
        splayTree.insert(-5);
        splayTree.insert(0);
        splayTree.insert(20);
        splayTree.insert(30);

        //O(1)
        ((SplayTree) splayTree).printRoot();

        System.out.println(splayTree.getMax());
        System.out.println(splayTree.getMin());

        splayTree.inOrderTraversal();

        ((SplayTree) splayTree).find(0);
        System.out.println();
        ((SplayTree) splayTree).printRoot();

    }
}
