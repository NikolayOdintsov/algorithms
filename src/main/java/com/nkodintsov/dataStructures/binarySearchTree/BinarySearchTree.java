package com.nkodintsov.dataStructures.binarySearchTree;

/**
 * Created by nikolay.odintsov on 30.05.18.
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
        } else {
            insertNode(data, root);
        }
    }

    @Override
    public T getMinValue() {
        if (this.root == null) return null;

        return getMin(this.root);
    }

    @Override
    public T getMaxValue() {
        if (this.root == null) return null;

        return getMax(this.root);
    }


    //O(lgN)
    @Override
    public void traversal() {
        if (this.root != null) {
            inOrderTraversal(this.root);
        }
    }

    @Override
    public void delete(T data) {
        if (this.root != null) {
            this.root = delete(this.root, data);
        }

    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) return node;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(node.getLeftChild(), data));

        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(node.getRightChild(), data));

        } else {
            //we found the node to remove

            //node is a leaf case:
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node..");
                return null;
            }

            //node has only one child case:
            if (node.getLeftChild() == null) {
                System.out.println("Removing the right child..");
                Node<T> tempNode = node.getRightChild();
                node = null;

                return tempNode;
            } else if (node.getRightChild() == null) {
                System.out.println("Removing the left child..");
                Node<T> tempNode = node.getLeftChild();
                node = null;

                return tempNode;
            }

            //the node with two children case:
            System.out.println("Removing item with two children..");
            Node<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData());
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));

        }

        return node;

    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        System.out.println("Predecessor is: " + node);
        return node;
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node + " --> ");

        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    private void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }

        return node.getData();
    }
}
