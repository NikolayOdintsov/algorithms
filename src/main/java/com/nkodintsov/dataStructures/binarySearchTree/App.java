package com.nkodintsov.dataStructures.binarySearchTree;

/**
 * Created by nikolay.odintsov on 30.05.18.
 */
public class App {

    public static void main(String[] args) {
        Tree<Integer> bst = new BinarySearchTree<>();
        bst.insert(-1);
        bst.insert(1);
        bst.insert(0);
        bst.insert(1000);
        bst.insert(-22);

        System.out.println(bst.getMaxValue());
        System.out.println(bst.getMinValue());

        bst.traversal();


        System.out.println();


        Tree<String> bstStr = new BinarySearchTree<>();
        bstStr.insert("Adam");
        bstStr.insert("Joe");
        bstStr.insert("Michael");
        bstStr.insert("Kevin");
        bstStr.insert("Staff");
        bstStr.insert("Daniel");

        bstStr.traversal();


        System.out.println();


        Tree<Integer> bstDelete = new BinarySearchTree<>();
        bstDelete.insert(10);
        bstDelete.insert(5);
        bstDelete.insert(15);
        bstDelete.insert(3);
        bstDelete.insert(7);

        bstDelete.traversal();
        System.out.println();

        bstDelete.delete(10);
        bstDelete.traversal();


        System.out.println();

        Tree<Person> personTree = new BinarySearchTree<>();
        personTree.insert(new Person("Adam", 27));
        personTree.insert(new Person("Kevin", 13));
        personTree.insert(new Person("Joe", 67));
        personTree.insert(new Person("Michael", 2));
        personTree.insert(new Person("Smith", 11));

        personTree.traversal();

    }
}
